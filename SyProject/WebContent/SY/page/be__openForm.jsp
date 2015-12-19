<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>湖南省自来水公司营销管理信息系统</title>
<%@ include file="/SY/page/linkDocuments.jsp"%>
<script type="text/javascript">
function f1(x){
	if(confirm("确认发送吗")){
		location.href="/SyProject/beOrder/updateOrder2?orderNo="+x;
	}
}
function f2(x){
	if(confirm("确认撤回吗")){
		location.href="/SyProject/beOrder/updateOrder3?orderNo="+x;
	}
}


</script>
</head>
<body>
	<div id="wrapper">
			<%@include file="/SY/page/header.jsp"%>
		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">通水停水</a></span> <span
					id="welcome_span">欢迎回来，马云</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">


			<div class="x12">

				<h2>
					通水停水 - <a href="../page/be_orderInfo.html?id=B1-20140105-0001"
						target="orderInfo">${param.orderNo}</a> <a style="float: right"
						href="javascript:history.back(-1);">返回</a>
				</h2>

				<div class="buttonrow">
					<button class="btn-icon btn-arrow-left btn-red"
						onclick="f2('${param.orderNo}')">
						<span></span>撤回
					</button>
					<button class="btn-icon btn-arrow-right btn-blue"
						onclick="f1('${param.orderNo}')">
						<span></span>发送
					</button>
				</div>

				<table width="100%">
					<thead>
						<tr>
							<th width="60"></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>用户名称</td>
							<td><input readonly="readonly" value="${param.userName }" /></td>
						</tr>
						<tr>
							<td colspan="2"
								style="line-height: 260px; vertical-align: middle; text-align: center;">
								此步骤没有需要操作的选项</td>
						</tr>
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

	<script src="../js/jquery/jquery-1.5.2.min.js"></script>
	<script src="../js/jquery/jquery-ui-1.8.12.custom.min.js"></script>
	<script src="../js/misc/excanvas.min.js"></script>
	<script src="../js/jquery/facebox.js"></script>
	<script src="../js/jquery/jquery.visualize.js"></script>
	<script src="../js/jquery/jquery.dataTables.min.js"></script>
	<script src="../js/jquery/jquery.tablesorter.min.js"></script>
	<script src="../js/jquery/jquery.uniform.min.js"></script>
	<script src="../js/jquery/jquery.placeholder.min.js"></script>

	<script src="../js/widgets.js"></script>
	<script src="../js/dashboard.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			Dashboard.init();
		});
	</script>

</body>

</html>