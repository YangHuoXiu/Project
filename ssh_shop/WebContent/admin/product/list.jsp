<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<%-- <script type="text/javascript">
			function addProduct(){
				window.location.href = "${pageContext.request.contextPath}/admin/product/add.jsp";
			}
		</script> --%>
	</HEAD>
	<body>
		<br>
		<form method="post" action="fuzzySearch_product.action">
		<table align="left">
			<tbody>
				<input id="str" type="text" name="str"
					style="height: 28px; width: 30%" placeholder="模糊查询(根据商品的名称、分类、描述)"/>&nbsp;&nbsp;
				<input type="submit" value="查询" style="height: 27px; width: 60px"/>
			</tbody>
		</table>
	</form>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>商品列表</strong>
						</TD>
					</tr>
					<!-- <tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="添加" class="button_add" onclick="addProduct()">
&#28155;&#21152;
</button>

						</td>
					</tr> -->
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="5%">
										序号
									</td>
									<td align="center" width="2%">
										图片
									</td>
									<td align="center" width="17%">
										商品名称
									</td>
									<td align="center" width="15%">
										所属分类
									</td>
									<td align="center" width="20%">
										商品描述
									</td>
									<td align="center" width="7%">
										商品价格
									</td>
									<td align="center" width="7%">
										码数
									</td>
									<td align="center" width="7%">
										颜色
									</td>
									<td align="center" width="7%">
										库存
									</td>
									<td width="7%" align="center">
										编辑
									</td>
									<td width="7%" align="center">
										删除
									</td>
								</tr>
									<s:iterator var="p" value="pageBean.list" status="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:property value="#status.count"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="2%">
												<img width="40" height="45" src="<s:property value="#p.productInfor.image"/>">
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="#p.pname"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="15%">
												<s:property value="#p.category.cname"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="20%">
												<s:property value="#p.productInfor.desName"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="7%">
												<s:property value="#p.productInfor.price"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="7%">
												<s:property value="#p.productInfor.size"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="7%">
												<s:property value="#p.productInfor.color"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="7%">
												<s:property value="#p.productInfor.sumnum"/>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${ pageContext.request.contextPath }/edit.action?pid=<s:property value="#p.pid"/>">
												
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
									
											<td align="center" style="HEIGHT: 22px">
												<a href="${ pageContext.request.contextPath }/delete_product.action?pid=<s:property value="#p.pid"/>">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
									</s:iterator>	
							</table>
						</td>
					</tr>
					<tr align="center">
						<td colspan="7">
							第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页 
							<s:if test="pageBean.page != 1">
								<a href="${ pageContext.request.contextPath }/adminFindAllProduct?page=1">首页</a>|
								<a href="${ pageContext.request.contextPath }/adminFindAllProduct?page=<s:property value="pageBean.page-1"/>">上一页</a>|
							</s:if>
							<s:if test="pageBean.page != pageBean.totalPage">
								<a href="${ pageContext.request.contextPath }/adminFindAllProduct?page=<s:property value="pageBean.page+1"/>">下一页</a>|
								<a href="${ pageContext.request.contextPath }/adminFindAllProduct?page=<s:property value="pageBean.totalPage"/>">尾页</a>|
							</s:if>
						</td>
					</tr>
				</TBODY>
			</table>
		</form>
	</body>
</HTML>

