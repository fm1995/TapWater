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
	<%@ include file="jQuery.jsp" %>
	<script type="text/javascript" src="/SyProject/SY/myJs/rd_volume.js"></script>
</head> 
 
<body> 
<input type="hidden" id="volumeId" value="0"/>
<div id="wrapper">
	
		
	
	<%@ include file="header.jsp" %>
	<input type="hidden" id="delId">
	<!-- #header -->	
	
	<div id="masthead">
		<div>
			<span id="pagetitle"><a href="javascript:;">表册管理</a></span>
			<span id="welcome_span">欢迎回来,${empLogin.empName}</span>
		</div>
	</div> <!-- #masthead -->	
	
	<div id="content" class="xgrid">
	 		
		<div class="x12">
		
			<div id="facebox_delete" style="display: none">
				<div style="height:80px;text-align:center;padding-top:50px;">
					删除后此表册的用户为未分配，确认删除此表册吗？
				</div>
				
				<div class="dialogbutton center">
					<a class="btn" href="javascript:toDel();" style="width:60px;">是</a>  
					<a class="btn btn-grey" href="javascript:closeDialog();" style="width:60px;">否</a>
				</div>
			</div>
			
			<div id="facebox_setVolume" style="display: none">
				<div id="facebox_setVolume_message" style="height:80px;text-align:center;padding-top:50px;">
					确认移动到此表册吗？
				</div>
				
				<div class="dialogbutton center">
					<a class="btn" href="javascript:toUpVolumeId()" style="width:60px;">是</a>  
					<a class="btn btn-grey" href="javascript:closeDialog();" style="width:60px;">否</a>
				</div>
			</div>
			
			<table id="parent_table">
				<tr><td width="30%">
					
					</td>
					<td width="1%">&nbsp;</td>
					<td width="69%">
						<h2><span id="spanTitle">未分配表册的用户</span></h2>
					
						<div style="float:right;">
							分配至 
							<select id="select_area" class="medium" onChange="setVolume();" >
							</select>
						</div><br><br>
						<div style="float:left;">
						每页显示 
							<select id="pageSize" class="medium" onChange="nuPage(-2)" >
								<option selected="selected" value="10">10</option>
								<option value="20">20</option>
								<option value="40">40</option>
								<option value="80">80</option>
								<option value="150">150&nbsp;&nbsp;&nbsp;</option>
							</select>
						</div>
						<div style="float:right;">
						搜索 <input type="text" id="key" onkeyup="keySel(this)"/>
						</div>
						<table class="data display datatableVolume" id="tab">
							<thead>
								<tr>
									<th width="40">&nbsp;</th>
									<th width="80">排序号</th>
									<th width="80">用户编码</th>
									<th width="80">表身码</th>
									<th width="80">用户姓名</th>
									<th width="80">地址</th>
								</tr>
							</thead>
							<tbody>
								<tr class="odd gradeX">
									<td><input type="checkbox" /></td>
									<td>未分配</td>
									<td>010012345</td>
									<td>02010631</td>
									<td>张三</td>
									<td>十里口8号</td>
								</tr>
								</tbody>
						</table>
						<div style="float:left;">总共<span id="count"></span>条数据</div>
						<div style="float:right;">
							<a href="javaScript:nuPage(-2)">第一页</a>
							<a href="javaScript:nuPage(-1)">上一页</a>
							<span id="page">1</span> / <span id="pageCount"></span>
							<a href="javaScript:nuPage(1)">下一页</a>
							<a href="javaScript:nuPage(-3)">第未页</a>
						</div>
			
					</td>
				</tr>
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
	
	
	/* $('.datatableVolume').dataTable({
		serverSide : false,
		iDisplayLength : 20,         //默认情况下，一页显示多少条
		sAjaxSource : "userVolume/test",
		 aoColumns : [  {  
            "mDataProp" : "readYear",  
            "sTitle" : "年份",  
            "sDefaultContent" : "",  
            "sClass" : "center"  
         }], 
		bSerchable:true,
		fnServerData : function(sSource, aDataSet, fnCallback) {  
			 $.ajax({  
				"dataType" : 'json',  
				"type" : "POST",  
			    "url" : sSource,  
			    "data" : aDataSet,  
			    "success" : function(json){
			    	alert(json.recordsTotal);
			    }  
			     });  
		  }   */

		
		/* "fnRender": function(x){
			//alert(x+"qqq");
			return x;
		} 



	});*/
	
}); 
 
//设置用户所属表册
 function setVolume(){
    var areaText=document.getElementById('select_area').options[document.getElementById('select_area').options.selectedIndex].text;
	if(areaText=='')return;
	if(areaText=='未分配'){
		$('#facebox_setVolume_message').text('确认将选择的用户变成未分配表册的用户吗？');
		$.facebox({div:'#facebox_setVolume'});
	}else{
		$('#facebox_setVolume_message').text('确认将选择的用户分配到表册【'+areaText+'】中吗？');
		$.facebox({div:'#facebox_setVolume'});
	}
}



</script>

</body> 
 
</html>