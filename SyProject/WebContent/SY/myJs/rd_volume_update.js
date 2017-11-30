/**
 * 表册修改
 */

$(document).ready(function(){
	window.load=function(){
		var volumeId=$("#volumeId").val();
		$.post("/SyProject/SY/page/volume/selById",{
			"volumeId":volumeId
		},function(x){
			$("#name").val(x.volumeName);
			$("#description").val(x.remark);
			var areaId=x.areaId;
			$.post("/SyProject/SY/page/load/selAllAreaAndVolume",function(x){
				var volumeSel=$("#select_area");
				volumeSel.empty();
				var areas=x.areas;
				for(var i=0;i<areas.length;i++)
				{
					if(areas[i].areaId==areaId)
						volumeSel.append('<option selected="selected"  value="'+areas[i].areaId+'">'+areas[i].areaName+'</option>');
					if(areas[i].id!=areaId)
						volumeSel.append('<option  value="'+areas[i].areaId+'">'+areas[i].areaName+'</option>');
				}
			});	
			
		})
		
	}
	
	window.upVolume=function(){
		var volumeName=$("#name").val();
		var areaId=$("#select_area").val();
		var remark=$("#description").val();
		var id=$("#volumeId").val();
		$.post("/SyProject/SY/page/volume/selByVolumeName",{
			"volumeName":volumeName
		},function(x){
			if(x==1){
				$.facebox({div:'#facebox_setVolume1'});
			}else{
				$.post("/SyProject/SY/page/volume/upById",{
					"volumeName":volumeName,
					"areaId":areaId,
					"remark":remark,
					"id":id
				},function(x){
					$('#facebox_setVolume_message').text(x);
					$.facebox({div:'#facebox_setVolume'});
				});
			}
		});

	}
	
	
	load();
});