$(document).ready(function() {
	window.getData = function() {
		$.post("/SyProject/RdController/queryToRdTask", {}, function(x) {
			var t = $("#tb")[0];
			var rowCount = t.rows.length;
			for (var i = 1; i < rowCount; i++) {
				 t.deleteRow(1);
			}
			for(var i=0;i<x.length;i++){
				var trId="tr"+i;
				$("<tr id='"+trId+"'></tr>").appendTo($(t));
				$("#"+trId).append("<td id='td1' class='odd gradeX'></td>")
							.append("<td id='td2'></td>")
							.append("<td id='td3'></td>")
							.append("<td id='td4'></td>")
							.append("<td id='td5'></td>")
							.append("<td id='td6' class='center'></td>");
				$("#"+trId).children("#td1").html(x[i].rdVolume.syArea.areaName);
				$("#"+trId).children("#td2").html(x[i].rdVolume.volumeName);
				$("#"+trId).children("#td3").html(x[i].syEmp.empName);
				$("#"+trId).children("#td4").html(x[i].readYear);
				$("#"+trId).children("#td5").html(x[i].readMonth);
				$("#"+trId).children("#td6").html('<button class="btn-icon btn-small btn-blue btn-star" onClick="toSet(\''+x[i].rdVolume.id+'\','+x[i].syEmp.empId+');"><span></span>分配</button>');
				//	奇数行与偶数行的class值不一样：class='odd gradeX',class='even gradeC'
				$("tr:odd").attr("class","odd gradeA");
				$("tr:even").attr("class","even gradeA");
			}
			
		});
	}
	
	getData();
	
	window.toSet=function(volume_id,emp_id){
		location.href="/SyProject/SY/page/rd_task_set.jsp?volume_id="+volume_id+"&emp_id="+emp_id;
	}
});