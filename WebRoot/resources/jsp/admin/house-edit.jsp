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
			.input_1{font-family:"Courier New","微软雅黑"}
		</style>
		<script type="text/javascript">
			var big_pictures = new Array();
			var small_pictures = new Array();
			var price_pictures = new Array();
			$(function() {
				//$.validationEngineLanguage.allRules._ajax_house_name.extraData = "project.id=" + ($("input:hidden[name='project.id']").length ? $("input:hidden[name='project.id']").val() : '');
				$.validationEngineLanguage.pushData('_ajax_house_name','project.id',($("input:hidden[name='project.id']").length ? $("input:hidden[name='project.id']").val() : ''));
				//加载图片
				<s:if test="null != project && null != project.bigPictures">
					<s:iterator value="project.bigPictures" var="item">
						big_pictures.push({"id":<s:property value="#item.id" />,"path":"<s:property value="#item.filePath" />"});
					</s:iterator>
				</s:if>
				<s:if test="null != project && null != project.smallPictures">
					<s:iterator value="project.smallPictures" var="item">
						small_pictures.push({"id":<s:property value="#item.id" />,"path":"<s:property value="#item.filePath" />"});
					</s:iterator>
				</s:if>
				<s:if test="null != project && null != project.priceImage">
					price_pictures.push({"id":<s:property value="project.priceImage.id" />,"path":"<s:property value="project.priceImage.filePath" />"});
				</s:if>
				$('#base_frm').validationEngine({
					addPromptClass: 'formError-white formError-small',
					promptPosition: 'centerRight: 10, +1',
					maxErrorsPerField: true,
					autoHideDelay: 3000
				}).bind("jqv.form.result",function(event, errorFound){
					var div = $(".hid_files_div").html('');
					$.each(big_pictures,function(idx,item){
						$("<input>").attr("type","hidden").attr("name","bigPictures[" + idx + "]").val(item.id).appendTo(div);
					});
					$.each(small_pictures,function(idx,item){
						$("<input>").attr("type","hidden").attr("name","smallPictures[" + idx + "]").val(item.id).appendTo(div);
					});
					
					$("<input>").attr("type","hidden").attr("name","project.priceImageId").val(price_pictures.length ? price_pictures[0].id : "-1").appendTo(div);
				});
				$("select").selectmenu({width:'440px'});
				$(".btn_upload:eq(0)").bind("click",function(){
					$("#upload_btn_0").trigger("click");
				});
				$(".btn_upload:eq(1)").bind("click",function(){
					$("#upload_btn_1").trigger("click");
				});
				$(".btn_upload:eq(2)").bind("click",function(){
					$("#upload_btn_2").trigger("click");
				});
				_init_upload(0);
				_init_upload(1);
				_init_upload(2);
				auto_size();
			});
			function _init_upload(idx){
				$("#upload_btn_" + idx).bind("change",function(){
					if(idx == 2){
						if(price_pictures.length){
							$.dialog.tips('奖励价格图片只能上传一张，如果需要替换，请先删除已经存在的奖励价格图片',3,'error.gif');
							return;
						}
					}
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
							fileType:idx == 0 ? 1 : (idx == 1 ? 2 : 5)
						},
						fileElementId: 'upload_btn_' + idx,
						//文件上传域的ID
						dataType: 'json',
						//返回值类型 一般设置为json
						success: function(data) { //服务器成功响应处理函数
							dialog.close();
							if (data.result) {
								var pic = {"id":data.id,"path":data.upload_path,"width":data.width,"height":data.height};
								if(idx == 0){
									small_pictures.push(pic);
								} else if(idx == 1){
									big_pictures.push(pic);
								} else if(idx == 2){
									price_pictures.push(pic);
								}
								rebuild_pict(pic,idx);
							} else {
								$.dialog.tips("文件上传失败，请稍候再试....", 2, "error.gif");
							}
							$("#upload_btn_" + idx).replaceWith("<input type='file' name='upload' value='' title='" + Math.random() + "' id='upload_btn_" + idx + "'/>");
							_init_upload(idx);
						},
						error: function(data, status, e) { //服务器响应失败处理函数
							dialog.close();
							$.dialog.tips("文件上传失败，请稍候再试....", 2, "error.gif");
						}
					});
				});
			}
			function auto_size() {
				$(".upload_imgs img").each(function() {
					AutoResizeImage(125, 125, this);
				});
				$(".upload_imgs_2 img").each(function() {
					AutoResizeImage(180, 180, this);
				});
				$(".upload_imgs_3 img").each(function() {
					AutoResizeImage(133, 120, this);
				});
			}
			function rebuild_pict(pic,idx){
				var span = $("<span>").attr("pic_id",pic.id);
				if(idx == 1){
					if(big_pictures.length == 1){
						$(".upload_imgs_1").remove();
					}
					span.addClass("upload_imgs_1 bigpic");
				} else if(idx == 0) {
					if(small_pictures.length == 1){
						$(".upload_imgs").remove();
					}
					span.addClass("upload_imgs smallpic");
				} else if(idx == 2) {
					if(price_pictures.length == 1){
						$(".upload_imgs_2").remove();
					}
					span.addClass("upload_imgs_2 pricepic");
				}
				var img = $("<img>").attr("pic_id",pic.id).attr("src",pic.path).width(pic.width).height(pic.height).bind("load",function(){
					if(idx == 0){
						AutoResizeImage(125,125, this);
					} else if(idx == 1){
						AutoResizeImage(180,180, this);
					} else if(idx == 2){
						AutoResizeImage(133,125, this);
					}
				});
				var close = $("<a>").addClass("img_close").attr("href","javascript:delete_img(" + idx + "," + pic.id + ")");
				span.append(img).append(close);
				if(idx == 0){
					span.appendTo("#small_imgs");
				} else if(idx == 1){
					span.appendTo("#big_imgs");
				} else if(idx == 2){
					span.appendTo("#price_imgs");
				}
			}
			function delete_img(idx,pic_id){
				var div = "";
				if(idx == 0){
					div = ".smallpic";
				} else if(idx == 1){
					div = ".bigpic";
				} else if(idx == 2){
					div = ".pricepic";
				}
				$(div + "[pic_id=" + pic_id + "]").remove();
				var index = -1;
				var list = null;
				if(idx == 0){
					list = small_pictures;
				} else if(idx == 1){
					list = big_pictures;
				} else if(idx == 2){
					list = price_pictures;
				}
				for(var i = 0; i < list.length; i++){
					if(list[i].id == pic_id){
						index = i
						break;
					}
				}
				
				if(index > -1){
					if(idx == 0){
						small_pictures.splice(index,1);
					} else if(idx == 1){
						big_pictures.splice(index,1);
					} else if(idx == 2){
						price_pictures.splice(index,1);
					}
				}
				
				if(idx == 0){
					if(small_pictures.length == 0){
						$("<span>").addClass("upload_imgs").appendTo("#small_imgs");
					}
				} else if(idx == 1){
					if(big_pictures.length == 0){
						$("<span>").addClass("upload_imgs_1").appendTo("#big_imgs");
					}
				} else if(idx == 2){
					if(price_pictures.length == 0){
						$("<span>").addClass("upload_imgs_2").appendTo("#price_imgs");
					}
				}
			}
		</script>
	</head>
	<body style="min-width: 1700px;">
		<div class="home">
			<img src="resources/images/icon_home.png" width="20" height="20" />数据管理&nbsp;>&nbsp;楼盘管理&nbsp;>&nbsp;编辑楼盘信息
		</div>
		<s:form action="house!save_project" namespace="/admin" method="post" id="base_frm">
			<div class="hid_files_div">
			
			</div>
			<s:hidden name="project.id" />
			<table width="40%" border="0" cellspacing="0" cellpadding="0" class="tab_1" style="margin:40px 0 0 40px;float:left;">
				<tr>
					<td width="16%" align="right">
						楼盘名称
					</td>
					<td width="84%">
						<s:textfield name="project.projectName" cssClass="input_1 input_1_w validate[required,minSize[4],maxSize[100],ajax[_ajax_house_name]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						&nbsp;
					</td>
					<td valign="top" style="padding-top:0;">
						<span class="f_gray">
							请输入楼盘的名称，4-100个字符，不限制符号
						</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						楼盘简介
					</td>
					<td>
						<s:textfield name="project.projectSummary" cssClass="input_1 input_1_w validate[required,minSize[4],maxSize[60]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						&nbsp;
					</td>
					<td valign="top" style="padding-top:0;">
						<span class="f_gray">
							请输入楼盘的简介，4-60个字符，不限制符号
						</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						楼盘所在区域
					</td>
					<td>
						<s:select list="#request.areas" listKey="id" listValue="areaName" name="project.area"></s:select>
					</td>
				</tr>
				<tr>
					<td align="right">
						&nbsp;
					</td>
					<td valign="top" style="padding-top:0;">
						<span class="f_gray">
							选择楼盘所在的区域，如果区域不在此列表中，请点击楼盘管理页面新增区域
						</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						楼盘地址
					</td>
					<td>
						<s:textfield name="project.address" cssClass="input_1 input_1_w validate[required,minSize[4],maxSize[200]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						楼盘单价
					</td>
					<td>
						<s:textfield name="project.price" cssClass="input_1 input_1_w validate[required,min[1000],max[400000],custom[number]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>&nbsp;元
					</td>
				</tr>
				<tr>
					<td align="right">
						面积上限
					</td>
					<td height="50">
						<s:textfield name="project.upArea" cssClass="input_1 input_1_w validate[required,min[1],max[10000],custom[number]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>&nbsp;m²
					</td>
				</tr>
				<tr>
					<td align="right">
						面积下限
					</td>
					<td height="50">
						<s:textfield name="project.downArea" cssClass="input_1 input_1_w validate[required,min[1],max[10000],custom[number]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>&nbsp;m²
					</td>
				</tr>
				<tr>
					<td align="right">
						总价上限
					</td>
					<td height="50">
						<s:textfield name="project.upSum" cssClass="input_1 input_1_w validate[required,min[0],max[1000000],custom[number]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>&nbsp;万元
					</td>
				</tr>
				<tr>
					<td align="right">
						总价下限
					</td>
					<td height="50">
						<s:textfield name="project.downSum" cssClass="input_1 input_1_w validate[required,min[0],max[1000000],custom[number]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>&nbsp;万元
					</td>
				</tr>
				<tr>
					<td align="right">
						项目经理
					</td>
					<td>
						<s:select name="project.pmId" list="#request.managers" listKey="id" listValue="realName"></s:select>
					</td>
				</tr>
				<tr>
					<td align="right">
						是否主打楼盘
					</td>
					<td>
						<s:select list="#{1:'是',0:'否' }" name="project.isMain"></s:select>
					</td>
				</tr>
				<tr>
					<td align="right">
						楼盘类型
					</td>
					<td>
						<s:select list="#{1:'刚需型住房',2:'改善型住房' }" name="project.reqType"></s:select>
					</td>
				</tr>
				<tr>
					<td align="right">
						首次来访奖励
					</td>
					<td height="50">
						<s:textfield name="project.firstReward" cssClass="input_1 input_1_w validate[required,min[0],max[1000000],custom[number]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						亲自带看奖励
					</td>
					<td height="50">
						<s:textfield name="project.viewReward" cssClass="input_1 input_1_w validate[required,min[0],max[1000000],custom[number]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						限时奖励描述
					</td>
					<td height="50">
						<s:textfield name="project.limitDesc" cssClass="input_1 input_1_w validate[required,minSize[4],maxSize[500]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						佣金
					</td>
					<td height="50">
						<s:textfield name="project.brokerage" cssClass="input_1 input_1_w validate[required,min[0],max[1000000],custom[number]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>&nbsp;元
					</td>
				</tr>
				<tr>
					<td align="right">
						最大佣金
					</td>
					<td height="50">
						<s:textfield name="project.maxBro" cssClass="input_1 input_1_w validate[required,min[0],max[1000000],custom[number]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>&nbsp;元
					</td>
				</tr>
				<tr>
					<td align="right">
						佣金组成描述
					</td>
					<td height="50">
						<s:textfield name="project.broDesc" cssClass="input_1 input_1_w validate[required,minSize[4],maxSize[500]]"></s:textfield>&nbsp;&nbsp;<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						成交指数
					</td>
					<td height="50">
						<s:textfield name="project.dealPoint" cssClass="input_1 input_1_w validate[custom[integer]]"></s:textfield>
					</td>
				</tr>
				<tr>
					<td align="right">
						佣金指数
					</td>
					<td height="50">
						<s:textfield name="project.commissionPoint" cssClass="input_1 input_1_w validate[custom[integer]]"></s:textfield>
					</td>
				</tr>
			</table>
			<table width="50%" border="0" cellspacing="0" cellpadding="0" class="tab_1" style="margin:40px 0 0 40px;float:left;">
				<tr>
					<td width="16%" align="right">
						楼盘小图片：
					</td>
					<td width="84%">
						<input type="button"  value="上传图片" class="btn_upload" />&nbsp;&nbsp;&nbsp;&nbsp;<span class="gray">建议小图片尺寸 125像素 X 125像素</span>
					</td>
				</tr>
				<tr>
					<td  align="right">
					</td>
					<td  valign="top" style="padding-top:0;" id="small_imgs">
						<s:if test="null == project">
							<span class="upload_imgs"></span>
						</s:if>
						<s:elseif test="null == project.smallPictures || project.smallPictures.isEmpty()">
							<span class="upload_imgs"></span>
						</s:elseif>
						<s:else>
							<s:iterator value="project.smallPictures" var="item">
								<span pic_id="<s:property value="#item.id" />" class="upload_imgs smallpic">
								<a href="javascript:delete_img(0,<s:property value="#item.id" />)" class="img_close"></a>
								<img style="width: 125px; height: 125px;" src="<s:property value="#item.filePath" />" pic_id="<s:property value="#item.id" />"></span>
							</s:iterator>
						</s:else>
					
					</td>
				</tr>
				<tr>
					<td width="16%" align="right">
						楼盘大图片：
					</td>
					<td width="84%" > 
						<input type="button"  value="上传图片" class="btn_upload" />&nbsp;&nbsp;&nbsp;&nbsp;<span class="gray">建议大图片尺寸 800像素 X 800像素</span>
					</td>
				</tr>
				<tr>
					<td  align="right">
						
					</td>
					<td valign="top" style="padding-top:0;" id="big_imgs">
						<s:if test="null == project">
							<span class="upload_imgs_1"></span>
						</s:if>
						<s:elseif test="null == project.bigPictures || project.bigPictures.isEmpty()">
							<span class="upload_imgs_1"></span>
						</s:elseif>
						<s:else>
							<s:iterator value="project.bigPictures" var="item">
								<span pic_id="<s:property value="#item.id" />" class="upload_imgs_1 bigpic">
								<a href="javascript:delete_img(1,<s:property value="#item.id" />)" class="img_close"></a>
								<img style="width: 180px; height: 180px;" src="<s:property value="#item.filePath" />" pic_id="<s:property value="#item.id" />"></span>
							</s:iterator>
						</s:else>
					</td>
				</tr>
				<tr>
					<td width="16%" align="right">
						奖励金额图片：
					</td>
					<td width="84%" > 
						<input type="button"  value="上传图片" class="btn_upload" />&nbsp;&nbsp;&nbsp;&nbsp;<span class="gray">建议大图片尺寸133像素 X 120像素</span>
					</td>
				</tr>
				<tr>
					<td  align="right">
						
					</td>
					<td valign="top" style="padding-top:0;" id="price_imgs">
						<s:if test="null == project">
							<span class="upload_imgs_2"></span>
						</s:if>
						<s:elseif test="null == project.priceImage">
							<span class="upload_imgs_2"></span>
						</s:elseif>
						<s:else>
							<span pic_id="<s:property value="project.priceImageId" />" class="upload_imgs_2 pricepic">
							<a href="javascript:delete_img(2,<s:property value="project.priceImageId" />)" class="img_close"></a>
							<img style="width: 133px; height: 120px;" src="<s:property value="project.priceImage.filePath" />" pic_id="<s:property value="project.priceImageId" />"></span>
						</s:else>
					</td>
				</tr>
			</table>
			<div id="small_picture_div"></div>
			<div id="big_picture_div"></div>
			<div id="price_picture_div"></div>
			<div class="clear"></div>
			<p align="center" style="margin:20px 0;"><input type="submit" name="button" id="button" value="保存楼盘信息" class="btn_tj btn_tj_w1" /></p>
		</s:form>
		<div style="width:1px;height:1px;filter:alpha(opacity=0);-moz-opacity:0;-khtml-opacity:0;opacity:0;">
			<s:file id="upload_btn_0" name="upload" />
			<s:file id="upload_btn_1" name="upload" />
			<s:file id="upload_btn_2" name="upload" />
		</div>
	</body>
</html>