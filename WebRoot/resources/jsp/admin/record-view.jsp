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
		     .input_1{width:160px;}
			.tab1 td{font-family: "Courier New","微软雅黑"}
			#base_frm_project_area-button{height: 30px;margin-left: 15px;}
			.tab1 td{font-family:'Courier New','微软雅黑'}
			.ui-selectmenu-button span.ui-selectmenu-text{
			line-height:22px;
			}
		</style>
		<script type="text/javascript">
		    var flag = false;
			$(function(){
					$(".timer").datepicker({
					showSecond: true,
					timeFormat: 'hh:mm:ss',
					separator: ' ',
					autoSize: true
				});
				$("select").selectmenu({width:"110px"});
				
				$(".importexcel").bind("click",function(){
					$("#upload_btn_1").trigger("click");
				});
				
				_init_upload(1);
			});
			
			function _forward_page(page){
			    var workPoorId = $('#workPoorId').val();
			    $("#base_frm").attr('action','admin/record!view?record.workPoorId='+ workPoorId);
				$("#page_current").val(page);
				$("#base_frm").submit();
			}
			
			function _forward_add(){
			    //alert($('#workPoorId').val());
			    var workPoorId = $('#workPoorId').val();
			    location.href='admin/record!add?record.workPoorId=' + workPoorId;
			}
			
			
			function exportData(){
				$("#base_frm").attr('action','admin/govhonorunit!export');
				$("#base_frm").submit();
			}
			
			function _init_upload(idx){
				$("#upload_btn_" + idx).bind("change",function(){
					var dialog = $.dialog({
					    icon: 'loading.gif',
					    titleIcon: 'lhgcore.gif',
					    content: '正在导入数据，请稍候....'
					});
					$.ajaxFileUpload({
						url: 'admin/upload!excel',
						//用于文件上传的服务器端请求地址
						secureuri: false,
						//是否需要安全协议，一般设置为false
						data: {
							createMedia: false,
							saveFile:true,
							fileType:99
						},
						fileElementId: 'upload_btn_' + idx,
						//文件上传域的ID
						dataType: 'json',
						//返回值类型 一般设置为json
						success: function(data) { //服务器成功响应处理函数
							dialog.close();
							if (data.result) {
							   $.dialog.tips("文件导入成功 ",2,'success.gif',function(){
							   });
							   window.location.reload(true);
							} else {
								$.dialog.tips("文件导入失败，请使用模板填写正确 再上传....", 3, "error.gif");
							    window.location.reload(true);
							}
							
						},
						error: function(data, status, e) { //服务器响应失败处理函数
							dialog.close();
							$.dialog.tips("文件导入失败，请稍候再试....", 2, "error.gif");
						}
					});
				});
			}		
			
			function delete_record(id){
			    $.dialog.confirm("你确定要删除此发放信息吗？<br /><br />删除后，将不再显示此信息，请谨慎操作。", function(){
				   $.get("admin/record!delete",{"record.id":id},function(data){
					   eval("data=" + data);
					   if(data.result){
						   $.dialog.tips("数据操作成功",2,'success.gif',function(){
							   window.location.reload(true);
						   });
					   } else {
						   $.dialog.tips("服务器繁忙，数据操作失败，请稍后再试",2,'error.gif');
					   }
				   });
				});
			}
			
			function checkHonor(honorrid,name,flag){
			     var tip = "你确定要审核";
			     var checkflag = "";
			     if(flag == "pass"){
			        tip += "通过";
			        checkflag = "1";
			     }else{
			        tip += "拒绝";
			        checkflag = "2";
			     }
			     tip += " 单位荣誉 [" + name + "]吗？<br /><br />";
			     
			     
			     $.dialog.confirm(tip, function(){
				   $.get("admin/govhonor!check",{"honor.id":honorrid,"honor.checkFlag":checkflag},function(data){
					   eval("data=" + data);
					   if(data.result){
						        $.dialog.tips("审核操作成功",2,'success.gif',function(){
							    window.location.reload(true);
						   });
					   } else {
						   $.dialog.tips("服务器繁忙，数据操作失败，请稍后再试",2,'error.gif');
					   }
				   });
				});
			}
		</script>
	</head>
	<body>
		<div class="home">
			<img src="resources/images/icon_home.png" width="20" height="20" />
			困难职工库&nbsp;>&nbsp;困难职工管理&nbsp;>&nbsp;发放记录管理
		</div>
		<div class="m_w">
<!-- 		    <div class="p_tpc" onclick="showSearch();" style="cursor: pointer;">搜索条件:</div> -->
			<!--检索部分-->
			<s:form action="record!view" namespace="/admin" id="base_frm">
			<s:hidden name="query.workPoorId" id="workPoorId"></s:hidden>
			<s:hidden name="page.current" id="page_current"></s:hidden>
			  <div class="tab_check"  id="search" >
				 <s:textfield name="query.keyword" cssClass="auto_tips" alt="现金、物资折合人民币、发放部门、物品、备注" style="margin-top:-2px;width:300px;border:1px solid #aaa;height:29px;line-height:29px;padding:1px 5px;margin-left:14px;"></s:textfield>
				 <input  type="button" value="搜索" class="btn_search" style="margin-left:10px;margin-top:-3px;" onclick="_forward_page(1)"/>
				 <input  type="button" value="新增" class="btn_search" style="margin-left:10px;margin-top:-3px;" onclick="_forward_add()"/>	  
			  </div>
			</s:form>
	
			<!--表格-->
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1">
				<tr>
					<th width="5%">
						序号
					</th>
					<th width="10%">
						现金
					</th>
					<th width="20%">
					           物资折合人民币
					</th>
					<th width="15%">
						发放部门
					</th>
					<th width="15%">
						发放物品
					</th>
					<th width="10%">
						发放时间
					</th>
					<th width="10%">
						发放备注
					</th>
					<th width="15%">
						操作
					</th>
				</tr>
				<s:if test="null != page.beans && page.beans.size()>0">
				<s:iterator value="#request.page.beans" var="item" status="st">
					<tr <s:if test="#st.even">class="inter"</s:if>>
						<td align="center" valign="top">
							<s:property value="%{#request.page.start + #st.count}" />
						</td>
						<td align="center" valign="top">
							<s:property value="#item.goodsCash" />
						</td>
						<td align="center" valign="top">
							<s:property value="#item.goodsValue" />
						</td>
						<td align="center" valign="top">
							<s:property value="#item.sendDept" />
						</td>
						<td align="center" valign="top">
							<s:property value="#item.sendThing" />
						</td>
						<td align="center" valign="top">
							<s:date name="#item.sendTime" format="yyyy-MM-dd" />
						</td>
						<td align="center" valign="top">
							<s:property value="#item.sendRemark" />
						</td>

						<td align="center" valign="top">
                              <a href="admin/record!detail?record.id=<s:property value="#item.id" />">详情</a>
                          |   <a href="javascript:delete_record(<s:property value="#item.id" />)">删除</a>			
						</td>

					</tr>
				</s:iterator>
				</s:if>
					<s:else>
						<tr>
							<td colspan="11" align="center">
								<font style="color:#ff671c;">
									没查询到您想要的数据信息！！
								</font>
							</td>
						</tr>
					</s:else>
			</table>
			<!--页码-->
			<div class="page">
			<s:include value="../common/page.jsp"></s:include>
			</div>
		</div>
		
		<div style="width:1px;height:1px;filter:alpha(opacity=0);-moz-opacity:0;-khtml-opacity:0;opacity:0;">
			<s:file id="upload_btn_1" name="upload" />
		</div>
		
	</body>
</html>