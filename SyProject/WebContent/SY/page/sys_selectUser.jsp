<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>选择用户</title> 
	
	<%@include file="jQuery.jsp" %>
	<%@include file="left.jsp" %>
	<%@include file="linkDocuments.jsp" %>
	
<script type="text/javascript">
	function ok(no){
		//模拟返回数据
		// returnWindow({id:'0100000987', name:'张三', abc:'zs'
		 //	, tel:'13012345678', addr:'新开发区国际IT中心华瑞国际总部办公楼'});
		 returnWindow(no);
		
		//window.returnValue=no;
		parent.close(); //简单的处理
	}
</script>
</head> 
<body> 

<div style="width:90%; margin:0 auto;">
	<br/>
	<h2>选择用户</h2>
	

	<table class="data display">
		<thead>
			<tr>
				<th>用户编码</th>
				<th>用户姓名</th>
				<th>简码</th>
				<th>电话</th>
				<th>地址</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="u" items="${map['users'] }">
				<tr class="odd">
					<td><a href="javascript:;" onClick="ok('${u.userNo }');">${u.userNo }</a></td>
					<td><a href="javascript:;" onClick="ok('${u.userNo }');">${u.userName }</a></td>
					<td>${u.abc }</td>
					<td>${u.phone }</td>
					<td>${u.address }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

<div style="margin-right:20px;">			
	<div class="page">
		<a href="javascript:up(2,${map['pageCount'] })">第一页</a>
		<a href="javascript:up(${map['page'] },${map['pageCount'] })">上一页</a>
		<input class="pageIndex" readonly="readonly" value="${map['page'] }"/> / <input class="pageCount" readonly="readonly" value="${map['pageCount'] }"  />
		<a href="javascript:down(${map['page'] },${map['pageCount'] })">下一页</a>
		<a href="javascript:down(${map['pageCount']-1 },${map['pageCount'] })">第未页</a>
	</div>
</div>
</div>

<script type="text/javascript">
	window.up=function(currPage,pageCount){
	 if(currPage<=1){
		return;
	 }
	 location.href="/SyProject/paywindow/selectUserPage?page="+(--currPage)+"&pageCount="+pageCount;
	}
		
	window.down=function(currPage,pageCount){
		 if(currPage>=pageCount){
			return;
		 }
		  location.href="/SyProject/paywindow/selectUserPage?page="+(++currPage)+"&pageCount="+pageCount;
	}
	 
	
<% 
	request.getSession().removeAttribute("map");
%>
</script>

</body> 
 
</html>