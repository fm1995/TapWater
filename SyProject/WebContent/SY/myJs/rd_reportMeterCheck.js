$(document).ready(function() {
	
	//	访问后台获取表格数据
	window.getTableData = function(f) {
		var meterAge=$("#meterAge").val();
		$("#showMeterAge").text(meterAge);
		var page=$("#page").val();
		if(f==1){
			$("#page").val(f);
			page=1;
		}
		var pageSize=$("#pageSize").val();
		var start = (parseInt(page) - 1) * pageSize;
		if(meterAge=='')
			meterAge=0;
		$.post("/SyProject/RdController/queryToReportMeterCheck", {
			"meterAge" : meterAge,
			"start":start,
			"pageSize":pageSize
		}, function(map) {
			
			var usMeter=map.list;
			$("#count").text(map.count);
			$("#pageTotal").val(map.pageTota);
			var t=$("#tb")[0];
			var rowCount=t.rows.length;
			for(var i=1;i<rowCount;i++){
				t.deleteRow(1);
			}
			
			for(var j=0;j<usMeter.length;j++){
				var trId="r"+j;
				$(t).append($("<tr id='"+trId+"'></tr>"));
				$("#"+trId).append("<td id='td1' class='center'></td>")
						.append("<td id='td2' class='left'></td>")
						.append("<td id='td3' class='center'></td>")
						.append("<td id='td4' class='center'></td>")
						.append("<td id='td5' class='center'></td>")
						.append("<td id='td6' class='center'></td>")
						.append("<td id='td7' class='center'></td>")	
						.append("<td id='td8'></td>");
				$("#"+trId).children("#td1").html(usMeter[j].usUser.userNo);
				$("#"+trId).children("#td2").html(usMeter[j].usUser.userName);
				$("#"+trId).children("#td3").html(usMeter[j].meterName);
				$("#"+trId).children("#td4").html(usMeter[j].syMeterType.meterTypeName);
				$("#"+trId).children("#td5").html(usMeter[j].syMeterType.metertypeAperture);
				$("#"+trId).children("#td7").html(usMeter[j].meterAge);
				$("#"+trId).children("#td8").html(usMeter[j].factory);
				setDate(usMeter[j].setupDate,trId);
			}
			
		});
	}
	
	getTableData(1);
	
	//	拼接装表日期
	window.setDate=function(initDate,trId){
		var date=new Date(initDate);
		var year=date.getFullYear();
		var month=date.getMonth()+1;
		var day=date.getDate();
		if(month<10){
			month="0"+month;
		}
		if(day<10){
			day="0"+day;
		}
		var newDate=year+"年"+month+"月"+day+"日";
		$("#"+trId).children("#td6").html(newDate);
	}
	
	//	分页跳转
	window.change=function(flag){
		var meterAge=$("#meterAge").val();
		$("#showMeterAge").text(meterAge);
		
		var page=$("#page");
		var pageSize=$("#pageSize");
		var count=$("#pageTotal");
		if(flag==-2){	//	第一页
			page.val(1);
			getTableData(0);
		}else if(flag==-1){
			var oldPage=page.val();
			var newPage=parseInt(oldPage)+parseInt(flag);
			if(newPage<=0){
				page.val(oldPageVal);
			}else{
				page.val(newPage);
				getTableData(0);
			}
		}else if(flag==1){
			var oldPage=page.val();
			var newPage=parseInt(oldPage)+parseInt(flag);
			if(newPage>count.val()){
				page.val(oldPageVal);
			}else{
				page.val(newPage);
				getTableData(0);
			}
		}else if(flag==-3){
			page.val(count.val());
			getTableData(0);
		}
	}
	
	window.textChange=function(){
		//	用一个全局变量来保存修改之前的page的值
		oldPageVal=$("#page").val();
	}
	
});
