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
    <title>个人中心</title>
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
        	   registUrl : "weixin/wechat!speRegist",     //专业经纪人注册url
        	   agentUrl : "weixin/wechat!queryAgentUser",
               sucUrl :  "",                              //登录成功后跳转url
               exitUrl: "weixin/wechat!exitStore",        //退出下线
               concelUrl: "weixin/wechat!concelStore"       //取消下线邀请url
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
            seajs.use("<%=basePath%>resources/weixin/js_cmd/person.js?v=044");
        })(location.href.match(/de(\-\d+)bug/));

     
    </script>
    
	
  </head>
	<body style="background:#f0f0f0;">
	<div style="padding-top:20px;">
	   
	   <s:if test="null != #request.invited"> 
	       <div class="caption" style="margin-bottom: 10px;">
	        <p>
	           <span style="float:left;color:#FF0000;font-size: 16px;">!您收到成为<a style="color:#FF0000;text-decoration:underline;" href="weixin/wechat!invitedInfo">下线邀请</a></span>
	           <a style="float:right;color:#FF0000;margin-right:8px;font-size: 16px;text-decoration:underline;" href="weixin/wechat!invitedInfo">查看</a>
	           <div class="clear"></div>
	        </p>
	    </div>
	   </s:if>
	   
	   <s:if test="null != #request.inviting && #request.inviting.size() > 0 "> 
	          <div class="caption" style="margin-bottom: 10px;">
	        <p>
	           <span style="float:left;color:#FF0000;font-size: 16px;">您的邀请暂时未被处理</span>
	           <a style="float:right;color:#FF0000;margin-right:8px;font-size: 16px;text-decoration:underline;" href="weixin/wechat!invite">继续邀请下线</a>
	           <div class="clear"></div>
	        </p>
	        <p>
	           <span style="float:left;font-size: 16px;"><a style="text-decoration:underline;color:#FF0000;" href="weixin/wechat!offlinePage">进入下线管理</a></span>
	           <a style="float:right;color:#FF0000;margin-right:8px;font-size: 16px;text-decoration:underline;" href="javascript:;" class="concelAll">取消所有邀请</a>
	           <div class="clear"></div>
	        </p>
	    </div>
	   </s:if>
	   
	   <s:if test="null == #request.inviting || #request.inviting.size() == 0 "> 
	     <div class="caption" style="margin-bottom: 10px;">
	        <p>
	           <span style="float:left;font-size: 16px;"><a style="text-decoration:underline;color:#FF0000;" href="weixin/wechat!offlinePage">进入下线管理</a></span>
	           <a style="float:right;color:#FF0000;margin-right:8px;font-size: 16px;text-decoration:underline;" href="weixin/wechat!invite">继续邀请下线</a>
	           <div class="clear"></div>
	        </p>
	    </div>
	   </s:if>
	       <div class="caption" style="margin-bottom: 10px;">
	         <p>
	           <span style="float:left;font-size: 16px;"><a style="text-decoration:underline;color:#FF0000;" href="weixin/wechat!topPage">查看上线</a></span>
	           <div class="clear"></div>
	        </p>
	       </div>
	    
	   
	    
		<div class="caption">
			<p>
				<span style="float:left;">个人信息&#13;</span>
				<s:if test="#request.agentUser.realNameValidate == 0">
					    <a href="javascript:;" id="upAgent" style="float:right;color:#c70013;margin-right:8px;text-decoration:underline;">升级为专业经纪人&gt;&gt;&nbsp;&nbsp;</a>
				</s:if>
                <div class="clear"></div>
			</p>
		</div>
		<div class="part_1" style="margin-bottom: 0;">
			<ul class="per">
			    <li>
					<span class="per_txt1">手机号码</span><span class="per_txt2"><s:property value="#request.agentUser.user.phone" /></span>
					<div class="clear"></div>
				</li>
				<li>
					<span class="per_txt1">身份证号</span><span class="per_txt2"><s:property value="#request.agentUser.idtNum" /></span>
					<a class="per_txt3" href="weixin/wechat!personEdit">修改&gt;&gt;</a>
					<div class="clear"></div>
				</li>
				<li>
					<span class="per_txt1">工作区域</span><span class="per_txt2"><s:property value="#request.agentUser.workArea" /></span>
					<a class="per_txt3" href="weixin/wechat!personEdit">修改&gt;&gt;</a>
					<div class="clear"></div>
				</li>
				<li>
					<span class="per_txt1">所属门店或楼盘</span><span class="per_txt2"><s:property value="#request.agentUser.workSpace" /></span>
					<a class="per_txt3" href="weixin/wechat!personEdit">修改&gt;&gt;</a>
					<div class="clear"></div>
				</li>

			</ul>
		</div>
		<div class="caption">
			<p style="margin-top:8px;">
				安全&#13;
			</p>
		</div>
		<div class="part_1" style="margin-bottom: 0;">
			<ul class="per">
				<li>
					<span class="per_txt1">密码</span>
					<a class="per_txt3" href="weixin/wechat!personEdit">修改&gt;&gt;</a>
					<div class="clear"></div>
				</li>
				<li>
					<span class="per_txt1">登录方式</span>
					<s:if test="request.agentUser.autoLogin == 0">
					    <span class="per_txt2">每次手机号+密码登录</span>
					</s:if>
					<s:else>
					    <span class="per_txt2">自动登录</span>
					</s:else>
					<a class="per_txt3" href="weixin/wechat!personEdit">修改&gt;&gt;</a>
					<div class="clear"></div>
				</li>

			</ul>
		</div>
		<div class="caption">
			<p style="margin-top:8px;">
				绑定银行卡&#13;
			</p>
		</div>
		<div class="part_1" style="margin-bottom: 0;">
			<ul class="per">
				<li>
					<span class="per_txt1">姓名</span><span class="per_txt2"><s:property value="#request.agentUser.user.realName" /></span>
					<a class="per_txt3" href="weixin/wechat!personEdit">修改&gt;&gt;</a>
					<div class="clear"></div>
				</li>
				<li>
					<span class="per_txt1">开户行</span><span class="per_txt2"><s:property value="#request.agentUser.bankName" /></span>
					<a class="per_txt3" href="weixin/wechat!personEdit">修改&gt;&gt;</a>
					<div class="clear"></div>
				</li>
				<li>
					<span class="per_txt1">银行卡号</span><span class="per_txt2"><s:property value="#request.agentUser.bankAccount" /></span>
					<a class="per_txt3" href="weixin/wechat!personEdit">修改&gt;&gt;</a>
					<div class="clear"></div>
				</li>

			</ul>
		</div>
		<input type="hidden" id="userId" value="<s:property value="#request.agentUser.user.id" />"/>
		<input type="hidden" id="agentId" value="<s:property value="#request.agentUser.id" />"/>
	</div>
	</body>
</html>
