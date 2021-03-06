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
		<style type="text/css">
			.tab1 td{text-align: center; font-family: "Courier New","微软雅黑"}
		</style>
		<script type="text/javascript">
			$(function(){
				$("select").selectmenu();
				<s:if test="null != #request.provinces && !#request.provinces.isEmpty()">
				select_province(<s:property value="#request.provinces.get(0).id" />,'<s:property value="#request.provinces.get(0).provinceName" />');
				</s:if>
			});
			function add_province(){
				$.dialog.prompt('请输入省份名称',
				    function(val){
				        var name = $.trim(val);
				        if(name == ''){
				        	$.dialog.tips('参数错误',1.5,'error.gif');
				        	return;
				        }
				        $.get("admin/area!add_province",{name:name},function(data){
				        	eval("data="+data);
				        	if(data.result){
				        		$.dialog.tips('添加省份信息成功，稍候将刷新数据',2,'success.gif',function(){
				        			window.location.reload(true);
				        		});
				        	} else {
				        		$.dialog.tips('添加省份信息失败，失败原因：' + data.description, 3 , 'error.gif');
				        	}
				        })
				    }
				);
			}
			function delete_province(id){
				$.dialog.confirm('你确定要删除这个省份信息吗？<br /><br />此操作不可逆，请谨慎操作', function(){
					$.get("admin/area!delete_province",{id:id},function(data){
			        	eval("data="+data);
			        	if(data.result){
			        		$.dialog.tips('数据删除完成，稍候将刷新数据',2,'success.gif',function(){
			        			window.location.reload(true);
			        		});
			        	} else {
			        		$.dialog.tips('数据操作失败，失败原因：' + data.description, 3 , 'error.gif');
			        	}
			        })
				});
			}
			function edit_province(id,name){
				var src_name = name;
				$.dialog.prompt('请输入省份名称',function (new_name){
					var new_name = $.trim(new_name);
					if(new_name == src_name || new_name == ''){
						$.dialog.tips('参数错误',2,'error.gif');
						return;
					}
					$.get("admin/area!edit_province",{id:id,name:new_name},function(data){
						eval("data="+data);
						if(data.result){
			        		$.dialog.tips('数据修改完成，稍候将刷新数据',2,'success.gif',function(){
			        			window.location.reload(true);
			        		});
			        	} else {
			        		$.dialog.tips('数据操作失败，失败原因：' + data.description, 3 , 'error.gif');
			        	}
					});
				},src_name);
			}
			function select_province(id,name){
				$(".tab1:eq(1) tr:eq(0) th:eq(0)").text(name + ' 市级单位列表');
				$(".tab1:eq(1) tr:gt(0)").remove();
				$(".btn_search:eq(2)").attr("onclick","add_city(" + id + ",'" + name + "')");
				$(".btn_search:eq(3)").removeAttr("onclick");
				//select_city();
				$.get("admin/area!queryCityByProvince",{id:id},function(data){
					eval("data="+data);
					$.each(data.citys,function(idx,item){
						var tr = $("<tr>");
						var td1 = $("<td>").text(idx + 1),td2 = $("<td>").text(item.cityName);
						var td3 = $("<td>").html("<a href=\"javascript:delete_city(" + item.id + ",'" + item.cityName + "'," + id + ",'" + name + "')\">删除</a>|<a href=\"javascript:edit_city(" + id + ",'" + name + "'," + item.id + ",'" + item.cityName + "')\">修改</a>");
						//|<a href=\"javascript:select_city(" + item.id + ",'" + item.cityName + "')\">选择</a>
						tr.append(td1).append(td2).append(td3)//.append(td3);
						$(".tab1:eq(1)").append(tr);
						if(idx == 0){
							select_city(item.id,item.cityName);
						}
					});
				});
			}
			function delete_city(id,name,provinceId,provinceName){
				$.dialog.confirm('你确定要删除市级单位[' + name + ']信息吗？<br /><br />此操作不可逆，请谨慎操作', function(){
					$.get("admin/area!delete_city",{id:id},function(data){
			        	eval("data="+data);
			        	if(data.result){
			        		$.dialog.tips('数据删除完成，稍候将刷新数据',2,'success.gif',function(){
			        			select_province(provinceId,provinceName);
			        		});
			        	} else {
			        		$.dialog.tips('数据操作失败，失败原因：' + data.description, 3 , 'error.gif');
			        	}
			        })
				});
			}
			function add_city(id,provinceName){
				$.dialog.prompt('请输入市级单位名称',
				    function(val){
				        var name = $.trim(val);
				        if(name == ''){
				        	$.dialog.tips('参数错误',1.5,'error.gif');
				        	return;
				        }
				        $.get("admin/area!add_city",{id:id,name:name},function(data){
				        	eval("data="+data);
				        	if(data.result){
				        		$.dialog.tips('添加市级单位信息成功，稍候将刷新数据',2,'success.gif',function(){
				        			select_province(id,provinceName);
				        		});
				        	} else {
				        		$.dialog.tips('添加省份信息失败，失败原因：' + data.description, 3 , 'error.gif');
				        	}
				        })
				    }
				);
			}
			function edit_city(provinceId,provinceName,cityId,cityName){
				var src_name = cityName;
				$.dialog.prompt('请输入新市级单位名称',function (new_name){
					var new_name = $.trim(new_name); 
					if(new_name == cityName || new_name == ''){
						$.dialog.tips('参数错误',2,'error.gif');
						return;
					}
					$.get("admin/area!edit_city",{id:cityId,name:new_name},function(data){
						eval("data="+data);
						if(data.result){
			        		$.dialog.tips('数据修改完成，稍候将刷新数据',2,'success.gif',function(){
			        			select_province(provinceId,provinceName);
			        		});
			        	} else {
			        		$.dialog.tips('数据操作失败，失败原因：' + data.description, 3 , 'error.gif');
			        	}
					});
				},cityName);
			}
			function select_city(cityId,cityName){
				$(".tab1:eq(2) tr:gt(0)").remove();
				if(undefined == cityId || null == cityId){
					return;
				}
				$(".tab1:eq(2) tr:eq(0) th:eq(0)").text(cityName + ' 区域列表');
				$(".btn_search:eq(3)").attr("onclick","add_area(" + cityId + ",'" + cityName + "')");
				
				$.get("admin/area!queryAreaByCity",{id:cityId},function(data){
					eval("data="+data);
					$.each(data.areas,function(idx,item){
						var tr = $("<tr>");
						var td1 = $("<td>").text(idx + 1),td2 = $("<td>").text(item.areaName);
						var td3 = $("<td>").html("<a href=\"javascript:delete_area(" + item.id + ",'" + item.areaName + "'," + cityId + ",'" + cityName + "')\">删除</a>|<a href=\"javascript:edit_area(" + cityId + ",'" + cityName + "'," + item.id + ",'" + item.areaName + "')\">修改</a>");
						tr.append(td1).append(td2).append(td3);
						$(".tab1:eq(2)").append(tr);
					});
				});
			}
			function delete_area(areaId,areaName,cityId,cityName){
				$.dialog.confirm('你确定要删除区域[' + areaName + ']信息吗？<br /><br />此操作不可逆，请谨慎操作', function(){
					$.get("admin/area!delete_area",{id:areaId},function(data){
			        	eval("data="+data);
			        	if(data.result){
			        		$.dialog.tips('数据删除完成，稍候将刷新数据',2,'success.gif',function(){
			        			select_city(cityId,cityName);
			        		});
			        	} else {
			        		$.dialog.tips('数据操作失败，失败原因：' + data.description, 3 , 'error.gif');
			        	}
			        })
				});
			}
			function edit_area(cityId,cityName,areaId,areaName){
				var src_name = areaName;
				$.dialog.prompt('请输入新区域名称',function (new_name){
					var new_name = $.trim(new_name); 
					if(new_name == areaName || new_name == ''){
						$.dialog.tips('参数错误',2,'error.gif');
						return;
					}
					$.get("admin/area!edit_area",{id:areaId,name:new_name},function(data){
						eval("data="+data);
						if(data.result){
			        		$.dialog.tips('数据修改完成，稍候将刷新数据',2,'success.gif',function(){
			        			select_city(cityId,cityName);
			        		});
			        	} else {
			        		$.dialog.tips('数据操作失败，失败原因：' + data.description, 3 , 'error.gif');
			        	}
					});
				},src_name);
			}
			function add_area(cityId,cityName){
				$.dialog.prompt('请输入区域名称',
				    function(val){
				        var name = $.trim(val);
				        if(name == ''){
				        	$.dialog.tips('参数错误',1.5,'error.gif');
				        	return;
				        }
				        $.get("admin/area!add_area",{id:cityId,name:name},function(data){
				        	eval("data="+data);
				        	if(data.result){
				        		$.dialog.tips('添加区域信息成功，稍候将刷新数据',2,'success.gif',function(){
				        			select_city(cityId,cityName);
				        		});
				        	} else {
				        		$.dialog.tips('添加省份信息失败，失败原因：' + data.description, 3 , 'error.gif');
				        	}
				        })
				    }
				);
			}
		</script>
	</head>
	<body>
		<div class="home">
			<img src="resources/images/icon_home.png" width="20" height="20" />
			系统设置&nbsp;>&nbsp;单位管理&nbsp;>&nbsp;市级单位管理
		</div>
		<div class="m_w">
			<!--检索部分-->
			<div class="tab_check">
				<input type="button" value="返回单位管理" class="btn_search" style="margin-left:10px;" onclick="location.href='admin/govunit!view'" />
				<div style="display:none"><!-- 去掉这两个按钮的显示，直接注释，会影响JS，可以隐藏 -->
				<input type="button" value="新增省份" class="btn_search" style="margin-left:10px;" onclick="add_province()" />
				
				</div>
				<input type="button" value="新增市级单位" class="btn_search" style="margin-left:10px;" />
				<div style="display:none">
			    <input type="button" value="新增区域" class="btn_search" style="margin-left:10px;" />
			    </div>
			</div>
			<!--表格-->
			<table width="400" border="0" cellspacing="0" cellpadding="0" class="tab1 tab_f">
				<tr>
					<th colspan="3" align="left">
						省份列表
					</th>
				</tr>
				<s:iterator value="#request.provinces" var="item" status="st">
					<tr>
						<td><s:property value="#st.count" /></td>
						<td><s:property value="#item.provinceName" /></td>
<!-- 						<td><a href="javascript:delete_province(<s:property value="#item.id" />)">删除</a>|<a href="javascript:edit_province(<s:property value="#item.id" />,'<s:property value="#item.provinceName" />')">修改</a>|<a href="javascript:select_province(<s:property value="#item.id" />,'<s:property value="#item.provinceName" />')" class=".chioce">选择</a></td> -->
					</tr>
				</s:iterator>
			</table>
			<table width="400" border="0" cellspacing="0" cellpadding="0" class="tab1 tab_f">
				<tr>
					<th colspan="3" align="left">
						城市列表
					</th>
				</tr>
			</table>
<!-- 			<table width="400" border="0" cellspacing="0" cellpadding="0" class="tab1 tab_f"> -->
<!-- 				<tr> -->
<!-- 					<th colspan="3" align="left"> -->
<!-- 						区域列表 -->
<!-- 					</th> -->
<!-- 				</tr> -->
<!-- 			</table> -->
		</div>
	</body>
</html>