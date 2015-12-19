/**
 * @author 卿建锋 
 * 
 * version 1.0
 *
 * 自定义js
 */
$(document).ready ( function () 
{
	Dashboard.init ();
	/*****************************************
	 * 
	 * @author 卿建锋
	 * 
	 * 快捷操作用户查询
	 * 
	 * ***************************************/
	//快捷重签-【条件查询用户】
	window.queryUsers=function(){
		var userNo=$("#userNo").val();
		var abc=$("#abc").val();
		var userName=$("#userName").val();
		var phone=$("#phone").val();
		var address=$("#address").val();
		$.post(
		"/SyProject/controller/queryUsUser",
		{
			"userNo":userNo,
			"abc":abc,
			"userName":userName,
			"phone":phone,
			"address":address
		},function(data){
			
			//处理查询出来的用户结果
			queryUserTow(data);
		}
		);
	};
	
	//读取登录员工信息
	window.readEmp=function()
	{
		$.post(
				"/SyProject/controller/getSyEmpNo",
				function(data)
				{
					document.getElementById("welcome_span").innerText=data.empName;
				}
			);
	}
	
	/*快捷换表查询用户*/
	window.queryChangeTable=function()
	{
		$.post(
		"/SyProject/controller/queryChangeTable",
		{
			"userNo":$("#userNo").val(),
			"abc":$("#abc").val(),
			"userName":$("#userName").val(),
			"phone":$("#phone").val(),
			"address":$("#address").val()
		},function(data){
			
			//处理查询出来的用户结果
			handleMeterResult(data);
		});
	};
	function handleMeterResult(data)
	{
		$("#uId").val(data[0].userNo);
		$("#uName").val(data[0].userName);
		$("#mType").val(data[0].meterType);
		$("#newMeterNo").val(data[0].meter.meterNo);
	}
	/*****************************************
	 * 
	 * @author 卿建锋
	 * 
	 * 快捷操作用户查询结果处理
	 * 
	 * ***************************************/
	//快捷重签-【处理查询结果】
	window.queryUserTow=function(data){
		
		 if(data.length==1){
			 //页面显示数据
			$("#id").val(data[0].userNo);
			$("#name").val(data[0].userName);
			$("#batchTibi").val(data[0].formula);
			$("#docNum").val(data[0].docNum);
			$("#yPhone").val(data[0].phone);
			$("#ySmsPhone").val(data[0].smsPhone);
			$("#yAddress").val(data[0].address);
			$("#payType").val(data[0].payType);
			$("#bankName").val(data[0].bankName);
			$("#bankNum").val(data[0].bankNum);
			if($("#userMoney").val()!=null){
				
				//快捷销户用户查询结果处理
				cancellationUserResult(data[0].userMoney);
			}
		}else if(data.length>1){
			showWindow({url:'../page/user_displayuser.jsp', callback: function(){
				alert(showWindow_options.url);
			}});
		
			
			
		}else if(data.length==0){
			return showDialog("没有此用户或用户已注销!!!", function(){clearText();}, "queryUsers");
		} 
		
		
	}
	//快捷销户-查询用户-【处理结果】
	window.cancellationUserResult=function(data){
		$("#userMoney").val(data);
		var btnStyle=document.getElementById("btn_div");
		var msgStyle=document.getElementById("msgText");
		if(data<0){
			
			msgStyle.style.display="inline";
		}else{
			btnStyle.disabled=false;
			
			msgStyle.style.display="none";
		}
	}
	
	/**---------------------------------------------
	 * 
	 * @authoe 卿建锋
	 * 
	 * 模式窗体 协议设置
	 * 
	 * 
	 * 方法说明:
	 * 	1.ok() 此方法在关闭模式窗体时调用 主要是用来设置 模式窗体回调值;
	 *  2.returnValues() 此方法内部具体实现如何设置模式窗体回调值;
	 *  3.addtibi(sel) @paremter 当前下拉列表对象
	 *  4.createTR(name) 添加协议 @paremter name 是添加协议的类型
	 *  5.setTibi(textId) 设置选好的协议 @paremter textId 需要显示协议的input标签ID
	 *  6.clearFormula(data) 删除新添加的协议 @paremter data 当前元素对象
	 *  7.changFormulaValue(data) 协议格式拼串 @paremter data 
	 * 
	 * --------------------------------------------*/
	 window.ok=function(flag){
		//模拟返回数据
		returnWindow(returnValues(flag));
	}
	//设置回调函数
	function returnValues(flag)
	{
		
		if(flag==0)
		{
			var forumlaValue=$("#txtTibi").val().split(",");
			
			var contentValue;
			for (var i = 0; i < forumlaValue.length; i++) 
			{
				contentValue+=forumlaValue[i];
			}
			window.returnValue=contentValue.substring(9);
		}
		
		
		
	}
	//添加提比提量规则
	window.addtibi=function(sel)
	{
		window.flag;
		
		 var name = $(sel).val();  
		 var falg=false;
		 //假如进来时false
		 if(window.flag)
		 {
				var tbs=document.getElementById("tibiTable");
				var nodes=tbs.lastChild.previousSibling.childNodes;
				
			  for (var i = 0; i < nodes.length; i++) 
			  {
				var contentValue=nodes[i];
				if(contentValue.tagName=="TR")
				{
					if(contentValue.innerText.split(":")[0]==name.split(":")[0])
					{
						falg=true;
						break;
					}
				}
				
			  }
			
			if(!falg){
				createTR(name);
			}else{
				//alert("");
				showDialog("已有该协议,请重选协议!!!", function(){}, "")
			}
		  
		}else{
			window.flag=true;  //创建完一个对象后 改变标量值
			 createTR(name);
		}
			
	}
	//创建新的规则项
	 window.createTR=function(name)
	 {
		
		var nameValue=name.split(":");
		
		if(name=='添加新规则')return;
		var tbody = $('#tibiTable tbody');
		if(name=='SH:生活用水')
		{
			tbody.append('<tr><td>'+name+'</td><td>提量</td><td><input onblur="changFormulaValue(this);"value="20" /></td><td><button class="btn btn-small btn-red" onclick="clearFormula(this);">移除</button></td></tr>'); 
			$("#txtTibi").val($("#txtTibi").val()+"["+nameValue[0]+":20]");
		}else if(name=='GY:工业用水'){
			tbody.append('<tr><td>'+name+'</td><td>剩余</td><td><input onblur="changFormulaValue(this);" value="*" /></td><td><button class="btn btn-small btn-red" onclick="clearFormula(this);">移除</button></td></tr>'); 
			$("#txtTibi").val($("#txtTibi").val()+"["+nameValue[0]+":*]");
		}else{
			tbody.append('<tr><td>'+name+'</td><td>提比</td><td><input onblur="changFormulaValue(this);" value="20%" /></td><td><button class="btn btn-small btn-red" onclick="clearFormula(this);">移除</button></td></tr>');
			$("#txtTibi").val($("#txtTibi").val()+"["+nameValue[0]+":20%]");
		}
	}
	
	 //设置选好的协议
	 window.setTibi=function(textId)
	 {
		var parentValue=showWindow({url:'../page/sys_setTibi.jsp', width:600, height:500});
		if(parentValue==undefined) return;       //如果返回值为 undefined 协议就不必重新覆盖
		$("#"+textId).val(parentValue);
	 }
	
	//DOM 核心文档操作 -【设置新协议】
	window.clearFormula=function(data){
		if(confirm("是否删除该协议!!!")){
			var parentValue=data.parentNode.parentNode;
			
			parentValue.parentNode.removeChild(parentValue);
			 var replaceValue="["+data.parentNode.parentNode.firstChild.innerHTML.split(":")[0]+":"
			+data.parentNode.previousSibling.firstChild.value+"]";
			
			var formulaValue=$("#txtTibi").val();
			$("#txtTibi").val(formulaValue.replace(replaceValue, ""));
		}
				
	}
	
	
	//协议格式拼串【一】
	window.changFormulaValue=function(data){
		changFormulaValueTow(data);	
	};
	
	//协议拼串【二】
	window.changFormulaValueTow=function(data){
		//取得协议文本【Input】
		var formulaValue=$("#txtTibi").val();
		//取得当前协议类型
		var formulaAtrr=data.parentNode.parentNode;
		var formulaContent=formulaAtrr.firstChild.innerHTML;
		var content=formulaContent.split(":");
		var str;
		
		
		var values=formulaValue.split("]");
		
		for (var i = 0; i < values.length; i++) {
			var value=values[i]+"]";
			var contentText=values[i].split(":")[0].substring(1);
			var forumlaStr=values[i].split(":")[0]+":";
			var contentValue=content[0];
			if(contentText==contentValue){
				var nextContent=formulaAtrr.firstChild.nextSibling.innerHTML;
				if(nextContent=="提比"){
		
					if (data.value.substring(data.value.length-1)!="%") 
						return showDialog("请填写百分比如：50%", function(){data.value="";data.focus();}, "maxPercent");
					if(parseInt(data.value.substring(0,data.value.length-1))>100)
						return showDialog("最大比例为100%,您设置比例不能超过最大比例", function(){data.value="";data.focus();}, "maxPercent");
					value=forumlaStr+data.value+"]";
				}else if(nextContent=="提量"){
					if (data.value.substring(data.value.length-1)=="%") 
						return showDialog("请填写数字如：50", function(){data.value="";data.focus();}, "maxPercent");
					value=forumlaStr+data.value+"]";
				}else{
					value=forumlaStr+"*]";
				}
				
			}
			if(values[i]=="")
				break;
			
			
			str+=value;
		}
		var valueFor=str.substring(9);
		$("#txtTibi").val(valueFor);
	};
	
	/*********************************************
	 * 
	 * @author 卿建锋
	 * 
	 * 快捷操作
	 * 
	 *********************************************/
	
	/*
	 * @ author Menkey 
	 * 
	 * 快捷代扣 
	 * */
	window.but1=function()
	{
		
		$.post(
				"/SyProject/controller/monkeyProduct",
				{
					"userNo":$("#id").val(),
					"userName":$("#name").val(),
					"bankName":$("#kName").val(),
					"bankNum":$("#kNum").val()
				},function(data){
			
					
				});
	};
	
	
	
	//填充水表类型
	window.fillMeterType=function()
	{
		
		$.post(
				"/SyProject/controller/fillMeterType",
				function(returnValue){
					
					var meterTypeId=document.getElementById("meterTypeId");
					meterTypeId.options.length=1;
					for (var i = 0; i < returnValue.length; i++) {
						var opt=new Option(returnValue[i].meterTypeName,returnValue[i].metertypeId);
						meterTypeId.appendChild(opt);
					}
				});
	};
	
	
	//快捷换表-【换表处理】
	window.replaceMeter=function()
	{
		if($("#uId").val()!=""&&$("#newMeterNo").val()!=""&&$("#meterTypeId").val()!="--请选择水表类型--"){
			$.post(
					"/SyProject/controller/replaceMeter",
					{
						"userNo":$("#uId").val(),
						"userName":$("#uName").val(),
						"meterNo":$("#newMeterNo").val(),
						"meterName":$("#meterName").val(),
						"meterTypeId":parseInt($("#meterTypeId").val()),
						"maxValue":$("#maxValue").val(),
						"startValue":$("#startValue").val(),
						"setupTime":$("#setupDate").val(),
						"factory":$("#factory").val(),
						"syMeterType.metertypeAperture":$("#metertypeAperture").val()
					},
					function(returnValue)
					{
						if(returnValue>0){
							return showDialog("操作成功!!!", function(){clearText();document.getElementsByTagName("input")[0].focus();}, "replaceMeter")
						}else{
							return showDialog("操作失败请重新试试", function(){clearText();}, "replaceMeter")
						}
					});
		}else{
			return showDialog("用户编号或水表编号或水表类型不能为空!!!", function(){}, "replaceMeter");
		}
		
	};
	
	//快捷重签 -新签用水协议 -【提比提量】
	window.reSetProtocol=function(){
	
		if($("#batchTibi2").val()&&$("#id").val()){
			$.post(
					"/SyProject/controller/updateFormulaForUsUser",
					{
						"userNo":$("#id").val(),
						"userName":$("#name").val(),
						"formula":$("#batchTibi2").val(),
						"orderType":6
					},
					function(data)
					{
						if(data>0)
						{
							showDialog("操作成功!是否继续重签", function(){window.clearText();}, "s")
						}
					});
		}else{
			
			return showDialog("编号或协议不能为空!!!", function(){}, "string");
			
		}
		
	};
	
	//快捷销户-注销用户
	window.cancellationUser=function(){
		$.post(
				"/SyProject/controller/updataUserAndCancellation",
				{
					"userNo":$("#id").val(),
					"userName":$("#name").val(),
					"userMoney":$("#userMoney").val(),
					"orderType":7,
					"description":$("#description").val()
				},
				function(data)
				{
					if(data<=0)return showDialog("操作失败!!!", function(){}, "cancelltaion");
					else return showDialog("操作成功!是否继续操作", function(){window.clearText();}, "cancelltaion")
				});
	};
	
	//快捷操作记录-【按照条件筛选条件匹配的快捷操作记录显示】
	window.queryOrderLiteByParemter=function(pageSize)
	{
		var stratTime=$("#stratDatee").val();
		var stopTime=$("#stopDatee").val();
		if(stratTime!=" "&&stopTime!=" ")
		{
		$.post(
				"/SyProject/controller/queryBeOrderLites",
				{
					"orderType":$("#orderType").val(),
					"empNo":$("#emp").val(),
					"stratDatee":$("#stratDatee").val(),
					"stopDatee":$("#stopDatee").val(),
					"pageNumber":pageSize || 1,
					"pageSize":10
				},function(data)
				{
					orderInit(data);
					var table=document.getElementById("tbody");
					if(table.childNodes.length!=0){
						window.clearTbody(table);
					}
					window.addTrAndTd(data);
				});
		}else{
			showDialog("请输入日期", function(){}, "inputDate")
		}
	};
	
	//验证数据库内是否存在相同档案号
	window.checkedDoc=function()
	{
		var docNum=$("#docNum").val();
		if(docNum!="")
		{
			$.post(
					"/SyProject/controller/queryDocByDocnum",
					{
						"docNum":docNum
					},function(data)
					{
						if(data!=null)return showDialog("档案号重叠，请重新输入档案号!", function(){var doc=$("#docNum");doc.val("");doc.focus();}, "resetInput")
					});
		}
	}
	
	//档案号管理-【修改档案号】
	window.docMsg=function()
	{
		var docNum=$("#docNum").val();
		if(docNum!=null&&docNum!="")
		{
			$.post(
					"/SyProject/controller/updateDoc",
					{
						"userNo":$("#id").val(),
						"userName":$("#name").val(),
						"docNum":docNum
						
					},function(data)
					{
						if(data>0) return showDialog("是否继续操作档案号管理?", function(){clearText();}, "reSetDoc")
					});
		}else{
			showDialog("请输入档案号！！！", function(){$("#docNum").focus();}, "inputDocNum");
		}
	};
	
	//短信群发
	window.msgMass=function(pageNumber)
	{
		var userType=$("#userType").val();
		var outContext=$("#outContext").val();
			$.post(
					"/SyProject/controller/queryUserDate",
					{
						"sendOut":outContext,
						"userType":userType,
						"page.pageNumber":pageNumber || 1,
						"page.pageSize":10
					},function(returnData)
					{
						massInit(returnData);
						var table=document.getElementById("tbody");
						clearTbody(table);
						addMassTrAndTd(returnData);
					});
	};
	
	//短信群发-【重新生成发送内容】
	window.newMassContext=function()
	{
		var userType=$("#userType").val();
		$.post(
				"/SyProject/controller/generateContext",
				function(returnValue){
					if(userType=="给所有用户发送")
					{
							randomContext(returnValue);
					}else if(userType=="只给欠费用户发送")
					{
						randomContextBy(returnValue);
					}
					groupPage(2,true);
				});
	
	};
	
	//短信群发-随机生成发送内容-【给所有用户发送】
	function randomContext(data)
	{
		var contextArr=new Array();
		contextArr[0]="尊敬的用户{用户姓名}，您好! 新年的钟声响起，是否还有未完成的心愿呢，在此我们祝您身体健康，工作顺利!!!";
		contextArr[1]="除夕的爆竹太美，怕打扰您阖家欢乐，尊敬的用户{用户姓名}，您好!，迟来的祝福 祝您跟您的家人身体健康，万事如意";
		contextArr[2]="尊敬的用户{用户姓名}，您好!,公司活动，预交100水费，抽大奖!!!";
		contextArr[3]="尊敬的用户{用户姓名}，您好,公司搬迁至零陵大道20栋21楼，如有不便请多多包涵";
		contextArr[4]="尊敬的用户{用户姓名}，您好!您的余额为{欠费金额}";
		switch (data) {
		case 0:
			$("#outContext").val(contextArr[0]);
			break;
		case 1:
			$("#outContext").val(contextArr[1]);	
			break;
		case 2:
			$("#outContext").val(contextArr[2]);
			break;
		case 3:
			$("#outContext").val(contextArr[3]);
			break;
		case 4:
			$("#outContext").val(contextArr[4]);
			break;
		default:
			break;
		}
		
	};
	//短信群发-随机生成发送内容-【只给欠费用户发送】
	function randomContextBy(data)
	{
		
		var contextArrTow=new Array();
		contextArrTow[0]="尊敬的用户{用户姓名}，您好! 您的余额已不足{欠费金额}元，为了不影响您的正常用水 请您续交水费。";
		contextArrTow[1]="尊敬的用户{用户姓名}，您好! 您的已欠费{欠费金额}元水费，我们将提供10元信用额度。请您尽快来我公司缴费，谢谢合作，祝您愉快"
		contextArrTow[2]="尊敬的用户{用户姓名}，您好! 您的余额已不足{欠费金额}元，我们将在24小时后停止为您供水服务。";
		contextArrTow[3]="尊敬的用户{用户姓名}，您好! 您的余额为{欠费金额}元，请尽快续交水费。";
		contextArrTow[4]="尊敬的用户{用户姓名}，您好! 您的余额已不足{欠费金额}元，请下个月初续费，谢谢合作，祝您生活愉快。";
		switch (data) {
		case 0:
			$("#outContext").val(contextArrTow[0]);
			break;
		case 1:
			$("#outContext").val(contextArrTow[1]);	
			break;
		case 2:
			$("#outContext").val(contextArrTow[2]);
			break;
		case 3:
			$("#outContext").val(contextArrTow[3]);
			break;
		case 4:
			$("#outContext").val(contextArrTow[4]);
			break;
		default:
			break;
		}
	};
	
	
	
	
	
	/*上下翻页操作      parameter group 为0  说明是往上翻页
	 *    为1或为null 说明往下翻页 
	 *    为2 说明 自动输入
	 *    为3说明是最末页*/
	window.groupPage=function(group,flag)
	{
		
		var page=$("#pageNumber").val();
		var pageNum=$("#number").val();
		var pageNumber
		if(group==0)
		{
			if(page>1){
				pageNumber=page-1;
			}
		}else if(group==1)
		{
			if(page<pageNum){
				pageNumber=parseInt(page)+1;
			}else{
				pageNumber=parseInt(page);
			}
		} if(group==2)
		{
			if(page<=pageNum){
				pageNumber=$("#pageNumber").val();
			}else{
				showDialog("已是最后一页!!!", function(){}, "maxValue")
				pageNumber=pageNum;
			}
			
		}else if(group==3)
		{
			
			pageNumber=parseInt(pageNum);
		}
		if(flag)
		{
			window.msgMass(pageNumber);
		}else{
			window.queryOrderLiteByParemter(pageNumber);
		}
		
	}
	
	//初始化page显示数据
	window.orderInit=function(data)
	{
		var orderCount=document.getElementById("orderCount").innerHTML="共"+data[data.length-1].page.pageCount+"次快捷操作";
		$("#number").val(data[data.length-1].page.pageNum);
		$("#pageNumber").val(data[data.length-1].page.pageNumber);
	}
	//初始化短信群发page
	window.massInit=function(data)
	{
		$("#number").val(data[data.length-1].page.pageNum);
		$("#pageNumber").val(data[data.length-1].page.pageNumber);
	}
	
	//短信群发内容验证
	window.chekedText=function()
	{
		var context=$("#outContext").val();
		var beginIndex=context.indexOf("{", 0);
		var endIndex=context.indexOf("}", 0);
		var subStr=context.substring(beginIndex, endIndex);
		var str=$.contains(context, subStr);
		
		if(str==true&&subStr=="{用户姓名"||subStr=="{欠费金额")
		{
			msgMass(1);
		}else{
			showDialog("请设置用户名或金额", function(){$("#outContext").val("");$("#outContext").focus();}, "setNameAndMoney")
		}
	};
	
	//短信群发对接通讯公司短信发送接口
	window.smsInterface=function()
	{
		return showDialog("目前没有通讯公司的接口，日后上线之前实现此接口", function(){}, "smsInterface");
	}
	
	//导出Excel报表
	window.flag=true;
	window.excelTable=function()
	{
		if(flag)
		{
			$.post(
					"/SyProject/controller/generateTableExcel",
					{
						"sendOut":$("#outContext").val(),
						"userType":$("#userType").val(),
						"page.pageNumber": $("#pageNumber").val(),
						"page.pageSize":10
					});
			window.flag=false;
		}else{
			$.post(
					"/SyProject/controller/addTableExcel",
					{
						"sendOut":$("#outContext").val(),
						"userType":$("#userType").val(),
						"page.pageNumber": $("#pageNumber").val(),
						"page.pageSize":10
					});
		}
			
	}
	
	//添加短信群发<tr>与<td>
	window.addMassTrAndTd=function(returnDate)
	{
		var tbody = $('#displayTable tbody');
	
		for (var i = 0; i < returnDate.length; i++) 
		{
			tbody.append("<tr>"+
					"<td class='left'>"+returnDate[i].userNo+"</td>"+
					"<td class='left'>"+returnDate[i].userName+"</td>"+
					"<td class='left'>"+returnDate[i].smsPhone+"</td>"+
					"<td class='left'>"+returnDate[i].sendOut+"</td>"+
					"</tr>");
		}
	}
	
	//添加新快捷操作记录<tr>与<td>
	window.addTrAndTd=function(data)
	{
		
		var tbody = $('#displayTable tbody');
		
		for (var i = 0; i < data.length; i++) 
		{
			
			tbody.append("<tr>" +
					"<td class='center'>"+data[i].dateeTime+"</td>"+
					"<td class='left'>"+data[i].empName+"</td>"+
					"<td class='center'>"+data[i].orderTypeString+"</td>"+
					"<td class='center'>"+data[i].userNo+"</td>"+
					"<td class='left'>"+data[i].userName+"</td>"+
					"<td>"+data[i].description+"</td>"+
					"</tr>");
		}
	};
	
	//清除table的tbody下的元素
	window.clearTbody=function(table)
	{
		var removeLength=table.childNodes.length;
		for (var i = 0; i < removeLength; i++) {
			table.removeChild(table.firstChild);
		}
	};
	
	
	//清空所有Input文本
	window.clearText=function(){
		var input=document.getElementsByTagName("input");
		for (var i = 0; i < input.length; i++) {
			input[i].value="";
		}
	};
	
	
	
	
	//快捷过户
	window.updateUser=function(){
		//alert($("#newPhone").val());
		
		/*post异步请求后台数据
		"url",   说明url 是请求访问后台的java类
		{},      说明 {}是一组json格式数据 用开装前台传往后台的参数
		function(returnValue){    说明这是一个回调函数 参数是后台的返回结果
			方法体
		}
		*/
		$.post(
				"/SyProject/controller/updateUser",
				{
					"userNo":$("#id").val(),
					"userName":$("#newName").val(),
					"phone":$("#newPhone").val(),
					"smsPhone":$("#newSMSPhone").val(),
					"address":$("#newAddress").val()
				}
				);
	}
});