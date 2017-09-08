
define(function(require, exports, moudle){
	var $ = require("lib_cmd/zepto.js"),
		main = require("js_cmd/main.js"),
		myDialog = require("lib_cmd/myDialog.js"),
		iForm = require("lib_cmd/iForm.js"),
		iTemplate = require("lib_cmd/iTemplate.js"),
		aLocation = require("lib_cmd/aLocation.js"),
		_Select = null;

		var aSelect = (function(aLocation){
			var _aSelect = function(apro, acit, aare, apv, acv, aav){
				this.apro = apro;
				this.acit = acit;
				this.aare = aare;
				this.values = [];
				this.values.push(apv||0, acv||0, aav||0);
				this.level = 3;
				this.init();
			}

			_aSelect.prototype = {
				init: function(){
					var self = this;
					self.apro.addEventListener("change", self, false);
					self.acit.addEventListener("change", self, false);
					self.aare.addEventListener("change", self, false);
					self.handleEvent({target:{value:self.apro.value}});
					return self;
				},
				handleEvent: function(evt){
					var self = this,
						ele = evt.target;
					switch(ele){
						case self.apro:
							self.values[0] = self.apro.value;
							self.setOption(self.acit, aLocation["0,"+self.values[0]], 1);
							self.handleEvent({target:self.acit});
						break;
						case self.acit:
							self.values[1] = self.acit.value;
							self.setOption(self.aare, aLocation["0,"+self.values[0]+","+self.values[1]], 2);
							self.handleEvent({target:self.aare});
							//判断是否存在三级地区
							self.level = aLocation["0,"+self.values[0]+","+self.values[1]]<1?2:3;
							$(self.aare).closest("li").css("display", self.level<3?"none":"inherit");
						break;
						case self.aare:
							self.values[2] = self.aare.value;
						break;
						default:
							self.setOption(self.apro, aLocation[0], 0);
							self.handleEvent({target:self.apro});
						break;
					}
				},
				setOption: function(ele, data, index){
					var self = this,
					val = 0,
					_val = self.values[index];
					ele.options.length = 1;
					for(var d in data){
						(d == _val)&&(val = d);
						ele.options.add(new Option(data[d], d));
					}
					ele.value = self.values[index] = val;
					return self;
				}
			}
			return _aSelect;
		})(aLocation);


		//
		$(function(){
			//
			var $list_address_edit = $("#list_address_edit"),
				TPL = $list_address_edit.html(),
				html = '',
				curAddr = localStorage.getItem("curAddr")||'{"ID":"", "NAME":"", "TEL":"", "DETAIL":"", "type":0}';
				curAddr = JSON.parse(curAddr);
			html = iTemplate.makeList(TPL, [curAddr], function(k,v){
				return{
					set_default_str:(1==v.isVip)?"会员卡地址暂不支持设为默认地址":"设为默认",
					show:(1==v.isVip)?" vhidden":"",
				    checked_str: "true" == v["isDefault"] ? 'checked="checked"' : ''
				}
			});
			$list_address_edit.html(html).removeClass("vhidden");
			//
			var form_list_address = $("#form_list_address")[0],
				name = form_list_address.name,
				tel = form_list_address.tel,
				provience = form_list_address.provience,
				city = form_list_address.city,
				area = form_list_address.area,
				address = form_list_address.address,
				_default = form_list_address._default,

				name_v,
				tel_v,
				address_v;

			//
			form_list_address.callBack = function(res){
				if(res && (0 == res.Status)){
					//if(res.url){
						history.go(-1);
					//}
				}
			}
			$("#btn_save_address, #btn_cancel_address").on("click", function(){
				switch(this.id){
					case "btn_save_address":
						//
						name_v = $.trim(name.value);
						tel_v = $.trim(tel.value);
						address_v = $.trim(address.value);

						if(name_v.length<1){
							alert("请输入收货人姓名");return;
						}
						if(!/^.{5,20}$/gi.test(tel_v) || !/^(\+\s?)?(\d*\s?)?(?:\(\s?(\d+[-\s])?\d+\s?\)\s?)?\s?(\d+[-\s]?)+\d+$/gi.test(tel_v) ){
							alert("请输入收货人联系电话");return;
						}
						if([null, provience, city, area][_Select.level].value.length<3){
							alert("请选择地址");return;
						}
						if(address_v.length<1){
							alert("请输入详细地址");return;
						}
						form_list_address.PName.value = form_list_address.provience.options[form_list_address.provience.selectedIndex].text;
						form_list_address.CName.value = form_list_address.city.options[form_list_address.city.selectedIndex].text;
						form_list_address.DName.value = form_list_address.area.options[form_list_address.area.selectedIndex].text;
						if(0 == form_list_address.area.selectedIndex){
							form_list_address.DName.value = "";
						}
						//
						form_list_address.action = APP.urls[(1==APP.type)?"editAddress":"addAddress"];
						form_list_address.submit();
						localStorage.removeItem("curAddr");
					break;
					case "btn_cancel_address":
						if(1==APP.type){
							form_list_address.action = APP.urls.delAddress;
							form_list_address.submit();
							localStorage.removeItem("curAddr");
						}else{
							history.go(-1);
						}
					break;
				}
			});
			_Select = new aSelect(provience, city, area, curAddr.PROVINCE, curAddr.CITY, curAddr.AREA);

		});
		

});