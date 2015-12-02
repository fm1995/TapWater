<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 
 
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>湖南省自来水公司营销管理信息系统</title> 
	
	<%@include file="/sy/style.jsp" %>
	
	<script type="text/javascript">
		window.fsubmit =function(){
			var mth=document.getElementById("month").value;
			location.href="/TapWater/report/monthRecycle?month="+mth;
		}
	
		//月份的回显
		window.loadSel=function(mth){
			var mSel=document.getElementById("month");
			for (var i = 0; i < mSel.options.length; i++) {
				if(mSel.options[i].value==mth){
					mSel.options[i].selected=true;
					return;
				}
			}
		}
		setTimeout("loadSel(${map['mth']})", 200);
	</script>
</head> 
 
<body> 

<div id="wrapper">
	
	<%@include file="/sy/header.jsp" %>
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">月资金回收情况报表</a></span>
			<span id="welcome_span">欢迎回来，马云</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>月资金回收情况报表</h2>
			
			<div class="searchDiv">
				
				选择月份 <select class="medium" id="month">
							<c:forEach var="m" items="${map['months'] }">
								<option value="${m }" 
									<c:if test="${mth eq m }">selected="selected"</c:if>
								>${m }</option>
							</c:forEach>
						 </select>
						
				<button class="btn btn-small btn-icon btn-find"  onclick="fsubmit()"><span></span>查询</button>
			</div>
			
			<div class="reportTitle">
				月资金回收情况报表
			</div>	
			<table class="report">
				<thead>
					<tr>
						<th width="100">年月</th>
						<th width="120">总吨位</th>
						<th width="120">总应收</th>
						<th width="120">总实收</th>
						<th width="120">下欠</th>
						<th width="80">回收率</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="center">${map['month'] }</td>
						<td class="right">${map['amounts'] }吨</td>
						<td class="right">${map['billMoneys'] }元</td>
						<td class="right">${map['realMoneys'] }元</td>
						<td class="right">${map['nextMoneys'] } 元</td>
						<td class="right">${map[''] }%</td>
						<td>&nbsp;</td>
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
<script src="../My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
$(document).ready(function() 
{
	Dashboard.init ();
});


</script>

</body> 
 
</html>