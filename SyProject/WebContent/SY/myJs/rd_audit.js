/**
 * 抄表复核
 */

$().ready(function(){
	
	window.selByVolumeId=function(id,volumeName){
		var arr=volumeName.split("#");
		location.href="rd_audit_details.jsp?volumeId="+id+"&name="+arr[0]+"&index="+arr[1];
	}
	
	window.load=function(){
		$.post("/SyProject/SY/page/volume/selByAuditPage",function(x){
			var tbody=document.getElementById("tableBody");
			for(var i=tbody.rows.length-1;i>=0;i--){
				tbody.deleteRow(i);
			}
			for(var i=0;i<x.length;i++)
		    {
		    	var tr=document.createElement("tr");
		    	tr.setAttribute("class","odd");
		    	if(i%2!=0)
		    		tr.setAttribute("class","even");
		    	var td1=document.createElement("td");
		    		td1.innerHTML=x[i].areaName;
		    	var td2=document.createElement("td");
		    		td2.innerHTML=x[i].volumeName;
		    	var td3=document.createElement("td");
		    		td3.innerHTML=x[i].empName;
		    		if(x[i].empName==undefined)
		    			td3.innerHTML="未分配";
		    	var td4=document.createElement("td");
		    		td4.innerHTML=x[i].mustCount;
		    		td4.setAttribute("align","center");
		    		
		    	var td5=document.createElement("td");
		    		td5.innerHTML=x[i].realityCount;
		    		td5.setAttribute("align","center");
		    	var td6=document.createElement("td");
		    		td6.innerHTML=x[i].auditCount;
		    		td6.setAttribute("align","center");
		    	var td7=document.createElement("td");
		    		var volumeName="'"+x[i].volumeName+"'";
		    		td7.innerHTML='<button class="btn-icon btn-small btn-blue btn-star" onClick="javaScript:selByVolumeId('+x[i].volumeId+','+volumeName+');"><span></span>进入表册</button> ';
		    		td7.setAttribute("align","center");
		    	var td8=document.createElement("td");
		    		td8.innerHTML=x[i].noCopy;
		    		td8.setAttribute("align","center");
		    	var td9=document.createElement("td");
		    		td9.innerHTML=x[i].noAuditCount;
		    		td9.setAttribute("align","center");
		    		tr.appendChild(td1);
		    		tr.appendChild(td2);
		    		tr.appendChild(td3);
		    		tr.appendChild(td4);
		    		tr.appendChild(td5);
		    		tr.appendChild(td6);
		    		tr.appendChild(td7);
		    		tr.appendChild(td8);
		    		tr.appendChild(td9);
		    		tbody.appendChild(tr);
		    }
		});
	}
	
	load();
});