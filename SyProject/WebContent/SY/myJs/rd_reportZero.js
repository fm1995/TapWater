/**
 * 页面加载时把抄表年月加载到下拉列表里，并根据默认条件查询第一页数据
 */
$(document).ready(function(){
	window.load=function(){
		$.post("/SyProject/SY/page/load/selAllAreaAndVolume",function(x){
				var start=$("#startTime");
				var end=$("#endTime");
				var volumeSel=$("#volumeId");
				start.empty();
				end.empty();
				volumeSel.empty();
				var arr=x.yearMonth;
				var volumes=x.volumes;
				var areas=x.areas;
				volumeSel.append('<option value="0" selected="selected">所有</option>');
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
				
				for(var i=0;i<arr.length;i++)
				{
					var value=arr[i].readYear+":"+arr[i].readMonth;
					var name=arr[i].readYear+""+arr[i].readMonth;
					if(arr[i].readMonth<10)
						name=arr[i].readYear+"0"+arr[i].readMonth;
					start.append("<option value="+value+">"+name+"</option>");
					end.append("<option value="+value+">"+name+"</option>");
				}
				var name1=arr[0].readYear+""+arr[0].readMonth;
				if(arr[0].readMonth<10)
					name1=arr[0].readYear+"0"+arr[0].readMonth;
				document.getElementById("year").innerText=name1+"—"+name1;
				sel(1);
		});
	}
	
	window.sel=function(page){
		var volumeObj=document.getElementById("volumeId");
		var volumeName=volumeObj.options[volumeObj.selectedIndex].innerText;
		var pageSize=document.getElementById("pageSize").value;
		var time1=document.getElementById("startTime").value;
		var arr1=time1.split(":");
		var time2=document.getElementById("endTime").value;
		var arr2=time2.split(":");
		var volumeId=document.getElementById("volumeId").value;
		var audit=document.getElementById("audit").value;
		var startIndex=(page-1)*pageSize;
		var table=document.getElementById("table");
		var rowCount=table.rows.length;
	    for (i=1;i<rowCount;i++){
	       table.deleteRow(1);    
	    }
	    
		$.post("/SyProject/SY/page/read/selReadByTerm",{
			"startYear":arr1[0],
			"endYear":arr2[0],
			"startMonth":arr1[1],
			"endMonth":arr2[1],
			"volumeId":volumeId,
			"audit":audit,
			"startIndex":startIndex,
			"rows":pageSize
		},function(x){
			var pageCount=x.pageCount;
			document.getElementById("pageCount").value=pageCount;
			document.getElementById("volumeText").innerHTML=volumeName;
			document.getElementById("page").value=page;
			document.getElementById("userCount").innerHTML=x.userCount;
			var reads=x.list;
			for(var i=0;i<reads.length;i++)
			{
				var tr=document.createElement("tr");
				var td1=document.createElement("td");
					td1.innerHTML=reads[i].usUser.userNo;
					td1.setAttribute("align","center");
				var td2=document.createElement("td");
					td2.innerHTML=reads[i].usUser.userName;
				var td3=document.createElement("td");
					td3.innerHTML=reads[i].preValue;
					td3.setAttribute("align","right");
				var td4=document.createElement("td");
					td4.innerHTML=reads[i].curValue;
					td4.setAttribute("align","right");
				var td5=document.createElement("td");
					td5.innerHTML=reads[i].curValue-reads[i].curValue;
					td5.setAttribute("align","right");
				var td6=document.createElement("td");
					if(reads[i].audit==0)
						td6.innerHTML="是";
					if(reads[i].audit==1)
						td6.innerHTML="否";
					td6.setAttribute("align","right");
				
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);
				tr.appendChild(td5);
				tr.appendChild(td6);
				table.appendChild(tr);
			}
		});
	}
	
	window.nuPage=function(num){
		var page=document.getElementById("page").value;
		var pageCount=document.getElementById("pageCount").value;
		page=parseInt(page)+parseInt(num);
		if(page>pageCount||num==-3)
			page=pageCount;
		if(page<=0||num==-2)
			page=1;
		
		sel(page);
			
	}
	
	load();
});