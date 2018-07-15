<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link href="<%=basePath%>/css/common.css" rel="stylesheet">
</head>
<style>
	*{
		vertical-align: bottom;
	}
	body{
		over-flow:hidden;
	}
	.main-content{
		display:flex;
	}
	.form-wrap{
		margin: 0 auto;
		width: 500px;
		margin-top: 200px;
	}
	input{
		font-size: 24px;
		padding: 12px;
		width: 100%;
		margin: 25px 0;
	}
	button{
		display: block;
		width: 100%;
		background-color: #00a997;
		height: 42px;
	    border: 1px solid #008476;
	    color: #FFF;
	    font-size: 18px;
	    border-radius: 3px;
	    cursor: pointer;
	    margin: 25px 0;
	}
	.error-message{
		color: red;
	}
</style>
<body>
	<div class="main-content">
		<div class="side" style="height:100%">
			<div class="side-bg-wrap" style="height:100%;line-height:0px;">
				<img src="<%=basePath%>/img/bg1.jpg" style="height:100%;">
			</div>
		</div>
		<div style="width:100%">
			<div class="form-wrap">
				<div>
					<h1>欢迎登录 Merchant</h1>
				</div>
				<form action="<%=basePath%>merchant/login" method="post">
					<div>
						<input type="text" name="loginName" placeholder="登录名">
					</div>
					<div>
						<input type="password" name="loginPassword" placeholder="密码">
					</div>
					<div style="margin: 5px 0;">
						<div class="error-message">${error}</div>
					</div>
					<div>
						<div>还没注册?<a href="<%=basePath%>register.jsp">注册</a></div>
					</div>
					<div>
						<button onclick="submit">登录</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script>
		var winHeight=0;
	    if (window.innerHeight){
	        winHeight = window.innerHeight;
	    }else if ((document.body) && (document.body.clientHeight)){
	        winHeight = document.body.clientHeight;
	    }
		var mainContent = document.getElementsByClassName("main-content")[0];
		console.log(mainContent);
		mainContent.style.height = (winHeight) + "px";
	</script>
</body>
</html>