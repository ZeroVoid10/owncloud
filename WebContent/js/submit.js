$(document).ready(function(){
    $('#install').submit(function(e) {
        e.preventDefault();
        var info = checkInstallForm();
        var prompt = Array("type", "host", "port", "username", "db_password", "root_password");
        if (info.success == true) {
            $.ajax({
                type: 'POST',
                url: 'InstallServlet',
                data: $(this).serialize(),
                success: function() {
                    for (var index in prompt) {
                        var key = prompt[index];
                        $("#"+key).html("");
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
    console.log(port == NaN);
    var username = $("[name='db_username']").val();
    var db_password = $("[name='db_password']").val();
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
    if (username == '') {
        info.username = "请输入数据库用户名";
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
