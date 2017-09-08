<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String open = request.getParameter("open");
	String link = request.getParameter("link");
	String second = request.getParameter("second");
	String second_link = request.getParameter("second_link");
	String third = request.getParameter("third");
	String third_link = request.getParameter("third_link");
%>
<p class="account_posit">
	<img src="resources/images/icon_sy.png" width="24" height="24" />&nbsp;&nbsp;
	<a href="."><font color="#666">房小帅首页</font></a>&nbsp;>&nbsp;<a href="account/" style="color:#666">我的账户</a>
	<%
		if(null != second && !"".equals(second)){
			out.print("&nbsp;&gt;&nbsp;");
			if(null != second_link && !"".equals(second_link)){
				out.print("<a href=\"");
				out.print(second_link);
				out.print("\" style=\"color=#666\">");
				out.print(second);
				out.print("</a>");
			} else {
				out.print(second);
			}
		}
		if(null != third && !"".equals(third)){
			out.print("&nbsp;&gt;&nbsp;");
			out.print(third);
		}
	%>
</p>
<div class="account_left">
	<ul class="account_nav">
		<li <%="1".equals(open)?"class=\"account_nav_now\"":"" %>>
			<a href="account/">账户总览</a>
		</li>
		<li class="arrow01">
			<a href="javascript:void(0)">我的投资</a>
			<ul>
				<li <%="5".equals(open)?"class=\"account_nav_now\"":"" %>><a href="account/product">投资统计</a></li>
				<li <%="6".equals(open)?"class=\"account_nav_now\"":"" %>><a href="account/product!invest">投资记录</a></li>
				<li <%="7".equals(open)?"class=\"account_nav_now\"":"" %>><a href="account/product!profit">收益明细</a></li>
			</ul>
		</li>
		<li class="arrow01">
			<a href="javascript:void(0)">我的借款</a>
			<ul>
				<li <%="8".equals(open)?"class=\"account_nav_now\"":"" %>><a href="account/loan">借款统计</a></li>
				<li <%="9".equals(open)?"class=\"account_nav_now\"":"" %>><a href="account/loan!record">借款记录</a></li>
				<li <%="10".equals(open)?"class=\"account_nav_now\"":"" %>><a href="account/loan!payment">还款明细</a></li>
			</ul>
		</li>
		<li <%="2".equals(open)?"class=\"account_nav_now\"":"" %>><a href="account/transaction">资金记录</a></li>
		<li <%="3".equals(open)?"class=\"account_nav_now\"":"" %>><a href="account/safe">账户安全</a></li>
	</ul>
</div>