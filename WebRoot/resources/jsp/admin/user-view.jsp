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
		$("#usersview").submit();
	}
	
	function delete_user(id){
	    var postParams = "user.id=" + id;

        $.dialog.confirm("是否确认删除", function(){
				$.post('admin/user!delete', postParams ,function(data){
				    eval("data=" + data);
					if(data.result){
					    $.dialog.tips('删除成功',2,'success.gif',function(){
					    	window.location.reload(true);
					    	//window.location.href = 'admin/team!view';
					    });
					} else {
						$.dialog.tips('失败',3,'error.gif');
					}
				});
		 }, function(){
			 $.dialog.tips('已取消操作',3,'alert.gif');
		 });
	}
	
	function reset_pwd(id){
	    var postParams = "user.id=" + id;

        $.dialog.confirm("重置后密码为用户名，是否确认重置密码？", function(){
				$.post('admin/user!reset', postParams ,function(data){
				    eval("data=" + data);
					if(data.result){
					    $.dialog.tips('重置成功',2,'success.gif',function(){
					    	window.location.reload(true);
					    	//window.location.href = 'admin/team!view';
					    });
					} else {
						$.dialog.tips('重置失败',3,'error.gif');
					}
				});
		 }, function(){
			 $.dialog.tips('已取消操作',3,'alert.gif');
		 });
	}
	
	
	
	</script>
</head>

<body>
<div class="home"><img src="resources/images/icon_home.png" width="20" height="20" />系统设置&nbsp;>&nbsp;用户管理</div>
<div class="m_w">
     <s:form action="user!view" namespace="/admin" method="POST" id="usersview">
  <s:hidden name="page.current" />
  <!--检索部分-->
			<div class="tab_check" style="min-width: 850px;">
				
				<s:textfield name="user.loginName" cssClass="auto_tips" alt="请输入用户登录名" style="float:left; width:300px;border:1px solid #aaa;height:28px;padding:1px 5px;line-height:28px"></s:textfield>
				
				<input type="button" value="搜索" class="btn_search" style="margin-left:10px;margin-top:-3px;" onclick="_forward_page(1)" />
				<input type="button" value="新增用户" class="btn_search" style="margin-left:10px;margin-top:-3px;" onclick="location.href='admin/user!add'" />
			</div>
 


  <!--表格-->
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1">
    <tbody>
        <tr>
		    <th width="8%">登录名</th>
		    <th width="13%">真实姓名</th>
		    <th width="7%">角色名</th>
		    <th width="13%">单位名称</th>
		    <th width="15%">上次登录时间</th>
		    <th width="15%">IP地址</th>
		    <th width="8%">操作</th>
        </tr>
	    <s:if test="null != page.beans && page.beans.size()>0">
	      <s:iterator value="page.beans" var="item" status="status">
			<tr <s:if test="#status.odd != true"> class="inter"</s:if>>		   
          		<td align="center" valign="top"><s:property value="#item.loginName"/></td>
          		<td align="center" valign="top"><s:property value="#item.realName"/></td>
          		<td align="center" valign="top"><s:property value="#item.roleInfo.roleName"/></td>
          		<td align="center" valign="top"><s:property value="#item.unitInfo.unitName"/></td>
          		<td align="center" valign="top">
          		    <font style="font-family:Courier New">
						<s:date name="#item.lastLogintime" format="yyyy-MM-dd HH:mm"/>
					</font>
          		</td>
             <td align="center" valign="top"><s:property value="#item.ip"/></td>
                <td align="center" valign="top">
                    <s:if test="#item.loginName == 'admin'">					   
			        </s:if>
			        <s:else>
			            <a href="javascript:void(0);" onclick="delete_user(<s:property value="#item.id"/>)">删除</a> 
			            &nbsp;&nbsp;
			            <a href="javascript:void(0);" onclick="reset_pwd(<s:property value="#item.id"/>)">重置密码</a> 
			        </s:else>
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
<!--页码-->
      <div class="page">
          <s:include value="../common/page.jsp" />
      </div>
      <div class="clear"></div>
</s:form>


</div>
</body>
</html>
