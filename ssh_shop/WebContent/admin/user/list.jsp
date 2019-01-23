<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/js/public.js">
</script>
<!-- 实现按钮的全选、不选、反选、批量删除 -->
<script>
	function allcheck() {
		var checkObj = document.getElementsByName("check");
		for (var i = 0; i < checkObj.length; i++) {
			checkObj[i].checked = true;
		}
	}
	function allnotcheck() {
		var checkObj = document.getElementsByName("check");
		for (var i = 0; i < checkObj.length; i++) {
			checkObj[i].checked = false;
		}
	}
	function backcheck() {
		var checkObj = document.getElementsByName("check");
		for (var i = 0; i < checkObj.length; i++) {
			if (checkObj[i].checked == true) {
				checkObj[i].checked = false;
			} else {
				checkObj[i].checked = true;
			}
		}
	}
	function batchdelete() {
		var arr = [];
		var flag = false;
		var checkObj = document.getElementsByName("check");
		for (var i = 0; i < checkObj.length; i++) {
			if (checkObj[i].checked == true) {
				arr.push(checkObj[i].value);
				flag = true;
			}
		}
		alert(arr);
		if (flag = true) {
			if (confirm("您确定要删除该用户？")) {
				location.href = "${pageContext.request.contextPath}/BatchDelete.action?arr=" + arr;
			}
		} else {
			alert("您至少选择一个用户，再进行删除！");
		}
	}
</script>
</HEAD>
<body>
	<br>
	<form method="post" action="userAdmin_fuzzySearch.action">
		<table align="left">
			<tbody>
				<input id="str" type="text" name="str"
					placeholder="模糊查询(根据用户名、地址、联系方式)" style="height: 28px; width: 30%" />&nbsp;&nbsp;
				<input type="submit" value="查询" style="height: 27px; width: 60px" />
			</tbody>
		</table>
	</form>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/user/list.jsp"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>用户列表</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="7%"></td>
								<td align="center" width="7%">序号</td>
								<td align="center" width="7%">用户名</td>
								<td align="center" width="7%">密码</td>
								<td align="center" width="17%">地址</td>
								<td align="center" width="17%">联系方式</td>
								<td align="center" width="7%">身份</td>
								<td width="7%" align="center">编辑</td>
								<td width="7%" align="center">删除</td>
							</tr>
							
							<s:iterator var="u" value="pageBean.list" status="status">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									
										<td><input type="checkbox" name="check" value=<s:property value="#u.uid"/>></td>
									
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="7%"><s:property value="#status.count" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="7%"><s:property value="#u.username" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="7%"><s:property value="#u.password" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%"><s:property value="#u.userInfor.address" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%"><s:property value="#u.userInfor.phone" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="7%"><s:if test="#u.userInfor.isadmin==1">
													管理员
												</s:if> <s:if test="#u.userInfor.isadmin==0">
													普通用户
												</s:if></td>
									<td align="center" style="HEIGHT: 22px"><a
										href="${ pageContext.request.contextPath }/userAdmin_edit.action?uid=<s:property value="#u.uid"/>">
											<img
											src="${pageContext.request.contextPath}/images/i_edit.gif"
											border="0" style="CURSOR: hand">
									</a></td>

									<td align="center" style="HEIGHT: 22px"><a
										href="${ pageContext.request.contextPath }/userAdmin_adminDelete.action?uid=<s:property value="#u.uid"/>">
											<img
											src="${pageContext.request.contextPath}/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a></td>
								</tr>
							
							</s:iterator>
						</table>
					</td>
					<input type="button" id="btn1" value="全选" onClick="allcheck();" />
						<input type="button" id="btn2" value="不选" onClick="allnotcheck();" />
						<input type="button" id="btn3" value="反选" onClick="backcheck();" />
						<input type="button" value="批量删除" onClick="batchdelete();" />
				</tr>
				<tr align="center">
					<td colspan="7">第<s:property value="pageBean.page" />/<s:property
							value="pageBean.totalPage" />页 <s:if test="pageBean.page != 1">
							<a
								href="${ pageContext.request.contextPath }/userAdmin_findAll.action?page=1">首页</a>|
								<a
								href="${ pageContext.request.contextPath }/userAdmin_findAll.action?page=<s:property value="pageBean.page-1"/>">上一页</a>|
							</s:if> <s:if test="pageBean.page != pageBean.totalPage">
							<a
								href="${ pageContext.request.contextPath }/userAdmin_findAll.action?page=<s:property value="pageBean.page+1"/>">下一页</a>|
								<a
								href="${ pageContext.request.contextPath }/userAdmin_findAll.action?page=<s:property value="pageBean.totalPage"/>">尾页</a>|
							</s:if>
					</td>
				</tr>
			</TBODY>
		</table>
	</form>
</body>
</HTML>

