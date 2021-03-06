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
	<script src="/SyProject/SY/js/jquery/jquery-ui-1.8.12.custom.min.js"></script>
	
	<style type="text/css">
	table.report th,table.report td { padding:10px; font-size:14px; }
	</style>
<script type="text/javascript">
$(function(){
	$("#selBtn").click(function(){ //查询当前选中的时间的报表
		var year=$("#year").val();
		//$.messageer.progress({title:"提示",msg:"文本内容",text:"正在加载",interval:200});
		 location.href="/SyProject/report/tongji?typee=1&year="+year;
	});	
	$("#testBtn").click(function(){//计算当前选中的时间的报表
		var year=$("#year").val();
		$.post("/SyProject/report/tongjiJisuan",
				{"typee":1,"year":year},
			function(x){
				if(x=='ok')
					alert('计算成功');			
		});
	});	
});


</script>
</head> 
 
<body> 

<div id="wrapper">
	
	<%@include file="header.jsp" %>
	
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">各类用水统计总表</a></span>
			<span id="welcome_span">欢迎回来，${empLogin.empName }</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>
				各类用水统计总表
				<div style="float:right;">
					<a href="/SyProject/report/tongji?typee=0">按月份统计</a>
					<span style="color:#0000FF;">按年份统计</span>
					
				</div>
			</h2>
			
			<div class="searchDiv">
				<div style="float:left;">
					统计年份 <select name="year" id="year">
						 <c:forEach var="y" begin="${map['year']-5 }" end="${map['year'] }" step="1">
							<option value="${y }"
							<c:if test="${map['dto'].year ==y}">selected="selected"</c:if>
							>${y }年</option>
						 </c:forEach>
					</select>
				</div>
				
				<button id="selBtn" class="btn btn-small btn-icon btn-find"><span></span>查询</button>
				<button id="testBtn" class="btn btn-small btn-icon btn-star btn-blue"><span></span>计算</button>
			</div>
			
			<div>
				<div class="reportTitle">
					${map['year'] }年各类用水统计总表
				</div>	
				<table class="report">
					<thead>
						<tr>
							<th width="60">序号</th>
							<th width="300">用水类型</th>
							<th width="140">水量</th>
							<th width="140">水价</th>
							<th width="180">水费</th>
							<th width="140">占比</th>
						</tr>
					</thead>
					<tbody>
						 <c:forEach var="t" items="${map['datas'] }">
							<tr>
								<td class="center">${t.lineNo}</td>
								<td class="left">${t.c1 }</td>
								<td class="right">${t.c2 }</td>
								<td class="right">${t.c3 }</td>
								<td class="right">${t.c4 }</td>
								<td class="right">${t.c5 }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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
	
$(document).ready ( function () 
{
	Dashboard.init ();
	
});


</script>

</body> 
</html>
 