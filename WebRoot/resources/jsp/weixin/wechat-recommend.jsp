<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<s:include value="../common/meta.jsp" />
		<script type="text/javascript" src="resources/js/ajaxfileupload.js"></script>
		<title>检查宿舍</title>
		<meta charset="utf-8">
		<meta content="" name="description">
		<meta content="" name="keywords">
		<meta content="application/xhtml+xml;charset=UTF-8" http-equiv="Content-Type">
		<meta content="telephone=no, address=no" name="format-detection">
		<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
		<link href="resources/weixin/css/style.css?v=044" rel="stylesheet" />
		<script src="resources/weixin/lib_cmd/sea.js"></script>
		<script>
        var  App ={
               remUrl : "weixin/wechat!save_check",//检查
               sucUrl :  "",//登录成功后跳转url
               houseUrl : "weixin/wechat!housesList",//获取楼盘列表url
               limit : "<s:property value='#request.myCount'/>" || 10,//今日推荐客户限制
               areas :"<s:property value='#request.areas'/>" || "[]"
        }
        </script>
		<script>

        (function(l){
            seajs.config({
                base:"<%=basePath%>/resources/weixin",
                map:[
                    [".js", (l&&l[1]||"")+".js?v=044"]
                ]
            });
            //
            seajs.use("<%=basePath%>resources/weixin/js_cmd/recommend.js?v=044");
        })(location.href.match(/de(\-\d+)bug/));
    </script>
    <style type="text/css">
		     .btn_upload{
			background:#e06767;
			width:100px;
			height:30px;
			color:#fff;
			border:0px;
			cursor:pointer;
			-moz-border-radius: 4px;
			-webkit-border-radius: 4px;
			border-radius:4px;
			text-align:center;
			-webkit-appearance:none;
		}
		.btn_upload:hover{
			background:#e70012;
		}
		.input_a input{
		   color:#fff;
		}
		
		.upload_imgs{
	display:block;
	float:left;
	border:1px solid #e0e0e0;
	padding:1px;
	width:125px;
	height:125px;
	margin-top:4px;
	margin-left:40px;
	overflow: hidden;
	position:relative;
}
.upload_imgs_1{
	display:block;
	float:left;
	border:1px solid #e0e0e0;
	padding:1px;
	width:125px;
	height:125px;
	margin-top:4px;
	margin-left:40px;
	overflow: hidden;
	margin-bottom:5px;
	position:relative;
}
.upload_imgs_2{
	display:block;
	float:left;
	border:1px solid #e0e0e0;
	padding:1px;
	width:125px;
	height:125px;
	margin-top:4px;
	margin-left:40px;
	overflow: hidden;
	margin-bottom:5px;
	position:relative;
}
.upload_imgs_3{
	display:block;
	float:left;
	border:1px solid #e0e0e0;
	padding:1px;
	width:125px;
	height:125px;
	margin-top:4px;
	margin-left:40px;
	overflow: hidden;
	margin-bottom:5px;
	position:relative;
}
	
.upload_imgs_4{
	display:block;
	float:left;
	border:1px solid #e0e0e0;
	padding:1px;
	width:125px;
	height:125px;
	margin-top:4px;
	margin-left:40px;
	overflow: hidden;
	margin-bottom:5px;
	position:relative;
}
	
		
    </style>

	</head>
	<body style="background: #f0f0f0;">
	<s:form action="wechat!save_check" namespace="/weixin" method="post" id="base_frm">
	<div style="padding:16px;">
		<div class="caption caption_tpc">
				<img src="resources/images/caption_arrow.png" width="14" height="14" class="caption_arrow" />
				检查宿舍
<!-- 			<span class="tips_txt1">您今日还有<s:property value='#request.myCount'/>位购房者可推荐</span> -->
		</div>
		<div id="cusList">
			<div class="cusInfo">
				<ul class="tj_strange part_st" style="padding-bottom:20px;">

					<li class="input_g bor_tb">	   
						<img src="resources/images/icon1.png"  class="input_icon_aa"/>
						<div style="position:relative">
							<div class="input_ab">
							   <s:textfield name="checkInfo.checkMetope01" id="check1" cssClass="input_aa" placeholder="宿舍内务卫生检查"></s:textfield>&nbsp;&nbsp;
							</div>
							
						</div>
					</li>
					
				    <li class="input_g bor_tb">	   
						<img src="resources/images/icon1.png"  class="input_icon_aa"/>
						<div style="position:relative">
							<div class="input_ab">
							   <s:textfield name="checkInfo.checkMetope02" id="check2" cssClass="input_aa" placeholder="卫生间卫生检查"></s:textfield>&nbsp;&nbsp;
							</div>
							
						</div>
					</li>
					
					
				    <li class="input_g bor_tb">	   
						<img src="resources/images/icon1.png"  class="input_icon_aa"/>
						<div style="position:relative">
							<div class="input_ab">
							   <s:textfield name="checkInfo.checkGround01"  id="check3" cssClass="input_aa" placeholder="宿舍违规行为规范检查"></s:textfield>&nbsp;&nbsp;
							</div>
							
						</div>
					</li>
					
					<li class="input_g bor_tb">	   
						<img src="resources/images/icon1.png"  class="input_icon_aa"/>
						<div style="position:relative">
							<div class="input_ab">
							   <s:textfield name="checkInfo.checkGround02"  id="check4" cssClass="input_aa" placeholder="宿舍物品摆放规范检查"></s:textfield>&nbsp;&nbsp;
							</div>
							
						</div>
					</li>
					
					<li class="input_g bor_tb">	   
						<img src="resources/images/icon1.png"  class="input_icon_aa"/>
						<div style="position:relative">
							<div class="input_ab">
							   <s:textfield name="checkInfo.checkGround03"  id="check5" cssClass="input_aa" placeholder="其他"></s:textfield>&nbsp;&nbsp;
							</div>
							
						</div>
					</li>
					
					<li class="input_g">
						<img src="resources/images/icon10.png" class="input_icon"/>
						<div class="input_a">
							<div class="tips_gray">
								<font color="#333">图片1</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id='btn_upload0' value="上传图片1" class="btn_upload" color="#FFF" />
							</div>
					    </div>
					  	<div id='small_imgs'>
					     <s:if test="null == checkInfo">
							<span class="upload_imgs"></span>
						 </s:if>		   
					   </div>
						<div class="clear"></div>
					</li>
					
					<li class="input_g">
						<img src="resources/images/icon10.png" class="input_icon"/>
						<div class="input_a">
							<div class="tips_gray">
								<font color="#333">图片2</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id='btn_upload1' value="上传图片2" class="btn_upload" color="#FFF" />
							</div>
					    </div>
					   	<div id='big_imgs'>
					     <s:if test="null == checkInfo">
							<span class="upload_imgs_1"></span>
						 </s:if>		   
					   </div>
						<div class="clear"></div>
					</li>
					
					<li class="input_g">
						<img src="resources/images/icon10.png" class="input_icon"/>
						<div class="input_a">
							<div class="tips_gray">
								<font color="#333">图片3</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"  id='btn_upload2'  value="上传图片3" class="btn_upload" color="#FFF" />
							</div>
					    </div>
					   <div id='price_imgs'>
					     <s:if test="null == checkInfo">
							<span class="upload_imgs_2"></span>
						 </s:if>		   
					   </div>
						<div class="clear"></div>
					</li>
					
					
					<li class="input_g">
						<img src="resources/images/icon10.png" class="input_icon"/>
						<div class="input_a">
							<div class="tips_gray">
								<font color="#333">图片4</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"  id='btn_upload3'  value="上传图片4" class="btn_upload" color="#FFF" />
							</div>
					    </div>
					   <div id='price_imgs1'>
					     <s:if test="null == checkInfo">
							<span class="upload_imgs_3"></span>
						 </s:if>		   
					   </div>
						<div class="clear"></div>
					</li>
					
					
										<li class="input_g">
						<img src="resources/images/icon10.png" class="input_icon"/>
						<div class="input_a">
							<div class="tips_gray">
								<font color="#333">图片5</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"  id='btn_upload4'  value="上传图片5" class="btn_upload" color="#FFF" />
							</div>
					    </div>
					   <div id='price_imgs2'>
					     <s:if test="null == checkInfo">
							<span class="upload_imgs_4"></span>
						 </s:if>		   
					   </div>
						<div class="clear"></div>
					</li>
					
					
					<li class="input_g">
						<img src="resources/images/icon10.png" class="input_icon"/>
						<div class="input_a">
							<div class="tips_gray">
								<font color="#333">备注信息</font>
							</div>
					    </div>
					    <s:textarea name="checkInfo.checkRemark" rows="3"  cssClass="textarea1 cusRemark"  placeholder="  请填写需要留住的信息">  </s:textarea>
						
						<div class="clear"></div>
					</li>
                    <div class="clear"></div>
				</ul>
			</div>
		</div>

		<div class="" style="margin-top:8px;">
			<input type="button" class="btn_zc" value="确认检查" />
		</div>
		<input type="hidden" name="checkInfo.checkPic01" id="checkPic01" />
		<input type="hidden" name="checkInfo.checkPic02" id="checkPic02"/>
		<input type="hidden" name="checkInfo.checkPic03" id="checkPic03"/>
		<input type="hidden" name="checkInfo.checkPic04" id="checkPic04"/>
		<input type="hidden" name="checkInfo.checkPic05" id="checkPic05"/>
		
		<input type="hidden" name="checkInfo.checkResult" id="checkResult"/>
		
		<input type="hidden" name="checkInfo.checkRoomId" value="<s:property value="#request.roomcode"/>" />
		<input type="hidden" name="buildingNo" value="<s:property value="#request.buildno"/>" />
      </div>
<!-- 		<script type="text/javascript"> -->
<!-- 		    App.areas = document.getElementById("firstArea").innerHTML; -->
<!-- 		</script> -->
		</s:form>
	    <div style="width:1px;height:1px;filter:alpha(opacity=0);-moz-opacity:0;-khtml-opacity:0;opacity:0;">
			<s:file id="upload_btn_0" name="upload" />
			<s:file id="upload_btn_1" name="upload" />
			<s:file id="upload_btn_2" name="upload" />
			<s:file id="upload_btn_3" name="upload" />
			<s:file id="upload_btn_4" name="upload" />
		</div>
	</body>
	
</html>