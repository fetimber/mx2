
define(function(require, exports, moudle){
	var $ = require("lib_cmd/zepto.js"),
		main = require("js_cmd/main.js"),
		myDialog = require("lib_cmd/myDialog.js"),
		iTemplate = require("lib_cmd/iTemplate.js"),
		aLocation = require("lib_cmd/aLocation.js");

	function get_my_address(){
		var l = loading();
		$.ajax({
			type: "POST",
			url: APP.urls.my_address,
			data: {
			},
			async:true,
			success: function(res){
				l.destroy();
				var html = ['', '', '<div class="noAddress">暂无收货地址</div>'], $html;
				if(0 == res.Status && res.Data && res.Data.length){
					var TPL = '<li>\
							<a href="javascript:;">\
								<label class="tbox" {isDefault_str}>'+
									(APP.select?'<div>\
										<span>\
											<input type="radio" class="radio" name="my_address" value="{ID}" data-index="{k}" {checked_str}>\
										</span>\
									</div>':"")+
									'<div>\
										<p>\
											<label>姓名</label>&nbsp;{NAME}\
										</p>\
										<p>\
											<label>电话</label>&nbsp;{TEL}\
										</p>\
										<p>\
											<label>地址</label>&nbsp;{FULLADDRESS}\
										</p>\
									</div><div><p style="width:60px;">&nbsp;</p></div>\
								</label>\
								<div class="icon_edit" data-index="{k}"></div>\
							</a>\
						</li>';
					html = [iTemplate.makeList(TPL, res.Data, function(k,v){
						return{
							k:k,
							isDefault_str:"true" == v["ISDEFAULT"] ? 'data-default="默认地址"' : '',
							checked_str: "true" == v["ISDEFAULT"] ? 'checked="checked"' : '',
							my_addressEdit_url:APP.urls.my_addressEdit_url+"&aid="+v.ID
						}
					})];
				}
				$html = $(html.join(''));
				$("#list_address").html($html).addClass("on");
				$html.find(APP.select?"input, .icon_edit":".icon_edit").click(function(evt){
					var idx = this.getAttribute("data-index");
					var curAddr = res.Data[idx];
					localStorage.setItem("curAddr", JSON.stringify(curAddr) );
					if("DIV" == this.tagName){
						location.href = APP.urls.my_addressEdit_url+"&aid="+curAddr.ID;
					} else {
					    var val = {
					        address_id: curAddr.ID,
					        receiver: curAddr.NAME,
					        phone: curAddr.TEL,
					        FullAddress: curAddr.FULLADDRESS
					    };
					    //setMyaddress(this, evt, val);
					    var _curAddr = res.Data[idx];
					    var curAddr = {
					    	"pid":"255388",
					    	"receiver":_curAddr.NAME,
					    	"phone":_curAddr.TEL,
					    	"address_id":_curAddr.ID,
					    	"address":_curAddr.DETAIL,
					    	"province_id":_curAddr.PROVINCE,
					    	"city_id":_curAddr.CITY,
					    	"zone_id":_curAddr.AREA,
					    	"is_default":"true" == _curAddr["ISDEFAULT"],
					    	"PName":_curAddr.PNAME,
					    	"CName":_curAddr.CNAME,
					    	"DName":_curAddr.DNAME,
					    	"Type":_curAddr.type,
					    	"FullAddress":_curAddr.FULLADDRESS
					    }
					    sessionStorage.setItem("cache_curAddr", JSON.stringify(curAddr));
						history.go(-1);
					}
				});
			},
			dataType: "json"
		});
	}

	function setMyaddress(thi, evt, val) {
	    if (window != window.parent) {
	        window.parent.postMessage({ val: val, method: "address" }, "*");
	        return false;
	    } else {
	        return true;
	    }
	}


	window.getWXaddr = function getWXaddr(thi, evt){
		WeixinJSBridge.invoke('editAddress', {
	        "appId": APP.wx_addr.AppId,
	        "scope": "jsapi_address",
	        "signType": "sha1",
	        "addrSign": APP.wx_addr.asign,
	        "timeStamp": APP.wx_addr.Timestamp,
	        "nonceStr": APP.wx_addr.Noncestr
	    }, function (res) {
	        //alert(JSON.stringify(res));
	        //若res 中所带的返回值不为空，则表示用户选择该返回值作为收货地址。否则若返回空，则表示用户取消了这一次编辑收货地址。
	        if (res.err_msg == 'edit_address:ok') {
				var _data = {
					name:res.userName,
					tel:res.telNumber,
					provience:"",
					city:"",
					area:"",
					"PName":res.proviceFirstStageName,
			    	"CName":res.addressCitySecondStageName,
			    	"DName":res.addressCountiesThirdStageName,
					address:res.addressDetailInfo,
					type:"1"
				};

				//get id
				(function(){
					function getId(name, list){
						for(var i in list){
							if(name.indexOf(list[i])>-1){
								return i;
								break;
							}
						}
					}

					_data.provience = getId(_data.PName, aLocation[0]);
					_data.city = getId(_data.CName, aLocation[0+","+_data.provience]);
					_data.area = getId(_data.DName, aLocation[0+","+_data.provience+","+_data.city]);
				})();

				var l = loading();
				$.ajax({
					type: "POST",
					url: APP.urls.my_address_add_url,
					data: _data,
					async:true,
					success: function(res){
						l.destroy();
						get_my_address();
					}
				});
	        }
	    });
	}

	//
	$(function(){
	    get_my_address();
	    if(APP.noDefault){
	    	tip("请选择相应的收货地址",{classes: "otip2", t: 1000});
	    }
	    $("#btn_addAddress").click(function() {
	        localStorage.removeItem("curAddr");
	    });
	});

});