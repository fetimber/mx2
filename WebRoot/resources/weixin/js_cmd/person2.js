define(function(require, exporets, module){
	var $ = require("lib_cmd/zepto.js"),
	    myDialog = require("lib_cmd/alert.js");
	
	//更新个人信息
	$(".btn_zc").click(function(){
		var idtNum = $.trim($("#idtNum").val());
		var workArea = $.trim($("#workArea").val());
	    var workSpace = $.trim($("#workSpace").val());
	    var pwd = $.trim($("#pwd").val());
	    var newPwd = $.trim($("#newPwd").val());
        var autoLogin = $.trim($("#autoLogin").val());
        var realName = $.trim($("#realName").val());
        var bankName = $.trim($("#bankName").val());
        var bankAccount = $.trim($("#bankAccount").val());
        
        if(!pwd){
        	$.alert({txt: '为保证账号安全，必须填写原密码!'});
        	return;
        }
        if(!newPwd){
        	newPwd = pwd;
        }
        if(!idtNum){
        	$.alert({txt: '身份证号不能为空!'});
        	return;
        }
        if(!workArea){
        	$.alert({txt: '工作区域不能为空!'});
        	return;
        }
        if(!workSpace){
        	$.alert({txt: '所属门店或楼盘不能为空!'});
        	return;
        } 
        
       	 $.confirm({txt: '确认提交您所修改的信息吗?',callback:function(){
       		$.ajax({
      	         type: "POST",
      	         url: APP.editUserUrl,
      	         timeout: 30000,
      	         data:{
      	             "agent.idtNum": idtNum,
      	             "agent.workArea": workArea,
      	             "agent.workSpace": workSpace,
      	             "agent.autoLogin": autoLogin,
      	             "agent.workSpace": workSpace,
      	             "agent.bankName": bankName,
      	             "agent.bankAccount": bankAccount,
      	             "user.pwdCode": newPwd,
      	             "user.realName": realName,
      	             "pwd":pwd
    	              },
      	         async: true,
      	         success: function (res) {
      	             if(res){
      	            	 if(res.Status == "3"){
      	            		 $.alert({txt: '您填写的原密码错误,修改失败!'});
      	            	 }else if(res.Status == "0"){
      	            		 $.alert({txt: '修改成功!'});
      	            		 window.location.href = "weixin/wechat!personCenter";
      	                  }
      	            	 else{
      	            		 $.alert({txt: '系统错误!'});
      	            	 }
      	             }
      	         },
      	         dataType: "json"
      	     })
       	 }});

	 });
			     				
});