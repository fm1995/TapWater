/**
 * 最大表码修正记录
 */

$(document).ready(function(){
	window.load=function(){
		$.post("/TapWater/sy/page/load/selByRdEmp",function(emps){
			var empSel=$("#empSel");
			empSel.empty();
			empSel.append('<option value="0" selected="selected">所有</option>');
			for(var i=0;i<emps.length;i++)
			{
				empSel.append('<option value="'+emps[i].id+'">'+emps[i].empName+'</option>');
			}
		});
		sel(1);
	}
	
	window.sel=function(page){
		var pageSize=$("#pageSize").val();
		var startIndex=(page-1)*pageSize;
		$.post("maxVlue/selByTerm",{
			"startTime":"2015-07-03 16:31:00",
			"endTime":"2015-09-03 16:31:00",
			"empId":7,
			"startIndex":startIndex,
			"rows":pageSize
			},function(x){
			alert(x.length);
		});
	}
	
	load();
});