function checkpath() {
  var path = "";
  var num = 0;
  var checkbox = document.getElementsByName("boxes[]");
  for (var i = 0; i < checkbox.length; i++) {
    if (checkbox[i].checked == true) {
      path += checkbox[i].value + ";";
      num++;
    }
  }
}

function allcheck() {
  var nn = document.getElementById("allcheck").checked;
  if (nn == true) {
    var checkbox = document.getElementsByName("boxes[]");
    for (var i = 0; i < checkbox.length; i++) {
      checkbox[i].checked = true;
    }
  }
  if (nn == false) {
    var checkbox = document.getElementsByName("boxes[]");
    for (var i = 0; i < checkbox.length; i++) {
      checkbox[i].checked = false;
    }
  }
}
function checkall() {
  var checkbox = document.getElementsByName("boxes[]");
  for (var i = 0; i < checkbox.length; i++) {
    if (checkbox[i].checked == false) {
      document.getElementById("allcheck").checked = false;
      break;
    } else {
      document.getElementById("allcheck").checked = true;
    }
  }
}

function addselect() {
  document.getElementById("selectdelete").checked = false;
}
function deleteselect() {
  document.getElementById("selectadd").checked = false;
}

function download() {
  var path = document.getElementsByName("boxes[]").value;
  alert(path);
}
