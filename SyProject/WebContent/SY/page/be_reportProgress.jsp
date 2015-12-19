<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>湖南省自来水公司营销管理信息系统</title>
<%@ include file="/SY/page/linkDocuments.jsp"%><style
	type="text/css">
table.report tr {
	line-height: 38px;
}

table.report th, table.report td.item {
	background-color: #CCCCCC;
}

table.report .todo, table.report .cnt {
	background-color: #99FFFF;
}

table.report tr.todo td.cnt {
	font-weight: bold;
	color: red;
}

table.report td.hover {
	cursor: pointer;
}

table.report td.hover {
	background-color: #FFFF99;
}
</style>

</head>

<body>

	<div id="wrapper">
		<%@include file="/SY/page/header.jsp"%>
		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">业扩工程进度</a></span> <span
					id="welcome_span">欢迎回来，马云</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">

			<div class="x12">

				<h2>业扩工程进度</h2>


				<table class="report">
					<thead>
						<tr>
							<th>进度</th>
							<th width="100">新户</th>
							<th width="100">分户</th>
							<th width="100">过户</th>
							<th width="100">代扣</th>
							<th width="100">换表</th>
							<th width="100">重签</th>
							<th width="100">销户</th>
							<th width="100">总数</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${stepList}" var="step">
					
						<c:choose>
						<c:when test="${step[0] eq '待办总数' }">
						<tr class="todo">
							<td class="center item">${step[0]}</td>
							<c:choose>
							<c:when test="${step[1].get(0).count eq 0}">
							<td class="center num"></td>
							</c:when>
							<c:otherwise>
							<td class="center num">${step[1].get(0).count}</td>
							</c:otherwise>
							</c:choose>
							<c:choose>
							<c:when test="${step[1].get(1).count eq 0}">
							<td class="center num"></td>
							</c:when>
							<c:otherwise>
							<td class="center num">${step[1].get(1).count}</td>
							</c:otherwise>
							</c:choose>
							<c:choose>
							<c:when test="${step[1].get(2).count eq 0}">
							<td class="center num"></td>
							</c:when>
							<c:otherwise>
							<td class="center num">${step[1].get(2).count}</td>
							</c:otherwise>
							</c:choose>
							<c:choose>
							<c:when test="${step[1].get(3).count eq 0}">
							<td class="center num"></td>
							</c:when>
							<c:otherwise>
							<td class="center num">${step[1].get(3).count}</td>
							</c:otherwise>
							</c:choose>
							<c:choose>
							<c:when test="${step[1].get(4).count eq 0}">
							<td class="center num"></td>
							</c:when>
							<c:otherwise>
							<td class="center num">${step[1].get(4).count}</td>
							</c:otherwise>
							</c:choose>
							<c:choose>
							<c:when test="${step[1].get(5).count eq 0}">
							<td class="center num"></td>
							</c:when>
							<c:otherwise>
							<td class="center num">${step[1].get(5).count}</td>
							</c:otherwise>
							</c:choose>
							<c:choose>
							<c:when test="${step[1].get(6).count eq 0}">
							<td class="center num"></td>
							</c:when>
							<c:otherwise>
							<td class="center num">${step[1].get(6).count}</td>
							</c:otherwise>
							</c:choose>
							<td class="center cnt num">${step[2]}</td>
						</tr>
						</c:when>
						<c:otherwise>
						<tr >
							<td class="center item">${step[0]}</td>
							<c:choose>
							<c:when test="${step[1].get(0).count eq 0}">
							<td class="center num"></td>
							</c:when>
							<c:otherwise>
							<td class="center num">${step[1].get(0).count}</td>
							</c:otherwise>
							</c:choose>
							<c:choose>
							<c:when test="${step[1].get(1).count eq 0}">
							<td class="center num"></td>
							</c:when>
							<c:otherwise>
							<td class="center num">${step[1].get(1).count}</td>
							</c:otherwise>
							</c:choose>
							<c:choose>
							<c:when test="${step[1].get(2).count eq 0}">
							<td class="center num"></td>
							</c:when>
							<c:otherwise>
							<td class="center num">${step[1].get(2).count}</td>
							</c:otherwise>
							</c:choose>
							<c:choose>
							<c:when test="${step[1].get(3).count eq 0}">
							<td class="center num"></td>
							</c:when>
							<c:otherwise>
							<td class="center num">${step[1].get(3).count}</td>
							</c:otherwise>
							</c:choose>
							<c:choose>
							<c:when test="${step[1].get(4).count eq 0}">
							<td class="center num"></td>
							</c:when>
							<c:otherwise>
							<td class="center num">${step[1].get(4).count}</td>
							</c:otherwise>
							</c:choose>
							<c:choose>
							<c:when test="${step[1].get(5).count eq 0}">
							<td class="center num"></td>
							</c:when>
							<c:otherwise>
							<td class="center num">${step[1].get(5).count}</td>
							</c:otherwise>
							</c:choose>
							<c:choose>
							<c:when test="${step[1].get(6).count eq 0}">
							<td class="center num"></td>
							</c:when>
							<c:otherwise>
							<td class="center num">${step[1].get(6).count}</td>
							</c:otherwise>
							</c:choose>
							<td class="center cnt num">${step[2]}</td>
						</tr>
						</c:otherwise>
						</c:choose>
					</c:forEach>
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
	<script src="../My97DatePicker/WdatePicker.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			Dashboard.init();

			$('.num').hover(function() {
				$(this).addClass('hover');
			}, function() {
				$(this).removeClass('hover');
			}).click(function() {
				if (!$(this).text())
					return;
				window.open('../page/be_order.html?where___');
			});
		});
	</script>

</body>

</html>