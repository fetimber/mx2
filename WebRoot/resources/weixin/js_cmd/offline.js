
define(function (require, exports, moudle) {
    var $ = require("lib_cmd/zepto"),
		main = require("js_cmd/main"),
		myDialog = require("lib_cmd/alert.js"),
		hid = getUrlParam('roomCode');
		scrollEvt = require("lib_cmd/scrollEvt"),
		iTemplate = require("lib_cmd/iTemplate"),
		$eles = {},
		ele = {};
   
    
    $("#more1").click(function(){
		pageArgs1.loadData();
	});
    
    $("#tj_more").click(function(){
 	   //当楼盘ID和地域同时存在时 跳转到固定楼盘推荐页面
        window.location.href = "weixin/wechat!housesPage?buildingno="+hid.substr(0,1);
    });
    
    $("#sub1").click(function(){
 	   window.location.href = "weixin/wechat!myAccount";
    });
    
    
    
	$("#div_xm_tpc1").click(function(){
		var $this = $(this);
		if($this.hasClass("xm_tpc_s")){
			$this.removeClass("xm_tpc_s").addClass("xm_tpc_ls");
			$("#d_p1").css("display","none");
			$this.find("img").attr("src","resources/images/arrow1_w1.png");
		}else{
			$this.removeClass("xm_tpc_ls").addClass("xm_tpc_s");
			$("#d_p1").css("display","");
			$this.find("img").attr("src","resources/images/arrow1_w1_u1.png");
		}
	});
	
    
    /**异步加载数据模块**/
    var pageArgs1 = {
        pageIndex: 1,
        pageSize: 3,
        template: '<tr>\
			         <td align="left" valign="middle" style="padding-left:8px;">\
		                {checkRoomId}\
	                 </td>\
	                 <td align="center" valign="middle" class="checktime">\
        	             {checkDate}\
	                 </td>\
			         <td align="center" valign="middle">\
			            {checkResult}\
			         </td>\
	                 <td align="center" valign="middle" style="padding-right:8px;">\
	                   <a href="'+APP.detailUrl+'?checkInfo.id={id}">\
		               <span style="position: relative;">查看检查结果\
		                </a>\
	                 </td>\
                  </tr>',
        isLoading: false,
        loadData: function (evt) {
            var that = this;
            if (that.isLoading) { return; }
            $('<li id="loading_element" class="loading_element"><span class="loading_icon">&nbsp;</span></li>').appendTo($('#tab1'));
            that.isLoading = true;

            $.ajax({
                type: "POST",
                url: APP.offlineUrl+"?roomCode="+hid,
                data: {
            	     "page.current": that.pageIndex,
                     "page.offset": that.pageSize
                },
                async: true,
                success: function (res) {
                    that.isLoading = false;
                    if (0 != res.total) {
                        var HTML_order = iTemplate.makeList(that.template, res.Data, function (k, v) {
                            return {
                            	//realName: v.bottom.user.realName ,
                            	//phone : v.bottom.user.phone
                            }
                        });
                        $("#loading_element").replaceWith($(HTML_order));
                    }
                    else {
                        //$("#div1").addClass("empty");
                        $("#loading_element").remove();
                    }

                    that.pageIndex++;
                    if (that.pageIndex >Math.ceil(res.total / that.pageSize)) {
                           $("#more1").css("display","none");
                    }
                    changeTime();
                },
                dataType: "json"
            });
        }
    };
    
    
    window.changeTime =  function(id){
    	$(".checktime").each(function(){
			 var $this = $(this);
			 var nowTime = $this.html();
			 if(nowTime.indexOf('T')!=-1){
				 nowTime = nowTime.replace('T',' ');
				 $this.html(nowTime);	 
			 }
		 });
    }	
    

    
   window.removeLine =  function(id){
    	$.confirm({txt: '您确定要将此用户踢出下线?',callback:function(){
			 $.ajax({
		         type: "POST",
		         url: APP.exitUrl,
		         timeout: 30000,
		         data: {
		             "id": id
		         },
		         async: true,
		         success: function (res) {
		             if (res.Status == 0) {
		            	 window.location.href = "weixin/wechat!personCenter";
		             }
		             else {
		            	 $.alert({txt: '操作失败!'});
                         console.log("error:error type:"+res.Status);
		             }
		         },
		         dataType: "json"
		     })   
   	    }
	  });
    }
    
	
    $(function () {
         pageArgs1.loadData();
    });

    function getUrlParam(name){
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg);  //匹配目标参数
		if (r!=null) return unescape(r[2]); return null; //返回参数值
	}
    
});