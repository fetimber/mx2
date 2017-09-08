define(function(require, exporets, module){
	var $ = require("lib_cmd/zepto.js"),
	    myDialog = require("lib_cmd/alert.js");
	
	 //接受邀请
	 $("#sub1").click(function(){	 
		 $.confirm({txt: '您确定接受此次邀请?',callback:function(){
			 $.ajax({
		         type: "POST",
		         url: APP.acceptUrl,
		         timeout: 30000,
		         data: {
		             "storeAgent.storeId": $("#storeId").val(),
		             "storeAgent.agentId": $("#agentId").val()
		         },
		         async: true,
		         success: function (res) {
		             if (res.Status == 0) {
		            	 window.location.href = "weixin/wechat!personCenter";
		             }
		             else {
		            	 $.alert({txt: '操作失败!'});
                          console.log("error:error type:"+res.Status);
		             }
		         },
		         dataType: "json"
		     })   
    	    }
		 });
	 });
	 //	
	 
	 //拒绝邀请
	 $("#sub2").click(function(){	 
		 $.confirm({txt: '您确定拒绝此次邀请?',callback:function(){
			 $.ajax({
		         type: "POST",
		         url: APP.refuseUrl,
		         timeout: 30000,
		         data: {
		             "storeAgent.storeId": $("#storeId").val(),
		             "storeAgent.agentId": $("#agentId").val()
		         },
		         async: true,
		         success: function (res) {
		             if (res.Status == 0) {
		            	 window.location.href = "weixin/wechat!personCenter";
		             }
		             else {
		            	 $.alert({txt: '操作失败!'});
                          console.log("error:error type:"+res.Status);
		             }
		         },
		         dataType: "json"
		     })   
    	    }
		 });
	 });
	 //	
});