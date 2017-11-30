/**
 * 根据用户审核
 */

$().ready(function(){
	window.load=function(){
		var userNo=$("#userNo").val();
		var userName=$("#userName").val();
		var phone=$("#phone").val();
		var address=$("#address").val();
		$.post("/SyProject/SY/page/read/selReadByUser",{
			"userNo":userNo,
			"userName":userName,
			"phone":phone,
			"address":address
		},function(x){
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
		    		td1.innerHTML='<input type="checkbox" name="readId" value="'+x[i].id+'" class="chk">';
		    		td1.setAttribute("align","center");
		    	var td2=document.createElement("td");
		    		td2.innerHTML=x[i].readYear;
		    		td2.setAttribute("align","center");
		    	var td3=document.createElement("td");
		    		td3.innerHTML=x[i].readMonth;
		    		td3.setAttribute("align","center");
		    	var td4=document.createElement("td");
		    		td4.innerHTML=x[i].maxValue;
		    		td4.setAttribute("align","center");
		    		
		    	var td5=document.createElement("td");
		    		td5.innerHTML=x[i].userNo;
		    		td5.setAttribute("align","center");
		    	var td6=document.createElement("td");
		    		td6.innerHTML=x[i].meterNo;
		    		td6.setAttribute("align","center");
		    	var td7=document.createElement("td");
		    		td7.innerHTML=x[i].preValue;
		    		td7.setAttribute("align","right");
		    	var td8=document.createElement("td");
		    		td8.innerHTML=x[i].curValue;
		    		td8.setAttribute("align","right");
		    	var td9=document.createElement("td");
		    		td9.innerHTML=x[i].amount;
		    		td9.setAttribute("align","right");
		    	var td10=document.createElement("td");
		    		td10.innerHTML=x[i].formula;
		    		td10.setAttribute("align","center");
		    		
		    	var td11=document.createElement("td");
		    		td11.innerHTML='<button class="btn-icon btn-small btn-blue btn-check" onClick="audit('+x[i].id+');"><span></span>复核</button>';
		    		td11.setAttribute("align","center");
		    		tr.appendChild(td1);
		    		tr.appendChild(td2);
		    		tr.appendChild(td3);
		    		tr.appendChild(td4);
		    		tr.appendChild(td5);
		    		tr.appendChild(td6);
		    		tr.appendChild(td7);
		    		tr.appendChild(td8);
		    		tr.appendChild(td9);
		    		tr.appendChild(td10);
		    		tr.appendChild(td11);
		    		tbody.appendChild(tr);
		    }
		});
	}
	
	window.audit=function(readId){
		$.post("/SyProject/SY/page/read/readAudit",{
			"readId":readId
		},function(x){
			
		});
		showWindow({url:'../page/rd_audit_progress1.jsp',width:560,height:240});
		load();
	}
	
	window.auditMutil=function(){
		var readIds=document.getElementsByName("readId");
		var readIdStr=new Array();
		var count=0;
		for(var i=0;i<readIds.length;i++){
			if(readIds[i].checked){
				readIdStr.push(readIds[i].value);
				count++;
			}
		}
		if(count>0)
		{
			for(var j=0;j<readIdStr.length;j++){
				var readId=readIdStr[j];
				$.post("/SyProject/SY/page/read/readAudit",{
					"readId":readId
				},function(x){
					
				});
			}
			showWindow({url:'../page/rd_audit_progress.jsp?count='+count,width:560,height:240});
			load();
		}
	}
	load();
});