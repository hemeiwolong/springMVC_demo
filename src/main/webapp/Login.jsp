<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<div style="text-align: center">
    <form action="login" method="post" id="loginFrom">
        姓名：<input type="text" name="uname" id = "uname" value = "${messageObject.object.name}"><br>
        密码：<input type="text" name="upwd" id = "upwd" value = "${messageObject.object.pwd}"><br>
        <button type="button" id="loginBtn">登录</button>
        <button type="button">注册</button>
    </form><br>
	<span id = "msg" style="font-size: 12px;color: red">${messageObject.msg}</span>
</div>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script>
	function isEmpty(str) {
		if (str == null || str == "") {
			return true;
		}
		return false;
	}

    $("#loginBtn").click(function() {
		var uname = $("#uname").val();
		var upwd = $("#upwd").val();

		if (isEmpty(uname) || isEmpty(upwd)) {
			$("#msg").html("uname or upwd is null!");
			return;
		} else {
		    $("#msg").html("");
		}

		$("#loginFrom").submit();
	});
</script>
</html>