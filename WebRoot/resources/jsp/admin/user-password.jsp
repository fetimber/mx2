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
		</style>
		<script type="text/javascript">
			
			$(function() {
			    $('#newPassword').val('');
			    $('#oldPassword').val('');
			   
				$('#base_frm').validationEngine({
					addPromptClass: 'formError-white formError-small',
					promptPosition: 'centerRight: 10, +1',
					maxErrorsPerField: true,
					autoHideDelay: 3000
				});
				
				$("select").selectmenu({width:'440px'});

	          	$("#save").click(function() { 
                   vaildFormSubmit();
	           });  
	           function CheckPassWord(password) {//密码必须包含数字和字母
				    var str = password;
				    if (str == null || str.length < 8) {
				        return false;
				    }
				    var reg = new RegExp(/^(?![^a-zA-Z]+$)(?!\D+$)/);
				    if (reg.test(str))
				        return true;
				}
				
	           function valijs(now){
			    var re = new RegExp("[a-zA-Z]");
			    var len=re.test(now);
			    re = new RegExp("[0-9]");
			    len=re.test(now);
			    re = new RegExp("((?=[\x21-\x7e]+)[^A-Za-z0-9])");
			    //re = new RegExp("^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\W_]+$)(?![a-z0-9]+$)(?![a-z\W_]+$)(?![0-9\W_]+$)[a-zA-Z0-9\W_]{8,}$");
			    len=re.test(now);
			    if(len){
			        return true;
			    }
		
			    $.dialog.tips('密码强度不符合,请重新输入',2.0,'error.gif');
			    return false;
			}
	           
     
		        function vaildFormSubmit(){
		            
		            if(!CheckPassWord($('#newPassword').val())){
		               if(!valijs($('#newPassword').val())){
		                 return false;
		               }
		            }
		        
		           
		            
		           if($('#newPassword').val() == ''){
		              $.dialog.tips('请输入密码',2.0,'error.gif');
		              return false;
		           }
		           
		            if($('#oldPassword').val() == ''){
		              $.dialog.tips('请输入确认密码',2.0,'error.gif');
		              return false;
		           }
		           
		           if($('#newPassword').val() != $('#oldPassword').val()){
		              $.dialog.tips('两次输入的密码不一致',2.0,'error.gif');
		              return false;
		           }
		           
		            var postParams = "newPassword=" + $('#newPassword').val() + "&oldPassword=" + $('#oldPassword').val();
			        $.dialog.confirm("确认是否修改密码", function(){
							$.post('admin/user!save_password', postParams ,function(data){
							    eval("data=" + data);
								if(data.result){
								    $.dialog.tips('修改成功',2,'success.gif',function(){
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
			});
			
		</script>
	</head>
	<body>
		<div class="home"><img src="resources/images/icon_home.png" width="20" height="20" />系统设置&nbsp;>&nbsp;个人设置</div>
		
		<s:form action="user!save_password" namespace="/admin" method="post" id="base_frm">
		 
			<div class="hid_files_div">
			
			</div>
			
			<table width="60%" border="0" cellspacing="0" cellpadding="0" class="tab_1" style="margin:40px 0 0 40px;float:left;">
				<tr>
					<td width="16%" align="right">
						新密码
					</td>
					<td width="84%">
						 <s:password id="newPassword" name="newPassword" cssClass="input_1 input_1_w validate[minSize[8]]" />&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						&nbsp;
					</td>
					<td valign="top" style="padding-top:0;">
						<span class="f_gray">
							请输入新密码,不得小于8位,且必须由数字、字母或特殊字符组成
						</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						确认密码
					</td>
					<td>
						 <s:password id="oldPassword" name="oldPassword" cssClass="input_1 input_1_w validate[minSize[6]]" />&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						&nbsp;
					</td>
					<td valign="top" style="padding-top:0;">
						<span class="f_gray">
							请再次输入密码
						</span>
					</td>
				</tr>
			 <tr>
			    <td align="right">&nbsp;</td>
			    <td height="60"> 
			    <input type="button" name="button" id="save" value="提交"  class="btn_tj btn_tj_w"/></td>
			  </tr>
			</table>

		</s:form>
		
	</body>
</html>