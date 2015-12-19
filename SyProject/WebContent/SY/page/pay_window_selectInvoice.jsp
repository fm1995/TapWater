<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 
 
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>选择发票</title> 
	 <%@include file="linkDocuments.jsp" %>
	 <%@include file="jQuery.jsp" %>
<style type="text/css">
.invoice_list a { margin:4px 2px;
font-size:14px;
}
</style>
<script type="text/javascript">
function ok(no){
	//window.returnValue=no;
	 returnWindow(no);
	parent.close();
}
</script>

</head> 
 
<body> 

<div style="width:90%; margin:0 auto;">
	<br/>
	<h2>选择发票</h2>


	<div class="invoice_list">
	  	<c:forEach var="iv" items="${map['invoices'] }">
			<a href="javascript:ok('${iv.invoiceNo }');">${iv.invoiceNo }</a>
	  	</c:forEach>
	</div>

<div style="margin-right:20px;">			
	<div class="page">
		<a href="javascript:up(2,${map['pageCount'] })">第一页</a>
		<a href="javascript:up(${map['page'] },${map['pageCount'] })">上一页</a>
		<input class="pageIndex" readonly="readonly" value="${map['page'] }"/> / <input class="pageCount" readonly="readonly" value="${map['pageCount'] }"  />
		<a href="javascript:down(${map['page'] },${map['pageCount'] })">下一页</a>
		<a href="javascript:down(${map['pageCount']-1 },${map['pageCount'] })">第未页</a>
	</div>
</div>
</div>


<script type="text/javascript">
	window.up=function(currPage,pageCount){
	 if(currPage<=1){
		return;
	 }
	 location.href="/SyProject/paywindow/selectInvoicePage?page="+(--currPage)+"&pageCount="+pageCount;
	}
		
	window.down=function(currPage,pageCount){
		 if(currPage>=pageCount){
			return;
		 }
		  location.href="/SyProject/paywindow/selectInvoicePage?page="+(++currPage)+"&pageCount="+pageCount;
	}
	 
	
<% 
	request.getSession().removeAttribute("map");
%>
</script>







 

<script type="text/javascript">
	
$(document).ready ( function () 
{
	Dashboard.init ();
});

</script>

</body> 
 
</html>