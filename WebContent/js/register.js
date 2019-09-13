$(document).ready(function() {
    $('#register').submit(function(e) {
        e.preventDefault();
        $('#error-msg').empty();
        var info = checkLoginForm();
        if (info.success == true) {
            $.ajax({
                type: 'POST',
                url: 'RegisterServlet',
                data: $(this).serialize(),
                success: function(res) {
                    $('#error-msg').empty();
                    if (res.register == 0) {
                        window.location.href = "login";
                    } else if (res.register == 1) {
                        $('#error-msg').append("<li class='item'>注册失败</li>");
                    } else if (res.register == 2) {
                        $('#error-msg').append("<li class='item'>" + "邮箱已注册" + "</li>")
                    }
                },
                error: function() {
                    alert('error');
                }
            })
        } else {
        	if (info.hasOwnProperty("name")) {
                $('#error-msg').append("<li class='item'>" + info.name + "</li>");
            }
            if (info.hasOwnProperty("mail")) {
                $('#error-msg').append("<li class='item'>" + info.mail + "</li>");
            }
            if (info.hasOwnProperty("password")) {
                $('#error-msg').append("<li class='item'>" + info.password + "</li>");
            }
        }
    })
})

function checkLoginForm() {
	var name = $("[name='username']").val();
    var mail = $("[name='email']").val();
    var password = $("[name='password']").val();
    var info = new Object();
    if (name  == '') {
        info.name = "用户名不能为空";
    }
    if (mail  == '') {
        info.mail = "注册邮箱不能为空";
    }
    if (password == '') {
        info.password = "密码不能为空";
    }
    if (Object.keys(info).length == 0) {
        info.success = true;
    } else {
        info.success = false;
    }
    return info;
}