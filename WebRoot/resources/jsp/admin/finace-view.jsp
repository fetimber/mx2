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
    function _forward_page(page){
		$(":hidden[name='page.current']").val(page);
		$("#finaceview").submit();
	}	
  
    function tabshow(divid,obj){
     
        if('ar_tab_now' != $(obj).attr('class')){
            $(".ar_tab li").removeClass("ar_tab_now");
            $(obj).addClass("ar_tab_now");
        }
        
        $('#tab').val(divid);
        _forward_page(1);
    }
  
    $(function(){
          $(".sel_01").selectmenu();
     
	   	  $("#startime").datepicker({
    	     showSecond: true,
	 	     timeFormat: 'hh:mm:ss',
		     separator: ' ',
		     autoSize:true
           });
                     
           $("#endtime").datepicker({
    	     showSecond: true,
	 	     timeFormat: 'hh:mm:ss',
		     separator: ' ',
		     autoSize:true
           });               
           
	       $("#querybtn").bind("click",function(){
	                 if($('#startime').val() > $('#endtime').val()){
				      $.dialog.tips('开始时间不能大于结束时间',2.5,'error.gif');
				      return;
				    }else if($('#endtime').val() > new Date().Format("yyyy-MM-dd") ){ 
				      $.dialog.tips('结束时间不能大于当前时间',2.5,'error.gif');
				      return;
				    }
				    else{
				       _forward_page(1);
				    }	    
		   	});     
	      
			
      });
 
  </script>
</head>

<body>
<div class="home" style="min-width: 1720px"><img src="resources/images/icon_home.png" width="20" height="20" />财务管理</div>
<div class="m_w">
<!--检索部分-->
<s:form action="finace!view" namespace="/admin" method="POST" id="finaceview">
	 <s:hidden name="page.current" />
     <s:hidden name="tab" id="tab"/>
     
  <div class="tab_check" style="min-width: 1680px"> 
    <span class="check_list1"> 
     <span> 输入搜索关键字： <s:textfield   name="keyword" cssClass="auto_tips input_data" alt="经纪人号码" />&nbsp;&nbsp;&nbsp;&nbsp;</span>
     <span>申请时间：</span> 
    	<span class="data_sel">
        	<input name="startime" id="startime" type="text" class="input_data timer" value="<s:date name="%{startime}" format="yyyy-MM-dd" />" />	
        </span> 
        
        <img src="resources/images/devide_line.png" width="10" height="3"  class="dvd_line"/> 
       
        <span class="data_sel">
    		<input name="endtime" id="endtime" type="text" class="input_data timer" value="<s:date name="%{endtime}" format="yyyy-MM-dd" />" />
         </span> 
    </span>
    &nbsp;&nbsp;
     <input id="querybtn"  type="button" value="搜索"  class="btn_search" style="margin-left:10px;"/>
   </div>
 <!--表格-->
  <ul class="ar_tab" style="border:1px solid #d1d1d1;border-bottom:0;min-width: 1682px">
    <li id="tab0" <s:if test="tab == 0"> class="ar_tab_now" </s:if><s:else>class="" </s:else> onclick="tabshow(0,this);">结佣审核</li>
    <li id="tab1" <s:if test="tab == 1"> class="ar_tab_now" </s:if><s:else>class="" </s:else> onclick="tabshow(1,this);">提现审核</li>
    <li id="tab2" <s:if test="tab == 2"> class="ar_tab_now" </s:if><s:else>class="" </s:else> onclick="tabshow(2,this);">全部佣金申请</li>
    <li id="tab3" <s:if test="tab == 3"> class="ar_tab_now" </s:if><s:else>class="" </s:else> onclick="tabshow(3,this);">全部提现申请</li>
  </ul>
  
  <s:if test="tab == 0">
    <div style="padding:20px;border:1px solid #d1d1d1;border-top:0px;min-width: 1642px">
	 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1" style="min-width: 1638px">
	 <tbody>
	        <tr>
			    <th width="8%">区域</th>
			    <th width="10%">项目</th>
			    <th width="8%">客户</th>
			    <th width="8%">经纪人</th>
			    <th width="8%">经纪人电话</th>
			    <th width="9%">申请时间</th>
			    <th width="8%">状态</th>
			    <th width="8%">佣金类型</th>
			    <th width="7%">签约数量(套)</th>
			    <th width="7%">佣金单价(元)</th>
			    <th width="7%">佣金总额(元)</th>
			    <th width="7%">终审金额(元)</th>
			    <th width="12%">操作</th>
	        </tr>
 	        <s:if test="null != page.beans && page.beans.size()>0">
		     <s:iterator value="page.beans" var="item" status="status">
				<tr <s:if test="#status.odd != true"> class="inter"</s:if>>	
				   <s:if test="#item.appType == 1 or #item.appType == 2 or #item.appType == 3">	   
	          		 <td align="center" valign="top"><s:property value="#item.appInfo.app.houseInfo.areaInfo.areaName"/></td>
	          		 <td align="center" valign="top"><s:property value="#item.appInfo.app.houseInfo.projectName"/></td>
	          		 <td align="center" valign="top"><s:property value="#item.appInfo.app.customerName"/></td>
	          	  </s:if>
	          	  <s:else>
	          	     <td align="center" valign="top">&nbsp;&nbsp;</td>
	          		 <td align="center" valign="top">&nbsp;&nbsp;</td>
	          		 <td align="center" valign="top">&nbsp;&nbsp;</td>
	          	  </s:else>
	          	  
	          	  <s:if test="#item.appType == 1">
                       <td align="center" valign="top"><s:property value="#item.appInfo.app.agentInfo.user.nickName"/></td>
                       <td align="center" valign="top"><s:property value="#item.appInfo.app.agentInfo.phoneDecimal"/> </td> 
                  </s:if>
                  <s:else>
                       <td align="center" valign="top"><s:property value="#item.agentInfo.user.nickName"/></td>
                       <td align="center" valign="top"><s:property value="#item.agentInfo.phoneDecimal"/> </td> 
                  </s:else>     
                       
                       <td align="center" valign="top">
                          <font style="font-family:Courier New">
				         <s:date name="#item.applicationTime" format="yyyy-MM-dd HH:mm"/>
					   </font>
					 </td> 
					   <td align="center" valign="top">
					    <s:if test="#item.resultStatus == 0">等待审核</s:if>
					    <s:if test="#item.resultStatus == 1 or #item.resultStatus == 3">审核通过</s:if>
					    <s:if test="#item.resultStatus == 2">审核拒绝</s:if>
					   </td> 
					   <td align="center" valign="top">
					     <s:if test="#item.appType == 1">签约结佣</s:if>
					     <s:elseif test="#item.appType == 2">到访奖励</s:elseif>
					     <s:elseif test="#item.appType == 3">带看奖励</s:elseif>
					     <s:elseif test="#item.appType == 4">推荐人注册奖励</s:elseif> 
					     <s:elseif test="#item.appType == 5">注册送红包</s:elseif>
					     <s:else>其他</s:else>
					   </td>
                      <s:if test="#item.appType == 1">
                         <td align="center" valign="top"><s:property value="#item.appInfo.app.houseCount"/> </td> 
                         <td align="center" valign="top"><s:property value="#item.appInfo.app.housePrice"/> </td>
                      </s:if>
                      <s:else>
                         <td align="center" valign="top">&nbsp;&nbsp;&nbsp;&nbsp;</td> 
                         <td align="center" valign="top">&nbsp;&nbsp;&nbsp;&nbsp;</td>
                      </s:else>
                       
                       <td align="center" valign="top"><s:property value="#item.amountMoney"/></td>
                       <td align="center" valign="top"><s:property value="#item.finalMoney"/></td>    
                       <td align="center" valign="top">
                          <s:if test="#item.resultStatus != 1">
                               <a href="admin/finace!money?flag=0&moneyApp.id=<s:property value="#item.id"/>">审核</a>
                          </s:if>
                          <s:else>
                               <a href="admin/finace!money?flag=1&moneyApp.id=<s:property value="#item.id"/>">详情</a>
                           </s:else>
                       </td>   
				</tr>
			</s:iterator>
			</s:if>	
			<s:else>
	          <tr>
	          	  <td colspan="13" align="center"><font style="color:#ff671c;">没查询到您想要的数据信息！！</font></td>
	          </tr>
	        </s:else> 
	     </tbody>
	</table>
    </s:if>
    <s:if test="tab == 1">
      <div style="padding:20px;border:1px solid #d1d1d1;border-top:0px;">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1" style="min-width: 1638px">
	  <tbody>
	        <tr>
			    <th width="8%">经纪人</th>
			    <th width="7%">经纪人电话</th>
			    <th width="9%">申请时间</th>
			    <th width="9%">申请金额（元）</th>
			    <th width="7%">终审金额(元)</th>
			    <th width="7%">终审时间</th>
			    <th width="9%">账户可提现余额（元）</th>
			    <th width="9%">账户已提现金额（元）</th>
			    <th width="12%">操作</th>
	        </tr>
  				<s:if test="null != page.beans && page.beans.size()>0">
			    <s:iterator value="page.beans" var="item" status="status">
					<tr <s:if test="#status.odd != true"> class="inter"</s:if>>		   
		          		<td align="center" valign="top"><s:property value="#item.agentInfo.user.realName"/></td>
		          		<td align="center" valign="top"><s:property value="#item.agentInfo.phoneDecimal"/></td>
                        <td align="center" valign="top">
                           <font style="font-family:Courier New">
					         <s:date name="#item.applicationTime" format="yyyy-MM-dd HH:mm"/>
						   </font>
						 </td> 
						<td align="center" valign="top"><s:property value="#item.amountMoney"/></td>
						<td align="center" valign="top"><s:property value="#item.finalMoney"/></td> 
						<td align="center" valign="top">
                           <font style="font-family:Courier New">
					         <s:date name="#item.finishTime" format="yyyy-MM-dd HH:mm"/>
						   </font>
						 </td> 
	
                        <td align="center" valign="top"><s:property value="#item.accountInfo.cash"/></td> 
                        <td align="center" valign="top"><s:property value="#item.accountInfo.history"/></td> 
                        
                        <td align="center" valign="top">
                          <s:if test="#item.resultStatus!=1 && #item.resultStatus!=3">
                               <a href="admin/finace!cash?flag=0&cashApp.id=<s:property value="#item.id"/>">审核</a>
                          </s:if>
                          <s:else>
                               <a href="admin/finace!cash?flag=1&cashApp.id=<s:property value="#item.id"/>">详情</a>
                           </s:else>
                         </td>   
					</tr>
				  </s:iterator>
				  </s:if>	
				  <s:else>
		             <tr>
		          	  <td colspan="9" align="center"><font style="color:#ff671c;">没查询到您想要的数据信息！！</font></td>
		             </tr>
		          </s:else> 
	     </tbody>
	</table>
    </s:if>
     
     
    <s:if test="tab == 2">
    <div style="padding:20px;border:1px solid #d1d1d1;border-top:0px;">
	 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1" style="min-width: 1638px">
	  <tbody>
	        <tr>
			    <th width="8%">区域</th>
			    <th width="10%">项目</th>
			    <th width="8%">客户</th>
			    <th width="8%">经纪人</th>
			    <th width="8%">经纪人电话</th>
			    <th width="9%">申请时间</th>
			    <th width="8%">状态</th>
			    <th width="8%">佣金类型</th>
			    <th width="7%">签约数量(套)</th>
			    <th width="7%">佣金单价(元)</th>
			    <th width="7%">佣金总额(元)</th>
			    <th width="7%">终审金额(元)</th>
			    <th width="12%">操作</th>
	        </tr>
 	        <s:if test="null != page.beans && page.beans.size()>0">
		     <s:iterator value="page.beans" var="item" status="status">
				<tr <s:if test="#status.odd != true"> class="inter"</s:if>>	
				   <s:if test="#item.appType == 1 or #item.appType == 2 or #item.appType == 3">	   
	          		 <td align="center" valign="top"><s:property value="#item.appInfo.app.houseInfo.areaInfo.areaName"/></td>
	          		 <td align="center" valign="top"><s:property value="#item.appInfo.app.houseInfo.projectName"/></td>
	          		 <td align="center" valign="top"><s:property value="#item.appInfo.app.customerName"/></td>
	          	  </s:if>
	          	  <s:else>
	          	     <td align="center" valign="top">&nbsp;&nbsp;</td>
	          		 <td align="center" valign="top">&nbsp;&nbsp;</td>
	          		 <td align="center" valign="top">&nbsp;&nbsp;</td>
	          	  </s:else>
	          	  
	          	  <s:if test="#item.appType == 1">
                       <td align="center" valign="top"><s:property value="#item.appInfo.app.agentInfo.user.nickName"/></td>
                       <td align="center" valign="top"><s:property value="#item.appInfo.app.agentInfo.phoneDecimal"/> </td> 
                  </s:if>
                  <s:else>
                       <td align="center" valign="top"><s:property value="#item.agentInfo.user.nickName"/></td>
                       <td align="center" valign="top"><s:property value="#item.agentInfo.phoneDecimal"/> </td> 
                  </s:else>     
                       
                       <td align="center" valign="top">
                          <font style="font-family:Courier New">
				         <s:date name="#item.applicationTime" format="yyyy-MM-dd HH:mm"/>
					   </font>
					 </td> 
					   <td align="center" valign="top">
					    <s:if test="#item.resultStatus == 0">等待审核</s:if>
					    <s:if test="#item.resultStatus == 1 or #item.resultStatus == 3">审核通过</s:if>
					    <s:if test="#item.resultStatus == 2">审核拒绝</s:if>
					   </td> 
					   <td align="center" valign="top">
					     <s:if test="#item.appType == 1">签约结佣</s:if>
					     <s:elseif test="#item.appType == 2">到访奖励</s:elseif>
					     <s:elseif test="#item.appType == 3">带看奖励</s:elseif>
					     <s:elseif test="#item.appType == 4">推荐人注册奖励</s:elseif> 
					     <s:elseif test="#item.appType == 5">注册送红包</s:elseif>
					     <s:else>其他</s:else>
					   </td>
                      <s:if test="#item.appType == 1">
                         <td align="center" valign="top"><s:property value="#item.appInfo.app.houseCount"/> </td> 
                         <td align="center" valign="top"><s:property value="#item.appInfo.app.housePrice"/> </td>
                      </s:if>
                      <s:else>
                         <td align="center" valign="top">&nbsp;&nbsp;&nbsp;&nbsp;</td> 
                         <td align="center" valign="top">&nbsp;&nbsp;&nbsp;&nbsp;</td>
                      </s:else>
                       
                       <td align="center" valign="top"><s:property value="#item.amountMoney"/></td>
                       <td align="center" valign="top"><s:property value="#item.finalMoney"/></td>    
                       <td align="center" valign="top">
                          <s:if test="#item.resultStatus != 1">
                               <a href="admin/finace!money?flag=0&moneyApp.id=<s:property value="#item.id"/>">审核</a>
                          </s:if>
                          <s:else>
                               <a href="admin/finace!money?flag=1&moneyApp.id=<s:property value="#item.id"/>">详情</a>
                           </s:else>
                       </td>   
				</tr>
			</s:iterator>
			</s:if>	
			<s:else>
	          <tr>
	          	  <td colspan="13" align="center"><font style="color:#ff671c;">没查询到您想要的数据信息！！</font></td>
	          </tr>
	        </s:else> 
	     </tbody>
	</table>
    </s:if>
     
     <s:if test="tab == 3">
      <div style="padding:20px;border:1px solid #d1d1d1;border-top:0px;">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1" style="min-width: 1638px">
	   <tbody>
	        <tr>
			    <th width="8%">经纪人</th>
			    <th width="7%">经纪人电话</th>
			    <th width="9%">申请时间</th>
			    <th width="9%">申请金额（元）</th>
			    <th width="7%">终审金额(元)</th>
			    <th width="7%">终审时间</th>
			    <th width="9%">账户可提现余额（元）</th>
			    <th width="9%">账户已提现金额（元）</th>
			    <th width="12%">操作</th>
	        </tr>
  				<s:if test="null != page.beans && page.beans.size()>0">
			    <s:iterator value="page.beans" var="item" status="status">
					<tr <s:if test="#status.odd != true"> class="inter"</s:if>>		   
		          		<td align="center" valign="top"><s:property value="#item.agentInfo.user.realName"/></td>
		          		<td align="center" valign="top"><s:property value="#item.agentInfo.phoneDecimal"/></td>
                        <td align="center" valign="top">
                           <font style="font-family:Courier New">
					         <s:date name="#item.applicationTime" format="yyyy-MM-dd HH:mm"/>
						   </font>
						 </td> 
						<td align="center" valign="top"><s:property value="#item.amountMoney"/></td>
						<td align="center" valign="top"><s:property value="#item.finalMoney"/></td> 
						<td align="center" valign="top">
                           <font style="font-family:Courier New">
					         <s:date name="#item.finishTime" format="yyyy-MM-dd HH:mm"/>
						   </font>
						 </td> 
	
                        <td align="center" valign="top"><s:property value="#item.accountInfo.cash"/></td> 
                        <td align="center" valign="top"><s:property value="#item.accountInfo.history"/></td> 
                        
                        <td align="center" valign="top">
                          <s:if test="#item.resultStatus!=1 && #item.resultStatus!=3">
                               <a href="admin/finace!cash?flag=0&cashApp.id=<s:property value="#item.id"/>">审核</a>
                          </s:if>
                          <s:else>
                               <a href="admin/finace!cash?flag=1&cashApp.id=<s:property value="#item.id"/>">详情</a>
                           </s:else>
                         </td>   
					</tr>
				  </s:iterator>
				  </s:if>	
				  <s:else>
		             <tr>
		          	  <td colspan="9" align="center"><font style="color:#ff671c;">没查询到您想要的数据信息！！</font></td>
		             </tr>
		          </s:else> 
	     </tbody>
	</table>
    </s:if>  
     
    <!--页码-->
    <div class="page">
        <s:include value="../common/page.jsp" />
    </div>
    <div class="clear"></div>
  </div>
</div>

 </s:form>
</body>
</html>
