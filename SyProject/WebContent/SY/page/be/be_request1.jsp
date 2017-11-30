<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE jsp PUBLIC "-//W3C//DTD jsp 4.01 Transitional//EN" "http://www.w3.org/TR/jsp4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xjsp">

<head>
<meta http-equiv="Content-type" content="text/jsp; charset=utf-8" />
<title>湖南省自来水公司营销管理信息系统</title>

<%@include file="../linkDocuments.jsp" %>
<style type="text/css">
#t_meterCount {
	text-align: right;
	width: 30px;
	vertical-align: middle;
}
</style>
<script type="text/javascript">
	function setMeter() {
		var n = $('#t_meterCount').val();
		if (isNaN(n))
			return; //不是数字
		if (n<=0||n>100)
			return; //不合理
		var rows = $('table.data tbody tr');
		if (rows.length == n)
			return; //行数相同

		if (rows.length < n) {//需增加行数
			for (var i = rows.length; i < n; i++) {
				$('table.data tbody')
						.append(
								'<tr><td>'
										+ (i + 1)
										+ '</td><td><input/></td><td><input/></td><td><input/></td><td><input/></td><td></td></tr>');
			}

		} else {//需减少行数
			$('table.data tbody tr:gt(' + (n - 1) + ')').remove();
		}

	}
	//提交
	function submit() {
		alert("aaaa");
		var str = $("#hi1").val();
		if (str == '1') {
			document.fm.submit();
			alert("新表申请成功！");
		}

		else if (str == '2') {
			document.fm2.submit();
			alert("新用户添加成!");
		}

	}
	
	
	var tab1click = function() {
		$("#hi1").val(1);
	}

	var tab2click = function() {
		
		$("#hi1").val(2);
	}
</script>
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
					用户申请 - 办理新开户业务 <a style="float: right"
						href="javascript:history.back(-1);">返回</a>
				</h2>

				<div class="tab_container">
					<ul class="tabs">
						<li><a href="#tab1" onclick="tab1click()">申请表</a> <input
							type="hidden" id="hi1" value="1" /></li>
						<li><a href="#tab2" onclick="tab2click()">新户详细表</a></li>
					</ul>
					<div class="tab_content_container">
						<div id="tab1" class="tab_content">
							<form action="/SY/beorder/save" name="fm" method="post">
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
											<td><input name="userName" /> <input type="hidden"
												value="B1" name="orderNo"></td>
											<td>用户类型</td>
											<td><select style="width: 158px;" name="userType">
													<option value="公户">公户</option>
													<option value="私户">私户</option>
											</select></td>
										</tr>
										<tr>
											<td>联系人</td>
											<td><input name="linkMan" /></td>
											<td>联系电话</td>
											<td><input name="phone" /></td>
										</tr>
										<tr>
											<td>用户地址</td>
											<td colspan="3"><input size="68" name="address" /></td>
										</tr>
										<tr>
											<td>用水量</td>
											<td><input name="maxAmount" /></td>
											<td>申请表径</td>

											<td><select style="width: 158px;" name="meterTypeName"
												id="selType">
											</select></td>

										</tr>
										<tr>
											<td>房屋层次</td>
											<td><input name="houseHeight" /></td>
											<td>接水用途</td>
											<td><input name="useTarget" /></td>
										</tr>
										<tr>
											<td>备注说明</td>
											<td colspan="3"><input size="68" name="abortCause"/></td>
										</tr>
									</tbody>
								</table>
							</form>
						</div>
						<div id="tab2" class="tab_content">
							申请装表表数 <input id="t_meterCount" value="1" />
							<button class="btn btn-small" onClick="setMeter();">确定</button>
							<div id="meters">
								<form action="/SY/beorder/insert" method="post" name="fm2">
									<table class="data display">
										<thead>
											<tr>
												<th width="30">序号</th>
												<th width="160">姓名</th>
												<th width="160">电话</th>
												<th width="160">短信号码</th>
												<th width="160">地址</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>1</td>
												<td><input name="userName" /> 
												<input type="hidden"value="B1" name="orderNo">
												</td>
												<td><input name="phone" /></td>
												<td><input name="smsPhone" /></td>
												<td><input name="address" /></td>

											</tr>
										</tbody>
									</table>
								</form>
							</div>
						</div>
					</div>
				</div>



			</div>
			<!-- .x12 -->

			<div class="centerButtons">
				<button class="btn" onclick="submit()">办理</button>
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
		
		var selSyMeterType=function(){
			$.get("/SY/beorder/selSyMeterType",
					function(data){
						var list=eval(data);
						var selType= document.getElementById("selType");
						selType.length=0;
						for (var i in list) {
							selType.appendChild(new Option(list[i].meterTypeName, list[i].metertypeId));
						}
					}
			);
		}
	</script>

</body>
</jsp>