define(function(require, exporets, module){
	var $ = require("lib_cmd/zepto.js"),
	    myDialog = require("lib_cmd/alert.js"),
	    hid = APP.hid,
	    area = APP.area;
	
   $("#tj_more").click(function(){
	   //当楼盘ID和地域同时存在时 跳转到固定楼盘推荐页面
	   window.location.href = "weixin/wechat!housesPage?buildingno="+hid;
	  
	   
   });
   
   $("#sub1").click(function(){
	   window.location.href = "weixin/wechat!myAccount";
   });
	
	(function(){
		
		
	})();
});