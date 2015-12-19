<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>湖南省自来水公司营销管理信息系统</title>

<%@include file="/SY/page/linkDocuments.jsp"%>
<%@include file="/SY/page/jQuery.jsp"%>
<script type="text/javascript" src="/SyProject/SY/myJs/rd_reportMeterCheck.js"></script>

</head>

<body>

	<input type="hidden" id="pageSize" value="5">

	<div id="wrapper">

		<%@include file="/SY/page/header.jsp"%>
		<!-- #header -->

		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">水表周检报表</a></span>
				<span id="welcome_span">欢迎回来,${empLogin.empName}</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">

			<div class="x12">

				<h2>水表周检报表</h2>

				<div>
					表龄大于 <input id="meterAge" style="width: 30px; text-align: right;" value="1" />
					个月
					<button class="btn btn-small btn-icon btn-find" onclick="getTableData(1);">
						<span></span>查询
					</button>
				</div>
				<div class="reportTitle">表龄大于 <span id="showMeterAge" readonly="readonly">1</span>个月的水表</div>
				<div class="height24">
					<div style="float: left; width: 200px;">共计 <span id="count"></span> 块水表</div>
				</div>
				<table class="report" id="tb">
					<thead>
						<tr>
							<th width="100">用户编码</th>
							<th width="100">用户姓名</th>
							<th width="100">表身码</th>
							<th width="100">水表类型</th>
							<th width="80">水表口径</th>
							<th width="100">装表日期</th>
							<th width="80">表龄（月）</th>
							<th>水表厂家</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
				<div class="page">
					<a href="javascript:change(-2);">第一页</a> <a href="javascript:change(-1);">上一页</a> <input class="pageIndex"
						value="1" id="page" onfocus="textChange();"/> / <input id="pageTotal" class="pageCount" readonly="readonly"
						value="10" /> <a href="javascript:change(1);">下一页</a> <a href="javascript:change(-3);">第未页</a>
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
			Dashboard.init();
		});
	</script>

</body>

</html>