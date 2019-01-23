package com.Action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.impl.OrderItemsDaoimpl;
import com.model.Cart;
import com.model.CartItem;
import com.model.OrderItems;
import com.model.Product;
import com.model.ProductOrder;
import com.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.OrderItemsServiceimpl;
import com.utils.PageBean;

public class OrderItemsAction extends ActionSupport implements
		ModelDriven<OrderItems> {
	
	private OrderItems orderItems = new OrderItems();
	private ProductOrder productOrder = new ProductOrder();
	
	private OrderItemsServiceimpl orderItemsServiceimpl;
	
	// 接受page参数******************
	private Integer page;
	
	public void setPage(Integer page) {
		this.page = page;
	}// end
	
	public OrderItemsServiceimpl getOrderItemsServiceimpl() {
		return orderItemsServiceimpl;
	}
	
	public void setOrderItemsServiceimpl(
			OrderItemsServiceimpl orderItemsServiceimpl) {
		this.orderItemsServiceimpl = orderItemsServiceimpl;
	}
	
	@Override
	public OrderItems getModel() {
		// TODO Auto-generated method stub
		return orderItems;
	}
	
	public OrderItems getOrderItems() {
		return orderItems;
	}
	
	public void setOrderItems(OrderItems orderItems) {
		this.orderItems = orderItems;
	}
	
	public ProductOrder getProductOrder() {
		return productOrder;
	}
	
	public void setProductOrder(ProductOrder productOrder) {
		this.productOrder = productOrder;
	}
	
	// *********************************
	// public String findAll() {
	// List<OrderItems> list = orderItemsServiceimpl.findAll();
	// Map<String, String> map= new HashMap<String, String>();
	// ActionContext actionContext = ServletActionContext.getContext();
	//
	// actionContext.put("list", list);
	// return "success";
	// }
	public String findAll() {
		PageBean<ProductOrder> pageBean = orderItemsServiceimpl
				.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "success";
	}
	
	// ����tid����
	
	public String findById() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer tid = Integer.parseInt(request.getParameter("tid"));
		orderItems = orderItemsServiceimpl.findById(tid);
		
		ActionContext actionContext = ServletActionContext.getContext();
		
		actionContext.put("tb", orderItems);
		
		return "update1";
	}
	
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int tid = Integer.parseInt(request.getParameter("tid"));
		Double subtotal = Double.parseDouble(request.getParameter("subtotal"));
		int count = Integer.parseInt(request.getParameter("count"));
		orderItems = orderItemsServiceimpl.findById(tid);
		orderItems.setCount(count);
		orderItems.setSubtotal(subtotal);
		orderItemsServiceimpl.update(orderItems);
		int oid = Integer.parseInt(request.getParameter("oid"));
		Double total = Double.parseDouble(request.getParameter("total"));
		int state = Integer.parseInt(request.getParameter("state"));
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		productOrder = orderItemsServiceimpl.findOid(ProductOrder.class, oid);
		productOrder.setTotal(total);
		productOrder.setState(state);
		productOrder.setUsername(username);
		productOrder.setPhone(phone);
		productOrder.setAddr(addr);
		orderItemsServiceimpl.update(productOrder);
		return "success";
		
	}
	
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int oid = Integer.parseInt(request.getParameter("oid"));
		Double subtotal = Double.parseDouble(request.getParameter("subtotal"));
		int count = Integer.parseInt(request.getParameter("count"));
		productOrder = orderItemsServiceimpl.findOid(ProductOrder.class, oid);
		orderItems.setProductOrder(productOrder);
		orderItems.setCount(count);
		orderItems.setSubtotal(subtotal);
		orderItemsServiceimpl.sava(orderItems);
		/* int oid=Integer.parseInt(request.getParameter("oid")); */
		Double total = Double.parseDouble(request.getParameter("total"));
		int state = Integer.parseInt(request.getParameter("state"));
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		/*
		 * System.out.println(desName + price + size + sumnum + image +
		 * color);
		 */
		productOrder.setOid(oid);
		productOrder.setTotal(total);
		productOrder.setState(state);
		productOrder.setUsername(username);
		productOrder.setPhone(phone);
		productOrder.setAddr(addr);
		orderItemsServiceimpl.sava(productOrder);
		
		return "success";
		
	}
	
	// 生成订单的执行的方法:
	public String saveOrder() {
		
		// 调用Service完成数据库插入的操作:
		// Order order = new Order();
		// 设置订单的总金额:订单的总金额应该是购物车中总金额:
		// 购物车在session中,从session总获得购物车信息.
		Cart cart = (Cart) ServletActionContext.getRequest().getSession()
				.getAttribute("cart");
		if (cart == null) {
			this.addActionMessage("亲!您还没有购物!");
			return "msg";
		}
		productOrder.setTotal(cart.getTotal());
		// 设置订单的状态
		productOrder.setState(1);// 1:未付款.
		// 设置订单关联的客户:
		User existUser = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		if (existUser == null) {
			this.addActionMessage("亲!您还没有登录!");
			return "msg";
		}
		productOrder.setUser(existUser);
		// 设置订单项集合:
		for (CartItem cartItem : cart.getCartItems()) {
			// 订单项的信息从购物项获得的.
			OrderItems orderItem = new OrderItems();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setProductOrder(productOrder);
			productOrder.getOrderItems().add(orderItem);
			
		}
		orderItemsServiceimpl.sava(productOrder);
		// 清空购物车:
		cart.clearCart();
		
		// 页面需要回显订单信息:
		// 使用模型驱动了 所有可以不使用值栈保存了
		// ActionContext.getContext().getValueStack().set("order", order);
		
		return "saveOrder";
	}
	
	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int tid = Integer.parseInt(request.getParameter("tid"));
		/* OrderItems t = orderItemsServiceimpl.findById(tid); */
		/* productOrder=t.getProductOrder(); */
		orderItemsServiceimpl.delete(orderItems);
		return "success";
	}
}
