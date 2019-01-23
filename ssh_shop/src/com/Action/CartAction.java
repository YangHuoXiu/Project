package com.Action;

import org.apache.struts2.ServletActionContext;

import com.model.Cart;
import com.model.CartItem;
import com.model.Product;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ProductServiceimpl;

/**
 * 购物车Action
 * 
 * @author 传智.郭嘉
 * 
 */
public class CartAction extends ActionSupport {
	// 接收pid
	private Integer pid;
	// 接收数量count
	private Integer count;
	// 注入商品的Service
	private ProductServiceimpl productServiceimpl;
	

	public ProductServiceimpl getProductServiceimpl() {
		return productServiceimpl;
	}

	public void setProductServiceimpl(ProductServiceimpl productServiceimpl) {
		this.productServiceimpl = productServiceimpl;
	}

	public Integer getPid() {
		return pid;
	}

	public Integer getCount() {
		return count;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	// 将购物项添加到购物车:执行的方法
	public String addCart() {
		System.out.println("添加到购物车");
		// 封装一个CartItem对象.
		CartItem cartItem = new CartItem();
		// 设置数量:
		cartItem.setCount(count);
		// 根据pid进行查询商品:
		System.out.println(pid+"dlsjlfsjld");
		
		Product product =productServiceimpl.findByPid(Product.class, pid);
		// 设置商品:
		cartItem.setProduct(product);
		// 将购物项添加到购物车.
		// 购物车应该存在session中.
		Cart cart = getCart();
		cart.addCart(cartItem);

		return "addCart";
	}

	// 清空购物车的执行的方法:
	public String clearCart(){
		// 获得购物车对象.
		Cart cart = getCart();
		// 调用购物车中清空方法.
		cart.clearCart();
		return "clearCart";
	}
	
	// 从购物车中移除购物项的方法:
	public String removeCart(){
		// 获得购物车对象
		Cart cart = getCart();
		// 调用购物车中移除的方法:
		cart.removeCart(pid);
		// 返回页面:
		return "removeCart";
	}
	
	// 我的购物车:执行的方法
	public String myCart(){
		return "myCart";
	}
	
	/**
	 * 获得购物车的方法:从session中获得购物车.
	 * @return
	 */
	private Cart getCart() {
		Cart cart = (Cart) ServletActionContext.getRequest().getSession()
				.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			ServletActionContext.getRequest().getSession()
					.setAttribute("cart", cart);
		}
		return cart;
	}
}
