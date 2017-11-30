<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE jsp PUBLIC "-//W3C//DTD jsp 4.01 Transitional//EN" "http://www.w3.org/TR/jsp4/loose.dtd">
<jsp xmlns="http://www.w3.org/1999/xjsp">

<head>
<meta http-equiv="Content-type" content="text/jsp; charset=utf-8" />
<title>湖南省自来水公司营销管理信息系统</title>

<%@include file="../linkDocuments.jsp" %>

</head>
<body>
	<div id="wrapper">
		<%@include file="../header.jsp" %>

		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">用户申请</a></span> <span
					id="welcome_span">欢迎回来，马云</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">


			<div class="x12">

				<h2>
					用户申请 - 办理销户业务 <a style="float: right"
						href="javascript:history.back(-1);">返回</a>
				</h2>

				<div class="tab_container">
					<ul class="tabs">
						<li><a href="#tab1" onclick="tab1click()">申请表</a><input
							type="hidden" id="hi1" value="1" /></li>
						<li><a href="#tab2">销户用户</a></li>
					</ul>
					<div class="tab_content_container">
						<div id="tab1" class="tab_content">
							<form action="/SY/beorder/request7" method="post" name="fm">
								<table width="100%">
									<thead>
										<tr>
											<th width="60"></th>
											<th width="220"></th>
											<th width="60"></th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>用户名称</td>
											<td><input name="userName" /><input type="hidden"
												value="B7" name="orderNo"></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>销户说明</td>
											<td colspan="3"><input size="68" name="abortCause" /></td>
										</tr>

									</tbody>
								</table>
							</form>
						</div>
						<div id="tab2" class="tab_content">
							<div class="form label-inline uniform">


								<div class="field">
									原用户编码<input id="orNo" />
									<button class="btn btn-small" onclick="find()">确定</button>
								</div>
								<div class="field">
									原用户姓名<input disabled="disabled" id="oldname" />
								</div>
								<div class="field">
									原用户电话<input disabled="disabled" id="oldphone" />
								</div>
								<div class="field">
									原用户表径<input disabled="disabled" id="oldmeter" />
								</div>
								<div class="field">
									原用户地址<input disabled="disabled" size="50" id="oldaddr" />
								</div>



							</div>
						</div>

					</div>
				</div>



			</div>
			<!-- .x12 -->

			<div class="centerButtons">
				<button class="btn" onclick="submit()">办理</button>
				<script type="text/javascript">
					function submit() {
						var str = $("#hi1").val();
						if (str == '1') {
							document.fm.submit();
							alert("销户业务已办理！");
						}
					}

					var tab1click = function() {
						$("#hi1").val(1);
					}
				</script>
				<button class="btn btn-grey" onClick="history.back(-1);">返回</button>
			</div>

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

	<script type="text/javascript">
		$(document).ready(function() {
			Dashboard.init();

			//选项卡初始化
			$('.tab_container').tabs();
			
			selSyMeterType();
		});
		

		var selSyMeterType = function() {
			$.get("/SY/beorder/selSyMeterType", function(data) {
				var list = eval(data);
				var selType = document.getElementById("selType");
				selType.length = 0;
				for ( var i in list) {
					selType.appendChild(new Option(list[i].meterTypeName,
							list[i].metertypeId));
				}
			});
		}

		//根据ID查询
		$(function() {
			window.find = function() {
				var orid = $("#orNo").val();
				var args = {
					"orid" : orid
				};
				//1.路径  2,参数,3回调函数
				$.post("/SY/beorder/findOrder", args, function(x) {
					$("#oldname").val(x.oldUserName);
					$("#oldphone").val(x.oldUserPhone);
					$("#oldmeter").val(x.oldMeter);
					$("#oldaddr").val(x.oldUserAddr);
				});

			}

		});
	</script>

</body>

</jsp>