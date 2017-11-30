<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>湖南省自来水公司营销管理信息系统</title>
<%@ include file="/SY/page/linkDocuments.jsp"%>
<%@include file="/SY/page/jQuery.jsp"%>
<script type="text/javascript" src="/SyProject/SY/myJs/rd_task.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		window.setCurrentDate=function(){
			var currentDate=new Date();
			var year=currentDate.getFullYear();
			var month=currentDate.getMonth()+1;
			$("#curYear").html(year);
			$("#curMonth").html(month);
		}
		setCurrentDate();
	});
	
</script>

</head>

<body>

	<div id="wrapper">
		<%@include file="/SY/page/header.jsp"%>
		<!-- #header -->

		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">抄表任务分配</a></span> 
				<span id="welcome_span">欢迎回来,${empLogin.empName}</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">

			<div class="x12">

				<div id="facebox_init" style="display: none">
					<div style="height: 80px; text-align: center; padding-top: 50px;">
						什么什么</div>

					<div class="dialogbutton center">
						<a class="btn" href="javascript:closeDialog();"
							style="width: 60px;">是</a> <a class="btn btn-grey"
							href="javascript:closeDialog();" style="width: 60px;">否</a>
					</div>
				</div>

				<h2>抄表任务分配 - <span id="curYear"></span>年<span id="curMonth"></span>月</h2>

				<table id="tb" class="data display">
					<thead>
						<tr>
							<th>抄表辖区</th>
							<th>表册</th>
							<th>抄表员</th>
							<th>本月应抄数</th>
							<th>本月实抄数</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>

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
			Dashboard.init();
		});
	</script>

</body>

</html>