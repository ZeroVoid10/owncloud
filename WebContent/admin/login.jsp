<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>登入协同办公系统</title>
        <link rel="stylesheet" href="css/login.css">
        <link rel="stylesheet" href="css/normalize.css">
    </head>

    <body class="body-100">
        <div class="owncloud-login-wrap">
            <div class="login_background">
                <div class="wallpaper"></div>
            </div>
            <div class="toggle-button-box">
                <a href="" class="signup-form submit-short">注册</a>
            </div>
            <div class="login-form">
                <div class="login-form_logo-box">
                    <div class="login-form_logo"></div>
                    <div class="login-form_phrase">让创作变得更有乐趣</div>
                </div>
                <div class="container-login">
                    <form>
                        <div class="input-field">
                            <input type="text" autocomplete="username" placeholder="邮箱地址" autocapitalize="off">
                        </div>
                        <div class="input-field">
                            <input type="password" autocomplete="current-password" placeholder="密码" autocapitalize="off">
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