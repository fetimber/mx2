<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="top">
	<div>
	<ul>
		<li>
			<a title="点击访问" href="javascript:window.open('http://weibo.com/p/1006065389106307/home?from=page_100606&mod=TAB#place');void(0);" style="border:0px">
				<img alt="新浪微博" src="resources/images/sina.png" width="20" height="20" />
			</a>
		</li>
		<li class="weixin">
			<a title="扫描关注" href="javascript:void(0)" id="a_wechat">
				<img alt="扫描关注" src="resources/images/wechat.png" width="20" height="20" on />
			</a>
			<div class="weixin_img">
				<img src="resources/images/weixin_download.png">
			</div>
		</li>
		<li>
			<a href="javascript:void(0)">
				<s:if test="null != #session.userinfo_in_session">
					<s:if test="null != #session.userinfo_in_session.realName">
						<s:property value="#session.userinfo_in_session.realName"/>
					</s:if>
					<s:else>
						<s:property value="#session.userinfo_in_session.loginName"/>
					</s:else>
				</s:if>
			</a>
		</li>
		<li>
			<a href="account/"><img src="resources/images/icon_wdzh.png" width="16"
					height="16" />我的账户</a>
		</li>
		<li>
			<a href="abouts/portal!toPage?pageName=help_service_contact"><img src="resources/images/icon_lxkf.png" width="16"
					height="16" />联系客服</a>
		</li>
		<li>
			<a href="abouts/portal!toPage?pageName=help_center"><img src="resources/images/icon_bzxd.png" width="16"
					height="16" />帮助向导</a>
		</li>
		<li class="top_extro">
			<s:if test="null == #session.userinfo_in_session">
				<a class="_call_back">登录</a>
				<a href="register">免费注册</a>
			</s:if>
			<s:else>
				<a href="login!out">安全退出</a>
			</s:else>
		</li>
	</ul>
	</div>
</div>