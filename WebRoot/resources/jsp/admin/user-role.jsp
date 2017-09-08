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
		$("#rolesview").submit();
	}
	
	function delete_role(id){
	    var postParams = "role.id=" + id;
        $.dialog.confirm("是否确认删除", function(){
				$.post('admin/user!roledel', postParams ,function(data){
				    eval("data=" + data);
					if(data.result){  
					    $.dialog.tips('删除成功',2,'success.gif',function(){
					    	window.location.reload(true);
					    });

					} else {
						$.dialog.tips('更新失败',3,'error.gif');
					}
				});
		 }, function(){
			 $.dialog.tips('已取消操作',3,'alert.gif');
		 });
	}
	
	
	$(function(){ 
        $("#save").click(function() { 
               vaildFormSubmit();
	    });  
       	$("#role_form").validationEngine({
			addPromptClass: 'formError-white formError-small',
			promptPosition: 'centerRight: 25, +5', maxErrorsPerField: true,
			autoHidePrompt:true, autoHideDelay:3000, focusFirstField: false
        });
    });
    
    function vaildFormSubmit(){   
      if($("#role_form").validationEngine('validate')){	  	
	      $("#role_form").submit();		     
      }
   }
    var role = null;
    function auth(role_id,role_name){
    	role = role_id;
    	$.dialog({
    		title:'请选择角色[' + role_name + ']的菜单权限',
    		content:'url:admin/user!role_auth?role.id=' + role_id
    	});
    }
    function auth_ok(checked){
    	var param = '';
    	$.each(checked,function(idx,item){
    		param += item;
    		if(idx + 1 < checked.length);
    		param += ',';
    	});
    	$.get("admin/user!role_auth_save",{checked:param,"role.id":role},function(data){
    		eval("data="+data);
    		if(data.result){
    			$.dialog.tips("数据保存完成",2,'success.gif');
    		} else {
    			$.dialog.tips("数据保存失败，请稍后再试....",3,'error.gif');
    		}
    	});
    	return true;
    }
	</script>
</head>

<body>
<div class="home"><img src="resources/images/icon_home.png" width="20" height="20" />系统设置&nbsp;>&nbsp;权限管理</div>
<div class="m_w">
<!--后台用户-->
<div class="p_tpc">角色列表</div>
  <s:form action="user!role" namespace="/admin" method="POST" id="rolesview">
  <!--表格-->
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1">
    <tbody>
        <tr>
		    <th width="7%">角色名</th>
		    <th width="15%">描述</th>
		    <th width="8%">操作</th>
        </tr>
	    <s:if test="null != roleList && roleList.size()>0">
	      <s:iterator value="roleList" var="item" status="status">
			<tr <s:if test="#status.odd != true"> class="inter"</s:if>>		   
          		<td align="center" valign="top"><s:property value="#item.roleName"/></td>
          		<td align="center" valign="top"><s:property value="#item.description"/></td>

                <td align="center" valign="top">
                	<s:if test="#item.roleName != '管理员'"><a href="javascript:auth(<s:property value="#item.id"/>,'<s:property value="#item.roleName"/>')">菜单权限配置</a>&nbsp;&nbsp;
                	<a href="admin/user!role?role.id=<s:property value="#item.id"/>">修改</a>&nbsp;&nbsp;
					    <if test="#item.id > 9"><a href="javascript:void(0);" onclick="delete_role(<s:property value="#item.id"/>)">删除</a></if>
                	</s:if>
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

      <div class="clear"></div>
</s:form>

<div class="p1_tpc">新建及修改角色</div> 
       <s:form id="role_form" action="user!rolesave" namespace="/admin" method="post">
			 <s:hidden name="role.id" />
			 <div class="p1_cont p1_cont_p">		
					<table width="70%" border="0" cellspacing="0" cellpadding="0" class="tab_1">
						<tr>
							<td align="right">
								角色名：
							</td>
							<td>
								<s:textfield name="role.roleName" cssClass="input_1 input_2_w validate[required]" />&nbsp;&nbsp;
							</td>
						</tr>
						<tr>
							<td align="right">
							                描述：
							</td>
							<td>
							    <s:textfield name="role.description" cssClass="input_1 input_2_w" />&nbsp;&nbsp;								
							</td>
						</tr>
						
						
						<s:if test="null != #request.message">
							<tr height="30px">
								<td colspan="2">
									<span style="float:left;margin-left:180px"><font color="red"><s:property value="#request.message" /></font></span>
								</td>
							</tr>
						</s:if>
						 <tr>
						    <td>&nbsp;</td>
						    <td><input id="save" type="button" value="保存" class="btn_tj btn_w1" /></td>
						</tr>
					</table>
				</s:form>
         </div>
</div>
</body>
</html>
