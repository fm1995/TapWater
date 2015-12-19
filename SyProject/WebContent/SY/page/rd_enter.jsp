<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>湖南省自来水公司营销管理信息系统</title>

<%@ include file="/SY/page/linkDocuments.jsp"%>
<%@include file="/SY/page/jQuery.jsp"%>
<script type="text/javascript" src="/SyProject/SY/myJs/rd_enter.js"></script>

<style type="text/css">
input.enter {
	-moz-box-shadow: none;
	-webkit-box-shadow: none;
	box-shadow: none;
	-moz-border-radius: 0px;
	-webkit-border-radius: 0px;
	border-radius: 0px;
	border: 1px solid #000;
	margin: 0px;
	padding: 0px;
	background: none;
	width: 98%;
	height: 100%;
	text-align: right;
}

table.data tbody td.enter {
	padding: 0px;
	margin: 0px;
	width: 100px;
	vertical-align: middle;
}

.right a {
	color: #000;
}

.state0 {
	color: #999;
} /*待抄*/
.state1 {
	color: #000;
} /*已抄未复核*/
.state2 {
	color: #0000FF;
} /*已复核*/
</style>
<script type="text/javascript">
	function setNotEnter(user_no,id) {
		showDialog('确认将此条[' + user_no + ']更改为待抄状态吗？', function() {
			upToWaitCopy(id);
		}); 
	}

	//修改最大表码值
	function setMaxValue(user_no) {
		showWindow({
			url : '/SyProject/SY/page/rd_enter_setMaxValue.jsp?user_no='+user_no,
			width : 560,
			height : 340
		});
		queryFromUser();
	}

	//修改上月底码 
	function setPreValue(user_no) {
		showWindow({
			url : '/SyProject/SY/page/rd_enter_setPreValue.jsp?user_no='+user_no,
			width : 560,
			height : 540
		});
		queryFromUser();
	}
	
	flag=false;
	//	只允许输入数字
	function numBox(obj,maxValue,id){
		var reg=/^\d$/;
		var f=reg.test(obj.value);
		if(f){
			flag=true;
		}
		var max_value=document.getElementById(id);
		obj.value=obj.value.replace(/\D/gi,"");
		var v=parseInt(obj.value);
		if(v>parseInt(maxValue)){
			max_value.style.color="green";
			obj.style.color="red";
			obj.focus();
		}else{
			max_value.style.color="black";
			obj.style.color="black";
		}
	}
	
	var textChaned=function(id){
		if(flag){
			mouseBlur(id);
			flag=false;
		}
	}
</script>
</head>

<body>
	<div id="wrapper">
		<%@include file="/SY/page/header.jsp"%>
		<!-- #header -->
		<div id="masthead">
			<div>
				<span id="pagetitle"><a href="javascript:;">抄表录入</a></span> <span
					id="welcome_span">欢迎回来，马云</span>
			</div>
		</div>
		<!-- #masthead -->

		<div id="content" class="xgrid">

			<div class="x12">

				<h2>
					抄表录入 - <span id="curYearMonth"></span> - <span id="volume_name">*****</span>（共<span id="total"></span>户）
					<div style="float: right;">
						选择表册 <select id="areas_volumes" class="medium" onchange="changeOption();">
						</select>
					</div>
				</h2>

				<table class="data display" id="tb">
					<thead>
						<tr>
							<th>用户编码</th>
							<th>表身码</th>
							<th>最大表码值</th>
							<th width="100">用户姓名</th>
							<th>上月表码数</th>
							<th>本月表码数</th>
							<th>实际用水量</th>
							<th width="200">状态</th>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>

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
		$(document).ready(
				function() {
					Dashboard.init();

					//抄表处理
					$('.enter').keyup(
							function(e) {
								e = e ? e : event;
								var key = e.keyCode;
								if (key == 13 || key == 40) {
									var input = $(this).parent().parent()
											.next().find('input.enter');
									if (input.length)
										input.get(0).select();
								} else if (key == 38) {
									var input = $(this).parent().parent()
											.prev().find('input.enter');
									if (input.length)
										input.get(0).select();
								}
							});

				});
	</script>

</body>

</html>