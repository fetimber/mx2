$(function(){
	$(".auto_tips").each(function(){
		if($(this).attr("type") == "text"){
			if($(this).val() == '' || $(this).val() == $(this).attr("alt")){
				var alt = $(this).attr('alt');
				$(this).val(alt).css('color','#AAA').css("font-family","'Courier New','\u5fae\u8f6f\u96c5\u9ed1'");
			}
		} else if ($(this).attr("type") == "password") {
			var that = $(this);
			var html = that.prop("outerHTML").replace("password","text");
			
			var element = $(html).attr("id",that.attr("id") + "_text").attr("name",that.attr("name")+ "_text");
			element.val(element.attr('alt')).css('color','#AAA').css("font-family","'Courier New','\u5fae\u8f6f\u96c5\u9ed1'");
			element.appendTo(that.parent());
			that.hide();
			element.unbind("focus").bind("focus",function(){
				$(this).hide();
				that.show().focus().val('').blur(function(){
					if($(this).val() == $(this).attr("alt")){
						$(this).hide();
						element.show();
					}
				});
			});
		}
	}).each(function(){
		$(this).bind("focus",function(){
			if($(this).val() == $(this).attr('alt')){
				$(this).val('').css('color','#333');
			}
		}).bind("blur",function(){
			if($(this).val() == ''){
				$(this).val($(this).attr('alt')).css('color','#AAA').css("font-family","'Courier New','\u5fae\u8f6f\u96c5\u9ed1'");
			}
		}).trigger("blur");
	});
	$("form").each(function(){
		$(this).bind("submit",function(){
			$(this).find("input:text").each(function(){
				if($(this).hasClass('auto_tips') && $(this).val() == $(this).attr('alt')){
					$(this).val('');
				}
			});
		});
	});
	$("a[href='#']").each(function(){
		$(this).attr("href","javascript:void(0)");
	});
});


function showSearch(){
    if(!flag){
      $('#search').slideDown();
      flag = true;
    }else{
      $('#search').slideUp();
      flag = false;
    }		
}	
