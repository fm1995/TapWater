/**
 * 表册管理
 */
$(document).ready(function(){
	var data;
	window.load=function(){
		$.post("/SyProject/SY/page/load/selAllAreaAndVolume",function(x){
				var volumeSel=$("#select_area");
				volumeSel.empty();
				var volumes=x.volumes;
				var areas=x.areas;
				volumeSel.append('<option value="" selected="selected"></option>');
				volumeSel.append('<option value="0">未分配</option>');
				var str="";
				for(var i=0;i<areas.length;i++)
				{
					str+='<optgroup label="'+areas[i].areaName +'">';
					for(var j=0;j<volumes.length;j++)
					{
						if(areas[i].areaId==volumes[j].areaId){
							str+='<option value="'+volumes[j].id+'">'+volumes[j].volumeName+'</option>';
						}
					}
					str+='</optgroup>';
				}
				volumeSel.append(str);
				
				loadMenu(x);
				selData(0,'未分配表册的用户');
		});
	}
	
	window.selData=function(volumeId,volumeStr){
		var pageSize=parseInt(document.getElementById("pageSize").value);
		var page=parseInt(document.getElementById("page").innerHTML);
		document.getElementById("spanTitle").innerHTML=volumeStr;
		document.getElementById("select_area").options.selectedIndex=0;
		document.getElementById("volumeId").value=volumeId;
		$.post("userVolume/selByTerm",{
			"volumeId":volumeId,
			"startIndex":(page-1)*pageSize,
			"rows":pageSize
			},function(x){
			document.getElementById("pageCount").innerHTML=x.pageCount;
			data=x.users;
			document.getElementById("count").innerHTML=x.count;
			initData(document.getElementById("key"));
				
		});
	}
	
	window.loadMenu=function(x){
		
		var volumes=x.volumes;
		var areas=x.areas;
		var url="'rd_volume_add.jsp'";
		var strName="'未分配表册的用户'";
		var trStr='<h2>表册管理</h2><p><br/><div style="float:left;height:42px;">'+
		'<button class="btn-icon btn-plus" onClick="location='+url+';"><span></span>'+
		'添加表册</button></div></p><table class="data display"><thead><tr>'+
		'<th>未分配表册的用户</th><th></th></tr></thead><tbody><tr class="odd gradeX">'+
		'<td><a href="javaScript:selData(0,'+strName+')">未分配表册的用户</a></td><td class="right">&nbsp;</td></tr>'+
		'</tbody></table>';
		
		for(var i=0;i<areas.length;i++)
		{
			
			trStr+='<table class="data display"><thead><tr><th>'+areas[i].areaName+'</th><th></th></tr></thead><tbody>';
			for(var j=0;j<volumes.length;j++)
			{
				var volumeStr1="'表册【"+volumes[j].volumeName+"】中的用户'";
				if(areas[i].areaId==volumes[j].areaId){
					trStr+='<tr class="odd gradeX"><td><a href="javaScript:selData('+volumes[j].id+','+volumeStr1+')">'+volumes[j].volumeName+
					'</a></td><td class="right"><a href="rd_volume_update.jsp?id='+volumes[j].id+'">[修改]</a>'+
					'<a href="javaScript:del('+volumes[j].id+')"  rel="facebox">[删除]</a></td></tr>';
				}
			}
			trStr+='</tbody></table></td>';
		}
		var table=document.getElementById("parent_table");
		table.rows[0].cells[0].innerHTML=trStr;
	
	}
	
	window.del=function(id){
		document.getElementById("delId").value=id;
		$.facebox({div:'#facebox_delete'});
	}
	
	window.toDel=function(){
		var id=$("#delId").val();
		closeDialog();
		$.post("volume/delById",{
			"volumeId":id
		},function(x){	
			load();
		});	
	}
	
	window.toUpVolumeId=function(){
		closeDialog();
		var volumeId=$("#select_area").val();
		var arr=document.getElementsByName("userNo");
		var userNos="";
		for(var i=0;i<arr.length;i++)
		{
			if(arr[i].checked)
			{
				userNos+=arr[i].value+":";
			}
		}
		if(userNos!="")
		{
			$.post("/SyProject/SY/page/userVolume/upVolumeIdToNull",{
				"userNos":userNos.substring(0,userNos.length-1),
				"volumeId":volumeId
			},function(x){
				selData(0);
			});
		}
	}
	
	window.nuPage=function(num){
		var page=document.getElementById("page").innerHTML;
		var pageCount=document.getElementById("pageCount").innerHTML;
		page=parseInt(page)+parseInt(num);
		if(page>pageCount||num==-3)
			page=pageCount;
		if(page<=0||num==-2)
			page=1;
		document.getElementById("page").innerHTML=page;
		var volumeId=document.getElementById("volumeId").value;
		var volumeName=document.getElementById("spanTitle").innerHTML;
		selData(volumeId,volumeName);
			
	}
	
	window.nuPage1=function(){
		var volumeId=document.getElementById("volumeId").value;
		var volumeName=document.getElementById("spanTitle").innerHTML;
		selData(volumeId,volumeName);		
	}
	
	window.keySel=function(obj){
		initData(obj);	
	}
	
	window.initData=function(obj){
		var keyValue=obj.value;
		var table=document.getElementById("tab");
		var rowCount=table.rows.length;
		for (i=1;i<rowCount;i++){
		       table.deleteRow(1);    
		    }
	    for (var i=0;i<data.length;i++)
		{
	    	if(data[i].userNo.indexOf(keyValue)>=0
	    			//||data[i].orderUser.meterName.indexOf(keyValue)>=0
	    			||data[i].userName.indexOf(keyValue)>=0
	    			||data[i].address.indexOf(keyValue)>=0
	 
	    			){
	    		var tr=document.createElement("tr");
		    		tr.setAttribute("class","odd gradeX");
		    	var td1=document.createElement("td");
		    		td1.innerHTML='<input type="checkbox" name="userNo" value="'+data[i].userNo+'" />';
		    	var td2=document.createElement("td");
		    	var userNo='"'+data[i].userNo+'"';
		    		td2.innerHTML="<a href='javaScript:upIndex("+userNo+","+data[i].volumeOrderIndex+");'>未分配</a>";
		    	if(data[i].volumeOrderIndex>0)
		    		td2.innerHTML="<a href='javaScript:upIndex("+userNo+","+data[i].volumeOrderIndex+");'>"+data[i].volumeOrderIndex+"</a>";
		    	var td3=document.createElement("td");
		    		td3.innerHTML=data[i].userNo;
		    	var td4=document.createElement("td");
		    		td4.innerHTML="";
		    		if(data[i].orderUser.meterName!=undefined)
		    			td4.innerHTML=data[i].orderUser.meterName;
		    	var td5=document.createElement("td");
		    		td5.innerHTML=data[i].userName;
		    	var td6=document.createElement("td");
		    		td6.innerHTML=data[i].address;
		    		tr.appendChild(td1);
		    		tr.appendChild(td2);
		    		tr.appendChild(td3);
		    		tr.appendChild(td4);
		    		tr.appendChild(td5);
		    		tr.appendChild(td6)
		    		table.appendChild(tr);
	    	}
		}
	}
	
	window.upIndex=function(id,x){
		window.showModalDialog('rd_volume_1_setOrder.jsp?id='+id+'&volumeIndex='+x,null,'dialogWidth:560px;dialogHeight:200px;');
		nuPage1();
	}
	load();
});
