function CheckPost(){
    var project = document.getElementById("project").value;
    var file = document.getElementById("file").value;
           if(project == ""){
        	   alert("请填写项目名称！");
        	   return false;
           }
           else if(file == ""){
        	   alert("请选择上传文件！");
        	   return false;
           }
       }
function CheckSearch(){
	var searchpro = document.getElementById("searchproject").value;
    var searchtag = document.getElementById("searchtag").value;
    var searchfile = document.getElementById("searchfile").value;
	if(searchpro == ""&&searchtag == ""&&searchfile == ""){
 	   alert("请输入搜索项");
 	   return false;
    }
}
       function checkpath(){
    	   var path = "";
    	   var checkbox = document.getElementsByName("boxes[]");
    	   for(var i=0;i<checkbox.length ;i ++){ 
    		   if(checkbox[i].checked==true){
    			   path += checkbox[i].value +";";
    		   }
    	   }
    	   alert(path);
       }
       function allcheck() {
           var nn = document.getElementById("allcheck").checked; 
               if(nn == true) {
            	   var checkbox = document.getElementsByName("boxes[]");
            	   for(var i=0;i<checkbox.length ;i ++){ 
                	   checkbox[i].checked=true;
                   }
               }
               if(nn == false) {
            	   var checkbox = document.getElementsByName("boxes[]");
            	   for(var i=0;i<checkbox.length ;i ++){ 
                	   checkbox[i].checked=false;
                   }
               }
           }
       function checkall() {
    	   var checkbox = document.getElementsByName("boxes[]");
    	   for(var i=0;i<checkbox.length ;i ++){ 
        	   if (checkbox[i].checked==false){
        		   document.getElementById("allcheck").checked = false;
        		   break;
        	   }else {
        		   document.getElementById("allcheck").checked = true;
        	   }
           }
       }
       function download(){
    	   var path = document.getElementsByName("boxes[]").value;
    	   alert(path);
       }