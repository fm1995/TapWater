<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>湖南省自来水公司营销管理信息系统</title>
<%@ include file="/SY/page/linkDocuments.jsp"%>
<script type="text/javascript">
	var mysubmit = function() {
		var orderNo = $("#orderNo").val();
		$.get("/SyProject/beOrder/selectByOrderno", {
			"orderNo" : orderNo
		}, function(x) {
			$("#orderId").val(x.orderNo);
			if (x.orderType == 1) {
				$("#orderType").val("新户");
			}
			if (x.orderType == 2) {
				$("#orderType").val("分户");
			}
			if (x.orderType == 3) {
				$("#orderType").val("过户");
			}
			;
			if (x.orderType == 4) {
				$("#orderType").val("代扣");
			}
			if (x.orderType == 5) {
				$("#orderType").val("换表");
			}
			if (x.orderType == 6) {
				$("#orderType").val("重签");
			}
			if (x.orderType == 7) {
				$("#orderType").val("销户");
			}
			$("#address").val(x.address);
			$("#linkMan").val(x.linkMan);
			$("#phone").val(x.phone);
			if (x.stepId == 1) {
				$("#stepId").val("用户申请");
			}
			if (x.stepId == 2) {
				$("#stepId").val("初步审核");
			}
			if (x.stepId == 3) {
				$("#stepId").val("交施工费");
			}
			if (x.stepId == 4) {
				$("#stepId").val("水费清算");
			}
			if (x.stepId == 5) {
				$("#stepId").val("供水协议");
			}
			if (x.stepId == 6) {
				$("#stepId").val("施工竣工");
			}
			if (x.stepId == 7) {
				$("#stepId").val("通水停水");
			}
			;
			if (x.stepId == 8) {
				$("#stepId").val("档案存档");
			}
			if (x.stepId == 0) {
				$("#stepId").val("完成");
			}
			if (x.stepId == -1) {
				$("#stepId").val("终止");
			}
			$("#lastEditEmp").val(x.syEmp.empName);
			$("#lastEditDate").val(x.lasteditDate);
			$("#abortCause").val(x.abortCause);
			if (x.realMoney != null && x.realMoney > 0) {
				$("#realMoney").val("是");
			} else {
				$("#realMoney").val("不是");
			}
		});
	};

	var mysubmit2 = function() {
		var orderNo = $("#orderNo").val();
		var abortCause = $("#abortCause").val();
		location.href = "/SyProject/beOrder/updateOrder?orderNo=" + orderNo
				+ "&abortCause=" + abortCause;
	};
</script>
</head>

<body>
	<div id="wrapper">
		<%@include file="/SY/page/header.jsp"%>
		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">终止工单</a></span> <span
					id="welcome_span">欢迎回来，马云</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">
			<div class="x12">
				<h2>终止工单</h2>
				<div class="height40">
					工单号 <input id="orderNo" />
					<button class="btn btn-small btn-icon btn-find"
						onclick="mysubmit()" type="button">
						<span></span>查询工单
					</button>
				</div>

				<br /> <br />

				<div class="form label-inline uniform">

					<div class="field">
						<label for="id">工单号</label> <input id="orderId" name="fname"
							size="50" type="text" class="medium" disabled="disabled"
							value="B1-20111223-0011" />
					</div>
					<div class="field">
						<label for="id">工单类型</label> <input id="orderType" name="fname"
							size="50" type="text" class="medium" disabled="disabled"
							value="新立户" />
					</div>
					<div class="field">
						<label for="id">用户姓名</label> <input id="userName" name="fname"
							size="50" type="text" class="medium" disabled="disabled"
							value="杨天雷" />
					</div>
					<div class="field">
						<label for="id">用户地址</label> <input id="address" name="fname"
							size="50" type="text" class="medium" disabled="disabled"
							value="新开发区步行街405号" />
					</div>
					<div class="field">
						<label for="id">联系人</label> <input id="linkMan" name="fname"
							size="50" type="text" class="medium" disabled="disabled"
							value="杨天雷" />
					</div>
					<div class="field">
						<label for="id">联系电话</label> <input id="phone" name="fname"
							size="50" type="text" class="medium" disabled="disabled"
							value="18458493458" />
					</div>
					<div class="field">
						<label for="id">当前流程</label> <input id="stepID" name="fname"
							size="50" type="text" class="medium" disabled="disabled"
							value="施工竣工" />
					</div>
					<div class="field">
						<label for="id">最后操作人</label> <input id="lastEditEmp" name="fname"
							size="50" type="text" class="medium" disabled="disabled"
							value="马云" />
					</div>
					<div class="field">
						<label for="id">最后操作时间</label> <input id="lastEditDate"
							name="fname" size="50" type="text" class="medium"
							disabled="disabled" value="2014-01-17" />
					</div>
					<div class="field">
						<label for="id">已交费</label> <input id="realMoney" name="fname"
							size="50" type="text" class="medium" disabled="disabled"
							value="否" />
					</div>

					<div class="field">
						<label for="description">终止原因</label>
						<textarea rows="7" cols="50" id="abortCause" name="description"></textarea>
					</div>

					<div class="buttonrow">
						<button class="btn" type="button" onclick="mysubmit2()">确认终止</button>
						<button class="btn btn-grey" onClick="history.back(-1);">返回</button>
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