<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>收费窗口 - 湖南省自来水公司营销管理信息系统</title> 
	
	<%@include file="jQuery.jsp" %>
	<%@include file="left.jsp" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

	
<style type="text/css">
table.pay td { height:30px; vertical-align:middle;  }
.getmoney { text-align:right; font-weight:bold; }
table.billlist { cursor:default; }
table.billlist thead th{ background-color:#000 !important; }
table.billlist tr.selected td { background-color:#333; color:#ff0; }
.second,.second td,.second th { font-size:12px; }
</style>
<script type="text/javascript">
$(function(){ //查询用户
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
		$.post("/SyProject/paywindow/selectUser",args,function(x){
			var no=showWindow({url:'/SyProject/SY/page/sys_selectUser.jsp',
				callback: function(val){
					  //回调处理
					if(val==undefined)
						return ;
					location.href="/SyProject/paywindow/selectUserByUserNo?userNo="+val;
				}
			});
		}); 
		
	});
	
		//本次实收改变计算金额
	$("#bcss").keyup(function(){
		this.value=this.value=this.value.replace(/\D/gi,"");
		
		var num = $("#userMoney").val();
		if(num==""){
			num=0;
		}
		var znum =eval(num+"+"+this.value);
		$("#bczl").html(znum);
		if($("#cc").attr("checked")){
			$("#bczl").html("0.0");
		}
	});
	
	//选不选中找零转入预存
	$("#cc").click(function(){
			if($("#cc").attr("checked")){
				$("#bczl").html("0.0");
			}else{
				var num = $("#userMoney").val();
				var bcss=$("#bcss").val();
				var znum =eval(num+"+"+bcss);
				$("#bczl").html(znum);
			}
	});
//交费
window.pay=function(){
	var bcss=$("#bcss").val();
	if(bcss==""){
		 alert("用户还没有缴费！");
		 return
	}
	
	showDialog('确认交费吗？', function(){
	//是否交入预存
	var isyc=$("#cc").attr("checked");
	var userNo = $("#userNo").val();
	if(userNo==""){
		alert("没有选择用户");
		return;
	}
	var fapiao = $("#fapiao").val();
	if(fapiao==""){
		alert("没有选择发票");
		return;
	}
	var billNo="";
		//回调
		var args = {
				"userNo":userNo,
				"fapiao": fapiao,
				"jiaofei": bcss
		};
		$.post("/SyProject/paywindow/jiaofei",args,function(x){
			if(x==undefined)
			return ;
			if(x=="ok"){
				alert('缴费成功！');
				showWindow({url:'/SyProject/SY/page/pay_printInvoice.jsp', width:800, height:260});
			}
			if(x=="fail")
				alert('缴费失败！');
			if(x=="failfp")
				alert('缴费失败！发票不行');
				
		}); 
		
		//打印发票
	});
}
	//详情
	$("#xiangqingx").click(function(){
		var userNo=$("#userNo").val();
		location.href="/SyProject/paydetails/yonghuxiangqing?userNo="+userNo;
	});
});
//选择发票
function selectInvoice(){
	 
	$.post("/SyProject/paywindow/selectInvoice",{"rows":5},function(x){
		if(x=="fail"){
			alert("你没有登陆");
			return ;
		}
		var no = showWindow({url:'/SyProject/SY/page/pay_window_selectInvoice.jsp',
			callback: function(val){
				  //回调处理
				$("#fapiao").val(val);
			}});
	}); 
}
//发票补开
function reInvoice(payNo){
	$.post("/SyProject/paywindow/selectInvoiceByPayNo",{"payNo":payNo},function(x){
		if(x=="ok")
			showWindow({url:'/SyProject/SY/page/pay_window_reInvoice.jsp'});
	}); 
}
 
</script>
</head> 
 
<body> 

	<% request.getSession().removeAttribute("whereStr");
	request.getSession().removeAttribute("map");
	%>
	<c:if test="${user==null }">
		<script type="text/javascript">
			//没有选择用户
			$(function(){
				$(".pay").hide();
				//$("#cqzd").hide();
			});
		</script>
	</c:if>
	
<div id="wrapper">
	
	<%@include file="header.jsp" %>
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">收费窗口</a></span>
			<span id="welcome_span">欢迎回来${empLogin.empName }</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid">

		<div class="x12">
			
			<h2>
				收费窗口
			</h2>
			
<div class="tab_container">
	<ul class="tabs"> 
		<li><a href="#tab1">查询及收费</a></li> 
		<li><a href="#tab2">陈欠账单</a></li> 
		<li><a href="#tab3">历史交费记录</a></li> 
		<li><a href="#tab4">修改联系资料</a></li> 
		<li><a href="#tab5">打印历史详单</a></li> 
		<li><a href="#tab6">打印催缴通知单</a></li> 
	</ul> 
	
	<div class="tab_content_container"> 
		
		<div id="tab1" class="tab_content"> 
		
			<!------------------------------------- 查询 --------------------------------------------->
			<h3>查询</h3>
			<form action="" name="frm"  method="post">
			<table>
				<tr>
					<td>用户编码</td>
					<td><input size="16" name="userNo" value="${user.userNo }"/>
					 </td>
					<td>用户简码</td>
					<td><input size="16" name="abc" value="${user.abc }" /> </td>
					<td>短信电话</td>
					<td><input size="16" name="smsPhone" value="${user.smsPhone }"/> </td>
					<td>联系电话</td>
					<td><input size="16" name="phone" value="${user.phone }"/> </td>
					<td></td>
				</tr>
				<tr>
					<td>档案编号</td>
					<td><input size="16" name="docNum" value="${user.docNum }" /> </td>
					<td>用户姓名</td>
					<td><input size="16" name="userName" value="${user.userName }"/> </td>
					<td>联系地址</td>
					<td colspan="4"><input size="16" name="address" value="${user.address }"/>
						<a href="javascript:;" class="btn btn-icon btn-small btn-find btn-blue"
						   id="btnSel"><span></span>查询</a>
						<a href="/SyProject/SY/page/user_search.html" id="xiangqing" target="_blank" 
							class="btn btn-icon btn-small btn-person btn-blue"><span></span>详情</a>
						<a href="/SyProject/SY/page/pay_window.jsp" class="btn btn-icon btn-small btn-refresh" id="chongzhi"><span></span>重置</a>
					</td>
				</tr>
			</table>	
			</form>
			<br/>
			
			
			<!------------------------------------- 收费 --------------------------------------------->
			<h3>收费</h3>
			
						
			<table class="pay">
				<tr>
					<td>陈欠总额</td>
					<td class="right red bold" >
						<c:if test="${user.userMoney < 0}">${user.userMoney }</c:if>
						<c:if test="${user.userMoney >= 0 || user.userMoney==null}">0.00</c:if>
						 &nbsp;&nbsp;
						</td>
					<td >元</td>
					<td rowspan="5" style="padding-left:80px;">
						<button onClick="pay();"
						class="btn btn-icon btn-dollar btn-blue btn-large"><span></span>交费</button>
					</td>
				</tr>
				<tr>
					<td>剩余预交</td>
					<td class="right green bold">
						<c:if test="${user.userMoney <= 0  || user.userMoney==null}">0.00</c:if>
						<c:if test="${user.userMoney > 0 }">${user.userMoney }</c:if>
					&nbsp;&nbsp;</td>
					<td>元</td>
				</tr>
				<tr>
					<td>本次实收</td>
					<td><input class="getmoney" type="text" id="bcss" />
						<input type="hidden" id="userMoney" value="${user.userMoney }">
					</td>
					<td>元</td>
				</tr>
				<tr>
					<td>本次找零</td>
					<td class="right" id="bczl">0.00&nbsp;&nbsp;</td>
					<td>元 <input id="cc" type="checkbox" checked="checked" /><label for="cc">找零转入预存</label></td>
				</tr>
				<tr>
					<td>发票号码</td>
					<td>
						<span class="text_button">
							<input style="width:120px; text-align:center;" value="" id="fapiao" />
							<button onClick="selectInvoice();">浏览</button>
						</span>
					</td>
					<td>&nbsp;</td>
				</tr>
			</table>
			<br/><br/><br/><br/>
		</div>
		<div id="tab2" class="tab_content second"> 
		
		
		<!------------------------------------- 陈欠账单 --------------------------------------------->
		
			<div style="float:left;width:45%;">
			
			<h3>陈欠账单</h3>
			<table class="data display billlist" id="cqzd">
				<thead>
					<tr>
						<th>水费单</th>
						<th style="text-align:right">总金额</th>
						<th style="text-align:right">实收</th>
						<th style="text-align:right">未收</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="b" items="${pyBills }">
					<tr class="odd ">
						<td>${b.billNo}</td>
						<td class="right">${b.realMoney+b.realMoney } 元</td>
						<td class="right">${b.billMoney } 元
							<input type="hidden" id="${b.billNo }" value="${b.readId }">
						</td>
						<td class="right">${b.realMoney }元</td>
					</tr>
				</c:forEach>
				
				</tbody>
			</table>
			</div>
			<span style="float:left;width:1%;">&nbsp;</span>
			<div id="details" style="float:left;width:54%; min-height:600px;">
			
			<!------------------------------------- 水费明细 --------------------------------------------->
			<h3>账单明细</h3>
			<table class="data display">
				<thead>
					<tr>
						<th>费用类型</th>
						<th style="text-align:right">水量</th>
						<th style="text-align:right">单价</th>
						<th style="text-align:right">小计</th>
						<th style="text-align:right">实收</th>
						<th style="text-align:right">未收</th>
					</tr>
				</thead>
				<tbody id="sfmx">
				 
				</tbody>
			</table>
			
			<!------------------------------------- 上月本月底码 --------------------------------------------->
			<br/><br/>
			<h3>表码明细</h3>
			<table class="data display">
				<thead>
					<tr>
						<th style="text-align:left">上月底码</th>
						<th style="text-align:left">本月底码</th>
						<th style="text-align:right">实用水量</th>
					</tr>
				</thead>
				<tbody id="bmmx">
				<tr class="odd">
					<td class="">93495 吨</td>
					<td class="">93515 吨</td>
					<td class="right">  120 吨</td>
				</tr>
				
				</tbody>
			</table>
			
			<!------------------------------------- 分类用水量 --------------------------------------------->
			<table class="data display">
				<thead>
					<tr>
						<th>用水类型</th>
						<th>提取方式</th>
						<th style="text-align:right;">分类水量</th>
					</tr>
				</thead>
				<tbody>
				<tr class="odd">
					<td>生活用水</td>
					<td>10%</td>
					<td class="right">12 吨</td>
				</tr>
				<tr class="even">
					<td>经营用水</td>
					<td>90%</td>
					<td class="right">108 吨</td>
				</tr>
				</tbody>
			</table>
			<br/>
			</div>
		</div>
		<div id="tab3" class="tab_content"> 
			<!------------------------------------- 历史交费记录 --------------------------------------------->
			<table class="data display">
				<thead>
					<tr>
						<th width="200">历史交费单号</th>
						<th width="140">交费日期</th>
						<th width="140" style="text-align:right">交费金额</th>
						<th width="100" style="text-align:center">发票号</th>
						<th width="100">收费员</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
				<% int i=0; %>
				<c:forEach var="p" items="${pays }">
					<tr class="odd">
						<td>${p.payNo }</td>
						<td><fmt:formatDate value="${p.payDate }"  type="date" dateStyle="long"/></td>
						<td class="right">${p.payMoney } 元</td>
						<td class="center">${p.invoice }</td>
						<td>${p.emp.empName }
						</td>
						<td><a href="javascript:reInvoice('${p.payNo }');" class="btn btn-small">发票补开</a></td>
					</tr>
				</c:forEach>
				
				<tr class="odd">
					<td colspan="6">只显示最近的8条交费记录...</td>
				</tr>
				</tbody>
			</table>
		</div>
		<div id="tab4" class="tab_content" style="min-height:500px;"> 
		
			<!------------------------------------- 修改联系信息 --------------------------------------------->
			<div class="form label-inline uniform">
				<div class="field"><label for="xx">用户编码</label> <input name="userNo" disabled="disabled" id="userNo" value="${user.userNo }" /></div>
				<div class="field"><label for="xx">用户姓名</label> <input name="userName" disabled="disabled" value="${user.userName }" /></div>
				<div class="field"><label for="xx">联系电话</label> <input name="phone" id="phone" value="${user.phone }" /></div>
				<div class="field"><label for="xx">短信号码</label> <input name="smsPhone" id="smsPhone" value="${user.smsPhone }" /></div>
				<div class="field"><label for="xx">联系地址</label> <input size="80" name="address" id="address"
					value="${user.address }" /></div>
				<div class="buttonrow">
					<button class="btn" id="updateUserFrm">保存</button>
				</div>
			</div>
<script type="text/javascript">
	$(function(){
		$("#updateUserFrm").click(function(){
			var userNo = $("#userNo").val();		
			var phone = $("#phone").val();		
			var smsPhone = $("#smsPhone").val();		
			var address = $("#address").val();	
			
			
			var args={
				"userNo":userNo,
				"phone":phone,
				"smsPhone":smsPhone,
				"address":address
			};
			$.post("/SyProject/paywindow/updateUserPhoneAndSmsPhone",args,function(x){
				alert("修改成功！");
			}); 
		});		
	});
</script>
		</div>
		<div id="tab5" class="tab_content"> 
			<div class="reportTitle">
				用户历史详单
			</div>
			<div class="height24">
				<div style="float:left;width:200px;">用户编码：${user.userNo }</div>
				<div style="float:left;">用户姓名：${user.userName }</div>
				
				<div style="float:right;">当前欠费：
					<c:if test="${user.userMoney < 0}">${user.userMoney }</c:if>
						<c:if test="${user.userMoney >= 0 || user.userMoney==null}">0.00</c:if>
				元</div>
				<div style="float:right;width:200px;">当前余额：
						<c:if test="${user.userMoney <= 0  || user.userMoney==null}">0.00</c:if>
						<c:if test="${user.userMoney > 0 }">${user.userMoney }</c:if>
				 元</div>
			</div>
			<table class="report">
				<thead>
					<tr>
						<th style="width:210px;">水费/交费单号</th>
						<th style="width:120px;">时间</th>
						<th style="width:70px;">上月表码</th>
						<th style="width:70px;">本月表码</th>
						<th style="width:70px;">用水量</th>
						<th style="width:100px;">应缴水费</th>
						<th style="width:100px;">交费金额</th>
						<th>余额/欠费</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var ="h" items="${historys }">
						<tr>
							<td class="left">交费 ${h.orderno }</td>
							<td class="center">
								<fmt:formatDate value="${h.datee }"  type="date" dateStyle="long"/>
							</td>
							<td class="right">${h.prevalue }</td>
							<td class="right">${h.curvalue };</td>
							<td class="right">${h.amount }</td>
							<td class="right">${h.billmoney }</td>
							<td class="right">${h.paymoney } 元</td>
							<td class="right"><span class="fleft"></span> ${h.usermoney } 元</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="height24 fright">
				打印日期：<fmt:formatDate value="${currDate }"  type="date" dateStyle="long"/>
			</div>
			<div style="margin:0px auto; text-align:center; margin-top:40px;">
				<button class="btn btn-icon btn-print btn-blue" onClick="parent.close();"><span></span>打印</button>
			</div>
		</div>
		<div id="tab6" class="tab_content"> 
			<div class="reportTitle">
				催缴水费通知单
			</div>
			<div class="height24">
				<div style="float:left;width:200px;">用户编码：${user.userNo }</div>
				<div style="float:left;">用户姓名：${user.userName }</div>
				<div style="float:right;">当前欠费：
						<c:if test="${user.userMoney < 0}">${user.userMoney }</c:if>
						<c:if test="${user.userMoney >= 0 || user.userMoney==null}">0.00</c:if>
				元</div>
			</div>
			<table class="report">
				<thead>
					<tr>
						<th style="width:100px;">时间</th>
						<th style="width:120px;">上月表码</th>
						<th style="width:120px;">本月表码</th>
						<th style="width:120px;">用水量</th>
						<th style="width:140px;">应缴水费</th>
						<th style="width:140px;">实缴</th>
						<th                     >未缴</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var ="h" items="${jiaofei }">
							<tr>
								<td class="center">
									<fmt:formatDate value="${h.datee }"  type="date" dateStyle="long"/>
								</td>
								<td class="right">${h.prevalue }</td>
								<td class="right">${h.curvalue }吨</td>
								<td class="right">${h.amount }</td>
								<td class="right">${h.billmoney }</td>
								<td class="right">${h.paymoney } 元</td>
								<td class="right">${h.weipaymoney } 元</td>
							</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="height24">
				尊敬的用户，你户已欠缴水费 ${sum } 元，请在三天内至我公司收费大厅结清水费，否则将停止供水。
			</div>
			<div class="height24 right">
				湖南省自来水公司
				&nbsp;&nbsp;
				<fmt:formatDate value="${currDate }"  type="date" dateStyle="long"/>
			</div>
			<div style="margin:0px auto; text-align:center; margin-top:10px;">
				<button class="btn btn-icon btn-print btn-blue" onClick="parent.close();"><span></span>打印</button>
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



<script type="text/javascript">
	
$(document).ready(function() 
{
	Dashboard.init ();
	
	//选择项初始化
	$('.tab_container').tabs ();
	
	//陈欠账单-选择账单的操作
	$('table.billlist tbody tr').click(function(){
		$('table.billlist tbody tr.selected').removeClass('selected');
		$(this).addClass('selected');
		var billNo=$(this).children("td").get(0).innerHTML;
		var readNo=$("#"+billNo).val();

	
		//aJax异步查询 水费的详细信息
		$.post("/SyProject/paywindow/queryBillDetails",{"billNo":billNo},function(x){
			$("#sfmx").html(x);
		});
		
		$.post("/SyProject/paywindow/queryReadDetails",{"readNo":readNo},function(x){
			var tr="<tr ><td >"+(x.read.preValue)+" 吨</td><td >"+(x.read.curValue)+"吨</td>	<td >"+(x.read.curValue-x.read.preValue)+" 吨</td></tr>";
			$("#bmmx").html(tr);
		});
		//$('#details').html('正在加载...');
		//if(!temp_html) temp_html = $('#details').html();
		
		//alert(temp_html);
		//setTimeout(function(){ $('#details').html(temp_html); }, 300);
	});
});
var temp_html;

</script>

</body> 
 
</html>