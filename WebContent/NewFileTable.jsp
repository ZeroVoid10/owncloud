<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "hp.fileRead.fileGet"
import = "java.lang.*"
import = "java.io.*"
import = "java.util.*" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta charset="UTF-8">
    <title>协同办公资源管理子系统</title>

    <script type="text/javascript" src="js/upload.js"></script>


    <meta content="b31ebb7c3759312418b3645de4991aef" name="baidu-tc-verification">
    <meta content="max-age=30" http-equiv="Cache-Control">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
    
    <link rel="shortcut icon" href="img/favicon.ico">
    <link rel="stylesheet" type="text/css" href="css/cover.css">
    <link rel="stylesheet" type="text/css" href="css/upload.css">
    <link rel="stylesheet" node-type="theme-link" type="text/css" href="css/diskSystem-theme.css">
    <link rel="stylesheet" type="text/css" href="css/alpha.css">
    <link rel="stylesheet" type="text/css" href="css/function.css">
    <link rel="stylesheet" type="text/css" href="css/context-all_2b14e94.css">
    <link rel="stylesheet" type="text/css" href="css/all_fe4c0e3.css">
    <link rel="stylesheet" type="text/css" href="css/home-all_5215898.css">
    <link rel="stylesheet" type="text/css" href="css/disk.header.css">
    <script type="text/javascript" src="js/uploadButton.js"></script>
    <link rel="stylesheet" type="text/css" href="css/disk.header.css">

</head>

<body>

    <div class="frame-all" id="layoutApp">    
             <!-- 侧边列表 -->
                    <div class="frame-aside" id="layoutAside">
                                <div class="module-aside menu">
                                    <ul class="menu">
                                        <li>
                                            <a  path="/" hidefocus="true">
                                                <span class="text">
                                                    <span>全部文件</span>
                                                </span>
                                            </a>
                                        </li>
                                        <li class="menuTip">
                                            <a hidefocus="true"
                                                href="">
                                                <span class="text">
                                                    <span class="icon icon-disk"></span>
                                                    <span>图片</span>
                                                </span>
                                            </a>
                                        </li>
                                        <li class="menuTip">
                                            <a hidefocus="true"
                                                href="">
                                                <span class="text">
                                                    <span class="icon icon-disk"></span>
                                                    <span>文档</span>
                                                </span>
                                            </a>
                                        </li>
                                        <li class="menuTip">
                                            <a hidefocus="true"
                                                href="">
                                                <span class="text">
                                                    <span class="icon icon-disk"></span>
                                                    <span>视频</span>
                                                </span>
                                            </a>
                                        </li>
                                        <li class="menuTip">
                                            <a hidefocus="true"
                                                href="">
                                                <span class="text">
                                                    <span class="icon icon-disk"></span>
                                                    <span>音乐</span>
                                                </span>
                                            </a>
                                        </li>
                                        <li class="menuTip">
                                            <a hidefocus="true"
                                                href="">
                                                <span class="text">
                                                    <span class="icon icon-disk"></span>
                                                    <span>其他</span>
                                                </span>
                                            </a>
                                        </li>
                                        <li class="menuTip">
                                            <a hidefocus="true"
                                                href="">
                                                <span class="text">
                                                    <span class="icon icon-disk"></span>
                                                    <span>回收站</span>
                                                </span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
         
                <div class="frame-main" id="layoutMain" style="display: block;">
                                <div class="order g-clearfix">
                                <!-- 检索 -->
                                        <div class="search">
                                            <div class="searchbox" style="width: 50px;padding-right: 0px;padding-left: 0px;">
                                                <a class="g-button g-button-blue blue-upload" id="searchbutton" 
                                                     onclick = "showsearch();" title="搜索文件"
                                                    style="display: inline-block;"><span class="g-button-right"><em
                                                            class="icon icon-upload" title="搜索"></em><span class="text"
                                                            style="width: auto;">搜索文件</span></span></a>
                                                            <div id="sch" style="border: 1;position: absolute;width: 200;height: 200; background:#ffffff;visibility: hidden"></div>
                                                <!--  
                                                <form action=" " method="get">
                                                    <input data-key="SEARCH_QUERY"
                                                         class="inputbox" name="q" value=""type="text">
                                                    <span data-key="SEARCH_BUTTON" class="searchbutton">
                                                        <span class="icon icon-search"></span>
                                                    </span>
                                                    <span class="searchtxt"
                                                        style="display: block;">搜索您的文件</span>
                                                </form>
                                                -->
                                            </div>
                                        </div>
                                        <!-- 文件按键 -->
                                        <div class="button" style="white-space: nowrap; position: relative;">
                                            
                                            <div style="position: absolute; top: 0px; line-height: normal; padding-top: 11px; padding-left: 0px; width: auto;">
                                                
                                                <a class="g-button g-button-blue blue-upload" id="uploadbutton" 
                                                     onclick = "show();" title="上传文件"
                                                    style="display: inline-block;"><span class="g-button-right"><em
                                                            class="icon icon-upload" title="上传"></em><span class="text"
                                                            style="width: auto;">上传文件</span></span></a>
                                                            <div id="pic" style="border: 1;position: absolute;width: 200;height: 200; background:#ffffff;visibility: hidden"></div>
                                                            
                                                <a class="g-button" title="新建项目"
                                                    style="display: inline-block;"><span class="g-button-right"><em
                                                            class="icon icon-newfolder" title="新建项目"></em><span
                                                            class="text" style="width: auto;">新建项目</span></span></a>
                                                <a class="g-button" title="下载文件" onclick="checkpath();"
                                                    style="display: inline-block;"><span class="g-button-right"><em
                                                            class="icon icon-download" title="下载文件"></em><span
                                                            class="text"
                                                            style="width: auto;">下载文件</span></span></a>
                                                <a class="g-button" title="更多"><span class="g-button-right"><em
                                                            class="icon icon-more" title="更多"></em><span class="text"
                                                            style="width: auto;">更多</span></span></a><span class="menu"
                                                    style="width: 70px;"><a style="display:none;" data-menu-id="b-menu0"
                                                        class="g-button-menu g-menu-hasIcon" href=""><em
                                                            class="icon icon-upload"></em>上传</a>
                                                    <a style="display:none;" data-menu-id="b-menu1"
                                                        class="g-button-menu g-menu-hasIcon" href=""><em
                                                            class="icon icon-newfolder"></em>新建文件夹</a><a
                                                        style="display:none;" data-menu-id="b-menu2"
                                                        class="g-button-menu g-menu-hasIcon" href=""><em
                                                            class="icon icon-download"></em>离线下载</a>
                                                    <a style="display:none;" data-menu-id="b-menu3"
                                                        class="g-button-menu g-menu-hasIcon" href=""><em
                                                            class="icon icon-device"></em>我的设备</a></span></span>
                                            </div>
                                           </div>
                                    </div>
                                <!-- 文件面板 -->
                                    <div class="fileTable" style="height: 784px;">
                                        <div class="fileTop">
                                            <span>全部文件</span>
                                            <ul class="return" style="display: none;">
                                                <li><a data-deep="-1" href="">返回上一级</a><span
                                                        class="line">|</span></li>
                                                <li></li>
                                            </ul>
                                        </div>
                                        <div class="file-sortorder">
                                            <div class="sort-order">
                                                <ul class="toporder">
                                                    <li data-key="name" class="fileTab filename" style="width:50%;">
                                                        <div class="allcheck" style="margin-left: 4px;"><span
                                                                class="allcheckbox" style="top: 4px;"><input name="allboxes" id="allcheck"
                                                                    onclick="allcheck()" type="checkbox"
                                                                    value="全选" style="margin-top: auto;"/></span>
                                                         </div>
                                                         <span class="text">文件名</span>
                                                    </li>
                                                    <li data-key="size" class="fileTab fileSize" style="width:16%;"><span
                                                            class="text">大小</span></li>
                                                    <li data-key="time" class="fileTab filedate" style="width:23%;"><span
                                                            class="text">修改日期</span></li>
                                                    <li data-key="time" class="fileTab filedate" style="width:10%;"><span
                                                            class="text">上传人</span></li>
                                                </ul>
                                                
                                            </div>
                                        </div>
                                            <div class="table-main"
                                                style="overflow-y: auto; height: 726px;">
                                                <div class="filelist" style="height: auto;">
                                                    <% 
                                                    fileGet flg = new fileGet();
                                                    flg.setprojectPath("C:\\Users\\HP\\Desktop\\UpLoad");
                                                    flg.getFileName();
                                                    List<String>nl = flg.getNameList();
                                                    List<String>sl = flg.getSizeList();
                                                    List<String>dl = flg.getDateList();
                                                    List<String>pl = flg.getPathList();
                                                    List<String>cl = flg.getChangeList();
                                                    int len = nl.size();
        
                                                    for(int i = 0;i<len;i++){ %>
                                                    <dd class="g-clearfix filelable open-enable"><span
                                                             class="checkboxlabel"><input name="boxes[]"
                                                                onclick="checkall()" type="checkbox" id="check"
                                                                value="<%= pl.get(i) %>" /></span></span>
                                                        <div class="file-img dir-small"><img src="img/<%= cl.get(i) %>.png" style="width:26px;height:26px;"></div>
                                                        <div class="file-name" style="width:50%">
                                                            <div class="text"><a href="<%= pl.get(i) %>"
                                                                    title="<%= nl.get(i) %>"><%= nl.get(i) %></a></div>
                                                        </div>
                                                        <div class="file-size" style="width:16%"><%= sl.get(i) %></div>
                                                        <div class="file-date" style="width:23%"><%= dl.get(i) %></div>
                                                        <div class="file-date" style="width:10%">灰原哀</div>
                                                    </dd>

                                                    <% } %>
                                                </div>
                                            </div>
                                    </div>
                </div>
        <!-- TOP -->
        <div id="layoutHeader">
            <div class="module-header">
                <div class="module-header-wrapper" style="height: 62px;">
                    <dl class="header-table">
                        <!-- LOGO -->
                        <dt class="logo">
                            <a href="" class="logo-top" href="" target="_self" title="协同办公资源管理子系统" style="margin-left:40px;"></a>
                        </dt>
                        <dd class="header-link">
                            <span class="header-label header-home">
                                <a href="" target="_self" title="文件">文件</a>
                            </span>
                            <span class="header-label" node-type="mbox-homepage">
                                <a href="" target="_self" title="分享"">分享</a>
                            </span>
                            <span class="header-label" node-type="pan-mall">
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
        <div>

        </div>
    </div>
</body>

</html>