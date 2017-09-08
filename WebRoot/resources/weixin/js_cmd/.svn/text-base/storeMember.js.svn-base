
define(function (require, exports, moudle) {
    var $ = require("lib_cmd/zepto"),
		main = require("js_cmd/main"),
		myDialog = require("lib_cmd/myDialog"),
		scrollEvt = require("lib_cmd/scrollEvt"),
		iTemplate = require("lib_cmd/iTemplate"),
		$eles = {},
		ele = {};
   
    
    $("#more1").click(function(){
		pageArgs1.loadData();
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
		                <a href="'+APP.detailUrl+'?agentId={agentId}">{realName}</a>\
	                 </td>\
	                 <td align="center" valign="middle">\
		                 {phone}\
	                 </td>\
	                 <td align="center" valign="middle">\
		                 {createTime}\
	                 </td>\
	                 <td align="center" valign="middle">\
	                     {customerCount}\
                     </td>\
	                 <td align="center" valign="middle" style="padding-right:8px;">\
	                   <a href="'+APP.detailUrl+'?agentId={agentId}">\
		               <span style="position: relative;">&gt;&gt;\
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
                url: APP.storeMemberUrl,
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
                            	realName: v.agent.user.realName,
                            	phone: v.agent.user.phone,
                            	createTime :v.agent.user.createTimeDesc,
                            	customerCount : v.agent.customerCount,
                            	agentId : v.agent.id
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
                },
                dataType: "json"
            });
        }
    };
    
	
    $(function () {
         pageArgs1.loadData();
    });

});