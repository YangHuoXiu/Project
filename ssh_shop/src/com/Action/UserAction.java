package com.Action;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import org.apache.struts2.ServletActionContext;









import com.model.ProductOrder;
import com.model.User;
import com.model.UserInfor;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.UserService;
import com.service.UserServiceimpl;
import com.utils.PageBean;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	private UserInfor userInfor = new UserInfor();
	private ProductOrder order = new ProductOrder();
	
	private UserServiceimpl userServiceimpl;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public UserInfor getUserInfor() {
		return userInfor;
	}
	
	public void setUserInfor(UserInfor userInfor) {
		this.userInfor = userInfor;
	}
	
	// 接收验证码:****************************begin
	private String checkcode;
	
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	// end
	
	public UserServiceimpl getUserServiceimpl() {
		return userServiceimpl;
	}
	
	public void setUserServiceimpl(UserServiceimpl userServiceimpl) {
		this.userServiceimpl = userServiceimpl;
	}
	
	// 查询用户表的信息
	public String findUserAll() {
		List<User> list = userServiceimpl.findAllUser("from User");
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("list", list);
		return "success";
	}
	
	/*
	 * public String findAllOrderItems(){ List<OrderItems> list =
	 * userServiceimpl.findAllOrderItems("from OrderItems");
	 * HttpServletRequest request = ServletActionContext.getRequest();
	 * request.getSession().setAttribute("list", list); return "success"; }
	 */
	
	// 级联删除(cascade="delete")
	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int uid = Integer.parseInt(request.getParameter("uid"));
		User t = userServiceimpl.findById(User.class, uid);
		userInfor = t.getUserInfor();
		/*
		 * Set<ProductOrder> order =t.getProductorder(); for (ProductOrder
		 * order2 : order){ order2.setUser(null); }
		 */
		userServiceimpl.delete(userInfor);
		return "success";
	}
	
	public String findById() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		User t = userServiceimpl.findById(User.class, uid);
		request.getSession().setAttribute("uid", t.getUid());
		request.getSession().setAttribute("username", t.getUsername());
		request.getSession().setAttribute("password", t.getPassword());
		request.getSession().setAttribute("uinforid",
				t.getUserInfor().getUinforid());
		request.getSession().setAttribute("isadmin",
				t.getUserInfor().getIsadmin());
		request.getSession().setAttribute("address",
				t.getUserInfor().getAddress());
		request.getSession().setAttribute("phone", t.getUserInfor().getPhone());
		return "success";
	}
	
	// 级联更新******************************
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int uid = Integer.parseInt(request.getParameter("uid"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		user.setUid(uid);
		user.setUsername(username);
		user.setPassword(password);
		userInfor.setUser(user);
		int uinforid = Integer.parseInt(request.getParameter("uinforid"));
		int isadmin = Integer.parseInt(request.getParameter("isadmin"));
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		userInfor.setAddress(address);
		userInfor.setIsadmin(isadmin);
		userInfor.setPhone(phone);
		userInfor.setUinforid(uinforid);
		userServiceimpl.update(userInfor);
		System.out.println(userInfor.getPhone()+"************");
//		return "success";
		return "updateSuccess";
	}
	
	// 登录****************************begin
//	public String UserLogin() throws IOException {
//		HttpServletRequest request = ServletActionContext.getRequest();
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		// 验证登录的用户名或密码是否正确
//		int i = userServiceimpl.UserLogin(username, password);
//		System.out.println(i);
//		if (i == 0) {
//			JOptionPane.showMessageDialog(null, "登录失败！用户名或密码错误，请重新登录！", "请注意",
//					JOptionPane.ERROR_MESSAGE);
//			return "input";
//		} else {
//			// this.addActionError("登录失败！用户名或密码错误，请重新登录！");
//			return "success";
//		}
//	}
	public String UserLogin() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 验证登录的用户名或密码是否正确
		user = userServiceimpl.UserLogin(username, password);
		if (user == null) {
			JOptionPane.showMessageDialog(null, "登录失败！用户名或密码错误，请重新登录！", "请注意",
					JOptionPane.ERROR_MESSAGE);
			return "input";
		} else {
			request.getSession().setAttribute("uid",user.getUid());
			request.getSession().setAttribute("uinforid",user.getUserInfor().getUinforid());
			request.getSession().setAttribute("isadmin",user.getUserInfor().getIsadmin());
			request.getSession().setAttribute("username",user.getUsername());
			request.getSession().setAttribute("password",user.getPassword());
			request.getSession().setAttribute("address",user.getUserInfor().getAddress());
			request.getSession().setAttribute("phone",user.getUserInfor().getPhone());
			request.getSession().setAttribute("existUser",user);
			return "success";
		}
	}
	
	public String AdminLogin() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 验证登录的用户名或密码是否正确
		user = userServiceimpl.AdminLogin(username, password);
		if (user == null) {
			JOptionPane.showMessageDialog(null, "登录失败！用户名或密码错误，请重新登录！", "请注意",
					JOptionPane.ERROR_MESSAGE);
			return "input";
		} else {
			request.getSession().setAttribute("uid",user.getUid());
			request.getSession().setAttribute("uinforid",user.getUserInfor().getUinforid());
			request.getSession().setAttribute("isadmin",user.getUserInfor().getIsadmin());
			request.getSession().setAttribute("username",user.getUsername());
			request.getSession().setAttribute("password",user.getPassword());
			request.getSession().setAttribute("address",user.getUserInfor().getAddress());
			request.getSession().setAttribute("phone",user.getUserInfor().getPhone());
			return "success";
		}
	}
	
	// end
	
	// 注册****************************begin*
	public String register() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String checkcode1 = (String) ServletActionContext.getRequest()
				.getSession().getAttribute("checkcode");
		String username = request.getParameter("username");
		// 验证用户名是否存在，若提示存在的情况下点击注册按钮，则会弹出报错窗口，并强制刷新页面，阻止对方注册
		int i = userServiceimpl.findByUsername(username);
		if (i == 0) {
			JOptionPane.showMessageDialog(null, "注册失败！用户名已存在，请重新注册！", "请注意",
					JOptionPane.ERROR_MESSAGE);
			return "input";
		} else {
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			int isadmin = Integer.parseInt(request.getParameter("isadmin"));
			// 用正则表达式验证手机号格式
			Pattern p = Pattern
					.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
			Matcher m = p.matcher(phone);
			System.out.println(m.matches() + "---");
			if (m.matches() == false) {
				JOptionPane.showMessageDialog(null, "手机号格式错误！", "请注意",
						JOptionPane.ERROR_MESSAGE);
				return "input";
			} else {
				userInfor.setAddress(address);
				userInfor.setPhone(phone);
				userInfor.setIsadmin(isadmin);
				userInfor.setUser(user);
				if (!checkcode.equalsIgnoreCase(checkcode1)) {
					JOptionPane.showMessageDialog(null, "验证码错误！", "请注意",
							JOptionPane.ERROR_MESSAGE);
					return "input";
				} else {
					userServiceimpl.register(userInfor);
					return "success";
				}
				
			}
		}
	}
	// end
	
	// 异步验证用户名是否存在（仅提示，不阻止对方进行下一步操作）****************************begin*
	public String findByName() throws IOException {
		int i = userServiceimpl.findByUsername(user.getUsername());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if (i == 0) {
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		} else {
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return NONE;
	}
	//end
	
							//****************************begin
	// 接受page参数
		private Integer page;

		public void setPage(Integer page) {
			this.page = page;
		}

		// 后台查询所有用户的方法带分页:
		public String findAll(){
			PageBean<User> pageBean = userServiceimpl.findByPage(page);
			ActionContext.getContext().getValueStack().set("pageBean", pageBean);
			return "findAllUser";
		}
		
		// 后台用户的删除
		public String adminDelete(){
			User existUser = userServiceimpl.findByUid(user.getUid());
			System.out.println(existUser.getUid()+"***************");
			userInfor=existUser.getUserInfor();
//			userServiceimpl.delete(existUser);
			userServiceimpl.delete(userInfor);//外键关联，不能直接删uid
			return "deleteSuccess";
		}
		
		// 后台用户的编辑
		public String edit(){
			user = userServiceimpl.findByUid(user.getUid());
			return "editSuccess";
		}
		
		//用户退出
		public String quit(){
			// 销毁session
			ServletActionContext.getRequest().getSession().invalidate();
			return "quit";
		}
		
		//模糊查询
//		public String fuzzySearch(){
//			HttpServletRequest request = ServletActionContext.getRequest();
//			String str = request.getParameter("str");
//			System.out.println(str+"***************");
//			PageBean<User> pageBean = userServiceimpl.fuzzySearch(page, str);
//			ActionContext.getContext().getValueStack().set("fuzzy", pageBean);
//			for (User user : pageBean.getList()) {
//				System.out.println(user.getUsername()+"*****************");
//			}
//			return "fuzzySearch";
//		}
		public String fuzzySearch(){
			HttpServletRequest request = ServletActionContext.getRequest();
			String str = request.getParameter("str");
			List<User> fuzzy = userServiceimpl.fuzzySearch(str);
			request.getSession().setAttribute("fuzzy", fuzzy);
			return "fuzzySearch";
		}
		
		//管理员批量删除用户
		public String BatchDelete(){
			HttpServletRequest request = ServletActionContext.getRequest();
			String[] arr = request.getParameterValues("arr");
			for(String a:arr)
			{
				String[] b = a.split(",");
				for (String c : b)
				{
					System.out.println(c+"************");
					userServiceimpl.deletes(c);
					System.out.println("**************");
				}
			}
			PageBean<User> pageBean = userServiceimpl.findByPage(page);
			request.getSession().setAttribute("pageBean", pageBean);
			System.out.println("**************adad");
			return "BatchDelete";
		}
	// end
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
}
