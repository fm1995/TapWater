<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>湖南省自来水公司营销管理信息系统</title>
<%@include file="left.jsp"%>
<script type="text/javascript">
	var selectId = function() {
		var id = document.getElementById("type").value;
		location.href = "/SyProject/sy/querySyAreapower?empId=" + id;
	};
	
	var checked_ = function() {
		if ($("#ide").attr('checked')==undefined) {
			alert("请选择多选框");
			return false;
		}
		document.frm.submit();
	};
</script>
</head>

<body>

	<div id="wrapper">
		<%@include file="header.jsp"%>
		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">片区权限</a></span> <span
					id="welcome_span">欢迎回来，${empLogin.empName}</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">

			<div class="x12">
				<form action="/SyProject/sy/queryEmpAreaPower" name="frm" method="post">
					<h2>片区权限</h2>
					<p>
					<div style="float: left;">
						<input type="button" class="btn-icon btn-star" value="批量设置片区权限"
							onclick="return checked_();">
					</div>
					<div style="float: right;">
						部门 <select id="type" class="medium" onchange="selectId()">
							<option value="0">所有部门</option>
							<c:forEach items="${syDept}" var="sy">
								<c:if test="${empId eq sy.deptId}">
									<option value="${sy.deptId}" selected="selected">${sy.deptName}</option>
								</c:if>
								<c:if test="${empId ne sy.deptId}">
									<option value="${sy.deptId}">${sy.deptName}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					</p>
					<table class="data display">
						<thead>
							<tr>
								<th><input type="checkbox"
									onChange="$(':checkbox').attr('checked', this.checked)" /></th>
								<th>员工ID</th>
								<th>员工工号</th>
								<th>员工姓名</th>
								<th>所属部门</th>
								<th>备注</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${syEmp}" var="m">
								<tr class="even gradeA">
									<td><input type="checkbox" id="ide" name="emp" value="${m.empId}"/></td>
									<td>${m.empId}</td>
									<td>${m.empNo}</td>
									<td>${m.empName}</td>
									<td>${m.syDept.deptName}</td>
									<td>${m.empRemark}</td>
									<td class="center"><input type="submit"
										class="btn-icon btn-small btn-blue btn-star" value="设置片区权限" />
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>

			</div>
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