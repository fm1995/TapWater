$(document).ready(function(){
		window.updateComment=function(orderNo){
			var id=$("#cid").val();
			var com = $("#txtTag").val();
			$.post("/SyProject/beOrder/updateCom",{
				"id":id,
				"comment":com,
				"orderNo":orderNo
			},function(x){
				location.href="/SyProject/beOrder/queryByOrderno?orderNo="+orderNo;
			});
		}
		
		window.delComment = function(id,orderNo,obj){
			var pa=obj.parentNode.parentNode;
			if(id!=null&&id!=0){
				if(confirm('确认删除？')){
					document.getElementById("tb").removeChild(pa);
					$.post("/SyProject/beOrder/delCom",{
						"id":id,
						"orderNo":orderNo
					},function(x){});
				}
				else{
					closeDialog();
				}
			}
			
		}
		
		window.addComment = function(orderNo,empId){
			var comment = $("#txtTag").val();
			$.post("/SyProject/beOrder/addCom",{
				"orderNo":orderNo,
				"empId":empId,
				"comment":comment
			},function(x){
				location.href="/SyProject/beOrder/queryByOrderno?orderNo="+orderNo;
			});
		}
		
		
		/*function showDialog(message, callback, id){
			if(!id)id='abc';
			window['facebox_function_'+id] = callback;
			var html = "<div id='facebox_{id}' style='display: none;'><div id='facebox_message_{id}' style='height:80px;text-align:center;padding-top:50px;'>&nbsp;</div><div class='dialogbutton center'><a class='btn btn-blue' href='javascript:;' onclick='closeDialog();facebox_function_{id}(true);' style='width:60px;'>是</a>&nbsp;<a class='btn btn-grey' href='javascript:;' onclick='closeDialog();' style='width:60px;'>否</a></div></div>";
			html = html.replace(/\{id\}/gi, id);
			if($('#facebox_'+id).length==0)
				$(document.body).append(html);
			$('#facebox_message_'+id).text(message);
			$.facebox({div:'#facebox_'+id});
		}*/
		
});