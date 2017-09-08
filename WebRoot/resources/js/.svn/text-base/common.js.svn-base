function _delete_confirm(content, yes, no, parent){
	lhgdialog({
		title: '确认',
		id: '_delete_confirm',
		icon: 'alert.gif',
		fixed: true,
		content: content,
		resize: false,
		width:'170px',
		parent: parent || null,
		ok: function(here){
			return yes.call(this, here);
		},
		cancel: function(here){
			return no && no.call(this, here);
		}
	});
}
function affiliation(phone){
	$.ajax({
		url : "http://virtual.paipai.com/extinfo/GetMobileProductInfo",
		data:{"mobile":phone,"amount":10000,"callname":"PhoneNumInfoExtCallback"},
		dataType:"jsonp"
	});
}
function PhoneNumInfoExtCallback(affil){
	try{
		$("._" + affil.mobile).each(function(){
			$(this).text(affil.province + " " + affil.cityname).attr("javascript:void(0)")
		});
	} catch(e){alert(e)}
}

function AutoResizeImage(maxWidth,maxHeight,objImg)
{
	 var img = new Image();
	 img.src = objImg.src;
	 var hRatio;
	 var wRatio;
	 var Ratio = 1;
	 var w = img.width;
	 var h = img.height;
	 if(w == 0){
		 w = objImg.width;
		 h = objImg.height;
	 }
	 wRatio = maxWidth / w;
	 hRatio = maxHeight / h;
	 if (maxWidth ==0 && maxHeight==0){
	 Ratio = 1;
	 }else if (maxWidth==0){//
	 if (hRatio<1) Ratio = hRatio;
	 }else if (maxHeight==0){
	 if (wRatio<1) Ratio = wRatio;
	 }else if (wRatio<1 || hRatio<1){
	 Ratio = (wRatio<=hRatio?wRatio:hRatio);
	 }
	 if (Ratio<1){
	 w = w * Ratio;
	 h = h * Ratio;
	 }
	 $(objImg).height(h);
	 $(objImg).width(w);
}

function showAllPic(url,title){
    $.dialog({
		content: "<p><img src='" + url +"' onload='AutoResizeImage(800,600,this)' /></p>",
		max: true,
		min: false,
		background: '#000', /* 背景色 */
	    opacity: 0.5,       /* 透明度 */
		cancel: true,
		position: "center",
		titleIcon: 'lhgcore.gif',
		padding: 0,
		title: title,
		drag: false,
		resize: false,
		fixed: true,
		ok:false,
		parent: this
	});
}
$(function(){
	$("#a_wechat").hover(function(){
		$(".weixin_img").show();
	},function(){
		$(".weixin_img").hide();
	});
});