<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>湖南省自来水公司营销管理信息系统</title>

<%@ include file="/SY/page/linkDocuments.jsp"%>
</head>
<body>
	<div id="wrapper">

		<%@include file="/SY/page/header.jsp"%>
		<!-- #header -->

		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">我的工作台</a></span> <span
					id="welcome_span">欢迎回来，${empLogin.empName}</span> <input
					type="hidden" id="empid" value="${empLogin.empId}">
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">

			<div id="welcome" class="x4">

				<p>
					<strong><a href="/SyProject/SY/pages/text.html">欢迎回来,
							${empLogin.empName}</a></strong><br />
				</p>

				<table class="data info_table">
					<tbody>

						<tr>
							<td class="value right">${showDate.nextUserCount}</td>
							<td class="full">本月新增用户数</td>
						</tr>
						<tr>
							<td class="value right">${showDate.rdShouldCount}</td>
							<td class="full">本月应抄表数</td>
						</tr>
						<tr>
							<td class="value right">${showDate.rdRealityCount}</td>
							<td class="full">本月实抄表数</td>
						</tr>
						<tr>
							<td class="value right">${showDate.readAmount}吨</td>
							<td class="full">本月用水量</td>
						</tr>
						<tr>
							<td class="value right">${showDate.SumBillMoney}元</td>
							<td class="full">本月应收水费</td>
						</tr>
						<tr>
							<td class="value right">${showDate.SumRealMoney}元</td>
							<td class="full">本月实收水费</td>
						</tr>

					</tbody>
				</table>

			</div>
			<!-- .x4 -->

			<div class="x8">
				<table class="stats" data-chart="bar">
					<caption>收费情况统计图表</caption>
					<thead>
						<tr>
							<td>&nbsp;</td>
							<c:forEach var="pb" items="${showDate.sumBillReal}">
								<th>${pb.billNo}</th>
							</c:forEach>
						</tr>

					</thead>

					<tbody>
						<tr>
							<th>应收（万元）</th>
							<c:forEach var="pb" items="${showDate.sumBillReal}">
								<td>${pb.billMoney/10000}</td>
							</c:forEach>
						</tr>
						<tr>
							<th>实收（万元）</th>
							<c:forEach var="pb" items="${showDate.sumBillReal}">
								<td>${pb.realMoney/10000}</td>
							</c:forEach>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- .x8 -->

			<div class="xbreak"></div>
			<!-- .xbreak -->



			<div class="x5 a1">

				<h2>用水类型统计</h2>

				<table class="stats" data-chart="pie">
					<caption>2014年02月用水类型占比表</caption>
					<thead>
						<tr>
							<td>&nbsp;</td>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>生活用水</th>
							<td>${showDate.SHCount}</td>
						</tr>
						<tr>
							<th>商业用水</th>
							<td>${showDate.SYCount}</td>
						</tr>
						<tr>
							<th>工业用水</th>
							<td>${showDate.GYCount}</td>
						</tr>
						<tr>
							<th>行政用水</th>
							<td>${showDate.XZCount}</td>
						</tr>
						<tr>
							<th>军区用水</th>
							<td>${showDate.JQCount}</td>
						</tr>
						<tr>
							<th>特种用水</th>
							<td>${showDate.TZCount}</td>
						</tr>
					</tbody>
				</table>

				<p>以上数据由系统自动生成，在本月结算之前，都不能视为正式数据，此图表仅供参考。</p>

			</div>
			<!-- .x5 -->



			<div class="x6">

				<h2>
					待处理的工单
					<!-- 此处要跳转工单管理界面,同时查出所有工单数据 -->
					<span class="fright "> <a
						href="/SyProject/beOrder/selectByStep?stepId=-2&orderType=0"
						class="ticket closed" style="color: #fff;">更多</a>
					</span>
				</h2>

				<table class="data support_table">
					<tbody>
						<c:forEach var="wb" items="${showDate.waitBe}">
							<tr>
								<td><span class="ticket responded">${wb.useTarget}</span></td>
								<td><span class="ticket open">${wb.phone}</span></td>
								<td class="full"><c:choose>
										<c:when test="${wb.stepId eq -1 }">
											<a target="_blank">${wb.address}</a>
										</c:when>
										<c:when test="${wb.stepId eq 0 }">
											<a target="_blank">${wb.address}</a>
										</c:when>
										<c:when test="${wb.stepId eq 2 }">
											<a href="/SyProject/SY/page/be__auditForm.jsp" target="_blank">${wb.address}</a>
										</c:when>
										<c:when test="${wb.stepId eq 3 }">
											<a href="/SyProject/SY/page/be__payForm.jsp"target="_blank">${wb.address}</a>
										</c:when>
										<c:when test="${wb.stepId eq 4 }">
											<a href="/SyProject/SY/page/be__billclearForm.jsp" target="_blank">${wb.address}</a>
										</c:when>
										<c:when test="${wb.stepId eq 5 }">
											<a href="/SyProject/SY/page/be__contractForm.jsp" target="_blank">${wb.address}</a>
										</c:when>
										<c:when test="${wb.stepId eq 6 }">
											<a href="/SyProject/SY/page/be__workingForm.jsp" target="_blank">${wb.address}</a>
										</c:when>
										<c:when test="${wb.stepId eq 7 }">
											<a href="/SyProject/SY/page/be__openForm.jsp?orderNo=${wb.orderNo}&userName=${wb.userName}" target="_blank">${wb.address}</a>
										</c:when>
										<c:otherwise>
											<a href="/SyProject/beOrderuser/selectByOrderNo2?orderNo=${wb.orderNo}&userName=${wb.userName}" target="_blank">${wb.address}</a>
										</c:otherwise>

									</c:choose></td>
								<td class="who"><a
									href="/SyProject/beOrder/queryByOrderno?orderNo=${wb.orderNo }" target="_blank">${wb.userName}</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- .x6 -->

			<a href="/SyProject/SY/page/error.html">出错演示页</a> | <a
				href="/SyProject/SY/page/success.html">成功演示页</a>

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

	</div>
	<!-- #wrapper -->

	<%@include file="/SY/page/jQuery.jsp"%>

	<script type="text/javascript">
		$(document).ready(function() {
			Dashboard.init();
		});
	</script>

</body>

</html>