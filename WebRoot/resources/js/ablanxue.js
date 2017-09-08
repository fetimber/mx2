if (jQuery)
	(function($) {
		var array =[0,1,2,3,4,5,6,7,8,9];
		 //获取数组长度
	    var arrlen = array.length;
	    //创建数组 存放下标数
	    var try1 = new Array();
	    for(var i = 0;i < arrlen; i++){
	        try1[i] = i;
	    }
	    //创建数组 生成随机下标数
	    var try2 = new Array();
	    for(var i = 0;i < arrlen; i++){
	        try2[i] = try1.splice(Math.floor(Math.random() * try1.length),1);
	    }
	    //创建数组，生成对应随机下标数的数组
	    var try3 = new Array();
	    for(var i = 0; i < arrlen; i++){
	        try3[i] = array[try2[i]];
	    }
	    
	    var keybords = "";
	    for(var i = 0 ; i < try3.length; i++){
	    	keybords+="<li class=\"key\">";
	    	keybords+=try3[i];
	    	keybords+="</li>";
	    }
	    
		// 定义键盘代码
		var _numkeybordhtml = "<div id=\"numkeybord\">\n" + "<div id=\"keymain\">" + "@keybords" + "<li id=\"esc\">键盘输入</li>"
				+ "<li id=\"back\">退格</li>" + "<li id=\"clear\">清空</li>"
				+ "<li id=\"enter\">确定</li>" + "</div>\n" + "</div>\n";
		_numkeybordhtml = _numkeybordhtml.replace("@keybords", keybords);
		var mozilla = /firefox/.test(navigator.userAgent.toLowerCase());
		var webkit = /webkit/.test(navigator.userAgent.toLowerCase());
		var opera = /opera/.test(navigator.userAgent.toLowerCase());
		var msie = /msie/.test(navigator.userAgent.toLowerCase());
		// 定义插件
		jQuery.fn.numkeybord = function(_option) {
			// 键盘追加到网页中
			$(document.body).append(_numkeybordhtml);
			var _obj = this;
			jQuery.each(_obj, function(i, _o) {
				$(_o).bind('click', function() {
					_show(this);
				});
			});
			$("#numkeybord #enter").bind('click', function() {
				_hide();
			});
			$("#numkeybord .key").bind('click.returnkey', function() {
				var tmp = $("#numkeybord").attr("target");
				var obj_tmp = $("#" + tmp);
				_returnkey(obj_tmp, $(this).text());
				$(this).blur();
			});
			$("#numkeybord #back").bind('click.back', function() {
				var tmp = $("#numkeybord").attr("target");
				var obj_tmp = $("#" + tmp);
				_back(obj_tmp);
			});
			$("#numkeybord #clear").bind('click', function() {
				var tmp = $("#numkeybord").attr("target");
				var obj_tmp = $("#" + tmp);
				_clear(obj_tmp);
			});
			if (_option == null)
				return;
			else {
				if (_option.enter == false)
					$("#enter").unbind('click.hide').css({
						color : "#fff"
					});
				if (_option.esc == false)
					$("#esc").unbind('click.hide').css({
						color : "#fff"
					});
				if (_option.back == false)
					$("#back").unbind('click.back').css({
						color : "#fff"
					});
			}
		}
		// 键盘与元素绑定及显示
		function _show(_input) {
			try{
				$(_input).attr('readonly', 'readonly');
				var _offset = $(_input).offset();
				var _left = _offset.left;
				var _top = _offset.top + $(_input).height() + (msie ? 5 : 6);
				$("#numkeybord").attr("target", _input.id).css({
					left : _left + "px",
					top : _top + "px",
					display : 'block'
				});
				$('#esc').click(function() {
					$(_input).focus();
					$(_input).removeAttr('readonly');
					$('#numkeybord').css('display', 'none');
				})
			} catch(e){alert(e)}
		}
		// 输入操作
		function _returnkey(_input, _val) {
			if ($(_input).val().length >= $(_input).attr("maxlength"))
				return;
			var tmpval = $(_input).val() + _val;
			$(_input).val(tmpval);
			_focus(_input);
		}
		// 光标返回
		function _focus(_input) {
			if (msie) {
				var rng = $(_input)[0].createTextRange();
				rng.collapse(false);
				rng.select();

			} else {
				// $(_input).focus();
			}
		}
		// 退格操作
		function _back(_input) {
			var _len = $(_input).val().length;
			var _tmp = $(_input).val();
			$(_input).val(_tmp.substr(0, _len - 1));
			_focus(_input);
		}
		// 键盘关闭
		function _hide(_input) {
			var tmp = $("#numkeybord").attr("target");
			var obj_tmp = $("#" + tmp);
			$("#numkeybord").css({
				display : 'none'
			});
			// $(obj_tmp).focus();
			_focus(obj_tmp);
		}
		// 输入操作
		function _clear(_input) {
			$(_input).val('');
		}
	})(jQuery);