<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
 
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
	table.data thead th { vertical-align:middle; text-align:center; }
	</style>
</head> 
 
<body> 

<div id="wrapper">
	
<<<<<<< .mine
	 <%@include file="header.jsp"%>	
=======
	<div id="header">
		
		<div class="content_pad">
			<h1><a href="/SyProject/SY/workspace.html">湖南省自来水公司营销管理信息系统</a></h1>
			
			<ul id="nav">
				
				<li class="nav_dropdown nav_icon">
					<a href="javascript:;"><span class="ui-icon ui-icon-wrench"></span>业扩工程</a>
					
					<div class="nav_menu">			
						<ul>
							<li><a href="/SyProject/SY/page/be__request.html">01 用户申请</a></li>
							<li><a href="/SyProject/SY/page/be__audit.html">02 初步审核</a></li>
							<li><a href="/SyProject/SY/page/be__pay.html">03 交施工费</a></li>
							<li><a href="/SyProject/SY/page/be__billclear.html">04 水费清算</a></li>
							<li><a href="/SyProject/SY/page/be__contract.html">05 供水协议</a></li>
							<li><a href="/SyProject/SY/page/be__working.html">06 施工竣工</a></li>
							<li><a href="/SyProject/SY/page/be__open.html">07 通水停水</a></li>
							<li><a href="/SyProject/SY/page/be__save.html">08 档案存档</a></li>
							<li><a href="/SyProject/SY/page/be_order.html">工单管理</a></li>
							<li><a href="/SyProject/SY/page/be_abort.html">终止工单</a></li>
							<li><a href="/SyProject/SY/page/be_reportProgress.html">业扩工程进度</a></li>
							<li><a href="/SyProject/SY/page/be_reportMoney.html">业扩收费报表</a></li>
						</ul>
						
					</div>
				</li>

				<li class="nav_dropdown nav_icon">
					<a href="javascript:;"><span class="ui-icon ui-icon-person"></span>用户管理</a>
					
					<div class="nav_menu">			
						<ul>
							<li><a href="/SyProject/SY/page/user_search.html">用户查询</a></li>	
							<li><a href="/SyProject/SY/page/user_add.html">快捷新户</a></li>	
							<li><a href="/SyProject/SY/page/user_changeName.html">快捷过户</a></li>
							<li><a href="/SyProject/SY/page/user_changeBank.html">快捷代扣</a></li>
							<li><a href="/SyProject/SY/page/user_changeMeter.html">快捷换表</a></li>
							<li><a href="/SyProject/SY/page/user_changeFormula.html">快捷重签</a></li>
							<li><a href="/SyProject/SY/page/user_delete.html">快捷销户</a></li>
							<li><a href="/SyProject/SY/page/user_reportShortcut.html">快捷操作记录</a></li>
							<li><a href="/SyProject/SY/page/user_docNum.html">档案号管理</a></li>
							<li><a href="/SyProject/SY/page/user_sendMsg.html">短信群发</a></li>
						</ul>
						
					</div>
				</li>

				<li class="nav_dropdown nav_icon">
					<a href="javascript:;"><span class="ui-icon ui-icon-pencil"></span>抄表管理</a>
					
					<div class="nav_menu">			
						<ul>
							<li><a href="/SyProject/SY/page/rd_volume.html">表册管理</a></li>	
							<li><a href="/SyProject/SY/page/rd_init.html">抄表初始化</a></li>	
							<li><a href="/SyProject/SY/page/rd_task.html">任务分配</a></li>	
							<li><a href="/SyProject/SY/page/rd_enter.html">抄表录入</a></li>	
							<li><a href="/SyProject/SY/page/rd_audit.html">抄表审核</a></li>
							<li><a href="/SyProject/SY/page/rd_reportReading.html">抄表情况查询</a></li>	
							<li><a href="/SyProject/SY/page/rd_reportVolumeReading.html">抄表统计报表</a></li>	
							<li><a href="/SyProject/SY/page/rd_reportZero.html">零吨位用户查询</a></li>	
							<li><a href="/SyProject/SY/page/rd_reportMaxValue.html">最大码值修正记录</a></li>
							<li><a href="/SyProject/SY/page/rd_reportCPreAmount.html">底码修正记录</a></li>	
							<li><a href="/SyProject/SY/page/rd_reportMeterCheck.html">水表周检报表</a></li>
						</ul>
						
					</div>
				</li>
				
				<li class="nav_dropdown nav_icon">
					<a href="javascript:;"><span class="ui-icon ui-icon-star"></span>收费管理</a>
					
					<div class="nav_menu">			
						<ul>
							<li><a href="/SyProject/SY/page/pay_window.html">窗口收费</a></li>	
							<li><a href="/SyProject/SY/page/pay_batch.html">批量收费</a></li>
							<li><a href="/SyProject/SY/page/pay_invoiceReprint.html">发票补开/作废</a></li>	
							<li><a href="/SyProject/SY/page/pay_reportDebts.html">欠费报表</a></li>	
							<li><a href="/SyProject/SY/page/pay_reportPay.html">收费情况报表</a></li>	
							<li><a href="/SyProject/SY/page/pay_reportMonthRecycle.html">月资金回收情况报表</a></li>	
							<li><a href="/SyProject/SY/page/pay_reportBalance.html">用户预收情况报表</a></li>	
							<li><a href="/SyProject/SY/page/pay_reportWaterType.html">各类用水统计总表</a></li>
						</ul>
						
					</div>
				</li>
				
				<li class="nav_dropdown nav_icon">
					<a href="javascript:;"><span class="ui-icon ui-icon-script"></span>发票管理</a>
					
					<div class="nav_menu">			
						<ul>
							<li><a href="/SyProject/SY/page/inv_invoiceManage.html">发票总表</a></li>
							<li><a href="/SyProject/SY/page/inv_invoiceIn.html">发票入库</a></li>	
							<li><a href="/SyProject/SY/page/inv_invoiceOut.html">发票出库</a></li>
							<li><a href="/SyProject/SY/page/inv_invoiceArchive.html">发票交票</a></li>
							<li><a href="/SyProject/SY/page/inv_invoiceReportOut.html">发票出库情况查询</a></li>	
							<li><a href="/SyProject/SY/page/inv_invoiceReportEmp.html">收费人员发票查询</a></li>	
							<li><a href="/SyProject/SY/page/inv_invoiceReportArchive.html">发票交票情况查询</a></li>	
							<li><a href="/SyProject/SY/page/inv_invoiceReportUse.html">发票使用情况查询</a></li>	
							<li><a href="/SyProject/SY/page/inv_invoiceReportMoneySum.html">销账汇总报表</a></li>	
							<li><a href="/SyProject/SY/page/inv_invoiceReportMoneyDetail.html">销账明细报表</a></li>	
						</ul>
					</div>
				</li>

				<li class="nav_dropdown nav_icon">
					<a href="javascript:;"><span class="ui-icon ui-icon-gear"></span>系统设置</a>
					
					<div class="nav_menu">			
						<ul>
							<li><a href="/SyProject/SY/page/sys_area.html">抄表辖区</a></li>	
							<li><a href="/SyProject/SY/page/sys_meterType.html">水表型号</a></li>	
							<li><a href="/SyProject/SY/page/sys_dept.html">部门管理</a></li>	
							<li><a href="/SyProject/SY/page/sys_emp.html">员工管理</a></li>	
							<li><a href="/SyProject/SY/page/sys_menupower.html">菜单权限设置</a></li>	
							<li><a href="/SyProject/SY/page/sys_areapower.html">辖区权限设置</a></li>	
							<li><a href="/SyProject/SY/page/sys_waterType.html">用水类型设定</a></li>	
							<li><a href="/SyProject/SY/page/sys_surcharge.html">附加费设定</a></li>	
							<li><a href="/SyProject/SY/page/sys_flow.html">流程配置</a></li>	
						</ul>
						
					</div>
				</li>
				
				<li class="nav_current nav_dropdown nav_icon_only">
					<a href="javascript:;">&nbsp;</a>
					
					<div class="nav_menu">
						<ul>
							<li><a href="/SyProject/SY/workspace.html">我的工作台</a></li>
							<li><a href="/SyProject/SY/page/sys_pwd.html">修改密码</a></li>
							<li><a href="/SyProject/SY/login.html">退出系统</a></li>
						</ul>
					</div> <!-- .menu -->
				</li>
			</ul>
		</div> <!-- .content_pad -->
		
	</div> <!-- #header -->	
>>>>>>> .r196
	
	<div id="content" class="xgrid" >

		<div class="x12">
			
			<h2>快捷代扣</h2>

			<div class="searchUserDiv">
				用户编码 <input id="userNo" />
				用户简码 <input id="abc" />
				用户姓名 <input id="userName"/>
				联系电话 <input id="phone"/>
				家庭住址 <input id="address"/>
				<button class="btn btn-small btn-icon btn-person" onclick="queryUsers();"><span></span>查询用户</button>
			</div>
			
			<br/><br/>
			
			
			
			<div class="form label-inline uniform">
				<h3 style="width:50%;">快捷代扣</h3>
				<div class="field"><label for="id" id="no">用户编码</label> <input id="id" name="fname" size="50" type="text" class="medium" disabled="disabled" value="" /></div>
				
				<div class="field"><label for="name" id="uname">用户姓名</label> <input id="name" name="lname" size="50" type="text" class="medium" disabled="disabled" value="" /></div>
				<div class="field"><label for="name">原收款方式</label> <input id="payType" name="lname" size="50" type="text" class="medium" disabled="disabled" value="" /></div>
				<div class="field"><label for="name">原开户银行</label> <input id="bankName" name="lname" size="50" type="text" class="medium" disabled="disabled" value="" /></div>
				<div class="field"><label for="name">原银行账号</label> <input id="bankNum" name="lname" size="50" type="text" class="medium" disabled="disabled" value="" /></div>
				
				
				<div class="field"><label for="name">新收款方式</label> <select style="width:158px;">
											<option>坐收</option>
											<option>走收</option>
											<option selected="selected">银行代扣</option>
										</select></div>
				<div class="field"><label for="name">新开户银行</label>
			    <input id="kName" name="lname" size="50" type="text" class="medium" value="" /></div>
				<div class="field"><label for="name">新银行账号</label>
			    <input id="kNum" name="lname" size="50" type="text" class="medium" value="" /></div>
				<div class="buttonrow">
					<button class="btn" onclick="but1();">保存银行代扣设置</button>
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

<script src="/SyProject/SY/js/jquery/jquery-1.5.2.min.js"></script>
<script src="/SyProject/SY/js/jquery/jquery-ui-1.8.12.custom.min.js"></script>
<script src="/SyProject/SY/js/misc/excanvas.min.js"></script>
<script src="/SyProject/SY/js/jquery/facebox.js"></script>
<script src="/SyProject/SY/js/jquery/jquery.visualize.js"></script>
<script src="/SyProject/SY/js/jquery/jquery.dataTables.min.js"></script>
<script src="/SyProject/SY/js/jquery/jquery.tablesorter.min.js"></script>
<script src="/SyProject/SY/js/jquery/jquery.uniform.min.js"></script>
<script src="/SyProject/SY/js/jquery/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="/SyProject/SY/js_2/js_2.js"></script>
<script src="/SyProject/SY/js/widgets.js"></script>
<script src="/SyProject/SY/js/dashboard.js"></script>

<script type="text/javascript">
	
$(document).ready ( function () 
{
	Dashboard.init ();
	//读取登录员工信息
	readEmp();
});


/* var but1=function(){
	var id=$("#id").val();
	var name=$("#name").val();
	var bName=$("#kName").val();
	var bNum=$("#kNum").val();
	alert($("#kName").val());
	alert($("#kNum").val())
	var data="userNo="+id+"&userName="+name+"&bankName="+bName+"&bankNum="+bNum;
	data=encodeURI(data);
	location.href="/SyProject/controller/monkeyProduct?"+data;
}
 */
</script>

</body> 
 
</html>