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
               var firstmoney =  $('#firstmoney').val();
               var finalmoney =  $('#finalmoney').val();
               var price = $('#price').val();
               var count = $('#count').val();
               
               if(price != undefined && count != undefined){
	               if(price * count != finalmoney){
	                  $.dialog.tips('审核总金额必须等于单价乘以套数',3,'alert.gif');
	                  return false;
	               }else{
	                  vaildFormSubmit(1);
	               }   
               }else{
	              vaildFormSubmit(1);
	          }  
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
<div class="home"><img src="resources/images/icon_home.png" width="20" height="20" />佣金管理</div>
<div class="m_w">
<!--后台用户-->
<s:form id="finace_form" action="finace!moneycheck" namespace="/admin" method="post">
<s:hidden name="moneyApp.id" />
<s:hidden name="pass" id="pass"/>
     <div class="p1_tpc"> <s:if test="moneyApp.flag == 0">佣金审核</s:if><s:else>佣金详情</s:else></div> 
	   <div class="p1_cont p1_cont_p">			
			<table style="width: 70%; margin-left: 15px ;" border="0" cellspacing="0" cellpadding="0" class="tab_1">
				<tr>
					<td width="10%" align="right" class="gray">经纪人：</td>
				    <td width="25%" align="left">
				         <s:property value="moneyApp.agentInfo.user.nickName"/>
				    </td>
				    <td width="10%" align="right" class="gray">电话：</td>
				    <td  align="left">   
				         <s:property value="moneyApp.agentInfo.phoneDecimal"/>
					</td>
				</tr>
				<s:if test="moneyApp.appType == 1 or moneyApp.appType == 2 or moneyApp.appType == 3">	  
				<tr>
					<td width="10%" align="right" class="gray">楼盘项目：</td>
				    <td width="25%" align="left">
				        <s:property value="moneyApp.appInfo.app.houseInfo.projectName"/>
				    </td>
				    <td width="10%" align="right" class="gray">所属区域：</td>
				    <td  align="left">    
				        <s:property value="moneyApp.appInfo.app.houseInfo.areaInfo.areaName"/>
					</td>
				</tr>
				</s:if>
				<s:if test="moneyApp.appType == 1">
			    <tr>
			       	<td width="10%" align="right" class="gray">佣金单价：</td>
				    <td width="25%" align="left">
				         <s:if test="moneyApp.flag == 0">
				           <s:textfield id="price" name="moneyApp.appInfo.app.housePrice" cssClass="input_1 input_2_w validate[required,custom[number],min[1]" />&nbsp;&nbsp;元
				         </s:if>
				         <s:else>
				           <s:property value="moneyApp.appInfo.app.housePrice"/>&nbsp;&nbsp;元
				         </s:else>
				    </td>
				    <td width="10%" align="right" class="gray">签约数量：</td>
				    <td width="25%" align="left">
				       <s:if test="moneyApp.flag == 0">
				          <s:textfield id="count" name="moneyApp.appInfo.app.houseCount" cssClass="input_1 input_2_w validate[required,custom[number],min[1]" />&nbsp;&nbsp;套
				       </s:if>
				       <s:else>
				           <s:property value="moneyApp.appInfo.app.houseCount"/>&nbsp;&nbsp;套
				       </s:else>
				    </td>
				</tr>
				</s:if>

				<tr>
				   <td width="10%" align="right" class="gray">申请总金额：</td>
				    <td width="25%" align="left">
				         <s:if test="moneyApp.flag == 0">
				           <s:textfield id="firstmoney" name="moneyApp.amountMoney" readonly="readonly" cssClass="input_1 input_2_w validate[required,custom[number],min[1]" />&nbsp;&nbsp;元
				         </s:if>
				        <s:else>
				            <s:property value="moneyApp.amountMoney"/>&nbsp;&nbsp;元
				         </s:else>
				    </td>
				    <td width="10%" align="right" class="gray">审核总金额：</td>
				    <td width="25%" align="left">
				         <s:if test="moneyApp.flag == 0">
				             <s:textfield id="finalmoney" name="moneyApp.finalMoney" cssClass="input_1 input_2_w validate[required,custom[number],min[1]" />&nbsp;&nbsp;元
				         </s:if>
				         <s:else>
				           <s:property value="moneyApp.finalMoney"/>&nbsp;&nbsp;元
				         </s:else>
				    </td>
				</tr>
				
				<tr>
				   <td width="10%" align="right" class="gray">审核：</td>
				    <td width="25%" align="left" colspan="3">
				        <s:if test="null != moneyApp.detailInfo && moneyApp.detailInfo.size()>0">
				           <s:iterator value="moneyApp.detailInfo" var="item" status="status">
				             <s:property value="#item.result"/> &nbsp;&nbsp;&nbsp; <s:date name="#item.operaterTime" format="yyyy-MM-dd HH:mm"/> 
				             &nbsp;&nbsp;&nbsp;操作人  <s:property value="#item.operaterInfo.loginName"/>
	                         <div class="clear"></div>
				          </s:iterator>
				        </s:if>
				        <s:else>暂无数据</s:else>
				    </td>
				</tr>
				
				 <s:if test="moneyApp.flag == 0">
				 <tr>
					<td width="10%" align="right" class="gray">审核说明：</td>
				    <td width="25%" align="left" colspan="3">
				        <textarea name="moneyApp.remark" id="textarea" cols="20" rows="5" class="txta1"></textarea>
				    </td>
				 </tr>
				 </s:if>
				
				
			</table>
			<s:if test="moneyApp.flag == 0">
			<input id="save"  type="button" value="通过"  class="btn_search" style="margin-left:100px;"/>	
			<input id="del"  type="button" value="拒绝"  class="btn_search" style="margin-left:20px;"/>	
			</s:if>
	  </div>
	  <div class="p1_tpc">经纪人</div> 
	  <div class="p1_cont p1_cont_p">			
			<table style="width: 70%; margin-left: 15px ;" border="0" cellspacing="0" cellpadding="0" class="tab_1">
				<tr>      
				    <td width="10%" align="right" class="gray">昵称：</td>
					<td width="25%" align="left"><s:property value="moneyApp.agentInfo.user.nickName"/></td>
					<td width="10%" align="right" class="gray">电话：</td>
					<td width="25%" align="left"> <s:property value="moneyApp.agentInfo.phoneDecimal"/></td>
					<td width="10%"align="right" class="gray">申请时间：</td>
					<td align="left"><s:date name="moneyApp.applicationTime" format="yyyy-MM-dd HH:mm"/></td>				    
				</tr>
				<tr>      
				    <td width="10%" align="right" class="gray">姓名：</td>
					<td width="25%" align="left"><s:property value="moneyApp.agentInfo.user.realName"/></td>
					<td width="10%" align="right" class="gray">开户银行：</td>
					<td width="25%" align="left"> <s:property value="moneyApp.agentInfo.bankName"/></td>
					<td width="10%"align="right" class="gray">银行账号：</td>
					<td align="left"> <s:property value="moneyApp.agentInfo.bankAccount"/></td>				    
				</tr>	
             </table>					
	  </div>

      <s:if test="moneyApp.appType == 1 or moneyApp.appType == 2 or moneyApp.appType == 3">	  

		 <div class="p1_cont p1_cont_p">			
				<table style="width: 70%; margin-left: 15px ;"  border="0" cellspacing="0" cellpadding="0" class="tab_1">
					<tr>
						<td width="10%" align="right" class="gray">姓名：</td>
					    <td width="25%" align="left"><s:property value="moneyApp.appInfo.app.customerName"/></td>
					    <td width="10%" align="right" class="gray">电话：</td>
					    <td width="25%" align="left"><s:property value="moneyApp.appInfo.app.customerDecimal"/></td>
					    <td width="10%"align="right" class="gray">推荐时间：</td>
					    <td align="left"><s:date name="moneyApp.appInfo.app.referTime" format="yyyy-MM-dd HH:mm"/></td>
					</tr>
				     <tr>
				 		<td width="10%" align="right" class="gray">备注：</td>
					    <td width="25%" align="left" colspan="4"><s:property value="moneyApp.appInfo.app.remark"/></td>
					</tr>
			    </table>			
		  </div>
	  </s:if>
	
	  
</div>
</s:form>
</div>
</body>
</html>
