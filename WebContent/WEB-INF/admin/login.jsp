<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="xyz.zerovoid.pan.usr.theme.ThemeConf"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>协同办公系统--登入</title>
    <link rel="stylesheet" href="/css/admin.css">
    <link rel="stylesheet" href="/css/normalize.css">
</head>

<body class="body-100">
    <div class="owncloud-wrap">
        <div class="admin-background">
            <div class="wallpaper"></div>
        </div>
        <div class="toggle-button-box">
            <a href="" class="signup-form submit-short">注册</a>
        </div>
        <div class="login-form">
            <div class="login-form_logo-box">
                <div class="login-form_logo" style="background-image: url(/img/logo.png)"></div>
                <div class="login-form_phrase">让学习变得更有乐趣</div>
            </div>
            <div class="container-login">
                <form>
                    <div class="input-field" id="login">
                        <input type="text" autocomplete="username" placeholder="邮箱地址">
                    </div>
                    <div class="input-field" id="login">
                        <input type="password" autocomplete="current-password" placeholder="密码">
                    </div>
                    <ul class="error-msg-list"></ul>
                    <button type="submit" class="login-form_submit">登入</button>
                    <div class="login-form-nav">
                        <div class="left"></div>
                        <div class="right">
                            <a href="">忘记了</a>
                        </div>
                    </div>
                </form>
            </div>
            <div class="terms">面朝大海，春暖花开</div>
        </div>
    </div>

</body>

</html>