
define(function (require, exports, module) {
    var $ = require("lib_cmd/zepto.js"),
		main = require("js_cmd/main.js"),
		balancepay = require("js_cmd/balancepay.js"),
		myDialog = require("lib_cmd/myDialog.js"),
		iTemplate = require("lib_cmd/iTemplate.js"),
		iForm = require("lib_cmd/iForm.js"),
		ajax3 = require("lib_cmd/ajax3"),
        //
        $eles = {};

    window.onerror = function (e) {
        console.log(JSON.stringify(e));
        return true;
    }
    window.addEventListener("pageshow", function (e) {
        if (sessionStorage.getItem("cache_orderCreate")) {
            location.reload();
        }
    }, false);


    $(function () {
        //初始化页面元素
        $eles = {
            ordercreate2: $(".ordercreate2"),
        }

        initPage();
        fixed_btn().handleEvent();
    });


    function initPage() {

    }


    window.myChoice = function myChoice(thi, evt, type) {
        switch (type) {
            case "address":
                var form1 = $("#form1")[0],
                    cache = {
                        APP_data: {
                            address: APP.data.address
                       
                        },
                        data: {
                            address: data.address//,
                          
                        },  
                        time: +new Date()
                    }
                sessionStorage.setItem("cache_orderCreate", JSON.stringify(cache));
                break;
            
            default:
                break;
        }
    }

    window.createOrder = function createOrder(orderType) {
        var remark = $("#remark").val();
        window.data.createOrder(APP.urls.createOrder_url, orderType, APP.buyFrom, remark, function (payment, payAmount, data, orderType) {
          
                location.href = data.Url;
        }, function (msg) {
            alert(msg);
        });
    }




    //
    function fixed_btn() {
        var Obj = {
            submit_btn1: $("#order_submit_1 .btn")[0],
            //buy_btn2:document.getElementById("buy_btn2"),
            order_submit_2_ul: $("#order_submit_2 ul")[0],
            doc_height: Math.min(document.body.clientHeight, document.documentElement.clientHeight),

            handleEvent: function () {
                var that = this;
                var range = that.submit_btn1.offsetTop - document.body.scrollTop;
                var outRange = "true";
                if (that.order_submit_2_ul) {
                    if (range < that.doc_height + 50 && range > -50) {
                        outRange = false;
                        that.order_submit_2_ul.removeAttribute("style");
                    } else {
                        outRange = true;
                        that.order_submit_2_ul.setAttribute("style", "position:fixed;");
                    }
                }
            }
        }
        window.addEventListener("scroll", Obj, false);
        return Obj;
    };

    function AppData() {
        AppData.instance = this;
        var address = null;//收货地址

        
        Object.defineProperty(this, "address", {
            get: function () { return address; },
            set: function (value) {
                var that = this;
                address = value;
                
                
                //显示当前地址
                var address_url = APP.urls.my_address_page;
                if (address && address.address_id) {
                    address_url += "&addid=" + address.address_id;
                }
                var TPL = '<a href="' + address_url + '" class="tbox arrow" onclick="myChoice(this, event, \'address\');">\
                            <div>\
                            <span class="icon_wrap icon_address">&nbsp;</span>\
                            </div>\
                            <div>\
                            <p><span><label>收货人：</label>{receiver}</span><span class="fr">{phone}</span></p>\
                            <p>{FullAddress}</p>\
                            </div>\
                        </a>';
                if (!address || !address.address_id) {
                    TPL = '<a href="' + APP.urls.my_address_page + '" class="tbox arrow" onclick="myChoice(this, event, \'address\');">\
                            <div>\
                            <span class="icon_wrap icon_address">&nbsp;</span>\
                            </div>\
                            <div>\
                            <p>暂无收货地址</p>\
                            </div>\
                        </a>';
                            
                }
                $("#wrap_address").html(iTemplate.makeList(TPL, [address]));
            }
        });

        //当地址变化时触发的获取配送方式
        var addressChange;
        var listChange;
        this.createOrder = function (url, orderType, buyFrom, remark, success, fail) {
            var that = this;
            if (!that.address || !that.address.address_id) {
                tip("收货地址不能为空~", { classes: "otip" });
                return false;
            }
            if (!navigator.onLine) {
                tip("当前网络不给力哦~", { classes: "otip" });
                return;
            }
            /**订单提交前做库存和限购的校验**/
                 
            var t = tip("订单提交中...", { classes: "otip", t: 1000 * 60 * 3 });
            var formData = new FormData();
            formData.append("buy_list", stockItems);   
            new ajax3({
                url: APP.urls.shopcartBuy_url,
                formData: formData,
                type: "POST",
                callback: function (res) {
                    if (0 == res.Status) {
                    	$.ajax({
                            type: "POST",
                            url: url,
                            timeout: 30000,
                            data: {
                                "address": JSON.stringify(that.address), 
                                "items": goodsItems          
                            },
                            async: false,
                            success: function (res) {
                            	t.destroy();
                                if (res.reCode && res.reCode == "10001") {
                                    window.location.href = 	APP.urls.base_location+"weixin.do?method=orderSuccessPage";
                                }
                                else {       
                                    if(res.reCode && res.reCode == "10002"){
                                    	window.location.href = 	APP.urls.base_location+"weixin.do?method=orderFailPage&reason='您的余额不足,下单失败!'";
                                    }
                                    else{
                                    	window.location.href = 	APP.urls.base_location+"weixin.do?method=orderFailPage&reason='对不起,下单失败!'";
                                    }
                                }
                            },
                            dataType: "json"
                        })
                    }
                    else if (res.Status == 2) {
                    	t.destroy();
                        alert(res.Message);
                    }
                    else {
                    	t.destroy();
                        alert("提交订单失败");
                    }
                  
                }
            });
        

            
            
            
           
            
        }
    }




    function checkArr(arr1, arr2) {
        for (var i = 0; i < arr1.length; i++) {
            for (var j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j])
                    return true;
            }
        }
        return false;
    }

    //
    module.exports = {
        $: $,
        main: main,
        balancepay: balancepay,
        myDialog: myDialog,
        iTemplate: iTemplate,
        iForm: iForm,
        AppData: AppData,
        $eles: $eles
    }
});