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
		$("#agentsview").submit();
	}	
  
    $(function(){
       
	
      });
  
  </script>
</head>

<body>
<div class="home"><img src="resources/images/icon_home.png" width="20" height="20" />数据管理&nbsp;>&nbsp;经纪人管理&nbsp;>&nbsp;报备历史</div>
<div class="m_w">
<!--检索部分-->
<s:form action="agent!history" namespace="/admin" method="POST" id="agentsview">
	 <s:hidden name="page.current" />
     <s:hidden name="agentUser.id" />
     
  <div class="tab_check"> 
     <span class="check_list1">   
    </span>  
   </div>
 <!--表格-->
 
 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1">
 <tbody>
        <tr>
		    <th width="8%">客户姓名</th>
		    <th width="10%">电话</th>
		    <th width="5%">有效性</th>
		    <th width="15%">推荐时间</th>
		    <th width="15%">最后跟进时间</th>
		    <th width="5%">状态</th>
		    <th width="12%">推荐楼盘</th>
        </tr>
  				<s:if test="null != page.beans && page.beans.size()>0">
			    <s:iterator value="page.beans" var="item" status="status">
					<tr <s:if test="#status.odd != true"> class="inter"</s:if>>		   
		          		<td align="center" valign="top"><s:property value="#item.customerName"/></td>
		          		<td align="center" valign="top"><s:property value="#item.customerDecimal"/></td>
		          		<td align="center" valign="top">
		          		<s:if test="#item.effectType == 1">有效客户</s:if><s:if test="#item.effectType == 0">无效客户</s:if>
		          		</td>         	
                        <td align="center" valign="top">
		                    <font style="font-family:Courier New">
								<s:date name="#item.referTime" format="yyyy-MM-dd HH:mm"/>
							</font>
						</td>
                        <td align="center" valign="top">
                            <font style="font-family:Courier New">
								<s:date name="#item.followTime" format="yyyy-MM-dd HH:mm"/>
							</font>
                        </td>
                        <td align="center" valign="top">
                             <s:if test="#item.customerStatus == 1">未分配</s:if>
		                     <s:elseif test="#item.customerStatus == 2">未处理</s:elseif><s:elseif test="#item.customerStatus == 3">电联</s:elseif>
		                     <s:elseif test="#item.customerStatus == 4">到访</s:elseif><s:elseif test="#item.customerStatus == 5">认购</s:elseif>
		                     <s:elseif test="#item.customerStatus == 6">签约</s:elseif><s:elseif test="#item.customerStatus == 7">申请结佣</s:elseif>
		                     <s:elseif test="#item.customerStatus == 8">已结佣</s:elseif><s:elseif test="#item.customerStatus == 9">申请提现</s:elseif>
		                     <s:elseif test="#item.customerStatus == 10">提现成功</s:elseif>
                        </td> 
                        <td align="center" valign="top"><s:property value="#item.houseInfo.projectName"/></td>  
					</tr>
				</s:iterator>
				</s:if>	
				<s:else>
		          <tr>
		          	  <td colspan="11" align="center"><font style="color:#ff671c;">没查询到您想要的数据信息！！</font></td>
		          </tr>
		        </s:else> 
   </tbody>
   </table>
      <!--页码-->
      <div class="page">
          <s:include value="../common/page.jsp" />
      </div>

</div>

 </s:form>
</body>
</html>
