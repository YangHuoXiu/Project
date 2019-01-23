<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="pc/common/js/jquery-1.8.3.js?v=biyao_7d074dc"></script>
	<script type="text/javascript"
		src="pc/minisite/byshoes/js/jquery.cookie.js?v=biyao_a5283b2"></script>
	<script type="text/javascript"
		src="pc/common/js/jquery.extention.js?v=biyao_98daa33"></script>
	<script type="text/javascript"
		src="pc/common/js/ui/dialog.js?v=biyao_130c013"></script>
	<link href="${pageContext.request.contextPath}/css/common.css"
		rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/login.css"
		rel="stylesheet" type="text/css" />
	<link rel="shortcut icon"
		href="${pageContext.request.contextPath}/image/r___________renleipic_01/favicon.ico" />
	<link rel="bookmark"
		href="${pageContext.request.contextPath}/image/r___________renleipic_01/favicon.ico" />
	<link href="pc/common/css/common.css?v=biyao_1227846" rel="stylesheet" />
	<link href="pc/www/css/cm_www.css?v=biyao_3f1d92e" rel="stylesheet" />
	<link type="text/css" href="pc/www/css/myCenter.css?v=biyao_5976431"
		rel="stylesheet" />
	<script type="text/javascript">
		// var Search=document.getElementById("username");
		// function Onfocus()
		// {
		//  if(Search.value=="${item.username}")
		//  {
		//   Search.value="";
		//  }
		// }
		// function Onblur()
		// {
		//  if(Search.value=="")
		//  {
		//   Search.value="${item.username}";
		//  }
		// }
	</script>
</head>
<body>
	<div class="container header">
		<div class="span5">
			<div class="logo">
				<a href="${pageContext.request.contextPath}/index.jsp"> <img
					src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.png" />
				</a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				<img src="${pageContext.request.contextPath}/image/header.jpg"
					width="320" height="50" alt="正品保障" title="正品保障">
			</div>
		</div>
		<%@ include file="menu.jsp"%>
	</div>

	<div class="container register">
		<div>
			<br />
			<div class="per_right ">
				<div class="">
					<div class="relative">
						<h4 class="nTitle">个人设置</h4>
						<h3 class="per_title">
							<a class="a_checked" href="#"><span>个人信息</span></a>
							<a href="MyAddressManager.jsp"><span>管理收货地址</span></a>
						</h3>
					</div>
					<div class="pd10 bd_b_eee">
						<h4 class="f14 col_666 mg_t20">基本信息</h4>
						<form method="post" id="form"
							action="update">
							<table cellspacing="0" cellpadding="0" border="0"
								class="per_table th80">
								<tbody>
									<tr>
										<th>用户名:</th>
										<td><input id="username" type="text" name="username"
											class="text" value="${username}" readonly="readonly" /></td>

									</tr>
									<tr>
										<th>密&nbsp;&nbsp;码:</th>
										<td><input type="password" id="password" name="password"
											class="text" value="${password}"/></td>
									</tr>
									<tr>
										<th>地址:</th>
										<td><input type="text" id="address" name="address"
											class="text" maxlength="200" value="${address}"/></td>
									</tr>
									<tr>
										<th>手机号码:</th>
										<td><input id="phone" type="text" name="phone"
											class="text" value="${phone}" /></td>
									</tr>
									<input type="hidden" name="uid" class="text" value="${uid}"/>
									<input type="hidden" name="uinforid" class="text" value="${uinforid}"/>
									<input type="hidden" name="isadmin" class="text" value="${isadmin}"/>
									<tr>
										<th>&nbsp;</th>
										<td><input type="submit" value="修改"
											class="btnCom1 btnComS btnBg2 btnH1 w80 inline J_save" /></td>
									</tr>
									</p>
								</tbody>
							</table>

						</form>
					</div>
					<br />
				</div>
			</div>
		</div>
	</div>
</body>
</html>