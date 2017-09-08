/**
 * 带标示的折线 divId:报表所放层的ID title:标题 xAxis:X轴区间值 yAxisTitle:Y周对应的描述 seriesName:点击描述
 * data:显示的数据
 */
function curveReoprtClickDisplay(divId, title, xAxis, yAxisTitle, valueSuffix,
		seriesName, data, reportType) {
	var str = ""; 
	if (reportType == 1) {
		str = "spline";
	} else if (reportType == 2) {
		str = "column";
	}
	$('#' + divId).highcharts(
			{
				colors: ["#008866"],
				chart : {
					type : str,
					backgroundColor : {
						linearGradient : {
							x1 : 0,
							y1 : 0,
							x2 : 0,
							y2 : 1
						},
						stops : [ [ 0, 'rgb(255, 255, 255)' ],
								[ 1, 'rgb(218, 242, 236)' ] ]
					}
				},
				credits : {
					enabled : false
				},
				exporting : {
					enabled : false
				},
				title : {
					text : title,
					x : -20
				// center
				},

				xAxis : {
					categories : xAxis
				},
				yAxis : {
					title : {
						text : yAxisTitle
					},
					plotLines : [ {
						value : 0,
						width : 1,
						color : '#808080'
					} ]
				},
				tooltip : {
					valueSuffix : valueSuffix
				},
				legend : {
					layout : 'vertical',
					align : 'right',
					verticalAlign : 'middle',
					borderWidth : 0
				},
				series : [ {
					name : seriesName,
					data : data
				} ]
			});

	/**
	 * 显示值得折线图 divId:报表所放层的ID title:标题 xAxis:X轴区间值 yAxisTitle:Y周对应的描述
	 * seriesName:点击描述 data:显示的数据
	 */
	function curveReoprt(divId, title, xAxis, yAxisTitle, seriesName, data) {
		$('#' + divId).highcharts(
				{
					credits : {
						enabled : false
					},
					exporting : {
						enabled : false
					},
					chart : {
						type : 'line'
					},
					title : {
						text : title
					},
					xAxis : {
						categories : xAxis
					},
					yAxis : {
						title : {
							text : yAxisTitle
						}
					},
					tooltip : {
						enabled : false,
						formatter : function() {
							return '<b>' + this.series.name + '</b><br/>'
									+ this.x + ': ' + this.y;
						}
					},
					plotOptions : {
						line : {
							dataLabels : {
								enabled : true
							},
							enableMouseTracking : false
						}
					},
					series : [ {
						name : seriesName,
						data : data
					} ]
				});
	}
	
}

function canvasReport(divId, title, xAxis, yAxisTitle, valueSuffix,data,reportType){
	var chartType = "";
	if (reportType == 1) {
		chartType = "line";
	} else if (reportType == 2) {
		chartType = "column";
	}
	$('#' + divId).highcharts(
			{
				chart : {
					type : chartType,
					backgroundColor : {
						linearGradient : {
							x1 : 0,
							y1 : 0,
							x2 : 0,
							y2 : 1
						},
						stops : [ [ 0, 'rgb(255, 255, 255)' ],
						          [ 1, 'rgb(224, 224, 224)' ] ]
					}
				},
				credits : {
					enabled : false
				},
				exporting : {
					enabled : false
				},
				title : {
					text : title,
					x : -20
				},
				xAxis : {
					categories : xAxis
				},
				yAxis : {
					title : {
						text : yAxisTitle
					},
					plotLines : [ {
						value : 0,
						width : 1,
						color : '#808080'
					} ]
				},
				tooltip : {
					valueSuffix : valueSuffix
				},
				legend : {
					layout : 'vertical',
					align : 'right',
					verticalAlign : 'middle',
					borderWidth : 0,
					pointWidth:40
				},
				series : data
			});
}

function PieReport(divId, title, altTile, data){
	$('#' + divId).highcharts({
			chart: {
		        plotBackgroundColor: null,
		        plotBorderWidth: null,
		        plotShadow: false
		    },
		    title: {
		        text: title
		    },
		    tooltip: {
			    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
		    },
		    credits : {
				enabled : false
			},
		    plotOptions: {
		        pie: {
		            allowPointSelect: true,
		            cursor: 'pointer',
		            dataLabels: {
		                enabled: true,
		                color: '#000000',
		                connectorColor: '#000000',
		                format: '<b>{point.name}</b>: {point.percentage:.1f} %'
		            }
		        }
		    },
			series : [{
	            type: 'pie',
	            name: altTile,
	            data: data
	        }]
	});
}

/**
 * 十个个月会员卡的充值 或者消费记录的图表
 * @param id
 * @param titleName
 * @param data
 */
function canvasMemberCardReport(id,titleName,leftTile,data){
	  $('#' + id).highcharts({
	        chart: {
	            type: 'column'
	        },
	        credits : {
				enabled : false
			},
			exporting : {
				enabled : false
			},
			title : {	
				text : titleName
			},
	        xAxis: {
	            categories: ['一月','二月','三月',
	                '四月','五月','六月','七月',
	                '八月','九月','十月','十一月',
	                '十二月']},
	        yAxis : {
				title : {
					text : leftTile
				}
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.001,
	                borderWidth: 0,
	                pointWidth:40
	            }
	        },
	        tooltip : {
				valueSuffix : '元'
			},
			legend : {
				layout : 'vertical',
				align : 'right',
				verticalAlign : 'middle',
				borderWidth : 0
			},
	        series: [{
	            name:'金额',
	            data: data
	        }]
	    });  
}