<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>湖南省自来水公司营销管理信息系统</title>
<%@include file="left.jsp"%>
<script type="text/javascript">
	function mysubmit() {
		if ($("#name").val() == "") {
			document.getElementById("no").style.display = "inline";
			document.getElementById("no").innerHTML = "抄表辖区名称不能为空";
			return false;
		} else {
			document.getElementById("no").style.display = "none";
		}
		if ($("#description").val() == "") {
			document.getElementById("no1").style.display = "inline";
			document.getElementById("no1").innerHTML = "备注不能为空";
			return false;
		} else {
			document.getElementById("no1").style.display = "none";
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
				<span id="pagetitle"><a href="javascript:;">抄表辖区设置</a></span> <span
					id="welcome_span">欢迎回来，${empLogin.empName}</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">
			<form action="/SyProject/sy/updateArea" name="frm" method="post">
				<input type="hidden" name="areaId" value="${syArea.areaId}" /> <input
					type="hidden" name="areaDisabled" value="0" />
				<div class="x12">
					<h2>添加/修改抄表辖区</h2>
					<div class="form label-inline uniform">

						<div class="field">
							<label for="id">抄表辖区ID</label> <input id="id" name="areaId"
								size="50" type="text" class="medium" disabled="disabled"
								value="${syArea.areaId}" />
						</div>

						<div class="field">
							<label for="name">抄表辖区名称</label> <input id="name" name="areaName"
								value="${syArea.areaName}" size="50" onblur="mysubmit()"
								type="text" class="medium" /><span id="no"
								style="display: none; color: red"></span>
						</div>


						<div class="field">
							<label for="description">备注</label>
							<textarea rows="7" cols="50" id="description" name="areaRemark">${syArea.areaRemark}</textarea>
							<span id="no1" style="display: none; color: red"></span>
						</div>

						<div class="buttonrow">
							<input class="btn" type="button" onclick="return mysubmit()" value="保存"/>
							<input type="button" class="btn btn-grey"onClick="history.back(-1);" value="返回"/>
						</div>

					</div>

				</div>
			</form>
			<!-- .x12 -->

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
		<%@include file="jQuery.jsp" %>

		<script type="text/javascript">
			$(document).ready(function() {
				Dashboard.init();
			});
		</script>
</body>

</html>