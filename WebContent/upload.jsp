<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "hp.fileRead.*"
import = "java.lang.*"
import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload</title>
<link rel="stylesheet" type="text/css" href="css/upload.css">
<script type="text/javascript" src = "js/upload.js"></script>
</head>
<body>

    <form class = "inputform" action="UploadServlet" method = "post" name = "upload" enctype = "multipart/form-data">
       <div class = "inputfield">项目名称：<input name = "projectName" id = "project"/></div>
       <div class = "inputfield">文件标签：<input name = "fileTag" id = "tag"/></div>
       <div class = "inputfield">上传文件：<input type = "file" name = "upFile" id = "file"/></div>
       <input class="uploadbutton" style="color:#ffffff" type = "submit" id = "upload" value = "上传文件" onclick = "return CheckPost();">
       
    </form>
       
    
    <table class = "fileTable">
        <tr>
            <td class = "fileSelect"><input name="allboxes" id ="allcheck" onclick="allcheck()" type="checkbox" value = "全选"/></td>
            <th class = "fileName">文件名</th>
            <th class = "fileSize">文件大小</th>
            <th class = "fileDate">修改时间</th>
        </tr>
        <% 
        fileGet flg = new fileGet();
        flg.getFileName();
        List<String>nl = fileGet.getNameList();
        List<String>sl = fileGet.getSizeList();
        List<String>dl = fileGet.getDateList();
        List<String>pl = fileGet.getPathList();
        String fileName = "1808.01244.pdf";    //临时
        int len = nl.size();
        
        for(int i = 0;i<len;i++){ %>
        <tr><td> <input  name="boxes[]" onclick="checkall()" type="checkbox" id = "check" value="<%= pl.get(i) %>"/> </td><td> <a><%= nl.get(i) %></a> </td><td> <a><%= sl.get(i) %></a> </td><td> <a><%= dl.get(i) %></a> </td></tr>
        <% } %>
    </table>
    <a class="downloadbutton" id="download" style="color:#ffffff" name="" onclick = "download()"
    href = "DownloadServlet?filename = 1808.01244.pdf">下载文件</a>
    
</body>
</html>