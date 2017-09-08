define(function(require, exporets, module){
	var $ = require("lib_cmd/zepto.js"),
	    myDialog = require("lib_cmd/alert.js"),
	    isLoading = false,
	    cusCount = 1,
	    hid,
	    area;
	    
	    
	 // 客户信息静态HTML
	var template = '\
	    <div class="part_2 cusInfo">\
	    	<ul>\
	    		<li class="input_g">\
	    			<img src="resources/images/icon1.png" class="input_icon"/>\
	    			<span style="position:relative">\
	    				<input type="text" class="input1 cusName" placeholder="客户姓名" style="border-bottom:0;"/>\
	    				<span class="must">*</span>\
	    			</span>\
	    		</li>\
	    		<li class="input_g">\
	    			<img src="resources/images/icon2.png" class="input_icon"/>\
	    			<span style="position:relative">\
	    				<input  type="text" class="input1 cusPhone" placeholder="手机号码" />\
	    				<span class="must">*</span>\
	    			</span>\
	    		</li>\
	    		<li class="input_g">\
	    			<img src="resources/images/icon12.png" class="input_icon"/>\
	    				<select  class="sel1 cusProject" style="-webkit-appearance:textfield;">\
	    					<option value="'+App.hid+'" data-brokerage="'+App.hPrice+'" data-area="'+App.area+'">\
	    						'+App.hName+'\
	    					</option>\
	    				</select>\
	    		</li>\
	    		<li class="input_g">\
	    			<img src="resources/images/icon10.png" class="input_icon"/>\
	    			<div class="input_a">\
	    				<div class="tips_gray">\
	    				    <font color="#666">备注信息</font>（请尽量详细填写客户信息，以便我们提供更有效服务）\
	    				</div>\
	    			</div>\
	    			<textarea rows="3" class="textarea1 cusRemark"></textarea>\
	    			<div class="sel2 cusMor">\
	    				   <span>\
					             <input class="refer_area" type="checkbox" value=""/>同时推荐到该区域\
					       </span>\
					       <span>\
					             <input class="self_send" type="checkbox" value="" />亲自邀约\
					       </span>\
					       <span>\
					             <input class="self_look" type="checkbox" value="" />亲自带看\
					       </span>\
	    			</div>\
	    			<div class="clear"></div>\
	    		</li>\
	    		<div class="clear"></div>\
	    	</ul>\
	    </div>\
	    ';
	
	
	window.myEvent = function(){
//		$(".cusMor a").click(function(){
//			var $this = $(this);
//			if($this.hasClass("sel2_sel")){
//				$this.removeClass("sel2_sel");
//			}else{
//				$this.addClass("sel2_sel");
//			}
//		})
	}
	

	$(".btn_tjgd").click(function(){
		if(cusCount<App.limit){
		   $("#cusList").append(template);
		   myEvent();
		   cusCount++;
		}
	});
	
	 $(".btn_zc").click(function(){
		 if(App.limit<=0){
			 $.alert({txt: '您今日已不能再推荐客户!'});
			 return;
		 }
		 var cusName = $.trim($("#cusName").val()),
		     cusPhone = $.trim($("#cusPhone").val()),
		     sex = $("#sex").val(),
		     pids = [],
		     prices = [],
		     scores = []
		     flag = true;
		 
		 var custArray = [];
//		             客户对象
//		     custInfo = {
//				 cusName : '',    //客户名称
//				 cusPhone :'',    //客户号码
//				 hid : '',        //楼盘ID
//               hPrice : '',     //楼盘佣金
//               area : '',       //区域
//				 cusRemark: '',      //备注信息
//               self_send : '',  //亲自邀约
//               refer_area : '', //推荐到该区域
//               self_look : ''   //亲自带看
//		     };
		 
		 $(".cusInfo").each(function(){
			 var $this = $(this);
			 var custInfo = {};
			 var cusMor;
			 custInfo.cusName = $this.find(".cusName").val();
			 custInfo.cusPhone = $this.find(".cusPhone").val();
			 custInfo.hid = $this.find(".cusProject").val();
			 custInfo.hPrice = $this.find(".cusProject").find("option").not(function(){ return !this.selected }).attr("data-brokerage");
			 custInfo.area = $this.find(".cusProject").find("option").not(function(){ return !this.selected }).attr("data-area");
			 custInfo.cusRemark = $this.find(".cusRemark").val();
			 cusMor = $this.find(".cusMor");
			 
			 hid = custInfo.hid;
			 area = custInfo.area;
			 
			 //推荐到该区域
			 if(cusMor.find(".refer_area").is(":checked")){
				 custInfo.refer_area = 1;
			 }
			 else{
				 custInfo.refer_area = 0;
			 }
			 //亲自邀约
			 if(cusMor.find(".self_send").is(":checked")){
				 custInfo.self_send = 1;
			 }
			 else{
				 custInfo.self_send = 0;
			 }
			 //亲自带看
			 if(cusMor.find(".self_look").is(":checked")){
				 custInfo.self_look = 1;
			 }
			 else{
				 custInfo.self_look = 0;
			 }
			 console.log(custInfo.refer_area);
			 console.log(custInfo.self_send);
			 console.log(custInfo.self_look);
			 if(!custInfo.cusName||!custInfo.cusPhone||!custInfo.hid){
				 $.alert({txt: '您填写的信息不完整，请完善后继续提交!'});
				 flag = false;
				 return;
			 }
			 
			 
			 custArray.push(custInfo);
		 });
		 
		 if(isLoading){
			 return;
		 }
		 
		 //如果通过校验
		 if(flag){
        	 isLoading = true;
        	 $.ajax({
    	         type: "POST",
    	         url: App.remUrl,
    	         timeout: 30000,
    	         data:{
    	             "custArray": JSON.stringify(custArray)
  	              },
    	         async: true,
    	         success: function (res) {
  	            	if(res){
	            		  if(res.Status == 0){
	            			window.location.href = "weixin/wechat!operSuccess?hid="+hid+"&area="+area;
	            		  }
	            		  else
	            		  if(res.Status == 2){
	            			$.alert({txt: '您推荐的用户已被推荐，不能重复推荐!'}); 
	            		  }
	            		  else{
	            			window.location.href = "weixin/wechat!operFail";
	            		  }
	            	  }
	            	  else{
	            		   window.location.href = "weixin/wechat!operFail";
	            	  }
    	             isLoading = false;
    	         },
    	         dataType: "json"
    	     })
         }

	 });
	 
	 (function(){
		 myEvent(); 	 
	 })();
});