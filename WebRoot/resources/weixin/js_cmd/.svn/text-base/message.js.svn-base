
define(function(require, exports, module){
	var $ = require("lib_cmd/zepto.js"),
		io = require("lib_cmd/socketIo.js");

	var SocketIp = "115.29.229.136";
    var TimeInterval;
    var getType = 1;
    var ajaxAddress = "http://kf.weimob.com/";

    var Factory = {
        create: function () {
            return function () { this.init.apply(this, arguments); }
        }
    }

    var ChatFloatFactory = Factory.create();

    ChatFloatFactory.prototype = {
        init: function () {
            return this;
        },
        setCookie: function (name, value, seconds) {
            var exp = new Date();
            exp.setTime(exp.getTime() + seconds);
            document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
        },
        getCookie: function (name) {
            var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
            if (arr = document.cookie.match(reg))
                return unescape(arr[2]);
            else
                return null;
        },
        AjaxRight: function (t, options, cookobj3g) {
            var e = this;
            var openid = options.openid ? options.openid : "";
            var weimobid = "";
            if (cookobj3g != null) {
                weimobid = cookobj3g.weimobid;
            }
            $.ajax({
                url: ajaxAddress + "Ajax/CustomerChatAjax.aspx",
                data: {
                    action: "userright",
                    AId: options.AId,
                    openid: openid,
                    weimobid: weimobid
                },
                success: function (obj) {
                    if (obj) {
                        e.setCookie('_useright_' + options.AId, '{"show":' + obj.succ + ',"aid":' + options.AId + ',"weimobid":"' + obj.weimobid + '","socket":' + obj.socket + ',"openid":"' + options.openid + '"}', 300 * 1000);
                        if (obj.succ && obj.weimobid && obj.weimobid.length > 0) {
                            t.initialize(options, obj.weimobid, obj.msgcount, obj.socket);
                            e.setCookie('_3GUserInfo_' + options.AId, '{"aid":' + options.AId + ',"weimobid":"' + obj.weimobid + '","openid":"' + options.openid + '","headurl":"' + obj.headurl + '","markname":"' + obj.markname + '","nickname":"' + obj.nickname + '"}', 3600 * 24 * 10000 * 1000);
                            Tools.LocationSource(options, options.AId, obj.weimobid, obj.nickname, obj.markname, obj.headurl);
                        }
                    }
                },
                dataType: "json"
            });
        },
        SocketMessage: function (AId, weimobid) {
            var e = this;
            $.ajax({
                url: ajaxAddress + "Ajax/CustomerChatAjax.aspx",
                data: {
                    action: "GetFloatSocketMessage",
                    AId: AId,
                    weimobid: weimobid
                },
                success: function (count) {
                    e.PollingSuccess(count);
                },
                dataType: "text"
            });
        },
        PollingSuccess: function (count) {
            if (parseInt(count) > 0) {
                $("#tolls_widget_message").attr("data-count", count);
            }
        },
        loadjscssfile: function (filename, filetype, loadfunction) {
            var fileref;
            if (filetype == "js") {
                fileref = document.createElement('script');
                fileref.setAttribute("type", "text/javascript");
                fileref.setAttribute("src", filename);

            } else if (filetype == "css") {
                fileref = document.createElement('link');
                fileref.setAttribute("rel", "stylesheet");
                fileref.setAttribute("type", "text/css");
                fileref.setAttribute("href", filename);
            }
            if (typeof fileref != "undefined") {
                document.getElementsByTagName("head")[0].appendChild(fileref);
            }
            fileref.onload = fileref.onreadystatechange = function () {
                if (!this.readyState || this.readyState == 'loaded' || this.readyState == 'complete') {
                    loadfunction();
                }
            }
        },
        LocationSource: function (options, aid, weimobid, nickname, markname, headurl) {
            var openid = options.openid ? options.openid : "";
            $.ajax({
                url: ajaxAddress + "Ajax/CustomerChatAjax.aspx",
                data: {
                    action: "LocationSource",
                    AId: aid,
                    openid: openid,
                    weimobid: weimobid,
                    nickname: nickname,
                    markname: markname,
                    headurl: headurl
                },
                success: function (obj) {
                    if (obj) {

                    }
                },
                dataType: "json"
            });
        }
    }

    var Tools = new ChatFloatFactory();

    window.ChatFloat = function (options) {
        var e = this;
        if (options && options.AId) {
            //如果是APP里访问的，则结束
            if (window.location.href.indexOf("APP=true") > 0) {
                return;
            }
            if (options.IsTest != undefined && options.IsTest) {
                SocketIp = "112.124.16.233";
                ajaxAddress = "http://112.124.16.233/";
            }

            var cooktext = Tools.getCookie("_3GUserInfo_" + options.AId);
            var cookobj3g = eval('(' + cooktext + ')');
            //判断有没有显示的权限
            var strStoreData = Tools.getCookie("_useright_" + options.AId);
            if (strStoreData && strStoreData.length > 0) {
                var objStorage = eval('(' + strStoreData + ')');
                if (objStorage && objStorage.aid == options.AId) {
                    if (objStorage.show && objStorage.weimobid) {
                        var socket = 0;
                        if (objStorage.socket) {
                            socket = objStorage.socket;
                        }
                        e.initialize(options, objStorage.weimobid, 0, socket);
                        Tools.SocketMessage(options.AId, objStorage.weimobid);
                        //写访问记录
                        if (cookobj3g != null) {
                            Tools.LocationSource(options, cookobj3g.aid, cookobj3g.weimobid, cookobj3g.nickname, cookobj3g.markname, cookobj3g.headurl);
                        }
                    }
                }
                else {
                    Tools.AjaxRight(e, options, cookobj3g);
                }
            }
            else {
                Tools.AjaxRight(e, options, cookobj3g);
            }
        }
    };

    ChatFloat.prototype = {
        initialize: function (options, weimobid, msgcount, socket) {
            var e = this;
            var openid = options.openid ? options.openid : "";
            $("#tools_kfli").show();
            $("#tolls_widget_message").attr("href", ajaxAddress + "MobileTalking.aspx?aid=" + options.AId + "&openid=" + openid + "&weimobid=" + weimobid);
            if (socket == 1) {
                e.socketconnect(options, weimobid);
                //Tools.loadjscssfile("http://" + SocketIp + ":8889/socket.io/socket.io.js", "js", function () { e.socketconnect(options, weimobid); });
            }
        },
        socketconnect: function (options, weimobid) {
            try {
                var socket = io.connect('http://' + SocketIp + ':8889/');
                //连接事件
                socket.on("connect", function () {
                    getType = 1;
                    socket.emit('paramquery', {
                        aid: options.AId,
                        weimobid: weimobid
                    });
                    socket.on('dataChange', function (json) {
                        if (json) {
                            if (json.msgCount == 1) {
                                $("#tolls_widget_message").attr("data-count", "1");
                                //Tools.SocketMessage(options.AId, weimobid);
                            }
                        }
                    });
                });
                //重新连接
                socket.on('reconnecting', function (data) {

                });
                //重新连接成功
                socket.on('reconnect', function (data) {

                });
                socket.on('disconnect', function () { });
            }
            catch (e) {
            }
        }
    };
    new ChatFloat({
        AId: window.APP.AId,
        openid: window.APP.openid
    });

});