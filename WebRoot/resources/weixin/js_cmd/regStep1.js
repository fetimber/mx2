define(function(require, exporets, module){
	var $ = require("lib_cmd/zepto.js"),
	    myDialog = require("lib_cmd/alert.js");
	    yzmFlag = true;
	
	
	$(function () {
        //初始化页面元素
        $eles = {
            phone: $("#phone"),
            pwd : $("#pwd"),
            repwd : $("#repwd"),
            yzm : $("#yzm")
        }
    });
	
	
	$("#title").click(function(){
		$("#content").toggle();
	});
	
	
	 //获取验证码
     $("#getyzm").click(function(){
    	 if(!yzmFlag){
    		 return;
    	 }
    	 yzmFlag = false;
    	 var phone = $.trim($eles.phone.val());
    	 if(!phone){
    		 $.alert({txt: '请输入手机号码!'});
    		 return;
    	 }else{
    		 $.ajax({
    	         type: "POST",
    	         url: APP.sendMsgUrl,
    	         timeout: 30000,
    	         data:{
    	                "phone":phone
    	              },
    	         async: true,
    	         success: function (res) {
    	             if(res&&res.Status == 1){
    	            	 $.alert({txt: '验证码获取失败!'});
    	             }else{
    	            	 var second = 0;
   	                     yzmFlag = false;
    	            	 $("#getyzm").removeClass("getyzm_get").addClass("getyzm");
    	            	 setTimeout(function(){
    	            		 if(second <= 60){
    	            		     $("#getyzm").html("获取成功"+(60 - second++));
    	            		      setTimeout(arguments.callee,1000);
    	            		 }
    	            		 else{
    	                         yzmFlag = true;
    	                         $("#getyzm").html("获取验证码");
    	                         $("#getyzm").removeClass("getyzm").addClass("getyzm_get");
    	            		 }
    	            	 },0);
    	             }
    	         },
    	         dataType: "json"
    	     })
    	 }
    	 
     });
     //
     
     //验证~验证码
     window.validCode = function(phone , code){
    	 var result = false;
    	 $.ajax({
	         type: "POST",
	         url: APP.validMsgUrl,
	         timeout: 30000,
	         data:{
	                "phone":phone,
	                "code":code
	              },
	         async: false,
	         success: function (res) {
	             if(res){
	            	 var status = res.Status;
	            	 if(status != 1){
	            		 $.alert({txt: res.Msg});
	            	 }
	            	 else{
	            		 result = true;
	            	 }
	             }
	         },
	         dataType: "json"
	     });
    	 return result;
     }
	
	
	 $(".btn_zc").click(function(){
         var phone = $.trim($eles.phone.val());
         var pwd = $.trim($eles.pwd.val());
         var repwd = $.trim($eles.repwd.val());
         var code = $.trim($eles.yzm.val());
         var openId = $.trim($("#openId").val());
         if(!phone){
        	 $.alert({txt: '请输入手机号码!'});
        	 return;
         }
         if(!pwd){
        	 $.alert({txt: '请输入密码!'});
        	 return;
         }
         if(!repwd){
        	 $.alert({txt: '请再次输入密码!'});
        	 return;
         }
         if(pwd!=repwd){
        	 $.alert({txt: '两次输入的密码不一致!'});
        	 return;
         }
         /*
         if(!code){
        	 $.alert({txt: '请输入手机校验码!'});
        	 return;
         }
         if(!validCode(phone , code)){
        	 return;
         }*/
         
//         if(!openId){
//        	 $.alert({txt: '请用微信访问!'});
//        	 return;
//         }
         console.log("验证通过!");
         $.ajax({
	         type: "POST",
	         url: APP.registUrl,
	         timeout: 30000,
	         data:{
	             "user.loginName": phone,
	             //"user.realName": nickName,
	             "user.pwdCode": pwd,
	             "user.phone": phone,
	             "user.userType": 1,
	             "user.roleId": 2,
	             //"agent.referId": referee,
	             "agent.phoneDecimal": phone,
	             //"agent.idtNum": idft,
	             //"agent.bankAccount": bankAccount,
	             //"agent.company": company,
	             "agent.wechatId": openId,
	             "agent.autoLogin":1
	              },
	         async: true,
	         success: function (res) {
	             if(res&&res.reMap){
	            	 if(res.reMap.Status == "0000"){
	            		 //$.alert({txt: '注册成功!'});
	            		 var userId = res.reMap.userId;
	            		 var agentId = res.reMap.agentId;
	            		 sessionStorage.setItem("userId",userId);
	            		 sessionStorage.setItem("agentId",agentId);
	            		 window.location.href = APP.sucUrl + "?phone=" + phone;
	            	 }else if(res.reMap.Status == "0100"){
	            		 $.alert({txt: '用户名已存在!'});
	                 }else if(res.reMap.Status == "0102"){
	            		 $.alert({txt: '手机号码已注册!'});
	                 }else if(res.reMap.Status == "0103"){
	            		 $.alert({txt: '您已注册过账号，不能再次注册!'});
	                 }
	            	 else{
	            		 $.alert({txt: '系统错误!'});
	            	 }
	             }
	         },
	         dataType: "json"
	     })
//		 var regData = JSON.parse(sessionStorage.getItem("regData")||"{}");
//		     regData.loginName = loginName;
//		     regData.nickName = nickName;
//		     regData.idft = idft;
//		     regData.company = company;
//		     regData.phone = phone;
//		     regData.bankAccount = bankAccount;
//		     regData.openId = openId;
//		     sessionStorage.setItem("regData",JSON.stringify(regData));
//             window.location.href = "weixin/wechat!regStep2";
	 });
});