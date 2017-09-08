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
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
    <style type="text/css">
		body {padding-top: 20px;}
		*{font-size: 13px;font-family: "Courier New","微软雅黑"}
		td , th {text-align: center;height: 20px;line-height: 20px; border: 1px solid #666}
    </style>  
    
    <script type="text/javascript">
      $(function(){
			$("#cbx_all").bind("change",function(){
				var is_checked = $(this).prop("checked");
				$("input:checkbox").not("#cbx_all").each(function(){
					$(this).prop("checked",is_checked)
				});
			});
			var api = frameElement.api, W = api.opener;
			api.button({name:'保存',focus:true,callback:function(){
				var checked = new Array();
				$(".cbx_checked").each(function(){
					if($(this).prop("checked")){
						checked.push($(this).val());
					}
				});
				
				W.allot_ok(checked);
			}},{name:'取消',callback:function(){}});
		});
  </script>
  
</head>

<body>

<div class="m_w">
<!--后台用户-->
<s:form action="team!user" namespace="/admin" method="POST" id="callusersview">
  <s:hidden name="page.current" />

  <!--表格-->
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1" style="width:650px">
    <tbody>
        <tr>
		    <th width="8%"><input type="checkbox" id="cbx_all" name="checkAll" style="vertical-align: middle;"></th>
            <th width="13%">组员姓名</th>
            <th width="13%">联系方式</th>
            <th width="8%">待处理数</th>
        </tr>
	    <s:if test="null != callUserList && callUserList.size()>0">
	      <s:iterator value="callUserList" var="item" status="status">
			<tr <s:if test="#status.odd != true"> class="inter"</s:if>>		
			    <td align="center" valign="top"><input type="checkbox" class="cbx_checked" value="<s:property value="#item.userId" />" /></td>
          		<td align="center" valign="top"><s:property value="#item.userInfo.realName"/></td>
          		<td align="center" valign="top"><s:property value="#item.userInfo.phone"/></td>
          		<td align="center" valign="top"><s:property value="#item.customerDecimal"/></td>  
			</tr>
		  </s:iterator>
		</s:if>	
		<s:else>
          <tr>
          	  <td colspan="5" align="center"><font style="color:#ff671c;">没查询到您想要的数据信息！！</font></td>
          </tr>
        </s:else> 
    </tbody>
   </table>
</s:form>
</div>
</body>
</html>
