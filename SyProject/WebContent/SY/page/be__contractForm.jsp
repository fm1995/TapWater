<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" /> 
	<title>湖南省自来水公司营销管理信息系统</title> 
	
	<link rel="stylesheet" href="../css/reset.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="../css/text.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="../css/form.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="../css/buttons.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="../css/grid.css" type="text/css" media="screen" title="no title" />	
	<link rel="stylesheet" href="../css/layout.css" type="text/css" media="screen" title="no title" />	
	
	<link rel="stylesheet" href="../css/ui-darkness/jquery-ui-1.8.12.custom.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="../css/plugin/jquery.visualize.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="../css/plugin/facebox.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="../css/plugin/uniform.default.css" type="text/css" media="screen" title="no title" />
	<link rel="stylesheet" href="../css/plugin/dataTables.css" type="text/css" media="screen" title="no title" />
	
	<link rel="stylesheet" href="../css/custom.css" type="text/css" media="screen" title="no title">
	<script type="text/javascript">
	function setTibi(){
		showWindow({url:'../page/sys_setTibi.html', width:600, height:500});
	}
	</script>
</head> 
 
<body> 

<div id="wrapper">	
	
	<div id="header">
		
		<div class="content_pad">
			<h1><a href="../workspace.html">湖南省自来水公司营销管理信息系统</a></h1>
			
			<ul id="nav">
				
				<li class="nav_dropdown nav_icon">
					<a href="javascript:;"><span class="ui-icon ui-icon-wrench"></span>业扩工程</a>
					
					<div class="nav_menu">			
						<ul>
							<li><a href="../page/be__request.html">01 用户申请</a></li>
							<li><a href="../page/be__audit.html">02 初步审核</a></li>
							<li><a href="../page/be__pay.html">03 交施工费</a></li>
							<li><a href="../page/be__billclear.html">04 水费清算</a></li>
							<li><a href="../page/be__contract.html">05 供水协议</a></li>
							<li><a href="../page/be__working.html">06 施工竣工</a></li>
							<li><a href="../page/be__open.html">07 通水停水</a></li>
							<li><a href="../page/be__save.html">08 档案存档</a></li>
							<li><a href="../page/be_order.html">工单管理</a></li>
							<li><a href="../page/be_abort.html">终止工单</a></li>
							<li><a href="../page/be_reportProgress.html">业扩工程进度</a></li>
							<li><a href="../page/be_reportMoney.html">业扩收费报表</a></li>
						</ul>
						
					</div>
				</li>

				<li class="nav_dropdown nav_icon">
					<a href="javascript:;"><span class="ui-icon ui-icon-person"></span>用户管理</a>
					
					<div class="nav_menu">			
						<ul>
							<li><a href="../page/user_search.html">用户查询</a></li>	
							<li><a href="../page/user_add.html">快捷新户</a></li>	
							<li><a href="../page/user_changeName.html">快捷过户</a></li>
							<li><a href="../page/user_changeBank.html">快捷代扣</a></li>
							<li><a href="../page/user_changeMeter.html">快捷换表</a></li>
							<li><a href="../page/user_changeFormula.html">快捷重签</a></li>
							<li><a href="../page/user_delete.html">快捷销户</a></li>
							<li><a href="../page/user_reportShortcut.html">快捷操作记录</a></li>
							<li><a href="../page/user_docNum.html">档案号管理</a></li>
							<li><a href="../page/user_sendMsg.html">短信群发</a></li>
						</ul>
						
					</div>
				</li>

				<li class="nav_dropdown nav_icon">
					<a href="javascript:;"><span class="ui-icon ui-icon-pencil"></span>抄表管理</a>
					
					<div class="nav_menu">			
						<ul>
							<li><a href="../page/rd_volume.html">表册管理</a></li>	
							<li><a href="../page/rd_init.html">抄表初始化</a></li>	
							<li><a href="../page/rd_task.html">任务分配</a></li>	
							<li><a href="../page/rd_enter.html">抄表录入</a></li>	
							<li><a href="../page/rd_audit.html">抄表审核</a></li>
							<li><a href="../page/rd_reportReading.html">抄表情况查询</a></li>	
							<li><a href="../page/rd_reportVolumeReading.html">抄表统计报表</a></li>	
							<li><a href="../page/rd_reportZero.html">零吨位用户查询</a></li>	
							<li><a href="../page/rd_reportMaxValue.html">最大码值修正记录</a></li>
							<li><a href="../page/rd_reportCPreAmount.html">底码修正记录</a></li>	
							<li><a href="../page/rd_reportMeterCheck.html">水表周检报表</a></li>
						</ul>
						
					</div>
				</li>
				
				<li class="nav_dropdown nav_icon">
					<a href="javascript:;"><span class="ui-icon ui-icon-star"></span>收费管理</a>
					
					<div class="nav_menu">			
						<ul>
							<li><a href="../page/pay_window.html">窗口收费</a></li>	
							<li><a href="../page/pay_batch.html">批量收费</a></li>
							<li><a href="../page/pay_invoiceReprint.html">发票补开/作废</a></li>	
							<li><a href="../page/pay_reportDebts.html">欠费报表</a></li>	
							<li><a href="../page/pay_reportPay.html">收费情况报表</a></li>	
							<li><a href="../page/pay_reportMonthRecycle.html">月资金回收情况报表</a></li>	
							<li><a href="../page/pay_reportBalance.html">用户预收情况报表</a></li>	
							<li><a href="../page/pay_reportWaterType.html">各类用水统计总表</a></li>
						</ul>
						
					</div>
				</li>
				
				<li class="nav_dropdown nav_icon">
					<a href="javascript:;"><span class="ui-icon ui-icon-script"></span>发票管理</a>
					
					<div class="nav_menu">			
						<ul>
							<li><a href="../page/inv_invoiceManage.html">发票总表</a></li>
							<li><a href="../page/inv_invoiceIn.html">发票入库</a></li>	
							<li><a href="../page/inv_invoiceOut.html">发票出库</a></li>
							<li><a href="../page/inv_invoiceArchive.html">发票交票</a></li>
							<li><a href="../page/inv_invoiceReportOut.html">发票出库情况查询</a></li>	
							<li><a href="../page/inv_invoiceReportEmp.html">收费人员发票查询</a></li>	
							<li><a href="../page/inv_invoiceReportArchive.html">发票交票情况查询</a></li>	
							<li><a href="../page/inv_invoiceReportUse.html">发票使用情况查询</a></li>	
							<li><a href="../page/inv_invoiceReportMoneySum.html">销账汇总报表</a></li>	
							<li><a href="../page/inv_invoiceReportMoneyDetail.html">销账明细报表</a></li>	
						</ul>
					</div>
				</li>

				<li class="nav_dropdown nav_icon">
					<a href="javascript:;"><span class="ui-icon ui-icon-gear"></span>系统设置</a>
					
					<div class="nav_menu">			
						<ul>
							<li><a href="../page/sys_area.html">抄表辖区</a></li>	
							<li><a href="../page/sys_meterType.html">水表型号</a></li>	
							<li><a href="../page/sys_dept.html">部门管理</a></li>	
							<li><a href="../page/sys_emp.html">员工管理</a></li>	
							<li><a href="../page/sys_menupower.html">菜单权限设置</a></li>	
							<li><a href="../page/sys_areapower.html">辖区权限设置</a></li>	
							<li><a href="../page/sys_waterType.html">用水类型设定</a></li>	
							<li><a href="../page/sys_surcharge.html">附加费设定</a></li>	
							<li><a href="../page/sys_flow.html">流程配置</a></li>	
						</ul>
						
					</div>
				</li>
				
				<li class="nav_current nav_dropdown nav_icon_only">
					<a href="javascript:;">&nbsp;</a>
					
					<div class="nav_menu">
						<ul>
							<li><a href="../workspace.html">我的工作台</a></li>
							<li><a href="../page/sys_pwd.html">修改密码</a></li>
							<li><a href="../login.html">退出系统</a></li>
						</ul>
					</div> <!-- .menu -->
				</li>
			</ul>
		</div> <!-- .content_pad -->
		
	</div> <!-- #header -->	
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">供水协议</a></span>
			<span id="welcome_span">欢迎回来，马云</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid">
		
 		
		<div class="x12">
			
			<h2>
				供水协议 - <a href="../page/be_orderInfo.html?id=B1-20140105-0001" target="orderInfo">B1-201412-0003</a>
				<a style="float:right" href="javascript:history.back(-1);">返回</a>
			</h2>
			
			<div class="buttonrow">
				<button class="btn-icon btn-arrow-left btn-red" 
					onclick="showDialog('确认撤回吗？');"><span></span>撤回</button>
				<button class="btn-icon btn-arrow-right btn-blue" 
					onclick="showDialog('确认发送吗？');"><span></span>发送</button>
			</div>
			
<table width="100%">
<thead>
	<tr>
		<th width="60"></th>
		<th></th>
	</tr>
</thead>
<tbody>
	<tr>
		<td>用户名称</td>
		<td><input readonly="readonly" value="张三" /></td>
		<td><span class="text_button">
			<input id="batchTibi" 
				style="width:200px;" readonly="readonly" value="[SH:80%][SY:10%][GY:10%]" />
			<button onClick="setTibi();">设定</button></span>
			<button onClick="$('input.tibi').val($('#batchTibi').val());">
				批量设定提比提量值</button></td>
		<td><input id="batchContract" value="HT201402035838" /><button 
			onclick="$('input.contract').val($('#batchContract').val());">批量设定合同编号</button></td>
	</tr>
</tbody>
</table>

<table class="data display">
<thead>
	<tr>
		<th width="30">序号</th>
		<th width="80">姓名</th>
		<th width="320">提比提量值</th>
		<th width="120">合同编号</th>
		<th></th>
	</tr>
</thead>
<tbody>
	<tr class="odd">
		<td>1</td>
		<td>张三</td>
		<td><span class="text_button">
			<input class="tibi" style="width:200px;" 
			readonly="readonly" value="[SH:80%][SY:*]" />
			<button onClick="setTibi();">设定</button></span></td>
		<td><input class="contract" value="" /></td>
		<td></td>
	</tr>
	<tr class="even">
		<td>2</td>
		<td>李四</td>
		<td><span class="text_button">
			<input class="tibi" style="width:200px;" 
			readonly="readonly" value="[SH:20][SY:20][GY:*]" />
			<button onClick="setTibi();">设定</button></span></td>
		<td><input class="contract" value="" /></td>
		<td></td>
	</tr>
	<tr class="odd">
		<td>3</td>
		<td>王五</td>
		<td><span class="text_button">
			<input class="tibi" style="width:200px;" 
			readonly="readonly" value="[TZ:20][SH:80%][SY:10%][GY:10%]" />
			<button onClick="setTibi();">设定</button></span></td>
		<td><input class="contract" value="" /></td>
		<td></td>
	</tr>
	<tr class="even">
		<td>4</td>
		<td>赵六</td>
		<td><span class="text_button">
			<input class="tibi" style="width:200px;" 
			readonly="readonly" value="[SH:80%][SY:10%][GY:10%]" />
			<button onClick="setTibi();">设定</button></span></td>
		<td><input class="contract" value="" /></td>
		<td></td>
	</tr>
	<tr class="odd">
		<td>5</td>
		<td>钱七</td>
		<td><span class="text_button">
			<input class="tibi" style="width:200px;" 
			readonly="readonly" value="[GY:100%]" />
			<button onClick="setTibi();">设定</button></span></td>
		<td><input class="contract" value="" /></td>
		<td></td>
	</tr>
	<tr class="even">
		<td>6</td>
		<td>唐八</td>
		<td><span class="text_button">
			<input class="tibi" style="width:200px;" 
			readonly="readonly" value="[SY:80%][SY:20%]" />
			<button onClick="setTibi();">设定</button></span></td>
		<td><input class="contract" value="" /></td>
		<td></td>
	</tr>
	<tr class="odd">
		<td>7</td>
		<td>何九</td>
		<td><span class="text_button">
			<input class="tibi" style="width:200px;" 
			readonly="readonly" value="[SH:100%]" />
			<button onClick="setTibi();">设定</button></span></td>
		<td><input class="contract" value="" /></td>
		<td></td>
	</tr>
	<tr class="even">
		<td>8</td>
		<td>布十</td>
		<td><span class="text_button">
			<input class="tibi" style="width:200px;" 
			readonly="readonly" value="[SH:80%][SY:20%]" />
			<button onClick="setTibi();">设定</button></span></td>
		<td><input class="contract" value="" /></td>
		<td></td>
	</tr>
</tbody>
</table>
			
<div class="centerButtons">
	<button class="btn">保存不发送</button>
</div>			
			
		</div> <!-- .x12 -->
		
	</div> <!-- #content -->
	
	<div id="footer">		
		<div class="content_pad">			
			<p>&copy; 2013-11 版权所有 <a href="#">湖南省自来水公司</a>.   技术支持 <a href="#">华瑞教育</a>.</p>
		</div> <!-- .content_pad -->
	</div> <!-- #footer -->
	
</div> <!-- #wrapper -->

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