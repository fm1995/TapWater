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
	<%@ include file="jquery.jsp" %>
	<script type="text/javascript" src="/TapWater/sy/myJs/rd_reportMaxValue.js"></script>
</head> 
 
<body> 

<div id="wrapper">
	
	<%@ include file="../header.jsp" %>
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">最大表码修正记录</a></span>
			<span id="welcome_span">欢迎回来，马云</span>
		</div>
	</div> <!-- #masthead -->	
	<input type="hidden" id="pageSize" value="1">
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>最大表码修正记录</h2>
			
			<div class="searchDiv">
				操作人员 <select class="medium" id="empSel" >
					   </select>
				
				修正日期 <span class="between">
							<input onClick="WdatePicker();" /> - <input onClick="WdatePicker();" />
						</span>
				<button class="btn btn-small btn-icon btn-find"><span></span>查询</button>
			</div>
			
			
			<div class="reportTitle">
				最大表码修改记录报表
			</div>	
			<div class="height24">
				<div style="float:left;width:200px;">共 134 次修改最大表码值</div>
			</div>
			<table class="report">
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
					<tr>
						<td class="center">2013年12月10日</td>
						<td class="center">0100000987</td>
						<td>张三</td>
						<td class="right">9999</td>
						<td class="right">99999</td>
						<td class="center">赵云</td>
						<td>经核实，此用户的最大表码值是 99999 </td>
					</tr>
					<tr>
						<td class="center">2013年12月10日</td>
						<td class="center">0100000987</td>
						<td>张三</td>
						<td class="right">9999</td>
						<td class="right">99999</td>
						<td class="center">赵云</td>
						<td>经核实，此用户的最大表码值是 99999 </td>
					</tr>
					<tr>
						<td class="center">2013年12月10日</td>
						<td class="center">0100000987</td>
						<td>张三</td>
						<td class="right">9999</td>
						<td class="right">99999</td>
						<td class="center">赵云</td>
						<td>经核实，此用户的最大表码值是 99999 </td>
					</tr>
					<tr>
						<td class="center">2013年12月10日</td>
						<td class="center">0100000987</td>
						<td>张三</td>
						<td class="right">9999</td>
						<td class="right">99999</td>
						<td class="center">赵云</td>
						<td>经核实，此用户的最大表码值是 99999 </td>
					</tr>
					<tr>
						<td class="center">2013年12月10日</td>
						<td class="center">0100000987</td>
						<td>张三</td>
						<td class="right">9999</td>
						<td class="right">99999</td>
						<td class="center">赵云</td>
						<td>经核实，此用户的最大表码值是 99999 </td>
					</tr>
					<tr>
						<td class="center">2013年12月10日</td>
						<td class="center">0100000987</td>
						<td>张三</td>
						<td class="right">9999</td>
						<td class="right">99999</td>
						<td class="center">赵云</td>
						<td>经核实，此用户的最大表码值是 99999 </td>
					</tr>
					<tr>
						<td class="center">2013年12月10日</td>
						<td class="center">0100000987</td>
						<td>张三</td>
						<td class="right">9999</td>
						<td class="right">99999</td>
						<td class="center">赵云</td>
						<td>经核实，此用户的最大表码值是 99999 </td>
					</tr>
					<tr>
						<td class="center">2013年12月10日</td>
						<td class="center">0100000987</td>
						<td>张三</td>
						<td class="right">9999</td>
						<td class="right">99999</td>
						<td class="center">赵云</td>
						<td>经核实，此用户的最大表码值是 99999 </td>
					</tr>
					<tr>
						<td class="center">2013年12月10日</td>
						<td class="center">0100000987</td>
						<td>张三</td>
						<td class="right">9999</td>
						<td class="right">99999</td>
						<td class="center">赵云</td>
						<td>经核实，此用户的最大表码值是 99999 </td>
					</tr>
					<tr>
						<td class="center">2013年12月10日</td>
						<td class="center">0100000987</td>
						<td>张三</td>
						<td class="right">9999</td>
						<td class="right">99999</td>
						<td class="center">赵云</td>
						<td>经核实，此用户的最大表码值是 99999 </td>
					</tr>
					<tr>
						<td class="center">2013年12月10日</td>
						<td class="center">0100000987</td>
						<td>张三</td>
						<td class="right">9999</td>
						<td class="right">99999</td>
						<td class="center">赵云</td>
						<td>经核实，此用户的最大表码值是 99999 </td>
					</tr>
					<tr>
						<td class="center">2013年12月10日</td>
						<td class="center">0100000987</td>
						<td>张三</td>
						<td class="right">9999</td>
						<td class="right">99999</td>
						<td class="center">赵云</td>
						<td>经核实，此用户的最大表码值是 99999 </td>
					</tr>
					<tr>
						<td class="center">2013年12月10日</td>
						<td class="center">0100000987</td>
						<td>张三</td>
						<td class="right">9999</td>
						<td class="right">99999</td>
						<td class="center">赵云</td>
						<td>经核实，此用户的最大表码值是 99999 </td>
					</tr>
					<tr>
						<td class="center">2013年12月10日</td>
						<td class="center">0100000987</td>
						<td>张三</td>
						<td class="right">9999</td>
						<td class="right">99999</td>
						<td class="center">赵云</td>
						<td>经核实，此用户的最大表码值是 99999 </td>
					</tr>	
				</tbody>
				</table>
				<div class="page">
					<a href="#">第一页</a>
					<a href="#">上一页</a>
					<input class="pageIndex" value="1"/> / <input class="pageCount" readonly="readonly" value="98765" />
					<a href="#">下一页</a>
					<a href="#">第未页</a>
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