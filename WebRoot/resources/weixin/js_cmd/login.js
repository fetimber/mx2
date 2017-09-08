define(function(require, exporets, module){
	var $ = require("lib_cmd/zepto.js"),
		myDialog = require("lib_cmd/alert.js"),
		iForm = require("lib_cmd/iForm.js"),
		iTemplate = require("lib_cmd/iTemplate.js");
	    $eles = {};
	
	
	$(function () {
        //初始化页面元素
        $eles = {
            userName: $("#userName"),
            pwd : $("#pwd"),
            sub : $("#sub"),
            reg : $("#reg")
        }
    });
	
	//注册按钮点击事件
	$eles.reg.click(function(){
		window.location.href = "weixin/wechat!regStep1";
	})
	//
	 
	//登录按钮点击事件
	$eles.sub.click(function(){
		if(!$.trim($eles.userName.val())||!$.trim($eles.pwd.val())){
			$.alert({txt: '用户名或密码错误!'});
		}
		else{
		
		 $.ajax({
	         type: "POST",
	         url: APP.loginUrl,
	         timeout: 30000,
	         data: {
	             "userName": $.trim($eles.userName.val()), 
	             "pwd": $.trim($eles.pwd.val()),
	             "openId": APP.openId
	         },
	         async: true,
	         success: function (res) {
	             if (res.Status == 0) {
	            	 //$.alert({txt: '登录成功!'});
	            	 window.location.href = APP.sucUrl;  //成功后跳转页面
	             }
	             else {
	            	 $.alert({txt: '用户名或密码错误!'});

	             }
	         },
	         dataType: "json"
	     })
		}
		 
	 });
	//
	 
});