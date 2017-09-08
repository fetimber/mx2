
define(function (require, exports, module) {
    var $ = require("lib_cmd/zepto.js"),
		main = require("js_cmd/main.js"),
		myDialog = require("lib_cmd/myDialog.js"),
		balancepay = require("js_cmd/balancepay.js"),
		scrollEvt = require("lib_cmd/scrollEvt.js"),
		iTemplate = require("lib_cmd/iTemplate.js");
    


    /**异步加载数据模块**/
    var pageArgs = {
        pageIndex: 0,
        pageSize: 10,
        template: '<div  class="orderlist">\
						<span>\
							下单时间：{ORDERTIME}\
							<label>￥{TOTALPRICE}</label>\
						</span>\
						<ul>\
						    <li>\
						      <a href="'+ APP.urls.detail + '&id={ORDER_ID}">\
							   <span><img src="{IMAGE_PATH}" /></span>\
							   <label>\
								  <span class="table">\
							    	  <div class="line1"> \
							    		  <span>{GOODS_NAME}</span> \
							    	  </div> \
							     	  <div class="line2"> \
							     		  <span>￥{TOTALPRICE}</span> \
							     	  </div> \
							    	  <div class="line3"> \
							    		  <span>/数量{COUNT}</span> \
							     	  </div>\
							      </span>\
						        </label>\
				      	     </a>\
				      	     </li>\
						</ul>\
						<label>{PayStatus_url}\
						</label>\
					</div>',
        isLoading: false,
        loadData: function (evt) {
            var that = this;
            if (that.isLoading) { return; }
            $('<li id="loading_element" class="loading_element"><span class="loading_icon">&nbsp;</span></li>').appendTo($('#list_order'));
            that.isLoading = true;

            $.ajax({
                type: "POST",
                url: APP.urls.myorder_url,
                data: {
                    "pageIndex": that.pageIndex,
                    "pageSize": that.pageSize,
                    "type": APP.type
                },
                async: true,
                success: function (res) {
                    that.isLoading = false;
                    if (0 != res.total) {
                        var HTML_order = iTemplate.makeList(that.template, res.Data, function (k, v) {
                            return {
                                PayStatus_url: (function () {
                                    var crowdBtnstr = "";
                                    var strReturn = "";
                                   
                                    if (v.ORDERSTATE == 1)//未付款
                                    {
                                      
                                            strReturn = '<span class="orderStatus">未付款</span>';
                                       
                                    }
                                    else if (v.ORDERSTATE == 2)//已付款
                                    {
                                      
                                            strReturn = '<span class="orderStatus">已付款</span><a href="javascript:;" class="btn fr black" onclick="operateOrder(this, event , ' + v.ORDER_ID +',\''+v.ORDERNO+'\',8,2);">退货</a>';
                                       
                                    }
                                    else if (v.ORDERSTATE == 3)//可疑订单
                                    {
                                      
                                            strReturn = '<span class="orderStatus">可疑订单</span>';
                                       
                                    }
                                    else if (v.ORDERSTATE == 4)//完成
                                    {
                                      
                                            strReturn = '<span class="orderStatus">完成</span>';
                                       
                                    }
                                    else if (v.ORDERSTATE == 5)//已撤销
                                    {
                                      
                                            strReturn = '<span class="orderStatus">已撤销</span>';
                                       
                                    }
                                    else if ( v.ORDERSTATE == 6 )//异常
                                    {
                                    	strReturn = '<span class="orderStatus">异常</span><a href="javascript:;" class="btn fr black" onclick="operateOrder(this, event, ' + v.ORDER_ID +',\''+v.ORDERNO+'\',8,6);">退货</a>';
                                    }
                                    else if ( v.ORDERSTATE == 7 )//已发货
                                    {
                                    	    strReturn = '<span class="orderStatus">已发货</span><a href="javascript:;" class="btn fr black" onclick="operateOrder(this, event, ' + v.ORDER_ID +',\''+v.ORDERNO+'\',8,7);">退货</a>&nbsp;'+
                                    	                '<a href="javascript:;" class="btn fr red" onclick="operateOrder(this, event, ' + v.ORDER_ID +',\''+v.ORDERNO+'\',4,7);">确认收货</a>';
                                    }
                                    else if ( v.ORDERSTATE == 8 )//退货中
                                    {
                                    	    strReturn = '<span class="orderStatus">退货中</span>';
                                    }
                                    else if ( v.ORDERSTATE == 9 )//退货完成
                                    {
                                    	    strReturn = '<span class="orderStatus">退货完成</span>';
                                    }
                                    else if ( v.ORDERSTATE == 10 )//拒绝退货
                                    {
                                    	    strReturn = '<span class="orderStatus">拒绝退货</span><a href="javascript:;" class="btn fr black" onclick="operateOrder(this, event, ' + v.ORDER_ID +',\''+v.ORDERNO+'\',8,10);">退货</a>&nbsp;'+
                                    	                '<a href="javascript:;" class="btn fr red" onclick="operateOrder(this, event, ' + v.ORDER_ID +',\''+v.ORDERNO+'\',4,10);">确认收货</a>';
                                    }
                                    
                                    
                                   
                                    return strReturn;

                                })()
                            
                               
                                
                            }
                        });
                        $("#loading_element").replaceWith($(HTML_order));
                    }
                    else {
                        $("#list_order").addClass("empty");
                        $("#loading_element").remove();
                    }

                    that.pageIndex++;
                    if (that.pageIndex >= Math.ceil(res.total / that.pageSize)) {
                        myScroll.stop();
                    }
                },
                dataType: "json"
            });
        }
    };


    //操作订单 改变订单状态
    window.operateOrder = function (thi, evt, id ,orderNo ,nextStatus, nowStatus) {
    	
    	var msg = "" ;
    	var rgs = "微信用户下单退货" ;
    	var _status = Number(nextStatus);
    	switch(_status){
    	case 4:
    		  msg= "确认您已经收货成功?";
    		  break;
    	case 5:
    		  msg= "确认要撤销此订单?";
  		      break;
    	case 8:
    		  msg= "确认要退货?";
  		      break;
    	case 9:
    		  msg= "确认已退货成功?";
  		      break;
  		default:
  			  break;
    	   
    	}
        if (!this.goOn) {
            var _arguments = arguments;
            confirm('<p>'+msg+'</p>', {
                callBack: function (evt) {
                    var that = this, ele = null;
                    if (evt && (ele = evt.target) && ("BUTTON" == ele.tagName) && "确定" == (ele.innerText)) {
                        _arguments.callee.call({ "goOn": true }, thi, evt, id ,orderNo ,nextStatus, nowStatus );
                    }
                    return true;
                }
            });
            return;
        }
        var l = loading();
        $.ajax({
            type: "POST",
            url: APP.urls.order_confirmReceipt_url,
            data : {
				'orderNo' : orderNo,        //订单编号
				'orderStatus' : nextStatus, //将要变成的订单状态
				'orderId':id,          //订单Id
				'nowStatus':nowStatus,      //现在的订单状态
				'rgs':rgs                   //投诉订单时的投诉原因
			},
            async: false,
            success: function (res) {
                l.destroy();
                if (res.Status == 0) {
                        alert(res.Message, {
                            callBack: function () {
                                location.reload();
                                return true;
                            }
                        });
 
                }
            },
            dataType: "json"
        });

    }

    

    var myScroll = new scrollEvt(pageArgs).start();

    $(function () {
        pageArgs.loadData();
    });


});