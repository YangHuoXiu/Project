<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/js/public.js"></script>
<script type="text/javascript">
	// 	function fuzzySearch() {
	// 		window.location.href = "${pageContext.request.contextPath}/admin/user/fuzzySearch.jsp";
	// 	}
</script>
</HEAD>
<body>
	<br>
	<form method="post" action="userAdmin_fuzzySearch.action">
		<table align="left">
			<tbody>
				<input id="str" placeholder="模糊查询(根据用户名、地址、联系方式)" type="text"
					name="str" style="height: 28px; width: 30%" />&nbsp;&nbsp;
				<input type="submit" value="查询" style="height: 27px; width: 60px" />
			</tbody>
		</table>
	</form>
	<form id="Form1" name="Form1" action="" method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>查询结果</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

								<td align="center" width="7%">用户名</td>
								<td align="center" width="7%">密码</td>
								<td align="center" width="17%">地址</td>
								<td align="center" width="17%">联系方式</td>
								<td align="center" width="7%">身份</td>
								<td width="7%" align="center">编辑</td>
								<td width="7%" align="center">删除</td>
							</tr>
							<c:forEach items="${fuzzy}" var="item">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="7%">${item.username }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="7%">${item.password }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${item.userInfor.address }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${item.userInfor.phone }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="7%"><c:if test="${item.userInfor.isadmin eq 1}">
													管理员</c:if> <c:if test="${item.userInfor.isadmin eq 0}">
													普通用户</c:if></td>
									<td align="center" style="HEIGHT: 22px"><a
										href="${ pageContext.request.contextPath }/userAdmin_edit.action?uid=${item.uid }">
											<img
											src="${pageContext.request.contextPath}/images/i_edit.gif"
											border="0" style="CURSOR: hand">
									</a></td>

									<td align="center" style="HEIGHT: 22px"><a
										href="${ pageContext.request.contextPath }/userAdmin_adminDelete.action?uid=${item.uid }">
											<img
											src="${pageContext.request.contextPath}/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a></td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
<!-- 				<tr align="center"> -->
<%-- 					<td colspan="7">第<s:property value="fuzzy.page" />/<s:property --%>
<%-- 							value="fuzzy.totalPage" />页 <s:if test="fuzzy.page != 1"> --%>
<!-- 							<a -->
<%-- 								href="${ pageContext.request.contextPath }/userAdmin_fuzzySearch.action?page=1">首页</a>| --%>
<!-- 								<a -->
<%-- 								href="${ pageContext.request.contextPath }/userAdmin_fuzzySearch.action?page=<s:property value="fuzzy.page-1"/>">上一页</a>| --%>
<%-- 							</s:if> <s:if test="fuzzy.page != fuzzy.totalPage"> --%>
<!-- 							<a -->
<%-- 								href="${ pageContext.request.contextPath }/userAdmin_fuzzySearch.action?page=<s:property value="fuzzy.page+1"/>">下一页</a>| --%>
<!-- 								<a -->
<%-- 								href="${ pageContext.request.contextPath }/userAdmin_fuzzySearch.action?page=<s:property value="fuzzy.totalPage"/>">尾页</a>| --%>
<%-- 							</s:if> --%>
<!-- 					</td> -->
<!-- 				</tr> -->
			</TBODY>
		</table>
	</form>
</body>
</HTML>

