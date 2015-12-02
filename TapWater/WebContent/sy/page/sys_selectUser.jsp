<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 
 
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>选择用户</title> 
	
	<%@include file="../style.jsp" %>
	
	<script type="text/javascript">
	function ok(no){
		//模拟返回数据
		//returnWindow({id:'0100000987', name:'张三', abc:'zs'
		//	, tel:'13012345678', addr:'新开发区国际IT中心华瑞国际总部办公楼'});
		window.returnValue=no;
		parent.close(); //简单的处理
	}
	</script>
</head> 
 
<body> 

<div style="width:90%; margin:0 auto;">
	<br/>
	<h2>选择用户</h2>


	<table class="data display">
		<thead>
			<tr>
				<th>用户编码</th>
				<th>用户姓名</th>
				<th>简码</th>
				<th>电话</th>
				<th>地址</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="u" items="${map['users'] }">
				<tr class="odd">
					<td><a href="javascript:;" onClick="ok('${u.userNo }');">${u.userNo }</a></td>
					<td><a href="javascript:;" onClick="ok('${u.userNo }');">${u.userName }</a></td>
					<td>${u.abc }</td>
					<td>${u.phone }</td>
					<td>${u.address }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

<div style="margin-right:20px;">			
	<div class="page">
		<a href="?page=1">第一页</a>
		<a href="?page=6">上一页</a>
		<input class="pageIndex" value="7"/> / <input class="pageCount" readonly="readonly" value="98765" />
		<a href="?page=8">下一页</a>
		<a href="?page=98765">第未页</a>
	</div>
</div>
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

<script type="text/javascript">
$(document).ready ( function () 
{
	Dashboard.init ();
});
</script>

</body> 
 
</html>