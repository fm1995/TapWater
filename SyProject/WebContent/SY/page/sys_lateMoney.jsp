<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>湖南省自来水公司营销管理信息系统</title>
	<%@include file="left.jsp" %>
</head> 
 
<body> 

<div id="wrapper">
	<%@include file="header.jsp" %>
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">违约金设定</a></span>
			<span id="welcome_span">欢迎回来，${empLogin.empName}</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid">
		
 		
		<div class="x12">
			
			<h2>违约金设定</h2>
			
			<div class="form label-inline uniform">
	
				
				<div class="field"><label for="name">违约金利率</label> <input id="name" name="lname" size="50" type="text" class="medium" value="0.005" /> 如果是5‰则输入0.005</div>

				
				<br/><br/><br/><br/><br/><br/>

				<div class="buttonrow">
					<button class="btn">保存</button>  
					<button class="btn btn-grey" onClick="history.back(-1);">返回</button>
				</div>
				
				<br/><br/><br/><br/><br/><br/>
				<br/><br/><br/><br/><br/><br/>

			</div>
			
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<div id="footer">		
		<div class="content_pad">			
			<p>&copy; 2015 版权所有 <a href="#">湖南省自来水公司</a>.   技术支持 <a href="#">华瑞教育</a>.</p>
		</div> <!-- .content_pad -->
	</div> <!-- #footer -->
	
</div> <!-- #wrapper -->
<%@include file="jQuery.jsp" %>

<script type="text/javascript">
	
$(document).ready ( function () 
{
	Dashboard.init ();		
});

</script>

</body> 
 
</html>