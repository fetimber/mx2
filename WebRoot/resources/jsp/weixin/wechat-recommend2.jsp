<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>推荐客户</title>
		<meta charset="utf-8">
		<meta content="" name="description">
		<meta content="" name="keywords">
		<meta content="application/xhtml+xml;charset=UTF-8" http-equiv="Content-Type">
		<meta content="telephone=no, address=no" name="format-detection">
		<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
		<link href="resources/weixin/css/style.css?v=044" rel="stylesheet" />
		<script src="resources/weixin/lib_cmd/sea.js"></script>
		<script>
        var  App ={
               remUrl : "weixin/wechat!recommend",//登录url
               sucUrl :  "",//登录成功后跳转url
               limit : "<s:property value='#request.myCount'/>" || 10,//今日推荐客户限制
               hid :"<s:property value='#request.curProject.id'/>" || "", //楼盘ID  
               hName:"<s:property value='#request.curProject.projectName'/>" || "",//楼盘名称
               hPrice:"<s:property value='#request.curProject.brokerage'/>" || "",//当前楼盘的佣金
               area:"<s:property value='#request.curProject.area'/>" || ""//当前楼盘的区域
        }
    </script>
		<script>

        (function(l){
            seajs.config({
                base:"<%=basePath%>/resources/weixin",
                map:[
                    [".js", (l&&l[1]||"")+".js?v=044"]
                ]
            });
            //
            seajs.use("<%=basePath%>resources/weixin/js_cmd/recommend2.js?v=044");
        })(location.href.match(/de(\-\d+)bug/));

     
    </script>


	</head>
	<body style="background:#f0f0f0;height: 120%;" class="bg_p">
	<div style="padding:16px;">
		<s:if test="#request.curProject!=null">
				<div style="padding-bottom: 8px;">
					<span class="fl_logo"><s:property value='#request.curProject.projectName'/></span><a href="weixin/wechat!houseDetail?id=<s:property value='#request.curProject.id'/>" class="fl_more" style="float:right;">楼盘详情&gt;&gt;</a>
				</div>
				<div class="i_t1 i_t2">
					<span class="tpc_w">佣金：</span><span>最高<s:property value='#request.curProject.maxBro'/>元/套</span>
				</div>
				<div class="i_t1">
					<span class="tpc_w">面积：</span><span><s:property value='#request.curProject.downArea'/>-<s:property value='#request.curProject.upArea'/>平米</span>
				</div>
				<div class="i_t1">
					<span class="tpc_w">均价：</span><span><s:property value='#request.curProject.price'/>元/平米</span>
				</div>
				<div class="i_t1">
					<span class="tpc_w">地址：</span><span><s:property value='#request.curProject.address'/></span>
				</div>
		</s:if>
		<div class="caption caption_tpc">
				<img src="resources/images/caption_arrow.png" width="14" height="14" class="caption_arrow" />
				推荐客户
				<span class="tips_txt1">您今日还有<s:property value='#request.myCount'/>位购房者可推荐</span>
		</div>
		<div id="cusList">
			<div class="cusInfo">
				<ul class="tj_strange part_st">
					<li class="input_g">
						<img src="resources/images/icon1.png"  class="input_icon_aa"/>
						<div style="position:relative">
							<div class="input_ab"><input type="text" class="input_aa cusName" placeholder="客户姓名"/></div>
							<span class="must" >*</span>
						</div>
					</li>
					<li class="input_g bor_tb">
						<img src="resources/images/icon2.png" class="input_icon_aa"/>
						<div style="position:relative">
							<div class="input_ab"><input type="tel" class="input_aa cusPhone" placeholder="手机号码"/></div>
							<span class="must"">*</span>
						</div>
					</li>
					<li class="input_g" style="border-bottom:1px solid #eee">
						<img src="resources/images/icon12.png" class="input_icon_aa"/>
							<div class="input_ab" style="position: relative;">
							<select class="sel1_aa cusProject"style="-webkit-appearance: textfield; color:#333;">
								<option value="<s:property value='#request.curProject.id'/>" 
								         data-brokerage="<s:property value='#request.curProject.brokerage'/>"
								         data-area="<s:property value='#request.curProject.area'/>">
									<s:property value='#request.curProject.projectName'/>
								</option>
							</select><span class="must">*</span></div>
					</li>
					<li class="input_g">
						<img src="resources/images/icon10.png" class="input_icon"/>
						<div class="input_a">
							<div class="tips_gray">
								<font color="#333">备注信息</font>
							</div>
					    </div>
						<textarea rows="3" class="textarea1 cusRemark" placeholder="  请尽量详细填写客户信息，以便我们提供更有效服务"></textarea>
						<div class="sel2 cusMor">
							<span> 
							      <input class="refer_area fx_btn" type="checkbox" value=""/><span style="font-size:12px" >&nbsp;同时推荐到该区域</span>
							</span>
							<span> 
							      <input class="self_send fx_btn" type="checkbox" value="" /><span style="font-size:12px" >&nbsp;亲自邀约</span>
							</span>
							<span> 
							      <input class="self_look fx_btn" type="checkbox" value="" /><span style="font-size:12px">&nbsp;亲自带看</span>
							</span>
						</div>
						<div class="clear"></div>
					</li>
                    <div class="clear"></div>
				</ul>
			</div>
		</div>
		<div style="margin-bottom: 15px;">
			<input type="button" class="btn_zc" value="确认推荐" />
		</div>
		<div>
		 &nbsp;
		</div>
	</div>
	</body>
</html>
