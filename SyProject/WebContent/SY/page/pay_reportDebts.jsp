<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 	prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>湖南省自来水公司营销管理信息系统</title> 
	
	<%@include file="linkDocuments.jsp" %>
	
	<style type="text/css">
	#volumeDiv { border:4px solid #ccc; background-color:#fff; 
	margin:34px 60px; position:absolute; width:640px; } 
	#volumeDiv .header{ background-color:#CCCCCC; font-size:18px; font-weight:bold; 
	text-align:center; padding:4px; color:#FFFFFF; }
	.controlset span.label { text-align:left; }
	</style>
	<%@include file="jQuery.jsp" %>
	<script type="text/javascript">
	function showVolumeDiv(){
			$('#volumeDiv').toggle();
	}

	
	
	$(function(){
		$("#volumeAll").click(function(){ //所有表册
			if($("#volumeAll").attr("checked")){
				var volumes= document.getElementsByName("volume");
				for (var i = 0; i < volumes.length; i++) {
					volumes[i].checked="checked";
				}
			}else{
				var volumes= document.getElementsByName("volume");
				for (var i = 0; i < volumes.length; i++) {
					volumes[i].checked="false";
				}
			}
		});
		
 	});
	</script>
</head> 
 
<body> 

<div id="wrapper">
	
	<%@include file="header.jsp" %>
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">欠费报表</a></span>
			<span id="welcome_span">欢迎回来，${empLogin.empName }</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>用户欠费情况查询</h2>
			
			<form action="/SyProject/report/reportDebts" name="frm" method="post">
			<div id="volumeDiv" class="form label-inline uniform" style="display:none;">
				 <c:forEach var="a" items="${map['areas'] }">
				 	<div class="portlet x2">
						<div class="controlset field">
							<span class="label">${a.areaName }</span>
							
							<div class="controlset-pad">
								<c:forEach var="v" items="${map['volumes'] }">
									<c:if test="${a.areaId == v.areaId }">
										<input type="checkbox" name="volume" id="volume${v.id }" value="${v.id }"/> 
										<label for="volume${v.id }">${v.volumeName }</label><br />
									</c:if>
								</c:forEach>
							</div>
						</div>
					</div>
				 </c:forEach>
			</div>
			
			<div class="searchDiv">
				起始年月 <select class="medium" name="payDateBefore">
							<c:forEach var="m" items="${map['dateMonths'] }">
								<option value="${m }" 
								<c:if test="${map['dto'].payDateBefore ==m}">selected="selected"</c:if> >${m }</option>
							</c:forEach>
						 </select>
						 
				截止年月 <select class="medium" name="payDateAfter">
							<c:forEach var="m" items="${map['dateMonths'] }">
								<option value="${m }" 
								<c:if test="${map['dto'].payDateAfter ==m}">selected="selected"</c:if>>${m }</option>
							</c:forEach>
						 </select>
						 
				表册 <input type="button" value="选择表册" style="background-color:#F8F8F8;" onClick="showVolumeDiv();" />
					
				排列 <select class="medium" name="orderStr">
							<option value="user_no"  
								<c:if test="${map['dto'].orderStr == 'user_no' }">selected="selected"</c:if>
							 >按用户编码</option>
							<option value="bill_money"  
								<c:if test="${map['dto'].orderStr == 'bill_money' }">selected="selected"</c:if>
							 >按欠费金额</option>
						 </select>
				<button class="btn btn-small btn-icon btn-find"  ><span></span>查询</button>
			</div>
			</form>
			
			<div class="reportTitle">
				
				${map['dto'].payDateBefore }至 ${map['dto'].payDateAfter } 用户欠费情况
			</div>	
			<div class="height24">
				<div style="float:left;width:300px;">总应收水费：${map['billmoneys'] } 元</div>
				<div style="float:left;">总已收水费：${map['realmoneys'] } 元</div>
				<div style="float:right;font-weight:bold;">总欠费金额：${map['billmoneys']-map['realmoneys'] } 元</div>
			</div>
			<table class="report">
				<thead>
					<tr>
						<th width="100">用户编码</th>
						<th>用户姓名</th>
						<th width="150">水费单号</th>
						<th width="80">上月底数</th>
						<th width="80">本月抄数</th>
						<th width="80">实用水量</th>
						<th width="100">应收水费</th>
						<th width="100">已收水费</th>
						<th width="100">未收水费</th>
					</tr>
				</thead>
				<tbody>
						<c:forEach var="b" items="${map['bills'] }">
							<tr>
								<td class="center">${b.user.userNo }</td>
								<td class="left">${b.user.userName }</td>
								<td class="center">${b.billNo }</td>
								<td class="right">${b.read.preValue }</td>
								<td class="right">${b.read.curValue }</td>
								<td class="right">${b.read.curValue - b.read.preValue  }吨</td>
								<td class="right">${b.billMoney } 元</td>
								<td class="right">${b.realMoney } 元</td>
								<td class="right">${b.billMoney.subtract(b.realMoney) }元</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
 				 <div class="page">
					<a href="javascript:up(2,${map['dto'].pageCount })">第一页</a>
					<a href="javascript:up(${map['dto'].page },${map['dto'].pageCount })">上一页</a>
					<!-- 存放当前的页面 -->
					<input class="pageIndex"  value="${map['dto'].page }"/> / <input class="pageCount" readonly="readonly" value="${map['dto'].pageCount }" />
					<a href="javascript:down(${map['dto'].page },${map['dto'].pageCount })">下一页</a>
					<a href="javascript:down(${map['dto'].pageCount-1 },${map['dto'].pageCount })">第未页</a>
				</div>
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<div id="footer">		
		<div class="content_pad">			
			<p>&copy; 2013-11 版权所有 <a href="#">湖南省自来水公司</a>.   技术支持 <a href="#">华瑞教育</a>.</p>
		</div> <!-- .content_pad -->
	</div> <!-- #footer -->
	
</div> <!-- #wrapper -->

<c:forEach var="v" items="${map['dto'].volume }">
	<!-- <script type="text/javascript">
		setTimeout("backload(${v})", 300);
	</script> -->
</c:forEach>

<script type="text/javascript">
	window.backload=function(id){
		document.getElementById("volume"+id).checked="checked";
	}

	window.up=function(currPage,row){
	 if(currPage<=1){
		return;
	 }
	 window.frm.action="/SyProject/report/reportDebts?page="+(--currPage);
	window.frm.submit();
	}
		
	window.down=function(currPage,row){
		 if(currPage>=row){
			return;
		 }
		window.frm.action="/SyProject/report/reportDebts?page="+(++currPage);
		window.frm.submit();
	}
</script>


<%@include file="jQuery.jsp" %>

<script type="text/javascript">
	
$(document).ready ( function () 
{
	Dashboard.init ();
	
});


</script>

</body> 
 
</html>