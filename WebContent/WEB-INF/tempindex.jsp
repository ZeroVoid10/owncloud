<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta charset="UTF-8">
    <title>协同办公资源管理子系统</title>

    <script type="text/javascript" src="js/upload.js"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">

    <link rel="shortcut icon" href="img/favicon.ico">
    <script src="https://kit.fontawesome.com/e44685b5e0.js"></script>
    <link rel="stylesheet" type="text/css" href="css/cover.css">
    <link rel="stylesheet" type="text/css" href="css/upload.css">
    <link rel="stylesheet" type="text/css" href="css/alpha.css">
    <link rel="stylesheet" type="text/css" href="css/function.css">
    <link rel="stylesheet" type="text/css" href="css/context-all_2b14e94.css">
    <link rel="stylesheet" type="text/css" href="css/all_fe4c0e3.css">
    <link rel="stylesheet" type="text/css" href="css/home-all_5215898.css">
    <script type="text/javascript" src="js/uploadButton.js"></script>
    <link rel="stylesheet" type="text/css" href="css/homepage.css">
</head>

<body>

    <div class="frame-all" id="layoutApp">
        <div class="layout-header">
            <div class='header'>
                <dl class='top-bar'>
                    <dt class='logo'>
                        <a href="/index" title="资源管理系统"></a>
                    </dt>
                    <dd class='app-list'>
                        <span class='item-wrap'>
                            <a href="">项目资源</a>
                        </span>
                        <span class='item-wrap'>
                            <a href="/index">项目详细</a>
                        </span>
                    </dd>
                </dl>
            </div>
        </div>
        <!-- 侧边列表 -->
        <div class="frame-aside" id="layoutAside">
            <div class="module-aside menu">
                <ul class="menu">
                    <li>
                        <a path="/" hidefocus="true">
                            <span class="text">
                                <i class="fas fa-file-alt"></i>
                                <span>全部文件</span>
                            </span>
                        </a>
                    </li>
                    <li class="menuTip">
                        <a hidefocus="true" href="">
                            <span class="text">
                                <i class="fas fa-image"></i>
                                <span>图片</span>
                            </span>
                        </a>
                    </li>
                    <li class="menuTip">
                        <a hidefocus="true" href="">
                            <span class="text">
                                <i class="fas fa-file"></i>
                                <span>文档</span>
                            </span>
                        </a>
                    </li>
                    <li class="menuTip">
                        <a hidefocus="true" href="">
                            <span class="text">
                                <i class="fas fa-file-video"></i>
                                <span>视频</span>
                            </span>
                        </a>
                    </li>
                    <li class="menuTip">
                        <a hidefocus="true" href="">
                            <span class="text">
                                <i class="fas fa-file-audio"></i>
                                <span>音乐</span>
                            </span>
                        </a>
                    </li>
                    <li class="menuTip">
                        <a hidefocus="true" href="">
                            <span class="text">
                                <i class="fas fa-bars"></i>
                                <span>其他</span>
                            </span>
                        </a>
                    </li>
                    <li class="menuTip">
                        <a hidefocus="true" href="">
                            <span class="text">
                                <i class="fas fa-trash"></i>
                                <span>回收站</span>
                            </span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="frame-main" id="layoutMain" style="display: block;">
            <div class="order g-clearfix">
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
                <!-- 检索 -->
                <div class="search">
                    <div class="searchbox">
                        <form action=" " method="get">
                            <input data-key="SEARCH_QUERY" class="inputbox" name="q" value="" type="text">
                            <span data-key="SEARCH_BUTTON" class="searchbutton">
                                <i class="fas fa-search"></i>
                            </span>
                            <span class="searchtxt" style="display: block;">搜索您的文件</span>
                        </form>
                    </div>
                </div>
                <!-- 文件按键 -->
                <div class="button" style="white-space: nowrap; position: relative;">

                    <div
                        style="position: absolute; top: 0px; line-height: normal; padding-top: 11px; padding-left: 0px; width: auto;">

                        <a class="g-button g-button-blue blue-upload" id="uploadbutton" onclick="show();" title="上传文件"
                            style="display: inline-block;">
                            <span class="g-button-right">
                            <i class="fas fa-upload"></i>
                            <span class="text" style="width: auto;">上传文件</span>
                        </span>
                    </a>
                        <div id="pic"
                            style="border: 1;position: absolute;width: 200;height: 200; background:#ffffff;visibility: hidden">
                        </div>

                        <a class="g-button" title="新建项目" style="display: inline-block;"><span class="g-button-right">
                                <i class="fas fa-folder-plus"></i>
                                    <span class="text"
                                    style="width: auto;">新建文件夹</span></span></a>
                        <a class="g-button" title="下载文件" style="display: inline-block;"><span class="g-button-right">
                                <i class="fas fa-download"></i>
                                    <span class="text"
                                    style="width: auto;">下载文件</span></span></a>
                        <a class="g-button" title="更多"><span class="g-button-right">
                                <i class="fas fa-ellipsis-v"></i>
                                    <span class="text" style="width: auto;">更多</span></span></a><span
                            class="menu" style="width: 70px;"><a style="display:none;" data-menu-id="b-menu0"
                                class="g-button-menu g-menu-hasIcon" href=""><em class="icon icon-upload"></em>上传</a>
                            <a style="display:none;" data-menu-id="b-menu1" class="g-button-menu g-menu-hasIcon"
                                href=""><em class="icon icon-newfolder"></em>新建文件夹</a><a style="display:none;"
                                data-menu-id="b-menu2" class="g-button-menu g-menu-hasIcon" href=""><em
                                    class="icon icon-download"></em>离线下载</a>
                            <a style="display:none;" data-menu-id="b-menu3" class="g-button-menu g-menu-hasIcon"
                                href=""><em class="icon icon-device"></em>我的设备</a></span></span>
                    </div>
                </div>
            </div>
            <!-- 文件面板 -->
            <div class="fileTable" style="height: 784px;">
                <div class="fileTop">
                    <span>全部文件</span>
                    <ul class="return" style="display: none;">
                        <li><a data-deep="-1" href="">返回上一级</a><span class="line">|</span></li>
                        <li></li>
                    </ul>
                </div>
                <div class="file-sortorder">
                    <div class="sort-order">
                        <ul class="toporder">
                            <li data-key="name" class="fileTab filename" style="width:50%;">
                                <div class="allcheck"><span class="allcheckbox"><input name="allboxes" id="allcheck"
                                            onclick="allcheck()" type="checkbox" value="全选" /></span>
                                </div>
                                <span class="text">文件名</span>
                            </li>
                            <li data-key="size" class="fileTab fileSize" style="width:16%;"><span class="text">大小</span>
                            </li>
                            <li data-key="time" class="fileTab filedate" style="width:23%;"><span
                                    class="text">修改日期</span></li>
                            <li data-key="time" class="fileTab filedate" style="width:10%;"><span
                                    class="text">上传人</span></li>
                        </ul>

                    </div>
                </div>
                <div class="table-main" style="overflow-y: auto; height: 726px;">
                    <div class="filelist" style="height: auto;">
                        <script id='file-list'>
                            <dd class="g-clearfix filelable open-enable">
                                <input name="boxes[]" onclick="checkall()" 
                                        type="checkbox" id="check"
                                        value="" />
                                <div class="file-img dir-small">
                                    <img src="img/<%= cl.get(i) %>.png"
                                         style="width:26px;height:26px;"/>
                                </div>
                                <div class="file-name" style="width:50%">
                                    <div class="text"><a href="" title="<%= nl.get(i) %>"><%= nl.get(i) %></a></div>
                                </div>
                                <div class="file-size" style="width:16%"><%= sl.get(i) %></div>
                                <div class="file-date" style="width:23%"><%= dl.get(i) %></div>
                                <div class="file-date" style="width:10%">灰原哀</div>
                            </dd>
                        </script>
                    </div>
                </div>
            </div>
        </div>
        <!-- TOP 
        <div id="layoutHeader">
            <div class="module-header">
                <div class="module-header-wrapper" style="height: 62px;">
                    <dl class="header-table">
                        <dt class="logo">
                            <a href="" class="logo-top" href="" target="_self" title="协同办公资源管理子系统"
                                style="margin-left:40px;"></a>
                        </dt>
                        <dd class="header-link">
                            <span class="header-label header-home">
                                <a href="" target="_self" title="文件">文件</a>
                            </span>
                            <span class="header-label" node-type="mbox-homepage">
                                <a href="" target="_self" title="分享"">分享</a>
                            </span>
                            <span class=" header-label" node-type="pan-mall">
                                    <a href="" target="_blank" title="找资源">找资源</a>
                            </span>
                            <span class="header-label">
                                <a href="" target="_self" title="更多" node-type="item-title">更多</a>
                            </span>
                        </dd>
                    </dl>
                </div>
            </div>
        </div>
    -->
        <div>

        </div>
    </div>
</body>

</html>