<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 
 <%@include file="/sy/style.jsp" %>
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>湖南省自来水公司营销管理信息系统</title> 
	
	<%@include file="../style.jsp" %>
	<style type="text/css">
	table.data thead th { vertical-align:middle; text-align:center; }
	.tab_content { min-height:220px; }
	</style>
	<script type="text/javascript">
	 
	//查询用户
$(function(){
	$("#btnSel").click(function(){

		var args = {
				"userNo":$("input[name=userNo]").val(),
				"abc": $("input[name=abc]").val(),		
				"smsPhone": $("input[name=smsPhone]").val(),		
				"phone": $("input[name=phone]").val(),		
				"docNum": $("input[name=docNum]").val(),		
				"userName": $("input[name=userName]").val(),		
				"address": $("input[name=address]").val(),		
				"userMoney": 200		
		};
		$.post("/TapWater/paywindow/selectUser",args,function(x){
			var no=showWindow({url:'/TapWater/sy/page/sys_selectUser.jsp'});
			if(no==undefined)
				return ;
			location.href="/TapWater/paydetails/selectUserByUserNo?userNo="+no;
		}); 
		
	});
	
});
	//显示抄表详情
	function showReadingDetail(){
		showWindow({url:'../page/user_search1_readingDetail.html', width:500, height:400});
	}
	
	//显示水费单详情
	function showBillDetail(){
		showWindow({url:'../page/user_search1_billDetail.html', width:600, height:500});
	}

	</script>
<script type="text/javascript">
$(function(){
	window.ajaxLoad=function(){
	
	}
	window.ajaxLoadPays=function(){
		var userId=$("#userIdt").val();
		var args={
			"userNo":userId
		};
		$.post("",args,function(x){
			
		});
	}
});
</script>	
</head> 
 
<body onload="ajaxLoad()"> 
	<input id="userIdt" value="0100000459">
<div id="wrapper">
	
	<%@include file="../header.jsp" %>
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">用户查询</a></span>
			<span id="welcome_span">欢迎回来，马云</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>用户查询</h2>
			
			<div class="searchUserDiv">
				用户编码 <input name="userNo"  value="${user.userNo }" />
				用户简码 <input  name="abc" value="${user.abc }"  />
				用户姓名 <input  name="userName" value="${user.userName }"/>
				联系电话 <input  name="phone" value="${user.phone }" />
				家庭住址 <input name="address" value="${user.address }" />
				<button class="btn btn-small btn-icon btn-person"  id="btnSel"
					><span></span>查询用户</button>
			</div>
			
			<div class="tab_container">
				<ul class="tabs"> 
					<li><a href="#tab1">基本信息</a></li> 
					<li><a href="#tab2">水价信息</a></li> 
					<li><a href="#tab3">抄表信息</a></li> 
					<li><a href="#tab4">水费单记录</a></li> 
					<li><a href="#tab5">收费单记录</a></li> 
				</ul> 
				<div class="tab_content_container"> 
					<div id="tab1" class="tab_content">
<!-- 基本信息 -->
						
<div class="x12">	
	<h3>用户基本信息</h3>
	
	<table width="100%">
	<thead>
		<tr>
			<th width="60"></th>
			<th width="220"></th>
			<th width="60"></th>
			<th width="220"></th>
			<th width="60"></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>用户编码</td>
			<td><input readonly="readonly" value="${user.userNo }" /></td>
			<td>用户类型</td>
			<td><input readonly="readonly" value="${user.userType }" /></td>
			<td>所属辖区</td>
			<td><input readonly="readonly" value="${user.areaId }" /></td>
		</tr>
		<tr>
			<td>用户名称</td>
			<td><input readonly="readonly" value="${user.userName }" /></td>
			<td>开户时间</td>
			<td><input readonly="readonly" value="${user.createDate }" /></td>
			<td>收款方式</td>
			<td><input readonly="readonly" value="${user.payType }" /></td>
		</tr>
		<tr>
			<td>联系电话</td>
			<td><input readonly="readonly" value="${user.phone }" /></td>
			<td>开户银行</td>
			<td><input readonly="readonly" value="${user.bankName }" /></td>
			<td>银行账号</td>
			<td><input readonly="readonly" value="${user.bankNum }" /></td>
		</tr>
		<tr>
			<td>短信电话</td>
			<td><input readonly="readonly" value="${user.smsPhone }" /></td>
			<td>用户地址</td>
			<td colspan="3"><input size="68" readonly="readonly" 
								value="${user.address }" /></td>
		</tr>
		<tr>
			<td>档案编号</td>
			<td><input readonly="readonly" value="${user.docNum }" /></td>
			<td>合同编号</td>
			<td><input readonly="readonly" value="${user.contractNum }" /></td>
			<td>签订日期</td>
			<td><input readonly="readonly" value="${user.contractDate }" /></td>
		</tr>
		<tr>
			<td>提比提量</td>
			<td><input readonly="readonly" value="${user.formula }" /></td>
			<td>用户余额</td>
			<td>
				<c:if test="${user.userMoney < 0}"><input readonly="readonly" class="right" value="0.00" /></c:if>
				<c:if test="${user.userMoney >= 0 || user.userMoney==null}"><input readonly="readonly" class="right" value="${user.userMoney }" /></c:if>
			元</td>
			<td>用户欠款</td>
			<td>
				<c:if test="${user.userMoney <= 0  || user.userMoney==null}"><input readonly="readonly" class="right" value="${user.userMoney }" /></c:if>
				<c:if test="${user.userMoney > 0 }"><input readonly="readonly" class="right" value="0.00" /></c:if>
			元</td>
		</tr>
	</tbody>
	</table>
	
	<br/><br/><br/>
	<h3>用户表册信息</h3>
	
	<table width="100%">
	<thead>
		<tr>
			<th width="60"></th>
			<th width="220"></th>
			<th width="60"></th>
			<th width="220"></th>
			<th width="60"></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>表册编号</td>
			<td><input readonly="readonly" value="${volume.id }" /></td>
			<td>表册名称</td>
			<td><input readonly="readonly" value="${volume.volumeName }" /></td>
			<td>所在序号</td>
			<td><input readonly="readonly" value="${volume.areaId }" /></td>
		</tr>
	</tbody>
	</table>
	
	<br/><br/><br/>
	<h3>用户水表信息</h3>
	
	<table width="100%">
	<thead>
		<tr>
			<th width="60"></th>
			<th width="220"></th>
			<th width="60"></th>
			<th width="220"></th>
			<th width="60"></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>水表编号</td>
			<td><input readonly="readonly" value="${meter.meterNo }" /></td>
			<td>表身码</td>
			<td><input readonly="readonly" value="${meter.meterName }" /></td>
			<td>起始底码</td>
			<td><input readonly="readonly" value="${meter.startValue }" /></td>
		</tr>
		<tr>
			<td>水表类型</td>
			<td><input readonly="readonly" value="${meter.meterTypeId }" /></td>
			<td>水表口径</td>
			<td><input readonly="readonly" value="${meterType.aperture }" /></td>
			<td>最大码值</td>
			<td><input readonly="readonly" value="${meter.maxValue }" /></td>
		</tr>
		<tr>
			<td>装表日期</td>
			<td><input readonly="readonly" value="${meter.setupDate }" /></td>
			<td>水表厂家</td>
			<td colspan="3"><input size="68" readonly="readonly" value="${meter.factory }" /></td>
		</tr>
	</tbody>
	</table>
	
</div>
						
					</div>
					<div id="tab2" class="tab_content"> 

<!-- 水价信息 -->

<table class="data display">
<thead>
	<tr>
		<th width="40">编码</th>
		<th width="70">类型</th>
		<th wdith="70">占比</th>
		<th width="70">价格</th>
		<th></th>
	</tr>
</thead>
<tbody>
	<tr class="odd">
		<td>SH</td>
		<td>生活用水</td>
		<td>80%</td>
		<td>2.71 元/吨</td>
		<td> = 生活用水费(1.69 元)+垃圾费(0.20 元)+污水费(0.80 元)+资源费(0.02 元)</td>
	</tr>
	<tr class="even">
		<td>SY</td>
		<td>商业用水</td>
		<td>20%</td>
		<td>3.36 元/吨</td>
		<td> = 商业用水费(2.54 元)+污水费(0.80 元)+资源费(0.02 元)</td>
	</tr>
</tbody>
</table>

					</div>
					<div id="tab3" class="tab_content"> 

<!-- 抄表记录 -->

<table class="data display">
<thead>
	<tr>
		<th width="80">抄表年月</th>
		<th width="40">复核</th>
		<th width="80">上次表码</th>
		<th width="80">本次表码</th>
		<th width="80">实用水量</th>
		<th width="100">操作日期</th>
		<th width="80">操作人</th>
		<th></th>
	</tr>
</thead>
<tbody>
	<tr class="odd">
		<td class="center">201402</td>
		<td class="center">是</td>
		<td class="right">931730</td>
		<td class="right">992631</td>
		<td class="right">60901 吨</td>
		<td class="center">2014-02-04</td>
		<td class="center">曹操</td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showReadingDetail();">详情</button></td>
	</tr>
	<tr class="even">
		<td class="center">201401</td>
		<td class="center">是</td>
		<td class="right">931730</td>
		<td class="right">992631</td>
		<td class="right">60901 吨</td>
		<td class="center">2014-01-04</td>
		<td class="center">曹操</td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showReadingDetail();">详情</button></td>
	</tr>
	<tr class="odd">
		<td class="center">201312</td>
		<td class="center">是</td>
		<td class="right">931730</td>
		<td class="right">992631</td>
		<td class="right">60901 吨</td>
		<td class="center">2013-12-04</td>
		<td class="center">曹操</td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showReadingDetail();">详情</button></td>
	</tr>
	<tr class="even">
		<td class="center">201311</td>
		<td class="center">是</td>
		<td class="right">931730</td>
		<td class="right">992631</td>
		<td class="right">60901 吨</td>
		<td class="center">2013-11-04</td>
		<td class="center">曹操</td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showReadingDetail();">详情</button></td>
	</tr>
	<tr class="odd">
		<td class="center">201310</td>
		<td class="center">是</td>
		<td class="right">931730</td>
		<td class="right">992631</td>
		<td class="right">60901 吨</td>
		<td class="center">2013-10-04</td>
		<td class="center">曹操</td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showReadingDetail();">详情</button></td>
	</tr>
	<tr class="even">
		<td class="center">201309</td>
		<td class="center">是</td>
		<td class="right">931730</td>
		<td class="right">992631</td>
		<td class="right">60901 吨</td>
		<td class="center">2013-09-04</td>
		<td class="center">曹操</td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showReadingDetail();">详情</button></td>
	</tr>
	<tr class="odd">
		<td class="center">201308</td>
		<td class="center">是</td>
		<td class="right">931730</td>
		<td class="right">992631</td>
		<td class="right">60901 吨</td>
		<td class="center">2013-08-04</td>
		<td class="center">曹操</td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showReadingDetail();">详情</button></td>
	</tr>
	<tr class="even">
		<td class="center">201307</td>
		<td class="center">是</td>
		<td class="right">931730</td>
		<td class="right">992631</td>
		<td class="right">60901 吨</td>
		<td class="center">2013-07-04</td>
		<td class="center">曹操</td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showReadingDetail();">详情</button></td>
	</tr>
	<tr class="odd">
		<td class="center">201306</td>
		<td class="center">是</td>
		<td class="right">931730</td>
		<td class="right">992631</td>
		<td class="right">60901 吨</td>
		<td class="center">2013-06-04</td>
		<td class="center">曹操</td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showReadingDetail();">详情</button></td>
	</tr>
	<tr class="even">
		<td class="center">201305</td>
		<td class="center">是</td>
		<td class="right">931730</td>
		<td class="right">992631</td>
		<td class="right">60901 吨</td>
		<td class="center">2013-05-04</td>
		<td class="center">曹操</td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showReadingDetail();">详情</button></td>
	</tr>
</tbody>
</table>
<div class="page">
	<a href="?page=1">第一页</a>
	<a href="?page=6">上一页</a>
	<input class="pageIndex" value="7"/> / <input class="pageCount" readonly="readonly" value="98765" />
	<a href="?page=8">下一页</a>
	<a href="?page=98765">第未页</a>
</div>

					</div>
					<div id="tab4" class="tab_content"> 

<!-- 水费单记录 -->

<table class="data display">
<thead>
	<tr>
		<th width="200">水费单号</th>
		<th width="100">应收金额</th>
		<th width="100">已收金额</th>
		<th width="100">未收金额</th>
		<th width="80">创建日期</th>
		<th width="80">是否结清</th>
		<th></th>
	</tr>
</thead>
<tbody>
	<tr class="odd">
		<td class="center">SF0100000987-201402</td>
		<td class="right">49385.67 元</td>
		<td class="right">0.00 元</td>
		<td class="right">49385.67 元</td>
		<td class="center">2014-02-04</td>
		<td class="center"></td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showBillDetail();">详情</button></td>
	</tr>
	<tr class="even">
		<td class="center">SF0100000987-201401</td>
		<td class="right">16944.95 元</td>
		<td class="right">4938.48 元</td>
		<td class="right">12006.47 元</td>
		<td class="center">2014-01-04</td>
		<td class="center"></td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showBillDetail();">详情</button></td>
	</tr>
	<tr class="odd">
		<td class="center">SF0100000987-201312</td>
		<td class="right">23839.22 元</td>
		<td class="right">23839.22 元</td>
		<td class="right">0.00 元</td>
		<td class="center">2013-12-04</td>
		<td class="center">是</td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showBillDetail();">详情</button></td>
	</tr>
	<tr class="even">
		<td class="center">SF0100000987-201311</td>
		<td class="right">9213.67 元</td>
		<td class="right">9213.67 元</td>
		<td class="right">0.00 元</td>
		<td class="center">2013-11-04</td>
		<td class="center">是</td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showBillDetail();">详情</button></td>
	</tr>
	<tr class="odd">
		<td class="center">SF0100000987-201310</td>
		<td class="right">4856.66 元</td>
		<td class="right">4856.66 元</td>
		<td class="right">0.00 元</td>
		<td class="center">2013-10-04</td>
		<td class="center">是</td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showBillDetail();">详情</button></td>
	</tr>
	<tr class="even">
		<td class="center">SF0100000987-201309</td>
		<td class="right">9213.67 元</td>
		<td class="right">9213.67 元</td>
		<td class="right">0.00 元</td>
		<td class="center">2013-09-04</td>
		<td class="center">是</td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showBillDetail();">详情</button></td>
	</tr>
	<tr class="odd">
		<td class="center">SF0100000987-201308</td>
		<td class="right">4856.66 元</td>
		<td class="right">4856.66 元</td>
		<td class="right">0.00 元</td>
		<td class="center">2013-08-04</td>
		<td class="center">是</td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showBillDetail();">详情</button></td>
	</tr>
	<tr class="even">
		<td class="center">SF0100000987-201307</td>
		<td class="right">9213.67 元</td>
		<td class="right">9213.67 元</td>
		<td class="right">0.00 元</td>
		<td class="center">2013-07-04</td>
		<td class="center">是</td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showBillDetail();">详情</button></td>
	</tr>
	<tr class="odd">
		<td class="center">SF0100000987-201306</td>
		<td class="right">4856.66 元</td>
		<td class="right">4856.66 元</td>
		<td class="right">0.00 元</td>
		<td class="center">2013-06-04</td>
		<td class="center">是</td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showBillDetail();">详情</button></td>
	</tr>
	<tr class="even">
		<td class="center">SF0100000987-201305</td>
		<td class="right">9213.67 元</td>
		<td class="right">9213.67 元</td>
		<td class="right">0.00 元</td>
		<td class="center">2013-05-04</td>
		<td class="center">是</td>
		<td class="left"><button class="btn btn-small btn-blue" onClick="showBillDetail();">详情</button></td>
	</tr>
</tbody>
</table>
<div class="page">
	<a href="?page=1">第一页</a>
	<a href="?page=6">上一页</a>
	<input class="pageIndex" value="7"/> / <input class="pageCount" readonly="readonly" value="98765" />
	<a href="?page=8">下一页</a>
	<a href="?page=98765">第未页</a>
</div>


					</div>
					<div id="tab5" class="tab_content"> 

<!-- 收费单记录 -->

<table class="data display">
<thead>
	<tr>
		<th width="200">交费单号</th>
		<th width="100">交费金额</th>
		<th width="100">剩余金额</th>
		<th width="100">发票号</th>
		<th width="80">交费日期</th>
		<th width="80">收费员</th>
		<th></th>
	</tr>
</thead>
<tbody>
	<tr class="odd">
		<td class="center">JF0100000987-201401-02</td>
		<td class="right">49385.67 元</td>
		<td class="right">0.00 元</td>
		<td class="center">58969399</td>
		<td class="center">2014-01-24</td>
		<td class="center">郝多乾</td>
		<td class="left"></td>
	</tr>
	<tr class="even">
		<td class="center">JF0100000987-201401-01</td>
		<td class="right">49385.67 元</td>
		<td class="right">0.00 元</td>
		<td class="center">58969399</td>
		<td class="center">2014-01-05</td>
		<td class="center">郝多乾</td>
		<td class="left"></td>
	</tr>
	<tr class="odd">
		<td class="center">JF0100000987-201312-01</td>
		<td class="right">49385.67 元</td>
		<td class="right">0.00 元</td>
		<td class="center">58969399</td>
		<td class="center">2013-12-24</td>
		<td class="center">郝多乾</td>
		<td class="left"></td>
	</tr>
	<tr class="even">
		<td class="center">JF0100000987-201311-01</td>
		<td class="right">49385.67 元</td>
		<td class="right">0.00 元</td>
		<td class="center">58969399</td>
		<td class="center">2013-11-24</td>
		<td class="center">郝多乾</td>
		<td class="left"></td>
	</tr>
	<tr class="odd">
		<td class="center">JF0100000987-201310-01</td>
		<td class="right">49385.67 元</td>
		<td class="right">0.00 元</td>
		<td class="center">58969399</td>
		<td class="center">2013-10-24</td>
		<td class="center">郝多乾</td>
		<td class="left"></td>
	</tr>
	<tr class="even">
		<td class="center">JF0100000987-201309-01</td>
		<td class="right">49385.67 元</td>
		<td class="right">0.00 元</td>
		<td class="center">58969399</td>
		<td class="center">2013-09-24</td>
		<td class="center">郝多乾</td>
		<td class="left"></td>
	</tr>
	<tr class="odd">
		<td class="center">JF0100000987-201308-01</td>
		<td class="right">49385.67 元</td>
		<td class="right">0.00 元</td>
		<td class="center">58969399</td>
		<td class="center">2013-08-24</td>
		<td class="center">郝多乾</td>
		<td class="left"></td>
	</tr>
	<tr class="even">
		<td class="center">JF0100000987-201307-01</td>
		<td class="right">49385.67 元</td>
		<td class="right">0.00 元</td>
		<td class="center">58969399</td>
		<td class="center">2013-07-24</td>
		<td class="center">郝多乾</td>
		<td class="left"></td>
	</tr>
	<tr class="odd">
		<td class="center">JF0100000987-201306-01</td>
		<td class="right">49385.67 元</td>
		<td class="right">0.00 元</td>
		<td class="center">58969399</td>
		<td class="center">2013-06-24</td>
		<td class="center">郝多乾</td>
		<td class="left"></td>
	</tr>
	<tr class="even">
		<td class="center">JF0100000987-201305-01</td>
		<td class="right">49385.67 元</td>
		<td class="right">0.00 元</td>
		<td class="center">58969399</td>
		<td class="center">2013-05-24</td>
		<td class="center">郝多乾</td>
		<td class="left"></td>
	</tr>
</tbody>
</table>
<div class="page">
	<a href="?page=1">第一页</a>
	<a href="?page=6">上一页</a>
	<input class="pageIndex" value="7"/> / <input class="pageCount" readonly="readonly" value="98765" />
	<a href="?page=8">下一页</a>
	<a href="?page=98765">第未页</a>
</div>


					</div>
				</div>
			</div>
			
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<div id="footer">		
		<div class="content_pad">			
			<p>&copy; 2013-11 版权所有 <a href="#">湖南省自来水公司</a>.   技术支持 <a href="#">华瑞教育</a>.</p>
		</div> <!-- .content_pad -->
	</div> <!-- #footer -->
	
</div> <!-- #wrapper -->

<script src="/TapWater/sy/js/jquery/jquery-1.5.2.min.js"></script>
<script src="/TapWater/sy/js/jquery/jquery-ui-1.8.12.custom.min.js"></script>
<script src="/TapWater/sy/js/misc/excanvas.min.js"></script>
<script src="/TapWater/sy/js/jquery/facebox.js"></script>
<script src="/TapWater/sy/js/jquery/jquery.visualize.js"></script>
<script src="/TapWater/sy/js/jquery/jquery.dataTables.min.js"></script>
<script src="/TapWater/sy/js/jquery/jquery.tablesorter.min.js"></script>
<script src="/TapWater/sy/js/jquery/jquery.uniform.min.js"></script>
<script src="/TapWater/sy/js/jquery/jquery.placeholder.min.js"></script>

<script src="/TapWater/sy/js/widgets.js"></script>
<script src="/TapWater/sy/js/dashboard.js"></script>

<script type="text/javascript">
	
$(document).ready ( function () 
{
	Dashboard.init ();
	
	//选项卡初始化
	$('.tab_container').tabs ();
});


</script>

</body> 
 
</html>