<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 
 
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>打印发票 - 09389411</title> 
	
	<%@include file="../style.jsp" %>
	
<style type="text/css">
tr.tr_money td { padding:10px;  }
tr.tr_money td.m1 { font-size:24px; }
</style>
<script type="text/javascript">
	
</script>
</head> 
 
<body > 
<input type="hidden" value="${param.flag }">

<div style="width:90%; margin:0px auto;">
	<div class="reportTitle">
		打印发票
	</div>
	<table class="report">
		<tbody>
			<tr>
				<td class="" style="width:10%">交费单号</td>
				<td class="" style="width:24%">JF0100000987-201401-02</td>
				<td class="" style="width:10%">发票号码</td>
				<td class="" style="width:23%">09389411</td>
				<td class="" style="width:10%">打印日期</td>
				<td class="" style="width:23%">2014年01月08日</td>
			</tr>
			<tr>
				<td class="">用户编码</td>
				<td class="">0100000987</td>
				<td class="">用户姓名</td>
				<td class="">张三</td>
				<td class="">收费人员</td>
				<td class="">雷军</td>
			</tr>
			<tr>
				<td class="">用水地址</td>
				<td class="" colspan="5">城东区解放东路阳光小区C栋439号</td>
			</tr>
		</tbody>
	</table>
	<br/>
	<table class="report">
		<tbody>
			<tr class="tr_money">
				<td class="">交费金额</td>
				<td class="m1" colspan="2">100 元</td>
				<td class="">大写金额</td>
				<td class="m1" colspan="2">壹佰元整</td>
			</tr>
		</tbody>
	</table>
	<div style="margin:0px auto; text-align:center; margin-top:10px;">
		<button class="btn btn-icon btn-print btn-blue" onClick="parent.close();"><span></span>打印</button>
		&nbsp;　　　　&nbsp;
		<button class="btn btn-icon btn-cross btn-red" onClick="parent.close();"><span></span>关闭</button>
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
	
	//选择项初始化
	$('.tab_container').tabs ();
	
	//陈欠账单-选择账单的操作
	$('table.billlist tbody tr').click(function(){
		$('table.billlist tbody tr.selected').removeClass('selected');
		$(this).addClass('selected');
		
		//以下代码是模拟ajax视觉效果
		if(!temp_html) temp_html = $('#details').html();
		$('#details').html('正在加载...');
		setTimeout(function(){ $('#details').html(temp_html); }, 300);
	});
});
var temp_html;

</script>
</body> 
</html>