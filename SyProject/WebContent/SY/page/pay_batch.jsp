<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 
 
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>湖南省自来水公司营销管理信息系统</title> 
	<%@include file="linkDocuments.jsp" %>	
	<%@include file="jQuery.jsp" %>
	<%@include file="left.jsp" %>
<style type="text/css">
table.pay td, table.pay td input,td.enter,input.enter { color:red; }
table.pay td { height:30px; vertical-align:middle;   }
.getmoney { text-align:right; font-weight:bold; }
input.enter { 
	-moz-box-shadow: none;
	-webkit-box-shadow: none;
	box-shadow: none;
	-moz-border-radius: 0px;
	-webkit-border-radius: 0px;
	border-radius: 0px;
	border:none; margin:0px; padding:0px; background:none;
	width:90%;
	height:100%;
	text-align:right;
 }
 table.data tbody td.enter {
	padding:0px;
	margin:0px;
	border:1px solid #000;
	width:200px; vertical-align:middle;
 }
</style>

<script type="text/javascript">
$(function(){
	$("#btnSel").click(function(){//查询用户
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
			var uno;
			var no=showWindow({url:'/SyProject/SY/page/sys_selectUser.jsp',
				callback: function(val){
					  //回调处理
				 	selUser(val);
				}
			});
		}); 
	});
	//查询用户
	window.selUser=function(uno){
		$.post("/SyProject/paybatch/selectUserByUserNo",{"userNo":uno},function(u){
			$("input[name=userNo]").val(u.userNo);
			$("input[name=huserNo]").val(u.userNo);
			 $("input[name=abc]").val(u.abc);		
			  $("input[name=smsPhone]").val(u.smsPhone);	
			 $("input[name=phone]").val(u.phone);
			 $("input[name=docNum]").val(u.docNum);		
			 $("input[name=userName]").val(u.userName);		
			 $("input[name=address]").val(u.address);
		});
	}
	//添加用户, 讲用户添加到页面
	$("#addUser").click(function(){
		var userNo=$("input[name=huserNo]").val();
		if(userNo==""){
			alert('没有选择用户');return;
		}
		$.post("/SyProject/paybatch/selectUserByUserNo",{"userNo":userNo},function(u){
			clearInp();
			if(u.userMoney==null)
				u.userMoney=0;
			var ye=0,qf=0;
			if(u.userMoney>0)
				ye=u.userMoney;
			else
				qf=u.userMoney;
				
			var tr="<tr class='odd'><td>"+u.userNo+"<input type='hidden' name='puserno' value='"+u.userNo+"'></td><td>"+u.userName+"</td><td>"+u.address+"</td><td >"+ye+"元</td><td >"+qf+"元</td><td class='enter' >"+
			"<input name='paymoney' onblur='paymenyChange()' class='enter'  value='0'> 元</td>"+
			"<td ><button onclick='deluser(this)'  class='btn btn-icon btn-mini btn-red btn-cross'><span  ></span></button></td></tr>";
			$("#userList").append(tr);
		});
	});
	window.deluser = function(obj){
		document.getElementById("userList").removeChild(obj.parentNode.parentNode);
		paymenyChange();
	}
	window.clearInp=function(){ //清空选择框
		$("input[name=userNo]").val("");
		$("input[name=huserNo]").val("");
		 $("input[name=abc]").val("");		
		  $("input[name=smsPhone]").val("");	
		 $("input[name=phone]").val("");
		 $("input[name=docNum]").val("");		
		 $("input[name=userName]").val("");		
		 $("input[name=address]").val("");
	}
	window.paymenyChange=function(){
		var moneys=0;
		$("input[name=paymoney]").each(function(i){
			var money=$("input[name=paymoney]")[i].value;
			moneys=eval(moneys+"+"+money);
		});
		$("#moneys").val(moneys);
	}
	 	
});

//交费
function pay(){
	if($("input[name=paymoney]").length==0){
		alert('没有选择用户');return;
	}
	if($("#fapiao").val()==""){
		alert('没有选择发票');return;
	}
	
	
	var unos="";
	$("input[name=puserno]").each(function(i){//拼接要交费的几个用户
		unos=unos+$("input[name=puserno]")[i].value+",";
	});
	var paymoneys="";
	$("input[name=paymoney]").each(function(i){//拼接要交费的几个用户
		paymoneys=paymoneys+$("input[name=paymoney]")[i].value+",";
	});
	var args={
		"unos":unos,
		"paymones":paymoneys,
		"fapiao":$("#fapiao").val(),
		"moneys":$("#moneys").val()
	};
	showDialog('确认交费吗？', function(){
		$.post("/SyProject/paybatch/pays",args,function(x){
			//回调
			if(x=="fail"){
				alert('缴费失败');return;
			}
			if(x=="failfp"){
				alert("发票不可用");return;
			}
			if(x=="ok")//打印发票
				showWindow({url:'pay_printInvoice2.html', width:800, height:260});
		});
		
		
	});
}

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

</script>
</head> 
 
<body> 

<div id="wrapper">
	
	<%@include file="header.jsp" %>
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">批量收费</a></span>
			<span id="welcome_span">欢迎回来，${empLogin.empName }</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid">

		<div class="x12">
			
			<h2>
				批量收费
			</h2>

			<!------------------------------------- 查询 --------------------------------------------->

			<table>
				<tr>
					<td>用户编码</td>
					<td>
					<input size="16" name="userNo" value="${user.userNo }"/>
					<input size="16" type="hidden" name="huserNo" value="${user.userNo }"/>
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
						<a href="javascript:;" id="addUser" class="btn btn-icon btn-small btn-arrow-down btn-blue"><span></span>添加用户</a>
					</td>
				</tr>
			</table>	
			<br/><br/><br/><br/>
			
			
			<!------------------------------------- 收费 --------------------------------------------->			
						
			<table class="pay">
				<tr>
					<td>本次实收</td>
					<td><input class="getmoney" value="0.0" id="moneys" readonly="readonly" /></td>
					<td width="100">元</td>
					<td>发票号码</td>
					<td width="300">
						<span class="text_button">
							<input style="width:120px; text-align:center;" value="" id="fapiao" />
							<button onClick="selectInvoice();">浏览</button>
						</span>
					</td>
					<td>
						<button onClick="pay();"
						class="btn btn-icon btn-dollar btn-red btn-small"><span></span>交费</button>
					</td>
				</tr>
			</table>
			
			<table class="data display">
				<thead>
					<tr>
						<th>用户编码</th>
						<th>用户名称</th>
						<th>用户地址</th>
						<th class="right">余额</th>
						<th class="right">欠费</th>
						<th>本次缴费金额</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody id="userList">
					 					
					</tbody>
			</table>
			


			
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<div id="footer">		
		<div class="content_pad">			
			<p>&copy; 2013-11 版权所有 <a href="#">湖南省自来水公司</a>.   技术支持 <a href="#">华瑞教育</a>.</p>
		</div> <!-- .content_pad -->
	</div> <!-- #footer -->
	
</div> <!-- #wrapper -->

<script type="text/javascript">
	
$(document).ready ( function () 
{
	Dashboard.init ();

});


</script>

</body> 
 
</html>