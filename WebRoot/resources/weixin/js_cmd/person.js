define(function(require, exporets, module){
	var $ = require("lib_cmd/zepto.js"),
	    myDialog = require("lib_cmd/alert.js");
	
	
	 //申请推荐奖
	 $(".btn_zc").click(function(){
        console.log("执行申请推荐奖");
	 });
	 //
	 
	 //升级为专业经纪人
	 $("#upAgent").click(function(){
		 var userId = $("#userId").val();
		 var agentId = $("#agentId").val();
		 sessionStorage.setItem("userId",userId);
		 sessionStorage.setItem("agentId",agentId);
		 window.location.href = "weixin/wechat!regStep3";
	 });
	 //		
	 
	 //退出下线
	 $("#a_del").click(function(){
		 $.confirm({txt: '您确定退出下线?',callback:function(){
			 $.ajax({
		         type: "POST",
		         url: APP.exitUrl,
		         timeout: 30000,
		         data: {
		             "id": $("#storeId_1").val()
		         },
		         async: true,
		         success: function (res) {
		             if (res.Status == 0) {
		            	 $.alert({txt: '退出成功!'});
		            	 window.location.href = "weixin/wechat!personCenter";
		             }
		             else {
		            	 $.alert({txt: '退出失败!'});
                         // console.log("error:error type:"+res.Status);
		             }
		         },
		         dataType: "json"
		     })   
    	    }
		 });
	 });
	 //
	 
	 //取消所有下线邀请
	 $(".concelAll").click(function(){
		 $.confirm({txt: '您确定要取消所有邀请?',callback:function(){
			 $.ajax({
		         type: "POST",
		         url: APP.concelUrl,
		         timeout: 30000,
		         data: {
		         },
		         async: true,
		         success: function (res) {
		             if (res.Status == 0) {
		            	 $.alert({txt: '取消成功!'});
		            	 window.location.href = "weixin/wechat!personCenter";
		             }
		             else {
                          //console.log("error:error type:"+res.Status);
		            	 $.alert({txt: '取消失败!'});
		             }
		         },
		         dataType: "json"
		     })   
    	    }
		 });
	 });
	 // 
	 
});