$(document).ready(function() {
    checkUploadButton();
    checkAddUserButton();
    checkSearchButton();
    checkUploadForm();
});

$(document).ready(function() {
});

function checkUploadForm() {
    $('#upload-form').submit(function(e) {
        e.preventDefault();
        clearErrorMsg();
        
        var info = _checkUpload();
        if (info.success == true) {
            $.ajax({
                type: "POST",
                url: 'UploadServlet',
                data: $(this).serialize() + "&resquest=upload",
                success: function(res) {
                    clearErrorMsg();
                    if (res.success == false) {
                        alert("Upload failed!");
                    } else {
                        $('#upload-div').hide();
                    }
                },
                error: function() {
                    alert('upload error');
                }
            });
        } else {
            if (info.hasOwnProperty('path')) {
                $('#upload-error-path').html(info.path);
            }
            if (info.hasOwnProperty('file')) {
                $('#upload-error-file').html(info.file);
            }
        }
    })
}

function clearErrorMsg() {
    $('#upload-error-file').html('');
    $('#upload-error-path').html('');
}

function _checkUpload() {
    var path = $('#upload-path').val();
    var file = $('#file').val();
    var info = new Object();
    if (path == '') {
        info.path = '上传目录名不能为空';
    }
    if (file == '') {
        info.file = '未选择上传文件';
    }

    if (Object.keys(info).length == 0) {
        info.success = true;
    } else {
        info.success = false;
    }
    return info;
}

function checkUploadButton() {
    $('#upload-button').click(clickUpload);
    $('#upload-div').click(function(e){
        e.stopPropagation();
    });
}

function clickUpload(e) {
    $('#upload-div').toggle();
    $('#adduser-div').hide();
    $('#search-div').hide();
    $(document).one("click", function(){
        $('#upload-div').hide();
    });
    e.stopPropagation();
}

function checkAddUserButton() {
    $('#adduser-button').click(clickAddUser);
    $('#adduser-div').click(function(e){
        e.stopPropagation();
    });
}

function clickAddUser(e) {
    $('#adduser-div').toggle();
    $('#search-div').hide();
    $('#upload-div').hide();
    $(document).one("click", function(){
        $('#adduser-div').hide();
    });
    e.stopPropagation();
}

function checkSearchButton() {
    $('#search-button').click(clickSearch);
    $('#search-div').click(function(e) {
        e.stopPropagation();
    });
}

function clickSearch(e) {
    $('#search-div').toggle();
    $('#upload-div').hide();
    $('#adduser-div').hide();
    $(document).one("click", function() {
        $('#search-div').hide();
    });
    e.stopPropagation();
}

function getmore() {
  alert("更多功能研发(摸鱼)中，敬请期待Σ(ﾟдﾟ)");
}