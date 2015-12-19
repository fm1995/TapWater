<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>湖南省自来水公司营销管理信息系统</title>
<%@ include file="/SY/page/linkDocuments.jsp"%>
<%@include file="/SY/page/jQuery.jsp"%>
<script type="text/javascript" src="/SyProject/SY/myJs/rd_task_set.js"></script>
</head>

<body>
	<input id="volume_id" value="${param.volume_id}" type="hidden">
	<input id="emp_id" value="${param.emp_id}" type="hidden">
	<div id="wrapper">
		<%@include file="/SY/page/header.jsp"%>
		<!-- #header -->
		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">任务分配</a></span> 
				<span id="welcome_span">欢迎回来,${empLogin.empName}</span>
			</div>
		</div>
		<!-- #masthead -->
		<div id="content" class="xgrid">
			<div class="x12">
				<h2>任务分配</h2>
				<div class="form label-inline uniform">
					<div class="field">
						<label for="id">抄表年月</label> <input id="yearMonth" name="fname"
							size="50" type="text" class="medium" disabled="disabled"
							value="201312" />
					</div>
					<div class="field">
						<label for="id">辖区</label> <input id="areaName" name="fname" size="50"
							type="text" class="medium" disabled="disabled" value="城东区" />
					</div>
					<div class="field">
						<label for="id">表册</label> <input id="volumeName" name="fname" size="50"
							type="text" class="medium" disabled="disabled" value="城区#1" />
					</div>
					<div class="field">
						<label for="name">任务分配给</label> <select id="sel" class="medium">
						</select>
					</div>
					<div class="buttonrow">
						<button class="btn" onClick="upRdTask();">确定</button>
						<button class="btn btn-grey" onClick="history.back(-1);">返回</button>
					</div>
					<div id="facebox_setVolume" style="display: none">
						<div id="facebox_setVolume_message"
							style="height: 80px; text-align: center; padding-top: 50px;">
							*******
						</div>
						<div class="dialogbutton center">
							<a class="btn" href="javascript:closeDialog();"
								style="width: 100px;">确定</a> 
						</div>
					</div>
				</div>
			</div>
			<!-- .x12 -->
		</div>
		<!-- #content -->
		<div id="footer">
			<div class="content_pad">
				<p>
					&copy; 2013-11 版权所有 <a href="#">湖南省自来水公司</a>. 技术支持 <a href="#">华瑞教育</a>.
				</p>
			</div>
			<!-- .content_pad -->
		</div>
		<!-- #footer -->
	</div>
	<!-- #wrapper -->
	<script type="text/javascript">
		$(document).ready(function() {
			//Dashboard.init();
		});
	</script>
	
</body>
</html>