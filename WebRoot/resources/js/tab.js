// JavaScript Document
function ChangeDiv(divId, divName, zDivCount) {
	// 将所有的层都隐藏
	for (i = 0; i <= zDivCount; i++) {
		document.getElementById(divName + i).style.display = "none";
	}
	//显示当前层 
	document.getElementById(divName + divId).style.display = "block";
	
}

//JavaScript Document
function ChangeDiv2(divId, divName, zDivCount) {
	// 将所有的层都隐藏
	for (i = 0; i <= zDivCount; i++) {
		$("#span_" + i).attr("class","mx_tab");
		document.getElementById(divName + i).style.display = "none";
	}
	//显示当前层 
	document.getElementById(divName + divId).style.display = "block";
	$("#span_" + divId).attr("class","mx_tab thistab");
}