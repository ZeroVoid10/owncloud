function CheckPost(){
    var project = document.getElementById("project").value;
    var file = document.getElementById("file").value;
           if(project == ""){
        	   alert("请填写项目名称！");
        	   return false;
           }
           else if(file == ""){
        	   alert(name+"请选择上传文件！");
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
               checkpath();
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
    	   checkpath();
       }
       function download(){
    	   var path = document.getElementsByName("boxes[]").value;
    	   alert(path);
       }