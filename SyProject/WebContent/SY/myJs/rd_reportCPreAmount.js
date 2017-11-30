/**
 *  底码修正记录
 */

$(document).ready(function(){
	window.load=function(){
		$.post("/SyProject/SY/page/load/selByRdEmp",function(emps){
			var empSel=$("#empSel");
			empSel.empty();
			empSel.append('<option value="0" selected="selected">所有</option>');
			for(var i=0;i<emps.length;i++)
			{
				empSel.append('<option value="'+emps[i].empId+'">'+emps[i].empName+'</option>');
			}
			sel(1);
		});
		
	}
	
	window.sel=function(page){
		var table=document.getElementById("table");
		var empId=document.getElementById("empSel").value;
		var pageSize=$("#pageSize").val();
		var startTime=$("#startTime").val();
		var endTime=$("#endTime").val();
		var startIndex=(page-1)*pageSize;
		$.post("changValue/selByTerm",{
			"startTime":startTime,
			"endTime":endTime,
			"empId":empId,
			"startIndex":startIndex,
			"rows":pageSize
			},function(map){
				var x=map.changValues;
				var count=map.count;
				document.getElementById("count").innerHTML=count;
				document.getElementById("pageCount").value=map.pageCount;
				document.getElementById("page").value=page;
				var rowCount=table.rows.length;
			    for (i=1;i<rowCount;i++){
			       table.deleteRow(1);    
			    }
			    for(var i=0;i<x.length;i++)
			    {
			    	var date=new Date(x[i].datee);
			    	var month=parseInt(date.getMonth())+1>10?parseInt(date.getMonth())+1:"0"+(parseInt(date.getMonth())+1);
			    	var day=parseInt(date.getMonth())>10?date.getMonth():"0"+date.getMonth();
			    	var dateStr=date.getFullYear()+"年"+month+"月"+day+"日";
			    	var tr=document.createElement("tr");
			    	var td1=document.createElement("td");
			    		td1.innerHTML=dateStr;
			    		td1.setAttribute("align","center");
			    	var td2=document.createElement("td");
			    		td2.innerHTML=x[i].userNo;
			    		td2.setAttribute("align","center");
			    	var td3=document.createElement("td");
			    		td3.innerHTML=x[i].user.userName;
			    		td3.setAttribute("align","left");
			    	var td4=document.createElement("td");
			    		td4.innerHTML=x[i].preValue1;
			    		td4.setAttribute("align","right");
			    	var td5=document.createElement("td");
			    		td5.innerHTML=x[i].preValue2;
			    		td5.setAttribute("align","right");
			    	var td6=document.createElement("td");
			    		td6.innerHTML=x[i].emp.empName;
			    		td6.setAttribute("align","right");
			    	var td7=document.createElement("td");
			    		td7.innerHTML=x[i].remark;
			    		td7.setAttribute("align","right");
			    		tr.appendChild(td1);
			    		tr.appendChild(td2);
			    		tr.appendChild(td3);
			    		tr.appendChild(td4);
			    		tr.appendChild(td5);
			    		tr.appendChild(td6);
			    		tr.appendChild(td7);
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