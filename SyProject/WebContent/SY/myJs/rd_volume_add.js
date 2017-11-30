/**
 * 表册添加页面
 */

$(document).ready(function(){
	window.load=function(){
		$.post("/SyProject/SY/page/load/selAllAreaAndVolume",function(x){
				var volumeSel=$("#select_area");
				volumeSel.empty();
				var areas=x.areas;
				for(var i=0;i<areas.length;i++)
				{
					if(i==0)
						volumeSel.append('<option selected="selected"  value="'+areas[i].areaId+'">'+areas[i].areaName+'</option>');
					if(i!=0)
						volumeSel.append('<option  value="'+areas[i].areaId+'">'+areas[i].areaName+'</option>');
				}
		});	
	}
	
	
	window.addVolume=function(){
		var volumeName=$("#name").val();
		var areaId=$("#select_area").val();
		var remark=$("#description").val();
		var disabled=0;
		$.post("/SyProject/SY/page/volume/selByVolumeName",{
			"volumeName":volumeName
		},function(x){
			if(x==1){
				$.facebox({div:'#facebox_setVolume1'});
			}else{
				$.post("volume/add",{
					"volumeName":volumeName,
					"areaId":areaId,
					"remark":remark,
					"disabled":disabled
				},function(x){
					$("#name").val("");
					$("#description").val("");
					$("#select_area")[0].options[0].selected=true;
					$('#facebox_setVolume_message').text(x);
					$.facebox({div:'#facebox_setVolume'});
				});
			}
		});
		
	}

	
	load();
});