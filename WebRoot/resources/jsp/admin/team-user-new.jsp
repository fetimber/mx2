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
		$("#teamsview").submit();
	}	
   
    function delete_team(id){
        var postParams = "callTeam.id=" + id;
        
        $.dialog.confirm("是否确认删除", function(){
				$.post('admin/team!delete', postParams ,function(data){
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
        $("#teamList").selectmenu(); 
        $("#userList").selectmenu();
        
        $("#save").click(function() { 
               vaildFormSubmit();
	    });  
     
       	$("#team_form").validationEngine({
			addPromptClass: 'formError-white formError-small',
			promptPosition: 'centerRight: 25, +5', maxErrorsPerField: true,
			autoHidePrompt:true, autoHideDelay:3000, focusFirstField: false
        });
   
        
        function vaildFormSubmit(){   
	      if($("#team_form").validationEngine('validate')){	 
	      			    
     		if("" == $("#teamList").val()){
		       $.dialog.tips('未选团队',3.0,'error.gif');
		       return false;
			} 
			 
			if("" == $("#userList").val()){
		       $.dialog.tips('未选队员',3.0,'error.gif');
		       return false;
			} 
			
		    $("#team_form").submit();     
			     
	      }
	   }
        
    });
  </script>
  
</head>

<body>
<div class="home"><img src="resources/images/icon_home.png" width="20" height="20" />Call客团队管理</div>
<div class="m_w">
<!--后台用户-->
<div class="p_tpc">成员管理</div>
<s:form action="team!user_new" namespace="/admin" method="POST" id="teamsview">
  <s:hidden name="page.current" />
  <s:hidden name="callUser.teamId" />
  <s:hidden name="callUser.id" />
  <!--表格-->
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1">
    <tbody>
        <tr>
		    <th width="8%">团队名称</th>
            <th width="13%">组员姓名</th>
            <th width="13%">联系方式</th>
            <th width="8%">待处理数</th>
            <th width="8%">操作</th>
        </tr>
	    <s:if test="null != page.beans && page.beans.size()>0">
	      <s:iterator value="page.beans" var="item" status="status">
			<tr <s:if test="#status.odd != true"> class="inter"</s:if>>		   
          		<td align="center" valign="top"><s:property value="#item.teamInfo.teamName"/></td>
          		<td align="center" valign="top"><s:property value="#item.userInfo.realName"/></td>
          		<td align="center" valign="top"><s:property value="#item.userInfo.phone"/></td>
          		<td align="center" valign="top"><s:property value="#item.customerDecimal"/></td>
                <td align="center" valign="top">
                   <a href="admin/team!user_new?callUser.teamId=<s:property value="#item.teamId"/>&callUser.id=<s:property value="#item.id"/>">修改</a>&nbsp;&nbsp;
			    </td>
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

<div class="p1_tpc">修改成员</div> 
       <s:form id="team_form" action="team!user_save" namespace="/admin" method="post">
		  <s:hidden name="callUser.id" />
			 <div class="p1_cont p1_cont_p">		
					
					<table width="70%" border="0" cellspacing="0" cellpadding="0" class="tab_1">
						<tr>
							<td align="right">
								所属团队
							</td>
							<td>
							    <label for="number"></label>
								<s:select id="teamList" headerKey="" headerValue="请选择团队" list="teamList" name="callUser.teamId" listKey="id" listValue="teamName" cssClass="sel_02 validate[required]" />
							</td>
						</tr>
						<tr>
							<td align="right">
								团队成员
							</td>
							<td>
							    <label for="number"></label>
								<s:select id="userList" headerKey="" headerValue="请选择成员" list="userList" name="callUser.userId" listKey="id" listValue="realName" cssClass="sel_02 validate[required]" />
							</td>
						</tr>
						
						<tr>
							<td align="right">
								待处理数
							</td>
							<td>
								<s:textfield name="callUser.customerDecimal" cssClass="input_1 input_2_w validate[number]" />&nbsp;&nbsp;
							</td>
						</tr>					
						<s:if test="null != #request.message">
							<tr height="30px">
								<td colspan="2">
									<span style="float:left;margin-left:232px"><font color="red"><s:property value="#request.message" /></font></span>
								</td>
							</tr>
						</s:if>
						 <tr>
						    <td>&nbsp;</td>
						    <td><input id="save" type="button" value="保存" class="btn_tj btn_w1" /></td>
						</tr>
					</table>
					
			       <div class="page">
			          <s:include value="../common/page.jsp" />
			      </div>
                  <div class="clear"></div>
                  
				</s:form>
         </div>
</div>
</body>
</html>
