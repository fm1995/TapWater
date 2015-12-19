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
			 location.href="/SyProject/sy/deleteEmp?empId="+id;
		 }
		 
	 };
	 var selectId=function()
	 {
		 var id=document.getElementById("type").value;
		 location.href="/SyProject/sy/querySyEmp?empId="+id;
	 }

</script>
</head> 
 
<body> 

<div id="wrapper">
		<%@include file="header.jsp" %>
		<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">员工设置</a></span>
			<span id="welcome_span">欢迎回来，${empLogin.empName}</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid">
	 		
		<div class="x12">
			<h2>员工设置</h2>
			
			
	<p>
			<div style="float:left;">
				<button class="btn-icon btn-plus" onClick="location='/SyProject/SY/page/sys_emp_add.jsp';"><span></span>添加员工</button>
			</div>
			<div style="float:right;">
				部门 
				<select id="type" class="medium" onchange="selectId()" >
						<option value="0">所有部门</option>
						<c:forEach items="${syDept}" var="sy">
						<c:if test="${empId eq sy.deptId}">
						<option value="${sy.deptId}"selected="selected">${sy.deptName}</option>
						</c:if>
						<c:if test="${empId ne sy.deptId}">
						<option value="${sy.deptId}">${sy.deptName}</option>
						</c:if>
						</c:forEach>
				</select>
			</div>
				</p>
			<table class="data display datatable">
					<thead>
						<tr>
							<th>员工ID</th>
							<th>员工工号</th>
							<th>员工姓名</th>
							<th>所属部门</th>
							<th>备注</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${syEmp}" var="emp">
						<tr class="odd gradeX">
							<td>${emp.empId}</td>
							<td>${emp.empNo}</td>
							<td>${emp.empName}</td>
							<td>${emp.syDept.deptName}</td>
							<td>${emp.empRemark}</td>
							<td class="center">
							<button class="btn-icon btn-small btn-blue btn-star" onClick="location='/SyProject/sy/queryOneEmp?empId=${emp.empId}'"><span></span>修改</button>
								<button class="btn-icon btn-small btn-red btn-cross"
									onClick="deleteDept(${emp.empId})">
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
			<p>&copy; 2015版权所有 <a href="#">湖南省自来水公司</a>.   技术支持 <a href="#">华瑞教育</a>.</p>
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