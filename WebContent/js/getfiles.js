$(getfiles());

function getfiles() {
    $.ajax({
        type: 'POST',
        url: 'IndexServlet',
        data: {'req': 'getfiles'},
        async: true,
        success:function(data) {
            data.forEach(fucntion(info) {
                var dd = "<dd class='g-clearfix filelable open-enable'><input name='boxes[]'" +
                    "onclick='checkall()' type='checkbox' id='check' " +
                    "value='" + info.filepath +"' /></span></span>";
                var fileimg = "<div class='file-img dir-small'><img src='img/" +
                                info.type + ".png'style='width:26px;height:26px;'></div>";
                var filename = "<div class='file-name' style='width:50%'>" + 
                                "<div class='text'><a href='' title='" + info.name + "'>" + info.name +"</a></div>"+
                                "</div>";
                
            });

            })
        }
    })
}