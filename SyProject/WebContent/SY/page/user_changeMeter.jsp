<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<style type="text/css">
	table.data thead th { vertical-align:middle; text-align:center; }
	</style>
</head> 
 
<body> 

<div id="wrapper">
	
	 <%@include file="header.jsp"%>
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">快捷换表</a></span>
			<span id="welcome_span">欢迎回来，马云</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>快捷换表</h2>

			<div class="searchUserDiv">
				用户编码 <input id="userNo" />
				用户简码 <input  id="abc"/>
				用户姓名 <input id="userName"/>
				联系电话 <input id="phone"/>
				家庭住址 <input id="address"/>
				<button class="btn btn-small btn-icon btn-person" onclick="queryChangeTable();"><span></span>查询用户</button>
			</div>
			
			<br/><br/>
			
			<h3 style="width:50%;">快捷换表</h3>
			
			<table width="100%">
				<thead>
					<tr>
						<th width="60"></th>
						<th width="220"></th>
						<th width="60"></th>
						<th width="220"></th>
						<th width="60"></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>用户编码</td>
						<td><input disabled="disabled" id="uId"/></td>
						<td>用户姓名</td>
						<td><input disabled="disabled" id="uName" /></td>
						<td>原表类型</td>
						<td><input disabled="disabled" id="mType" /></td>
					</tr>
					<tr>
						<td>新表编号</td>
						<td><input readonly="readonly" disabled="disabled" id="newMeterNo" /></td>
						<td>表身码</td>
						<td><input id="meterName" /></td>
						<td>起始底码</td>
						<td><input id="startValue" /></td>
					</tr>
					<tr>
						<td>水表类型</td>
						<td><select id="meterTypeId" style="width:158px;">
								<option>--请选择水表类型--</option>
							</select></td>
						<td>水表口径</td>
						<td><input id="metertypeAperture" /></td>
						<td>最大码值</td>
						<td><input id="maxValue"/></td>
					</tr>
					<tr>
						<td>装表日期</td>
						<td><input id="setupDate" onClick="WdatePicker();" /></td>
						<td>水表厂家</td>
						<td colspan="3"><input size="68" id="factory" /></td>
					</tr>
				</tbody>
				</table>
				
				<div style=" margin:20px 0px 0px 66px;" >
					<button class="btn" onclick="replaceMeter()">更换水表</button>
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
<script src="../My97DatePicker/WdatePicker.js"></script>
<script src="../js/widgets.js"></script>
<script src="../js/dashboard.js"></script>
<script type="text/javascript" src="../js_2/js_2.js"></script>
<script type="text/javascript">
	
$(document).ready ( function () 
{
	Dashboard.init ();
	//读取员工信息
	readEmp();
	fillMeterType();
});


</script>

</body> 
 
</html>