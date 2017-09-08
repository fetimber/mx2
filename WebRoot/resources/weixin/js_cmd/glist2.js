var  buildingNo;
define(function (require, exports, moudle) {
    var $ = require("lib_cmd/zepto"),
        swipe = require("lib_cmd/swipe"),
		main = require("js_cmd/main"),
		myDialog = require("lib_cmd/myDialog"),
		scrollEvt = require("lib_cmd/scrollEvt"),
		iTemplate = require("lib_cmd/iTemplate"),
		$eles = {},
		ele = {};
    
    new Swipe(document.getElementById('slider_3_wrap'), {
		speed:500,
		loop:true,
		auto:3000,
		indicate:"#slider_3_indicate"
	});
    
    
    $("#xqli").click(function(){
    	var xqul = $("#xqul");
    	var dyul = $("#dyul");
    	var xqul_display = xqul.css("display");
    	if(xqul_display == "none"){
    		xqul.css("display" , "");
    		dyul.css("display" , "none");
    		$(this).addClass("tab_s_show");
    		$("#dyli").removeClass("tab_s_show");
    	}
    	else{
    		xqul.css("display" , "none");
    		$(this).removeClass("tab_s_show");
    	}
    });
    
    $("#xqul li").click(function(){
    	$this = $(this);
    	ele.isEnding = false;
    	var str = $this.text();
    	$eles.reqType = $this.attr("data-val");
    	$("#xqli span").html(str+'&nbsp;&nbsp;&nbsp;&nbsp;<img src="resources/images/icon_arrow.png" />');
    	$("#glist2_ul").html("");
    	pageArgs.pageIndex = 1;
    	pageArgs.loadData();
        window.myScroll.start();
    });
    
    $("#dyul li").click(function(){
    	$this = $(this);
    	ele.isEnding = false;
    	var str = $this.text();
    	$eles.area = $this.attr("data-val");
    	$("#dyli span").html(str+'&nbsp;&nbsp;&nbsp;&nbsp;<img src="resources/images/icon_arrow.png" />');
    	$("#glist2_ul").html("");
    	pageArgs.pageIndex = 1;
    	pageArgs.loadData();
        window.myScroll.start();
    });
    
    $("#dyli").click(function(){
    	var xqul = $("#xqul");
    	var dyul = $("#dyul");
    	var dyul_display = dyul.css("display");
    	if(dyul_display == "none"){
    		dyul.css("display" , "");
    		xqul.css("display" , "none");
    		$(this).addClass("tab_s_show");
    		$("#xqli").removeClass("tab_s_show");
    	}
    	else{
    		$(this).removeClass("tab_s_show");
    		dyul.css("display" , "none");
    	}
    });
    
    
    window.recommend = function(id,roomcode,buildingNo){
    	window.location.href = "weixin/wechat!recommendPage?hid="+id+"&roomcode="+roomcode+"&buildno="+buildingNo;
    }
        
    window.checkdetail = function(id,roomcode,buildingNo){
    	window.location.href = "weixin/wechat!recommendPage?hid="+id+"&roomcode="+roomcode+"&buildno="+buildingNo;
    }
    
    waterFall = (function (win, doc) {
        function waterFall(obj) {
            this.column = 1;
            this.container = null;
            this.rows = {};

            if (obj && ("object" == typeof obj)) {
                for (var k in obj) {
                    this[k] = obj[k];
                }
            }
        }

        waterFall.prototype = {
            constructor: waterFall,
            init: function () {
                var self = this;
                return self;
            },
            append: function (data) {
                var self = this;
                for (var i = 0, ci, frg; ci = data[i]; i++) {
                	self.container.appendChild(ci);
                }
                return self;
            },
            getNextRow: function () {
                var self = this;
                return self.rows[0].container;
            }
        }

        return waterFall;
    })(window, document);

    /**异步加载数据模块**/
    var pageArgs = {
        pageIndex: 1,
        pageSize: 4,
        index: 0,
        template1: '\
					<a href="' + APP.urls.DetailUrl + '?id={id}" onclick="dataCache.recordInfo(this, event, {index});">\
					<img src="{imgPath}" class="fl_imgs" />\
					</a>\
				    <p class="fl_txt1">[{projectName}]{projectSummary} </p>\
				    <p class="fl_txt2">房子价格  ￥{price}元/平方米</p>\
				    <p class="fl_txt2">房子佣金  ￥{brokerage}元</p>\
				  ',
        template2: '\
        	        <li>\
        	<div class="fl_l">\
		       <img src="resources/images/build_logo.jpg" class="build_logo" />\
		       <a href="weixin/wechat!houseDetail?id={id}"><img src="{imgPath}" /></a>\
	        </div>\
	<div class="fl_r">\
		<div class="fl_t1">\
			<div class="fl_t1_s">\
				<p class="fl_t1_t">\
				 {projectName}【{areaName}】\
				</p>\
				<p>\
					{projectSummary}\
				</p>\
			</div>\
		</div>\
		    <div style="margin: 9px 0 5px 0;">\
		         <input value="推荐客户"  type="button" class="btn red" onclick="recommend({id},{area})"/>\
		    </div>\
		</div>\
		<div class="clear"></div>\
		<div class="i_t1" style="margin-top: 5px;">\
		  <span class="tpc_w">均价：</span>\
		  <span>{price}/平方米</span>\
	    </div>\
	    <div class="i_t1">\
	       <span class="tpc_w">面积范围：</span>\
		   <span>{downArea}-{upArea}平方米</span>\
	     </div>\
		<div class="i_t1">\
			佣金：\
			<span>{brokerage}元/套</span>\
		</div>\
		<div class="i_t">\
			佣金组成：\
			<font color="#666">{broDesc}</font>\
		</div>\
		<div class="t_jl">\
			限时奖励：{limitDesc}\
		</div>\
		<div>\
			<div class="pr_1">\
				首次来访奖：\
				<font color="#c70013">{firstReward}元</font>\
			</div>\
			<div class="pr_2">\
				亲自带看奖：\
				<font color="#ff671c">{viewReward}元</font>\
			</div>\
			<div class="clear"></div>\
		</div>\
	</div>\
	</li>\
        	       ',
	template3:'\
		      <li>\
                 <p style="padding-bottom:8px;">\
                      <span class="fl_logo">\
                             {roomName}\
                      </span>\
                      <a href="' + APP.urls.checkRecordList + '?roomCode={roomCode}" class="fl_more">\
                             宿舍检查详情&gt;&gt;\
                      </a>\
                 </p>\
                <div class="fl_l">\
                      <img src="resources/images/house.png" />\
                </div>\
               <div class="fl_r">\
                      <img src="{pricePath}"  class="fl_c_r">\
                      <div class="i_t" >\
                           <span class="tpc_w">楼号:</span>\
                           <span>{buildingNo}号</span>\
                           <span class="tpc_w">楼层号:</span>\
                           <span>{floorNo}楼</span>\
                      </div>\
                      <div class="i_t" >\
                           <span class="tpc_w">房间号:</span>\
                           <span>{roomNo}室</span>\
                      </div>\
                      <div class="i_t" >\
                           {rewardHtml}\
                           <input value="检查"  type="button" class="btn_tj" onclick="recommend({id},{roomCode},{buildingNo})"/>\
                     </div>\
              </div>\
              <div class="clear"></div>\
              </li>\
              ',
        isLoading: false,
        loadData: function (evt) {
            var that = this;
            if (that.isLoading) { return; }
            that.start_time = +new Date();
            that.isLoading = ele.isLoading = true;
            $.ajax({
                type: "POST",
                url: APP.urls.glist,
                data: {
                    "page.current": that.pageIndex,
                    "page.offset": that.pageSize,
                    "project.orderStyle":$eles.reqType,
                    "project.area":$eles.area,
                    "room.buildingNo": buildingNo,
                    "room.roomCode": roomCode
                },
                async: true,
                success: function (res) {
                    if (0 == res.Status) {
                        setTimeout(function () {
                            that.isLoading = ele.isLoading = false;
                            that.pageIndex++;
                            $("#glist2_ul").removeClass("isLoading");
                            window.glist2_ul.append($(that.rendData(res.Data)));
                            if (0 == res.total) {
                            	alert('暂无宿舍数据');
                                $eles.glist2_ul.addClass("empty");
                                ele.isEnding = true;
                            }
                            if (that.pageIndex > Math.ceil(res.total / that.pageSize)) {
                                window.myScroll.stop();
                                if (res.total) {
                                    ele.isEnding = true;
                                }
                            }
                        }, Math.max(0, that.start_time + 500 - new Date().getTime()));
                    }
                },
                dataType: "json"
            });
        },
        rendData: function (data) {
            var that = this, _html;
            _html = iTemplate.makeList(that.template3, data, function (k, v) {
            	var imgPath = "",rewardHtml = "";
            	var pricePath = "";
//            	if(v.priceImage && v.priceImage.filePath){
//            		pricePath = v.priceImage.filePath;
//            	}
//            	if(v.smallPictures.length > 0){
//            		imgPath = v.smallPictures[0].filePath;
//            	}
            	
            	rewardHtml = '\
			          <span class="tpc_w">房间类型：</span>\
			          <span>'+v.roomType+'</span>\
			         ';
            	
                return {
                    //areaName : v.areaInfo.areaName,
                    //imgPath : imgPath,
                    //pricePath : pricePath,
                    rewardHtml : rewardHtml   
                }
            });
            return _html;
        }
    };

    (function (win, doc) {
        var dc = localStorage.getItem("glist"), dataCache;
        if (dc && (dataCache = JSON.parse(dc)) && dataCache.flag) {

        } else {
            dataCache = {
                data: [],
                pageIndex: 1,
                pageSize: 10,
                index: 0,
                flag: false
            };
        }

        dataCache.recordInfo = function (thi, evt, index) {
            dataCache.flag = true;
            dataCache.index = index;
            dataCache.st = doc.body.scrollTop;
            dataCache.rows_html = [];
            for (var i = 0; i < window.glist2_ul.column; i++) {
                dataCache.rows_html.push(window.glist2_ul.rows[i].container.innerHTML);
            }
            localStorage.setItem("glist", JSON.stringify(dataCache));
        }
        dataCache.destroy = function () {
            localStorage.removeItem("glist");
        }

        win.dataCache = dataCache;
    })(window, document);

    $(function () {
    	buildingNo = $('#buildingNo').val();
    	roomCode = $('#roomCode').val();
    	
        $eles = {
            glist2_ul: $("#glist2_ul"),
            loading_bottom: null,
            reqType:"",
            area:""
        }
        //
        ele = (function () {
            function Ele() {
                var isLoading = false;
                var isEnding = false;

                Object.defineProperty(this, "isLoading", {
                    get: function () {
                        return isLoading;
                    },
                    set: function (v) {
                        isLoading = v;
                        if (!$eles.loading_bottom) {
                            $eles.loading_bottom = $(main.ele.loading_bottom);
                            $eles.glist2_ul.parent().append($eles.loading_bottom);
                        }
                        $eles.loading_bottom[isLoading ? "removeClass" : "addClass"]("vhidden");
                    }
                });
                Object.defineProperty(this, "isEnding", {
                    set: function (v) {
                	   if(v){
                           $eles.loading_bottom[v ? "removeClass" : "addClass"]("vhidden").addClass("nomore");
                	   }else{
                		   $eles.loading_bottom[v ? "removeClass" : "addClass"]("vhidden").removeClass("nomore"); 
                	   }
                    }
                });
            }
            //
            return new Ele();
        })();
        //
        window.myScroll = new scrollEvt(pageArgs);
        window.glist2_ul = new waterFall({
            column: 1,
            container: $("#glist2_ul")[0]
        }).init();
        if (dataCache && dataCache.data.length) {
            for (var i = 0, l = dataCache.rows_html.length; i < l; i++) {
                window.glist2_ul.rows[i].container.innerHTML = dataCache.rows_html[i];
            }
            pageArgs.pageIndex = dataCache.pageIndex;
            setTimeout(function () {
                window.scrollTo(0, dataCache.st);
                dataCache.destroy();
            }, 1000);
            if (!dataCache.end) {
                setTimeout(function () {
                    window.myScroll.start();
                }, 1500);
            }
        } else {
            pageArgs.loadData();
            window.myScroll.start();
        }
    });


});
