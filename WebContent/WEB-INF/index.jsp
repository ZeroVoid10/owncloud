<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% if (application.getAttribute("installed") == null) {%>
    <jsp:forward page="install"/>
<% } %>
<%@ page import = "hp.fileRead.*"
import = "hp.project.*"
import = "java.lang.*"
import = "java.io.*"
import = "java.util.*" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta charset="UTF-8">
    <title>协同办公资源管理子系统</title>


    <meta content="max-age=30" http-equiv="Cache-Control">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
    <link rel="shortcut icon" href="img/favicon.ico">

    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script src="https://kit.fontawesome.com/e44685b5e0.js"></script>

    <link rel="stylesheet" type="text/css" href="css/cover.css">
    <link rel="stylesheet" type="text/css" href="css/upload.css">
    <link rel="stylesheet" node-type="theme-link" type="text/css" href="css/diskSystem-theme.css">
    <link rel="stylesheet" type="text/css" href="css/alpha.css">
    <link rel="stylesheet" type="text/css" href="css/function.css">
    <link rel="stylesheet" type="text/css" href="css/context-all_2b14e94.css">
    <link rel="stylesheet" type="text/css" href="css/all_fe4c0e3.css">
    <link rel="stylesheet" type="text/css" href="css/home-all_5215898.css">
    <link rel="stylesheet" type="text/css" href="css/disk.header.css">

    <script type="text/javascript" src="js/homepage.js"></script>
    <script type="text/javascript" src="js/homepage-aside.js"></script>
    <script type="text/javascript" src="js/fileload.js"></script>

</head>

<body>

    <div class="frame-all" id="layoutApp">
        <!-- 侧边列表 -->
        <div class="frame-aside" id="layoutAside">
            <div class="module-aside menu">
                <ul class="menu">
                    <li>
                        <a onclick="allFile();" hidefocus="true">
                            <span class="text">
                                <i class="fas fa-file-alt"></i>
                                <span>全部文件</span>
                            </span>
                        </a>
                    </li>
                    <li class="menuTip">
                        <a onclick="allPicture();" hidefocus="true" href="">
                            <span class="text">
                                <i class="fas fa-image"></i>
                                <span>图片</span>
                            </span>
                        </a>
                    </li>
                    <li class="menuTip">
                        <a onclick="allText();" hidefocus="true" href="">
                            <span class="text">
                                <i class="fas fa-file"></i>
                                <span>文档</span>
                            </span>
                        </a>
                    </li>
                    <li class="menuTip">
                        <a onclick="allVideo();" hidefocus="true" href="">
                            <span class="text">
                                <i class="fas fa-file-video"></i>
                                <span>视频</span>
                            </span>
                        </a>
                    </li>
                    <li class="menuTip">
                        <a onclick="allMusic();" hidefocus="true" href="">
                            <span class="text">
                                <i class="fas fa-file-audio"></i>
                                <span>音乐</span>
                            </span>
                        </a>
                    </li>
                    <li class="menuTip">
                        <a onclick="allOthers();" hidefocus="true" href="">
                            <span class="text">
                                <i class="fas fa-bars"></i>
                                <span>其他</span>
                            </span>
                        </a>
                    </li>
                    <li class="menuTip">
                        <a onclick="trashBin();" hidefocus="true" href="">
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


                <!-- 检索 -->
                <div class="search">
                    <!-- 
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
                -->

                    <div class="searchbox" style="width: 50px;padding-right: 0px;padding-left: 0px;">
                        <a class="g-button g-button-blue blue-upload" id="search-button" title="搜索文件"
                            style="display: inline-block;"><span class="g-button-right">
                                <span class="text" style="width: auto;">
                                    <i class="fas fa-search"></i>
                                    搜索文件</span></span></a>
                        <div id="search-div"
                            style="border: 1;position: absolute;width: 200;height: 200; background:#ffffff;display: none;border: 1px solid #0098ea;border-radius: 4px;">
                            <form action='' id="search-form" name='search' style='padding-left: 6px;'>
                                <div style='color:#0080ff;font-size:13px;padding-top: 4px;padding-bottom: 4px;'>
                                    路径：
                                </div>
                                <input name='search-path' id='search-project' /><br />
                                <div style='color:#0080ff;font-size:13px;padding-top: 4px;padding-bottom: 4px;'>
                                    文件标签：
                                </div>
                                <input name='searchTag' id='search-tag' /><br />
                                <div style='color:#0080ff;font-size:13px;padding-top: 4px;padding-bottom: 4px;'>
                                    上传人UID：
                                </div>
                                <input name='searchpersonUID' id='search-uid' /><br />
                                <div style='color:#0080ff;font-size:13px;padding-top: 4px;padding-bottom: 4px;'>
                                    文件名称：
                                </div>
                                <input name='searchfilename' id='search-file' /><br />
                                <div id='search-error' style="color: red"></div>
                                <br />
                                <input class='uploadbutton' style='color:#ffffff;margin-bottom:10px' type='submit'
                                    id='upload' value='搜索文件' onclick='return CheckSearch();'>
                            </form>
                        </div>

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
                <div class="search">
                    <div class="searchbox" style="width: 50px;padding-right: 0px;padding-left: 0px;">
                        <a class="g-button g-button-blue blue-upload" id="adduser-button" title="添加项目相关人员"
                            style="display: inline-block;"><span class="g-button-right">
                                <span class="text" style="width: auto;">
                                    <i class="fas fa-user-plus"></i>
                                    添加用户
                                </span>
                            </span>
                        </a>
                        <div id="adduser-div"
                            style="border: 1;position: absolute;width: 200;height: 200; background:#ffffff; display: none;border: 1px solid #0098ea;border-radius: 4px;">
                            <form id='adduser-form' name='adduser' style='padding-left: 6px;'>
                                <div style='color:#0080ff;font-size:13px;padding-top: 4px;padding-bottom: 4px;'>
                                    项目名称：
                                </div>
                                <input name='projectName' id='adduser-project' /><br />
                                <div id='adduser-error-project' style="color: red"></div>
                                <div style='color:#0080ff;font-size:13px;padding-top: 4px;padding-bottom: 4px;'>
                                    项目成员UID：
                                </div>
                                <input name='username' id='username' /><br />
                                <div id='adduser-error-user' style="color: red"></div>
                                <label>
                                    <input id='selectadd' type='radio' value='add' checked='true'
                                        onclick='addselect();' />
                                    添加
                                </label>
                                <label>
                                    <input id='selectdelete' type='radio' value='delete' onclick='deleteselect();' />
                                    删除
                                </label> <br />
                                <input class='uploadbutton' style='color:#ffffff;margin-bottom:10px' type='submit'
                                    id='upload' value='添加用户' onclick='return CheckAdd();'>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- 文件按键 -->
                <div class="button" style="white-space: nowrap; position: relative;width:1000px">
                    <div
                        style="position: absolute; top: 0px; line-height: normal; padding-top: 11px; padding-left: 0px; width: auto;">
                        <!-- 上传文件 -->
                        <a class="g-button g-button-blue blue-upload" id="upload-button" title="上传文件"
                            style="display: inline-block;">
                            <span class="g-button-right" style="font: #fff">
                                <span class="text" style="width: auto;">
                                    <i class="fas fa-upload"></i>
                                    上传文件
                                </span>
                            </span>
                        </a>
                        <div id="upload-div"
                            style="border: 1;position: absolute;width: 200;height: 200; background:#ffffff;display: none;border: 1px solid #0098ea;border-radius: 4px;">
                            <form id='upload-form' enctype="multipart/form-data" style='padding-left: 6px;'>
                                <div style='color:#0080ff;font-size:13px;padding-top: 4px;padding-bottom: 4px;'>
                                    上传路径：
                                </div>
                                <input type='text' name='upload-path' id='upload-path' /><br />
                                <div id='upload-error-path' style="color: red"></div>
                                <div style='color:#0080ff;font-size:13px;padding-top: 4px;padding-bottom: 4px;'>
                                    文件标签：
                                </div>
                                <input type='text' name='tags' id='tags' /><br />
                                <div style='color:#0080ff;font-size:13px;padding-top: 4px;padding-bottom: 4px;'>
                                    上传文件：
                                </div>
                                <input type='file' name='upFile' id='upload-file' /><br /><br />
                                <div id='upload-error-file' style="color: red"></div>
                                <input class='uploadbutton' style='color:#ffffff;margin-bottom:10px' type='submit'
                                     value='上传'>
                            </form>

                        </div>
                        <!-- 新建文件夹-->
                        <a class="g-button" title="新建文件夹" id="folder-button" style="display: inline-block;"><span class="g-button-right">
                                <span class="text" style="width: auto;">
                                    <i class="fas fa-folder-plus"></i>
                                    新建文件夹</span></span></a>
                        <div id="folder-div"
                            style="border: 1;position: absolute;width: 200;height: 200; background:#ffffff; display: none;border: 1px solid #0098ea;border-radius: 4px;margin-left:123px;">
                            <form action=''  id='folder-form' name='folder' style='padding-left: 6px;'>
                                <div style='color:#0080ff;font-size:13px;padding-top: 4px;padding-bottom: 4px;'>
                                    路径：
                                </div>
                                <input name='folder-path' id='folder-path' /><br />
                                <div id='folder-error-path' style="color: red"></div>
                                <div style='color:#0080ff;font-size:13px;padding-top: 4px;padding-bottom: 4px;'>
                                    文件夹名称：
                                </div>
                                <input name='foldername' id='folder-name' /><br />
                                <div id='folder-error-file' style="color: red"></div><br />
                                <input class='uploadbutton' style='color:#ffffff;margin-bottom:10px' type='submit'
                                     value='新建文件夹' onclick='return CheckSearch();'>
                            </form>
                        </div>
                        <!-- 新建项目 -->
                        <a class="g-button" title="新建项目" id="project-button" style="display: inline-block;"><span
                                class="g-button-right">
                                <span class="text" style="width: auto;">
                                    <i class="fas fa-tasks"></i>
                                    新建项目</span></span></a>
                        <div id="project-div"
                            style="border: 1;position: absolute;width: 200;height: 200; background:#ffffff; display: none;border: 1px solid #0098ea;border-radius: 4px;margin-left:255px;">
                            <form action=''  id='project-form' name='project' style='padding-left: 6px;'>
                                <div style='color:#0080ff;font-size:13px;padding-top: 4px;padding-bottom: 4px;'>
                                    项目名称：
                                </div>
                                <input name='projectname' id='project-name' /><br />
                                <div id='project-error-file' style="color: red"></div><br />
                                <input class='uploadbutton' style='color:#ffffff;margin-bottom:10px' type='submit'
                                     value='新建项目' onclick='return CheckSearch();'>
                            </form>
                        </div>
                        <!-- 下载文件 -->
                        <a class="g-button" title="下载文件" onclick="Download();" style="display: inline-block;"><span
                                class="g-button-right">
                                <span class="text" style="width: auto;">
                                    <i class="fas fa-download"></i>
                                    下载文件</span></span></a>
                        <!-- 更多 -->
                        <a class="g-button" title="更多" onclick="getmore()">
                            <span class="g-button-right">
                                <span class="text" style="width: auto;">
                                    <i class="fas fa-ellipsis-v"></i>
                                    更多
                                </span>
                            </span>
                        </a>
                        <span class="menu" style="width: 70px;"><a style="display:none;" data-menu-id="b-menu0"
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
            <%
//                              定义项目名称
                                String projectname = "Upload";
                                %>
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
                                <div class="allcheck" style="margin-left: 4px;"><span class="allcheckbox"
                                        style="top: 4px;"><input name="allboxes" id="allcheck" onclick="allcheck()"
                                            type="checkbox" value="全选" style="margin-top: auto;" /></span>
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
                <textarea style="display: none;">
                        <dd class="g-clearfix filelable open-enable" data-id="$fileinfoid$">
                            <span></span>
                            <span class="checkboxlabel">
                                <input name="boxes[]"
                                    onclick="checkall()" type="checkbox" id="check"
                                    value="$dir$" />
                                </span>
                            </span>
                            <div class="file-img dir-small">
                                <img src="$imgsrc$"
                                    style="width:26px;height:26px;">
                                </div>
                            <div class="file-name" style="width:50%">
                                <div class="text">
                                    <a href="$filenamea$"
                                        title="$filenametitle$">$filename$</a></div>
                            </div>
                            <div class="file-size" style="width:16%">$size$</div>
                            <div class="file-date" style="width:23%">$date$</div>
                            <div class="file-date" style="width:10%">$uploaduser$</div>
                        </dd>
                    </textarea>
                <div class="table-main" style="overflow-y: auto; height: 726px;">
                    <div id='fileinfo' class="filelist" style="height: auto;">
                    </div>
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
                        <a href="" class="logo-top" href="" target="_self" title="协同办公资源管理子系统"
                            style="margin-left:40px;"></a>
                    </dt>
                    <dd class="header-link">
                        <span class="header-label header-home">
                            <a href="" target="_self" title="文件">文件</a>
                        </span>
                        <span class="header-label" node-type="mbox-homepage">
                            <a href="" target="_self" title="项目">项目</a>
                        </span>
                        <span class=" header-label" node-type="pan-mall">
                            <a href="https://github.com/ZeroVoid10/owncloud" target="_blank" title="GitHub">GitHub</a>
                        </span>
                        <span class="header-label">
                            <a href="" target="_self" title="更多" node-type="item-title">更多</a>
                        </span>
                        <span class="header-label" style="color:#333;font-size:10px;margin-left:500px;margin-right:0px;">
                        <ul style="margin-top:-10px;">
                            <li style="width:40px;height:15px;">
                            <div>用户名：</div>
                            </li>
                            <li style="width:40px;height:15px;">
                            <div>U  I  D：</div>
                            </li>
                            <li style="width:40px;height:15px;">
                            <div>邮     箱：</div>
                            </li>
                        </ul>
                        </span>
                        <span class=" header-label" style="color:#333;font-size:10px;">
                        <ul style="margin-top:-10px;">
                            <li style="width:100px;height:15px;">
                            <div>世博元</div>
                            </li>
                            <li style="width:100px;height:15px;">
                            <div>7777777</div>
                            </li>
                            <li style="width:100px;height:15px;">
                            <div>邮箱@163.com</div>
                            </li>
                        </ul>
                        </span>
                    </dd>
                </dl>
            </div>
        </div>
    </div>
    </div>
</body>

</html>