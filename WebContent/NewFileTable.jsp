<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "hp.fileRead.fileGet"
import = "java.lang.*"
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
    <link rel="stylesheet" type="text/css" href="css/cover.css">
    <link rel="stylesheet" node-type="theme-link" type="text/css" href="css/diskSystem-theme.css">
    <link rel="stylesheet" type="text/css" href="css/alpha.css">
    <link rel="stylesheet" type="text/css" href="css/function.css">
    <link rel="stylesheet" type="text/css" href="css/context-all_2b14e94.css">
    <link rel="stylesheet" type="text/css" href="css/all_fe4c0e3.css">
    <link rel="stylesheet" type="text/css" href="css/home-all_5215898.css">
    <link rel="stylesheet" type="text/css" href="css/disk.header.css">
    <script type="text/javascript" src="css/vipWarn-all_88ec5d3.js"></script>
    <link rel="stylesheet" type="text/css" href="css/disk.header.css">
    <style type="text/css">
        .context-menu {
            position: absolute;
            font-size: 13px !important;
            color: #000 !important;
            top: 0;
            left: 0;
            -moz-user-select: none;
            -o-user-select: none;
            -webkit-user-select: none;
            user-select: none
        }

        .context-menu .arrowicon {
            background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA0AAAAyCAMAAACwGaE2AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoV2luZG93cykiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6NzhGQzA4MUIzRkNFMTFFNEFFNkRGOTBCODU5NjkyMTciIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6NzhGQzA4MUMzRkNFMTFFNEFFNkRGOTBCODU5NjkyMTciPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDo3OEZDMDgxOTNGQ0UxMUU0QUU2REY5MEI4NTk2OTIxNyIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDo3OEZDMDgxQTNGQ0UxMUU0QUU2REY5MEI4NTk2OTIxNyIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PpbvuBQAAAAGUExURXp6ev///7iACewAAAACdFJOU/8A5bcwSgAAAElJREFUeNrc0kEKACAIRNHf/S8dSWoz4AVyo4/QRQwrircBLbgkEaRwSAOZc7nqC6FChYr5bb75xS9pCmS29FiyLHWWyGpbgAEA38gCGb87IAIAAAAASUVORK5CYII=) right center no-repeat
        }

        .context-menu .arrowicon.list-hover,
        .context-menu .arrowicon.open {
            background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA0AAAAyCAMAAACwGaE2AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoV2luZG93cykiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6ODAxQTFDRkYzRkNFMTFFNDhCREVDNDI5RDEyNTM1NTUiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6ODAxQTFEMDAzRkNFMTFFNDhCREVDNDI5RDEyNTM1NTUiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDo4MDFBMUNGRDNGQ0UxMUU0OEJERUM0MjlEMTI1MzU1NSIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDo4MDFBMUNGRTNGQ0UxMUU0OEJERUM0MjlEMTI1MzU1NSIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PlWhQhkAAAAGUExURf///////1V89WwAAAACdFJOU/8A5bcwSgAAAElJREFUeNrc0kEKACAIRNHf/S8dSWoz4AVyo4/QRQwrircBLbgkEaRwSAOZc7nqC6FChYr5bb75xS9pCmS29FiyLHWWyGpbgAEA38gCGb87IAIAAAAASUVORK5CYII=)
        }

        .context-menu ul,
        .context-menu li {
            list-style: none;
            padding: 0;
            margin: 0;
            font-size: 13px !important;
            color: #5b667b !important
        }

        .context-menu .list {
            min-height: 23px;
            padding: 2px 0;
            position: absolute;
            background-color: #FFF;
            color: #000
        }

        .context-menu .list {
            border: 1px solid #dde0e4;
            border-radius: 5px;
            box-shadow: 0 0 8px #ccc
        }

        .context-menu .list li {
            display: list-item;
            cursor: default;
            +width: 65px;
            height: 23px;
            line-height: 23px;
            white-space: nowrap;
            position: relative;
            z-index: 1;
            padding: 0 27px 0 20px
        }

        .context-menu .list .disable,
        .context-menu .list .disable:hover {
            color: #c5cbd8 !important;
            background: #FFF;
            opacity: .8;
            filter: alpha(opacity=80);
            -ms-filter: "alpha(Opacity=80)";
            filter: alpha(Opacity=80)
        }

        .context-menu .list li .icon,
        .context-menu .list li .icon-hover {
            position: absolute;
            display: block;
            width: 16px;
            height: 16px;
            top: 3px;
            left: 2px
        }

        .context-menu .list li .icon-hover {
            display: none
        }

        .context-menu .list li.list-hover,
        .context-menu .list .has-more.open {
            background-color: #4281F4;
            color: #FFF !important
        }

        .context-menu .list li.list-hover>.icon {
            display: none
        }

        .context-menu .list li.list-hover>.icon-hover {
            display: block
        }

        .context-menu .list .has-more {
            z-index: 2
        }

        .context-menu .list .has-more .list {
            display: none;
            top: -3px;
            left: 98%;
            z-index: 2;
            border-radius: 0;
            box-shadow: 0 0 0
        }

        .context-menu .list .separate,
        .context-menu .list .separate.list-hover {
            padding: 0;
            margin: 5px 0;
            height: 1px;
            line-height: 0;
            font-size: 0 !important;
            background-color: #e9e9e9;
            cursor: default
        }

        .context-menu .list .arrow-down {
            height: 16px;
            background-position: center -38px
        }

        .context-menu .list li:hover {
            background-color: #4281F4;
            color: #FFF !important
        }

        .context-menu .list li.separate:hover {
            background-color: #e9e9e9
        }

        .context-menu .list .arrow-up {
            height: 16px;
            background-position: center 4px
        }
    </style>
</head>

<body>

    <div class="frame-all" id="layoutApp">
        <div class="red-packet-box">
            <a class="red-packet use-red-packet"></a>
            <a class="red-packet get-red-packet"></a>
            <a class="red-packet-close"></a>
        </div>
        <div class="skin-main"></div>
        <div class="iGW3q8" node-type="iGW3q8">
            <div class="4Gni2YYS" node-type="4Gni2YYS">
                <div class="nbVsUftw" node-type="nbVsUftw">
                    <!-- 侧边列表 -->
                    <div class="frame-aside" id="layoutAside">
                        <div class="rDDU4A" node-type="rDDU4A">
                            <div class="I1zYDD" node-type="I1zYDD">
                                <div node-type="dyqLjbp" class="module-aside DtJtsC">
                                    <div class="KHbQCub"></div>
                                    <ul class="fOHAbxb">
                                        <li node-type="ljdJ5Q" data-key="list" class="dodAkP bHzsaPb">
                                            <a node-type="yud4lw" path="/" class="pydeZk ztxwyDRe" hidefocus="true"
                                                href="javascript:void(0);">
                                                <span class="text">
                                                    <span node-type="vaLEWj" class="icon icon-disk"></span>
                                                    <span node-type="izyL8Qp">全部文件</span>
                                                </span>
                                            </a>
                                        </li>
                                        <li node-type="ljdJ5Q" data-key="pic" class="dodAkP">
                                            <a node-type="yud4lw" class="ztxwyDRe" hidefocus="true"
                                                href="https://pan.baidu.com/disk/timeline">
                                                <span class="text">
                                                    <span node-type="izyL8Qp">图片</span>
                                                </span>
                                            </a>
                                        </li>
                                        <li node-type="ljdJ5Q" data-key="doc" class="dodAkP">
                                            <a node-type="yud4lw" cat="4" class="ztxwyDRe" hidefocus="true"
                                                href="javascript:void(0);">
                                                <span class="text">
                                                    <span node-type="izyL8Qp">文档</span>
                                                </span>
                                            </a>
                                        </li>
                                        <li node-type="ljdJ5Q" data-key="video" class="dodAkP">
                                            <a node-type="yud4lw" cat="1" class="ztxwyDRe" hidefocus="true"
                                                href="javascript:void(0);">
                                                <span class="text">
                                                    <span node-type="izyL8Qp">视频</span>
                                                </span>
                                            </a>
                                        </li>
                                        <li node-type="ljdJ5Q" data-key="mbt" class="dodAkP">
                                            <a node-type="yud4lw" cat="7" class="ztxwyDRe" hidefocus="true"
                                                href="javascript:void(0);">
                                                <span class="text">
                                                    <span node-type="izyL8Qp">种子</span>
                                                </span>
                                            </a>
                                        </li>
                                        <li node-type="ljdJ5Q" data-key="music" class="dodAkP">
                                            <a node-type="yud4lw" cat="2" class="ztxwyDRe" hidefocus="true"
                                                href="javascript:void(0);">
                                                <span class="text">
                                                    <span node-type="izyL8Qp">音乐</span>
                                                </span>
                                            </a>
                                        </li>
                                        <li node-type="ljdJ5Q" data-key="other" class="dodAkP">
                                            <a node-type="yud4lw" cat="6" class="ztxwyDRe" hidefocus="true"
                                                href="javascript:void(0);">
                                                <span class="text">
                                                    <span node-type="izyL8Qp">其它</span>
                                                </span>
                                            </a>
                                        </li>
                                    </ul>
                                    <div class="jpcbLWz1" style="display: block;"></div>
                                    <ul class="FvBGOQ" style="white-space: nowrap; position: relative;">
                                        <div class="button-box-mark"
                                            style="display:inline-block;*display:inline;*zoom:1;width:1px;height:1px;line-height:0;">
                                        </div>
                                        <div class="sipjL6BL"
                                            style="position:absolute;top:0;line-height:normal;padding-top:0px;">
                                            <div
                                                style="display:none;width:100%;height:100%;z-index:30;position:absolute;top:0;left:0;">
                                            </div><a class="g-button" data-button-id="b1" data-button-index="8"
                                                href="javascript:;" title="我的分享"><span class="g-button-right"><em
                                                        class="icon icon-my-share" title="我的分享"></em><span class="text"
                                                        style="width: auto;">我的分享</span></span></a><span
                                                class="g-dropdown-button tools-more" style="display: none;"><a
                                                    class="g-button" data-button-id="b3" data-button-index=""
                                                    href="javascript:;" title="更多"><span class="g-button-right"><em
                                                            class="icon icon-more" title="更多"></em><span class="text"
                                                            style="width: auto;">更多</span></span></a><span class="menu"
                                                    style="width: 112px;"><a style="display:none;"
                                                        data-menu-id="b-menu0" class="g-button-menu g-menu-hasIcon"
                                                        href="javascript:;"><em
                                                            class="icon icon-my-share"></em>我的分享</a></span></span>
                                        </div>
                                    </ul>
                                    <div class="jpcbLWz1" style="display: block;"></div>
                                    <ul class="JKEQDvb" style="white-space: nowrap; position: relative;">
                                        <div class="button-box-mark"
                                            style="display:inline-block;*display:inline;*zoom:1;width:1px;height:1px;line-height:0;">
                                        </div>
                                        <div class="gmdVJd"
                                            style="position:absolute;top:0;line-height:normal;padding-top:0px;">
                                            <div
                                                style="display:none;width:100%;height:100%;z-index:30;position:absolute;top:0;left:0;">
                                            </div><a class="g-button" data-button-id="b5" data-button-index="9"
                                                href="javascript:;" title="回收站"><span class="g-button-right"><em
                                                        class="icon icon-delete" title="回收站"></em><span class="text"
                                                        style="width: auto;">回收站</span></span></a><span
                                                class="g-dropdown-button tools-more" style="display: none;"><a
                                                    class="g-button" data-button-id="b7" data-button-index=""
                                                    href="javascript:;" title="更多"><span class="g-button-right"><em
                                                            class="icon icon-more" title="更多"></em><span class="text"
                                                            style="width: auto;">更多</span></span></a><span class="menu"
                                                    style="width: 112px;"><a style="display:none;"
                                                        data-menu-id="b-menu0" class="g-button-menu g-menu-hasIcon"
                                                        href="javascript:;"><em
                                                            class="icon icon-delete"></em>回收站</a></span></span>
                                        </div>
                                    </ul>

                                    <div node-type="zknJwN" class="quota-over-tips">
                                        <div node-type="fece07dn wimnE5n" class="quota-over-text"> </div> <a
                                            class="quota-over-btn" href="https://pan.baidu.com/disk/home?"></a> <em
                                            class="quota-over-bg"></em>
                                    </div>
                                    <ul class="tDuODs">
                                        <li class="g-clearfix bar">
                                            <div node-type="cuamNdqk" class="remainingSpaceUi"> <span
                                                    node-type="ypu0YLk" class="remainingSpaceUi_span"
                                                    style="background: rgb(28, 175, 253); transition-duration: 0.373397s; width: 24.8931%;"></span>
                                            </div>
                                            <div class="DIeHPCb remaining-space">
                                                <div class="GELdyA"> </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div data-index="2" node-type="layout-absolute-box"
                                style="width: 100%; height: 50px; background:none; z-index: 0; ">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="pYdsxNF" node-type="pYdsxNF">
            <div class="23n4ux79" node-type="23n4ux79">
                <div class="frame-main" id="layoutMain" style="display: block;">
                    <div class="UJ88EFI" node-type="UJ88EFI">
                        <div class="snYWcB2S" node-type="snYWcB2S">
                            <div class="msahBmYS" node-type="msahBmYS">
                                <div class="DxdbeCb g-clearfix">
                                    <div class="uuuLp2v"></div>
                                    <div class="uyiLGWX">
                                        <!-- 排序 -->
                                        <div class="EzLavy">
                                            <div node-type="mrvLW3w" class="andn0W" href="javascript:void(0)">
                                                <span class="icon icon-order"></span>
                                            </div>
                                            <div node-type="sDwvAgb" class="sDwvAgb">
                                                <span data-key="name" class="vAFAFF">
                                                    <em class="icon icon-sort-select"></em>
                                                    文件名</span>
                                                <span data-key="size" class="vAFAFF ugcOHtb">
                                                    <em class="icon icon-sort-select"></em>
                                                    大小</span>
                                                <span data-key="time" class="vAFAFF">
                                                    <em class="icon icon-sort-select"></em>
                                                    修改日期</span>
                                            </div>
                                        </div>
                                        <div class="OFaPaO">
                                            <label class="ppnzdvjM">
                                                <p>
                                                    <span></span>按文档全局检索</p>
                                                <input type="checkbox">
                                            </label>
                                            <div class="oclLlDK" node-type="sol1zp0">
                                                <form node-type="wnmLRjo" class="rodJJ7 nqlj1aPp"
                                                    action="javascript: void(0)" method="get">
                                                    <input node-type="almaLkra alpjdwPe" data-key="SEARCH_QUERY"
                                                        autocomplete="off" class="klzvyY8g" name="q" value=""
                                                        spellchecking="off" type="text">
                                                    <span node-type="bjdQ5l" class="arsyZng icon icon-search-del"
                                                        style="display: none;"></span>
                                                    <span node-type="alpjdwPe" data-key="SEARCH_BUTTON" class="gHHsaL">
                                                        <span class="icon icon-search"></span>
                                                    </span>
                                                    <span node-type="hxvdL9l8" class="bclyoDz"
                                                        style="display: block;">搜索您的文件</span>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="oyLWOp" style="white-space: nowrap; position: relative;">
                                            <div class="button-box-mark"
                                                style="display:inline-block;*display:inline;*zoom:1;width:1px;height:1px;line-height:0;">
                                            </div>
                                            <div class="tcuLAu"
                                                style="position: absolute; top: 0px; line-height: normal; padding-top: 11px; padding-left: 0px; width: auto;">
                                                <div
                                                    style="display:none;width:100%;height:100%;z-index:30;position:absolute;top:0;left:0;">
                                                </div>
                                                <a class="g-button g-button-blue blue-upload" data-button-id="b31"
                                                    data-button-index="1" href="javascript:;" title="上传"
                                                    style="display: inline-block;"><span class="g-button-right"><em
                                                            class="icon icon-upload" title="上传"></em><span class="text"
                                                            style="width: auto;">上传文件</span></span></a>
                                                <a class="g-button" data-button-id="b33" data-button-index="2"
                                                    href="javascript:;" title="新建文件夹"
                                                    style="display: inline-block;"><span class="g-button-right"><em
                                                            class="icon icon-newfolder" title="新建文件夹"></em><span
                                                            class="text" style="width: auto;">新建项目</span></span></a>
                                                <a class="g-button" data-button-id="b35" data-button-index="3"
                                                    href="javascript:;" title="离线下载"
                                                    style="display: inline-block;"><span class="g-button-right"><em
                                                            class="icon icon-download" title="离线下载"></em><span
                                                            class="text"
                                                            style="width: auto;">下载文件</span></span></a></em></span></a>
                                                <a class="g-button" data-button-id="b39" data-button-index=""
                                                    href="javascript:;" title="更多"><span class="g-button-right"><em
                                                            class="icon icon-more" title="更多"></em><span class="text"
                                                            style="width: auto;">更多</span></span></a><span class="menu"
                                                    style="width: 70px;"><a style="display:none;" data-menu-id="b-menu0"
                                                        class="g-button-menu g-menu-hasIcon" href="javascript:;"><em
                                                            class="icon icon-upload"></em>上传</a>
                                                    <a style="display:none;" data-menu-id="b-menu1"
                                                        class="g-button-menu g-menu-hasIcon" href="javascript:;"><em
                                                            class="icon icon-newfolder"></em>新建文件夹</a><a
                                                        style="display:none;" data-menu-id="b-menu2"
                                                        class="g-button-menu g-menu-hasIcon" href="javascript:;"><em
                                                            class="icon icon-download"></em>离线下载</a>
                                                    <a style="display:none;" data-menu-id="b-menu3"
                                                        class="g-button-menu g-menu-hasIcon" href="javascript:;"><em
                                                            class="icon icon-device"></em>我的设备</a></span></span>
                                            </div>
                                            <div class="button-box-mark"
                                                style="display:inline-block;*display:inline;*zoom:1;width:1px;height:1px;line-height:0;">
                                            </div>
                                            <div class="QDDOQB"
                                                style="position: absolute; top: 0px; line-height: normal; padding-top: 11px; display: none;">
                                                <div
                                                    style="display:none;width:100%;height:100%;z-index:30;position:absolute;top:0;left:0;">
                                                </div><a class="g-button" data-button-id="b41" data-button-index="1"
                                                    href="javascript:;" title="分享"><span class="g-button-right"><em
                                                            class="icon icon-share" title="分享"></em><span class="text"
                                                            style="width: auto;">分享</span></span></a><a
                                                    class="g-button g-button-hastips" data-button-id="b43"
                                                    data-button-index="1" href="javascript:;" title="邀人一起管理此文件夹"><span
                                                        class="g-button-right"><em class="icon icon-sharedir"
                                                            title=""></em><span class="text"
                                                            style="width: auto;">共享</span></span><span
                                                        class="g-button-tips">邀人一起管理此文件夹</span></a><a class="g-button"
                                                    data-button-id="b45" data-button-index="1" href="javascript:;"
                                                    title="取消共享"><span class="g-button-right"><em
                                                            class="icon icon-sharedir" title="取消共享"></em><span
                                                            class="text" style="width: auto;">取消共享</span></span></a><a
                                                    class="g-button" data-button-id="b47" data-button-index="1"
                                                    href="javascript:;" title="退出共享"><span class="g-button-right"><em
                                                            class="icon icon-sharedir" title="退出共享"></em><span
                                                            class="text" style="width: auto;">退出共享</span></span></a><a
                                                    class="g-button" data-button-id="b49" data-button-index="2"
                                                    href="javascript:;" title="音乐播放"><span class="g-button-right"><em
                                                            class="icon icon-play" title="音乐播放"></em><span class="text"
                                                            style="width: auto;">音乐播放</span></span></a><a
                                                    class="g-button" data-button-id="b51" data-button-index="3"
                                                    href="javascript:;" title="下载"><span class="g-button-right"><em
                                                            class="icon icon-download" title="下载"></em><span
                                                            class="text" style="width: auto;">下载</span></span></a><a
                                                    class="g-button" data-button-id="b53" data-button-index="5"
                                                    href="javascript:;" title="删除"><span class="g-button-right"><em
                                                            class="icon icon-delete" title="删除"></em><span class="text"
                                                            style="width: auto;">删除</span></span></a><a class="g-button"
                                                    data-button-id="b55" data-button-index="8" href="javascript:;"
                                                    title="云冲印"><span class="g-button-right"><em class="icon icon-print"
                                                            title="云冲印"></em><span class="text"
                                                            style="width: auto;">云冲印</span></span></a><a
                                                    class="g-button" data-button-id="b57" data-button-index="9"
                                                    href="javascript:;" title="照片电影"><span class="g-button-right"><em
                                                            class="icon icon-director" title="照片电影"></em><span
                                                            class="text" style="width: auto;">照片电影</span></span></a><a
                                                    class="g-button" data-button-id="b59" data-button-index="9"
                                                    href="javascript:;" title="历史版本"><span class="g-button-right"><em
                                                            class="icon icon-history" title="历史版本"></em><span
                                                            class="text" style="width: auto;">历史版本</span></span></a><a
                                                    class="g-button" data-button-id="b61" data-button-index="13"
                                                    href="javascript:;" title="美化"><span class="g-button-right"><em
                                                            class="icon icon-beauty" title="美化"></em><span class="text"
                                                            style="width: auto;">美化</span></span></a><a class="g-button"
                                                    data-button-id="b63" data-button-index="101" href="javascript:;"
                                                    title="重命名"><span class="g-button-right"><span class="text"
                                                            style="width: auto;">重命名</span></span></a><a
                                                    class="g-button" data-button-id="b65" data-button-index="102"
                                                    href="javascript:;" title="复制到"><span class="g-button-right"><span
                                                            class="text" style="width: auto;">复制到</span></span></a><a
                                                    class="g-button" data-button-id="b67" data-button-index="103"
                                                    href="javascript:;" title="移动到"><span class="g-button-right"><span
                                                            class="text" style="width: auto;">移动到</span></span></a><a
                                                    class="g-button" data-button-id="b69" data-button-index="103"
                                                    href="javascript:;" title="详细信息"><span class="g-button-right"><em
                                                            class="icon icon-share" title="详细信息"></em><span class="text"
                                                            style="width: auto;">详细信息</span></span></a><span
                                                    class="g-dropdown-button"><a class="g-button" data-button-id="b71"
                                                        data-button-index="104" href="javascript:;" title="推送到云设备"><span
                                                            class="g-button-right"><span class="text"
                                                                style="width: auto;">推送到云设备</span></span></a><span
                                                        class="menu" style="width: 102px;"></span></span><span
                                                    class="g-dropdown-button tools-more" style="display: none;"><a
                                                        class="g-button" data-button-id="b73" data-button-index=""
                                                        href="javascript:;" title="更多"><span class="g-button-right"><em
                                                                class="icon icon-more" title="更多"></em><span
                                                                class="text"
                                                                style="width: auto;">更多</span></span></a><span
                                                        class="menu" style="width: 70px;"><a style="display:none;"
                                                            data-menu-id="b-menu0" class="g-button-menu g-menu-hasIcon"
                                                            href="javascript:;"><em
                                                                class="icon icon-share"></em>分享</a><a
                                                            style="display:none;" data-menu-id="b-menu1"
                                                            class="g-button-menu g-menu-hasIcon" href="javascript:;"><em
                                                                class="icon icon-sharedir"></em>共享</a><a
                                                            style="display:none;" data-menu-id="b-menu2"
                                                            class="g-button-menu g-menu-hasIcon" href="javascript:;"><em
                                                                class="icon icon-sharedir"></em>取消共享</a><a
                                                            style="display:none;" data-menu-id="b-menu3"
                                                            class="g-button-menu g-menu-hasIcon" href="javascript:;"><em
                                                                class="icon icon-sharedir"></em>退出共享</a><a
                                                            style="display:none;" data-menu-id="b-menu4"
                                                            class="g-button-menu g-menu-hasIcon" href="javascript:;"><em
                                                                class="icon icon-play"></em>音乐播放</a><a
                                                            style="display:none;" data-menu-id="b-menu5"
                                                            class="g-button-menu g-menu-hasIcon" href="javascript:;"><em
                                                                class="icon icon-download"></em>下载</a><a
                                                            style="display:none;" data-menu-id="b-menu6"
                                                            class="g-button-menu g-menu-hasIcon" href="javascript:;"><em
                                                                class="icon icon-delete"></em>删除</a><a
                                                            style="display:none;" data-menu-id="b-menu7"
                                                            class="g-button-menu g-menu-hasIcon" href="javascript:;"><em
                                                                class="icon icon-print"></em>云冲印</a><a
                                                            style="display:none;" data-menu-id="b-menu8"
                                                            class="g-button-menu g-menu-hasIcon" href="javascript:;"><em
                                                                class="icon icon-director"></em>照片电影</a><a
                                                            style="display:none;" data-menu-id="b-menu9"
                                                            class="g-button-menu g-menu-hasIcon" href="javascript:;"><em
                                                                class="icon icon-history"></em>历史版本</a><a
                                                            style="display:none;" data-menu-id="b-menu10"
                                                            class="g-button-menu g-menu-hasIcon" href="javascript:;"><em
                                                                class="icon icon-beauty"></em>美化</a><a
                                                            style="display:none;" data-menu-id="b-menu11"
                                                            class="g-button-menu " href="javascript:;">重命名</a><a
                                                            style="display:none;" data-menu-id="b-menu12"
                                                            class="g-button-menu " href="javascript:;">复制到</a><a
                                                            style="display:none;" data-menu-id="b-menu13"
                                                            class="g-button-menu " href="javascript:;">移动到</a><a
                                                            style="display:none;" data-menu-id="b-menu14"
                                                            class="g-button-menu g-menu-hasIcon" href="javascript:;"><em
                                                                class="icon icon-share"></em>详细信息</a><span
                                                            style="display:none;" data-menu-id="b-menu15"
                                                            class="g-button-menu g-menu-hasIcon"><span
                                                                class="g-dropdown-button g-dropdown-button-second"
                                                                menulevel="2"><a class="g-button" data-button-id="b75"
                                                                    data-button-index="104" href="javascript:;"
                                                                    title="推送到云设备"><span class="g-button-right"><span
                                                                            class="text"
                                                                            style="width: auto;">推送到云设备</span></span></a><span
                                                                    class="menu"></span></span></span></span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="bisp1zmG"></div>
                                    <div class="rjLRBW">
                                    </div>
                                    <div node-type="EQBfLM" class="EQBfLM g-clearfix">
                                        <a href="javascript:void(0);" class="AbMfvg selected">最近上传</a>
                                    </div>
                                </div>
                                <div class="w4Lnda6s" node-type="w4Lnda6s">
                                    <div node-type="KPDwCE" class="KPDwCE" style="height: 784px;">
                                        <div node-type="JDeHdxb" class="JDeHdxb">
                                            <ul class="FuIxtL" node-type="FuIxtL" style="display: none;">
                                                <li><a data-deep="-1" href="javascript:;">返回上一级</a><span
                                                        class="EKIHPEb">|</span></li>
                                                <li node-type="tbAudfb"></li>
                                            </ul>
                                        </div>
                                        <div class="QxJxtg">
                                            <div class="xGLMIab">
                                                <ul class="QAfdwP tvPMvPb" node-type="tvPMvPb">
                                                    <li data-key="name" class="fufHyA yfHIsP" style="width:50%;">
                                                        <div node-type="fydGNC" class="Qxyfvg fydGNC"><span
                                                                class="zbyDdwb"><input name="allboxes" id="allcheck"
                                                                    onclick="allcheck()" type="checkbox"
                                                                    value="全选" /></span><span
                                                                class="MIMvNNb">全选</span><span
                                                                class="icon NbKJexb icon-checksmall"></span></div><span
                                                            class="text">文件名</span><span class="xEuDywb"></span><span
                                                            class="icon aHEytd icon-up"></span><span
                                                            class="icon sFxCFbb icon-downtitle"></span>
                                                    </li>
                                                    <li data-key="size" class="fufHyA MCGAxG" style="width:16%;"><span
                                                            class="text">大小</span><span class="xEuDywb"></span><span
                                                            class="icon aHEytd icon-up"></span><span
                                                            class="icon sFxCFbb icon-downtitle"></span></li>
                                                    <li data-key="time" class="fufHyA gObdAzb" style="width:23%;"><span
                                                            class="text">修改日期</span><span class="xEuDywb"></span><span
                                                            class="icon aHEytd icon-up"></span><span
                                                            class="icon sFxCFbb icon-downtitle"></span></li>
                                                    <li data-key="time" class="fufHyA gObdAzb" style="width:10%;"><span
                                                            class="text">上传人</span><span class="xEuDywb"></span><span
                                                            class="icon aHEytd icon-up"></span><span
                                                            class="icon sFxCFbb icon-downtitle"></span></li>
                                                </ul>
                                                <ul class="vwCPvP tvPMvPb" node-type="tvPMvPb" style="display: none;">
                                                    <li class="fufHyA yfHIsP">
                                                        <div node-type="fydGNC" class="Qxyfvg fydGNC"><span
                                                                class="zbyDdwb"></span><span
                                                                class="MIMvNNb">全选</span><span
                                                                class="icon NbKJexb icon-checksmall"></span></div>
                                                    </li>
                                                </ul>
                                                <div class="FcQMwt global-clearfix"><span class="MdLxwM"></span>
                                                    <div class="KKtwaH"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="zJMtAEb" style="">
                                            <div node-type="NHcGw" class="NHcGw"
                                                style="overflow-y: auto; height: 726px;">
                                                <div class="vdAfKMb" style="height: auto;">
                                                    <% 
fileGet flg = new fileGet();
flg.getFileName();
List<String>nl = flg.getNameList();
List<String>sl = flg.getSizeList();
List<String>dl = flg.getDateList();
List<String>pl = flg.getPathList();
String fileName = "1808.01244.pdf";    //临时
int len = nl.size();
        
for(int i = 0;i<len;i++){ %>
                                                    <dd class="g-clearfix AuPKyz open-enable" _position="<%= i %>"
                                                        _cmd_installed="<%= i %>" _installed="<%= i %>"><span
                                                            node-type="EOGexf" class="EOGexf"><input name="boxes[]"
                                                                onclick="checkall()" type="checkbox" id="check"
                                                                value="<%= pl.get(i) %>" /><span
                                                                class="icon NbKJexb"></span></span>
                                                        <div class="creyDgd dir-small"></div>
                                                        <div class="file-name" style="width:50%">
                                                            <div class="text"><a href="javascript:void(0);"
                                                                    class="ltvdXqk"
                                                                    title="<%= nl.get(i) %>"><%= nl.get(i) %></a></div>
                                                            <div class="operate"></div>
                                                        </div>
                                                        <div class="wsbdJ7D" style="width:16%"><%= sl.get(i) %></div>
                                                        <div class="pdgbd47Z" style="width:23%"><%= dl.get(i) %></div>
                                                        <div class="pdgbd47Z" style="width:10%">灰原哀</div>
                                                        <div class="ufuryDBg" style="width:0%"><span class="oyLE7b"
                                                                node-type="xeLW3p"></span></div>
                                                    </dd>

                                                    <% } %>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="AuMwTMJ" node-type="AuMwTMJ">
                        <div class="GNgr6S" node-type="GNgr6S">
                            <div class="frame-main" id="layoutServiceHolder" style="display: none;"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- TOP -->
        <div id="layoutHeader">
            <div node-type="module" class="module-header">
                <div node-type="module-header-wrapper" class="module-header-wrapper" style="height: 62px;">
                    <dl class="xtJbHcb">
                        <!-- LOGO -->
                        <dt class="EHazOI">
                            <a href="" class="logo-top" href="" target="_self" title="协同办公资源管理子系统"></a>
                        </dt>
                        <dd class="vyQHNyb" node-type="header-link">
                            <span class="cMEMEF wGMtMgb" node-type="disk-home">
                                <a href="" target="_self" title="文件" node-type="item-title">文件</a>
                                <span class="gICyHO"></span>
                            </span>
                            <span class="cMEMEF " node-type="mbox-homepage">
                                <a href="" target="_self" title="分享" node-type="item-title">分享</a>
                                <span class="gICyHO"></span></span>
                            <span class="cMEMEF " node-type="pan-mall">
                                <a href="" target="_blank" title="找资源" node-type="item-title">找资源</a>
                                <span class="gICyHO"></span></span>
                            <span class="cMEMEF " node-type="find-apps">
                                <a href="" target="_self" title="更多" node-type="item-title">更多</a>
                                <span class="gICyHO"></span><i class="find-light-icon"></i></span>
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