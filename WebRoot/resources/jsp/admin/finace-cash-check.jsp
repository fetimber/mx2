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
        $("#houseList").selectmenu();
        $("#statusList").selectmenu(); 
        $("#effectList").selectmenu();
         

        $("#save").click(function() { 
               vaildFormSubmit(1);
	    });  
	    
	    
	     $("#del").click(function() { 
               vaildFormSubmit(0);
	    });  
     
       	$("#finace_form").validationEngine({
			addPromptClass: 'formError-white formError-small',
			promptPosition: 'centerRight: 25, +5', maxErrorsPerField: true,
			autoHidePrompt:true, autoHideDelay:3000, focusFirstField: false
        });
   
        
        function vaildFormSubmit(id){  
          $('#pass').val(id); 
	      if($("#finace_form").validationEngine('validate')){	  	
		     $("#finace_form").submit();		     
	      }
	   }
        
    });
	</script>
</head>

<body>
<div class="home"><img src="resources/images/icon_home.png" width="20" height="20" />提现管理</div>
<div class="m_w">
<!--后台用户-->
<s:form id="finace_form" action="finace!cashcheck" namespace="/admin" method="post">
<s:hidden name="cashApp.id" />
<s:hidden name="pass" id="pass"/>
     <div class="p1_tpc"><s:if test="cashApp.flag == 0">提现审核</s:if><s:else>提现详情</s:else></div> 
	   <div class="p1_cont p1_cont_p">			
			<table style="width: 70%; margin-left: 15px ;" border="0" cellspacing="0" cellpadding="0" class="tab_1">
				<tr>
					<td width="10%" align="right" class="gray">经纪人昵称：</td> 
				    <td width="25%" align="left">
				         <s:property value="cashApp.agentInfo.user.nickName"/>
				    </td>
				    <td width="10%" align="right" class="gray">电话：</td>
				    <td  align="left">   
				         <s:property value="cashApp.agentInfo.phoneDecimal"/>
					</td>
				</tr>
				
				<tr>
					<td width="10%" align="right" class="gray">所属区域：</td>
				    <td width="25%" align="left">
				          <s:property value="cashApp.agentInfo.workArea"/>
				    </td>
				    <td width="10%" align="right" class="gray">门店楼盘：</td>
				    <td  align="left">    
				           <s:property value="cashApp.agentInfo.workSpace"/>
					</td>
				</tr>
			    <tr>
			       	<td width="10%" align="right" class="gray">申请提现时间：</td>
				    <td width="25%" align="left" >
				        <s:date name="cashApp.applicationTime" format="yyyy-MM-dd HH:mm"/> 
				    </td>
				    <td width="10%" align="right" class="gray">真实姓名：</td>
				    <td width="25%" align="left" >
				       <s:property value="cashApp.agentInfo.user.realName"/>
				    </td>
				</tr>
			    <tr>
					<td width="10%" align="right" class="gray">开户银行：</td>
					<td width="25%" align="left"><s:property value="cashApp.agentInfo.bankName"/></td>
					<td width="10%"align="right" class="gray">银行卡号：</td>
					<td width="25%" align="left"><s:property value="cashApp.agentInfo.bankAccount"/></td>				    
				</tr>
				<tr>
				   <td width="10%" align="right" class="gray">申请总金额：</td>
				    <td width="25%" align="left" colspan="3">
				         <s:property value="cashApp.amountMoney"/>&nbsp;&nbsp;元
				    </td>
				</tr>
			    <tr>
		       	    <td width="10%" align="right" class="gray">审核总金额：</td>
				    <td width="25%" align="left" colspan="3">
				        <s:if test="cashApp.flag == 0">
				           <s:textfield name="cashApp.finalMoney" cssClass="input_1 input_2_w validate[required,custom[number],min[1]" />&nbsp;&nbsp;元
				        </s:if>
				        <s:else><s:property value="cashApp.finalMoney"/>&nbsp;&nbsp;元</s:else>
				    </td>
				</tr>
				<tr>
				   <td width="10%" align="right" class="gray">审核：</td>
				    <td width="25%" align="left" colspan="3">
				        <s:if test="null != cashApp.detailInfo && cashApp.detailInfo.size()>0">
				           <s:iterator value="cashApp.detailInfo" var="item" status="status">
				             <s:property value="#item.result"/> &nbsp;&nbsp;&nbsp; <s:date name="#item.operaterTime" format="yyyy-MM-dd HH:mm"/> 
				             &nbsp;&nbsp;&nbsp;操作人  <s:property value="#item.operaterInfo.loginName"/>
	                         <div class="clear"></div>
				          </s:iterator>
				        </s:if>
				        <s:else>暂无审核数据</s:else>
				    </td>
				</tr>
				<s:if test="cashApp.flag == 0">
				 <tr>
					<td width="10%" align="right" class="gray">审核说明：</td>
				    <td width="25%" align="left" colspan="3">
				         <textarea name="cashApp.remark" id="textarea" cols="20" rows="5" class="txta1"></textarea>
				    </td>
				</tr>
				</s:if>	
			</table>
			<s:if test="cashApp.flag == 0">
			 <input id="save"  type="button" value="通过"  class="btn_search" style="margin-left:100px;"/>	
			 <input id="del"  type="button" value="拒绝"  class="btn_search" style="margin-left:20px;"/>	
		   </s:if>	
	  </div>
	  <div class="p1_tpc">经纪人账户信息</div> 
	  <div class="p1_cont p1_cont_p">			
			<table style="width: 70%; margin-left: 15px ;" border="0" cellspacing="0" cellpadding="0" class="tab_1">
				<tr>
				    <td width="10%" align="right" class="gray">可结佣金：</td>
					<td width="25%" align="left"><s:property value="cashApp.accountInfo.usable"/></td>
					<td width="10%" align="right" class="gray">已结佣金：</td>
					<td width="25%" align="left"><s:property value="cashApp.accountInfo.total"/></td>
					<td width="10%"align="right" class="gray">审核中的佣金：</td>
					<td align="left"><s:property value="cashApp.accountInfo.pending"/></td>				    
				</tr>
				<tr>
				    <td width="10%" align="right" class="gray">可结现金：</td>
					<td width="25%" align="left"><s:property value="cashApp.accountInfo.cash"/></td>
					<td width="10%" align="right" class="gray">已提现金：</td>
					<td width="25%" align="left"><s:property value="cashApp.accountInfo.history"/></td>
					<td width="10%"align="right" class="gray">审核中的现金：</td>
					<td align="left"><s:property value="cashApp.accountInfo.cashing"/></td>				    
				</tr>	
             </table>					
	  </div>

</div>
</s:form>
</div>
</body>
</html>
