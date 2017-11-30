<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>湖南省自来水公司营销管理信息系统</title> 
	
	<link rel="stylesheet" href="/SyProject/SY/css/reset.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/text.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/form.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/buttons.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/grid.css" type="text/css" media="screen" title="no title" />	
	<link rel="stylesheet" href="/SyProject/SY/css/layout.css" type="text/css" media="screen" title="no title" />	
	
	<link rel="stylesheet" href="/SyProject/SY/css/ui-darkness/jquery-ui-1.8.12.custom.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/plugin/jquery.visualize.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/plugin/facebox.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/plugin/uniform.default.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="/SyProject/SY/css/plugin/dataTables.css" type="text/css" media="screen" title="no title" />
	
	<link rel="stylesheet" href="/SyProject/SY/css/custom.css" type="text/css" media="screen" title="no title">
	<style type="text/css">
	#changeMessage { color:red; margin-left:150px; visibility:hidden;  }
	</style>
	<%@include file="jQuery.jsp" %>
	<script type="text/javascript">
	
	//发票号码发生改变
	var invoiceChanged = false;
	function invoiceChange(){
		if(invoiceChanged)return;
		invoiceChanged=true;
		
		//发票号码发生改变时，要进行的处理
		$('#changeMessage').css('visibility','visible');
		$('#submit').val('修改发票号码并重新打印');
	}
	
	$(function(){
		//提交表单
		window.ok=function(){
			//打印发票
			var invoice=$("#invoice").val();
			var flag=1; //发票未变
			
						
			if(invoice==$("#hinvoice").val()){//发票没改变
				showWindow({url:'/SyProject/SY/page/pay_printInvoice.jsp?invoice='+invoice+"&flag="+flag, width:800, height:260});
				return;
			}
			if(invoice!=$("#hinvoice").val()){//发票改变
				flag=0;
				$.post("/SyProject/paywindow/changeInvoice",
						{"invoice":invoice,
						"payNo":$("#payNo").val(),
						"oldinvoice":$("#hinvoice").val()
						}
				,function(x){
					if(x=="noinvoice"){
						alert('没有这个发票');
						return;
					}
					if(x=="usedinvoice"){
						alert("发票已经使用");
						return;
					}
			showWindow({url:'/SyProject/SY/page/pay_printInvoice.jsp?invoice='+invoice+"&flag="+flag, width:800, height:260});
				});
			}
		}
		
	});
	</script>
</head> 
 
<body> 

<div id="wrapper">
	
		
	
	<%@include file="header.jsp" %>
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">发票补开/作废</a></span>
			<span id="welcome_span">欢迎回来，${empLogin.empName }</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid">
		
 		
		<div class="x12">
			<form action="?" class="form label-inline uniform">
			<div class="form label-inline uniform">
				<h2>发票补开/作废</h2>
				<p style="margin-left:20px;">说明：
				1.不修改发票号表示重新打印发票。
				2.修改发票号表示将旧的发票作废，并将新的发票与交费单关联，以及打印新发票。</p>
			
				<div class="field"><label for="name">发票类型</label>
					<c:if test="${pay.ivInvoice.invoiceType ==0 }">
						<input size="50" type="text" class="medium" value="普通发票" disabled="disabled" />
					</c:if>
					<c:if test="${pay.ivInvoice.invoiceType ==1 }">
						<input size="50" type="text" class="medium" value="增值税发票" disabled="disabled" />
					</c:if>
				</div>
				
				<div class="field"><label for="name">状态</label>
				<input size="50" type="text" class="medium" value="已使用" disabled="disabled" /></div>
				
				<div class="field"><label for="name">发票号码</label>
				<input size="50" type="text"   id="invoice" class="medium" value="${pay.invoice }" onKeyUp="invoiceChange();" /> 
				<input size="50" type="hidden" id="hinvoice" class="medium" value="${pay.invoice }" onKeyUp="invoiceChange();" />
				<br/>
				<span id="changeMessage">由于你修改了发票号码，此操作会将原发票号码作废，将新发票号码与交费单关联。</span></div>
				
				<div class="field"><label for="name">交费单号</label>
				<input size="50" type="text" class="medium" value="${pay.payNo }" id="payNo" disabled="disabled" /></div>
				
				<div class="field"><label for="name">交费用户</label>
				<input size="50" type="text" class="medium" value="${pay.user.userName }" disabled="disabled" /></div>
				
				<div class="field"><label for="name">收费员</label>
				<input size="50" type="text" class="medium" value="${pay.emp.empName }" disabled="disabled" /></div>
				
				<div class="field"><label for="name">交费金额</label>
				<input size="50" type="text" class="medium" value="${pay.payMoney } 元" disabled="disabled" /></div>
				
				<div class="field"><label for="name">交费日期</label>
				<input size="50" type="text" class="medium" value="<fmt:formatDate value='${pay.payDate }'  type='date'  />" disabled="disabled" /></div>
				
				<div class="buttonrow">
					<input id="submit" type="submit" class="btn" value="重新打印发票" onClick="ok();"></input>  
					<button class="btn btn-grey" onClick="history.back(-1);">返回</button>
				</div>
			
			</div>
			</form>
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<div id="footer">		
		<div class="content_pad">			
			<p>&copy; 2013-11 版权所有 <a href="#">湖南省自来水公司</a>.   技术支持 <a href="#">华瑞教育</a>.</p>
		</div> <!-- .content_pad -->
	</div> <!-- #footer -->
	
</div> <!-- #wrapper -->

<script src="/SyProject/SY/js/jquery/jquery-1.5.2.min.js"></script>
<script src="/SyProject/SY/js/jquery/jquery-ui-1.8.12.custom.min.js"></script>
<script src="/SyProject/SY/js/misc/excanvas.min.js"></script>
<script src="/SyProject/SY/js/jquery/facebox.js"></script>
<script src="/SyProject/SY/js/jquery/jquery.visualize.js"></script>
<script src="/SyProject/SY/js/jquery/jquery.dataTables.min.js"></script>
<script src="/SyProject/SY/js/jquery/jquery.tablesorter.min.js"></script>
<script src="/SyProject/SY/js/jquery/jquery.uniform.min.js"></script>
<script src="/SyProject/SY/js/jquery/jquery.placeholder.min.js"></script>

<script src="/SyProject/SY/js/widgets.js"></script>
<script src="/SyProject/SY/js/dashboard.js"></script>

<script type="text/javascript">
	
$(document).ready ( function () 
{
	Dashboard.init ();		
});

</script>

</body> 
 
</html>