<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>湖南省自来水公司营销管理信息系统</title>
<%@include file="left.jsp"%>
</head>
<script type="text/javascript">
	function mysubmit() {
		if ($("#name").val() == "") {
			document.getElementById("no").style.display = "inline";
			document.getElementById("no").innerHTML = "水表型号名称不能为空";
			return false;
		}else{
			document.getElementById("no").style.display = "none";
		}
		if ($("#Aperture").val()== "") {
			document.getElementById("no1").style.display = "inline";
			document.getElementById("no1").innerHTML = "设置口径不能为空";
			return false;
		}else{
			document.getElementById("no1").style.display = "none";
		}
		if ($("#MaxValue").val()== "") {
			document.getElementById("no2").style.display = "inline";
			document.getElementById("no2").innerHTML = "最大表码不能为空";
			return false;
		}else{
			document.getElementById("no2").style.display = "none";
		}
		if ($("#MinValue").val() == "") {
			document.getElementById("no3").style.display = "inline";
			document.getElementById("no3").innerHTML = "下限设置不能为空";
			return false;
		}else{
			document.getElementById("no3").style.display = "inline";
			document.getElementById("no3").innerHTML = "吨";
		}
		if ($("#Life").val() == "") {
			document.getElementById("no4").style.display = "inline";
			document.getElementById("no4").innerHTML = "周检年限不能为空";
			return false;
		}else{
			document.getElementById("no4").style.display = "inline";
			document.getElementById("no4").innerHTML = "年";
		}
		if ($("#Remark").val() == "") {
			document.getElementById("no5").style.display = "inline";
			document.getElementById("no5").innerHTML = "备注不能为空";
			return false;
		}else{
			document.getElementById("no5").style.display = "none";
		}
		document.frm.submit();
	}
</script>
<body>

	<div id="wrapper">
		<%@include file="header.jsp"%>
		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">抄表辖区设置</a></span> <span
					id="welcome_span">欢迎回来，${empLogin.empName}</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">
			<form name="frm" action="/SyProject/sy/saveMeter" method="post">
			<input type="hidden" name="metertypeDisabled" value="0"/>
				<div class="x12">

					<h2>添加/修改水表型号</h2>

					<div class="form label-inline uniform">

						<div class="field">
							<label for="id">水表型号ID</label> <input id="id" name="fname"
								size="50" type="text" class="medium" disabled="disabled"
								value="自动生成" />
						</div>

						<div class="field">
							<label for="name">水表型号</label> <input id="name"
								name="meterTypeName" size="50" type="text" onblur="mysubmit()" class="medium" /><span id="no" style="display: none; color: red"></span>
						</div>

						<div class="field">
							<label for="name">设置口径</label> <input id="Aperture"
								name="metertypeAperture" size="50" onblur="mysubmit()" type="text" class="medium" /><span id="no1" style="display: none; color: red"></span>
						</div>

						<div class="field">
							<label for="name">最大表码</label> <input id="MaxValue"
								name="metertypeMaxValue" size="50" onblur="mysubmit()" type="text" class="medium" /><span id="no2" style="display: none; color: red"></span>
						</div>

						<div class="field">
							<label for="name">下限设置</label> <input id="MinValue"
								name="metertypeMinValue" size="50" onblur="mysubmit()" type="text" class="medium" /><span id="no3" style="display: inline; color: red">吨</span>
							
						</div>

						<div class="field">
							<label for="name">周检年限</label> <input id="Life"
								name="metertypeLife" size="50" onblur="mysubmit()" type="text" class="medium" /><span id="no4" style="display: inline; color: red">年</span>
						</div>


						<div class="field">
							<label for="description">备注</label>
							<textarea rows="7" cols="50" id="Remark"
								name="metertypeRemark"></textarea><span id="no5" style="display: none; color: red"></span>
						</div>

						<div class="buttonrow">
								<input type="button" class="btn" value="保存" onclick="return mysubmit();"/>
								<input type="button" class="btn btn-grey" value="返回" onclick="history.back(-1);"/>
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
					&copy; 2015 版权所有 <a href="#">湖南省自来水公司</a>. 技术支持 <a href="#">华瑞教育</a>.
				</p>
			</div>
			<!-- .content_pad -->
		</div>
		<!-- #footer -->

	</div>
	<!-- #wrapper -->
<%@include file="jQuery.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			Dashboard.init();
		});
	</script>

</body>

</html>