<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<s:include value="../common/meta.jsp" />
		<style type="text/css">
			* {font-family:"Courier New","微软雅黑"}
			.tab1 td{text-align: center;border:1px solid #e0e0e0;}
		</style>
		<script type="text/javascript">
			$(function() {
				$('#base_frm').validationEngine({
					addPromptClass: 'formError-white formError-small',
					promptPosition: 'centerRight: 10, +5',
					maxErrorsPerField: true,
					autoHideDelay: 3000
				})
				$(".tab1 tr").each(function(idx){
					$(this).find("td:eq(0)").text(idx); 
				});
			});
			function update(old_url,new_url){
				$.post("admin/config!setting_menu_save",{old_url:old_url,new_url:new_url},function(data){
					eval("data="+data);
					if(data.result){
						$.dialog.tips("微信菜单信息已更新完成.",2,'success.gif',function(){
							window.location.reload(true);
						})
					} else {
						$.dialog.tips("微信菜单更新失败.",'2','error.gif');
					}
				});
			}
			function replace_new(name,old_url){
				$.dialog.prompt('请输入菜单[' + name + ']的回调地址:',
				    function(new_url){
						update(old_url,new_url);
				    },
				    old_url
				);
			}
		</script>
	</head>
	<body>
		<div class="home">
			<img src="resources/images/icon_home.png" width="20" height="20" />微信设置&nbsp;>&nbsp;菜单设置
		</div>
		<div class="m_w">
			<div class="ar_p1">
				<img src="resources/images/icon_1.png" width="36" height="36" class="ar_img1" />
				<div class="ar_txt1">
					<p>
						菜单设置可能会影响整个微信平台的使用，请谨慎操作
					</p>
					<p>
						<font color="#999">
							菜单数据更新到微信平台后，需要24小时的刷新时间，您可能不会立即看到改变后的数据。可通过取消关注和重新关注来解决此问题
						</font>
					</p>
				</div>
				<div class="clear"></div>
			</div>
			<br />
			<table width="1290" border="0" cellspacing="0" cellpadding="0" class="tab1" style="min-width:1280px">
				<tr>
					<th width="6%">
						序号
					</th>
					<th width="12%">
						一级菜单
					</th>
					<th width="12%">
						二级菜单
					</th>
					<th width="8%">
						菜单类型
					</th>
					<th>
						菜单值
					</th>
					<th width="8%">
						OpenId
					</th>
					<th width="12%">
						操作
					</th>
				</tr>
				<s:iterator value="#request.menus" var="item" status="st">
					<tr>
						<td><s:property value="#st.count" /></td>
						<s:if test="#item.hasSub()">
							<td rowspan="<s:property value="#item.sub_button.size()"/>"><s:property value="#item.name" /></td>
							<td><s:property value="#item.sub_button.get(0).name" /></td>
							<td><s:property value="%{#item.sub_button.get(0).type == 'view' ? '跳转链接' : '按钮事件'}" /></td>
							<td><s:property value="#item.sub_button.get(0).url" /></td>
							<td><s:property value="%{#item.sub_button.get(0).openId ? '需要授权':'无需授权'}" /></td>
							<td><a href="javascript:replace_new('<s:property value="#item.sub_button.get(0).name" />','<s:property value="#item.sub_button.get(0).url" />')">修改</a></td>
						</s:if>
						<s:else>
							<td><s:property value="#item.name" /></td>
							<td>--</td>
							<td><s:property value="%{#item.type == 'view' ? '跳转链接' : '按钮事件'}" /></td>
							<td><s:property value="#item.url" /></td>
							<td><s:property value="%{#item.openId ? '需要授权':'无需授权'}" /></td>
							<td><a href="javascript:replace_new('<s:property value="#item.name" />','<s:property value="#item.url" />')">修改</a></td>
						</s:else>
					</tr>
					<s:if test="#item.hasSub()">
						<s:iterator value="#item.sub_button" var="sub_item" status="stt">
							<s:if test="!#stt.first">
								<tr>
									<td><s:property value="#stt.count" /></td>
									<td><s:property value="#sub_item.name" /></td>
									<td><s:property value="%{#sub_item.type == 'view' ? '跳转链接' : '按钮事件'}" /></td>
									<td><s:property value="#sub_item.url" /></td>
									<td><s:property value="%{openId ? '需要授权':'无需授权'}" /></td>
									<td>
										<a href="javascript:replace_new('<s:property value="#sub_item.name" />','<s:property value="#sub_item.url" />')">修改</a>
									</td>
								</tr>
							</s:if>
						</s:iterator>
					</s:if>
				</s:iterator>
			</table>
		</div>
	</body>
</html>