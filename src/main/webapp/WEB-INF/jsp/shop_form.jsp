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
<body>
	<div>
		<div class="form-wrap">
			<form action="<%=basePath%>shop/apply" method="post" enctype="multipart/form-data">
				<div>
					<input type="text" name="idcardNum" placeholder="身份证id">
				</div>
				<div>
					<input type="text" name="merchantName" placeholder="名字">
				</div>
				<div>
					<input type="file" name="idcardPic" placeholder="身份证图片">
				</div>
				<div>
					<input type="file" name="shopPic">
					<input type="file" name="shopPic">
					<input type="file" name="shopPic">
				</div>
				<div>
					<input type="file" name="businessPic" placeholder="营业执照">
				</div>
				
				<div>
					<input type="text" name="address" placeholder="店铺地址">
				</div>
				<div>
					<input type="text" name="introduction" placeholder="店铺简介">
				</div>
				<div>
					<button>申请</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>