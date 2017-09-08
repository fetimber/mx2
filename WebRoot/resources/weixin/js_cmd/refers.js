define(function(require, exporets, module){
	var $ = require("lib_cmd/zepto.js"),
	    myDialog = require("lib_cmd/alert.js");
	
	 //申请推荐奖
	 $(".btn_zc").click(function(){
        var tr_list = $(".data_tr");
        if(!tr_list||!tr_list.length){
        	$.alert({'txt' : '没有任何可申请的数据!'});
        }
        else{
        	$.ajax({
   	         type: "POST",
   	         url: APP.commitUrl,
   	         timeout: 30000,
   	         data:{
   	               
 	              },
   	         async: true,
   	         success: function (res) {
   	             if(res && res.Status == 0){
   	            	window.location.href = "weixin/wechat!applySuccess";
   	             }else{
   	            	 $.alert({txt: '您没有可申请推荐奖的数据!'}); 
   	             }
   	             isLoading = false;
   	         },
   	         dataType: "json"
   	     })
        }
	 });
	 //
			     				
});