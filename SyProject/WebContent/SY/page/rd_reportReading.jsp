<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>湖南省自来水公司营销管理信息系统</title>

<%@ include file="/SY/page/linkDocuments.jsp"%>
<%@include file="/SY/page/jQuery.jsp"%>
<script src="/SyProject/SY/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="/SyProject/SY/myJs/rd_reportReading.js"></script>

</head>

<body>

	<div id="wrapper">

		<%@include file="/SY/page/header.jsp"%>
		<!-- #header -->

		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">抄表情况查询</a></span> 
				<span id="welcome_span">欢迎回来,${empLogin.empName}</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">

			<div class="x12">

				<h2>抄表情况查询</h2>

				<div class="searchDiv">
					抄表年月 <select class="medium" id="yearMonth">
					</select> 表册 <select class="medium" id="volume_id">

					</select> 审核日期 <span class="between"> <input onClick="WdatePicker();" id="startDate"/>
						- <input onClick="WdatePicker();" id="endDate"/>
					</span>
					<button class="btn btn-small btn-icon btn-find" onclick="queryRdReadDetails();">
						<span></span>查询
					</button>
				</div>


				<div class="reportTitle">表册抄表详细报表</div>
				<div class="height24">
					<div style="float: left; width: 200px;">抄表年月：<span id="volume_year_month"></span></div>
					<div style="float: left; width: 200px;">抄表员：<span id="emp_name"></span></div>
					<div style="float: left; width: 200px;">总用户数：<span id="total"></span>户</div>
					<div style="float: left; width: 200px;">总实用水量：<span id="totalAudit"></span>吨</div>
				</div>
				<table id="tb" class="report">
					<thead>
						<tr>
							<th width="100">用户编码</th>
							<th>用户姓名</th>
							<th width="100">上月底数</th>
							<th width="100">本月抄数</th>
							<th width="100">实用水量</th>
							<th width="60">是否已抄</th>
							<th width="60">是否复核</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
				<div class="page">
					<a href="javascript:change(-2);">第一页</a> <a href="javascript:change(-1);">上一页</a> <input class="pageIndex"
						value="1" id="page"/> / <input class="pageCount" readonly="readonly" id="count2"
						value="10" /> <a href="javascript:change(1);">下一页</a> <a href="javascript:change(-3);">第未页</a>
				</div>
				<input id="pageSize" type="hidden" value="2">
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