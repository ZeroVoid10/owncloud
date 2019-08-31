<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "hp.fileRead.fileGet"
import = "java.lang.*"
import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload</title>
<style>
a {color: #696B83;TEXT-DECORATION: none}
a:active {background: #AFC1DC}
.DownButtonNormal{
    height: 18px;
    line-height: 18px;
    padding: 0 11px;
    background: rgb(120, 127, 162);
    border: 1px #E5E7EA solid;
    border-radius: 3px;
    display: inline-block;
    font-size: 12px;
    outline: none;
 }
input {color: #696B83;TEXT-DECORATION: none}
input:active {background: #AFC1DC}
.UpButtonNormal{
    height: 18px;
    line-height: 18px;
    padding: 0 11px;
    background: rgb(120, 127, 162);
    border: 1px #E5E7EA solid;
    border-radius: 3px;
    display: inline-block;
    font-size: 12px;
    outline: none;
 }
 table.fileTable{
    width:100%;
    
 }
 th{
    height:30px;
 }
 th.fileName{width:40%;}
 th.fileSize{width:20%;}
 th.fileDate{width:30%;}
 tr{
    height:25px;
 }
 
</style>
</head>
<body>
    <form action="UploadServlet" method = "post" name = "upload" enctype = "multipart/form-data">
             项目名称：<input name = "projectName" /><br/>
             文件标签：<input name = "fileTag" /><br/>
             上传文件：<input type = "file" name = "upFile" />
             <br/>
       <input class="UpButtonNormal" style="color:#ffffff" type = "submit" id = "upload" value = "上传文件" onclick = "return CheckPost();">
       
    </form>
       <script type = "text/javascript" >
       function CheckPost(){
           var file = upload.upFile.value;
           var project = upload.projectName.value;
           if(project == ""){
        	   alert("请填写项目名称！");
        	   return false;
           }
           else if(file == ""){
        	   alert("请选择上传文件！");
        	   return false;
           }
       }
       </script> 
       <script type="text/javascript">
       function allcheck() {
           var nn = allboxes.checked; 
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
       </script>
       <script type="text/javascript">
       function checkall() {
    	   var checkbox = document.getElementsByName("boxes[]");
    	   for(var i=0;i<checkbox.length ;i ++){ 
        	   if (checkbox[i].checked==false){
        		   allboxes.checked = false;
        		   break;
        	   }else {
        		   allboxes.checked = true;
        	   }
           }
           }
       </script>
    
    <table class = "fileTable">
        <tr>
            <td class = "fileSelect"><input name="allboxes" onclick="allcheck()" type="checkbox" value = "全选"/>全选</td>
            <th class = "fileName">文件名</th>
            <th class = "fileSize">文件大小</th>
            <th class = "fileDate">修改时间</th>
        </tr>
        <tr><td> <input  name="boxes[]" onclick="checkall()" type="checkbox"/> </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
        <tr><td> <input  name="boxes[]" onclick="checkall()" type="checkbox"/> </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
        <tr><td> <input  name="boxes[]" onclick="checkall()" type="checkbox"/> </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
    </table>
    <a class="DownButtonNormal" name="DownLoadHistEvent" style="color:#ffffff" download="1808.01244.pdf" 
    href = "DownloadServlet?filename = 1808.01244.pdf">下载文件</a>
    
</body>
</html>