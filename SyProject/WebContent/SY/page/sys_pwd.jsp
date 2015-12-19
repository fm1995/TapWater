<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>湖南省自来水公司营销管理信息系统</title>
<%@include file="left.jsp"%>
<script type="text/javascript">
	var mysubmit=function() {
		if ($("#pwd").val() == ""
				|| $("#pwd").val() != $("#pwd3").val()) {
			document.getElementById("no").style.display = "inline";
			document.getElementById("no").innerHTML = "当前密码不能为空,密码错误";
			return false;
		} else {
			document.getElementById("no").style.display = "none";
		}
		if ($("#pwd1").val() == "") {
			document.getElementById("no1").style.display = "inline";
			document.getElementById("no1").innerHTML = "新密码不能为空";
			return false;
		} else {
			document.getElementById("no1").style.display = "none";
		}
		if ($("#pwd2").val() == "") {
			document.getElementById("no2").style.display = "inline";
			document.getElementById("no2").innerHTML = "确认密码不能为空";
			return false;
		} else {
			document.getElementById("no2").style.display = "none";
		}
		if ($("#pwd1").val()!= $("#pwd2").val()) {
			$("#pwd1").val("");
			$("#pwd2").val("");
			document.getElementById("no2").style.display = "inline";
			document.getElementById("no2").innerHTML = "二次密码不一致,请重新输入";
			return false;
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
				<span id="pagetitle"><a href="javascript:;">修改密码</a></span> <span
					id="welcome_span">欢迎回来，${empLogin.empName}</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">

			<form action="/SyProject/sy/updateLogin" name="frm" method="post">
				<input id="pwd3" type="hidden" value="${empLogin.empPwd}" /> <input
					type="hidden" name="empId" value="${empLogin.empId}" />
				<div class="x12">

					<h2>修改密码</h2>

					<div class="form label-inline uniform">

						<div class="field">
							<label for="id">员工姓名</label> <input id="id" name="empName"
								size="50" type="text" class="medium" disabled="disabled"
								value="${empLogin.empName}" />
						</div>

						<div class="field">
							<label for="name">当前密码</label> <input id="pwd" name="empPwd1"
								size="50" type="password" class="medium" onblur="mysubmit()" /><span
								id="no" style="display: none; color: red"></span>
						</div>

						<div class="field">
							<label for="name">新密码</label> <input id="pwd1" name="empPwd"
								size="50" type="password" class="medium" onblur="mysubmit()" /><span
								id="no1" style="display: none; color: red"></span>
						</div>

						<div class="field">
							<label for="name">确认新密码</label> <input id="pwd2" name="empPwd1"
								size="50" type="password" class="medium" /><span
								id="no2" style="display: none; color: red"></span>
						</div>


						<div class="buttonrow">
							<input type="button" class="btn" value="确定"
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