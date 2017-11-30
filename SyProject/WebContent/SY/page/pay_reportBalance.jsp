<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>湖南省自来水公司营销管理信息系统</title> 
	 
	<%@include file="linkDocuments.jsp" %>
	<%@include file="jQuery.jsp" %>
</head> 
 
<body> 

<div id="wrapper">
	
	<%@include file="header.jsp" %>
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">用户预收费情况报表</a></span>
			<span id="welcome_span">欢迎回来，${empLogin.empName }</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>用户预收费情况报表</h2>
			
			<div class="searchDiv">
				<div style="float:left;">预收金额大于 <!-- 隐藏的携带上次的数据 -->
					 <input type="hidden" id="userMoney" value="${map['userMoney'] }" />
					 <input  id="userTrueMoney"  value="${map['userMoney'] }" /> 
				</div>
				
				<button class="btn btn-small btn-icon btn-find" onclick="tj()"><span></span>查询</button>
			</div>
			
			<div class="reportTitle">
				用户预收费情况报表
			</div>	
			<div class="height24">
				<div style="float:left;width:160px;">总户数：${map['total'] } 户</div>
				<div style="float:left;">总预收金额：${map['moneys'] } 元</div>
			</div>
			<table class="report">
				<thead>
					<tr>
						<th width="100">用户编码</th>
						<th width="100">预收金额</th>
						<th width="140">用户姓名</th>
						<th width="360">用户地址</th>
						<th>联系电话</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="u" items="${map['rows']}">
						<tr>
							<td class="center">${u.userNo }</td>
							<td class="right">${u.userMoney } 元</td>
							<td class="left">${u.userName }</td>
							<td class="left">${u.address }</td>
							<td class="left">${u.phone }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="page">
				<a href="javascript:up(2,${map['pageCount'] })">第一页</a>
				<a href="javascript:up(${map['page'] },${map['pageCount'] })">上一页</a>
				<!-- 存放当前的页面 -->
				<input   type="hidden"  id="page" name="page" value="${map['page'] }">
				<input class="pageIndex"  value="${map['page'] }"/> / <input class="pageCount" readonly="readonly" value="${map['pageCount'] }" />
				<a href="javascript:down(${map['page'] },${map['pageCount'] })">下一页</a>
				<a href="javascript:down(${map['pageCount']-1 },${map['pageCount'] })">第未页</a>
			</div>
		</div> <!-- .x12 -->
	</div> <!-- #content -->
	
	<div id="footer">		
		<div class="content_pad">			
			<p>&copy; 2013-11 版权所有 <a href="#">湖南省自来水公司</a>.   技术支持 <a href="#">华瑞教育</a>.</p>
		</div> <!-- .content_pad -->
	</div> <!-- #footer -->
	
</div> <!-- #wrapper -->



<script type="text/javascript">
	window.up=function(currPage,row){
	 if(currPage<=1){
		return;
	 }
	var money=document.getElementById("userMoney").value;
	 location.href="/SyProject/report/yushou?page="+(--currPage)+"&userMoney="+money;
	}
		
	window.down=function(currPage,row){
		 if(currPage>=row){
			return;
		 }
		var money=document.getElementById("userMoney").value;
		location.href="/SyProject/report/yushou?page="+(++currPage)+"&userMoney="+money;
	}
</script>



<script type="text/javascript">
	
$(document).ready(function()
{
	Dashboard.init ();
});


function tj(){
	var userMoney=document.getElementById("userTrueMoney").value;
	location.href="/SyProject/report/yushou?userMoney="+userMoney;
}
</script>

</body> 
 
</html>