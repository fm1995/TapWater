<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>湖南省自来水公司营销管理信息系统</title>
<%@include file="left.jsp" %>
<script type="text/javascript">
	 var deleteDept=function(id){
		 if(confirm("确定删除吗？"))
		 {
			 location.href=" /SyProject/sy/deleteDept?id="+id;
		 }
		 
	 };

</script>
</head>
<body>
		<div id="wrapper">
		<%@include file="header.jsp" %>
		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">部门设置</a></span> <span
					id="welcome_span">欢迎回来，${empLogin.empName}</span>
			</div>
		</div><!-- #masthead -->
		<div id="content" class="xgrid">
		<div class="x12">
			<h2>部门设置</h2>
			
			<p><button class="btn-icon btn-plus" onClick="location='/SyProject/SY/page/sys_dept_add.jsp';"><span></span>添加部门</button></p>
				
			<table class="data display">
					<thead>
						<tr>
							<th>部门ID</th>
							<th>部门名称</th>
							<th>备注</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listDept}" var="li">
						<tr class="odd gradeA">
							<td>${li.deptId}</td>
							<td>${li.deptName}</td>
							<td>${li.deptRemark}</td>
							<td class="center">
								<button class="btn-icon btn-small btn-blue btn-star"
									onClick="location='/SyProject/sy/queryOneDept?deptId=${li.deptId}'">
									<span></span>修改
								</button>
								<button class="btn-icon btn-small btn-red btn-cross"
									onClick="deleteDept(${li.deptId})">
									<span></span>删除
								</button>
							</td>
						</tr>
						</c:forEach>
						</tbody>
					</table>
			
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