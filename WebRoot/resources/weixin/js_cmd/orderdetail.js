 
define(function(require, exports, module){
    var $ = require("lib_cmd/zepto.js"),
        main = require("js_cmd/main.js"),
        balancepay = require("js_cmd/balancepay.js"),
        myDialog = require("lib_cmd/myDialog.js");


    window.orderOperate = function orderOperate(thi, evt, id ,orderNo ,nextStatus, nowStatus) {
    	var msg = "" ;
    	var rgs = "" ;
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
                    ele = evt.target;
                    if (evt && (ele = evt.target) && ("BUTTON" == ele.tagName) && "确定" == (ele.innerText)) {
                        _arguments.callee.call({ "goOn": true }, thi, evt, id ,orderNo ,nextStatus, nowStatus);
                    }
                    return true;
                }
            });
            return;
        }
        var l = loading();
        $.ajax({
            type: "POST",
            url: APP.urls.ConfirmReceipt_url,
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



});