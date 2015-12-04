<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>湖南省自来水公司营销管理信息系统 - 员工登陆</title>

<link rel="stylesheet" href="/SyProject/SY/css/reset.css" type="text/css"
	media="screen" title="no title" />
<link rel="stylesheet" href="/SyProject/SY/css/text.css" type="text/css"
	media="screen" title="no title" />
<link rel="stylesheet" href="/SyProject/SY/css/form.css" type="text/css"
	media="screen" title="no title" />
<link rel="stylesheet" href="/SyProject/SY/css/buttons.css" type="text/css"
	media="screen" title="no title" />
<link rel="stylesheet" href="/SyProject/SY/css/login.css" type="text/css"
	media="screen" title="no title" />
<script type="text/javascript">
	var mysubmit = function() {
		if (document.getElementById("no").value == "") {
			alert("员工工号不能为空");
			return false;
		}
		if (document.getElementById("pwd").value == "") {
			alert("登陆密码不能为空");
			return false;
		}
		document.frm.submit();
	};
</script>
</head>
<%
	request.getSession().invalidate();
%>
<body>
	<div id="login_background">
		<div id="login">
			<h1>员工登陆</h1>
			<div id="login_panel">
				<form action="/SyProject/queryLogin" name="frm" method="post">
					<div class="login_fields">
						<div class="field">
							<label for="email">员工工号：</label> <input type="text" name="empNo"
								id="no" tabindex="1" placeholder="请输入您的员工编号" />
						</div>

						<div class="field">
							<label for="password">登陆密码： </label> <input type="password"
								name="empPwd" value="" id="pwd" tabindex="2"
								placeholder="请输入您的密码" />
						</div>
					</div>
					<!-- .login_fields -->

					<div class="login_actions">
						<input type="button" class="btn btn-orange" value="登陆"
							onclick="return mysubmit()" />
					</div>
				</form>
			</div>
			<!-- #login_panel -->
		</div>
		<!-- #login -->
	</div>
</body>

</html>