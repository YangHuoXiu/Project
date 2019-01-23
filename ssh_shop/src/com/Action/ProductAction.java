package com.Action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.model.Category;
import com.model.Product;
import com.model.ProductInfor;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.ProductServiceimpl;
import com.utils.PageBean;

public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {
	private Product product = new Product();
	private ProductServiceimpl productServiceimpl;
	private ProductInfor productInfor = new ProductInfor();
	
	// 接受page参数******************
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}//end
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public ProductServiceimpl getProductServiceimpl() {
		return productServiceimpl;
	}
	
	public void setProductServiceimpl(ProductServiceimpl productServiceimpl) {
		this.productServiceimpl = productServiceimpl;
	}
	
	public ProductInfor getProductInfor() {
		return productInfor;
	}
	
	public void setProductInfor(ProductInfor productInfor) {
		this.productInfor = productInfor;
	}
	
	// 文件上传需要的三个属性:****************
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	
	// 后台系统展示所有的商品*******************
	public String adminFindAllProduct() {
		PageBean<Product> pageBean = productServiceimpl.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "adminsuccess";
	}
	//前台系统展示所有商品
	public String findAllProduct() {
		System.out.println("dlfjlsdjlsfdkls");
		List<Product> list = productServiceimpl.findAllProduct("from Product");
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("list", list);
		System.out.println(list+"11111");
		return "success";
	}
	
	public String findByPid() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int pid = Integer.parseInt(request.getParameter("pid"));
		System.out.println(pid+"dlfjdlfjkdl");
		Product p = productServiceimpl.findByPid(Product.class, pid);
		request.getSession().setAttribute("pid", p.getPid());
		request.getSession().setAttribute("pname", p.getPname());
		request.getSession().setAttribute("cid", p.getCategory().getCid());
		/*request.getSession().setAttribute("cname", p.getCategory().getCname());*/
		request.getSession().setAttribute("desid",
				p.getProductInfor().getDesid());
		request.getSession().setAttribute("desName",
				p.getProductInfor().getDesName());
		request.getSession().setAttribute("price",
				p.getProductInfor().getPrice());
		request.getSession()
				.setAttribute("size", p.getProductInfor().getSize());
		request.getSession().setAttribute("sumnum",
				p.getProductInfor().getSumnum());
		request.getSession().setAttribute("image",
				p.getProductInfor().getImage());
		request.getSession().setAttribute("color",
				p.getProductInfor().getColor());
		return "success";
	}
	
	// 级联删除容易出错********************
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("pname");
		int desid = Integer.parseInt(request.getParameter("desid"));
		String desName = request.getParameter("desName");
		int price = Integer.parseInt(request.getParameter("price"));
		int size = Integer.parseInt(request.getParameter("size"));
		int sumnum = Integer.parseInt(request.getParameter("sumnum"));
		String image = request.getParameter("image");
		String color = request.getParameter("color");
		ProductInfor infor = productServiceimpl.findByid(ProductInfor.class,
				pid);
		infor.setDesid(desid);
		infor.setDesName(desName);
		infor.setPrice(price);
		infor.setSize(size);
		infor.setSumnum(sumnum);
		infor.setImage(image);
		infor.setColor(color);
		infor.setProduct(product);
		System.out.println(desid+desName+price+size);
		productServiceimpl.update(infor);
		int cid = Integer.parseInt(request.getParameter("cid"));
//		System.out.println(cid+"michael");
//		String cname = request.getParameter("cname");
		Category c = productServiceimpl.findByCid(Category.class, cid);
//		c.setCid(cid);
//		c.setCname(cname);
		System.out.println(c.getCname()+c.getCid()+",aldfaklsd");
		Product p = productServiceimpl.findByPid(Product.class, pid);
		p.setCategory(c);
		productServiceimpl.update(p);
		return "success";		
	}
//	public String update() {
//		System.out.println("******************action1");
//		HttpServletRequest request = ServletActionContext.getRequest();
//		int pid = Integer.parseInt(request.getParameter("pid"));
//		String pname = request.getParameter("pname");
//		product.setPid(pid);
//		product.setPname(pname);
//		productInfor.setProduct(product);
//		int desid = Integer.parseInt(request.getParameter("desid"));
//		String desName = request.getParameter("desName");
//		int price = Integer.parseInt(request.getParameter("price"));
//		int size = Integer.parseInt(request.getParameter("size"));
//		int sumnum = Integer.parseInt(request.getParameter("sumnum"));
//		String image = request.getParameter("image");
//		String color = request.getParameter("color");
//		productInfor.setDesid(desid);
//		productInfor.setDesName(desName);
//		productInfor.setPrice(price);
//		productInfor.setSize(size);
//		productInfor.setSumnum(sumnum);
//		productInfor.setImage(image);
//		productInfor.setColor(color);
//		productServiceimpl.update(productInfor);
//		System.out.println("******************action");
//		return "success";		
//	}
	
	// 删除商品*********************
	public String delete() {
//		HttpServletRequest request = ServletActionContext.getRequest();
//		int pid = Integer.parseInt(request.getParameter("pid"));
//		Product p = productServiceimpl.findByPid(Product.class, pid);
		Product p = productServiceimpl.findByPid(product.getPid());
		System.out.println(p.getPid()+"*************");
		productInfor = p.getProductInfor();
		productServiceimpl.delete(productInfor);
//		productServiceimpl.delete(p);
		return "success";
	}
	
	//***********************************
	public String save() throws IOException {
//		HttpServletRequest request = ServletActionContext.getRequest();
//		int cid = Integer.parseInt(request.getParameter("cid"));
//		Category c = productServiceimpl.findByCid(Category.class, cid);
//		product.setCategory(c);
//		productServiceimpl.sava(product);
//		productInfor.setProduct(product);
//		String desName = request.getParameter("desName");
//		int price = Integer.parseInt(request.getParameter("price"));
//		int size = Integer.parseInt(request.getParameter("size"));
//		int sumnum = Integer.parseInt(request.getParameter("sumnum"));
//		String image = request.getParameter("image");
//		String color = request.getParameter("color");
//		System.out.println(desName + price + size + sumnum + image + color);
//		/* productInfor.setDesid(desid); */
//		productInfor.setDesName(desName);
//		productInfor.setPrice(price);
//		productInfor.setSumnum(sumnum);
//		productInfor.setImage(image);
//		productInfor.setSize(size);
//		productInfor.setColor(color);
//		productServiceimpl.sava(productInfor);
		// 将提交的数据添加到数据库中.
		// product.setImage(image);
//		if(upload != null){
//			// 将商品图片上传到服务器上.
//			// 获得上传图片的服务器端路径.
//			String path = ServletActionContext.getServletContext().getRealPath(
//					"/products");
//			// 创建文件类型对象:
//			File diskFile = new File(path + "//" + uploadFileName);
//			// 文件上传:
//			FileUtils.copyFile(upload, diskFile);
//			productInfor.setImage("products/" + uploadFileName);
//		}
		productServiceimpl.sava(product);
		productServiceimpl.sava(productInfor);
		return "success";		
	}
	
	//**********************
	/*public String edit(){
		product = productServiceimpl.findByPid(product.getPid());
		// 查询所有二级分类
		System.out.println("****************edit");
		return "success";
	}*/
	
	//模糊查询
	public String fuzzySearch(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String str = request.getParameter("str");
		List<Product> fuzzy = productServiceimpl.fuzzySearch(str);
		request.getSession().setAttribute("fuzzy", fuzzy);
		return "fuzzySearch";
	}
	
	

	
	@Override
	public Product getModel() {
		return product;
	}
	
}
