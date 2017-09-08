define(function(require, exporets, module){
	var $ = require("lib_cmd/zepto.js"),
	    myDialog = require("lib_cmd/alert.js");
	
	
	
	 $(".btn_zc").click(function(){
		 var cIdList = [];
		 $(".cus_tr").each(function(){
			 var $this  = $(this);
			 cIdList.push($this.attr("data-cid"));
		 });
         
         

         if(!cIdList.length){
        	 $.alert({txt: '没有任何数据!'});
         }
         else{  	 
        	 $.ajax({
    	         type: "POST",
    	         url: APP.opUrl,
    	         timeout: 30000,
    	         data:{
    	             "cIds": cIdList.join(",")
  	              },
    	         async: true,
    	         success: function (res) {
    	             if(res && res.Status == 0){
    	            	 window.location.href = "weixin/wechat!applySuccess";
    	             }
    	             else{
    	            	 $.alert({txt: '申请失败!'});
    	             }
    	         },
    	         dataType: "json"
    	     })
         }

	 });
});