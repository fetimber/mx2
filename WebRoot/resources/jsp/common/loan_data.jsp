<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.math.BigDecimal"%>
<%@ page import="net.huimin.common.page.LoanPassportBean"%>
<%@ page import="net.huimin.common.cnst.Const"%>

<ul class="tab_nav">
    <% 
       String choice = (String)request.getParameter("choice");
       LoanPassportBean pass = (LoanPassportBean)request.getSession().getAttribute(Const.LOAN_PASSPORT);
       BigDecimal loanid = (BigDecimal)request.getSession().getAttribute(Const.LOAN_ID);  
    %>
	<li id="li_1" <%=pass.getLoan() ? "class=\"icon_part_finish\"" : "class=\"icon_part_unfinish\"" %>>
		<a href="loan/fillinfo?loandetailid=<%=loanid%>">借 款 信 息</a>
	</li>
	<li id="li_2" <%=pass.getPersonal()?"class=\"icon_part_finish\"" : "class=\"icon_part_unfinish\"" %>>
		<a href="loan/fillinfo!personal?loandetailid=<%=loanid%>">个 人 信 息</a>
	</li>
	<li id="li_3" <%=pass.getHouse()?"class=\"icon_part_finish\"" : "class=\"icon_part_unfinish\"" %>>
		<a href="loan/fillinfo!house?loandetailid=<%=loanid%>">房 车 信 息</a>
	</li>
	<li id="li_4" <%=pass.getWork()?"class=\"icon_part_finish\"" : "class=\"icon_part_unfinish\"" %>>
		<a href="loan/fillinfo!work?loandetailid=<%=loanid%>">工 作 信 息</a>
	</li>
	<li id="li_5" <%=pass.getLinkman()?"class=\"icon_part_finish\"" : "class=\"icon_part_unfinish\"" %>>
		<a href="loan/fillinfo!linkman?loandetailid=<%=loanid%>">联系人信息</a>
	</li>
	<li id="li_6" <%=pass.getCard()?"class=\"icon_part_finish\"" : "class=\"icon_part_unfinish\"" %>>
		<a href="loan/fillinfo!card?loandetailid=<%=loanid%>">银行卡信息</a>
	</li>
	<li id="li_7" <%=pass.getFiles()?"class=\"icon_part_finish\"" : "class=\"icon_part_unfinish\"" %>>
		<a href="loan/fillinfo!files?loandetailid=<%=loanid%>">影像文件上传</a>
	</li>
</ul>

<script>
    var liid =  "li_" + <%=choice%>;    
    var div = document.getElementById(liid);
    div.className = 'tab_nav_now'; 
</script>
