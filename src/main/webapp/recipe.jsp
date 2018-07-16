<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri= "http://java.sun.com/jsp/jstl/core" %>  
<%@ page import="com.lames.merchant.config.*" %>      
<% String picRoot = WebServiceConfig.getConfig().get("image.server"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <body>
    <h3 align="center">添加菜品</h3>
    <form name="Recipe" action="recipe/add" method="post" enctype="multipart/form-data">
    <table border="0.5" align="center">
      <input type="hidden" name="shop_id" value="1374">
      <tr>
      <td>菜品名:</td>
      <td><input type="text" name="re_name"></td>
      </tr>
      <tr>
      <td>菜图片:</td>
      <td><input type="file" name="re_pic"></input></td>
      </tr>
      <tr>
      <td>菜详情:</td>
      <td><input type="text" name="detail"></td>
      </tr>
      <tr>
      <td>菜价格:</td>
      <td><input type="text" name="price"></td>
      </tr>
      <tr>
      <td><input type="reset" value="重置"></td>
      <td><input type="submit" value="提交"></td>
      </tr>
    </table>
    </form>
    </br>
	<table align="center" border="1">
		<c:if test="${not empty recipeList}">
		<tr>
			<td>菜品ID</td>
			<td>菜品名</td>
			<td>菜图片</td>
			<td>菜详情</td>
			<td>菜价格</td>
		</tr>
		
			<c:forEach items="${recipeList}" var="recipe">
				<tr>
					<td>${recipe.re_id}</td>
					<td>${recipe.re_name}</td>
					<td><img alt="图片凉凉~" src="<%=picRoot%>${recipe.re_pic}"></td>
					<td>${recipe.detail}</td>
					<td>${recipe.price}</td>
					<td>
						<form action="delete.do" method="post">
							<input type="hidden" name="re_id" value="${recipe.re_id}"/> 
							<input type="hidden" name="re_name" value="${recipe.re_name}"/> 
							<input type="hidden" name="re_pic" value="${recipe.re_pic}"/> 
							<input type="hidden" name="detail" value="${recipe.detail}"/> 
							<input type="hidden" name="price" value="${recipe.price}"/> 
							<input type="submit" value="delete" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty recipeList}">
			<tr>
				<td>您还没有菜单，请添加~</td>
			</tr>
		</c:if>			
	</table>    
</body>
</html>