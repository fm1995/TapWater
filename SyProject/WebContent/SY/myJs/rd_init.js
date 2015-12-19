/**
 * 抄表初始化
 */

$().ready(function(){
	window.load=function(){
		$.post("YearMonth/selAllAndEmp",function(arr){
				var table=document.getElementById("table");
				var rowCount=table.rows.length;
			    for (i=1;i<rowCount;i++){
			       table.deleteRow(1);    
			    }
			    for(var i=0;i<arr.length;i++)
			    {
			    	var start=new Date(arr[i].initDate);
			    	var month=parseInt(start.getMonth())+1>10?parseInt(start.getMonth())+1:"0"+(parseInt(start.getMonth())+1);
		    		var day=parseInt(start.getDate())>10?start.getDate():"0"+start.getDate();
		    		var timeStr=start.getFullYear()+"/"+month+"/"+day;
			    	var end=new Date(arr[i].endDate);
			    	var month1=parseInt(end.getMonth())+1>10?parseInt(end.getMonth())+1:"0"+(parseInt(end.getMonth())+1);
			    	var day1=parseInt(end.getDate())>10?end.getDate():"0"+end.getDate();
			    	var timeStr1=end.getFullYear()+"/"+month1+"/"+day1;
			    	var tr=document.createElement("tr");
			    	var td1=document.createElement("td");
			    		td1.innerHTML=arr[i].readYear;
			    	var td2=document.createElement("td");
			    		td2.innerHTML=arr[i].readMonth;
			    	var td3=document.createElement("td");
			    		td3.innerHTML="";
			    		if(arr[i].isCurrent==0)
			    			td3.innerHTML="是";
			    	var td4=document.createElement("td");
			    		td4.innerHTML=arr[i].emp.empName;
			    	var td5=document.createElement("td");
			    		td5.innerHTML=timeStr;
			    	var td6=document.createElement("td");
			    		td6.innerHTML=timeStr1;
			    		
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
	load();
});