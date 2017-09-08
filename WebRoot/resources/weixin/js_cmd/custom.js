
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
	$("#more2").click(function(){
		pageArgs2.loadData();
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
	
	$("#div_xm_tpc2").click(function(){
		var $this = $(this);
		if($this.hasClass("xm_tpc_s")){
			$this.removeClass("xm_tpc_s").addClass("xm_tpc_ls");
			$("#d_p2").css("display","none");
			$this.find("img").attr("src","resources/images/arrow1_w1.png");
		}else{
			$this.removeClass("xm_tpc_ls").addClass("xm_tpc_s");
			$("#d_p2").css("display","");
			$this.find("img").attr("src","resources/images/arrow1_w1_u1.png");
		}
	});
    
    /**异步加载数据模块**/
    var pageArgs1 = {
        pageIndex: 1,
        pageSize: 3,
        template: '<tr>\
			         <td align="left" valign="middle" style="padding-left:8px;">\
		                <a href="'+APP.detailUrl+'?cId={id}">{customerName}</a>\
	                 </td>\
	                 <td align="center" valign="middle">\
		                 {followTimeDesc}\
	                 </td>\
	                 <td align="center" valign="middle">\
		                 {resultMsg}\
	                 </td>\
	                 <td align="center" valign="middle" style="padding-right:8px;">\
	                   <a href="'+APP.detailUrl+'?cId={id}">\
		               <span style="position: relative;">&gt;&gt;\
		                   {msgHtml}\
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
                url: APP.myCustomUrl,
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
                            	recordCount: v.records.length || '0',
                            	msgHtml : (function(){
                            		  if(v.messageCount == 0){
                            			  return "";
                            		  }else{
                            			  return '<span class="icon_tips1">'+v.messageCount+'</span>';
                            		  }
                            	})(),
                            	resultMsg: (function () {
                            		var strReturn ='未知';
                            		
                                   
                                    if (v.customerStatus == 1 || v.customerStatus == 2)
                                    {
                                      
                                            strReturn = '新客户';
                                       
                                    }
                                    else if (v.customerStatus == 3)
                                    {
                                     
                                    	    strReturn = '电联';
                                    }
                                    else if (v.customerStatus == 4)
                                    {
                                     
                                    	    strReturn = '到访';
                                    }
                                    else if (v.customerStatus == 5)
                                    {
                                     
                                    	    strReturn = '认购';
                                    }
                                    else if (v.customerStatus == 6)
                                    {
                                     
                                    	    strReturn = '签约';
                                    }
                                    else if (v.customerStatus == 7 || v.customerStatus == 8)
                                    {
                                     
                                    	    strReturn = '结佣';
                                    }
                                   
                                    return strReturn;

                                })()
                            
                               
                                
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
    
    
    
    
    
	/**异步加载数据模块**/
    var pageArgs2 = {
        pageIndex: 1,
        pageSize: 3,
        template: '<tr>\
	                  <td align="left" valign="middle" style="padding-left:8px;">\
                          {customerName}\
                      </td>\
                      <td align="center" valign="middle">\
                          {followTimeDesc}\
                      </td>\
                      <td align="center" valign="middle">\
                          {resultMsg}\
                      </td>\
                      <td align="center" valign="middle" style="padding-right:8px;">\
                        <a href="'+APP.detailUrl+'?cId={id}">\
                            已流失&gt;&gt;\
                         </a>\
                      </td>\
                  </tr>',
        isLoading: false,
        loadData: function (evt) {
            var that = this;
            if (that.isLoading) { return; }
            $('<li id="loading_element2" class="loading_element"><span class="loading_icon">&nbsp;</span></li>').appendTo($('#tab2'));
            that.isLoading = true;

            $.ajax({
                type: "POST",
                url: APP.myMissCustomUrl,
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
                            	recordCount: v.records.length || '0',
                            	resultMsg: (function () {
                            		var strReturn ='未知';
                            		
                                   
                                    if (v.customerStatus == 0)
                                    {
                                      
                                            strReturn = '申诉';
                                       
                                    }
                                    else if (v.customerStatus == 1)
                                    {
                                     
                                    	    strReturn = '未分配';
                                    }
                                    else if (v.customerStatus == 2)
                                    {
                                     
                                    	    strReturn = '未处理';
                                    }
                                    else if (v.customerStatus == 3)
                                    {
                                     
                                    	    strReturn = '电联';
                                    }
                                    else if (v.customerStatus == 4)
                                    {
                                     
                                    	    strReturn = '到访';
                                    }
                                    else if (v.customerStatus == 5)
                                    {
                                     
                                    	    strReturn = '认购';
                                    }
                                    else if (v.customerStatus == 6)
                                    {
                                     
                                    	    strReturn = '签约';
                                    }
                                    else if (v.customerStatus == 7)
                                    {
                                     
                                    	    strReturn = '申请结佣';
                                    }
                                    else if (v.customerStatus == 8)
                                    {
                                     
                                    	    strReturn = '已结佣';
                                    }
                                    else if (v.customerStatus == 9)
                                    {
                                     
                                    	    strReturn = '申请提现';
                                    }
                                    else if (v.customerStatus == 10)
                                    {
                                     
                                    	    strReturn = '催办';
                                    }
                                   
                                   
                                    return strReturn;

                                })()
                            
                               
                                
                            }
                        });
                        $("#loading_element2").replaceWith($(HTML_order));
                    }
                    else {
                        //$("#div2").addClass("empty");
                        $("#loading_element2").remove();
                    }

                    that.pageIndex++;
                    if (that.pageIndex > Math.ceil(res.total / that.pageSize)) {
                    	
                           $("#more2").css("display","none");
                    }
                },
                dataType: "json"
            });
        }
    };
	
    $(function () {
         pageArgs1.loadData();
         pageArgs2.loadData();
    });

});