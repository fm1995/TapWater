<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>湖南省自来水公司营销管理信息系统</title> 
	<%@include file="linkDocuments.jsp" %>	
	<%@include file="jQuery.jsp" %>	
	<style type="text/css">
	tr.disabled td { color:#999999; }
	</style>
<script type="text/javascript">

//发票补开
function reInvoice(payNo){
	$.post("/SyProject/paywindow/selectInvoiceByPayNo",{"payNo":payNo},function(x){
		if(x=="ok")
			 //showWindow({url:'/SyProject/SY/page/pay_window_reInvoice.jsp'});
			location='/SyProject/SY/page/pay_invoiceReprint_reprint.jsp';
	}); 
}
$(function(){
	window.backLoad=function(empId){
		$("#empId").val(empId);
	}
});
setTimeout("backLoad(${dto.empId })", 200);
</script>
</head> 
 
<body> 

<div id="wrapper">
	
		
	
	<%@include file="header.jsp" %>
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">发票补开/作废</a></span>
			<span id="welcome_span">欢迎回来，${empLogin.empName }</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid">
		
 		
		<div class="x12">
			
			<h2>发票补开/作废</h2>
			<div class="height40">
			<form action="/SyProject/payprint/invoiceReprint" method="get" >
				发票保管员 <select class="medium" name="empId" id="empId">
						<option value="">所有</option>
							<c:forEach var="e" items="${emps }">
								<option value="${e.empId }">${e.empName }</option>
							</c:forEach>
					</select>
				发票号码 <input value="${dto.invoiceNo }" name="invoiceNo"/>
				使用日期 <input  onClick="WdatePicker();" value="${dto.date }" name="date"/>
				<button class="btn btn-small btn-icon btn-find"><span></span>查询</button>
			</form>
			</div>
				
			<table class="data display">
					<thead>
						<tr>
							<th>发票类型</th>
							<th>状态</th>
							<th>发票号码</th>
							<th>交费单号</th>
							<th>交费用户</th>
							<th>收费员</th>
							<th>交费金额</th>
							<th>交费/作废日期</th>
							<th>是否交票</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${pays }">
							<tr class="odd">
								<td>
									<c:if test="${p.ivInvoice.invoiceType ==0 }">普通发票</c:if>
									<c:if test="${p.ivInvoice.invoiceType ==1 }">增值税发票</c:if>
								</td>
								<td>
									<c:if test="${p.ivInvoice.used }">已使用</c:if>
									<c:if test="${!p.ivInvoice.used || p.ivInvoice.used ==null}">未使用</c:if>
								</td>
								<td>${p.ivInvoice.invoiceNo }</td>
								<td>${p.payNo }</td>
								<td>${p.user.userName }</td>
								<td>${p.emp.empName }</td>
								<td class="right">${p.payMoney } 元</td>
								<td>
									<c:if test="${p.ivInvoice.invalidDate != null }">
										<fmt:formatDate value="${p.ivInvoice.invalidDate }" pattern="yyyy-MM-dd"/>
									</c:if>
									<c:if test="${p.ivInvoice.archiveDate != null }">
										<fmt:formatDate value="${p.ivInvoice.archiveDate }" pattern="yyyy-MM-dd"/>
									</c:if></td>
								<td>
									<c:if test="${p.ivInvoice.archived}">是</c:if>
								</td>
								<td class="center">
									<c:if test="${p.ivInvoice.archived}">已交票不能操作</c:if>
									<c:if test="${!p.ivInvoice.archived || p.ivInvoice.archived==null }">
										<c:if test="${p.ivInvoice.invalid}">已作废不能操作</c:if>
										<c:if test="${!p.ivInvoice.invalid || p.ivInvoice.invalid==null }">
											<c:if test="${p.ivInvoice.used}">
												<button class="btn-icon btn-small btn-blue btn-star" onClick="reInvoice('${p.payNo }')"><span></span>补开</button>
											</c:if>
											<c:if test="${!p.ivInvoice.used || p.ivInvoice.used==null }">
												<button class="btn-icon btn-small btn-blue btn-star" onClick="location='/SyProject/payprint/ReprintDisable?invoiceNo=${p.ivInvoice.invoiceNo }';"><span></span>作废</button>  
											</c:if>
										</c:if>
									</c:if>
								</td>
							</tr>
						</c:forEach>
						 
						<tr class="odd disabled">
							<td>增值税发票</td>
							<td>已作废</td>
							<td>44949209</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td class="right">&nbsp;</td>
							<td>2013-11-04</td>
							<td>是</td>
							<td class="center">
								已作废不能操作  
							</td>
						</tr>
					</tbody>
					</table>
			
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<div id="footer">		
		<div class="content_pad">			
			<p>&copy; 2013-11 版权所有 <a href="#">湖南省自来水公司</a>.   技术支持 <a href="#">华瑞教育</a>.</p>
		</div> <!-- .content_pad -->
	</div> <!-- #footer -->
	
</div> <!-- #wrapper -->

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