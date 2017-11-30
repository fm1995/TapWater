$(document).ready(function(){
	window.initData=function(){
		$.post("/SyProject/RdController/initData",{},function(data){
			var ym=data.yearMonth;
			var v=data.volumes;
			var area=data.areas;
			var ymSel=$("#yearMonth");
			var vSel=$("#volume_id");
			ymSel.empty();
			for(var i=0;i<ym.length;i++){
				var y=ym[i].readYear.toString();
				var m=ym[i].readMonth;
				if(m<10)
					m="0"+m;
				var newYm=y+m;
				var logic=y+":"+m;
				ymSel.append("<option value="+logic+">"+newYm+"</option>");
			}
			ymSel[0].options[5].selected=true;
			var p=ymSel.val().split(":");
			$("#volume_year_month").html(p[0]+p[1]);
			vSel.append("<option value='0'>所有</option>");
			for(var j=0;j<area.length;j++){
				vSel.append("<optgroup id="+area[j].areaId+" label="+area[j].areaName+"></optgroup>");
				for(var k=0;k<v.length;k++){
					if(area[j].areaId==v[k].areaId){
						$("#"+area[j].areaId).append("<option value="+v[k].id+">"+v[k].volumeName+"</option>");
					}
				}
			}
			queryRdReadDetails(1);
		});
		
	}
	
	initData();
	
	window.queryRdReadDetails=function(times){
		var ym=$("#yearMonth");
		var volume=$("#volume_id");
		var startDate=$("#startDate");
		var endDate=$("#endDate");
		var yearMonth=ym.val().split(":");
		var pageSize=$("#pageSize").val();
		var page=$("#page").val();
		var start = (parseInt(page) - 1) * pageSize;
		
		$.post("/SyProject/RdController/queryRdReadData",{
			"readYear":yearMonth[0],
			"readMonth":yearMonth[1],
			"volumeId":volume.val(),
			"startDate":startDate.val(),
			"endDate":endDate.val(),
			"start":start,
			"pageSize":pageSize
		},function(data){
			var x=data.rdReads;
			var count=data.count;
			if(count=="0"||times==1||volume.val()=="0"){
				$("#emp_name").html("所有");
				if(count=="0")
					$("#emp_name").html("");
			}else{
				var en=x[0].rdTask.syEmp.empName;
				$("#emp_name").html(en);
			}
			pagi=data.pagi;
			$("#count2").val(pagi);
			$("#total").html(count);
			var tb=$("#tb")[0];
			var rowCount=tb.rows.length;
			for(var i=1;i<rowCount;i++){
				tb.deleteRow(1);
			}
			var totalAudit=0;
			
			for(var j=0;j<x.length;j++){
				totalAudit+=parseInt(x[j].amount);
				var trId="tr"+j;
				$(tb).append("<tr id="+trId+"></tr>");
				$("#"+trId).append("<td id='td1' class='center'></td>")
							.append("<td id='td2'></td>")
							.append("<td id='td3' class='right'></td>")
							.append("<td id='td4' class='right'></td>")
							.append("<td id='td5' class='right'></td>")
							.append("<td id='td6' class='center'></td>")
							.append("<td id='td7' class='center'></td>");
				$("#"+trId).children("#td1").html(x[j].usUser.userNo);
				$("#"+trId).children("#td2").html(x[j].usUser.userName);
				$("#"+trId).children("#td3").html(x[j].preValue);
				$("#"+trId).children("#td4").html(x[j].curValue);
				$("#"+trId).children("#td5").html(x[j].amount);
				if(!x[j].enter){
					x[j].enter="是";
				}
				$("#"+trId).children("#td6").html(x[j].enter);
				if(!x[j].audit){
					x[j].audit="是";
				}
				$("#"+trId).children("#td7").html(x[j].audit);
			}
			$("#totalAudit").html(totalAudit);
		});
	}
	
	//	分页
	window.change=function(f){
		if(f==-2)
			$("#page").val(1);
		if(f==-1){
			var sum=parseInt($("#page").val())+f;
			if(sum<1){
				sum=1;
			}
			$("#page").val(sum);
		}
		if(f==1){
			var sum=parseInt($("#page").val())+f;
			if(sum>pagi){
				sum=pagi;
			}
			$("#page").val(sum);
		}
		if(f==-3){
			$("#page").val(pagi);
		}
		queryRdReadDetails();
	}
	
});