/**
 * 页面加载时加载抄表年月到下拉列表里面
 */
$(document).ready(function(){

	window.load=function(){
		$.post("YearMonth/selAll",function(x){
				var set=$("#yearMonth");
				set.empty();
				eval("var arr="+x+";");
				for(var i=0;i<arr.length;i++)
				{
					var value=arr[i].readYear+":"+arr[i].readMonth;
					var name=arr[i].readYear+""+arr[i].readMonth;
					if(arr[i].readMonth<10)
						name=arr[i].readYear+"0"+arr[i].readMonth;
					set.append("<option value="+value+">"+name+"</option>");
				}
				var name1=arr[0].readYear+""+arr[0].readMonth;
				if(arr[0].readMonth<10)
					name1=arr[0].readYear+"0"+arr[0].readMonth;
				document.getElementById("year").innerText=name1;
				selByYearAndMonth(document.getElementById("btn"));
		});
	}
	
	window.selByYearAndMonth=function(sel){
		var obj=sel.previousSibling;
		document.getElementById("year").innerText=obj.options[obj.selectedIndex].innerHTML;
		var arr=obj.value.split(":");
		$.post("read/selByYearAndMonth",{"readYear":arr[0],"readMonth":arr[1]},function(x){
			var table=document.getElementById("readTable");
			eval("var reads="+x+";");
			var rowCount=table.rows.length;
		    for (i=1;i<rowCount;i++){
		       table.deleteRow(1);    
		    }
		    var sum=0;
		    var enterYesSum=0;
		    var enterNoSum=0;
		    var auditYesSum=0;
		    var auditNoSum=0;
			for(var i=0;i<reads.length;i++)
			{
				var tr=document.createElement("tr");
				var area=reads[i].area;
				var volume=reads[i].volume;
				var empName=reads[i].empName;
				var count=reads[i].count;
				var enterYes=reads[i].enterYes;
				var enterNo=reads[i].enterNo;
				var auditYes=reads[i].auditYes;
				var auditNo=reads[i].auditNo;
				sum=sum+count;
				enterYesSum=enterYesSum+enterYes;
				enterNoSum=enterNoSum+enterNo;
				auditYesSum=auditYesSum+auditYes;
				auditNoSum=auditNoSum+auditNo;
				var td1=document.createElement("td");
					td1.setAttribute("align","center");
				var td2=document.createElement("td");
					td2.setAttribute("align","center");
				var td3=document.createElement("td");
					td3.setAttribute("align","center");
				var td4=document.createElement("td");
					td4.setAttribute("align","right");
				var td5=document.createElement("td");
					td5.setAttribute("align","right");
				var td6=document.createElement("td");
					td6.setAttribute("align","right");
				var td7=document.createElement("td");
					td7.setAttribute("align","right");
				var td8=document.createElement("td");
					td8.setAttribute("align","right");
				td1.innerHTML=area;
				td2.innerHTML=volume;
				td3.innerHTML=empName;
				if(empName==undefined)
					td3.innerHTML="";
				td4.innerHTML=count;
				td5.innerHTML=enterYes;
				td6.innerHTML=enterNo;
				td7.innerHTML=auditYes;
				td8.innerHTML=auditNo;
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);
				tr.appendChild(td5);
				tr.appendChild(td6);
				tr.appendChild(td7);
				tr.appendChild(td8);
				table.appendChild(tr);
			}
			var tr1=document.createElement("tr");
			var td9=document.createElement("td");
			var td10=document.createElement("td");
			var td11=document.createElement("td");
			td11.setAttribute("align","right");
			var td12=document.createElement("td");
			td12.setAttribute("align","right");
			var td13=document.createElement("td");
			td13.setAttribute("align","right");
			var td14=document.createElement("td");
			td14.setAttribute("align","right");
			var td15=document.createElement("td");
			td15.setAttribute("align","right");
			td9.innerHTML="合计:";
			td9.setAttribute("align","center");
			td10.innerHTML="表册数:"+reads.length+"册";
			td10.setAttribute("colspan",2);
			td11.innerHTML=sum;
			td12.innerHTML=enterYesSum;
			td13.innerHTML=enterNoSum;
			td14.innerHTML=auditYesSum;
			td15.innerHTML=auditNoSum;
			tr1.appendChild(td9);
			tr1.appendChild(td10);
			tr1.appendChild(td11);
			tr1.appendChild(td12);
			tr1.appendChild(td13);
			tr1.appendChild(td14);
			tr1.appendChild(td15);
			table.appendChild(tr1);
		
		});
	}
	

	load();
});

/**
 * 
 */


/**
 * 
 */


/**
 * 
 */

/**
 * 
 */