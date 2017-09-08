define(function(require, exporets, module){
	var $ = require("lib_cmd/zepto.js"),
	    myDialog = require("lib_cmd/alert.js"),
	    iTemplate = require("lib_cmd/iTemplate.js");
	
	
	$("#mydiv dl").click(function(){
		//alert("执行点击方法1");
		$(this).addClass("m_2_show").siblings().removeClass("m_2_show");
		var _index = $(this).attr("data-index");
		$("#list"+_index).css("display","");
		$("#list"+(_index == "1" ? "2" : "1" )).css("display","none");
	});
	
	$("#more1").click(function(){
		pageArgs1.loadData();
	});
	$("#more2").click(function(){
		pageArgs2.loadData();
	});
	
	$(".yj_lists .xm_tpc2").click(function(){
		//alert("执行点击方法2");
		var $this = $(this);
		if($this.hasClass("xm_tpc_show")){
			$this.parent().find(".yj_lista").hide();//css("display","none");
			$this.removeClass("xm_tpc_show");
			$this.find("img").attr("src" , "resources/images/arrow1.png");
		}
		else{
			$this.addClass("xm_tpc_show");
			$this.parent().find(".yj_lista").show();//css("display","");
			$this.find("img").attr("src" , "resources/images/arrow1_up1.png");
		}
	});
	
	$(".xm_tpc").click(function(){
		var $this = $(this);
		if($this.hasClass("yj_tab_n")){
			$this.parent().parent().find(".bankInfo").hide();//css("display","none");
			$this.removeClass("yj_tab_n").addClass("yj_tab_n_2");	
		}
		else{
			$this.removeClass("yj_tab_n_2").addClass("yj_tab_n");
			$this.parent().parent().find(".bankInfo").show();//css("display","");
		}
	});
	
	//申请结佣
	$("#sub1").click(function(){
		$(this).attr("disabled","disabled").removeClass("btn_zc1").addClass("btn_zc1_gray");
			$.ajax({
		         type: "POST",
		         url: APP.usableApply,
		         timeout: 30000,
		         data:{
		              },
		         async: true,
		         success: function (res) {
		             if(res && res.Status == 0){
		            	 $("#li_data").css("display","none");
		            	 $("#li_suc").css("display","");
		            	 window.scrollTo(0,0);
		            	 //三秒自动刷新页面
		            	 setTimeout(function(){
		            		 window.location.reload(true);
		            	 },3000);
		             }else{ 
		            	 $.alert({txt: '系统错误，提交失败!'}); 
		            	 $(this).removeAttr("disabled").removeClass("btn_zc1_gray").addClass("btn_zc1");
		             }
		             isLoading = false;
		         },
		         dataType: "json"
		     })	
	});
	
	
	//银行卡信息确认按钮
	$("#sub2").click(function(){
		var realName = $.trim($("#realName").val());
		var bankName = $.trim($("#bankName").val());
		var bankAccount = $.trim($("#bankAccount").val());
		if(!realName||!bankName||!bankAccount){
			$.alert({'txt':"您填写的信息不完整!"});
		}
		else{
			//先执行提交效果 后台异步执行保存操作
			$("#bankInfo").trigger("click");
 			$("#moneyInfo").trigger("click");
 			$("#_div_en").hide();
 			$("#_div_dis").show();
 			$("#realName").attr("readonly","readonly");
 			$("#bankName").attr("readonly","readonly");
 			$("#bankAccount").attr("readonly","readonly");
			//保存银行卡信息
			$.ajax({
	         type: "POST",
	         url: APP.accountUpdate,
	         timeout: 30000,
	         data:{
			        "user.realName" : realName,
			        "agent.bankName" :bankName,
			        "agent.bankAccount":bankAccount
	              },
	         async: true,
	         success: function (res) {
	             if(res && res.Status == 0){
	            	
	            	 
	             }else{
	            	  $.alert({txt: '系统错误!'}); 
	             }
	             isLoading = false;
	         },
	         dataType: "json"
	     });
			
		}
	});
	//
	
	//申请提现按钮
	$("#sub3").click(function(){
		var realName = $.trim($("#realName").val());
		var bankName = $.trim($("#bankName").val());
		var bankAccount = $.trim($("#bankAccount").val());
		if(!realName||!bankName||!bankAccount){
			$.alert({'txt':"请先绑定银行卡信息!"});
			return;
		}
		var txMoney = $("#txMoney").val();
		if(!txMoney||!Number(txMoney)||txMoney<0){
			$.alert({'txt' : '请输入正确的金额!'});
		}
		else
		if(Number(txMoney) > Number(APP.cash)){
			$.alert({'txt' : '您最多可提现'+APP.cash+'元'});
			$("#txMoney").focus();
		}
		else{
			//window.location.href = "weixin/wechat!myBrokerage?tabId=1";
			$.ajax({
		         type: "POST",
		         url: APP.cashApply,
		         timeout: 30000,
		         data:{
				        "amount" : txMoney
		              },
		         async: true,
		         success: function (res) {
		             if(res && res.Status == 0){
		            	 //$.alert({txt: '提现成功!'}); 
		            	 $.confirm({txt: '申请成功!是否刷新页面显示最新信息?',callback:function(){
		            		 window.location.href = "weixin/wechat!myBrokerage?tabId=1";
		            	 }});
		             }else{
		            	  $.alert({txt: '系统错误,提现失败!'}); 
		             }
		             isLoading = false;
		         },
		         dataType: "json"
		     })
		}
	})
	
	
	/**异步加载数据模块**/
    var pageArgs1 = {
        pageIndex: 1,
        pageSize: 3,
        template: '<tr>\
		             <td align="left" valign="middle">\
		                {finishTimeDesc}\
	                 </td>\
	                 <td align="center" valign="middle">\
		                 {finalMoney}元\
	                 </td>\
	                 <td align="center" valign="middle">\
		                 {resultStatus}\
	                 </td>\
	                 <td align="right" valign="middle">\
		                 {resultMsg}\
	                 </td>\
                </tr>',
        isLoading: false,
        loadData: function (evt) {
            var that = this;
            if (that.isLoading) { return; }
            $('<li id="loading_element" class="loading_element"><span class="loading_icon">&nbsp;</span></li>').appendTo($('#tab1'));
            that.isLoading = true;

            $.ajax({
                type: "POST",
                url: APP.list1Url,
                data: {
            	     "page.current": that.pageIndex,
                     "page.offset": that.pageSize
                },
                async: true,
                success: function (res) {
                    that.isLoading = false;
                    if (0 != res.total) {
                        var HTML_order = iTemplate.makeList(that.template, res.Data, function (k, v) {
                            return {
                            	resultMsg: (function () {
                            		var strReturn ='未知';
                                   
                                    if (v.moneyApp.resultStatus == 1 || v.moneyApp.resultStatus == 3)
                                    {
                                      
                                            strReturn = '审核通过';
                                       
                                    }
                                    else if (v.moneyApp.resultStatus == 0)
                                    {
                                     
                                    	    strReturn = '审核中';
                                    }
                                    else if (v.moneyApp.resultStatus == 2)
                                    {
                                     
                                    	    strReturn = '审核未通过';
                                    }
                                    
                                   
                                   
                                    return strReturn;

                                })(),
                                resultStatus: (function(){
                                	var strReturn ='未知'; 
                                	if (v.moneyApp.appType == 1)
                                    {
                                      
                                            strReturn = '签约结佣';
                                       
                                    }
                                    else if (v.moneyApp.appType == 2)
                                    {
                                     
                                    	    strReturn = '客户到访奖';
                                    }
                                    else if (v.moneyApp.appType == 3)
                                    {
                                     
                                    	    strReturn = '首次带看奖';
                                    }
                                    else if (v.moneyApp.appType == 4)
                                    {
                                     
                                    	    strReturn = '推荐人注册奖';
                                    }
                                    else if (v.moneyApp.appType == 5)
                                    {
                                     
                                    	    strReturn = '注册送红包';
                                    }
                                    else if (v.moneyApp.appType == 6)
                                    {
                                     
                                    	    strReturn = '其他活动';
                                    }
                                    
                                   
                                   
                                    return strReturn;
                                })()
                            
                               
                                
                            }
                        });
                        $("#loading_element").replaceWith($(HTML_order));
                    }
                    else {
                        $("#div1").addClass("empty");
                        $("#loading_element").remove();
                    }

                    that.pageIndex++;
                    if (that.pageIndex >Math.ceil(res.total / that.pageSize)) {
                           $("#more1").css("display","none");
                    }
                },
                dataType: "json"
            });
        }
    };
    
    
    
    
    
	/**异步加载数据模块**/
    var pageArgs2 = {
        pageIndex: 1,
        pageSize: 3,
        template: '<tr>\
			          <td align="left" valign="middle">\
		                 {applicationTimeDesc}\
	                  </td>\
	                  <td align="center" valign="middle">\
		                 {amountMoney}元\
	                  </td>\
	                  <td align="right" valign="middle">\
		                 {resultMsg}\
	                  </td>\
                  </tr>',
        isLoading: false,
        loadData: function (evt) {
            var that = this;
            if (that.isLoading) { return; }
            $('<li id="loading_element2" class="loading_element"><span class="loading_icon">&nbsp;</span></li>').appendTo($('#tab2'));
            that.isLoading = true;

            $.ajax({
                type: "POST",
                url: APP.list2Url,
                data: {
            	    "page.current": that.pageIndex,
                    "page.offset": that.pageSize
                },
                async: true,
                success: function (res) {
                    that.isLoading = false;
                    if (0 != res.total) {
                        var HTML_order = iTemplate.makeList(that.template, res.Data, function (k, v) {
                            return {
                            	resultMsg: (function () {
                            		var strReturn ='未知';
                                   
                                    if (v.resultStatus == 0)
                                    {
                                      
                                            strReturn = '提现办理中';
                                       
                                    }
                                    else if (v.resultStatus == 1)
                                    {
                                     
                                    	    strReturn = '提现成功';
                                    }
                                    else if (v.resultStatus == 2)
                                    {
                                     
                                    	    strReturn = '提现失败';
                                    }
                                   
                                   
                                    return strReturn;

                                })()
                            
                               
                                
                            }
                        });
                        $("#loading_element2").replaceWith($(HTML_order));
                    }
                    else {
                        $("#div2").addClass("empty");
                        $("#loading_element2").remove();
                    }

                    that.pageIndex++;
                    if (that.pageIndex > Math.ceil(res.total / that.pageSize)) {
                    	
                           $("#more2").css("display","none");
                    }
                },
                dataType: "json"
            });
        }
    };
   
	
    $(function () {
        pageArgs1.loadData();
        pageArgs2.loadData();
        //如果存在tabId 则展开提现列表
        if(APP.tabId){
        	$("#dl2").trigger("click");
        	$("#div_tx").trigger("click");
        }
        
    });
	
	
});