<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>初始化抄表年月</title> 
	
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
	<script type="text/javascript" src="/SyProject/SY/myJs/rd_init_progress.js"></script>
</head> 
 
<body > 

<div id="messageDiv">
	<div id="divText" style="height:80px;text-align:center;padding-top:50px;">
		确定要初始化抄表年月【2014年01月】吗？
	</div>
	
	<div class="dialogbutton center">
		<a class="btn" href="javascript:start();" style="width:60px;">是</a>  
		<a class="btn btn-grey" href="javascript:parent.close();" style="width:60px;">否</a>
	</div>
</div>

<form class="form label-inline uniform " style="display:none;">
	<h2><span id="spanText">正在初始化【2014年01月】的抄表任务...</span></h2>
	
	<div class="progressContent">
		<span id="message">&nbsp;</span>
		<div id="progressbar"></div>
	</div>
	
	<div class="center">
		<br/>
		<a  id="ok" class="btn btn-grey" href="javascript:parent.close();" style="display:none;" style="width:60px;">完成</a>
		<!-- <button id="ok" class="btn btn-blue" style="display:none;" onclick="off()">完成</button>   -->
	</div>
</form>

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
	
$(document).ready ( function () 
{
	Dashboard.init ();	
	
	$( "#progressbar" ).progressbar({ max:max, value: 0 });
});



</script>

</body> 
 
</html>