<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>湖南省自来水公司营销管理信息系统</title>
<%@include file="left.jsp"%>
<script type="text/javascript">
var mysubmit=function() {
	if (document.getElementById("code").value == "") {
		document.getElementById("no").style.display="inline";
		document.getElementById("no").innerHTML = "附加费编码不能为空";
		return false;
	}else{
		document.getElementById("no").style.display="none";
	}
	if (document.getElementById("name").value == "") {
		document.getElementById("no1").style.display="inline";
		document.getElementById("no1").innerHTML = "附加费简称不能为空";
		return false;
	}else{
		document.getElementById("no1").style.display="none";
	}
	if (document.getElementById("full").value == "") {
		document.getElementById("no2").style.display="inline";
		document.getElementById("no2").innerHTML = "附加费名称不能为空";
		return false;
	}else{
		document.getElementById("no2").style.display="none";
	}
	if (document.getElementById("price").value == "") {
		document.getElementById("no3").style.display="inline";
		document.getElementById("no3").innerHTML = "附加费单价不能为空";
		return false;
	}else{
		document.getElementById("no3").innerHTML = "元/吨";
	}
	if (document.getElementById("text").checked == false) {
		document.getElementById("no4").style.display="inline";
		document.getElementById("no4").innerHTML = "征收范围不能为空";
		return false;
	}else{
		document.getElementById("no4").style.display="none";
	}
	if (document.getElementById("remark").value== "") {
		document.getElementById("no5").style.display="inline";
		document.getElementById("no5").innerHTML = "备注不能为空";
		return false;
	}else{
		document.getElementById("no5").style.display="none";
	}
	document.frm.submit();
}
</script>
</head>

<body>

	<div id="wrapper">
		<%@include file="header.jsp"%>
		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">附加费设定</a></span> <span
					id="welcome_span">欢迎回来,${empLogin.empName}</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">

			<form action="/SyProject/sy/saveSurcharge" method="post" name="frm">
				<input type="hidden" value="1" name="costtypeKind"> <input
					type="hidden" value="0" name="costtypeDisabled">
				<div class="x12">

					<h2>添加/修改附加费</h2>

					<div class="form label-inline uniform">

						<div class="field">
							<label for="id">附加费ID</label> <input id="id" name="fname"
								size="50" type="text" class="medium" disabled="disabled"
								value="自动生成" />
						</div>

						<div class="field">
							<label for="name">附加费编码</label> <input id="code"
								name="costtypeCode" size="50" onblur="mysubmit()" type="text" class="medium" /><span id="no" style="display: none; color: red"></span>
						</div>

						<div class="field">
							<label for="name">附加费简称</label> <input id="name"
								name="costTypeName" size="50" onblur="mysubmit()" type="text" class="medium" /><span id="no1" style="display: none; color: red"></span>
						</div>

						<div class="field">
							<label for="name">附加费全称</label> <input id="full"
								name="costtypeFullName" onblur="mysubmit()" size="50" type="text" class="medium" /><span id="no2" style="display: none; color: red"></span>
						</div>

						<div class="field">
							<label for="name">附加费单价</label> <input id="price"
								name="costtypePrice" size="50" onblur="mysubmit()" type="text" class="medium" /><span id="no3" style="display:inline; color: red">元/吨</span>
							</div>

						<div class="controlset field">

							<span class="label">征收范围</span>
							<div class="controlset-pad">
						<c:forEach items="${ListCost}" var="li">
									<input type="checkbox" id="text" onblur="mysubmit()" name="cost"
										value="${li.costtypeId}-${li.costTypeName}"/>${li.costTypeName}<br>
						</c:forEach>
									<span id="no4" style="display: none; color: red"></span>
							</div>
						</div>
						<div class="field">
							<label for="description">备注</label>
							<textarea rows="7" cols="50" id="remark" name="costtypeRemark"></textarea><span id="no5" style="display: none; color: red"></span>
						</div>

						<div class="buttonrow">
							<input type="button" class="btn" value="保存" onclick="mysubmit()" />
							<input type="button" class="btn btn-grey" value="返回"
								onclick="history.back(-1);" />
						</div>

					</div>

				</div>
				<!-- .x12 -->
			</form>
		</div>
		<!-- #content -->

		<div id="footer">
			<div class="content_pad">
				<p>
					&copy; 2015版权所有 <a href="#">湖南省自来水公司</a>. 技术支持 <a href="#">华瑞教育</a>.
				</p>
			</div>
			<!-- .content_pad -->
		</div>
		<!-- #footer -->

	</div>
	<!-- #wrapper -->

<%-- <%@include file="jQuery.jsp" %> --%>

	<script type="text/javascript">
		$(document).ready(function() {
			Dashboard.init();
		});
	</script>

</body>

</html>