<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 
 
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>湖南省自来水公司营销管理信息系统</title> 
	
	<%@ include file="/SY/page/linkDocuments.jsp"%>	

</head> 
 
<body> 

<div id="wrapper">	
	
	<%@include file="/SY/page/header.jsp"%>
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">发票入库</a></span>
			<span id="welcome_span">欢迎回来，${empLogin.empName}</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid">
		
 		<form action="/SyProject/iv/inv_invoiceIn" method="post">
		<div class="x12">
			
			<h2>发票入库</h2>
			
			<div class="form label-inline uniform">
	
				<div class="field"><label for="id">入库时间</label><input id="date" name="dateIn" size="50" type="text" class="medium" readonly="readonly" value="" /></div>
				
				<div class="field"><label for="name">入库人员</label> <input name="lname" size="50" type="text" class="medium" disabled="disabled" value="${empLogin.empName}" /></div>
				
				<div class="field"><label for="name">发票类型</label> <select class="medium" name="invoiceType">
						<option value="0">普通发票</option>
						<option value="1">增值税发票</option>
					</select></div>
				
				<div class="field"><label for="name">发票起始号码</label> <input name="startNo" size="50" type="text" class="medium" onchange="count()" id="stid"/></div>
				
				<div class="field"><label for="name">发票终止号码</label> <input name="endNo" size="50" type="text" class="medium" onchange="count()" id="etid"/></div>
				
				<div class="field"><label for="name">发票张数</label> <input id="ctid" name="counts" size="50" type="text" readonly="readonly" class="medium" value="填入发票号码后，动态显示" /></div>

				<div class="buttonrow">
				<input type="hidden" name="inEmpId" value="${empLogin.empId }"/>
					<button class="btn">保存</button>  
					<button class="btn btn-grey" onClick="history.back(-1);">返回</button>
				</div>

			</div>
			
		</div> <!-- .x12 -->
		</form>
	</div> <!-- #content -->
	
	<div id="footer">		
		<div class="content_pad">			
			<p>&copy; 2013-11 版权所有 <a href="#">湖南省自来水公司</a>.   技术支持 <a href="#">华瑞教育</a>.</p>
		</div> <!-- .content_pad -->
	</div> <!-- #footer -->
	
</div> <!-- #wrapper -->

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
	
	 var now=new Date();
	now.getFullYear();
	now.getMonth()+1;
	now.getDate();
	$("#date").val(now.getFullYear()+'-'+(now.getMonth()+1)+'-'+now.getDate());
	
}); 

var count=function(){
	var stid=parseInt($("#stid").val());
	var etid=parseInt($("#etid").val());
	if(stid<=etid&&stid!=null&&etid!=null){
		$("#ctid").val(etid-stid+1);
	}
}

</script>

</body> 
 
</html>