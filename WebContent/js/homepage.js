$(document).ready(function() {
   
    getfileinfo();
    checkUploadButton();
    checkFolderButton();
    checkProjectButton();
    checkAddUserButton();
    checkSearchButton();
    checkUploadForm();
    checkFolderForm();
    checkProjectForm();
    checkSearchForm();
    checkAddUserForm();
});

function getfileinfo() {
    $.ajax({
        type: 'GET',
        url: 'IndexServlet',
        data: "request=fileinfo",
        success: function(res) {
            showfileinfo(res);
        }, 
        error: function() {
            alert('failed get fileinfo');
        }
    })
}

String.prototype.temp = function(obj) {
    return this.replace(/\$\w+\$/gi, function(matchs) {
        var returns = obj[matchs.replace(/\$/g, "")];		
        return (returns + "") == "undefined"? "": returns;
    });
};

function showfileinfo(info) {
    var htmlList = '';
    var htmltemp = $("textarea").val();
    if (info.hasOwnProperty("fileinfo")) {
        info.fileinfo.forEach(function(object) {
            htmlList += htmltemp.temp(object);
        });
        $('#fileinfo').html(htmlList);
    }
}

function checkUploadForm() {
    $('#upload-form').submit(function(e) {
        e.preventDefault();
        clearErrorMsg();
        
        var info = _checkUpload();
        var formdata = new FormData();
        if (info.success == true) {
            var file = $('#upload-file').prop('files')[0];
            var filename = file.name;
            formdata.append("description", $('#upload-path').val());
            formdata.append("tags", $('#tags').val());
            formdata.append("suffix", filename.substr(filename.lastIndexOf(".")+1).toLowerCase());
            formdata.append("filename", filename);
            formdata.append("filesize", file.size);
            formdata.append("file", file);
            $.ajax({
                type: "POST",
                url: 'IndexServlet',
                data: formdata,
                cache: false,
                processData: false,
                contentType: false,
                success: function(res) {
                    clearErrorMsg();
                    if (res.success == false) {
                        alert("Upload failed!");
                    } else {
                        $('#upload-div').hide();
                    }
                    getfileinfo();
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

function clearErrorMsg() {
    $('#upload-error-file').html('');
    $('#upload-error-path').html('');
}

function checkFolderForm() {
    $('#folder-form').submit(function(e) {
        e.preventDefault();
        clearErrorMsg();
        
        var info = _checkFolder();
        if (info.success == true) {
            $.ajax({
                type: "POST",
                url: 'IndexServlet',
                data: $(this).serialize() + "&resquest=newfolder",
                success: function(res) {
                    clearErrorMsg();
                    if (res.success == false) {
                        alert("Create folder failed!");
                    } else {
                        $('#folder-div').hide();
                    }
                },
                error: function() {
                    alert('newfolder error');
                }
            });
        } else {
            if (info.hasOwnProperty('path')) {
                $('#folder-error-path').html(info.path);
            }
            if (info.hasOwnProperty('file')) {
                $('#folder-error-file').html(info.file);
            }
        }
    })
}
function _checkFolder() {
    var path = $('#folder-path').val();
    var name = $('#folder-name').val();
    var info = new Object();
    if (path == '') {
        info.path = '新建目录名不能为空';
    }
    if (name == '') {
        info.file = '文件夹名不能为空';
    }

    if (Object.keys(info).length == 0) {
        info.success = true;
    } else {
        info.success = false;
    }
    return info;
}

function checkProjectForm() {
    $('#project-form').submit(function(e) {
        e.preventDefault();
        clearErrorMsg();
        
        var info = _checkProject();
        if (info.success == true) {
            $.ajax({
                type: "POST",
                url: 'IndexServlet',
                data: $(this).serialize() + "&resquest=newproject",
                success: function(res) {
                    clearErrorMsg();
                    if (res.success == false) {
                        alert("Create project failed!");
                    } else {
                        $('#project-div').hide();
                    }
                },
                error: function() {
                    alert('newproject error');
                }
            });
        } else {
            if (info.hasOwnProperty('file')) {
                $('#project-error-file').html(info.file);
            }
        }
    })
}
function _checkProject() {
	var name = $('#project-name').val();
    var info = new Object();
    if (name == '') {
        info.file = '项目名不能为空';
    }

    if (Object.keys(info).length == 0) {
        info.success = true;
    } else {
        info.success = false;
    }
    return info;
}

function checkSearchForm() {
    $('#search-form').submit(function(e) {
        e.preventDefault();
        clearErrorMsg();
        
        var info = _checkSearch();
        if (info.success == true) {
            $.ajax({
                type: "POST",
                url: 'IndexServlet',
                data: $(this).serialize() + "&resquest=search",
                success: function(res) {
                    clearErrorMsg();
                    if (res.success == false) {
                        alert("Search failed!");
                    } else {
                        $('#search-div').hide();
                    }
                },
                error: function() {
                    alert('search error');
                }
            });
        } else {
            if (info.hasOwnProperty('item')) {
                $('#search-error').html(info.item);
            }
        }
    })
}
function _checkSearch() {
	var path = $('#search-project').val();
	var tag = $('#search-tag').val();
	var uid = $('#search-uid').val();
	var name = $('#search-file').val();
    var info = new Object();
    if (path == ''&&tag == ''&&uid == ''&&name == '') {
        info.item = '请填写搜索项';
    }

    if (Object.keys(info).length == 0) {
        info.success = true;
    } else {
        info.success = false;
    }
    return info;
}

function checkAddUserForm() {
    $('#adduser-form').submit(function(e) {
        e.preventDefault();
        clearErrorMsg();
        
        var info = _checkAddUser();
        if (info.success == true) {
            $.ajax({
                type: "POST",
                url: 'IndexServlet',
                data: $(this).serialize() + "&resquest=adduser",
                success: function(res) {
                    clearErrorMsg();
                    if (res.success == false) {
                        alert("Create project failed!");
                    } else {
                        $('#adduser-div').hide();
                    }
                },
                error: function() {
                    alert('adduser error');
                }
            });
        } else {
            if (info.hasOwnProperty('project')) {
                $('#adduser-error-project').html(info.project);
            }
            if (info.hasOwnProperty('user')) {
                $('#adduser-error-user').html(info.user);
            }
        }
    })
}
function _checkAddUser() {
	var project = $('#adduser-project').val();
	var user = $('#username').val();
    var info = new Object();
    if (project == '') {
        info.project = '项目名不能为空';
    }
    if (user == '') {
        info.user = 'UID不能为空';
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
    $('#folder-div').hide();
    $('#project-div').hide();
    $(document).one("click", function(){
        $('#upload-div').hide();
    });
    e.stopPropagation();
}

function checkFolderButton() {
    $('#folder-button').click(clickFolder);
    $('#folder-div').click(function(e){
        e.stopPropagation();
    });
}

function clickFolder(e) {
    $('#folder-div').toggle();
    $('#adduser-div').hide();
    $('#search-div').hide();
    $('#upload-div').hide();
    $('#project-div').hide();
    $(document).one("click", function(){
        $('#folder-div').hide();
    });
    e.stopPropagation();
}

function checkProjectButton() {
    $('#project-button').click(clickProject);
    $('#project-div').click(function(e){
        e.stopPropagation();
    });
}

function clickProject(e) {
    $('#project-div').toggle();
    $('#adduser-div').hide();
    $('#search-div').hide();
    $('#upload-div').hide();
    $('#folder-div').hide();
    $(document).one("click", function(){
        $('#project-div').hide();
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
    $('#folder-div').hide();
    $('#project-div').hide();
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
    $('#folder-div').hide();
    $('#project-div').hide();
    $(document).one("click", function() {
        $('#search-div').hide();
    });
    e.stopPropagation();
}

function DownLoad(){
	checkpath();//获取路径
}

function getmore() {
  alert("更多功能研发(摸鱼)中，敬请期待Σ(ﾟдﾟ)");
}