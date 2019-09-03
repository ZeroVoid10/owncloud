$(document).ready(function() {
    $('#login').submit(function(e) {
        e.preventDefault();
        $('#error-msg').empty();
        var info = checkLoginForm();
        if (info.success == true) {
            $.ajax({
                type: 'POST',
                url: 'LoginServlet',
                data: $(this).serialize(),
                success: function(res) {
                    $('#error-msg').empty();
                    if (res.login == 0) {
                        window.location.href = "index";
                    } else if (res.login == 1) {
                        $('#error-msg').append("<li class='item'>用户名或密码错误</li>");
                    } else if (res.login == 2) {
                        $('#error-msg').append("<li class='item'>" + "邮箱未注册" + "</li>")
                    }
                },
                error: function() {
                    alert('error');
                }
            })
        } else {
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
    var mail = $("[name='mail']").val();
    var password = $("[name='password']").val();
    var info = new Object();
    if (!validMail(mail)) {
        info.mail = "非法邮箱，请正确输入邮箱";
    }
    if (password == '') {
        info.password = "root密码不能为空";
    }
    if (Object.keys(info).length == 0) {
        info.success = true;
    } else {
        info.success = false;
    }
    return info;
}