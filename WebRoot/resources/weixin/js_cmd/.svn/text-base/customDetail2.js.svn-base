define(function(require, exporets, module){
	var $ = require("lib_cmd/zepto.js"),
	    myDialog = require("lib_cmd/alert.js");
        cid = $("#cid").val();
        
	//展开收起消息
	$(".step1 ._title").click(function(){
		var $this = $(this);
		var $img = $this.find("img");
		var $content = $this.parent().find("._content");
		
		//默认展开reources/images/arrow1_w1_u1.png  arrow1_w1
		if($img.attr("src").indexOf("arrow1_w1_u1.png") != -1){
			$img.attr("src","resources/images/arrow1_w1.png");
			$content.css("display","none");
		}
		else{
			$img.attr("src","resources/images/arrow1_w1_u1.png");
			$content.css("display","block");	
		}
		
	});
	
	(function(){
		$("#firstDiv").trigger("click");
	})();
	 
});