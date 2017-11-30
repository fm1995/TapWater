<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml"> 
 
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>打印发票 - 09389411</title> 
	
	<%@include file="jQuery.jsp" %>
	<%@include file="left.jsp" %>
	
<style type="text/css">
tr.tr_money td { padding:10px;  }
tr.tr_money td.m1 { font-size:24px; }
</style>
<script type="text/javascript">
	
</script>
</head> 
 
<body> 
<div style="width:90%; margin:0px auto;">
	<div class="reportTitle">
		打印发票
	</div>
	<table class="report">
		<tbody>
			<tr>
				<td class="" style="width:10%">交费单号</td>
				<td class="" style="width:24%">${pay.payNo }</td>
				<td class="" style="width:10%">发票号码</td>
				<td class="" style="width:23%">${pay.invoice }</td>
				<td class="" style="width:10%">打印日期</td>
				<td class="" style="width:23%"><fmt:formatDate value='${pay.payDate }'  type='date' /></td>
			</tr>
			<tr>
				<td class="">用户编码</td>
				<td class="">${pay.userNo }</td>
				<td class="">用户姓名</td>
				<td class="">${pay.user.userName }</td>
				<td class="">收费人员</td>
				<td class="">${pay.emp.empName }</td>
			</tr>
			<tr>
				<td class="">用水地址</td>
				<td class="" colspan="5">${pay.user.address }</td>
			</tr>
		</tbody>
	</table>
	<br/>
	<table class="report">
		<tbody>
			<tr class="tr_money">
				<td class="">交费金额</td>
				<td class="m1" colspan="2">${pay.payMoney } 元</td>
				<td class="">大写金额</td>
				<td class="m1" colspan="2" id="zhMoney">壹佰元整</td>
			</tr>
		</tbody>
	</table>
	<div style="margin:0px auto; text-align:center; margin-top:10px;">
		<button class="btn btn-icon btn-print btn-blue" onClick="parent.close();"><span></span>打印</button>
		&nbsp;　　　　&nbsp;
		<button class="btn btn-icon btn-cross btn-red" onClick="parent.close();"><span></span>关闭</button>
	</div>
</div>

<script src="/SyProject/SY/js/jquery/jquery-1.5.2.min.js"></script>
<script src="/SyProject/SY/js/jquery/jquery-ui-1.8.12.custom.min.js"></script>
<script src="/SyProject/SY/js/misc/excanvas.min.js"></script>
<script src="/SyProject/SY/js/jquery/facebox.js"></script>
<script src="/SyProject/SY/js/jquery/jquery.visualize.js"></script>
<script src="/SyProject/SY/js/jquery/jquery.dataTables.min.js"></script>
<script src="/SyProject/SY/js/jquery/jquery.tablesorter.min.js"></script>
<script src="/SyProject/SY/js/jquery/jquery.uniform.min.js"></script>
<script src="/SyProject/SY/js/jquery/jquery.placeholder.min.js"></script>

<script src="/SyProject/SY/js/widgets.js"></script>
<script src="/SyProject/SY/js/dashboard.js"></script>
<script src="/SyProject/SY/myJs/convertZH.js"></script>

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
	
	window.convertMoney=function(money){
		var zhMoney=changeMoneyToChinese(money);
		$("#zhMoney").html(zhMoney);
	}
});
var temp_html;
setTimeout("convertMoney('${pay.payMoney }')", 200)
</script>
</body> 
</html>