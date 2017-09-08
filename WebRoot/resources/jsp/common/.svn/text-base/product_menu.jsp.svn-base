<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="net.huimin.common.helper.CodeHelper"%>
<div class="head">
	<div class="head_main">
		<img src="resources/images/logo.png" width="141" height="42" class="logo" />
		<span class="area">上海
<%--		<a href="javascript:void(0)" class="changecity">[切换城市]</a>--%>
		</span>
		<%
			if(CodeHelper.isEmpty(request.getParameter("select"))){
				out.write("没有设置选中菜单");
			}
		%>
		<ul>
			<li <%="1".equals(request.getParameter("select"))?"class=\"nav_now\"" : "" %>>
				<a href=".">首 页</a>
			</li>
			<li <%="2".equals(request.getParameter("select"))?"class=\"nav_now\"" : "" %>>
				<a href="product/">投资理财</a>
			</li>
			<li <%="3".equals(request.getParameter("select"))?"class=\"nav_now\"" : "" %>>
				<a href="loan/application">借 款</a>
			</li>
			<li <%="4".equals(request.getParameter("select"))?"class=\"nav_now\"" : "" %>>
				<a href="abouts/portal!toPage?pageName=help_center">新手入门</a>
			</li>
		</ul>
		<img src="resources/images/hotline.png" width="199" height="27"
			class="hotline" />
	</div>
	<div class="jk_banner01">
		<img src="resources/images/detail_banner_img1.jpg" height="320" />
	</div>
</div>
