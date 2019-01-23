<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="pc/common/js/jquery-1.8.3.js?v=biyao_7d074dc"></script>
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
							<a href="MyCenterProfile.jsp"><span>个人信息</span></a> <a
								class="a_checked" href="#"><span>管理收货地址</span></a>
						</h3>
					</div>
					<form method="post" id="formAddress">
						<div class="pd10">
								<table border="0" cellspacing="0" class="per_table th80">
									<tbody>
										<tr>
											<th><span class="col_ee5b47"></span>收货人姓名：</th>
											<td><input type="text" data-highlight="highlight" name="sentName" class="inpCom w200 permy"></td>
										</tr>
										<tr>
											<th><span class="col_ee5b47"></span>收货人地址：</th>
											<td><input type="text" data-highlight="highlight" class="inpCom w380 permy" name="sentAddress"></td>
										</tr>
										<tr>
											<th><span class="col_ee5b47"></span>手机号码：</th>
											<td><input type="text" data-highlight="highlight" class="inpCom w200 permy" name="phone"></td>
										</tr>
										<tr>
											<th></th>
											<td><label class="checked J_default_address"> <i
													class="openIcon inline"> </i>&nbsp;设为默认地址
											</label></td>
										</tr>
										<tr>
											<th></th>
											<td colspan="2"><a id="btn_SaveAddress" href="#"
												class="btnCom1 btnComS btnBg2 btnH1 w80 inline J_save"><span>确
														定</span></a></td>
										</tr>
									</tbody>
								</table>
						</div>
					</form>
					<h3 class="perTitle col_523 lineH24">已保存的地址</h3>
					<table border="0" cellspacing="0" cellpadding="0"
						class="perTableTitle1">
						<tbody>
							<tr>
								<td width="9%"><span class="inline">收货人</span></td>
								<td width="20%"><span class="inline">所在省市</span></td>
								<td width="30%"><span class="inline">街道地址</span></td>
								<td width="10%"><span class="inline">手机</span></td>
								<td width="10%"><span class="inline"></span></td>
								<td width="10%"><span class="inline">操作</span></td>
							</tr>
						</tbody>
					</table>
					<table border="0" cellspacing="1" cellpadding="0"
						class="J_table per_list1  bg_fff">
						<tbody>
							<tr data-addressid="476683">
								<td width="9%" class="J_td2">阿茂</td>
								<td width="20%" class="J_td3">北京市西城区<input type="hidden"
									value="110000" data-text="北京市"> <input type="hidden"
										value="110100" data-text="市辖区"> <input type="hidden"
											value="110102" data-text="西城区"></td>
								<td width="30%" align="left" class="J_td2">网路1</td>
								<td width="11%" class="J_td2">13303032929</td>
								<td width="10%" type="true" class="J_td"><span
									class="col_ee5b47">默认地址</span></td>
								<td width="10%"><a class="J_edit col_link">修改</a> / <a
									class="J_dele col_link">删除</a></td>
							</tr>

						</tbody>
					</table>
					<br />
				</div>
			</div>
		</div>
	</div>
</body>
</html>