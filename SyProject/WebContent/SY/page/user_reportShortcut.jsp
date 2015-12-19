<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml"> 
 
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>湖南省自来水公司营销管理信息系统</title> 
	
	<link rel="stylesheet" href="../css/reset.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="../css/text.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="../css/form.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="../css/buttons.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="../css/grid.css" type="text/css" media="screen" title="no title" />	
	<link rel="stylesheet" href="../css/layout.css" type="text/css" media="screen" title="no title" />	
	
	<link rel="stylesheet" href="../css/ui-darkness/jquery-ui-1.8.12.custom.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="../css/plugin/jquery.visualize.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="../css/plugin/facebox.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="../css/plugin/uniform.default.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="../css/plugin/dataTables.css" type="text/css" media="screen" title="no title" />
	
	<link rel="stylesheet" href="../css/custom.css" type="text/css" media="screen" title="no title">
</head> 
 
<body> 

<div id="wrapper">
	
	 <%@include file="header.jsp"%>
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">快捷操作记录</a></span>
			<span id="welcome_span">欢迎回来，马云</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>快捷操作记录</h2>
			
			<div class="searchDiv">
				操作类型 <select class="medium" id="orderType">
							<option value=0>所有</option>
							<option value=1>新户</option>
							<option value=3>过户</option>
							<option value=4>代扣</option>
							<option value=5>换表</option>
							<option value=6>重签</option>
							<option value=7>销户</option>
						</select>
				操作人员 <select class="medium" id="emp">
							<option value=0>所有</option>
						 </select>
				
				操作日期 <span class="between">
							<input onClick="WdatePicker();" id="stratDatee"/> - <input onClick="WdatePicker();" id="stopDatee"/>
						</span>
				<button class="btn btn-small btn-icon btn-find" onclick="queryOrderLiteByParemter();"><span></span>查询</button>
			</div>
			
			
			<div class="reportTitle">
				快捷操作记录
			</div>	
			<div class="height24">
				<div style="float:left;width:200px;" id="orderCount">共 0 次快捷操作</div>
			</div>
			<table class="report" id="displayTable">
				<thead>
					<tr>
						<th width="128">操作时间</th>
						<th width="60">操作员</th>
						<th width="40">类型</th>
						<th width="60">用户编码</th>
						<th width="100">用户姓名</th>
						<th>备注</th>
					</tr>
				</thead>
				<tbody id="tbody">
				</tbody>
				</table>
				<div class="page">
					<a href="javascript:queryOrderLiteByParemter(1);">第一页</a>
					<a href="javascript:groupPage(0);">上一页</a>
					<input class="pageIndex" id="pageNumber" value="1" onblur="groupPage(2)"/> / <input class="pageCount" readonly="readonly" id="number" value="98765" />
					<a href="javascript:groupPage(1);">下一页</a>
					<a href="javascript:groupPage(3);">第未页</a>
				</div>
				
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<div id="footer">		
		<div class="content_pad">			
			<p>&copy; 2013-11 版权所有 <a href="#">湖南省自来水公司</a>.   技术支持 <a href="#">华瑞教育</a>.</p>
		</div> <!-- .content_pad -->
	</div> <!-- #footer -->
	
</div> <!-- #wrapper -->

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
<script src="../js_2/js_2.js"></script>
<script type="text/javascript">
	
$(document).ready ( function () 
{
	Dashboard.init ();
		readEmp();
	//初始化 绑定操作员工 
		$.post(
				"/SyProject/controller/queryEmpAll",
				function(data)
				{
					var emps=document.getElementById("emp");
					emps.options.length=1;
					for (var y = 0; y < data.length; y++) {
						var opt=new Option(data[y].empName,data[y].empId);
						emps.appendChild(opt);
					}
					
				});	

	
});


</script>

</body> 
 
</html>