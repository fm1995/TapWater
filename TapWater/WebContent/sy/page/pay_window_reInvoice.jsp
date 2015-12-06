<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>发票补开</title> 
	
	<%@include file="../style.jsp" %>
	<style type="text/css">
	#changeMessage { color:red; margin-left:150px; visibility:hidden;  }
	</style>
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
			
						
			if(invoice!=$("#hinvoice").val()){//发票没改变
				showWindow({url:'/TapWater/sy/page/pay_printInvoice.jsp?invoice='+invoice+"&flag="+flag, width:800, height:260});
				return;
			}
			if(invoice!=$("#hinvoice").val()){//发票改变
				flag=0;
				$.post("/TapWater/paywindow/changeInvoice",
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
				});
			showWindow({url:'/TapWater/sy/page/pay_printInvoice.jsp?invoice='+invoice+"&flag="+flag, width:800, height:260});
			}
		}
		
	});
	
	</script>
</head> 
 
<body> 

	<form action="?" class="form label-inline uniform">
		<h2>发票补开</h2>
		<p style="margin-left:20px;">说明：
		1.不修改发票号表示重新打印发票。
		2.修改发票号表示将旧的发票作废，并将新的发票与交费单关联，以及打印新发票。</p>
	
		<div class="field"><label for="name">发票类型</label>
		<input size="50" type="text" class="medium" value="普通发票" disabled="disabled" /></div>
		
		<div class="field"><label for="name">状态</label>
		<input size="50" type="text" class="medium" value="已使用" disabled="disabled" /></div>
		
		<div class="field"><label for="name">发票号码</label>
		<input size="50" type="text" id="invoice" class="medium" value="${pay.invoice }" onKeyUp="invoiceChange();" /> 
		<input size="50" type="hidden" id="hinvoice" class="medium" value="${pay.invoice }" onKeyUp="invoiceChange();" /> 
		<br/>
		<span id="changeMessage">由于你修改了发票号码，此操作会将原发票号码作废，将新发票号码与交费单关联。</span></div>
		
		<div class="field"><label for="name">交费单号</label>
		<input size="50" type="text" class="medium" value="${pay.payNo }" id="payNo" disabled="disabled" /></div>
		
		<div class="field"><label for="name">交费用户</label>
		<input size="50" type="text" class="medium" value="${pay.userNo }" disabled="disabled" /></div>
		
		<div class="field"><label for="name">收费员</label>
		<input size="50" type="text" class="medium" value="${sfEmp.empName }" disabled="disabled" /></div>
		
		<div class="field"><label for="name">交费金额</label>
		<input size="50" type="text" class="medium" value="${pay.payMoney } 元" disabled="disabled" /></div>
		
		<div class="field"><label for="name">交费日期</label>
		<input size="50" type="text" class="medium" value="<fmt:formatDate value='${pay.payDate }'  type='date' dateStyle='long'/>" disabled="disabled" />
		
		</div>
		
		<div class="buttonrow">
			<input id="submit" type="submit" class="btn" value="重新打印发票" onClick="ok();"></input>  
			<button class="btn btn-grey" onClick="parent.close();">关闭</button>
		</div>
	
	</form>

<script src="../js/jquery/jquery-1.5.2.min.js"></script>
<script src="../js/jquery/jquery-ui-1.8.12.custom.min.js"></script>
<script src="../js/misc/excanvas.min.js"></script>
<script src="../js/jquery/facebox.js"></script>
<script src="../js/jquery/jquery.visualize.js"></script>
<script src="../js/jquery/jquery.dataTables.min.js"></script>
<script src="../js/jquery/jquery.tablesorter.min.js"></script>
<script src="../js/jquery/jquery.uniform.min.js"></script>
<script src="../js/jquery/jquery.placeholder.min.js"></script>

<script src="../js/widgets.js"></script>
<script src="../js/dashboard.js"></script>

<script type="text/javascript">
	
$(document).ready ( function () 
{
	Dashboard.init ();		
});

</script>

</body> 
 
</html>