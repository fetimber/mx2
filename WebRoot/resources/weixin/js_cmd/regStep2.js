define(function(require, exporets, module){
	var $ = require("lib_cmd/zepto.js"),
	    myDialog = require("lib_cmd/alert.js");
	
     //继续注册专业经纪人
	 $(".btn_reg").click(function(){
		 window.location.href = "weixin/wechat!regStep3";
	 });
	 //
	 
	 //跳转到个人中心
     $(".btn_reg1").click(function(){
    	 window.location.href = "weixin/wechat!myAccount";
	 });
	 //
	
	 $(".btn_zc").click(function(){
         var pwd = $.trim($("#pwd").val());
         var repwd = $.trim($("#repwd").val());
         var autoLogin = $("#autoLogin").val();
         if(!pwd){
        	 $.alert({txt: '请输入密码!'});
        	 return;
         }
         if(!repwd){
        	 $.alert({txt: '请再次输入密码!'});
        	 return;
         }
         if(pwd != repwd){
        	 $.alert({txt: '您两次输入的密码不一致!'});
        	 return;
         }
		 var regData = JSON.parse(sessionStorage.getItem("regData")||"{}");
		     regData.pwd = pwd;
		     regData.autoLogin = autoLogin;
		     sessionStorage.setItem("regData",JSON.stringify(regData));
             window.location.href = "weixin/wechat!regStep3";
	 });
			     				
});