<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% application.setAttribute("appStatus", "installed"); %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>协同办公资源管理子系统安装</title>
    <link rel="stylesheet" type="text/css" href="/css/admin.css">
    <link rel="stylesheet" type="text/css" href="/css/normalize.css">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script src="/js/submit.js"></script>
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
        <div>
            <form id="install" method="POST">
                <div class="prompt">数据库类型</div>
                <div class="install-input-field">
                    <select name="db_type" >
                        <option value="">---请选择---</option>
                        <option value="mysql">mysql</option>
                        <option value="mariadb">mariadb</option>
                    </select>
                </div>

                <div class="prompt">数据库Host</div>
                <div class="install-input-field">
                    <input type="text" name="db_host" placeholder="Database host">
                </div>

                <div class="prompt">数据库端口</div>
                <div class="install-input-field">
                    <input type="text" name="db_port" placeholder="Database port">
                </div>

                <div class="prompt">数据库用户名</div>
                <div class="install-input-field">
                    <input type="text" name="db_username" placeholder="Database user name">
                </div>

                <div class="prompt">数据库密码</div>
                <div class="install-input-field">
                    <input type="password" name="db_password" placeholder="Database password">
                </div>

                <div class="prompt">root用户密码</div>
                <div class="install-input-field">
                    <input type="password" name="root_password" placeholder="root password">
                </div>

                <ul class="error-msg-list">
                    <%
                        String type = (String)request.getAttribute("db_type");
                        String host = (String)request.getAttribute("db_host");
                        if (type != null) { %>
                            <li>2 <%=type%></li>
                    <%  }
                        if (host != null) { %>
                            <li><%=host%></li>
                    <%  }
                    %>
                    <li id="test"><%=(String)request.getAttribute("y")%></li>
                </ul>
                
                <button type="submit" class="install-form_submit">确认</button>
            </form>
        </div>
    </div>
</body>
</html>