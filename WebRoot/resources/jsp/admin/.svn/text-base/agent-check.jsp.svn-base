<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<s:include value="../common/meta.jsp" />
		<style type="text/css">
			.tab_1 td {font-family:'Courier New','微软雅黑';line-height: 34px}
			.tab_1 tr {height:34px;}
			.input_1 {font-family:'Courier New','微软雅黑';width:230px}
		</style>
		<script type="text/javascript">
			$(function() {
				$("select").selectmenu({width:'242px'});

				$("#save").click(function() {
					vaildFormSubmit();
				});

				$("#agent_form").validationEngine({
					addPromptClass: 'formError-white formError-small',
					promptPosition: 'topLeft',
					maxErrorsPerField: true,
					autoHidePrompt: true,
					autoHideDelay: 3000,
					focusFirstField: false
				});
				$(".timer").datepicker({ showButtonPanel:true });
			});
			function select_id_pic(){
				selected_idx = 1;
				$.dialog({
					title:'请选择身份证图片',
					width:600,
					height:400,
					icon:'loading.gif',
					content:'url:admin/agent!load_pic?agentUser.userId=<s:property value="agentUser.userId" />'
				});
			}
			function select_name_pic(){
				selected_idx = 2;
				$.dialog({
					title:'请选择身份证图片',
					width:600,
					height:400,
					icon:'loading.gif',
					content:'url:admin/agent!load_pic?agentUser.userId=<s:property value="agentUser.userId" />'
				});
			}
			var selected_idx;
			function set_pic(file_id,pic_path){
				if(selected_idx == 1){
					$("input:hidden[name='agentUser.cardFileid']").val(file_id);
				} else if(selected_idx == 2){
					$("input:hidden[name='agentUser.idtFileid']").val(file_id);
				}
				$(".pic_select_" + selected_idx).attr("src",pic_path).unbind("load").bind("load",function(){
					AutoResizeImage(400,300,this);
				});
			}
			function validate(result){
				$("input:hidden[name='agentUser.realNameValidate']").val(result);
				$("#agent_form").submit();
			}
		</script>
	</head>
	<body style="min-width: 1700px;">
		<div class="home">
			<img src="resources/images/icon_home.png" width="20" height="20" />数据管理&nbsp;>&nbsp;经纪人管理&nbsp;>&nbsp;经纪人审核
		</div>
		<div class="m_w">
			<!--后台用户-->
			<s:form id="agent_form" action="agent!confirm" namespace="/admin" method="post">
				<s:hidden name="agentUser.id" />
				<s:hidden name="agentUser.user.id" />
				<s:hidden name="agentUser.cardFileid" />
				<s:hidden name="agentUser.idtFileid" />
				<s:hidden name="agentUser.referId" />
				<s:hidden name="agentUser.accountId" />
				<s:hidden name="agentUser.realNameValidate"/>
				<div class="p1_tpc">
					经纪人信息
					<s:if test="agentUser.realNameValidate == 0 || agentUser.realNameValidate == null">
					<input id="savebtn" type="button" value="审核通过" class="btn_search" style="margin-left:200px;" onclick="validate(1)"/>
					<input id="savebtn" type="button" value="审核拒绝" class="btn_search" style="margin-left:200px;" onclick="validate(0)"/>
					<input id="savebtn" type="button" value="保存修改" class="btn_search" style="margin-left:200px;" onclick="validate(0)"/>
					</s:if>
					<s:else>
					<input id="savebtn" type="button" value="保存修改" class="btn_search" style="margin-left:300px;" onclick="validate(2)"/>
					</s:else>
					<input id="savebtn" type="submit" style="display:none"/>
				</div>
				<div class="p1_cont p1_cont_p">
					<table style="width: 95%; margin-left: 15px ;min-width: 1660px" border="0" cellspacing="0" cellpadding="0" class="tab_1">
						<tr>
							<td width="10%" align="right" class="gray">
								姓名：
							</td>
							<td width="25%" align="left">
								<s:property value="agentUser.user.realName" />
							</td>
							<td width="10%" align="right" class="gray">
								电话：
							</td>
							<td width="25%" align="left">
								<s:property value="agentUser.phoneDecimal" />
							</td>
							<td width="10%" align="right" class="gray">
								注册时间：
							</td>
							<td align="left">
								<s:date name="agentUser.user.createTime" format="yyyy-MM-dd HH:mm" />
							</td>
						</tr>
						<tr>
							<td align="right" class="gray">
								认证状态：
							</td>
							<td align="left">
								<s:if test="agentUser.realNameValidate > 0">已认证</s:if><s:else>未认证</s:else>
							</td>
							<td align="right" class="gray">
								推荐客户数：
							</td>
							<td align="left">
								<s:property value="agentUser.customerCount" />
							</td>
							<td align="right" class="gray">
								最近登录时间：
							</td>
							<td align="left">
								<s:date name="agentUser.user.lastLogintime" format="yyyy-MM-dd HH:mm" />
							</td>
						</tr>
						<tr>
							<td align="right" class="gray">
								最近一次交互处理时间：
							</td>
							<td align="left">
								<input name="agentUser.dealTime" value="<s:date name="%{agentUser.dealTime}" format="yyyy-MM-dd" />" class="input_1 timer" alt="格式:2015-03-04" readonly="readonly" />
							</td>
							<td align="right" class="gray">
								最后一次交互处理结果：
							</td>
							<td align="left">
								<s:textfield name="agentUser.dealContent" cssClass="input_1 validate[maxSize[200]]" />
							</td>
							<td align="right" class="gray">
								经纪人维护人：
							</td>
							<td align="left">
								<s:textfield name="agentUser.agentPerson" cssClass="input_1 validate[maxSize[5]]" />
							</td>
						</tr>
					    <tr>
							<td align="right" class="gray">
								最新跟进信息：
							</td>
							<td align="left" colspan="6">
								<s:iterator value="agentUser.records" var="item" status="st">
									<s:property value="#item.user.realName" />&nbsp;在&nbsp;<s:date name="%{#item.operateTime}" format="yyyy-MM-dd HH:mm" />&nbsp;进行操作：&nbsp;
									<s:property value="#item.operateContent" /><br />
								</s:iterator>
							</td>
					    </tr>
						
						<tr>
							<td align="right" class="gray">
								维护人号码：
							</td>
							<td align="left">
								<s:textfield name="agentUser.personPhone" cssClass="input_1 validate[custom[phone]]" />
							</td>
							<td align="right" class="gray">
								下次回访日期设定：
							</td>
							<td align="left">
								<input name="agentUser.nextTime" value="<s:date name="%{agentUser.nextTime}" format="yyyy-MM-dd" />"  class="input_1 timer" />
							</td>
							<td align="right" class="gray">
								经纪人分组：
							</td>
							<td align="left">
								<s:textfield name="agentUser.agentGroup" cssClass="input_1 validate[maxSize[5]]" />
							</td>
						</tr>
						<tr>
							<td align="right" class="gray">
								经纪人微信昵称：
							</td>
							<td align="left">
								<s:textfield name="agentUser.user.nickName" cssClass="input_1 validate[maxSize[20]]" />
							</td>
							<td align="right" class="gray">
								经纪人姓名：
							</td>
							<td align="left">
								<s:textfield name="agentUser.user.realName" cssClass="input_1 validate[maxSize[5]]" />
							</td>
							<td align="right" class="gray">
								所属门店或楼盘：
							</td>
							<td align="left">
								<s:textfield name="agentUser.workSpace" cssClass="input_1 validate[maxSize[40]]" />
							</td>
						</tr>
						<tr>
							<td align="right" class="gray">
								经纪人来源：
							</td>
							<td align="left">
								<s:select name="agentUser.source" list="#{'':'请选择',1:'自主注册',2:'推荐注册',3:'线下推广',4:'其他方式' }" />
							</td>
							<td align="right" class="gray">
								经纪人所属区域：
							</td>
							<td align="left" colspan="3">
								<s:textfield name="agentUser.workArea" cssClass="input_1 validate[maxSize[40]]" />
							</td>
						</tr>
					    <tr>
							<td align="right" class="gray">
								身份证号：
							</td>
							<td align="left">
								<s:textfield name="agentUser.idtNum" cssClass="input_1 validate[maxSize[40]]" />
							</td>
							<td align="right" class="gray">
								开户银行：
							</td>
							<td align="left">
								<s:textfield name="agentUser.bankName" cssClass="input_1 validate[maxSize[40]]" />
							</td>
							<td align="right" class="gray">
								银行卡号：
							</td>
							<td align="left">
								<s:textfield name="agentUser.bankAccount" cssClass="input_1 validate[maxSize[40]]" />
							</td>
						</tr>
						<tr>
							<td align="right" class="gray">
								身份证图片：
							</td>
							<td align="left" style="overflow: hidden">
								<img src="<s:property value="%{null == agentUser.idtFileInfo.filePath || agentUser.idtFileInfo.filePath == '' ? 'resources/images/select_pig.png' : agentUser.idtFileInfo.filePath}" default="resources/images/select_pig.png" />" alt="" onclick="select_id_pic(1)" class="pic_select_1" onload="AutoResizeImage(400,300,this);" />
							</td>
							<td align="right" class="gray">
								名片图片：
							</td>
							<td align="left" colspan="3" style="overflow: hidden;">
								<img src="<s:property value="%{null == agentUser.cardFileInfo.filePath || agentUser.cardFileInfo.filePath == '' ? 'resources/images/select_pig.png' : agentUser.cardFileInfo.filePath}" default="resources/images/select_pig.png" />" alt="" onclick="select_name_pic(2)" class="pic_select_2" onload="AutoResizeImage(400,300,this);"/>
							</td>
						</tr>
					</table>
				</div>
			</s:form>
		</div>
	</body>
</html>
