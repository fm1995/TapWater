<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>湖南省自来水公司营销管理信息系统</title>

<link rel="stylesheet" href="/SyProject/SY/css/reset.css"
	type="text/css" media="screen" title="no title" />
<link rel="stylesheet" href="/SyProject/SY/css/text.css" type="text/css"
	media="screen" title="no title" />
<link rel="stylesheet" href="/SyProject/SY/css/form.css" type="text/css"
	media="screen" title="no title" />
<link rel="stylesheet" href="/SyProject/SY/css/buttons.css"
	type="text/css" media="screen" title="no title" />
<link rel="stylesheet" href="/SyProject/SY/css/grid.css" type="text/css"
	media="screen" title="no title" />
<link rel="stylesheet" href="/SyProject/SY/css/layout.css"
	type="text/css" media="screen" title="no title" />

<link rel="stylesheet"
	href="/SyProject/SY/css/ui-darkness/jquery-ui-1.8.12.custom.css"
	type="text/css" media="screen" title="no title" />
<link rel="stylesheet"
	href="/SyProject/SY/css/plugin/jquery.visualize.css" type="text/css"
	media="screen" title="no title" />
<link rel="stylesheet" href="/SyProject/SY/css/plugin/facebox.css"
	type="text/css" media="screen" title="no title" />
<link rel="stylesheet"
	href="/SyProject/SY/css/plugin/uniform.default.css" type="text/css"
	media="screen" title="no title" />
<link rel="stylesheet" href="/SyProject/SY/css/plugin/dataTables.css"
	type="text/css" media="screen" title="no title" />

<link rel="stylesheet" href="/SyProject/SY/css/custom.css"
	type="text/css" media="screen" title="no title">

</head>

<body>

	<div id="wrapper">
		<%@include file="/SY/page/header.jsp"%>
		<!-- #header -->
		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">发票使用情况查询</a></span> <span
					id="welcome_span">欢迎回来，马云</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">

			<div class="x12">

				<h2>
					发票使用情况查询
					<div style="float: right;">
						<a href="/SyProject/iv/toInvInvoiceReportUse">发票使用情况汇总表</a> 发票使用情况明细表
					</div>
				</h2>

				<div class="searchDiv">
					<div>
						<div style="float: left; width: 150px;">
							收费员 <select class="medium" id="empid">
								<option value="0">所有</option>
								<c:forEach var="emp" items="${toJsp}">
									<option value="${emp.empId}">${emp.empName}</option>
								</c:forEach>
							</select>
						</div>

						<div style="float: left; width: 298px;">
							发票号码 <span class="between"> <input id="t_invoice1"
								name="startNo" /> <input type="checkbox"
								id="ck_invoice_between" class="checkbox"
								onclick="$('#t_invoice2').toggle();" /> <label
								for="ck_invoice_between">至</label> <input id="t_invoice2"
								class="hide" name="endNo" />
							</span>
						</div>

						<div style="float: left;">
							使用日期 <span class="between"> <input id="t_paydate1"
								onClick="WdatePicker();" value="默认今天" name="useDateStart" /> <input
								type="checkbox" id="ck_paydate_between" class="checkbox"
								onclick="$('#t_paydate2').toggle();" /> <label
								for="ck_paydate_between">至</label> <input id="t_paydate2"
								onClick="WdatePicker();" class="hide" name="useDateEnd" />
							</span>
						</div>


					</div>
					<br />
					<br />
					<div>
						使用/作废 <select id="isUsed">
							<option value="-1">所有</option>
							<option value="0">已使用</option>
							<option value="1">已作废</option>
						</select> 是否交票 <select name="isArchived" id="isarchived">
							<option value="-1">所有</option>
							<option value="0">未交票</option>
							<option value="1">已交票</option>
						</select> 发票类型 <select name="InvoiceType" id="invoicetype">
							<option value="-1">所有</option>
							<option value="0">普通发票</option>
							<option value="1">增值税发票</option>
						</select> 用户编码 <input name="userNo" id="userno" />

						<button class="btn btn-small btn-icon btn-find" onclick="sub()">
							<span></span>查询
						</button>
					</div>



				</div>
				<br />
				<br />

				<div class="reportTitle">发票使用情况明细表</div>
				<table class="report">
					<thead>
						<th width="80">发票类型</th>
						<th width="80">发票号码</th>
						<th width="40">使用</th>
						<th width="40">作废</th>
						<th width="160">交费单号</th>
						<th>交费用户</th>
						<th width="100">交费金额</th>
						<th width="80">交费时间</th>
						<th width="80">收费员</th>
					</thead>
					<tbody id="tbo">
					</tbody>
					<tfoot>
						<tr>
							<td align="center">合计张数：</td>
							<td align="center" id="heji"></td>
							<td align="center" id="shiyong"></td>
							<td align="center" id="zuofei"></td>
							<td align="center">&nbsp;</td>
							<td align="right">合计金额：</td>
							<td align="right" id="sumMoney"></td>
							<td align="center">&nbsp;</td>
							<td align="center">&nbsp;</td>
						</tr>
					</tfoot>
				</table>

				<div class="page">
					<a href="javascript:selPage(1)">第一页</a> 
					<a href="javascript:selPage('-')">上一页</a> 
					<input class="pageIndex" id="page"/> / 
					<input class="pageCount" readonly="readonly" id="pageCount"/> 
					<a href="javascript:selPage('+')">下一页</a> 
					<a href="javascript:selPage('*')">第未页</a>
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
			sub(1);
		});

		//条件查询提交
		function sub(page) {
			//清空当前table中所有数据
			tableClear();
			
			var empId = $("#empid").val();
			var startNo = $("#t_invoice1").val();
			var endNo = $("#t_invoice2").val();
			var useDateStart = $("#t_paydate1").val();
			var useDateEnd = $("#t_paydate2").val();
			var isUsed = $("#isUsed").val();
			// 	var isInvalid=$("#isinvalid").val();
			var isArchived = $("#isarchived").val();
			var InvoiceType = $("#invoicetype").val();
			var userNo = $("#userno").val();
			
			//分页-初始条数
			if(page==null)
				page=1;
			
			if (useDateStart == "默认今天")
				useDateStart = "";

			//有时间再写验证逻辑

			$.post("/SyProject/iv/InvInvoiceReportUse1", {
				"empId" : empId,
				"startNo" : startNo,
				"endNo" : endNo,
				"useDateStart" : useDateStart,
				"useDateEnd" : useDateEnd,
				"isUsed" : isUsed,
				"isArchived" : isArchived,
				"InvoiceType" : InvoiceType,
				"userNo" : userNo,
				"page":page,
				"maxPage":10
			}, function(data) {
				//显示list集合数据
				var tbo= document.getElementById("tbo");
				for (var i = 0; i < data["whereIvPy"].length; i++) {
				var tr=document.createElement("tr");
					var list= data["whereIvPy"][i];
				var td1=document.createElement("td");
					td1.align="center";
					td1.innerHTML=invoiceType(list.invoiceType);
				tr.appendChild(td1);
				var td2=document.createElement("td");
					td2.align="center";
					td2.innerHTML=list.invoiceNo;
				tr.appendChild(td2);
				var td3=document.createElement("td");
					td3.align="center";
					td3.innerHTML=usedIs(list.used);
				tr.appendChild(td3);
				var td4=document.createElement("td");
					td4.align="center";
					td4.innerHTML=usedIs(list.invalid);
				tr.appendChild(td4);
				var td5=document.createElement("td");
					td5.align="center";
					td5.innerHTML=list.pay.payNo;
				tr.appendChild(td5);
				var td6=document.createElement("td");
					td6.align="left";
					td6.innerHTML=list.pay.user.userName;
				tr.appendChild(td6);
				var td7=document.createElement("td");
					td7.align="right";
					td7.innerHTML=list.pay.payMoney+".00元";
				tr.appendChild(td7);
				var td8=document.createElement("td");
					td8.align="center";
					td8.innerHTML=list.pay.payDate;
				tr.appendChild(td8);
				var td9=document.createElement("td");
					td9.align="center";
					td9.innerHTML=list.emp.empName;
				tr.appendChild(td9);
				tbo.appendChild(tr);
				//显示统计数据
				//合计总数
				$("#heji").html(data["rup"].maxCount);
				//合计使用数量
				$("#shiyong").html(data["usedCount"]);
				//合计的作废数量
				$("#zuofei").html(data["invalidCount"]);
				//合计的总金额
				$("#sumMoney").html(data["sumMoney"]+".00元");
				
				//分页显示
				//初始
				$("#page").val(data["rup"].page);
				//最大页数
				$("#pageCount").val(data["rup"].pageCount);
				}
			}, "json");
		}
		
		
		//分页操作
		var selPage=function(fh){
			var page=$("#page").val();
			switch(fh){
				case 1:
					//第一页
					if(page>1)
						page=1;
					else
						return;
					break;
				case '+':
					//下一页
					if($("#pageCount").val()>page)
						page= parseInt(page)+1;
					else
						return;
					break;
				case '-':
					//上一页
					if(page>1)
						page=page-1;
					else
						return;
					break;
				case '*':
					//最后一页
					if($("#pageCount").val()>1&&pageCount>page)
						page=$("#pageCount").val();
					else
						return;
					break;
			}
			//调用提交按钮表单
			sub(page);
		}
		
		var invoiceType=function(i){
			if(i==0)
				return "普通发票 ";
			else
				return "增值税发票";
		}
		
		var usedIs=function(i){
			if(i==0)
				return "";
			else
				return "是";
		}
		
		//清空当前table中所有数据
		var tableClear=function(){
			var tbo1= document.getElementById("tbo");
			var sum= tbo1.childNodes.length;
			for (var i = 0; i < sum; i++) {
				tbo1.removeChild(tbo1.lastChild);
			}
		}
		
		
	</script>

</body>

</html>