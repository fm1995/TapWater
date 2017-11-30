<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<style type="text/css">
	table.data thead th { vertical-align:middle; text-align:center; }
	.re { width:60px; text-align:center; }
	</style>
	
	<%@ include file="jQuery.jsp" %>
	<script type="text/javascript" src="/SyProject/SY/myJs/rd_audit_details.js"></script>
</head> 
 
<body> 
<input type="hidden" value="${param.volumeId }" id="volumeId">
<div id="wrapper">
	
	<%@ include file="header.jsp" %>
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">抄表审核</a></span>
			<span id="welcome_span">欢迎回来,${empLogin.empName}</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid">

		<div class="x12">
			
			<h2>
				抄表复核 - 按表册复核 - <%=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8")%>#<%=request.getParameter("index") %>
				<div style="float:right;">
					按表册复核
					<a href="rd_auditUser.jsp">按用户复核</a>
				</div>
			</h2>
			
			<div style="float:left;">
				<button class="btn-icon btn-grey btn-back" onClick="history.back(-1);"><span></span>返回</button>
			</div>
			<div style="float:right;">
				<button class="btn-icon btn-blue btn-check" onClick="auditMutil();"><span></span>复核选中的所有记录</button>
			</div>
			<br/><br/>
			
			<table class="data display">
					<thead>
						<tr>
							<th><input type="checkbox" onClick="$(':checkbox.chk').attr('checked',this.checked);"></th>
							<th>年份</th>
							<th>月份</th>
							<th>第几次<br/>抄表</th>
							<th>用户编码</th>
							<th>用户姓名</th>
							<th>上次底码</th>
							<th>本次底码</th>
							<th>用水量</th>
							<th>性质</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody id="tableBody">
						<tr class="odd">
							<td class="center"><input type="checkbox" class="chk"></td>
							<td class="center">2013</td>
							<td class="center">12</td>
							<td class="center">1</td>
							<td class="center">0100000987</td>
							<td class="center">张三</td>
							<td class="right">2056</td>
							<td class="right">2066</td>
							<td class="right">10</td>
							<td class="center">每月抄表任务</td>
							<td class="center">
								<button class="btn-icon btn-small btn-blue btn-check" onClick="audit();"><span></span>复核</button>  
							</td>
						</tr>
						<tr class="even">
							<td class="center"><input type="checkbox" class="chk"></td>
							<td class="center">2013</td>
							<td class="center">12</td>
							<td class="center">1</td>
							<td class="center">0100000987</td>
							<td class="center">张三</td>
							<td class="right">2056</td>
							<td class="right">2066</td>
							<td class="right">10</td>
							<td class="center">每月抄表任务</td>
							<td class="center">
								<button class="btn-icon btn-small btn-blue btn-check" onClick="audit();"><span></span>复核</button>  
							</td>
						</tr>
						<tr class="odd">
							<td class="center"><input type="checkbox" class="chk"></td>
							<td class="center">2013</td>
							<td class="center">12</td>
							<td class="center">1</td>
							<td class="center">0100000987</td>
							<td class="center">张三</td>
							<td class="right">2056</td>
							<td class="right">2066</td>
							<td class="right">10</td>
							<td class="center">每月抄表任务</td>
							<td class="center">
								<button class="btn-icon btn-small btn-blue btn-check" onClick="audit();"><span></span>复核</button>  
							</td>
						</tr>
						<tr class="even">
							<td class="center"><input type="checkbox" class="chk"></td>
							<td class="center">2013</td>
							<td class="center">12</td>
							<td class="center">1</td>
							<td class="center">0100000987</td>
							<td class="center">张三</td>
							<td class="right">2056</td>
							<td class="right">2066</td>
							<td class="right">10</td>
							<td class="center">每月抄表任务</td>
							<td class="center">
								<button class="btn-icon btn-small btn-blue btn-check" onClick="audit();"><span></span>复核</button>  
							</td>
						</tr>
						<tr class="odd">
							<td class="center"><input type="checkbox" class="chk"></td>
							<td class="center">2013</td>
							<td class="center">12</td>
							<td class="center">1</td>
							<td class="center">0100000987</td>
							<td class="center">张三</td>
							<td class="right">2056</td>
							<td class="right">2066</td>
							<td class="right">10</td>
							<td class="center">每月抄表任务</td>
							<td class="center">
								<button class="btn-icon btn-small btn-blue btn-check" onClick="audit();"><span></span>复核</button>  
							</td>
						</tr>
						<tr class="even">
							<td class="center"><input type="checkbox" class="chk"></td>
							<td class="center">2013</td>
							<td class="center">12</td>
							<td class="center">1</td>
							<td class="center">0100000987</td>
							<td class="center">张三</td>
							<td class="right">2056</td>
							<td class="right">2066</td>
							<td class="right">10</td>
							<td class="center">每月抄表任务</td>
							<td class="center">
								<button class="btn-icon btn-small btn-blue btn-check" onClick="audit();"><span></span>复核</button>  
							</td>
						</tr>
						<tr class="odd">
							<td class="center"><input type="checkbox" class="chk"></td>
							<td class="center">2013</td>
							<td class="center">12</td>
							<td class="center">1</td>
							<td class="center">0100000987</td>
							<td class="center">张三</td>
							<td class="right">2056</td>
							<td class="right">2066</td>
							<td class="right">10</td>
							<td class="center">每月抄表任务</td>
							<td class="center">
								<button class="btn-icon btn-small btn-blue btn-check" onClick="audit();"><span></span>复核</button>  
							</td>
						</tr>
						<tr class="even">
							<td class="center"><input type="checkbox" class="chk"></td>
							<td class="center">2013</td>
							<td class="center">12</td>
							<td class="center">1</td>
							<td class="center">0100000987</td>
							<td class="center">张三</td>
							<td class="right">2056</td>
							<td class="right">2066</td>
							<td class="right">10</td>
							<td class="center">每月抄表任务</td>
							<td class="center">
								<button class="btn-icon btn-small btn-blue btn-check" onClick="audit();"><span></span>复核</button>  
							</td>
						</tr>
						<tr class="odd">
							<td class="center"><input type="checkbox" class="chk"></td>
							<td class="center">2013</td>
							<td class="center">12</td>
							<td class="center">1</td>
							<td class="center">0100000987</td>
							<td class="center">张三</td>
							<td class="right">2056</td>
							<td class="right">2066</td>
							<td class="right">10</td>
							<td class="center">每月抄表任务</td>
							<td class="center">
								<button class="btn-icon btn-small btn-blue btn-check" onClick="audit();"><span></span>复核</button>  
							</td>
						</tr>
						<tr class="even">
							<td class="center"><input type="checkbox" class="chk"></td>
							<td class="center">2013</td>
							<td class="center">12</td>
							<td class="center">1</td>
							<td class="center">0100000987</td>
							<td class="center">张三</td>
							<td class="right">2056</td>
							<td class="right">2066</td>
							<td class="right">10</td>
							<td class="center">每月抄表任务</td>
							<td class="center">
								<button class="btn-icon btn-small btn-blue btn-check" onClick="audit();"><span></span>复核</button>  
							</td>
						</tr>
						<tr class="odd">
							<td class="center"><input type="checkbox" class="chk"></td>
							<td class="center">2013</td>
							<td class="center">12</td>
							<td class="center">1</td>
							<td class="center">0100000987</td>
							<td class="center">张三</td>
							<td class="right">2056</td>
							<td class="right">2066</td>
							<td class="right">10</td>
							<td class="center">每月抄表任务</td>
							<td class="center">
								<button class="btn-icon btn-small btn-blue btn-check" onClick="audit();"><span></span>复核</button>  
							</td>
						</tr>
						<tr class="even">
							<td class="center"><input type="checkbox" class="chk"></td>
							<td class="center">2013</td>
							<td class="center">12</td>
							<td class="center">1</td>
							<td class="center">0100000987</td>
							<td class="center">张三</td>
							<td class="right">2056</td>
							<td class="right">2066</td>
							<td class="right">10</td>
							<td class="center">每月抄表任务</td>
							<td class="center">
								<button class="btn-icon btn-small btn-blue btn-check" onClick="audit();"><span></span>复核</button>  
							</td>
						</tr>
						<tr class="odd">
							<td class="center"><input type="checkbox" class="chk"></td>
							<td class="center">2013</td>
							<td class="center">12</td>
							<td class="center">1</td>
							<td class="center">0100000987</td>
							<td class="center">张三</td>
							<td class="right">2056</td>
							<td class="right">2066</td>
							<td class="right">10</td>
							<td class="center">每月抄表任务</td>
							<td class="center">
								<button class="btn-icon btn-small btn-blue btn-check" onClick="audit();"><span></span>复核</button>  
							</td>
						</tr>
						<tr class="even">
							<td class="center"><input type="checkbox" class="chk"></td>
							<td class="center">2013</td>
							<td class="center">12</td>
							<td class="center">1</td>
							<td class="center">0100000987</td>
							<td class="center">张三</td>
							<td class="right">2056</td>
							<td class="right">2066</td>
							<td class="right">10</td>
							<td class="center">每月抄表任务</td>
							<td class="center">
								<button class="btn-icon btn-small btn-blue btn-check" onClick="audit();"><span></span>复核</button>  
							</td>
						</tr>
						<tr class="odd">
							<td class="center"><input type="checkbox" class="chk"></td>
							<td class="center">2013</td>
							<td class="center">12</td>
							<td class="center">1</td>
							<td class="center">0100000987</td>
							<td class="center">张三</td>
							<td class="right">2056</td>
							<td class="right">2066</td>
							<td class="right">10</td>
							<td class="center">每月抄表任务</td>
							<td class="center">
								<button class="btn-icon btn-small btn-blue btn-check" onClick="audit();"><span></span>复核</button>  
							</td>
						</tr>
						<tr class="even">
							<td class="center"><input type="checkbox" class="chk"></td>
							<td class="center">2013</td>
							<td class="center">12</td>
							<td class="center">1</td>
							<td class="center">0100000987</td>
							<td class="center">张三</td>
							<td class="right">2056</td>
							<td class="right">2066</td>
							<td class="right">10</td>
							<td class="center">每月抄表任务</td>
							<td class="center">
								<button class="btn-icon btn-small btn-blue btn-check" onClick="audit();"><span></span>复核</button>  
							</td>
						</tr>
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