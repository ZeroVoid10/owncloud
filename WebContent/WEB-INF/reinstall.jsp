<!--开发调试文件，存在改文件系统不安全。-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% application.removeAttribute("installed"); %>
<!DOCTYPE html>

<html>
<head>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script type="text/javascript">
    $(function(){
        reinstall();    
    })
    function reinstall() {
        $.ajax({
            type: 'GET',
            url: 'ReinstallServlet',
            async: false
        })

    }

    </script>
</head>
<body>
    Have remove Attribute "installed".
</body>
</html>
