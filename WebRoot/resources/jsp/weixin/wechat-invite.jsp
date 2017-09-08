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
    <title>被邀请人信息</title>
	<meta charset="utf-8">
    <meta content="" name="description">
    <meta content="" name="keywords">
    <meta content="application/xhtml+xml;charset=UTF-8" http-equiv="Content-Type">
    <meta content="telephone=no, address=no" name="format-detection">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
	<link href="resources/weixin/css/style.css?v=044" rel="stylesheet" />
	<script src="resources/weixin/lib_cmd/sea.js"></script>
    <script>
        var  APP ={
        	   inviteUrl : "weixin/wechat!inviting",     //下线邀请Url
        	   agentUrl : "weixin/wechat!queryAgentUser",
               sucUrl :  "",                             //登录成功后跳转url
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
            seajs.use("<%=basePath%>resources/weixin/js_cmd/invite.js?v=044");
        })(location.href.match(/de(\-\d+)bug/));

     
    </script>
    
	
  </head>
	<body style="background: #f0f0f0;" class="bg_p">
		<div style="padding: 16px;">
			<div class="caption caption_tpc" style="margin-top: 8px;">
				<img src="resources/images/caption_arrow.png" width="14" height="14"
					class="caption_arrow " />
				被邀请人信息
			</div>
			<ul class="tj_strange">
<%--				<li class="input_g">--%>
<%--					<img src="resources/images/icon1.png" class="input_icon" />--%>
<%--					<div style="position:relative">--%>
<%--					     <div class="input_ab">--%>
<%--					          <input id="nickName" type="text" class="input_aa" placeholder="经济人昵称" />--%>
<%--					     </div>--%>
<%--					</div>--%>
<%--				</li>--%>
				<li class="input_g">
					<img src="resources/images/icon2.png" alt="" class="input_icon" />
					  <div style="position:relative">
					     <div class="input_ab">
					      <input id="phone" type="text" class="input_aa" placeholder="经济人电话" />
					  </div>
					</div>
				</li>
				<li class="input_g" style="padding-bottom: 20px;">
					<img src="resources/images/icon10.png" alt="" class="input_icon" />
					<div class="input_a">
						<div class="tips_gray">
							<font color="#666">邀请备注</font>
						</div>
					</div>
					<textarea id="memo" rows="3" class="textarea1" placeholder="请尽可能表明您的身份，以便对方能够及时了解"> </textarea>
					<div class="clear"></div>
				</li>
				<div class="clear"></div>
			</ul>
			<div class="btn_w">
				<input type="button" class="btn_zc btn_zc_m" value="发出邀请" id="sub1"/>
				<input type="hidden" value="<s:property value="#request.storeId"/>" id="storeId">
			</div>
			
		</div>
	</body>
</html>
