function For_CompaniesInfo_AssetSize(e,t,n){
	var r=new RGraph.Bar("cvs",GetNumList(t));
	r.Set("labels",e),
	r.Set("colors.sequential",!0),
	r.Set("shadow",!0),
	r.Set("shadow.color","#000"),
	r.Set("background.grid.hlines",!1),
	r.Set("background.grid.vlines",!1),
	r.Set("background.grid.border",!1),
	r.Set("ymax",GetMaxInList(t,5)),
	r.Set("chart.tooltips",GetStrList(t)),
	r.Set("chart.tooltips.event","onmousemove"),
	r.Set("chart.key",["资产规模(亿元)","环比增幅(%)"]),
	r.Set("chart.key.colors",GetColors(2)),
	r.Set("chart.key.position","gutter"),
	r.Set("key.position.gutter.boxed",!1),
	r.Set("key.background","rgb(255,255,255)"),
	r.Set("key.position.x",r.canvas.width/2-100),
	r.Set("key.position.y",r.canvas.height-30),
	r.Set("hmargin",25),r.Set("gutter.left",35),
	r.Set("gutter.right",45),
	r.Set("gutter.bottom",65);
	var i=new RGraph.Line("cvs",GetNumList(n));
	i.Set("tooltips",GetStrList(n,"%")),
	i.Set("chart.ymax",GetMaxInList(n,5)),
	i.Set("chart.yaxispos","right"),
	i.Set("ylabels.count",3),
	i.Set("background.grid",!1),
	i.Set("xaxispos","center"),
	i.Set("linewidth",2),
	i.Set("units.post","%"),
	i.Set("chart.colors",GetColors(2,1)),
	i.Set("hmargin",(i.canvas.width-i.Get("chart.gutter.left")-i.Get("chart.gutter.right"))/(r.data.length*2)),
	i.Set("gutter.right",45),
	i.Set("gutter.left",35),
	i.Set("gutter.bottom",65);
	var s=GetSameness(GetStrList(t).length);
	r.Set("colors",s),
	typeof Worker!="undefined"?(RGraph.Clear(r.canvas),RGraph.Redraw(),RGraph.Effects.Bar.Grow(r),RGraph.Effects.Line.jQuery.Trace(i)):(alert("由于当前web浏览器版本较低，图表无法显示动画，建议您选择支持html5的浏览器"),r.Draw(),i.Draw()
   )}
   function ForYieldMovements(e,t,n,i){
	 var s=new RGraph.Line("cvs",GetNumList(e),GetNumList(t),GetNumList(n));
      s.Set("background.grid.vlines",!0),
      s.Set("background.color","#fffde7"),
      s.Set("chart.labels",i),
      s.Set("linewidth",2),
      s.Set("tooltips",GetStrList(e),GetStrList(t),GetStrList(n)),
      s.Set("chart.colors",GetColors(4)),
      s.Set("chart.ymax",GetMaxInList([GetNumList(e),GetNumList(t),GetNumList(n)],.5)),
      s.Set("chart.ymin",GetMinInList([GetNumList(e),GetNumList(t),GetNumList(n)],.5)),
      s.Set("scale.decimals",1),
      s.Set("hmargin",30),
      s.Set("gutter.bottom",30),
      s.Set("chart.tickmarks","circle"),
      s.Set("chart.key",["3月","6月","9月"]),
      s.Set("chart.key.colors",GetColors(4)),
      s.Set("chart.key.position.y",5),
      s.Set("chart.key.position","gutter"),
      s.Set("text.size",8),
      typeof Worker!="undefined"?(RGraph.Redraw(),RGraph.Effects.Line.jQuery.UnfoldFromCenterTrace(s,{duration:1e3})):s.Draw()
    }
   function ExpectedBenefits(e,t,n){alert(1);var r=new RGraph.Bar("cvs2",GetNumList(e));r.Set("labels",GetStrList(t)),r.Set("ymax",GetMaxInList(e,1)),r.Set("hmargin",15),r.Set("scale.decimals",1),r.Set("chart.tooltips",GetStrList(e)),r.Set("chart.tooltips.event","onmousemove"),r.Set("background.color","#f5f8ff"),r.Set("chart.key",[n]),r.Set("chart.key.colors",["#ffffff"]),r.Set("chart.key.position","gutter"),r.Set("text.size",8),r.Set("key.position.gutter.boxed",!1),r.Set("key.background","rgb(255,255,255)"),r.Set("key.position.x",r.canvas.width/2-100),r.Set("key.width",400);var i=GetSameness(GetStrList(e).length);r.Set("colors",["#4d4398"]),typeof Worker!="undefined"?(RGraph.Clear(r.canvas),RGraph.Redraw(),RGraph.Effects.Bar.Grow(r)):r.Draw()}function GetNumList(e){for(var t=0;t<e.length;t++)e[t]=e[t]*1;return e}function GetStrList(e,t){t==null&&(t="");var n=[];for(var r=0;r<e.length;r++)typeof e[r]=="object"?n[r]=GetStrList(e[r]):n[r]=e[r].toString()+t;return n}function GetComplexList(e,t){for(var n=0;n<e.length;n++)e[n]=e[n].split(t);return e}function getQueryString(e){var t=new RegExp("(^|&)"+e+"=([^&]*)(&|$)","i"),n=window.location.search.substr(1).match(t);return n!=null?unescape(n[2]):null}function GetMaxInList(lists,cz){var max=0,num=0,list=lists.join(",").split(",");for(var i=0;i<list.length;i++)typeof list[i]=="object"?num=eval(list[i].join("+")):num=list[i],num=Math.abs(num),num>max&&(max=num);return cz==null&&(cz=0),max+cz}function GetMinInList(lists,cz){var min=9999999999,num=0,list=lists.join(",").split(",");for(var i=0;i<list.length;i++)typeof list[i]=="object"?num=eval(list[i].join("+")):num=list[i],num=Math.abs(num),num<min&&(min=num);return cz==null&&(cz=0),min-cz}function GetColors(e,t,n){t==null&&(t=0);var r=["#4d4398","#659942","#ffaa14","#ea5404","#BFBFBF","#1A3B69","#FFE382","#129CD0","#CA6B4B","#A64DFF"];return r.slice(t,e)}function GetSameness(e){var t=GetColors(1),n=[];for(var r=0;r<e;r++)n=n.concat(t);return n}function SetListLocation(e){for(var t=0;t<e.length;t++)t%2==1&&(e[t]="\r\n"+e[t]);return e};