<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="header">
		<div class="content_pad">
			<h1><a href="/TapWater/sy/workspace.jsp">湖南省自来水公司营销管理信息系统</a></h1>
			
			<ul id="nav">
				
				<li class="nav_dropdown nav_icon">
					<a href="javascript:;"><span class="ui-icon ui-icon-wrench"></span>业扩工程</a>
					
					<div class="nav_menu">			
						<ul>
							<li><a href="./page/be__request.html">01 用户申请</a></li>
							<li><a href="./page/be__audit.html">02 初步审核</a></li>
							<li><a href="./page/be__pay.html">03 交施工费</a></li>
							<li><a href="./page/be__billclear.html">04 水费清算</a></li>
							<li><a href="./page/be__contract.html">05 供水协议</a></li>
							<li><a href="./page/be__working.html">06 施工竣工</a></li>
							<li><a href="./page/be__open.html">07 通水停水</a></li>
							<li><a href="./page/be__save.html">08 档案存档</a></li>
							<li><a href="./page/be_order.html">工单管理</a></li>
							<li><a href="./page/be_abort.html">终止工单</a></li>
							<li><a href="./page/be_reportProgress.html">业扩工程进度</a></li>
							<li><a href="./page/be_reportMoney.html">业扩收费报表</a></li>
						</ul>
						
					</div>
				</li>

				<li class="nav_dropdown nav_icon">
					<a href="javascript:;"><span class="ui-icon ui-icon-person"></span>用户管理</a>
					
					<div class="nav_menu">			
						<ul>
							<li><a href="./page/user_search.html">用户查询</a></li>	
							<li><a href="./page/user_add.html">快捷新户</a></li>	
							<li><a href="./page/user_changeName.html">快捷过户</a></li>
							<li><a href="./page/user_changeBank.html">快捷代扣</a></li>
							<li><a href="./page/user_changeMeter.html">快捷换表</a></li>
							<li><a href="./page/user_changeFormula.html">快捷重签</a></li>
							<li><a href="./page/user_delete.html">快捷销户</a></li>
							<li><a href="./page/user_reportShortcut.html">快捷操作记录</a></li>
							<li><a href="./page/user_docNum.html">档案号管理</a></li>
							<li><a href="./page/user_sendMsg.html">短信群发</a></li>
						</ul>
						
					</div>
				</li>

				<li class="nav_dropdown nav_icon">
					<a href="javascript:;"><span class="ui-icon ui-icon-pencil"></span>抄表管理</a>
					
					<div class="nav_menu">			
						<ul>
							<li><a href="./page/rd_volume.html">表册管理</a></li>	
							<li><a href="./page/rd_init.html">抄表初始化</a></li>	
							<li><a href="./page/rd_task.html">任务分配</a></li>	
							<li><a href="./page/rd_enter.html">抄表录入</a></li>	
							<li><a href="./page/rd_audit.html">抄表审核</a></li>
							<li><a href="./page/rd_reportReading.html">抄表情况查询</a></li>	
							<li><a href="/TapWater/sy/page/rd_reportVolumeReading.jsp">抄表统计报表</a></li>	
							<li><a href="/TapWater/sy/page/read/selAllAreaAndVolume">零吨位用户查询</a></li>	
							<li><a href="/TapWater/sy/page/rd_reportMaxValue.jsp">最大码值修正记录</a></li>
							<li><a href="./page/rd_reportCPreAmount.html">底码修正记录</a></li>	
							<li><a href="./page/rd_reportMeterCheck.html">水表周检报表</a></li>
						</ul>
						
					</div>
				</li>
				
				<li class="nav_dropdown nav_icon">
					<a href="javascript:;"><span class="ui-icon ui-icon-star"></span>收费管理</a>
					
					<div class="nav_menu">			
						<ul>
							<li><a href="/TapWater/sy/page/pay_window.jsp">窗口收费</a></li>	
							<li><a href="/TapWater/sy/page/pay_batch.html">批量收费</a></li>
							<li><a href="/TapWater/sy/page/pay_invoiceReprint.html">发票补开/作废</a></li>	
							<li><a href="/TapWater/sy/page/pay/TapWater/sy/Debts.html">欠费报表</a></li>	
							<li><a href="/TapWater/sy/page/pay_reportPay.html">收费情况报表</a></li>	
							<li><a href="/TapWater/report/monthRecycle">月资金回收情况报表</a></li>	
							<li><a href="/TapWater/report/yushou">用户预收情况报表</a></li>	
							<li><a href="/TapWater/report/tongji">各类用水统计总表</a></li>
						</ul>
						
					</div>
				</li>
				
				<li class="nav_dropdown nav_icon">
					<a href="javascript:;"><span class="ui-icon ui-icon-script"></span>发票管理</a>
					
					<div class="nav_menu">			
						<ul>
							<li><a href="/TapWater/sy/page/inv_invoiceManage.html">发票总表</a></li>
							<li><a href="./page/inv_invoiceIn.html">发票入库</a></li>	
							<li><a href="./page/inv_invoiceOut.html">发票出库</a></li>
							<li><a href="./page/inv_invoiceArchive.html">发票交票</a></li>
							<li><a href="./page/inv_invoiceReportOut.html">发票出库情况查询</a></li>	
							<li><a href="./page/inv_invoiceReportEmp.html">收费人员发票查询</a></li>	
							<li><a href="./page/inv_invoiceReportArchive.html">发票交票情况查询</a></li>	
							<li><a href="./page/inv_invoiceReportUse.html">发票使用情况查询</a></li>	
							<li><a href="./page/inv_invoiceReportMoneySum.html">销账汇总报表</a></li>	
							<li><a href="./page/inv_invoiceReportMoneyDetail.html">销账明细报表</a></li>	
						</ul>
					</div>
				</li>

				<li class="nav_dropdown nav_icon">
					<a href="javascript:;"><span class="ui-icon ui-icon-gear"></span>系统设置</a>
					
					<div class="nav_menu">			
						<ul>
							<li><a href="./page/sys_area.html">抄表辖区</a></li>	
							<li><a href="./page/sys_meterType.html">水表型号</a></li>	
							<li><a href="./page/sys_dept.html">部门管理</a></li>	
							<li><a href="./page/sys_emp.html">员工管理</a></li>	
							<li><a href="./page/sys_menupower.html">菜单权限设置</a></li>	
							<li><a href="./page/sys_areapower.html">辖区权限设置</a></li>	
							<li><a href="./page/sys_waterType.html">用水类型设定</a></li>	
							<li><a href="./page/sys_surcharge.html">附加费设定</a></li>	
							<li><a href="./page/sys_flow.html">流程配置</a></li>	
						</ul>
						
					</div>
				</li>
				
				<li class="nav_current nav_dropdown nav_icon_only">
					<a href="javascript:;">&nbsp;</a>
					
					<div class="nav_menu">
						<ul>
							<li><a href="./workspace.html">我的工作台</a></li>
							<li><a href="./page/sys_pwd.html">修改密码</a></li>
							<li><a href="./login.html">退出系统</a></li>
						</ul>
					</div> <!-- .menu -->
				</li>
			</ul>
		</div> <!-- .content_pad -->
		
	</div> <!-- #header -->	
	
