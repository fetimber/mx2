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
    <title>修改个人信息</title>
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
        	   editUserUrl : "weixin/wechat!editUser"     //个人账户更新
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
            seajs.use("<%=basePath%>resources/weixin/js_cmd/person2.js?v=044");
        })(location.href.match(/de(\-\d+)bug/));

     
    </script>
    
	
  </head>
	<body style="background:#f0f0f0;height: 120%;">
	<div style="padding-top:20px;">
		<div class="caption">
			<p>
				<span style="float:left;">个人信息&#13;</span>
				<a href="weixin/wechat!myAccount" class="per_txt3" style="float:right;margin-right:8px;font-size: 14px;">取消&gt;&gt;</a>
				<div class="clear"></div>
			</p>
		</div>
		<div class="part_1" style="margin-bottom: 0;">
			<ul class="per">
			    <li>
					<span class="per_txt1">手机号码</span><span class="per_txt2"><s:property value="#request.agentUser.user.phone" /></span>
					<div class="clear"></div>
				</li>
				<li style="position:relative;">
					<span class="per_txt1">身份证号</span><span class="per_txt2">
					<input id="idtNum" type="text" class="input2" value="<s:property value="#request.agentUser.idtNum" />"/>
					</span>
					<span class="must">*</span>
					<div class="clear"></div>
				</li>
				<li style="position:relative;">
					<span class="per_txt1">工作区域</span>
					<span class="per_txt2" style="width: 40%;">
					 <select id="workArea" class="sel3">
							<s:iterator value="#request.areas" var="area" status="st">
							    <s:if test="#area.areaName == #request.agentUser.workArea">
							       <option value="<s:property value='#area.areaName'/>" selected="selected">
										<s:property value='#area.areaName' />
									</option>
							    </s:if>
							    <s:else>
							        <option value="<s:property value='#area.areaName'/>">
										<s:property value='#area.areaName' />
									</option>
							    </s:else>
									
							</s:iterator>
						</select> </span><span class="must">*</span>
					<div class="clear"></div>
				</li>
				<li style="position:relative;">
					<span class="per_txt1">所属门店或楼盘</span><span class="per_txt2">
					<input id="workSpace" type="text" class="input2" value="<s:property value="#request.agentUser.workSpace" />"/>
					</span><span class="must">*</span>
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
				<li style="position:relative;">
					<span class="per_txt1">原密码</span><span class="per_txt2">
					<input id="pwd" type="password" class="input2" />
					</span><span class="must">*</span>
					<div class="clear"></div>
				</li>
				<li>
					<span class="per_txt1">新密码</span><span class="per_txt2">
					<input id="newPwd" type="password" class="input2" />
					</span>
					<div class="clear"></div>
				</li>
				<li>
					<span class="per_txt1">登录方式</span>
					<span class="per_txt2" style="width: 60%;"> <select
							id="autoLogin" class="sel3">
							<s:if test="#request.agentUser.autoLogin == 1">
							     <option value="1" selected="selected">
								          自动登录
							     </option>
							     <option value="0">
								          每次手机号+密码登录
							     </option>
							</s:if>
							<s:else>
							     <option value="0" >
								        每次手机号+密码登录
							     </option>
							     <option value="1" selected="selected">
								       自动登录
							     </option>
							</s:else>
							
						</select> </span>

					<div class="clear"></div>
				</li>

			</ul>
		</div>
		<div class="caption">
			<p>
				绑定银行卡&#13;
			</p>
		</div>
		<div class="part_1" style="margin-bottom: 0;">
			<ul class="per">
				<li>
					<span class="per_txt1">姓名</span><span class="per_txt2"><input id="realName" type="text" class="input2" value="<s:property value="#request.agentUser.user.realName" />"/>
					</span>
					<div class="clear"></div>
				</li>
				<li>
					<span class="per_txt1">开户行</span><span class="per_txt2"><input id="bankName" type="text" class="input2" value="<s:property value="#request.agentUser.bankName" />"/>
					</span>
					<div class="clear"></div>
				</li>
				<li>
					<span class="per_txt1">银行卡号</span><span class="per_txt2"><input id="bankAccount" type="text" class="input2" value="<s:property value="#request.agentUser.bankAccount" />"/>
					</span>
					<div class="clear"></div>
				</li>

			</ul>
		</div>
		<div class="btn_w" style="margin-bottom: 15px;">
			<input class="btn_zc" type="button" value="确认修改">
		</div>
		<div>
			&nbsp;
		</div>
	</div>
		<script>
		    
		</script>
	</body>
</html>
