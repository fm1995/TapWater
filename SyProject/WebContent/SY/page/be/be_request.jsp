<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE jsp PUBLIC "-//W3C//DTD jsp 4.01 Transitional//EN" "http://www.w3.org/TR/jsp4/loose.dtd">
 <html>
<head> 
	<title>湖南省自来水公司营销管理信息系统</title> 
	
	<%@include file="/SY/page/linkDocuments.jsp" %>
	
	<style type="text/css">
	a.metro {
		float:left; margin:4px 16px; font-size:20px; font-weight:bold;
		color:#FFFFFF;background-color:#666666;text-align:center;
	    line-height:100px;display:block;width:200px; vertical-align:middle;
	}
	a.metro:hover{
		background-color:#000033; text-decoration:none;
	}
	</style>
</head> 
 
<body> 

<div id="wrapper">
	
		<%@include file="/SY/page/header.jsp"%>
	
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">用户申请</a></span>
			<span id="welcome_span">欢迎回来，马云</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid">
		
 		
		<div class="x12">
			
			<h2>用户申请</h2>
			
			<a class="metro" href="be_request1.jsp">新户</a>
			<a class="metro" href="be_request2.jsp">分户</a>
			<a class="metro" href="be_request3.jsp">过户</a>
			<a class="metro" href="be_request4.jsp">代扣</a>
			<a class="metro" href="be_request5.jsp">换表</a>
			<a class="metro" href="be_request6.jsp">重签</a>
			<a class="metro" href="be_request7.jsp">销户</a>
			<a class="metro" href="be_requestOrder.jsp">工单</a>
			
			
			
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