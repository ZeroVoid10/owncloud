<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/admin.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script type="text/javascript" src="js/register.js"></script>
        
</head>
<body>
    <div class="owncloud-wrap">
        <div class="admin-background">
            <div class="wallpaper"></div>
        </div>
        <div class="toggle-button-box">
            <a href="/register" class="signup-form submit-short">注册</a>
        </div>
        <div class="login-form">
            <div class="login-form_logo-box">
                <div class="login-form_logo" style="background-image: url(/img/logo.png)"></div>
                <div class="login-form_phrase">让学习变得更有乐趣</div>
            </div>
            <div class="container-login">
                <form id="register">
                    <div class="input-field" id="register">
                        <input type="text" name="username" placeholder="用户名">
                    </div><br>
                    <div class="input-field" id="register">
                        <input type="email" name="email" placeholder="电子邮箱">
                    </div><br>
                    <div class="input-field" id="register">
                        <input type="password" name="password" placeholder="密码">
                    </div><br>
                    <ul class="error-msg-list" id="error-msg"></ul>
                    <button type="submit" class="login-form_submit">注册</button>
                    <div class="login-form-nav">
                        <div class="left"></div>
                        <div class="right">
                            <a href="">找回</a>
                        </div>
                    </div>
                </form>
            </div>
            <div class="terms">面朝大海，春暖花开</div>
        </div>
    </div>

</body>
</html>