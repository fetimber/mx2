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
			
			.ui-selectmenu-button span.ui-selectmenu-text{
			line-height:22px;
			}
		</style>
		<script type="text/javascript">
			
			$(function() {
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
			<img src="resources/images/icon_home.png" width="20" height="20" />困难职工库&nbsp;>&nbsp;困难职工管理&nbsp;>&nbsp;困难员工详情
		</div>
		<s:form action="govworker!save_poor" namespace="/admin" method="post" id="base_frm">
		    <s:hidden name="worker.id" />
		    <s:hidden name="workerPoor.id" />
		    
			<div class="hid_files_div"></div>
		
			<table width="60%" border="0" cellspacing="0" cellpadding="0" class="tab_1" style="margin:40px 0 0 40px;float:left;">
				<tr>
					<td width="16%" align="right">
						姓名
					</td>
					<td width="84%">
						<s:textfield name="worker.workerName" cssClass="input_1 input_1_w validate[required,minSize[1],maxSize[100]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td width="16%" align="right">
						所属单位
					</td>
					<td width="84%">
						<s:if test="null == #session.userinfo_in_session.unitInfo">
						   <label for="number"></label>
						   <s:select id="unitList"  name="worker.unitId"  list="#request.units" headerKey="" headerValue="请选择单位" listKey="id" listValue="unitName" ></s:select>
						</s:if>
					   <s:else>
					      <s:property value="#session.userinfo_in_session.unitInfo.unitName"/>
					   </s:else>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						性别
					</td>
                    <td>
					    <label for="number"></label>
						<s:select  name="worker.workerSex"  list="#{'男':'男','女':'女'}"></s:select>
					  </td>
				      </tr>
			     <tr>
					<td align="right">
						年龄
					</td>
					<td>
					   <s:textfield name="worker.workerAge" cssClass="input_1 input_1_w validate[required,custom[number],min[16],max[100]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						身份证号
					</td>
					<td>
					   <s:textfield name="worker.workerIdnumber2" cssClass="input_1 input_1_w validate[required,minSize[10],maxSize[18],ajax[_ajax_id_card]]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						银行卡号
					</td>
					<td>
					   <s:textfield name="worker.bankCard2" cssClass="input_1 input_1_w validate[minSize[10],maxSize[20]]"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						家庭地址
					</td>
					<td>
					   <s:textfield name="worker.workerAddress" cssClass="input_1 input_1_w validate[required,maxSize[256]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						联系电话
					</td>
					<td>
					   <s:textfield name="worker.workerPhone" cssClass="input_1 input_1_w validate[custom[number]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
						
				<tr>
					<td align="right">
						备注荣誉
					</td>
					<td>
					   <s:textfield name="worker.honorRemark" cssClass="input_1 input_1_w"></s:textfield>&nbsp;&nbsp;
					</td>
				</tr>
				
				<tr>
					<td align="right">
						家庭人数
					</td>
					<td>
					   <s:textfield name="workerPoor.familyPeople" cssClass="input_1 input_1_w validate[custom[number]]"></s:textfield>&nbsp;&nbsp;
					</td>
				</tr>
				
				<tr>
					<td align="right">
						家庭年人均月收入
					</td>
					<td>
					   <s:textfield name="workerPoor.familyIncome" cssClass="input_1 input_1_w validate[custom[number]]"></s:textfield>&nbsp;&nbsp;元
					</td>
				</tr>
				
				
				
<!-- 					<tr> -->
<!-- 					<td align="right"> -->
<!-- 						填报单位 -->
<!-- 					</td> -->
<!-- 					<td> -->
<!-- 					   <s:textfield name="workerPoor.inUnit" cssClass="input_1 input_1_w"></s:textfield>&nbsp;&nbsp; -->
<!-- 					</td> -->
<!-- 				</tr> -->
				
<!-- 								<tr> -->
<!-- 					<td align="right"> -->
<!-- 						审核单位 -->
<!-- 					</td> -->
<!-- 					<td> -->
<!-- 					   <s:textfield name="workerPoor.checkUnit" cssClass="input_1 input_1_w"></s:textfield>&nbsp;&nbsp; -->
<!-- 					</td> -->
<!-- 				</tr> -->
				<tr>
					<td align="right">
						职工身份
					</td>
					<td>
					  <s:select  name="worker.workDuty"  list="#{'正式在职':'正式在职','劳务派遣':'劳务派遣','其他':'其他'}"></s:select>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						困难标准
					</td>
					<td>
					   <s:select  name="workerPoor.poorLevel"  list="#{'家庭人均收入低于当地居民最低生活保障线的困难职工家庭':'家庭人均收入低于当地居民最低生活保障线的困难职工家庭','家庭人均收入略高于低保标准但因一定原因导致生活困难的困难职工家庭':'家庭人均收入略高于低保标准但因一定原因导致生活困难的困难职工家庭','因意外事件、重大疾病、自然灾害等造成生活困难的职工家庭':'因意外事件、重大疾病、自然灾害等造成生活困难的职工家庭'}"></s:select>
					</td>
				</tr>

                  <tr>
					<td align="right">
						致困原因
					</td>
					<td>
					  <s:select  name="workerPoor.poorReason"  list="#{'因病':'因病','因灾':'因灾','其他':'其他'}"></s:select>
					  
					</td>
				</tr>

		       <tr>
					<td align="right">
						说明
					</td>
					<td>
					   <s:textfield name="workerPoor.changeMemo" cssClass="input_1 input_1_w"></s:textfield>&nbsp;&nbsp;
					</td>
				</tr>
				
				<tr>
					<td align="right">
						物资发放时间
					</td>
					<td>
						 <input name="workerPoor.sendTime" type="text" class="input_1 input_1_w timer" value="<s:date name="%{workerPoor.sendTime}" format="yyyy-MM-dd" />" />
					    &nbsp;&nbsp;<span style="color:red">*</span>
					</td>		
				</tr>
				
				<tr>
					<td align="right">
					   发放主管部门
					</td>
					<td>
					   <s:textfield name="workerPoor.sendDept" cssClass="input_1 input_1_w validate[required]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				
			    <tr>  
					<td align="right">
						物资
					</td>
					<td>
					   <s:textfield name="workerPoor.sendThing" cssClass="input_1 input_1_w validate[required]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				
          
				<tr>  
					<td align="right">
						发放记录
					</td>
					<td>  
					   <s:textarea cols="52" rows="20" name="workerPoor.sendRemark" ></s:textarea> 
					</td>
				</tr>
			
			 <tr>
			    <td align="right">&nbsp;</td>
			    <td height="60"> 
			    <input type="button" name="back" id="back" value="返回"  class="btn_tj btn_tj_w" onclick="history.go(-1)"/></td>
			  </tr>
			</table>

		</s:form>
		
	</body>
</html>