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
	<script type="text/javascript">
	
	</script>
</head> 
 
<body> 

<div id="wrapper">
	
	 <%@include file="header.jsp"%>
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">快捷重签</a></span>
			<span id="welcome_span">欢迎回来，马云</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>快捷重签</h2>

			<div class="searchUserDiv">
				用户编码 <input  id="userNo"/>
				用户简码 <input   id="abc"/>
				用户姓名 <input id="userName"/>
				联系电话 <input id="phone"/>
				家庭住址 <input id="address"/>
				<button class="btn btn-small btn-icon btn-person" onclick="queryUsers();"><span></span>查询用户</button>
<!-- 			<a href="/SyProject/controller/queryUsUser">测试</a> -->
			</div>
			
			<br/><br/>
			
			
			
			<div class="form label-inline uniform">
				<h3 style="width:50%;">快捷重签</h3>
				<div class="field"><label for="id">用户编码</label> <input id="id" name="fname" size="50" type="text" class="medium" disabled="disabled"  /></div>
				
				<div class="field"><label for="name">用户姓名</label> <input id="name" name="lname" size="50" type="text" class="medium" disabled="disabled" /></div>
				
				<div class="field"><label for="name">原提比提量</label> <span class="text_button">
			<input id="batchTibi" disabled="disabled"
				style="width:245px;" readonly="readonly"  /></span></div>
							
				<div class="field"><label for="name">现提比提量</label> <span class="text_button">
			<input id="batchTibi2" 
				style="width:200px;" readonly="readonly" />
			<button onClick="setTibi('batchTibi2');">设定</button></span></div>

				<div class="buttonrow">
					<button class="btn" onclick="reSetProtocol();">重新签订用水协议</button>
				</div>

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

<script type="text/javascript" src="../js_2/js_2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		readEmp();
	});
</script>

</body> 
 
</html>