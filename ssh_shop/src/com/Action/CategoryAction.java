package com.Action;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.model.Category;
import com.model.User;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CategoryServiceimpl;
import com.utils.PageBean;

public class CategoryAction extends ActionSupport implements
		ModelDriven<Category> {
	private Category category = new Category();
	private CategoryServiceimpl categoryServiceimpl;
	
	// 接受page参数******************
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}//end
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public CategoryServiceimpl getCategoryServiceimpl() {
		return categoryServiceimpl;
	}

	public void setCategoryServiceimpl(CategoryServiceimpl categoryServiceimpl) {
		this.categoryServiceimpl = categoryServiceimpl;
	}
	
	public Integer getPage() {
		return page;
	}

	// 展示所有的商品*******************
	public String findAllCategory() {
		PageBean<Category> pageBean = categoryServiceimpl.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAllSuccess";
	}
	
	@Override
	public Category getModel() {
		return category;
	}
	
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int cid = Integer.parseInt(request.getParameter("cid"));
		String cname = request.getParameter("cname");
		category.setCid(cid);
		category.setCname(cname);
		categoryServiceimpl.update(category);
		return "updateSuccess";
	}
	
	public String edit(){
		category = categoryServiceimpl.findByCid(category.getCid());
		return "editSuccess";
	}
	
	public String categoryDelete(){
		Category existCategory = categoryServiceimpl.findByCid(category.getCid());
		categoryServiceimpl.delete(existCategory);
		return "deleteSuccess";
	}
	
	// 保存一级分类的方法
	public String save(){
		// 调用Service完成保存一级分类
		categoryServiceimpl.save(category);
		// 进行页面跳转:
		return "saveSuccess";
	}
	
}
