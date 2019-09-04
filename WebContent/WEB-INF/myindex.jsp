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
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script src="https://kit.fontawesome.com/e44685b5e0.js"></script>
    <link rel="stylesheet" href="css/homepage.css">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/function.css">
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
                            <span class='item-box'>
                                全部文件
                            </span>
                        </a>
                    </li>

                    <li>
                        <a href="">
                            <span class='item-box'>
                                图片
                            </span>
                        </a>
                    </li>

                    <li>
                        <a href="">
                            <span class='item-box'>
                                文档
                            </span>
                        </a>
                    </li>

                    <li>
                        <a href="">
                            <span class='item-box'>
                                视频
                            </span>
                        </a>
                    </li>

                    <li>
                        <a href="">
                            <span class='item-box'>
                                音乐
                            </span>
                        </a>
                    </li>
                    
                    <li>
                        <a href="">
                            <span class='item-box'>
                                其他
                            </span>
                        </a>
                    </li>

                </ul>
            </div>
        </div>
        <div class='layout-main'>
            <div class='tool-bar'>
                <div class='right-first-box'>
                    <a href="" class='item-icon'>
                        <i class="fas fa-th-large"></i>
                    </a>
                </div>

                <div class='right-second-box'>
                    <a href="" class='item-icon'>
                        <i class="fas fa-sort"></i>
                    </a>
                </div>

                <div class='search-box'>
                    <div class='search'>
                        <form>
                            <input type="text" placeholder="搜索您的文件">
                        </form>
                        <span class='icon'>
                            <i class="fas fa-search"></i>
                        </span>
                    </div>
                </div>

                <div class='tool-bar-left'>
                    <div class='tool'>
                        <span class='tool-button'>

                        </span>
                        <a class='tool-button2' title="新建文件夹" href="">
                            <span class='right'>
                                <i class="fas fa-folder-plus"></i>
                                <span class='text'>新建文件夹</span>
                            </span>
                        </a>
                    </div>

                </div>
            </div>
        </div>
    </div>
</body>
</html>
