define(function(require, exporets, module){
	var $ = require("lib_cmd/zepto.js"),
	    myDialog = require("lib_cmd/alert.js");
        cid = $("#cid").val();
        
        
     window.cb = function(cid){
    	 $.ajax({
	         type: "POST",
	         url: APP.cbUrl,
	         timeout: 30000,
	         data:{
	                "cid": cid
	              },
	         async: true,
	         success: function (res) {
	             if(res && res.Status == "0"){
	            	     window.location.href = "weixin/wechat!cbSuccess?cId="+cid;
	              }else{
	            		 $.alert({txt: '催办失败!'});
	              }
	         },
	         dataType: "json"
	     })
     }
     
     //更新记录的阅读状态
     window.readRecord = function (rId){
    	 $.ajax({
	         type: "POST",
	         url: APP.readUrl,
	         timeout: 30000,
	         data:{
	                "rId": rId
	              },
	         async: true,
	         success: function (res) {
	         },
	         dataType: "json"
	     })
     }
	
	 //催办
	 $("#btn_cb").click(function(){
		 cb(cid);
	 });
	 
     $("#btn_cb2").click(function(){
    	 cb(cid);
	 });
	 
     //申诉
	 $("#btn_ss").click(function(){	 
		 window.location.href = "weixin/wechat!complainPage?cId="+cid;
	 });
	 //
	 
	 //申请结佣
	 $("#sub_jy").click(function() {
		 $.ajax({
	         type: "POST",
	         url: APP.apply1,
	         timeout: 30000,
	         data:{
	                "cid": cid
	              },
	         async: true,
	         success: function (res) {
	             if(res && res.Status == "0"){
	            	     //$.alert({txt: '申请成功!'});
	            	     //alert("申请成功!");
	            	     window.location.href = "weixin/wechat!myBrokerage";
	              }else{
	            		 $.alert({txt: '申请失败!'});
	              }
	         },
	         dataType: "json"
	     })
	 });
	 //
    
	 //申请到访
	$("#sub_df").click(function() {
		$.ajax({
	         type: "POST",
	         url: APP.apply2,
	         timeout: 30000,
	         data:{
	                "cid": cid
	              },
	         async: true,
	         success: function (res) {
	             if(res && res.Status == "0"){
	            	     //$.alert({txt: '申请成功!'});
	            	     //alert("申请成功!");
            	     window.location.href = "weixin/wechat!myBrokerage";
	              }else{
	            		 $.alert({txt: '申请失败!'});
	              }
	         },
	         dataType: "json"
	     })
	 });
	//
	
	//申请带看
	$("#sub_dk").click(function() {
		$.ajax({
	         type: "POST",
	         url: APP.apply3,
	         timeout: 30000,
	         data:{
	                "cid": cid
	              },
	         async: true,
	         success: function (res) {
	             if(res && res.Status == "0"){
	            	     //$.alert({txt: '申请成功!'});
	            	 //alert("申请成功!");
            	     window.location.href = "weixin/wechat!myBrokerage";
	              }else{
	            		 $.alert({txt: '申请失败!'});
	              }
	         },
	         dataType: "json"
	     })
	 });
	//
	
	//展开收起消息
	$(".step1 ._title").click(function(){
		var $this = $(this);
		var $img = $this.find("img");
		var $content = $this.parent().find("._content");
		var msgType = $this.attr("data-read");
		var rId = $this.attr("data-rId");
		
		//默认展开reources/images/arrow1_w1_u1.png  arrow1_w1
		if($img.attr("src").indexOf("arrow1_w1_u1.png") != -1){
			$img.attr("src","resources/images/arrow1_w1.png");
			$content.css("display","none");
		}
		else{
			$img.attr("src","resources/images/arrow1_w1_u1.png");
			$content.css("display","block");
			//未读
			if(msgType == 0){
				$this.attr("data-read","1");
				readRecord(rId);
			}
			
		}
		
	});
	
	(function(){
		$("#firstDiv").trigger("click");
	})();
	 
});