<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>湖南省自来水公司营销管理信息系统</title>

<%@ include file="/SY/page/linkDocuments.jsp"%>

<style type="text/css">
table.data th {
	text-align: center !important;
}

table.data tbody tr td {
	vertical-align: middle;
	text-align: center;
}

td.content {
	text-align: left !important;
	vertical-align: top !important;
}

table.forminfo {
	width: 100%;
}

table.forminfo td {
	text-align: left;
	vertical-align: top !important;
	margin: 0px !important;
	padding: 0px !important;
}

table.forminfo textarea {
	width: 100%;
	height: 80px;
}

table.forminfo button {
	margin: 0px !important;
}
</style>
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

<script src="/SyProject/SY/js/jquery/updateComment.js"></script>

<script type="text/javascript">
	//进入修改附加信息界面
	function editTag(str,id) {
		$('#btnAddTag').hide();
		$('#btnEditTag').show();
		$('#btnCancelTag').show();
 		$('#cid').val(id);
 		$('#txtTag').val(str);
		$('#txtTag').focus();
	}

	//保存修改附加信息
	function saveEditTag(orderNo) {
		updateComment(orderNo);
		newTag();
	}
	//放弃修改附加信息
	function cancelEditTag() {
		newTag();
	}
	//回到新增附加信息界面
	function newTag() {
		$('#btnEditTag').hide();
		$('#btnCancelTag').hide();
		$('#btnAddTag').show();
		$('#txtTag').val('');
		$('#cid').val('');
	}
	
	//删除附加信息
	function delCom(id,orderNo,obj){
		delComment(id,orderNo,obj);
	}
	
	//添加附加信息
	function addCom(orderNo,empId){
		addComment(orderNo,empId);
	}
	
</script>
</head>

<body>

	<div id="wrapper">

		<%@include file="/SY/page/header.jsp"%>
		<!-- #header -->

		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">工单信息</a></span> <span
					id="welcome_span">欢迎回来，${empLogin.empName }</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">


			<div class="x12">

				<h2>工单信息 ${orderInfo.Order.orderNo } <c:choose>
									<c:when test="${orderInfo.Order.orderType eq 1 }">
										新户
									</c:when>
									<c:when test="${orderInfo.Order.orderType eq 2 }">
										分户
									</c:when>
									<c:when test="${orderInfo.Order.orderType eq 3 }">
										过户
									</c:when>
									<c:when test="${orderInfo.Order.orderType eq 4 }">
										代扣
									</c:when>    
									<c:when test="${orderInfo.Order.orderType eq 5 }">
										换表
									</c:when>
									<c:when test="${orderInfo.Order.orderType eq 6 }">
										重签
									</c:when>
									<c:otherwise>
										销户
									</c:otherwise>
								</c:choose> ${orderInfo.Order.userName }</h2>

				<div class="tab_container">
					<ul class="tabs">
						<li><a href="#tab1">流程记录</a></li>
						<li><a href="#tab2">基本信息</a></li>
						<li><a href="#tab3">用户详细表</a></li>
						<li><a href="#tab4">表计详细表</a></li>
						<li><a href="#tab5">其它信息</a></li>
						<li><a href="#tab6">交费信息</a></li>
					</ul>
					<div class="tab_content_container">
						<div id="tab1" class="tab_content">
							<!-- 流程记录 -->
							<table width="100%">
								<tbody>
									<tr>
										<td width="48%">
											<!-- 历史记录 --> 流程历史记录
											<table class="data display">
												<thead>
													<tr>
														<th width="20"></th>
														<th width="100">处理时间</th>
														<th>内容</th>
														<th width="100">操作人</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="his" items="${orderInfo.history }" varStatus="vs">
													<c:if test="vs%2==0">
														<tr class="odd">
													</c:if>
													<c:if test="vs%2!=0">
														<tr class="even">
													</c:if>
														<td>${his.id }</td>
														<td><fmt:formatDate value="${his.datee }" pattern="yyyy/MM/dd HH:mm:ss"/></td>
														
														<td>
														<c:choose>
															<c:when test="${his.stepId eq -1 }">
																[终止]
															</c:when>
															<c:when test="${his.empId eq null }">
																[当前]
															</c:when>
															<c:otherwise>
																[完成]
															</c:otherwise>
														</c:choose>
														 ${his.stepName }</td>
														<td>${his.emp.empName }</td>
													</tr>
													</c:forEach>
												</tbody>
											</table> <!-- 历史记录结束 -->
										</td>
										<td width="2%"></td>
											<td width="50%">
											<!-- 附加信息 --> 附加信息记录
											<table class="data display">
												<thead>
													<tr>
														<th width="100"></th>
														<th>内容</th>
													</tr>
												</thead>
												<tbody id="tb">
													<c:forEach var="oc" items="${beComment.BeComment }" varStatus="vs">
														<c:if test="vs%2!=0">
															<tr class="odd">
														</c:if>
														<c:if test="vs%2==0">
															<tr class="even">
														</c:if>
															<td><b>${oc.emp.empName }</b><br /><fmt:formatDate value="${oc.datee }" pattern="yyyy/MM/dd HH:mm:ss"/><br />
																<c:if test="${empLogin.empId==oc.empId }">
																	<a href="javascript:;" onClick="editTag('${oc.comment }',${oc.id });">改</a> 
															<a href="javascript:;" onClick="delCom(${oc.id},'${oc.orderNo }',this);">删</a>
															<br />
																</c:if>
															 <br /></td>
															<td class="content">${oc.comment }</td>
														</tr>
													</c:forEach>
													
												</tbody>
											</table>
											<div style="float: left;">
												<textarea name="comment" id="txtTag" style="width: 330px; height: 80px;"></textarea>
												<input id="cid" type="hidden">
											</div>
											<div>
													<button id="btnAddTag" style="height: 94px; width: 100px;"
													 onclick="addCom('${orderInfo.Order.orderNo }',${empLogin.empId })">添加附加信息</button> 
													<button id="btnEditTag"   
													style="height: 47px; width: 100px; display: none;"
													onClick="saveEditTag('${orderInfo.Order.orderNo }');">保存修改</button>
													<button id="btnCancelTag" 
													style="height: 47px; width: 100px; display: none;"
													onClick="cancelEditTag();">放弃修改</button>
											</div>
											 <!-- 附加信息结束 -->
										</td>
									</tr>
								</tbody>
							</table>
							<!-- 流程记录结束 -->
						</div>
						<div id="tab2" class="tab_content">

							<!-- 基本信息 -->
							<table width="100%">
								<thead>
									<tr>
										<th width="60"></th>
										<th width="220"></th>
										<th width="60"></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>用户名称</td>
										<td><input readonly="readonly" value="${orderInfo.Order.userName }" /></td>
										<td>用户类型</td>
										<td><input readonly="readonly" value="${orderInfo.Order.userType }" /></td>
									</tr>
									<tr>
										<td>联系人</td>
										<td><input readonly="readonly" value="${orderInfo.Order.linkMan }" /></td>
										<td>联系电话</td>
										<td><input readonly="readonly" value="${orderInfo.Order.phone }" /></td>
									</tr>
									<tr>
										<td>用户地址</td>
										<td colspan="3"><input size="68" readonly="readonly"
											value="${orderInfo.Order.address }" /></td>
									</tr>
									<tr>
										<td>用水量</td>
										<td><input readonly="readonly" value="${orderInfo.Order.maxAmount }" /></td>
										<td>申请表径</td>
										<td><input readonly="readonly" value="${orderInfo.Order.syMeterType.meterTypeName }" /></td>
									</tr>
									<tr>
										<td>房屋层次</td>
										<td><input readonly="readonly" value="${orderInfo.Order.houseHeight }" /></td>
										<td>接水用途</td>
										<td><input readonly="readonly" value="${orderInfo.Order.useTarget }" /></td>
									</tr>
									<tr>
										<td>备注说明</td>
										<td colspan="3"><input size="68" readonly="readonly"
											value="${orderInfo.Order.userRemark }" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td>收费方式</td>
										<td><input readonly="readonly" value="${orderInfo.Order.payType }" /></td>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td>开户银行</td>
										<td><input readonly="readonly" value="${orderInfo.Order.bankCompany }" /></td>
										<td>银行账号</td>
										<td><input readonly="readonly" value="${orderInfo.Order.bankNum }" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td>原户编码</td>
										<td><input readonly="readonly" value="${orderInfo.Order.oldUserNo }" /></td>
										<td>原户姓名</td>
										<td><input readonly="readonly" value="${orderInfo.Order.oldUserName }" /></td>
									</tr>
									<tr>
										<td>原户电话</td>
										<td><input readonly="readonly" value="${orderInfo.Order.oldUserPhone }" /></td>
										<td>原户表径</td>
										<td><input readonly="readonly" value="${orderInfo.Order.oldMeter }" /></td>
									</tr>
									<tr>
										<td>原户地址</td>
										<td colspan="3"><input size="68" readonly="readonly"
											value="${orderInfo.Order.oldUserAddr }" /></td>
									</tr>
								</tbody>
							</table>
							<!-- 基本信息 -->

						</div>
						<div id="tab3" class="tab_content">
							<!-- 用户详细表 -->
							<table class="data display">
								<thead>
									<tr>
										<th width="30">序号</th>
										<th width="80">姓名</th>
										<th width="80">电话</th>
										<th width="80">短信号码</th>
										<th>地址</th>
										<th width="80">合同编号</th>
										<th width="80">档案号</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="ou" items="${orderInfo.OrderUser }" varStatus="vs">
									<c:if test="vs.index%2==0">
										<tr class="odd">
									</c:if>
									<c:if test="vs.index%2!=0">
										<tr class="even">
									</c:if>
										<td>${ou.id }</td>
										<td>${ou.userName }</td>
										<td>${ou.phone }</td>
										<td>${ou.smsPhone }</td>
										<td>${ou.address }</td>
										<td>${ou.contractNum }</td>
										<td>${ou.docNum }</td>
										<td></td>
									</tr>
										
									</c:forEach>
									
								</tbody>
							</table>
							<!-- 用户详细表 -->
						</div>
						<div id="tab4" class="tab_content">
							<!-- 表计详细表 -->
							<table class="data display">
								<thead>
									<tr>
										<th width="30">序号</th>
										<th width="80">姓名</th>
										<th width="80">表径</th>
										<th width="80">表身码</th>
										<th width="80">最大表码值</th>
										<th width="80">起始码</th>
										<th width="100">水表厂家</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="ou" items="${orderInfo.OrderUser }" varStatus="vs">
									<c:if test="vs.index%2==0">
									<tr class="odd">
									</c:if>
									<c:if test="vs.index%2!=0">
										<tr class="even">
									</c:if>
										<td>${ou.id }</td>
										<td>${ou.userName }</td>
										<td>${ou.syMeterType.meterTypeName }</td>
										<td>${ou.meterName }</td>
										<td>${ou.maxValue }</td>
										<td>${ou.startValue }</td>
										<td>${ou.meterFactory }</td>
										<td></td>
									</c:forEach>
									</tr>
									
								</tbody>
							</table>
							<!-- 表计详细表 -->
						</div>
						<div id="tab5" class="tab_content">
							<!-- 其它信息 -->
							<table width="100%">
								<thead>
									<tr>
										<th width="60"></th>
										<th width="220"></th>
										<th width="60"></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>建单日期</td>
										<td><input readonly="readonly" value="<fmt:formatDate value='${orderInfo.Order.createDate }' pattern='yyyy/MM/dd HH:mm:ss'/>" /></td>
										<td>关单日期</td>
										<td><input readonly="readonly" value="<fmt:formatDate value='${orderInfo.Order.completeDate }' pattern='yyyy/MM/dd HH:mm:ss'/>" /></td>
									</tr>
									<tr>
										<td>开工日期</td>
										<td><input readonly="readonly" value="<fmt:formatDate value='${orderInfo.Order.projectDate1 }' pattern='yyyy/MM/dd HH:mm:ss'/>" /></td>
										<td>竣工日期</td>
										<td><input readonly="readonly" value="<fmt:formatDate value='${orderInfo.Order.projectDate2 }' pattern='yyyy/MM/dd HH:mm:ss'/>" /></td>
									</tr>
									<tr>
										<td>审核人</td>
										<td><input readonly="readonly" value="${orderInfo.Order.auditEmpName }" /></td>
									</tr>
									<tr>
										<td style="vertical-align: top;">审核意见</td>
										<td colspan="3"><textarea readonly="readonly"
												style="width: 426px; height: 150px;">${orderInfo.Order.auditMessage }</textarea></td>
									</tr>
								</tbody>
							</table>
							<!-- 其它信息 -->
						</div>
						<div id="tab6" class="tab_content">
							<!-- 交费信息 -->
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
										<td>总应收</td>
										<td><input readonly="readonly" class="right"
											value="${orderInfo.Order.projectMoney }" /> 元</td>
										<td>总实收</td>
										<td><input readonly="readonly" class="right"
											value="${orderInfo.Order.realMoney }" /> 元</td>
										<td>总欠缴</td>
										<td><input readonly="readonly" class="right" value="${orderInfo.Order.projectMoney-orderInfo.Order.realMoney }" />
											元</td>
									</tr>
								</tbody>
							</table>
							<table class="data display">
								<thead>
									<tr>
										<th width="30">序号</th>
										<th width="80">姓名</th>
										<th width="80">应交金额</th>
										<th width="80">实收金额</th>
										<th width="80">发票号</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="u" items="${orderInfo.OrderUser }" varStatus="vs">
									<c:if test="vs.index%2==0">
										<tr class="even">
									</c:if>
									<c:if test="vs.index%2!=0">
										<tr class="odd">
									</c:if>
										<tr class="even">
										<td>${u.id }</td>
										<td>${u.userName }</td>
										<td>${u.projectMoney }</td>
										<td>${u.realMoney }</td>
										<td>${u.invoiceNo }</td>
										<td></td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- 交费信息 -->
						</div>
					</div>
				</div>

			</div>
			<!-- .x12 -->

		</div>
		<!-- #content -->

		<div id="footer">
			<div class="content_pad">
				<p>
					&copy; 2013-11 版权所有 <a href="#">湖南省自来水公司</a>. 技术支持 <a href="#">华瑞教育</a>.
				</p>
			</div>
			<!-- .content_pad -->
		</div>
		<!-- #footer -->

	</div>
	<!-- #wrapper -->



	<script type="text/javascript">
		$(document).ready(function() {
			Dashboard.init();

			//选项卡初始化
			$('.tab_container').tabs();
		});
	</script>

</body>

</html>