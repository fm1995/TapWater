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
function mysubmit(){
	 if ($("#No").val() == "") {
		document.getElementById("no").style.display="inline";
		document.getElementById("no").innerHTML = "员工工号不能为空";
		return false;
	}else{
		document.getElementById("no").style.display="none";
	}
	if ($("#name").val()== "") {
		document.getElementById("no1").style.display="inline";
		document.getElementById("no1").innerHTML = "员工姓名不能为空";
		return false;
	}else{
		document.getElementById("no1").style.display="none";
	}
	if ($("#pwd").val() == "") {
		document.getElementById("no2").style.display="inline";
		document.getElementById("no2").innerHTML = "员工密码不能为空";
		return false;
	}else{
		document.getElementById("no2").style.display="none";
	}
	if ($("#description").val()== "") {
		document.getElementById("no4").style.display="inline";
		document.getElementById("no4").innerHTML = "备注不能为空";
		return false;
	}else{
		document.getElementById("no4").style.display="none";
	}
	document.frm.submit();
}
</script>
</head>

<body>

	<div id="wrapper">
		<%@include file="header.jsp"%>
		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">员工设置</a></span> <span
					id="welcome_span">欢迎回来，${empLogin.empName}</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">

			<form name="frm" action="/SyProject/sy/updateEmp" method="post">
				<input type="hidden" value="${emp.empId}" name="empId" /> 
					<input type="hidden" value="0" name="empDisabled" /> 
				<div class="x12">

					<h2>添加/修改员工信息</h2>

					<div class="form label-inline uniform">

						<div class="field">
							<label for="id">员工ID</label> <input id="id" name="empId"
								size="50" type="text" class="medium" disabled="disabled"
								value="${emp.empId}" />
						</div>

						<div class="field">
							<label for="name">员工工号</label> <input id="No" name="empNo"
								size="50" type="text" value="${emp.empNo}" class="medium" /><span id="no" style="display: none; color: red"></span>
						</div>

						<div class="field">
							<label for="name">员工姓名</label> <input id="name" name="empName"
								size="50" value="${emp.empName}" type="text" class="medium" /><span id="no1" style="display: none; color: red"></span>
						</div>

						<div class="field">
							<label for="name">密码</label> <input id="pwd" name="empPwd"
								size="50" type="password" value="${emp.empPwd}" class="medium" /><span id="no2" style="display: none; color: red"></span>
						</div>

						<div class="field">
							<label for="type">所属部门</label> <select id="type" name="deptId"
								class="medium">
								<c:forEach items="${syDept}" var="sy">
									<c:if test="${emp.deptId eq sy.deptId}">
										<option value="${sy.deptId}" selected="selected">${sy.deptName}</option>
									</c:if>
									<c:if test="${emp.deptId ne sy.deptId}">
										<option value="${sy.deptId}">${sy.deptName}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>

						<div class="field">
							<label for="description">备注</label>
							<textarea rows="7" cols="50" id="description" name="empRemark">${emp.empRemark}</textarea><span id="no4" style="display: none; color: red"></span>
						</div>

						<div class="buttonrow">
							<input type="button" class="btn" value="修改"
								onclick="return mysubmit()" /> <input type="button"
								class="btn btn-grey" value="返回" onclick="history.back(-1);" />
						</div>

					</div>

				</div>
				<!-- .x12 -->
			</form>
		</div>
		<!-- #content -->

		<div id="footer">
			<div class="content_pad">
				<p>
					&copy; 2015 版权所有 <a href="#">湖南省自来水公司</a>. 技术支持 <a href="#">华瑞教育</a>.
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