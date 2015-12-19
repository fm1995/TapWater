<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>湖南省自来水公司营销管理信息系统</title>
<%@include file="left.jsp"%>
</head>


<body>

	<div id="wrapper">
		<%@include file="header.jsp"%>
		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">流程配置</a></span> <span
					id="welcome_span">欢迎回来，${empLogin.empName}</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">
			<form action="/SyProject/sy/updateFlow" method="post">
				<p>
					<input class="btn" type="submit" value="保存配置">
				</p>
				<div class="x12">

					<h2>流程配置</h2>
					<table class="data display">
						<thead>
							<tr>
								<th width="80">序号</th>
								<th width="120">流程工作项</th>
								<th>负责部门</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${flows}" var="fl">
								<c:if test="${fl.id >0}">
									<input type="hidden" name="id" value="${fl.id}" />
									<tr class="even">
										<td>${fl.id}</td>
										<td>${fl.stepName}</td>
										<td><select name="deptId" id="text">
												<c:forEach items="${depts}" var="de">
												<c:if test="${fl.deptId eq de.deptId}">
													<option value="${de.deptId}" selected="selected">${de.deptName}</option>
												</c:if>
												<c:if test="${fl.deptId ne de.deptId}">
													<option value="${de.deptId}">${de.deptName}</option>
												</c:if>
												</c:forEach>
										</select></td>
										<td></td>
									</tr>
								</c:if>

							</c:forEach>
						</tbody>
					</table>
				</div>
			</form>
			<!-- .x12 -->

		</div>
		<!-- #content -->

		<div id="footer">
			<div class="content_pad">
				<p>
					&copy; 2015版权所有 <a href="#">湖南省自来水公司</a>. 技术支持 <a href="#">华瑞教育</a>.
				</p>
			</div>
			<!-- .content_pad -->
		</div>
		<!-- #footer -->

	</div>
	<!-- #wrapper -->
<%@include file="jQuery.jsp" %>

	<script type="text/javascript">
		$(document).ready(function() {
			Dashboard.init();
		});
	</script>

</body>

</html>