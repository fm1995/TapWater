<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进度条</title> 
	
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
		

		
	</style>
	
</head> 
 
<body>
　　<input type="hidden" id="count" value="${param.count }">
<form class="form label-inline uniform ">
	<h2>正在复核...</h2>
	
	<div class="progressContent">
		<span id="message">&nbsp;</span>
		<div id="progressbar"></div>
	</div>
	
	<div class="center">
		<br/>
		<button id="ok" class="btn btn-blue" style="display:none;" onClick="parent.close();">完成</button>  
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
	var max = document.getElementById("count").value;
	var value = 0;
	function process(){
		value+=1; if(value>max)value=max;
		$( "#progressbar" ).progressbar({ max:max, value: value });
		processShowInfo();
		if(value<max){
			setTimeout(process, 10);
		}else{
			processComplete();
		}
	}
	function processShowInfo(){
		$('#message').text(value+'户/'+max+'户');
	}
	function processComplete(){
		$('#ok').show();
	}
	</script>
<script type="text/javascript">
	
$(document).ready ( function () 
{
	Dashboard.init ();	
	
	$( "#progressbar" ).progressbar({ max:max, value: 0 });
	process();
});



</script>

</body> 
 
</html>