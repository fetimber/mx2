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
			window.UEDITOR_HOME_URL = "resources/js/ueditor/";
		</script>
		<script type="text/javascript" src="resources/js/ajaxfileupload.js"></script>
		<script type="text/javascript" charset="utf-8" src="resources/js/ueditor/ueditor.config.js"></script>
		<script type="text/javascript" charset="utf-8" src="resources/js/ueditor/ueditor.all.min.js"> </script>
		<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
		<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
		<script type="text/javascript" charset="utf-8" src="resources/js/ueditor/lang/zh-cn/zh-cn.js"></script>
		<style type="text/css">
			#imgs{overflow: hidden;}
		</style>
		<script type="text/javascript">
			var imgs_array = new Array();
			$(function(){
				<s:iterator value="config.files" var="item" status="st">
					imgs_array.push({"id":<s:property value="#item.id" />,"path":'<s:property value="#item.filePath" />'});
				</s:iterator>
				var ue = UE.getEditor('editor',{
					toolbars: [[
			            'fullscreen', 'source', '|', 'undo', 'redo', '|',
			            'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
			            'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
			            'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
			            'directionalityltr', 'directionalityrtl', 'indent', '|',
			            'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
			            'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
			            'horizontal', 'date', 'time', 'spechars', '|',
			            'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', 'charts', '|',
			            'preview', 'searchreplace', 'drafts'
			        ]]
				});
				$(".btn_upload").bind("click",function(){
					$("#upload_btn_0").trigger("click");
				});
				$("#upload_btn_0").bind("change",upload_img);
				$("#base_frm").validationEngine({
					addPromptClass: 'formError-white formError-small',
					promptPosition: 'centerRight: 10, +1',
					maxErrorsPerField: true,
					autoHideDelay: 3000
				}).bind("jqv.form.result",function(event, errorFound){
					if(!errorFound){
						var div = $(".hid_files_div").html('');
						$.each(imgs_array,function(idx,item){
							$("<input>").attr("type","hidden").attr("name","bigPictures[" + idx + "]").val(item.id).appendTo(div);
						});
					}
				});
			});
			function delete_img(pic_id){
				$(".upload_imgs_2[img_id='#IMG_ID']".replace("#IMG_ID",pic_id)).remove();
				var index = -1;
				$.each(imgs_array,function(idx,item){
					if(item.id == pic_id){
						index = idx;
						return false;
					}
				});
				if(index > -1){
					imgs_array.splice(index,1);
				}
			}
			function upload_img(){
				var dialog = $.dialog({
				    icon: 'loading.gif',
				    titleIcon: 'lhgcore.gif',
				    content: '正在上传图片，请稍候....'
				});
				$.ajaxFileUpload({
					url: 'admin/upload',
					//用于文件上传的服务器端请求地址
					secureuri: false,
					//是否需要安全协议，一般设置为false
					data: {
						createMedia: false,
						saveFile:true,
						fileType:3
					},
					fileElementId: 'upload_btn_0',
					//文件上传域的ID
					dataType: 'json',
					//返回值类型 一般设置为json
					success: function(data) { //服务器成功响应处理函数
						dialog.close();
						if (data.result) {
							var pic = {"id":data.id,"path":data.upload_path,"width":data.width,"height":data.height};
							imgs_array.push(pic);
							rebuild_img(pic);
						} else {
							$.dialog.tips("文件上传失败，请稍候再试....", 2, "error.gif");
						}
						$("#upload_btn_0").replaceWith("<input type='file' name='upload' value='' title='" + Math.random() + "' id='upload_btn_0'/>");
						$("#upload_btn_0").unbind("change").bind("change",upload_img);
					},
					error: function(data, status, e) { //服务器响应失败处理函数
						dialog.close();
						$.dialog.tips("文件上传失败，请稍候再试....", 2, "error.gif");
					}
				});
			}
			function rebuild_img(pic){
				var div = $("<div>").addClass("upload_imgs_2").attr("img_id",pic.id).appendTo("#imgs");
				$("<img>").attr("src",pic.path).appendTo(div).bind("load",function(){
					AutoResizeImage(180, 180, this);
				});
				$("<a>").addClass("img_close").attr("href","javascript:delete_img(" + pic.id + ")").appendTo(div);
			}
		</script>
	</head>
	<body>
		<div class="home">
			<img src="resources/images/icon_home.png" width="20" height="20" />
			数据管理&nbsp;>&nbsp;楼盘管理&nbsp;>&nbsp;周边信息&nbsp;>&nbsp;周边信息编辑
		</div>
		<div style="width:1px;height:1px;filter:alpha(opacity=0);-moz-opacity:0;-khtml-opacity:0;opacity:0;">
			<s:file id="upload_btn_0" name="upload" />
		</div>
		<s:form action="house!config_save" namespace="/admin" method="post" id="base_frm">
			<div class="hid_files_div"></div>
			<s:hidden name="config.id" />
			<s:hidden name="config.projectId" />
			<table width="1024" border="0" cellspacing="0" cellpadding="0" class="tab_1" style="margin:40px 0 0 40px;float:left;">
				<tr>
					<td width="16%" align="right">
						周边名称
					</td>
					<td width="84%">
						<s:textfield name="config.configName" cssClass="input_1 input_1_w validate[required,minSize[2],maxSize[100]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						简介标题
					</td>
					<td>
						<s:textfield name="config.configTitle" cssClass="input_1 input_1_w validate[required,minSize[2],maxSize[60]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						周边简介
					</td>
					<td>
						<script id="editor" name="config.configContent" type="text/plain" style="width:100%;height:300px;"><s:property value="config.configContent" escapeHtml="false" /></script>
					</td>
				</tr>
				<tr>
					<td align="right">
						周边图片
					</td>
					<td>
						<input type="button"  value="上传图片" class="btn_upload" />
					</td>
				</tr>
				<tr>
					<td align="right">
						已上传图片
					</td>
					<td>
						<div id="imgs">
							<s:iterator value="config.files" var="item" status="st">
								<div img_id="<s:property value="#item.id" />" class="upload_imgs_2"><img style="height: 135px; width: 180px;" src="<s:property value="#item.filePath" />"><a href="javascript:delete_img(<s:property value="#item.id" />)" class="img_close"></a></div>
							</s:iterator>
						</div>
					</td>
				</tr>		
				<tr>
					<td align="right" colspan="2">
					<p align="center" style="margin:20px 0;"><input type="submit" name="button" id="button" value="保存周边信息" class="btn_tj btn_tj_w1" /></p>
					</td>
				</tr>				
			</table>
		</s:form>
	</body>
</html>