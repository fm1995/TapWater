<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>湖南省自来水公司营销管理信息系统</title> 
	
	<link rel="stylesheet" href="/TapWater/sy/css/reset.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/TapWater/sy/css/text.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/TapWater/sy/css/form.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/TapWater/sy/css/buttons.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/TapWater/sy/css/grid.css" type="text/css" media="screen" title="no title" />	
	<link rel="stylesheet" href="/TapWater/sy/css/layout.css" type="text/css" media="screen" title="no title" />	
	
	<link rel="stylesheet" href="/TapWater/sy/css/ui-darkness/jquery-ui-1.8.12.custom.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/TapWater/sy/css/plugin/jquery.visualize.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/TapWater/sy/css/plugin/facebox.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/TapWater/sy/css/plugin/uniform.default.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/TapWater/sy/css/plugin/dataTables.css" type="text/css" media="screen" title="no title" />
	
	<link rel="stylesheet" href="/TapWater/sy/css/custom.css" type="text/css" media="screen" title="no title">
	<%@ include file="jquery.jsp" %>
	<script type="text/javascript" src="/TapWater/sy/myJs/rd_reportZero.js"></script>
</head> 
 
<body> 

<div id="wrapper">
	
	<%@include file="../header.jsp" %>
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">零吨位用户查询</a></span>
			<span id="welcome_span">欢迎回来，马云</span>
		</div>
	</div> <!-- #masthead -->	
	<input type="hidden" id="pageSize" value="1">
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>零吨位用户查询</h2>
			<div class="searchDiv">
				抄表年月 
				<span class="between">
				<select class="medium" id="startTime">
						 </select>
				-
				<select class="medium" id="endTime">
						 </select>
				</span>
				
				表册 <select class="medium" id="volumeId">
							<option value="0" selected="selected">所有</option>
							<c:forEach items="${areas}" var="area">
								<optgroup label="${area.areaName }">
								<c:forEach items="${volumes }" var="volume">
								<c:if test="${area.areaId==volume.areaId }">
									<option value="${volume.id}">${volume.volumeName }</option>
								</c:if>
								</c:forEach>
								</optgroup>
							</c:forEach>
					</select>

				是否复核 <select class="medium" id="audit" >
							<option value="0">是</option>
							<option value="1">否</option>
						 </select>
				
				<button class="btn btn-small btn-icon btn-find" onclick="sel(1)"><span></span>查询</button>
			</div>
			
			
			<div class="reportTitle">
				零吨位用户情况报表
			</div>	
			<div class="height24">
				<div style="float:left;width:250px;">抄表年月：<span id="year"></span></div>
				<div style="float:left;width:200px;">表册：<span id="volumeText">所有</span></div>
				<div style="float:left;width:200px;">总用户数：<span id="userCount">0</span>户</div>
			</div>
			<table class="report" id="table">
				<thead>
					<tr>
						<th width="100">用户编码</th>
						<th>用户姓名</th>
						<th width="100">上月底数</th>
						<th width="100">本月抄数</th>
						<th width="100">实用水量</th>
						<th width="60">是否复核</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="center">0100000987</td>
						<td class="">张三</td>
						<td class="right">1034</td>
						<td class="right">1034</td>
						<td class="right">0</td>
						<td class="center">是</td>
					</tr>
				</tbody>
				</table>
				<div class="page">
					<a href="javaScript:nuPage(-2)">第一页</a>
					<a href="javaScript:nuPage(-1)">上一页</a>
					<input id="page" class="pageIndex" value="1"/> / <input class="pageCount" id="pageCount" readonly="readonly" value="${pageCount}" />
					<a href="javaScript:nuPage(1)">下一页</a>
					<a href="javaScript:nuPage(-3)">第未页</a>
				</div>
				
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
	
$(document).ready ( function () 
{
	Dashboard.init ();
	
});


</script>

</body> 
 
</html>