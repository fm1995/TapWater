<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>湖南省自来水公司营销管理信息系统</title> 
	<%@include file="linkDocuments.jsp" %>
	<%@include file="jQuery.jsp" %>
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
			
			<div class="form label-inline uniform">
				<h2>未使用的发票 - 作废操作</h2>
				
				<div class="field"><label for="name">发票类型</label>
					<c:if test="${ivInvoice.invoiceType ==0 }">
						<input size="50" type="text" class="medium" value="普通发票" disabled="disabled" />
					</c:if>
					<c:if test="${ivInvoice.invoiceType ==1 }">
						<input size="50" type="text" class="medium" value="增值税发票" disabled="disabled" />
					</c:if>
				</div>
				
				<div class="field"><label for="name">发票状态</label>
					<c:if test="${!ivInvoice.used }">
						<input size="50" type="text" class="medium" value="未使用" disabled="disabled" />
					</c:if>
					<c:if test="${ivInvoice.used }">
						<input size="50" type="text" class="medium" value="已使用" disabled="disabled" />
					</c:if>
				</div>
				
				<div class="field"><label for="name">发票号码</label>
				<input size="50" type="text" class="medium" value="${ivInvoice.invoiceNo }" disabled="disabled"/></div>
				
				<div class="field"><label for="name">发票保管员</label>
				<input size="50" type="text" class="medium" value="${ivInvoice.emp.empName }" disabled="disabled" /></div>
				
				<div class="buttonrow">
					<input id="submit" type="button" onclick="location.href='/SyProject/payprint/disable?invoiceNo=${ivInvoice.invoiceNo }'" class="btn" value="作废" ></input>  
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

<script type="text/javascript">
	
$(document).ready ( function () 
{
	Dashboard.init ();		
});

</script>

</body> 
 
</html>