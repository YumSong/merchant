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
					<input type="text" name="shop_name" placeholder="店铺名字" value="${shop.shop_name}">
				</div>
				<div>
					<input type="text" name="service_starttime" placeholder="服务开始时间" value="${shop.service_starttime}">
				</div>
				<div>
					<input type="text" name="service_endtime" placeholder="服务结束时间" value="${shop.service_endtime}">
				</div>
				<div>
					<input type="text" name="service_range" placeholder="服务范围" value="${shop.service_range}">
				</div>
				<div>
					<input type="text" name="distribution_cost" placeholder="服务费用" value="${shop.distribution_cost}">
				</div>
				<div>
					<input type="text" name="idcardNum" placeholder="身份证id" value="${merchantDetail.idcardNum}">
				</div>
				<div>
					<input type="text" name="merchantName" placeholder="名字" value="${merchantDetail.merchantName}">
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
					<input type="text" name="address" placeholder="店铺地址"  value="${merchantDetail.address}">
				</div>
				<div>
					<input type="text" name="introduction" placeholder="店铺简介"  value="${merchantDetail.introduction}">
				</div>
				<div>
					<button>申请</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>