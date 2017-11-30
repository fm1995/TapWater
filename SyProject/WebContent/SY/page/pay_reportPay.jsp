<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>湖南省自来水公司营销管理信息系统</title> 
	
	<link rel="stylesheet" href="/SyProject/SY/css/reset.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/text.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/form.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/buttons.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/grid.css" type="text/css" media="screen" title="no title" />	
	<link rel="stylesheet" href="/SyProject/SY/css/layout.css" type="text/css" media="screen" title="no title" />	
	<link rel="stylesheet" href="/SyProject/SY/css/ui-darkness/jquery-ui-1.8.12.custom.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/plugin/jquery.visualize.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/plugin/facebox.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/plugin/uniform.default.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/plugin/dataTables.css" type="text/css" media="screen" title="no title" />
	
	<link rel="stylesheet" href="/SyProject/SY/css/custom.css" type="text/css" media="screen" title="no title">
<%@include file="jQuery.jsp" %>
</head> 
 
<body> 

<div id="wrapper">
	<%@include file="header.jsp" %>
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">收费情况报表</a></span>
			<span id="welcome_span">欢迎回来，${empLogin.empName }</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>收费情况报表</h2>
			
			<div id="volumeDiv" class="form label-inline uniform" style="display:none;">
				<div class="header">
					选择表册
				</div>
				<div class="controlset field">
					<span class="label">&nbsp;</span>
					<div class="controlset-pad">
						<input type="checkbox" id="volumeAll" checked="checked" />  
						<label for="volumeAll">所有表册</label><br />
					</div>
				</div>
				<div class="portlet x2">
					<div class="controlset field">
						<span class="label">城东区</span>
						<div class="controlset-pad">
							<input type="checkbox" id="volume34" />  <label for="volume34">城东#1</label><br />
							<input type="checkbox" id="volume35" />  <label for="volume35">城东#2</label><br />
						</div>
					</div>
				</div>
				<div class="portlet x2">
					<div class="controlset field">
						<span class="label">城南区</span>
						<div class="controlset-pad">
							<input type="checkbox" id="volume36" />  <label for="volume36">城南#1</label><br />
							<input type="checkbox" id="volume37" />  <label for="volume37">城南#2</label><br />
						</div>
					</div>
				</div>
				<div class="portlet x2">
					<div class="controlset field">
						<span class="label">城西区</span>
						<div class="controlset-pad">
							<input type="checkbox" id="volume38" />  <label for="volume38">城西#1</label><br />
							<input type="checkbox" id="volume39" />  <label for="volume39">城西#2</label><br />
						</div>
					</div>
				</div>
				<div class="portlet x2">
					<div class="controlset field">
						<span class="label">城北区</span>
						<div class="controlset-pad">
							<input type="checkbox" id="volume40" />  <label for="volume40">城北#1</label><br />
							<input type="checkbox" id="volume41" />  <label for="volume41">城北#2</label><br />
						</div>
					</div>
				</div>
				<div class="portlet x2">
					<div class="controlset field">
						<span class="label">新开发区</span>
						<div class="controlset-pad">
							<input type="checkbox" id="volume42" />  <label for="volume42">新开发区#1</label><br />
							<input type="checkbox" id="volume43" />  <label for="volume43">新开发区#2</label><br />
						</div>
					</div>
				</div>
				<div class="portlet x2">
					<div class="controlset field">
						<span class="label">旧城区</span>
						<div class="controlset-pad">
							<input type="checkbox" id="volume44" />  <label for="volume44">旧城区#1</label><br />
							<input type="checkbox" id="volume45" />  <label for="volume45">旧城区#2</label><br />
						</div>
					</div>
				</div>
				<div class="portlet x2">
					<div class="controlset field">
						<span class="label">特别商户</span>
						<div class="controlset-pad">
							<input type="checkbox" id="volume46" />  <label for="volume46">特别商户#1</label><br />
						</div>
					</div>
				</div>
			</div>
			
			<form action="/SyProject/report/reportPay" method="post" name="frm">
			<div class="searchDiv">
				<div style="float:left;width:200px;">用户编码 <input name="userNo" value="${map['dto'].userNo }"/> </div>
				收费日期 <span class="between">
							<input id="t_paydate1" onClick="WdatePicker();" name="payDateBefore" value="${map['dto'].payDateBefore }"/> 
							<input type="checkbox"   value="2" id="ck_paydate_between" class="checkbox"
							onclick="$('#t_paydate2').toggle();" />
							<label for="ck_paydate_between">至</label>
							<input id="t_paydate2" name="payDateAfter"  value="${map['dto'].payDateAfter }" onClick="WdatePicker();" class="hide" />
						</span>
				<br/>
						 
				<div style="float:left;width:200px;">收费人员
				 <select class="medium" name="empId" id="empId">
						<option value="">所有</option>
						<c:forEach var="e" items="${map['emps']	 }">
							<option value="${e.empId }">${e.empName }</option>
						</c:forEach>
					</select>
				</div>
				发票号码 <span class="between">
							<input id="t_invoice1"  value="${map['dto'].ivNoBefore }"  name="ivNoBefore"/> 
							<input type="checkbox"   id="ck_invoice_between" class="checkbox"
							onclick="$('#t_invoice2').toggle();" />
							<label for="ck_invoice_between">至</label>
							<input id="t_invoice2" value="${map['dto'].ivNoAfter }" name="ivNoAfter"  class="hide" />
						</span>
				<button onclick="window.frm.submit();" class="btn btn-small btn-icon btn-find"><span></span>查询</button>
			</div>
			</form>
			
			<br/><br/>
			
			<div class="reportTitle">
				收费情况报表
			</div>	
			<div class="height24">
				<div style="float:left;">合计交费金额：${map['moneys'] }元</div>
			</div>
			<table class="report">
				<thead>
					<tr>
						<th width="100">用户编码</th>
						<th>用户姓名</th>
						<th width="160">交费单号</th>
						<th width="80">发票号</th>
						<th width="100">交费金额</th>
						<th width="120">交费日期</th>
						<th width="100">已用金额</th>
						<th width="100">剩余金额</th>
						<th width="80">收费员</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var ="p" items="${map['pays'] }">
						<tr>
							<td class="center">${p.user.userNo }</td>
							<td class="left">${p.user.userName }</td>
							<td class="center">${p.payNo }</td>
							<td class="center">${p.invoice }</td>
							<td class="right">${p.payMoney }元</td>
							<td class="right"> 
								<fmt:formatDate value="${p.payDate }"  type="date" dateStyle="long"/>
							</td>
							<td class="right">${p.useMoney }元</td>
							<td class="right">${p.payMoney.subtract(p.useMoney) }元</td>
							<td class="center">${p.emp.empName }</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				 <div class="page">
					<a href="javascript:up(2,${map['dto'].pageCount })">第一页</a>
					<a href="javascript:up(${map['dto'].page },${map['dto'].pageCount })">上一页</a>
					<!-- 存放当前的页面 -->
					<input class="pageIndex"  value="${map['dto'].page }"/> / <input class="pageCount" readonly="readonly" value="${map['dto'].pageCount }" />
					<a href="javascript:down(${map['dto'].page },${map['dto'].pageCount })">下一页</a>
					<a href="javascript:down(${map['dto'].pageCount-1 },${map['dto'].pageCount })">第未页</a>
				</div>
				
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<div id="footer">		
		<div class="content_pad">			
			<p>&copy; 2013-11 版权所有 <a href="#">湖南省自来水公司</a>.   技术支持 <a href="#">华瑞教育</a>.</p>
		</div> <!-- .content_pad -->
	</div> <!-- #footer -->
	
</div> <!-- #wrapper -->




<script type="text/javascript">
	setTimeout("back(${map['dto'].empId})", 250);
	window.back=function(empId,payDateAfter,ivNoAfter){
		$("#empId").val(empId);
		if($("#t_paydate2").val()!="")
			$("#ck_paydate_between").click();
		if($("#t_invoice2").val()!="")
			$("#ck_invoice_between").click();
	}
	
	window.up=function(currPage,row){
	 if(currPage<=1){
		return;
	 }
	 window.frm.action="/SyProject/report/reportPay?page="+(--currPage);
	window.frm.submit();
	}
		
	window.down=function(currPage,row){
		 if(currPage>=row){
			return;
		 }
		window.frm.action="/SyProject/report/reportPay?page="+(++currPage);
		window.frm.submit();
	}
</script>



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
<script src="/SyProject/SY/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
	
$(document).ready ( function () 
{
	Dashboard.init ();
	
});


</script>

</body> 
 
</html>