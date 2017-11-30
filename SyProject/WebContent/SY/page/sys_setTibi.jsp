<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>设置提比提量值</title> 
	<%@include file="left.jsp" %>
</head> 
 
<body> 

<div style="width:90%; margin:0 auto;">
	<br/>
	<h2>设置提比提量值</h2>

	<input id="txtTibi" readonly="readonly" style="width:50%;" value="" />
	<button class="btn-icon btn-small btn-check btn-blue" onclick="ok(0);"><span></span>确定</button>
	<button class="btn-icon btn-small btn-cross btn-grey" onclick="ok(1);"><span></span>取消</button>
	
	<br/><br/>

	<table id="tibiTable" class="data display">
	<thead>
		<tr>
			<th>用水类型</th>
			<th>提取方式</th>
			<th>提取值</th>
			<th></th>
		</tr>
	</thead>
	<tbody></tbody>
	</table>
	
	<select style="width:98%;" onchange="addtibi(this);">
		<option >添加新规则</option>
		<option value="SH:生活用水">SH:生活用水</option>
		<option value="SY:商业用水">SY:商业用水</option>
		<option value="GY:工业用水">GY:工业用水</option>
		<option value="XZ:行政用水">XZ:行政用水</option>
		<option value="JQ:军区用水">JQ:军区用水</option>
		<option value="TZ:特种用水">TZ:特种用水</option>
	</select>
	
	<pre>操作说明：
1.提量   指定常量值，如：20，说明提取20吨做为该类型用水
2.提比   指定百分比，如：20%，说明从提量后剩余中提取20%做为该类型用水
3.取剩余 指定*号，说明把提量以及提比之后剩余量做为该类型用水
	</pre>

</div>

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

<script type="text/javascript" src="../js_2/js_2.js">
</script>

</body> 
 
</html>