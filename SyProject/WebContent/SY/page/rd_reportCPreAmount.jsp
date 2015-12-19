<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<%@ include file="jQuery.jsp" %>
	<script type="text/javascript" src="/SyProject/SY/myJs/rd_reportCPreAmount.js"></script>
</head> 
 
<body> 

<div id="wrapper">
	
	<%@ include file="header.jsp" %>
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">底码修正记录</a></span>
			<span id="welcome_span">欢迎回来,${empLogin.empName}</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>底码修正记录</h2>
			
			<div class="searchDiv">
				操作人员 <select class="medium" id="empSel" >
					   </select>
				
				修正日期 <span class="between">
							<input onClick="WdatePicker();" id="startTime"/> - <input onClick="WdatePicker();" id="endTime" />
						</span>
				<button class="btn btn-small btn-icon btn-find" onclick="sel(1)"><span></span>查询</button>
			</div>
			
			<input type="hidden" id="pageSize" value="2">
			<div class="reportTitle">
				底码修改记录报表
			</div>	
			<div class="height24">
				<div style="float:left;width:200px;">共 <span id="count"></span> 次修改底码</div>
			</div>
			<table class="report" id="table">
				<thead>
					<tr>
						<th width="100">日期</th>
						<th width="100">用户编码</th>
						<th width="100">用户姓名</th>
						<th width="60">修正前</th>
						<th width="60">修正后</th>
						<th width="80">操作员</th>
						<th>备注</th>
					</tr>
				</thead>
				<tbody>	
				</tbody>
				</table>
				<div class="page">
					<a href="javaScript:nuPage(-2)">第一页</a>
					<a href="javaScript:nuPage(-1)">上一页</a>
					<input id="page" class="pageIndex" id="page" value="1"/> / <input class="pageCount" id="pageCount" readonly="readonly"  />
					<a href="javaScript:nuPage(1)">下一页</a>
					<a href="javaScript:nuPage(-3)">第未页</a>
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

<script type="text/javascript">
	
$(document).ready ( function () 
{
	Dashboard.init ();
	
});


</script>

</body> 
 
</html>