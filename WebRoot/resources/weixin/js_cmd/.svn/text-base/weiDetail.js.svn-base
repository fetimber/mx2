
define(function(require, exports, module){
	var $ = require("lib_cmd/zepto"),
		swipe = require("lib_cmd/swipe"),
		addressSelect = null;
		$eles = {},
		ele = {};
		new Swipe(document.getElementById('slider_3_wrap'), {
			speed:500,
			loop:true,
			//auto:3000,
			indicate:"#slider_3_indicate"
		});
		var houseId = $("#houseId").val();
		var area = $("#area").val();
		
		$("#tjkh").click(function(){
			window.location.href="weixin/wechat!recommendPage2?hid="+houseId+"&area="+area;
		});
        $("#wdkh").click(function(){
        	window.location.href="weixin/wechat!customPage";
		});
        $("#bbkh").click(function(){
        	window.location.href="weixin/wechat!recommendPage2?hid="+houseId+"&area="+area;
		});
        $(".detail_part").click(function(){
        	
        	var $this = $(this).children(".house_dl");
        	var this_display = $this.css("display");
        	if(this_display == "none"){
        		$this.css("display" , "");
        	}
        	else{
        		$this.css("display" , "none");
        	}
        });
	
});