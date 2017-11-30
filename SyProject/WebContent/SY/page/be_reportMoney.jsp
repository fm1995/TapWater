<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>湖南省自来水公司营销管理信息系统</title>
<link rel="stylesheet" href="../css/custom.css" type="text/css"
	media="screen" title="no title">
<%@ include file="/SY/page/linkDocuments.jsp"%>

<style type="text/css">
.searchDiv input.chk {
	width: auto;
	vertical-align: middle;
	padding: 0px;
	margin: 2px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<%@include file="/SY/page/header.jsp"%>
		<!-- #header -->
		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">业扩收费报表</a></span> <span
					id="welcome_span">欢迎回来，马云</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">

			<div class="x12">

				<h2>业扩收费报表</h2>
				<form action="/SyProject/beOrderuser/selAllOrderuser">
					<div class="searchDiv">
						业扩类型 &nbsp;&nbsp; <label><input type="checkbox"
							class="chk" checked="checked" name="orderType1" value="1111" />新户</label>
						<label><input type="checkbox" class="chk"
							name="orderType2" value="2222" checked="checked" />分户</label> <label><input
							type="checkbox" class="chk" name="orderType3" value="3333"
							checked="checked" />换表</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 交费日期
						<span class="between"> <input name="date1" value="1970-1-1" type="date"> -<input
							name="date2" value='2050-1-1' type="date"  ></input>
						</span>
						<button  class="btn btn-small btn-icon btn-find" type="submit">
							<span></span>查询
						</button>
					</div>
				</form>

				<div class="reportTitle">业扩收费报表</div>
				<div class="height24">
					<div style="float: left; width: 200px;">收费总金额：${moneyCount }元</div>
				</div>
				<table class="report">
					<thead>
						<tr>
							<th width="140">工单号</th>
							<th width="60">类型</th>
							<th>工单户名</th>
							<th width="120">用户姓名</th>
							<th width="120">交费日期</th>
							<th width="120">交费金额</th>
							<th width="120">发票号码</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${orderUsers }" var="orderUser">
							<tr>
								<td class="center">${orderUser.beOrder.orderNo}</td>
								<c:choose>
									<c:when test="${orderUser.beOrder.orderType eq 1 }">
										<td class="center">新户</td>
									</c:when>
									<c:when test="${orderUser.beOrder.orderType eq 2 }">
										<td class="center">分户</td>
									</c:when>
									<c:when test="${orderUser.beOrder.orderType eq 3 }">
										<td class="center">过户</td>
									</c:when>
									<c:when test="${orderUser.beOrder.orderType eq 4 }">
										<td class="center">代扣</td>
									</c:when>
									<c:when test="${orderUser.beOrder.orderType eq 5 }">
										<td class="center">换表</td>
									</c:when>
									<c:when test="${orderUser.beOrder.orderType eq 6 }">
										<td class="center">重签</td>
									</c:when>
									<c:otherwise>
										<td class="center">销户</td>
									</c:otherwise>
								</c:choose>
								<td class="left">${orderUser.beOrder.userName }</td>
								<td class="left">${orderUser.userName }</td>
								<td class="center">${orderUser.beOrder.payDate}</td>
								<td class="right">${orderUser.realMoney}元</td>
								<td class="center">${orderUser.invoiceNo}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="page">
					<c:choose>
						<c:when test="${page == 0}">
							<a>第一页</a>
							<a>上一页</a>
						</c:when>
						<c:otherwise>
							<a href="/SyProject/beOrderuser/selAllOrderuser?page=0&orderType1=${orderType1 }&orderType2=${orderType2 }&orderType3=${orderType3}&date1=${date1}&date2=${date2}">第一页</a>
							<a href="/SyProject/beOrderuser/selAllOrderuser?page=${page-1}&orderType1=${orderType1 }&orderType2=${orderType2 }&orderType3=${orderType3}&date1=${date1}&date2=${date2}">上一页</a>
						</c:otherwise>
					</c:choose>
					<input class="pageIndex" readonly="readonly" value="${page+1 }" />
					/ <input class="pageCount" readonly="readonly"
						value="${pageCount }" />
					<c:choose>
						<c:when test="${page eq pageCount-1 }">
							<a>下一页</a>
							<a>第未页</a>
						</c:when>
						<c:otherwise>
							<a href="/SyProject/beOrderuser/selAllOrderuser?page=${page+1}&orderType1=${orderType1 }&orderType2=${orderType2 }&orderType3=${orderType3}&date1=${date1}&date2=${date2}">下一页</a>
							<a
								href="/SyProject/beOrderuser/selAllOrderuser?page=${pageCount-1}&orderType1=${orderType1 }&orderType2=${orderType2 }&orderType3=${orderType3}&date1=${date1}&date2=${date2}">第未页</a>
						</c:otherwise>
					</c:choose>
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

	<script src="/SyProject/SY/js/jquery/jquery-1.5.2.min.js"></script>
	<script src="/SyProject/SY/js/jquery/jquery-ui-1.8.12.custom.min.js"></script>
	<script src="/SyProject/SY/js/misc/excanvas.min.js"></script>
	<script src="/SyProject/SY/js/jquery/facebox.js"></script>
	<script src="/SyProject/SY/js/jquery/jquery.visualize.js"></script>
	<script src="/SyProject/SY/js/jquery/jquery.dataTables.min.js"></script>
	<script src="/SyProject/SY/js/jquery/jquery.tablesorter.min.js"></script>
	<script src="/SyProject/SY/js/jquery/jquery.uniform.min.js"></script>
	<script src="/SyProject/SY/js/jquery/jquery.placeholder.min.js"></script>

	<script src="/SyProject/SY/js/widgets.js"></script>
	<script src="/SyProject/SY/js/dashboard.js"></script>
	<script src="/SyProject/SY/My97DatePicker/WdatePicker.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			Dashboard.init();

		});
	</script>

</body>

</html>