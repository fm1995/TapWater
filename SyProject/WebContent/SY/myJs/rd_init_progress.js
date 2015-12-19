/**
 * 抄表初始化加载
 */

$(document).ready(function(){
	window.count=0;
	window.value = 0;
	window.load=function(){
		var date=new Date();
		var year=date.getFullYear();
		var month=date.getMonth()+1>9?date.getMonth()+1:"0"+date.getMonth+1();
		document.getElementById("divText").innerHTML="确定要初始化抄表年月【"+year+"年"+month+"月】吗？";
		document.getElementById("spanText").innerHTML="正在初始化【"+year+"年"+month+"月】的抄表任务...";
		$.post("/SyProject/SY/page/read/selReadCount",function(x){
			count=x;
		});
	}
	
	window.start=function(){
		$.post("/SyProject/SY/page/read/isInit",function(x){
			if(x=="no")
			{
				$.post("/SyProject/SY/page/read/initUserRead",function(){
					alert(x);
				});
				$('#messageDiv').hide();
				$('form').show();
				process();
			}
			else
				alert("此月份已经初始化");
		});
	}
	
	
	window.process=function(){
		value+=100; if(value>count)value=count;
		$( "#progressbar" ).progressbar({ count:count, value: value });
		processShowInfo();
		if(value<count){
			setTimeout(process, 10);
		}else{
			processComplete();
		}
	}
	window.processShowInfo=function(){
		$('#message').text(value+'户/'+count+'户');
	}
	window.processComplete=function(){
		$('#ok').show();
	}
	window.off=function(){
		alert("off");
	}
	
	load();
});