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
			
			$(function() {
			    $(".timer").datepicker({
					showSecond: true,
					timeFormat: 'hh:mm:ss',
					separator: ' ',
					autoSize: true
				});
				
				$("select").selectmenu({width:'440px'});
			
				$('#base_frm').validationEngine({
					addPromptClass: 'formError-white formError-small',
					promptPosition: 'centerRight: 10, +1',
					maxErrorsPerField: true,
					autoHideDelay: 3000
				});
			});
			
		</script>
	</head>
	<body>
		<div class="home">
			<img src="resources/images/icon_home.png" width="20" height="20" />系统设置&nbsp;>&nbsp;单位管理&nbsp;>&nbsp;
		    <s:if test="null == unit.id">
		                新增单位
		    </s:if>
		    <s:else>
		              修改单位
		    </s:else>

		</div>
		<s:form action="govunit!save" namespace="/admin" method="post" id="base_frm">
		   <s:hidden name="unit.id" />
		  
			<div class="hid_files_div"></div>
			
			<table width="60%" border="0" cellspacing="0" cellpadding="0" class="tab_1" style="margin:40px 0 0 40px;float:left;">
				<tr>
					<td width="16%" align="right">
						单位名称
					</td>
					<td width="84%">
					   <s:if test="null == unit.id">
						 <s:textfield name="unit.unitName" cssClass="input_1 input_1_w validate[required,minSize[1],maxSize[100],ajax[_ajax_unit_name]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					   </s:if>
					   <s:else>
					      <s:textfield name="unit.unitName" cssClass="input_1 input_1_w validate[required,minSize[1],maxSize[100]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>	 
					   </s:else>
					</td>
				</tr>
				<tr>
					<td align="right">
						&nbsp;
					</td>
					<td valign="top" style="padding-top:0;">
						<span class="f_gray">
							请输入单位的名称，4-100个字符，不限制符号
						</span>
					</td>
			  
				</tr>
					<tr>
					<td width="16%" align="right">
						负责人
					</td>
					<td width="84%">
						<s:textfield name="unitDuty" cssClass="input_1 input_1_w validate[required,minSize[1],maxSize[100]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						&nbsp;
					</td>
					<td valign="top" style="padding-top:0;">
						<span class="f_gray">
							请输入负责人姓名，4-100个字符
						</span>
					</td>
				</tr>
				
			   <tr>
					<td width="16%" align="right">
						 成立时间
					</td>
					<td width="84%">
					    <input name="joinTime" type="text" class="input_1 input_1_w timer" value="<s:date name="%{unit.joinTime}" format="yyyy-MM-dd" />" />&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				
								
				<tr>
					<td align="right">
						&nbsp;
					</td>
					<td valign="top" style="padding-top:0;">
						<span class="f_gray">
							请选择单位成立时间
						</span>
					</td>
				</tr>

				<tr>
					<td align="right">
						市级单位
					</td>
					<td>
					   <s:if test="null == #session.userinfo_in_session.cityInfo">
					     <label for="number"></label>
						 <s:select id="cityList"  name="unitCity"  list="#request.citys"  listKey="id" listValue="cityName" ></s:select>
					   </s:if>  
					   <s:else>
					      <s:property value="#session.userinfo_in_session.cityInfo.cityName"/>
					   </s:else>
					
					</td>
				</tr>
				<s:if test="null == #session.userinfo_in_session.cityInfo">
				<tr>
					<td align="right">
						&nbsp;
					</td>
					<td valign="top" style="padding-top:0;">
					    
						<span class="f_gray">
							选择市级单位，如果市级单位不在此列表中，请点击单位管理页面新增市级单位
						</span>
					</td>
				</tr>
			   </s:if>
				
			 <tr>
			    <td align="right">&nbsp;</td>
			    <td height="60"> 
			    
			    <s:if test="null == unit.id">
			        <input type="submit" name="button" id="save" value="提交"  class="btn_tj btn_tj_w"/>
			     </s:if>
			     <s:else>
			        <input type="submit" name="button" id="save" value="修改"  class="btn_tj btn_tj_w"/>
			     </s:else>
			     
			     <input type="button" name="back" id="back" value="返回"  class="btn_tj btn_tj_w" onclick="history.go(-1)"/></td>
		
			  </tr>
			</table>

		</s:form>
		
	</body>
</html>