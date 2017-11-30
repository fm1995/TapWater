<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 
 
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>湖南省自来水公司营销管理信息系统</title> 
	
	<link rel="stylesheet" href="/SyProject/SY/css/reset.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/text.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/form.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/buttons.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/grid.css" type="text/css" media="screen" title="no title" />	
	<link rel="stylesheet" href="/SyProject/SY/css/layout.css" type="text/css" media="screen" title="no title" />	
	
	<link rel="stylesheet" href="/SyProject/SY/css/ui-darkness/jquery-ui-1.8.12.custom.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/plugin/jquery.visualize.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/plugin/facebox.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/plugin/uniform.default.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/plugin/dataTables.css" type="text/css" media="screen" title="no title" />
	
	<link rel="stylesheet" href="/SyProject/SY/css/custom.css" type="text/css" media="screen" title="no title">
	<style type="text/css">
	table.report { width:300px; margin:0px auto; }
	table.report th,table.report td { padding:10px; font-size:14px;  }
	</style>
</head> 
 
<body> 

<div id="wrapper">
	<%@include file="/SY/page/header.jsp"%>
	 <!-- #header -->	
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">发票使用情况查询</a></span>
			<span id="welcome_span">欢迎回来，马云</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>
				发票使用情况查询
				<div style="float:right;">
					发票使用情况汇总表
					<a href="/SyProject/iv/toInvInvoiceReportUse1">发票使用情况明细表</a>
				</div>
			</h2>
			
			<div class="searchDiv">
			
				
				
				<div>
					<div style="float:left;width:150px;">
					收费员<select class="medium" name="empId" id="empid">
								<option value="0">所有</option>
							<c:forEach var="emp" items="${toJsp}">
								<option value="${emp.empId}">${emp.empName}</option>
							</c:forEach>
						 </select>
					</div>
						 
					<div style="float:left;width:298px;">
					发票号码 <span class="between">
							<input id="t_invoice1" name="startNo"/> 
							<input type="checkbox" id="ck_invoice_between" class="checkbox"
							onclick="$('#t_invoice2').toggle();" />
							<label for="ck_invoice_between">至</label>
							<input id="t_invoice2" class="hide" name="endNo"/>
						</span>
					</div>
						
					<div style="float:left;">
					使用日期 <span class="between">
							<input id="t_paydate1" onClick="WdatePicker();" value="默认今天" name="useDateStart"/> 
							<input type="checkbox" id="ck_paydate_between" class="checkbox" onclick="$('#t_paydate2').toggle();" />
							<label for="ck_paydate_between">至</label>
							<input id="t_paydate2" onClick="WdatePicker();" class="hide" name="useDateEnd"/>
						</span>
					</div>
						 
					
				</div>
				<br/><br/>
				<div>
<!-- 					是否使用 <select name="isUsed" id="isused"> -->
<!-- 								<option value="-1">所有</option> -->
<!-- 								<option value="0">未使用</option> -->
<!-- 								<option value="1">已使用</option> -->
<!-- 							 </select> -->
							 
<!-- 					是否作废 <select name="isInvalid" id="isinvalid"> -->
<!-- 								<option value="-1">所有</option> -->
<!-- 								<option value="0">未作废</option> -->
<!-- 								<option value="1">已作废</option> -->
<!-- 							 </select> -->
							 
<!-- 					是否交票 <select name="isArchived" id="isarchived"> -->
<!-- 								<option value="-1">所有</option> -->
<!-- 								<option value="0">未交票</option> -->
<!-- 								<option value="1">已交票</option> -->
<!-- 							 </select> -->
							 
					发票类型 <select name="InvoiceType" id="invoicetype">
								<option value="-1">所有</option>
								<option value="0">普通发票</option>
								<option value="1">增值税发票</option>
							 </select>
							 
					用户编码 <input name="userNo" id="userno"/>
					
					<button class="btn btn-small btn-icon btn-find" onclick="sub()"><span></span>查询</button>
				</div>
						 
				
				
			</div>
			<br/><br/>
			
			<div class="reportTitle">
				发票使用情况汇总表
			</div>
			<table class="report" id="ta1">
				
			</table>
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<div id="footer">		
		<div class="content_pad">			
			<p>&copy; 2013-11 版权所有 <a href="#">湖南省自来水公司</a>.   技术支持 <a href="#">华瑞教育</a>.</p>
		</div> <!-- .content_pad -->
	</div> <!-- #footer -->
	
</div> <!-- #wrapper -->

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
	
$(document).ready ( function () 
{
	Dashboard.init ();
	sub();
});

//条件查询提交
function sub(){
	var empId= $("#empid").val();
	var startNo=$("#t_invoice1").val();
	var endNo=$("#t_invoice2").val();
	var useDateStart=$("#t_paydate1").val();
	var useDateEnd=$("#t_paydate2").val();
// 	var isUsed=$("#isused").val();
// 	var isInvalid=$("#isinvalid").val();
// 	var isArchived=$("#isarchived").val();
	var InvoiceType=$("#invoicetype").val();
	var userNo=$("#userno").val();
	
	
	if(useDateStart=="默认今天")
		useDateStart="";
	
	
	//有时间再写验证逻辑
	
	$.post("/SyProject/iv/invInvoiceReportUse",
			{
				"empId":empId,
				"startNo":startNo,
				"endNo":endNo,
				"useDateStart":useDateStart,
				"useDateEnd":useDateEnd,
				"isUsed":-1,
				"isArchived":-1,
				"InvoiceType":InvoiceType,
				"userNo":userNo
			},
			function(data){
				var list= eval(data);
				var ta=document.getElementById("ta1");
				while(ta.hasChildNodes()){
					ta.removeChild(ta.firstChild);
				}
				
				for(var i=0;i<list.length;i++){
					var tr=document.createElement("tr");
					var td1=document.createElement("td");
					td1.innerHTML=list[i].key;
					var td2=document.createElement("td");
					td2.innerHTML=list[i].value;
					tr.appendChild(td1);
					tr.appendChild(td2);
					ta.appendChild(tr);
				}
			},"json");
}



</script>

</body> 
 
</html>