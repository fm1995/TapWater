$(document).ready(function() {

	//	从后获取表格数据
	window.toRdInit = function() {
		$.post("/SyProject/RdController/queryAll", {}, function(x) {
			//	jQuery对象是DOM数组对象
			var t = $("#tb")[0];
			var rowCount = t.rows.length;
			for (var i = 1; i < rowCount; i++) {
				t.deleteRow(1);
			}
			for(var i=0;i<x.length;i++){
				var trId="tr"+i;
				$("<tr id='"+trId+"'></tr>").appendTo($(t));
				$("#"+trId).append("<td id='td1'></td>")
							.append("<td id='td2'></td>")
							.append("<td id='td3'></td>")
							.append("<td id='td4'></td>")
							.append("<td id='td5'></td>")
							.append("<td id='td6'></td>");
				var c=x[i].isCurrent.toString();
				if(c=="true")
					$("#"+trId).children("#td3").html("是");
				$("#"+trId).children("#td1").html(x[i].readYear);
				$("#"+trId).children("#td2").html(x[i].readMonth);
				$("#"+trId).children("#td4").html(x[i].emp.empName);
				setDate(x[i].initDate,trId,5);
				setDate(x[i].endDate,trId,6);
			}
			//	奇数行与偶数行的class值不一样：class='odd gradeX',class='even gradeC'
			$("tr:odd").attr("class","odd gradeX");
			$("tr:even").attr("class","even gradeX");
		});
	}

	toRdInit();
	
	//	初始化日期、结束日期
	window.setDate=function(initDate,trId,flag){
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
		if(flag=="5")
			$("#"+trId).children("#td5").html(newDate);
		if(flag=="6")
			$("#"+trId).children("#td6").html(newDate);
	}
});