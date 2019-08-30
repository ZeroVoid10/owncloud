$(document).ready(function(){
    $('#install').submit(function(e) {
        e.preventDefault();
        $("#install-msg").html("");
        var info = checkInstallForm();
        var prompt = Array("type", "host", "port", "db_name", "username", "db_password", "root_mail", "root_password");
        if (info.success == true) {
            $.ajax({
                type: 'POST',
                url: 'InstallServlet',
                data: $(this).serialize(),
                success: function(res) {
                    for (var index in prompt) {
                        var key = prompt[index];
                        $("#"+key).html("");
                    }
                    if (res.connection == true) {
                        toLogin();
                    } else {
                        conFailed();
                    }
                },
                error: function() {
                    alert('error');
                }
            });
        } else {
            for (var index in prompt) {
                var key = prompt[index];
                if (info.hasOwnProperty(key)) {
                    $("#"+key).html(info[key]);
                } else {
                    $("#"+key).html("");
                }
            }
        }
    });
});

function checkInstallForm() {
    var type = $("select[name='db_type']").val();
    var host = $("[name='db_host']").val();
    var port = $("[name='db_port']").val();
    port = parseInt(port);
    var db_name = $("[name='db_name']").val();
    var username = $("[name='db_username']").val();
    var db_password = $("[name='db_password']").val();
    var root_mail = $("[name='root_mail']").val();
    var root_password = $("[name='root_password']").val();
    var info = new Object();
    if (type == '') {
        info.type = "请选择数据库类型";
    }
    if (host != 'localhost' && !validIP(host)) {
        info.host = "非法IP，请输入正确数据库IP,如127.0.0.1";
    }
    if (isNaN(port) || port < 1 || port > 65535) {
        info.port = "非法端口号，请输入正确端口号1～65535";
    }
    if (db_name == '') {
        info.db_name = "请输入数据库名";
    }
    if (username == '') {
        info.username = "请输入数据库用户名";
    }
    if (!validMail(root_mail)) {
        info.root_mail = "非法邮箱，请正确输入邮箱";
    }
    if (root_password == '') {
        info.root_password = "root密码不能为空";
    }

    if (Object.keys(info).length == 0) {
        info.success = true;
    } else {
        info.success = false;
    }
    return info;
}

function validIP(inputIP) {
    var re = /^([0-9]|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.([0-9]|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.([0-9]|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.([0-9]|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])$/;
    return re.test(inputIP);
}

function validMail(mail) {
    var re = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    return re.test(mail);
}

function toLogin() {
    $.ajax({
        type: "GOT",
        url: "login",
        async: false,
        success: function(msg) {
            if (msg) {
                window.location.href = "login";
            }
        }
    });
}

function conFailed() {
    $("#install-msg").html("无法连接到数据库，请检查填写信息及数据库配置");
}
