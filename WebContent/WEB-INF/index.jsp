<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if (application.getAttribute("installed") == null) {%>
    <jsp:forward page="install.jsp"/>
<% } %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>资源管理系统</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/function.css">
    <link rel="stylesheet" href="css/homepage.css">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script src="js/util.js"></script>
</head>
<body>
    <div class='frame-all' id='layoutApp'>
        <div class="layout-header">
            <div class='header'>
                <dl class='top-bar'>
                    <dt class='logo'>
                        <a href="/index" title="资源管理系统"></a>
                    </dt>
                    <dd class='app-list'>
                        <span class='item-wrap'>
                            <a href="">项目</a>
                        </span>
                        <span class='item-wrap'>
                            <a href="/index">项目资源</a>
                        </span>
                    </dd>

                    <dd class='user-info-wrap'>
                        <span class='userinfo'>
                            <span class='usrname'>ZeroVoid</span>
                        </span>
                    </dd>
                </dl>
            </div> 
        </div>
        <div class="layout-aside">
            <div class='aside-wrap'>
                <ul>
                    <li>
                        <a href="">
                            <span>
                                全部文件
                            </span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class='layout-main'>
            main
        </div>
    </div>
</body>
</html>
