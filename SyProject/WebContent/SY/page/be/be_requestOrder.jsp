<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE jsp PUBLIC "-//W3C//DTD jsp 4.01 Transitional//EN" "http://www.w3.org/TR/jsp4/loose.dtd">
<jsp xmlns="http://www.w3.org/1999/xjsp"> 
 
<head> 
	<meta http-equiv="Content-type" content="text/jsp; charset=utf-8" /> 
	<title>湖南省自来水公司营销管理信息系统</title> 
	
	<%@include file="../linkDocuments.jsp" %>
	<style type="text/css">
	a.metro {
		float:left; margin:4px 16px; font-size:20px; font-weight:bold;
		color:#FFFFFF;background-color:#666666;text-align:center;
	    line-height:100px;display:block;width:200px; vertical-align:middle;
	}
	a.metro:hover{
		background-color:#000033; text-decoration:none;
	}
	</style>
</head> 
 
<body> 

<div id="wrapper">	
	
	<%@include file="../header.jsp" %>
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">用户申请</a></span>
			<span id="welcome_span">欢迎回来，马云</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid">
		
 		
		<div class="x12">
			
			<h2>
				正在等待【用户申请】的工单
				<a style="float:right" href="javascript:history.back(-1);">返回</a>
			</h2>
			
			<table class="data display">
					<thead>
						<tr>
							<th width="120">工单号</th>
							<th width="60">类型</th>
							<th width="80">进度</th>
							<th width="90">当前处理部门</th>
							<th width="100">最后操作日期</th>
							<th width="200">用户名称</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr class="odd">
							<td><a href="/SyProject/SY/page/be/be_orderInfo.jsp?id=B1-20140105-0001" target="orderInfo">B1-20140105-0001</a></td>
							<td>新户</td>
							<td>用户申请</td>
							<td>收费室</td>
							<td>2014-02-18</td>
							<td>许三多</td>
							<td><button class="btn-icon btn-small btn-blue btn-check" onClick="location.href = 'be_request1.jsp';"><span></span>处理</button></td>
						</tr>
						<tr class="even">
							<td><a href="/SyProject/SY/page/be/be_orderInfo.jsp?id=B1-20140105-0001" target="orderInfo">B1-20140117-0002</a></td>
							<td>分户</td>
							<td>用户申请</td>
							<td>收费室</td>
							<td>2014-02-18</td>
							<td>许四多</td>
							<td><button class="btn-icon btn-small btn-blue btn-check" onClick="location.href = 'be_request2.jsp';"><span></span>处理</button></td>
						</tr>
						<tr class="odd">
							<td><a href="/SyProject/SY/page/be/be_orderInfo.jsp?id=B1-20140105-0001" target="orderInfo">B1-20140105-0003</a></td>
							<td>过户</td>
							<td>用户申请</td>
							<td>收费室</td>
							<td>2014-02-18</td>
							<td>许五多</td>
							<td><button class="btn-icon btn-small btn-blue btn-check" onClick="location.href = 'be_request3.jsp';"><span></span>处理</button></td>
						</tr>
						<tr class="even">
							<td><a href="/SyProject/SY/page/be/be_orderInfo.jsp?id=B1-20140105-0001" target="orderInfo">B1-20140105-0004</a></td>
							<td>代扣</td>
							<td>用户申请</td>
							<td>收费室</td>
							<td>2014-02-18</td>
							<td>中国农业银行解放路支行</td>
							<td><button class="btn-icon btn-small btn-blue btn-check" onClick="location.href = 'be_request4.jsp';"><span></span>处理</button></td>
						</tr>
						<tr class="odd">
							<td><a href="/SyProject/SY/page/be/be_orderInfo.jsp?id=B1-20140105-0001" target="orderInfo">B1-20140105-0005</a></td>
							<td>换表</td>
							<td>用户申请</td>
							<td>收费室</td>
							<td>2014-02-18</td>
							<td>中国联通广东路营业厅</td>
							<td><button class="btn-icon btn-small btn-blue btn-check" onClick="location.href = 'be_request5.jsp';"><span></span>处理</button></td>
						</tr>
						<tr class="even">
							<td><a href="/SyProject/SY/page/be/be_orderInfo.jsp?id=B1-20140105-0001" target="orderInfo">B1-20140105-0006</a></td>
							<td>重签</td>
							<td>用户申请</td>
							<td>收费室</td>
							<td>2014-02-18</td>
							<td>许八多</td>
							<td><button class="btn-icon btn-small btn-blue btn-check" onClick="location.href = 'be_request6.jsp';"><span></span>处理</button></td>
						</tr>
						<tr class="odd">
							<td><a href="/SyProject/SY/page/be/be_orderInfo.jsp?id=B1-20140105-0001" target="orderInfo">B1-20140105-0007</a></td>
							<td>销户</td>
							<td>用户申请</td>
							<td>收费室</td>
							<td>2014-02-18</td>
							<td>许蛮多</td>
							<td><button class="btn-icon btn-small btn-blue btn-check" onClick="location.href = 'be_request7.jsp';"><span></span>处理</button></td>
						</tr>
						<tr class="even">
							<td><a href="/SyProject/SY/page/be/be_orderInfo.jsp?id=B1-20140105-0001" target="orderInfo">B1-20140105-0008</a></td>
							<td>分户</td>
							<td>用户申请</td>
							<td>收费室</td>
							<td>2014-02-18</td>
							<td>新多国际商务大厦</td>
							<td><button class="btn-icon btn-small btn-blue btn-check" onClick="location.href = 'be_request2.jsp';"><span></span>处理</button></td>
						</tr>
						<tr class="odd">
							<td><a href="/SyProject/SY/page/be/be_orderInfo.jsp?id=B1-20140105-0001" target="orderInfo">B1-20140105-0009</a></td>
							<td>新户</td>
							<td>用户申请</td>
							<td>收费室</td>
							<td>2014-02-18</td>
							<td>许钱多</td>
							<td><button class="btn-icon btn-small btn-blue btn-check" onClick="location.href = 'be_request1.jsp';"><span></span>处理</button></td>
						</tr>
						<tr class="even">
							<td><a href="/SyProject/SY/page/be/be_orderInfo.jsp?id=B1-20140105-0001" target="orderInfo">B1-20140105-0010</a></td>
							<td>重签</td>
							<td>用户申请</td>
							<td>收费室</td>
							<td>2014-02-18</td>
							<td>许翔多</td>
							<td><button class="btn-icon btn-small btn-blue btn-check" onClick="location.href = 'be_request6.jsp';"><span></span>处理</button></td>
						</tr>
					</tbody>
				</table>
				<div class="page">
					<a href="#">第一页</a>
					<a href="#">上一页</a>
					<input class="pageIndex" value="1"/> / <input class="pageCount" readonly="readonly" value="98765" />
					<a href="#">下一页</a>
					<a href="#">第未页</a>
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

<script src="/SyProject/SY/js/widgets.js"></script>
<script src="/SyProject/SY/js/dashboard.js"></script>

<script type="text/javascript">
	
$(document).ready ( function () 
{
	Dashboard.init ();		
});

</script>

</body> 
 
</jsp>