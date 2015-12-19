/**
 * 设置排序号 
 */
$().ready(function(){
	window.upIndex=function(){
		var userNo=document.getElementById("userNo").value;
		var volumeIndex=document.getElementById("volumeIndex").value;
		if(volumeIndex!=""){
			$.post("/SyProject/SY/page/userVolume/upUserVolumeIndex",{
				"userNo":userNo,
				"volumeOrderIndex":volumeIndex
			},function(x){
				window.close();
			});
		}else{
			window.close();
		}
	}
});