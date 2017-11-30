<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>湖南省自来水公司营销管理信息系统</title>
	<%@include file="left.jsp" %>
<script type="text/javascript">
var mysubmitDept1 = function(){
	 if ($("#Name").val() == "") {
		document.getElementById("Name1").style.display="inline";
		document.getElementById("Name1").innerHTML = "部门名称不能为空";
		return false;
	}else{
		document.getElementById("Name1").style.display="none";
	}
	if ($("#Remark").val() == "") {
		document.getElementById("Remark1").style.display="inline";
		document.getElementById("Remark1").innerHTML = "备注不能为空";
		return false;
	}else{
		document.getElementById("Remark1").style.display="none";
	}
	document.frm.submit();
};
</script>
</head> 
 
<body> 

<div id="wrapper">
	<%@include file="header.jsp" %>
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">部门设置</a></span>
			<span id="welcome_span">欢迎回来，${empLogin.empName}</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid">
		
 		<form name="frm" action="/SyProject/sy/saveDept" method="post">
				<input type="hidden" name="deptDisabled" value="0" />
		<div class="x12">
			<h2>添加/修改部门</h2>
			<div class="form label-inline uniform">
	
				<div class="field"><label for="id">部门ID</label> <input id="id" name="fname" size="50" type="text" class="medium" disabled="disabled" value="自动生成" /></div>
				<div class="field"><label for="name">部门名称</label> <input id="Name" onblur="mysubmitDept1()" name="deptName" size="50" type="text" class="medium" /><span id="Name1" style="display: none; color: red"></span></div>
				<div class="field"><label for="description">备注</label> <textarea rows="7" cols="50" id="Remark" name="deptRemark"></textarea><span id="Remark1" style="display: none; color: red"></span></div>
				<div class="buttonrow">
					<input type="button" class="btn" value="保存" onclick="return mysubmitDept1()"/>
					<input type="button" class="btn btn-grey" value="返回" onclick="history.back(-1);"/>
				</div>
			</div>
		</div> <!-- .x12 -->
		</form>
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