define(function(require, exporets, module){
	var $ = require("lib_cmd/zepto.js"),
	    myDialog = require("lib_cmd/alert.js");
	
	

	
	
	 $("#sub1").click(function(){	
		 if(checkRef()){
			  regist();
		 }else{
			 $(".form_div").hide();
			 $(".part_3").show();
		 }
	 });
	 
	 $("#sub2").click(function(){
		 regist();
	 });
	 
	 $("#concel1").click(function(){
		 $(".form_div").show();
		 $(".part_3").hide();
	 });
	 
	 
	 //注册主方法
	 window.regist = function(){
	     
	     var realName = $.trim($("#realName").val());
	     var idtNum = $.trim($("#idtNum").val());
	     var workArea = $.trim($("#workArea").val());
	     var workSpace = $.trim($("#workSpace").val());
	     var referee = $.trim($("#referee").val());
	     var userId = sessionStorage.getItem("userId");
	     var agentId = sessionStorage.getItem("agentId");
	     
	     //如果页面中不存在userId和agentId则不进行注册专业经纪人
	     if(!userId||!agentId){
	    	 $.alert({txt: '系统检测页面已过期!'});
	    	 return;
	     }
	     
	     //防止专业经纪人注册重复提交
	     if(!checkSpe(agentId)){
	    	 return;
	     }
	     
         if(!realName||!idtNum||!workArea||!workSpace){
        	 $.alert({txt: '您填写的信息不完整,请检查后再次提交!'});
         }
         else{  	 
        	 $.ajax({
    	         type: "POST",
    	         url: APP.registUrl,
    	         timeout: 30000,
    	         data:{
        		     "agent.user.id":userId,
        		     "agent.user.realName":realName,
    	             "agent.id":agentId,
    	             //"agent.realNameValidate":1,
    	             "agent.idtNum":idtNum,
    	             "agent.workArea":workArea,
    	             "agent.workSpace":workSpace,
    	             "agent.referNumber": referee
  	              },
    	         async: true,
    	         success: function (res) {
    	             if(res &&res.Status == 0){
    	            	 console.log("注册专业经纪人成功!");
    	            	 window.location.href = "weixin/wechat!attention";
    	              }else{
    	                $.alert({txt: '系统错误!'});
    	              }
    	         },
    	         dataType: "json"
    	     })
         }
	 }
	 
	 //校验推荐的经纪人
	 window.checkRef = function(){
		 var referee = $.trim($("#referee").val());
		 var flag = false;
		 if(!referee){
			 //如果推荐经纪人为空 也返回true
			 return true;
		 }
		 $.ajax({
	         type: "POST",
	         url: APP.agentUrl,
	         timeout: 30000,
	         data:{
    		        "referee":referee,
	              },
	         async: false,
	         success: function (res) {
	           
	             if(res &&res.Status == 0){
	               //是专业经纪人
	            	 flag =true;
	              }else{
	               //不是专业经纪人
	            	 flag =false;
	              }
	         },
	         dataType: "json"
	     });
		 return flag;
	 }
	 
	 
	 //校验专业经纪人  agentId ：经纪人Id
	 window.checkSpe = function(agentId){
		 var flag = false;
		 if(!agentId){
			 return flag;
		 }
		 $.ajax({
	         type: "POST",
	         url: APP.speUrl,
	         timeout: 30000,
	         data:{
    		        "agentId":agentId,
	              },
	         async: false,
	         success: function (res) {
	            	  
	              if(res){
	            	  if(res.Status == 0){
	            		  flag =true;
	            	  }
	            	  else
	            	  if(res.Status == 1){
	            		  $.alert({txt: '您已提交过专业经纪人注册申请!'});
	            	  }
	            	  else{
	            		  $.alert({txt: '系统错误!'});
	            	  }
	              }
	              else{
	            	  $.alert({txt: '系统错误!'});
	              }
	         },
	         dataType: "json"
	     });
	   return flag;
	 }
});