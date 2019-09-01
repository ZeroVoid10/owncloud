<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>协同办公资源管理子系统安装</title>
    <link rel="stylesheet" type="text/css" href="css/admin.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script src="js/install.js"></script>
    <link rel="shortcut icon", href="img/logo.png")>
</head>

<body>
    <div class="admin-background">
        <div class="wallpaper"></div>
    </div>
    <div class="install-form">
        <div class="login-form_logo-box">
            <div class="login-form_logo" style="background-image: url(/img/logo.png)"></div>
            <div class="login-form_phrase">让学习变得更有乐趣</div>
        </div>
        <div class="title">协同办公系统安装</div>
        <div>

            <form id="install">
                <div class="prompt">
                    <div>数据库类型</div> 
                    <div class="error-msg" id="type"></div>
                </div>
                <div class="install-input-field">
                    <select name="db_type" >
                        <!--
                        <option value="">---请选择---</option>
                        -->
                        <option value="mariadb">mariadb</option>
                        <option value="mysql">mysql</option>
                    </select>
                </div>

                <div class="prompt">
                    <div>数据库Host</div>
                    <div class="error-msg" id="host"></div>
                </div>
                <div class="install-input-field">
                    <input type="text" name="db_host" placeholder="Database host" value="localhost">
                </div>

                <div class="prompt">
                    <div>数据库端口</div>
                    <div class="error-msg" id="port"></div>
                </div>
                <div class="install-input-field">
                    <input type="text" name="db_port" placeholder="Database port" value="3306">
                </div>

                <div class="prompt">
                    <div>数据库名称</div>
                    <div class="error-msg" id="db_name"></div>
                </div>
                <div class="install-input-field">
                    <input type="text" name="db_name" placeholder="Database name" value="test">
                </div>

                <div class="prompt">
                    <div>数据库用户名</div>
                    <div class="error-msg" id="username"></div>
                </div>
                <div class="install-input-field">
                    <input type="text" name="db_username" placeholder="Database user name" value="pan">
                </div>

                <div class="prompt">
                    <div>数据库用户密码</div>
                    <div class="error-msg" id="db_password"></div>
                </div>
                <div class="install-input-field">
                    <input type="password" name="db_password" placeholder="Database password">
                </div>

                <div class="prompt">
                    <div>管理员用户邮箱</div>
                    <div class="error-msg" id="root_mail"></div>
                </div>
                <div class="install-input-field">
                    <input type="text" name="root_mail" placeholder="root password" value="2@a.com">
                </div>

                <div class="prompt">
                    <div>管理员用户密码</div>
                    <div class="error-msg" id="root_password"></div>
                </div>
                <div class="install-input-field">
                    <input type="password" name="root_password" placeholder="root password">
                </div>

                <ul class="error-msg-list" id="install-msg"></ul>
                
                <button type="submit" class="install-form_submit">确认</button>
            </form>
        </div>
    </div>
</body>
</html>
