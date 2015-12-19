
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<title>湖南省自来水公司营销管理信息系统</title> 
	
	<%@include file="left.jsp" %>
	<style type="text/css">
	table.data thead th { vertical-align:middle; text-align:center; }
	</style>
</head> 
 
<body> 

<div id="wrapper">
	
	<%@include file="header.jsp" %>
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">快捷过户</a></span>
			<span id="welcome_span">欢迎回来，马云</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>快捷过户</h2>

			<div class="searchUserDiv">

				用户编码 <input id="userNo" />
				用户简码 <input id="abc" />
				用户姓名 <input id="userName"/>
				联系电话 <input id="phone"/>
				家庭住址 <input id="address"/>
				<button class="btn btn-small btn-icon btn-person" onclick="queryUsers();"><span></span>查询用户</button>

			</div>
			
			<br/><br/>
			
			
			
			<div class="form label-inline uniform">
				<h3 style="width:50%;">快捷过户</h3>
				<div class="field"><label for="id">用户编码</label> <input id="id" name="fname" size="50" type="text" class="medium" disabled="disabled" value="0100000987" /></div>
				
				<div class="field"><label for="name">原用户姓名</label> <input id="name" name="lname" size="50" type="text" class="medium" disabled="disabled" /></div>
				<div class="field"><label for="name">原联系电话</label> <input id="yPhone" name="lname" size="50" type="text" class="medium" disabled="disabled"  /></div>
				<div class="field"><label for="name">原短信电话</label> <input id="ySmsPhone" name="lname" size="50" type="text" class="medium" disabled="disabled" /></div>
				<div class="field"><label for="name">原联系地址</label> <input id="yAddress" name="lname" size="50" type="text" class="medium" disabled="disabled" /></div>
				
				
				
				<div class="field"><label for="name">新用户姓名</label> <input id="newName" name="lname" size="50" type="text" class="medium" value="" /></div>
				<div class="field"><label for="name">新联系电话</label> <input id="newPhone" name="lname" size="50" type="text" class="medium" value="" /></div>
				<div class="field"><label for="name">新短信电话</label> <input id="newSMSPhone" name="lname" size="50" type="text" class="medium" value="" /></div>
				<div class="field"><label for="name">新联系地址</label> <input id="newAddress" name="lname" size="50" type="text" class="medium" value="" /></div>
				

				<div class="buttonrow">
					<button class="btn" onclick="updateUser()">过户</button>
				</div>

			</div>
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<div id="footer">		
		<div class="content_pad">			
			<p>&copy; 2015 版权所有 <a href="#">湖南省自来水公司</a>.   技术支持 <a href="#">华瑞教育</a>.</p>
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
<script type="text/javascript" src="../js_2/js_2.js"></script>
<script type="text/javascript">
	
$(document).ready ( function () 
{
	Dashboard.init ();
	//读取登录员工信息
	readEmp();
});


</script>

</body> 
 
</html>
