function show(){
            var x=event.clientX;
            var y=event.clientY;
            document.getElementById("pic").style.top=y+50;
            document.getElementById("pic").style.left=x;
            document.getElementById("pic").style.visibility="visible";
            var formDiv="<form action='UploadServlet' method = 'post' name = 'upload' enctype = 'multipart/form-data'style='padding-left: 6px;'>";
            formDiv+="<div style = 'color:#0080ff;font-size:13px;padding-top: 4px;padding-bottom: 4px;'>项目名称：</div><input name = 'projectName' id = 'project'/><br/>";
            formDiv+="<div style = 'color:#0080ff;font-size:13px;padding-top: 4px;padding-bottom: 4px;'>文件标签：</div><input name = 'fileTag' id = 'tag'/><br/>";
            formDiv+="<div style = 'color:#0080ff;font-size:13px;padding-top: 4px;padding-bottom: 4px;'>上传文件：</div><input type = 'file' name = 'upFile' id = 'file'/><br/><br/>";
            formDiv+="<input class='uploadbutton' style='color:#ffffff;margin-bottom:10px' type = 'submit' id = 'upload' value = '上    传' onclick = 'return CheckPost();'></form>";     
            document.getElementById("pic").innerHTML=formDiv;
            var curObj=document.getElementById("uploadbutton");
            curObj.onclick = function onclick(event){hide()};
        }
         
        function hide(){
        	document.getElementById("pic").style.visibility="hidden";
        	var curObj=document.getElementById("uploadbutton");  
            curObj.onclick = function onclick(event){show()};
        }