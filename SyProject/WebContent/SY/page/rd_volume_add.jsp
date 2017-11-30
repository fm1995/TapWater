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
	<script type="text/javascript" src="/SyProject/SY/myJs/rd_volume_add.js"></script>
</head> 
 
<body> 

<div id="wrapper">
	
		
	
	<%@ include file="header.jsp" %>
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">表册管理</a></span>
			<span id="welcome_span">欢迎回来,${empLogin.empName}</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid">
		
 		
		<div class="x12">
			
			<h2>添加/修改表册信息</h2>
			<div id="facebox_setVolume" style="display: none">
				<div id="facebox_setVolume_message" style="height:80px;text-align:center;padding-top:50px;">
					确认移动到此表册吗？
				</div>
				
				<div class="dialogbutton center">
					<a class="btn btn-grey" href="javascript:closeDialog();" style="width:120px;">确定</a>  
				</div>
			</div>
			<div id="facebox_setVolume1" style="display: none">
				<div id="facebox_setVolume_message1" style="height:80px;text-align:center;padding-top:50px;">
					表册名已占用！
				</div>
				
				<div class="dialogbutton center">
					<a class="btn btn-grey" href="javascript:closeDialog();" style="width:120px;">确定</a>  
				</div>
			</div>
			<div class="form label-inline uniform">
	
				<div class="field"><label for="id">表册ID</label> <input id="id" name="fname" size="50" type="text" class="medium" disabled="disabled" value="自动生成" /></div>
				
				<div class="field"><label for="name">表册名称</label> <input id="name" name="lname" size="50" type="text" class="medium" /></div>
				
				<div class="field"><label for="name">所属辖区</label> 
					<select id="select_area" class="medium" >
					</select>
				</div>
							
				<div class="field"><label for="description">备注</label> <textarea rows="7" cols="50" id="description" name="description"></textarea></div>

				<div class="buttonrow">
					<button class="btn" onclick="addVolume()">保存</button>  
					<button class="btn btn-grey" onClick="history.back(-1);">返回</button>
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

<script type="text/javascript">
	
<!-- $(document).ready ( function () 
{
	Dashboard.init ();		
});

</script> -->

</body> 
 
</html>