define(function(require, exports, module){
    var $ = require("lib_cmd/zepto"),
    	myDialog = require("lib_cmd/myDialog"),
		_APP = window.APP||{};
		window.$ = $,
		$eles = {},
		ele = {};

	//
	ele = (function(){
		function Ele(){
			var loading_bottom = '<div data-role="widget" data-widget="loading_bottom" id="loading_bottom" class="loading_bottom">\
							<div class="widget_wrap">\
								<ul class="tbox">\
									<li>\
										<div class="loading_wrap">\
											<span class="loading">&nbsp;</span>\
										</div>\
									</li>\
									<li>\
										正在加载，请稍后...\
									</li>\
								</ul>\
								<ul class="tbox">\
									<li></li>\
									<li style="text-align:center;">\
										没有更多数据\
									</li>\
								</ul>\
							</div>\
						</div>';
			var img_src = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAC0lEQVQIW2NkAAIAAAoAAggA9GkAAAAASUVORK5CYII=";
			
			this.loading_bottom = loading_bottom;
			this.img_src = img_src;
		}
		//
		return new Ele();
	})();
	//显示客服按钮和返回顶部按钮
	(function(){
		var _html = "",
			fn_goTop,
			fn_message;
		if(_APP.goTop){
			_html += '<li>\
						<a href="javascript:;" id="tools_widget_goTop" class="tools_widget_goTop hidden">顶部</a>\
					</li>';
			fn_goTop = function($id){
				var Obj = {
					ele: $id[0],
					init: function(){
						this.ele.addEventListener("click", function(){
							var st = document.body.scrollTop, step = 10;
							var timer = setInterval(function(){
								window.scrollBy(0, -(step+=5) );
								if( (st-=step)<=0){
									clearInterval(timer);
								}
							}, 15);
						}, false);
						window.addEventListener("scroll", this, false);
						return this;
					},
					handleEvent:function(evt){
						var top = document.body.scrollTop,
							height = $(window).height();
						this.ele.classList[top<height?"add":"remove"]("hidden");
						return this;
					}
				}
				Obj.init().handleEvent();
			}
		}
		if(_APP.message){
			_html += '<li id="tools_kfli" style="display:none;">\
						<a href="javascript:;" id="tolls_widget_message" class="tolls_widget_message" >客服</a>\
					</li>';
			fn_message = function () {
			    var message = require.async("js_cmd/message");
			}
		}
		if(_html){
			_html = '<div data-widget="tools" data-tools="tools_widget" id="tools_widget" class="tools_widget" >\
				<div class="widget_wrap">\
					<ul class="tools_widget_wrap">'+_html +'</ul></div></div>';
			var $_html = $(_html);
			$_html.appendTo( $(".container") );
			fn_goTop&&fn_goTop($_html.find("#tools_widget_goTop"));
			fn_message&&fn_message($_html.find("#tolls_widget_message"));
		}

	})();
	
	//
	$(function(){
		//设置版权信息位置为一屏
		$('*[data-role="body"]').css("min-height", (Math.min(window.screen.height, (document.body.scrollHeight-80)) - $('*[data-role="header"]').height() )+"px");
	});

	module.exports = {
		ele: ele
	}
});