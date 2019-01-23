package com.Action;

import org.apache.struts2.ServletActionContext;





import com.model.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserInterceptorAction extends MethodFilterInterceptor{
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		// 判断是否登录,如果登录,放行,没有登录,跳转到登录页面.
		User user = (User) ServletActionContext.getRequest()
				.getSession().getAttribute("existUser");
		if(user != null){
			// 已经登录过
			return actionInvocation.invoke();
		}else{
			// 跳转到登录页面:
			return "input";
		}
	}

}
