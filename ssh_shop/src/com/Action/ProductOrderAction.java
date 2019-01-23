package com.Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.model.Cart;
import com.model.CartItem;
import com.model.OrderItems;
import com.model.Product;
import com.model.ProductOrder;
import com.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.ProductOrderservice;
import com.service.ProductOrderserviceimpl;
import com.utils.PageBean;
import com.utils.PaymentUtil;

public class ProductOrderAction extends ActionSupport implements
ModelDriven<ProductOrder>{
private ProductOrder productOrder=new ProductOrder();
private ProductOrderserviceimpl productOrderserviceimpl;

	public ProductOrder getProductOrder() {
	return productOrder;
}

public void setProductOrder(ProductOrder productOrder) {
	this.productOrder = productOrder;
}


//生成订单的执行的方法:
		public ProductOrderserviceimpl getProductOrderserviceimpl() {
	return productOrderserviceimpl;
}

public void setProductOrderserviceimpl(
		ProductOrderserviceimpl productOrderserviceimpl) {
	this.productOrderserviceimpl = productOrderserviceimpl;
}
//接收支付通道编码:
	private String pd_FrpId;

	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}
	// 接收付款成功后的参数:
	private String r3_Amt;
	private String r6_Order;
	
	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}

	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}

	// 接收page
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}


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
			productOrder.setUsername(existUser.getUsername());
			productOrder.setPhone(existUser.getUserInfor().getPhone());
			productOrder.setAddr(existUser.getUserInfor().getAddress());
			
			System.out.println("sldjsldfjslfjls");
			
			// 设置订单项集合:
			for (CartItem cartItem : cart.getCartItems()) {
				// 订单项的信息从购物项获得的.
				OrderItems orderItem=new OrderItems();
				System.out.println("jjjjjjjjjjjjjjjjj");
				orderItem.setCount(cartItem.getCount());
				orderItem.setSubtotal(cartItem.getSubtotal());
				orderItem.setProduct(cartItem.getProduct());
				orderItem.setProductOrder(productOrder);
				productOrder.getOrderItems().add(orderItem);

			}
			productOrderserviceimpl.save(productOrder);
			// 清空购物车:
			cart.clearCart();
			// 页面需要回显订单信息:
			// 使用模型驱动了 所有可以不使用值栈保存了
			// ActionContext.getContext().getValueStack().set("order", order);
			return "saveOrder";
		}
	
	
	/*// 查询我的订单:
		public String findByUid() {
			// 获得用户的id.
			User existUser = (User) ServletActionContext.getRequest().getSession()
					.getAttribute("existUser");
			// 获得用户的id
			System.out.println(existUser.getUid()+"**************");
			Integer uid = existUser.getUid();
			// 根据用户的id查询订单:
			PageBean<ProductOrder> pageBean =productOrderserviceimpl.findByUid(uid, page);   
			// 将PageBean数据带到页面上.
			ActionContext.getContext().getValueStack().set("pageBean", pageBean);
			return "findByUid";
		}*/
		
		// 根据订单id查询订单:
		public String findByOid() {
			productOrder=productOrderserviceimpl.findByOid(productOrder.getOid());  
			return "findByOid";
		}
		
		public String findByUid(){
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
			System.out.println(user.getUid()+"MICHAELJACKSON");
			List<ProductOrder> list=productOrderserviceimpl.findByUid(user.getUid());
			request.getSession().setAttribute("order",list);
			
			return "findByUid";
			
		}
		
		
		
		// 为订单付款:
		public String payOrder() throws IOException {
			// 1.修改数据:
			ProductOrder currOrder =productOrderserviceimpl.findByOid(productOrder.getOid());
			currOrder.setAddr(productOrder.getAddr());
			currOrder.setUsername(productOrder.getUsername());
			currOrder.setPhone(productOrder.getPhone());
			// 修改订单
			productOrderserviceimpl.update(currOrder);
			// 2.完成付款:
			// 付款需要的参数:
			String p0_Cmd = "Buy"; // 业务类型:
			String p1_MerId = "10001126856";// 商户编号:
			String p2_Order =productOrder.getOid().toString();// 订单编号:
			String p3_Amt = "0.01"; // 付款金额:
			String p4_Cur = "CNY"; // 交易币种:
			String p5_Pid = ""; // 商品名称:
			String p6_Pcat = ""; // 商品种类:
			String p7_Pdesc = ""; // 商品描述:
			String p8_Url = "http://192.168.36.69:8080/shop/order_callBack.action"; // 商户接收支付成功数据的地址:
			String p9_SAF = ""; // 送货地址:
			String pa_MP = ""; // 商户扩展信息:
			String pd_FrpId = this.pd_FrpId;// 支付通道编码:
			String pr_NeedResponse = "1"; // 应答机制:
			String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 秘钥
			String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
					p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
					pd_FrpId, pr_NeedResponse, keyValue); // hmac
			// 向易宝发送请求:
			StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
			sb.append("p0_Cmd=").append(p0_Cmd).append("&");
			sb.append("p1_MerId=").append(p1_MerId).append("&");
			sb.append("p2_Order=").append(p2_Order).append("&");
			sb.append("p3_Amt=").append(p3_Amt).append("&");
			sb.append("p4_Cur=").append(p4_Cur).append("&");
			sb.append("p5_Pid=").append(p5_Pid).append("&");
			sb.append("p6_Pcat=").append(p6_Pcat).append("&");
			sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
			sb.append("p8_Url=").append(p8_Url).append("&");
			sb.append("p9_SAF=").append(p9_SAF).append("&");
			sb.append("pa_MP=").append(pa_MP).append("&");
			sb.append("pd_FrpId=").append(pd_FrpId).append("&");
			sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
			sb.append("hmac=").append(hmac);
			
			// 重定向:向易宝出发:
			ServletActionContext.getResponse().sendRedirect(sb.toString());
			return NONE;
		}

		// 付款成功后跳转回来的路径:
		public String callBack(){
			// 修改订单的状态:
			ProductOrder currOrder =productOrderserviceimpl.findByOid(Integer.parseInt(r6_Order));
			// 修改订单状态为2:已经付款:
			currOrder.setState(2);
			productOrderserviceimpl.update(currOrder);
			this.addActionMessage("支付成功!订单编号为: "+r6_Order +" 付款金额为: "+r3_Amt);
			return "msg";
		}
		
		// 修改订单的状态:
		public String updateState(){
			ProductOrder currOrder =productOrderserviceimpl.findByOid(productOrder.getOid());
			currOrder.setState(4);
			productOrderserviceimpl.update(currOrder);
			return "updateStateSuccess";
		}
		
	@Override
	public ProductOrder getModel() {
		// TODO Auto-generated method stub
		return productOrder;
	}

}
