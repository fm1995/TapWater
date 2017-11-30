<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml"> 
 
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>湖南省自来水公司营销管理信息系统</title> 

	<%@ include file="/SY/page/linkDocuments.jsp"%>	
	<style type="text/css">
	.data td,.data th,.data tr{padding:10px 2px !important; text-align:right !important; }
	</style>
</head> 
 
<body> 

<div id="wrapper">
	<%@include file="/SY/page/header.jsp"%>
		
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">发票总表</a></span>
			<span id="welcome_span">欢迎回来，马云</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid">
		
 		
		<div class="x12">
			
			<h2>发票总表</h2>
			
			<a href="javascript:;" onclick="$('#description').toggle();">显示/隐藏说明</a>
			<div id="description" class="hide">
			发票使用流程为：入库->出库->使用/作废->交票<br/>
			总张数：从税务局入库至公司财务室的发票总张数<br/>
			出库数：从财务室出库至收费室收费员手中总张数<br/>
			未出数：即[总张数]减[出库数]<br/>
			已用数：从收费员手中打印给客户的发票总张数（保有第二联）<br/>
			作废数：从收费员手中做作废处理的发票总张数<br/>
			待用数：在收费员手中还可以使用的发票总数，即[出库数]-([已用数]+[作废数])<br/>
			已交数：从收费员手中交还至财务室进行归档做账的发票总张数<br/>
			未交数：尚留在收费员手中的发票，可以是已用的，作废的或待用的<br/>
						<br/>
			</div>
			
			<table class="data display">
					<thead>
						<tr>
							<th width="80">发票类型</th>
							<th width="80">起始号码</th>
							<th width="80">终止号码</th>
							<th width="60">总张数</th>
							<th width="60">出库数</th>
							<th width="60">未出数</th>
							<th width="60">已用数</th>
							<th width="60">作废数</th>
							<th width="60">待用数</th>
							<th width="60">已交数</th>
							<th width="60">未交数</th>
							<th width="80">入库日期</th>
							<th>入库操作员</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${data.ivInvoices}" var="ivInvoice">
							<tr class="odd">
								<c:if test="${ivInvoice.invoiceType==0 }"><td>普通发票</td></c:if>
								<c:if test="${ivInvoice.invoiceType==1 }"><td>增值税发票</td></c:if>
								<td>${ivInvoice.startNo }</td>
								<td>${ivInvoice.endNo }</td>
								<td>${ivInvoice.counts }</td>
								<td>${ivInvoice.outInvoice }</td>
								<td>${ivInvoice.notOutInvoice }</td>
								<td>${ivInvoice.used }</td>
								<td>${ivInvoice.invalid }</td>
								<td>${ivInvoice.isUsed }</td>
								<td>${ivInvoice.archived }</td>
								<td>${ivInvoice.isArchived }</td>
								<td><fmt:formatDate value="${ivInvoice.inDate }"/></td>
								<td>${ivInvoice.empName }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="page">
					<a href="javascript:fpage(1)">第一页</a>
					<a href="javascript:fpage('-')">上一页</a>
					<input class="pageIndex" id="page" value="${data.pageClass.page}"/> / <input class="pageCount" id="pageCount" readonly="readonly" value="${data.pageClass.pageCount}" />
					<a href="javascript:fpage('+')">下一页</a>
					<a href="javascript:fpage('*')">第未页</a>
					
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

var fpage=function(fp){
	var page=$("#page").val();
	switch(fp){
		case 1:
			if(page>1){
				page=1;
				location.href="/SyProject/iv/inv_invoiceManage?page="+page;
			}else{
				return;
			}
			break;
		case '-':
			if(page>1){
				page=parseInt(page)-1;
				//alert("a:"+page);
				location.href="/SyProject/iv/inv_invoiceManage?page="+page;
			}else{
				return;
			}
			break;
		case '+':
			if(page<$("#pageCount").val()){
				page=parseInt(page)+1;
				location.href="/SyProject/iv/inv_invoiceManage?page="+page;
			}else{
				return;
			}
			break;
		case '*':
			if(page<$("#pageCount").val()){
				page=$("#pageCount").val();
				location.href="/SyProject/iv/inv_invoiceManage?page="+page;
			}else{
				return;
			}
			break;
	}
	
}
</script>

</body> 
 
</html>