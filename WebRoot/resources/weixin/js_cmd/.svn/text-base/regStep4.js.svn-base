define(function(require, exporets, module){
	var $ = require("lib_cmd/zepto.js"),
	    myDialog = require("lib_cmd/alert.js");
	
	var regData = JSON.parse(sessionStorage.getItem("regData")||"{}");
	
	
	 $(".btn_zc").click(function(){
		 var loginName = regData.loginName;
         var nickName = regData.nickName;
         var phone = regData.phone;
         var pwd = regData.pwd;
         var referee = regData.referee||"";
         var bankAccount = $.trim($("#bankAccount").val());
         
         

         if(!regData||!loginName||!nickName||!phone||!pwd||!bankAccount){
        	 $.confirm({txt: '系统检测您的注册信息有误，请返回首页重新注册!',callback:function(){
        		 window.location.href = "weixin/wechat!regStep1";
        	 }});
         }
         else{  	 
        	 $.ajax({
    	         type: "POST",
    	         url: APP.registUrl,
    	         timeout: 30000,
    	         data:{
    	             "user.loginName": loginName,
    	             "user.realName": nickName,
    	             "user.pwdCode": pwd,
    	             "user.userType": 1,
    	             "user.roleId": 2,
    	             "agent.referId": referee,
    	             "agent.phoneDecimal": phone,
    	             "agent.wechatId": "ojMT5txpoLl4VfLQm2xHC30jf-v0",
    	             "bankAccount": bankAccount
  	              },
    	         async: true,
    	         success: function (res) {
    	             if(res&&res.reMap){
    	            	 if(res.reMap.Status == "0000"){
    	            		 $.alert({txt: '注册成功!'});
    	            	 }else if(res.reMap.Status == "0100"){
    	            		 $.alert({txt: '用户名已存在!'});
    	                  }
    	            	 else{
    	            		 $.alert({txt: '系统错误!'});
    	            	 }
    	             }
    	         },
    	         dataType: "json"
    	     })
         }

	 });
});