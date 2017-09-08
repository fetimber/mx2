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

	margin-top:4px;
	margin-left:40px;
	overflow: hidden;
	margin-bottom:5px;
	position:relative;
}
		.acc_img1 {
	  margin-top:24px;
	  width:360px;
	  height:400px;
      }
    </style>

	</head>
	<body style="background: #f0f0f0;">
	<s:form action="wechat!save_check" namespace="/weixin" method="post" id="base_frm">
	<div style="padding:16px;">
		<div class="caption caption_tpc">
				<img src="resources/images/caption_arrow.png" width="14" height="14" class="caption_arrow" />
				检查宿舍   房间号 <s:property value="checkInfo.checkRoomId" />    得分<s:property value="checkInfo.checkResult" />分  
<!-- 			<span class="tips_txt1">您今日还有<s:property value='#request.myCount'/>位购房者可推荐</span> -->
		</div>
		<div id="cusList">
			<div class="cusInfo">
				<ul class="tj_strange part_st" style="padding-bottom:20px;">
					<li class="input_g">
						<img src="resources/images/icon1.png" class="input_icon"/>
						<div class="input_a">
							<div class="tips_gray">
								<font color="#333">宿舍内务卫生检查</font>
							</div>
					    </div>
					    <div class="input_ab">
					      <s:property value="checkInfo.checkMetope01" />分
					    </div>
						<div class="clear"></div>
					</li>


                    <li class="input_g">
						<img src="resources/images/icon1.png" class="input_icon"/>
						<div class="input_a">
							<div class="tips_gray">
								<font color="#333">卫生间卫生检查</font>
							</div>
					    </div>
					    <div class="input_ab">
					      <s:property value="checkInfo.checkMetope02" />分
					    </div>
						<div class="clear"></div>
					</li>
	
					<li class="input_g">
						<img src="resources/images/icon1.png" class="input_icon"/>
						<div class="input_a">
							<div class="tips_gray">
								<font color="#333">宿舍违规行为规范检查</font>
							</div>
					    </div>
					    <div class="input_ab">
					      <s:property value="checkInfo.checkGround01" />分
					    </div>
						<div class="clear"></div>
					</li>
					
					
					
					<li class="input_g">
						<img src="resources/images/icon1.png" class="input_icon"/>
						<div class="input_a">
							<div class="tips_gray">
								<font color="#333">宿舍物品摆放规范检查</font>
							</div>
					    </div>
					    <div class="input_ab">
					      <s:property value="checkInfo.checkGround02" />分
					    </div>
						<div class="clear"></div>
					</li>
								
					<li class="input_g">
						<img src="resources/images/icon1.png" class="input_icon"/>
						<div class="input_a">
							<div class="tips_gray">
								<font color="#333">其他</font>
							</div>
					    </div>
					    <div class="input_ab">
					      <s:property value="checkInfo.checkGround03" />分
					    </div>
						<div class="clear"></div>
					</li>			
							
					
					
					
					<li class="input_g">
						<img src="resources/images/icon10.png" class="input_icon"/>
						<div class="input_a">
							<div class="tips_gray">
								<font color="#333">图片1</font>
							</div>
					    </div>
					  	<div id='small_imgs' style="margin-left:40px;">
					  	  <s:if test="checkInfo.checkPic01 != null && checkInfo.checkPic01 != ''">
					       <img src="<s:property value="checkInfo.checkPic01" />" class="acc_img1" />
					      </s:if>
					   </div>
						<div class="clear"></div>
					</li>
					
					<li class="input_g">
						<img src="resources/images/icon10.png" class="input_icon"/>
						<div class="input_a">
							<div class="tips_gray">
								<font color="#333">图片2</font>
							</div>
					    </div>
					    <div id='big_imgs' style="margin-left:40px;">
					      <s:if test="checkInfo.checkPic02 != null && checkInfo.checkPic02 != ''">
					        <img src="<s:property value="checkInfo.checkPic02" />" class="acc_img1" />
					      </s:if>
					   </div>
					    
						<div class="clear"></div>
					</li>
					
					<li class="input_g">
						<img src="resources/images/icon10.png" class="input_icon"/>
						<div class="input_a">
							<div class="tips_gray">
								<font color="#333">图片3</font>
							</div>
					    </div>
					     <div id='price_imgs' style="margin-left:40px;" class='imgshow'>
					     <s:if test="checkInfo.checkPic03 != null && checkInfo.checkPic03 != ''">
					        <img src="<s:property value="checkInfo.checkPic03" />" class="acc_img1" />
					      </s:if>     
					   </div>
					    
						<div class="clear"></div>
					</li>
					
					
									<li class="input_g">
						<img src="resources/images/icon10.png" class="input_icon"/>
						<div class="input_a">
							<div class="tips_gray">
								<font color="#333">图片4</font>
							</div>
					    </div>
					    <div id='big_imgs' style="margin-left:40px;">
					      <s:if test="checkInfo.checkPic04 != null && checkInfo.checkPic04 != ''">
					        <img src="<s:property value="checkInfo.checkPic04" />" class="acc_img1" />
					      </s:if>
					   </div>
					    
						<div class="clear"></div>
					</li>
					
									<li class="input_g">
						<img src="resources/images/icon10.png" class="input_icon"/>
						<div class="input_a">
							<div class="tips_gray">
								<font color="#333">图片5</font>
							</div>
					    </div>
					    <div id='big_imgs' style="margin-left:40px;">
					      <s:if test="checkInfo.checkPic05 != null && checkInfo.checkPic05 != ''">
					        <img src="<s:property value="checkInfo.checkPic05" />" class="acc_img1" />
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
					    <s:textarea name="checkInfo.checkRemark" rows="3"  cssClass="textarea1 cusRemark"> 
					    
					     </s:textarea>
						
						<div class="clear"></div>
					</li>
                    <div class="clear"></div>
				</ul>
			</div>
		</div>

		<input type="hidden" name="checkInfo.checkRoomId" value="<s:property value="#request.roomcode"/>" />
		<input type="hidden" name="buildingNo" value="<s:property value="#request.buildno"/>" />
      </div>
<!-- 		<script type="text/javascript"> -->
<!-- 		    App.areas = document.getElementById("firstArea").innerHTML; -->
<!-- 		</script> -->
		</s:form>

	</body>
	
</html>