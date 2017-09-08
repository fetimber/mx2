define(function(require, exporets, module){
	var $ = require("lib_cmd/zepto.js"),
	    myDialog = require("lib_cmd/alert.js");
	
	 //邀请下线
	 $("#sub1").click(function(){
		 var phone = $("#phone").val();
		 var storeId = $("#storeId").val();
		 var memo = $("#memo").val();
		 
		 if(!phone){
			 $.alert({txt: '手机号码不能为空!'});
			 return;
		 }
		 else{
			 $.ajax({
		         type: "POST",
		         url: APP.inviteUrl,
		         timeout: 30000,
		         data: {
		             "storeAgent.bottom.phoneDecimal": phone, 
		             "storeAgent.storeId": storeId,
		             "storeAgent.memo": memo
		         },
		         async: true,
		         success: function (res) {
		             if (res.Status == 1) {
		            	 window.location.href = "weixin/wechat!personCenter";
		             }
		             else {
		            	  //console.log(res.Status);
                          window.location.href = "weixin/wechat!inviteFail?reason="+res.Status;
		             }
		         },
		         dataType: "json"
		     })
		 }
		 
	 });
	 //		     				
});