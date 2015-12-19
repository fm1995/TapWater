<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>湖南省自来水公司营销管理信息系统</title>
<%@ include file="/SY/page/linkDocuments.jsp"%>
<script type="text/javascript">
	var mysubmit = function() {
		var stepId = document.getElementById("stepId").value;
		var orderType = document.getElementById("orderType").value;
		var orderNo = document.getElementById("orderNo").value;
		var userName = document.getElementById("userName").value;
		location.href = "/SyProject/beOrder/selectByStep?stepId=" + stepId
				+ "&orderType=" + orderType + "&orderNo=" + orderNo
				+ "&userName=" + userName;

	}
</script>
</head>
<body>

	<div id="wrapper">
		<%@include file="/SY/page/header.jsp"%>
		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">工单管理</a></span> <span
					id="welcome_span">欢迎回来，马云</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">

			<div class="x12">

				<h2>工单管理</h2>

				<div class="height40">
					工单类型 <select id="orderType">
						<option value="0">所有</option>
						<option value="1">新户</option>
						<option value="2">分户</option>
						<option value="3">过户</option>
						<option value="4">代扣</option>
						<option value="5">换表</option>
						<option value="6">重签</option>
						<option value="7">销户</option>
					</select> 工程进度 <select id="stepId">
						<option value="-2">所有</option>
						<option value="1">用户申请</option>
						<option value="2">初步审核</option>
						<option value="3">交施工费</option>
						<option value="4">水费清算</option>
						<option value="5">供水合同</option>
						<option value="6">施工竣工</option>
						<option value="7">通水停水</option>
						<option value="8">档案存档</option>
						<option value="0">完成</option>
						<option value="-1">终止</option>
					</select> 工单号 <input id="orderNo" /> 用户姓名 <input id="userName" />
					<button class="btn btn-small btn-icon btn-find" type="button"
						onclick="mysubmit()">
						<span></span>查询工单
					</button>
				</div>

				<table class="data display">
					<thead>
						<tr>
							<th width="120">工单号</th>
							<th width="60">类型</th>
							<th width="80">进度</th>
							<th width="90">当前处理部门</th>
							<th width="100">最后操作日期</th>
							<th width="200">用户名称</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${beOrders}" var="beOrder">
							<tr class="odd">
								<td><a href="/SyProject/beOrder/queryByOrderno?orderNo=${beOrder.orderNo }"
									target="orderInfo">${beOrder.orderNo}</a></td>
								<c:choose>
									<c:when test="${beOrder.orderType eq 1 }">
										<td>新户</td>
									</c:when>
									<c:when test="${beOrder.orderType eq 2 }">
										<td>分户</td>
									</c:when>
									<c:when test="${beOrder.orderType eq 3 }">
										<td>过户</td>
									</c:when>
									<c:when test="${beOrder.orderType eq 4 }">
										<td>代扣</td>
									</c:when>
									<c:when test="${beOrder.orderType eq 5 }">
										<td>换表</td>
									</c:when>
									<c:when test="${beOrder.orderType eq 6 }">
										<td>重签</td>
									</c:when>
									<c:otherwise>
										<td>销户</td>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${beOrder.stepId eq 2 }">
										<td>初步审核</td>
										<td>生技室</td>
									</c:when>
									<c:when test="${beOrder.stepId eq 3 }">
										<td>交施工费</td>
										<td>财务室</td>
									</c:when>
									<c:when test="${beOrder.stepId eq 4 }">
										<td>水费清算</td>
										<td>收费室</td>
									</c:when>
									<c:when test="${beOrder.stepId eq 5 }">
										<td>供水协议</td>
										<td>生技室</td>
									</c:when>
									<c:when test="${beOrder.stepId eq 6 }">
										<td>施工竣工</td>
										<td>安装队</td>
									</c:when>
									<c:when test="${beOrder.stepId eq 7 }">
										<td>通水停水</td>
										<td>抄表班</td>
									</c:when>
									<c:when test="${beOrder.stepId eq 8 }">
										<td>档案存档</td>
										<td>生技室</td>
									</c:when>
									<c:when test="${beOrder.stepId eq 0 }">
										<td>完成</td>
										<td></td>
									</c:when>
									<c:otherwise>
										<td>终止</td>
										<td></td>
									</c:otherwise>
								</c:choose>
								<td>${beOrder.lasteditDate }</td>
								<td>${beOrder.userName}</td>
								<c:choose>
									<c:when test="${beOrder.stepId eq -1 }">
										<td></td>
									</c:when>
									<c:when test="${beOrder.stepId eq 0 }">
										<td></td>
									</c:when>
									<c:when test="${beOrder.stepId eq 2}">
										<td>
											<button class="btn-icon btn-small btn-blue btn-check"
												onClick="location.href = '/SyProject/SY/page/be__auditForm.jsp';">
												<span></span>处理
											</button>
										</td>
									</c:when>
									<c:when test="${beOrder.stepId eq 3}">
										<td>
											<button class="btn-icon btn-small btn-blue btn-check"
												onClick="location.href = '/SyProject/SY/page/be__payForm.jsp';">
												<span></span>处理
											</button>
										</td>
									</c:when>
									<c:when test="${beOrder.stepId eq 4}">
										<td>
											<button class="btn-icon btn-small btn-blue btn-check"
												onClick="location.href = '/SyProject/SY/page/be__billclearForm.jsp';">
												<span></span>处理
											</button>
										</td>
									</c:when>
									<c:when test="${beOrder.stepId eq 5}">
										<td>
											<button class="btn-icon btn-small btn-blue btn-check"
												onClick="location.href = '/SyProject/SY/page/be__contractForm.jsp';">
												<span></span>处理
											</button>
										</td>
									</c:when>
									<c:when test="${beOrder.stepId eq 6}">
										<td>
											<button class="btn-icon btn-small btn-blue btn-check"
												onClick="location.href = '/SyProject/SY/page/be__workingForm.jsp';">
												<span></span>处理
											</button>
										</td>
									</c:when>
									<c:when test="${beOrder.stepId eq 7}">
										<td>
											<button class="btn-icon btn-small btn-blue btn-check"
												onClick="location.href = '/SyProject/SY/page/be__openForm.jsp';">
												<span></span>处理
											</button>
										</td>
									</c:when>
									<c:otherwise>
										<td>
											<button class="btn-icon btn-small btn-blue btn-check"
												onClick="location.href = '/SyProject/SY/page/be__saveForm.jsp';">
												<span></span>处理
											</button>
										</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="page">
					<c:choose>
						<c:when test="${page == 0 }">
							<a>第一页</a>
							<a>上一页</a>
						</c:when>
						<c:otherwise>
							<a href="/SyProject/beOrder/selectByStep?stepId=${stepId }&page=0&orderType=${orderType}&orderNo=${orderNo}&userName=${userName}">第一页</a>
							<a
								href="/SyProject/beOrder/selectByStep?stepId=${stepId }&page=${page-1}&orderType=${orderType}&orderNo=${orderNo}&userName=${userName}">上一页</a>
						</c:otherwise>
					</c:choose>
					<input class="pageIndex" value="${page+1}" readonly="readonly" />
					/ <input class="pageCount" readonly="readonly" value="${count }" />
					<c:choose>
						<c:when test="${page eq count-1 }">
							<a>下一页</a>
							<a>第未页</a>
						</c:when>
						<c:otherwise>
							<a
								href="/SyProject/beOrder/selectByStep?stepId=${stepId }&page=${page+1}&orderType=${orderType}&orderNo=${orderNo}&userName=${userName}">下一页</a>
							<a
								href="/SyProject/beOrder/selectByStep?stepId=${stepId }&page=${count-1}&orderType=${orderType}&orderNo=${orderNo}&userName=${userName}">第未页</a>
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