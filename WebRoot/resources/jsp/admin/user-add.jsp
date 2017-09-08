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
		<script type="text/javascript" src="resources/js/ajaxfileupload.js"></script>
		<style type="text/css">
			* {font-family:"Courier New","微软雅黑"}
			.hasDatepicker{font-family:'Courier New','微软雅黑'}
			.ui-datepicker-calendar * {font-family:'Courier New','微软雅黑'}
			.btn_tj_w{
				width:218px;
			}
		</style>
		<script type="text/javascript">
			
		$(function(){
	     $("select").selectmenu({width:'440px'});
       
	     $("#roleList").selectmenu({change: _roleList_change});
	    _roleList_change();
     
       
        $("#save").click(function() { 
               vaildFormSubmit();
	    });  
     
       	$("#user_form").validationEngine({
			addPromptClass: 'formError-white formError-small',
			promptPosition: 'centerRight: 25, +5', maxErrorsPerField: true,
			autoHidePrompt:true, autoHideDelay:3000, focusFirstField: false
        });
   
        function _roleList_change(){
          if($("#roleList").val() == "1"){//管理员
             $("#city").hide();
             $("#unit").hide(); 
          }else if($("#roleList").val() == "11"){//省级
             $("#city").hide();
             $("#unit").hide(); 
          }else if($("#roleList").val() == "12"){//市级
             $("#city").show();
             $("#unit").hide();          
          }else if($("#roleList").val() == "13"){//
             $("#city").hide();
             $("#unit").show(); 
          }else{
             $("#city").show();
             $("#unit").show(); 
          }
        }
        
        
        function vaildFormSubmit(){   
	      if($("#user_form").validationEngine('validate')){	 
	      			       
			if("" == $("#roleList").val()){
		       $.dialog.tips('未选择角色',3.0,'error.gif');
		       return false;
			}  
			
			if($("#roleList").val() != $("#levelList").val() ){
			   $.dialog.tips('角色名与用户级别不一致',3.0,'error.gif');
		       return false;
			}
			
		    $("#user_form").submit();		     
	      }
	   }
        
    });
			
		</script>
	</head>
	<body>
		<div class="home">
			<img src="resources/images/icon_home.png" width="20" height="20" />系统设置&nbsp;>&nbsp;用户管理&nbsp;>&nbsp;
			<s:if test="null == user || null== user.id">
		     	新增后台用户
			</s:if>
			<s:else>
			          修改后台用户
			</s:else>	
		</div>
		
		 <s:form id="user_form" action="user!save" namespace="/admin" method="post">
			 <s:hidden name="user.id" />
			 <div class="hid_files_div">
			
			</div>		
					<table width="60%" border="0" cellspacing="0" cellpadding="0" class="tab_1" style="margin:40px 0 0 40px;float:left;">
						  <tr>
						    <td width="16%" align="right">角色名：</td>
						   <td width="84%">
								<label for="number"></label>
	
	                            <s:if test="12 == #session.userinfo_in_session.roleId">
								  <s:select id="roleList" headerKey="" headerValue="请选择角色" list="roleList" disabled="true" name="user.roleId" listKey="id" listValue="roleName"  cssClass="sel_02 validate[required]" />&nbsp;&nbsp;<span style="color:red">*</span>
							    </s:if>
							    <s:if test="12 != #session.userinfo_in_session.roleId">
								  <s:select id="roleList" headerKey="" headerValue="请选择角色" list="roleList" name="user.roleId" listKey="id" listValue="roleName"  cssClass="sel_02 validate[required]" />&nbsp;&nbsp;<span style="color:red">*</span>
							    </s:if>
							
							</td> 
						  </tr>
						  
						  <tr>
						    <td align="right">用户级别：</td>
						    <td>
						       <s:if test="12 == #session.userinfo_in_session.roleId">
								  <s:select id="levelList" headerKey="" disabled="true"  headerValue="请选择用户级别" list="levelList" name="user.userLevel" listKey="configKey" listValue="configName" cssClass="sel_02 validate[required]" readOnly="true"/>&nbsp;&nbsp;<span style="color:red">*</span>
                                </s:if> 
                                <s:if test="12 != #session.userinfo_in_session.roleId">
								  <s:select id="levelList" headerKey=""  headerValue="请选择用户级别" list="levelList" name="user.userLevel" listKey="configKey" listValue="configName" cssClass="sel_02 validate[required]" readOnly="true"/>&nbsp;&nbsp;<span style="color:red">*</span>
                                </s:if> 
							</td> 
						  </tr>
						  
						<tr id="city">
						    <td align="right">市级单位：</td>
						    <td>
						       <s:if test="null == #session.userinfo_in_session.cityInfo">
								  <label for="number"></label>
								  <s:select id="cityList" headerKey="" headerValue="请选择市级单位" list="cityList" name="user.cityId" listKey="id" listValue="cityName" cssClass="sel_02 validate[required]" />		
							   </s:if>
							   <s:else>
							      <s:property value="#session.userinfo_in_session.cityInfo.cityName"/>
							   </s:else>
							</td> 
						  </tr>
						  
						  
						  <tr id="unit">
						    <td align="right">单位名称：</td>
						    <td>
								<label for="number"></label>
								<s:select id="unitList" headerKey="" headerValue="请选择单位" list="unitList" name="user.unitId" listKey="id" listValue="unitName" cssClass="sel_02" />
							</td> 
						  </tr>
						<tr>
							<td align="right">
								登录名：
							</td>
							<td>
							   <s:if test="null == user || null == user.id">
							       <s:textfield name="user.loginName" cssClass="input_1 input_1_w validate[required,ajax[_ajax_login_name]]" />&nbsp;&nbsp;<span style="color:red">*</span>	
							   </s:if>
							   <s:else>
							       <s:property value="user.loginName"/>
							   </s:else>
							   
							</td>
						</tr>
						<tr>
							<td align="right">
							                真实姓名：
							</td>
							<td>
							    <s:textfield name="user.realName" cssClass="input_1 input_1_w validate[required]" />&nbsp;&nbsp;<span style="color:red">*</span>								
							</td>
						</tr>
						<tr>
							<td align="right">密码： </td>
							<td>
								 <s:password name="user.pwdCode" cssClass="input_1 input_1_w validate[minSize[6]]" />&nbsp;&nbsp;<span style="color:red">*</span>
							</td>
				       </tr>
				       <tr>
							<td align="right">手机号码： </td>
							<td>
								 <s:textfield name="user.phone" cssClass="input_1 input_1_w validate[required,minSize[11]]" />&nbsp;&nbsp;<span style="color:red">*</span>
							</td>
				       </tr>

						
						<s:if test="null != #request.message">
							<tr height="30px">
								<td colspan="2">
									<span style="float:left;margin-left:192px"><font color="red"><s:property value="#request.message" /></font></span>
								</td>
							</tr>
						</s:if>
						 <tr>
						    <td>&nbsp;</td>
						    <td>  
						    <s:if test="null == user || null == user.id">
						     	<input type="submit" name="button" id="save" value="提交"  class="btn_tj btn_tj_w"/>
							</s:if>
							<s:else>
							    <input type="submit" name="button" id="save" value="修改"  class="btn_tj btn_tj_w"/>
							</s:else>
			                
			                <input type="button" name="back" id="back" value="返回"  class="btn_tj btn_tj_w" onclick="history.go(-1)"/>
		                </td>
						</tr>
					</table>
				</s:form>
		
		
	</body>
</html>