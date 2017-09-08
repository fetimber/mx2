define(function(require, exporets, module){
	var $z = require("lib_cmd/zepto.js"),
	    myDialog = require("lib_cmd/alert.js"),
	    isLoading = false;
	    cusCount = 1;

		// 客户信息静态HTML
	    // 客户信息静态HTML
		var template = '\
		    <div class="part_2 cusInfo">\
		    	<ul>\
		    	    <li class="input_g" style="padding:0 8px;margin:8px 0;">\
    			       <img src="resources/images/icon7.png" class="input_icon"/>\
    				   <select  class="sel1 area" style="-webkit-appearance:textfield;">\
    				     '+App.areas+'\
    				   </select>\
    		        </li>\
    		        <li class="input_g" style="padding:0 8px;margin-bottom:8px;">\
			          <img src="resources/images/icon12.png" class="input_icon" />\
				       <select class="sel1 cusProject">\
					   <option value="">\
						  请选择楼盘\
					  </option>\
				       </select>\
		            </li>\
		            <li>\
					  <div class="sel2 cusMor">\
						   <span>\
						      <input class="refer_area" type="checkbox" value=""/>同时推荐到该区域\
						   </span>\
						   <span>\
						      <input class="self_send" type="checkbox" value="" />亲自邀约\
						   </span>\
						   <span>\
						      <input class="self_look" type="checkbox" value="" />亲自带看\
						   </span>\
					  </div>\
				    </li>\
		    		<li class="input_g">\
		    			<img src="resources/images/icon1.png" class="input_icon"/>\
		    			<span style="position:relative">\
		    				<input type="text" class="input1 cusName" placeholder="客户姓名" style="border-bottom:0;"/>\
		    				<span class="must">*</span>\
		    			</span>\
		    		</li>\
		    		<li class="input_g">\
		    			<img src="resources/images/icon2.png" class="input_icon"/>\
		    			<span style="position:relative">\
		    				<input  type="text" class="input1 cusPhone" placeholder="手机号码" />\
		    				<span class="must">*</span>\
		    			</span>\
		    		</li>\
		    		<li class="input_g">\
		    			<img src="resources/images/icon10.png" class="input_icon"/>\
		    			<div class="input_a">\
		    				<div class="tips_gray">\
		    				    <font color="#666">备注信息</font>（请尽量详细填写客户信息，以便我们提供更有效服务）\
		    				</div>\
		    			</div>\
		    			<textarea rows="3" class="textarea1 cusRemark"></textarea>\
		    			<div class="clear"></div>\
		    		</li>\
		    		<div class="clear"></div>\
		    	</ul>\
		    </div>\
		    ';
	//自定义事件绑定	
    window.myEvent = function(){

				$z("#btn_upload0").click(function(){
					$z("#upload_btn_0").trigger("click");
				})
				
				$z("#btn_upload1").click(function(){
					$z("#upload_btn_1").trigger("click");
				})
				
				$z("#btn_upload2").click(function(){
					$z("#upload_btn_2").trigger("click");
				})
				
				$z("#btn_upload3").click(function(){
					$z("#upload_btn_3").trigger("click");
				})
				
				$z("#btn_upload4").click(function(){
					$z("#upload_btn_4").trigger("click");
				})
				
				_init_upload(0);
				_init_upload(1);
				_init_upload(2);
				_init_upload(3);
				_init_upload(4);
				auto_size();
				_init_form();
				

	}
    
					
	
	
	$z(".btn_tjgd").click(function(){
		if(cusCount<App.limit){
		   $z("#cusList").append(template);
		   myEvent();
		   cusCount++;
		}
	});
	
	$z(".btn_zc").click(function(){
		var flag = true;
		var total = 0;
		var i = 0;
		
		if($z("#check1").val() == "" || $z("#check1").val() == null){
			 $.alert({txt: '宿舍内务卫生检查未填写'});
			return;
		}
		
		if($z("#check2").val() == "" || $z("#check2").val() == null){
			 $.alert({txt: '宿舍内务卫生检查未填写'});
			return;
		}
		
		if($z("#check3").val() == "" || $z("#check3").val() == null){
			 $.alert({txt: '宿舍内务卫生检查未填写'});
			return;
		}
		
		if($z("#check4").val() == "" || $z("#check4").val() == null){
			 $.alert({txt: '宿舍内务卫生检查未填写'});
			return;
		}
		
		if($z("#check5").val() == "" || $z("#check5").val() == null){
			 $.alert({txt: '宿舍内务卫生检查未填写'});
			return;
		}
	
		
		//$.alert({txt: '您今日已不能再推荐客户!'});
		 $z(".input_g").each(function(){
			 var $this = $z(this);
			 var custInfo = {};
             i++;

			 if(i <= 5){
				 custInfo.scoer = parseInt($this.find(".input_aa").val());
				 custInfo.title = $this.find(".input_aa").attr("placeholder");

				 if( custInfo.scoer >2 || custInfo.scoer < 0){
					 $.alert({txt: custInfo.title + ' 填写的分值不正确'});
					 flag = false;
					 return;
				 }else{
				
					 total =  parseInt(total) + parseInt(custInfo.scoer);	 
				 }	 
			 }
		 });
		 
		 if(flag){
		
			$z("#checkResult").val(total);
			window.document.forms[0].submit();
		 }
	
	});
	 
	 (function(){
		 myEvent();
		 
	 })();
});

var big_pictures = new Array();
var small_pictures = new Array();
var price_pictures = new Array();
var price_pictures1 =  new Array();
var price_pictures2 =  new Array();

function auto_size() {
	$("#price_imgs img").each(function() {
		AutoResizeImage(360, 400, this);
	});
	$("#big_imgs img").each(function() {
		AutoResizeImage(360, 400, this);
	});
	$("#small_imgs img").each(function() {
		AutoResizeImage(360, 400, this);
	});
	$("#price_imgs1 img").each(function() {
		AutoResizeImage(360, 400, this);
	});
	$("#price_imgs2 img").each(function() {
		AutoResizeImage(360, 400, this);
	});
	
}

function _init_form(){
	$('#base_frm').validationEngine({
		addPromptClass: 'formError-white formError-small',
		promptPosition: 'centerRight: 10, +1',
		maxErrorsPerField: true,
		autoHideDelay: 3000
	});
	
	
}

function _init_upload(idx){	
	$("#upload_btn_" + idx).change(function(){
		var dialog = $.dialog({
		    icon: 'loading.gif',
		    titleIcon: 'lhgcore.gif',
		    content: '正在上传图片，请稍候....'
		});
		$.ajaxFileUpload({
			url: 'weixin/upload',
			//用于文件上传的服务器端请求地址
			secureuri: false,
			//是否需要安全协议，一般设置为false
			data: {
				createMedia: false,
				saveFile:true,
				fileType:idx == 0 ? 9 : (idx == 1 ? 10 : 11)
			},
			fileElementId: 'upload_btn_' + idx,
			//文件上传域的ID
			dataType: 'json',
			//返回值类型 一般设置为json
			success: function(data) { //服务器成功响应处理函数
				dialog.close();
				if (data.result) {
					var pic = {"id":data.id,"path":data.upload_path,"width":data.width,"height":data.height};
					if(idx == 0){
						small_pictures.push(pic);
						 $('#checkPic01').val(data.upload_path);
					} else if(idx == 1){
						big_pictures.push(pic);
						 $('#checkPic02').val(data.upload_path);
					} else if(idx == 2){
						price_pictures.push(pic);
						 $('#checkPic03').val(data.upload_path);
					} else if(idx == 3){
						price_pictures1.push(pic);
						 $('#checkPic04').val(data.upload_path);
					} else if(idx == 4){
						price_pictures2.push(pic);
						 $('#checkPic05').val(data.upload_path);
					}
					rebuild_pict(pic,idx);
				} else {
					$.dialog.tips("文件上传失败，请稍候再试....", 2, "error.gif");
				}
				$("#upload_btn_" + idx).replaceWith("<input type='file' name='upload' value='' title='" + Math.random() + "' id='upload_btn_" + idx + "'/>");
				_init_upload(idx);
			},
			error: function(data, status, e) { //服务器响应失败处理函数
				dialog.close();
				$.dialog.tips("文件上传失败，请稍候再试....", 2, "error.gif");
			}
		});
	});
}


function rebuild_pict(pic,idx){
	var span = $("<span>").attr("pic_id",pic.id);
	if(idx == 1){
		if(big_pictures.length == 1){
			$(".upload_imgs_1").remove();
		}
		span.addClass("upload_imgs_1 bigpic");
	} else if(idx == 0) {
		if(small_pictures.length == 1){
			$(".upload_imgs").remove();
		}
		span.addClass("upload_imgs smallpic");
	} else if(idx == 2) {
		if(price_pictures.length == 1){
			$(".upload_imgs_2").remove();
		}
		span.addClass("upload_imgs_2 pricepic");
	}else if(idx == 3) {
		if(price_pictures1.length == 1){
			$(".upload_imgs_3").remove();
		}
		span.addClass("upload_imgs_3 pricepic1");
	}else if(idx == 4) {
		if(price_pictures2.length == 1){
			$(".upload_imgs_4").remove();
		}
		span.addClass("upload_imgs_4 pricepic2");
	}
	var img = $("<img>").attr("pic_id",pic.id).attr("src",pic.path).width(pic.width).height(pic.height).bind("load",function(){
		if(idx == 0){
			AutoResizeImage(360, 400, this);
		} else if(idx == 1){
			AutoResizeImage(360, 400, this);
		} else if(idx == 2){
			AutoResizeImage(360, 400, this);
		} else if(idx == 3){
			AutoResizeImage(360, 400, this);
		} else if(idx == 4){
			AutoResizeImage(360, 400, this);
		} else if(idx == 5){
			AutoResizeImage(360, 400, this);
		}
	});
	var close = $("<a>").addClass("img_close").attr("href","javascript:delete_img(" + idx + "," + pic.id + ")");
	span.append(img).append(close);
	if(idx == 0){
		span.appendTo("#small_imgs");
	} else if(idx == 1){
		span.appendTo("#big_imgs");
	} else if(idx == 2){
		span.appendTo("#price_imgs");
	}else if(idx == 3){
		span.appendTo("#price_imgs1");
	}else if(idx == 4){
		span.appendTo("#price_imgs2");
	}
}
function delete_img(idx,pic_id){
	var div = "";
	if(idx == 0){
		div = ".smallpic";
	} else if(idx == 1){
		div = ".bigpic";
	} else if(idx == 2){
		div = ".pricepic";
	}
	$(div + "[pic_id=" + pic_id + "]").remove();
	var index = -1;
	var list = null;
	if(idx == 0){
		list = small_pictures;
	} else if(idx == 1){
		list = big_pictures;
	} else if(idx == 2){
		list = price_pictures;
	}
	for(var i = 0; i < list.length; i++){
		if(list[i].id == pic_id){
			index = i
			break;
		}
	}
	
	if(index > -1){
		if(idx == 0){
			small_pictures.splice(index,1);;
		} else if(idx == 1){
			big_pictures.splice(index,1);;
		} else if(idx == 2){
			price_pictures.splice(index,1);;
		}
	}
	
	if(idx == 0){
		if(small_pictures.length == 0){
			$("<span>").addClass("upload_imgs").appendTo("#small_imgs");
		}
	} else if(idx == 1){
		if(big_pictures.length == 0){
			$("<span>").addClass("upload_imgs_1").appendTo("#big_imgs");
		}
	} else if(idx == 2){
		if(price_pictures.length == 0){
			$("<span>").addClass("upload_imgs_2").appendTo("#price_imgs");
		}
	}
}
