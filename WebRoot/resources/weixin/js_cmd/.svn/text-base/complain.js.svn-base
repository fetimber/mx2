define(function(require, exporets, module){
	var $ = require("lib_cmd/zepto.js"),
	    myDialog = require("lib_cmd/alert.js");
	
	
	
	 $(".btn_zc").click(function(){
         var cpMsg = $.trim($("#cpMsg").val());
         var cid = $.trim($("#cid").val());
         

         if(!cpMsg){
        	 $.alert({txt: '请输入投诉内容!'});
         }
         else{  	 
        	 $.ajax({
    	         type: "POST",
    	         url: APP.cplUrl,
    	         timeout: 30000,
    	         data:{
        		     cpMsg : cpMsg,
        		     cId : cid
  	              },
    	         async: true,
    	         success: function (res) {
    	             if(res){
    	            	 if(res.Status == "0"){
    	            		 window.location.href = "weixin/wechat!customDetail?cId="+cid;
    	            	 }else{
    	            		 $.alert({txt: '申诉失败!'});
    	                  }
    	              }
    	            	 else{
    	            		 $.alert({txt: '系统错误!'});
    	            	 }
    	         },
    	         dataType: "json"
    	     })
         }

	 });
});