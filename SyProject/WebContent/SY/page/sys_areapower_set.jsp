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
				<span id="pagetitle"><a href="javascript:;">片区权限</a></span> <span
					id="welcome_span">欢迎回来，${empLogin.empName}</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">

			<form action="/SyProject/sy/saveempAreaPower" method="post">
				<div class="x12">

					<h2>设置片区权限</h2>

					<div class="form label-inline uniform">

						<div class="field">
							<span class="bold">正在设置以下员工的片区权限</span> <br /> <span class="red">注意：你正在编辑多个员工的片区权限，不会显示这些员工的原有权限。
								<br />仅仅在只编辑一个员工时，才会显示该员工的原有权限。
							</span>
						</div>

						<div class="field">
							<textarea class="medium" disabled="disabled"
								style="width: 100%; height: 50px;">${empName}
							 </textarea>
							 <input type="hidden" name="id" value="${id}">
							<c:forEach  items="${empid}" var="em">
							 <input type="hidden" name="empid" value="${em}">
							</c:forEach>
						</div>
						<c:forEach items="${list}" var="li">
							<div class="controlset field">
								<span class="label">${li.areaName}</span>
								<div class="controlset-pad">
									<input type="checkbox" name="areaid" id="${li.areaId}"
										value="${li.areaId}" />
								</div>

							</div>
						</c:forEach>


						<div class="buttonrow">
							<input type="submit" class="btn" value="保存" /> <input
								type="button" class="btn btn-grey" value="返回"
								onclick="history.back(-1);" />
						</div>

					</div>
					<!-- .x12 -->
			</form>
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
<script type="text/javascript">
		$(document).ready(function() {
			Dashboard.init();
		});
	</script>
	<!--  		回显多选框 -->
	<c:forEach items="${li}" var="n">
		<script type="text/javascript">
			setTimeout("load('${n.areaId}')", 200)
		</script>
	</c:forEach>
	<script type="text/javascript">
		function load(name) {
			var obj = document.getElementById(name);
			obj.checked = "true";
		}
	</script>

</body>

</html>