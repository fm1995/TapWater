<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>湖南省自来水公司营销管理信息系统</title>
	<%@include file="left.jsp" %>
</head> 
 <script type="text/javascript">
	 var deleteMeter=function(id){
		 if(confirm("确定删除吗？"))
		 {
			 location.href="/SyProject/sy/deleteMeter?id="+id;
		 }
		 
	 };

</script>
<body> 

<div id="wrapper">
	<%@include  file="header.jsp" %>
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">水表型号设置</a></span>
			<span id="welcome_span">欢迎回来，${empLogin.empName}</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid">
		
		<div class="x12">
			<h2>水表型号设置</h2>
			
			<p><button class="btn-icon btn-plus" onClick="location='/SyProject/SY/page/sys_meterType_add.jsp';"><span></span>添加水表型号</button></p>
				
			<table class="data display">
					<thead>
						<tr>
							<th>水表型号ID</th>
							<th>水表型号</th>
							<th>设备口径</th>
							<th>最大表码</th>
							<th>下限设置</th>
							<th>周检年限</th>
							<th>备注</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${list}" var="li">
						<tr class="odd gradeA">
							<td>${li.metertypeId}</td>
							<td>${li.meterTypeName}</td>
							<td>${li.metertypeAperture}</td>
							<td>${li.metertypeMaxValue}</td>
							<td>${li.metertypeMinValue}</td>
							<td>${li.metertypeLife}</td>
							<td>${li.metertypeRemark}</td>
							<td class="center">
								<button class="btn-icon btn-small btn-blue btn-star" onClick="location='/SyProject/sy/queryOneMeter?typeId=${li.metertypeId}'"><span></span>修改</button>
								<button class="btn-icon btn-small btn-red btn-cross"
									onClick="deleteMeter(${li.metertypeId})">
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