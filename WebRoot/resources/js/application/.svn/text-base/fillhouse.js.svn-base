var yes = "resources/images/radio_yes.png";
var no = "resources/images/radio_no.png";


function radionButtonClick (obj)
{
	//判断点击的按钮  是或否
    var btnName = "";
    var btnOther = "";
    var btnNowStatus = "";
    var btnType = "";

    if($(obj).attr("id").indexOf("yes") < 0)
    {
        btnName  =  $(obj).attr("id").substring(0,$(obj).attr("id").indexOf("no")) + "no";
        btnOther	=  $(obj).attr("id").substring(0,$(obj).attr("id").indexOf("no")) + "yes";
        btnType  =  $(obj).attr("id").substring(0,$(obj).attr("id").indexOf("no")); 
       		       
	       if($(obj).attr("src").indexOf("yes") < 0)
	       {
	          btnNowStatus = "no";
	       }
	       else
	       {
	          btnNowStatus = "yes";
	       }
    }
    else
    {
    	   btnName  = $(obj).attr("id").substring(0,$(obj).attr("id").indexOf("yes")) + "yes";
    	   btnOther = $(obj).attr("id").substring(0,$(obj).attr("id").indexOf("yes")) + "no";
    	   btnType  = $(obj).attr("id").substring(0,$(obj).attr("id").indexOf("yes"));
    	   
    	   if($(obj).attr("src").indexOf("yes") < 0)
	       {
	          btnNowStatus = "no";
	       }
	       else
	       {
	          btnNowStatus = "yes";
	       }  
    }

    if( btnNowStatus == "no" )
    {
       $("#"+ btnName).attr("src",yes);
       $("#"+ btnOther).attr("src",no);   
    }
    if(btnType == "car")
    {
       $("#carLoan").val($("#"+ btnName).attr("imgval")); 
    }
    else if (btnType == "house")
    {
 	  $("#mortgage").val($("#"+ btnName).attr("imgval")); 
    }   
}

function singleRadionButtonClick (obj,radiohidden)
{
	 if($(obj).attr("id").indexOf("yes") < 0)
	    {
	        btnName  =  $(obj).attr("id").substring(0,$(obj).attr("id").indexOf("no")) + "no";
	        btnOther	=  $(obj).attr("id").substring(0,$(obj).attr("id").indexOf("no")) + "yes";
	       		       
		    if($(obj).attr("src").indexOf("yes") < 0)
		    {
		         btnNowStatus = "no";
		    }
		    else
		    {
		         btnNowStatus = "yes";
		    }
	    }
	    else
	    {
	    	   btnName  = $(obj).attr("id").substring(0,$(obj).attr("id").indexOf("yes")) + "yes";
	    	   btnOther = $(obj).attr("id").substring(0,$(obj).attr("id").indexOf("yes")) + "no";
	    	   
	    	   if($(obj).attr("src").indexOf("yes") < 0)
		       {
		          btnNowStatus = "no";
		       }
		       else
		       {
		          btnNowStatus = "yes";
		       }  
	    }

	    if( btnNowStatus == "no" )
	    {
	       $("#"+ btnName).attr("src",yes);
	       $("#"+ btnOther).attr("src",no);    
	    }	
	    
	    $("#"+radiohidden).val($("#"+ btnName).attr("imgval")); 

}

