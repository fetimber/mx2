<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <s:include value="../common/meta.jsp" />
  
  <script type="text/javascript">

	$(function(){
        $("#statusList").selectmenu(); 
        
        $("#save").click(function() { 
               vaildFormSubmit();
	    });  
     
       	$("#customer_form").validationEngine({
			addPromptClass: 'formError-white formError-small',
			promptPosition: 'centerRight: 25, +5', maxErrorsPerField: true,
			autoHidePrompt:true, autoHideDelay:3000, focusFirstField: false
        });
   
        
        function vaildFormSubmit(){   
	      if($("#customer_form").validationEngine('validate')){	 
	      			       
			if("" == $("#houseList").val()){
		       $.dialog.tips('未选择角色',3.0,'error.gif');
		       return false;
			}    	
		    $("#customer_form").submit();		     
	      }
	   }
        
    });
	</script>
</head>

<body>
<div class="home"><img src="resources/images/icon_home.png" width="20" height="20" />数据管理&nbsp;&gt;&nbsp;客户管理&nbsp;&gt;&nbsp;申诉处理</div>
<div class="m_w">
<!--后台用户-->
<s:form id="customer_form" action="customer!track_confirm" namespace="/admin" method="post">
     <s:hidden name="customerApplication.id" />
     <div class="p1_tpc">申诉处理 <input id="savebtn"  type="submit" value="处理"  class="btn_search" style="margin-left:40px;"/></div> 
	   <div class="p1_cont p1_cont_p">			
			<table style="width: 70%; margin-left: 15px ;" border="0" cellspacing="0" cellpadding="0" class="tab_1">
				<tr>
					<td width="10%" align="right" class="gray">申诉内容：</td>
				    <td width="25%" align="left">
				          <s:property value="customerApplication.appealMsg" />
				    </td>
				    <td width="10%" align="right" class="gray">申诉经纪人：</td>
				    <td  align="left"><s:property value="customerApplication.agentInfo.user.loginName"/>
				    <s:property value="customerApplication.agentInfo。phoneDecimal" /></td>
				</tr>
  
			    <tr>
				    <td width="10%" align="right" class="gray">处理意见：</td>
				    <td width="25%" align="left" colspan="3">
				         <textarea name="customerApplication.remark" id="textarea" cols="20" rows="5" class="txta1"></textarea>
				    </td>
				</tr>
			    <tr>   
				    <td width="10%" align="right" class="gray">更改状态：</td>
				    <td width="25%" align="left" colspan="3">
				         <s:select  id="statusList" list="#{'0':'未申诉','1':'未处理','2':'已处理'}" name="customerApplication.appealStatus" cssClass="sel_02"> </s:select>
				    </td>
				</tr>	
			</table>
						
	  </div>

	  
</div>
</s:form>
</div>
</body>
</html>
