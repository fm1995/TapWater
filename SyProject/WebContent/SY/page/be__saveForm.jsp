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
		document.forms[0].submit();
	};
	var f1=function (x){
		document.getElementsByName("docNums1").value=document.getElementsByName("docNums").value;
		document.forms[1].submit();
	}
	var f2=function (x){
		if(confirm("确认撤回吗")){
			location.href="/SyProject/beOrder/updateOrder5?orderNo="+x;
		}
	}

</script>


</head>

<body>

	<div id="wrapper">
		<%@include file="/SY/page/header.jsp"%>
		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">档案存档</a></span> <span
					id="welcome_span">欢迎回来，马云</span>
			</div>
		</div>
		<!-- #masthead -->
		<div id="content" class="xgrid">
			<div class="x12">
				<h2>
					档案存档 - <a href="../page/be_orderInfo.html?id=B1-20140105-0001"
						target="orderInfo">${beOrderusers[0].orderNo} </a> <a
						style="float: right" href="javascript:history.back(-1);">返回</a> <input
						type="hidden" id="orderNo" value="${beOrderusers[0].orderNo }">
				</h2>

				<div class="buttonrow">
					<button class="btn-icon btn-arrow-left btn-red"
						onclick="f2('${beOrderusers[0].orderNo}')">
						<span></span>撤回
					</button>
					<button class="btn-icon btn-arrow-right btn-blue"
						onclick="f1('${beOrderusers[0].orderNo}')">
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
							<td><input readonly="readonly" value="${userName }" /></td>
						</tr>
					</tbody>
				</table>
				<form action="/SyProject/beOrderuser/updateByOrderNo">
					<input type="hidden" name="orderNo"
						value="${beOrderusers[0].orderNo}">
					<table class="data display">
						<thead>
							<tr>
								<th width="30">序号</th>
								<th width="80">姓名</th>
								<th width="120">档案编号</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${beOrderusers }" var="beOrderuser"
								varStatus="i">
								<tr class="odd">
									<td>${i.count}</td>
									<td>${beOrderuser.userName }</td>
									<td><input name="docNums" value="${beOrderuser.docNum }" /></td>
									<td><input name="userId" value="${beOrderuser.id }" type="hidden" />
									<input name="userName" value="${userName }" type="hidden"/>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>

				<div class="centerButtons">
					<button class="btn" type="button" onclick="mysubmit()">保存不发送</button>
				
				</div>

			</div>
			<!-- .x12 -->

		</div>
		<!-- #content -->
		<form action="/SyProject/beOrder/updateOrder4">
		<input type="hidden" name="orderNo1" value="${beOrderusers[0].orderNo}">
		<c:forEach items="${beOrderusers }" var="beOrderuser">
		<input name="docNums1" type="hidden" value="${beOrderuser.docNum }" />
		<input name="userId1" value="${beOrderuser.id }" type="hidden" />
		</c:forEach>
		</form>

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