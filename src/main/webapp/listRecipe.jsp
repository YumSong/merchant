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

	<a href="addRecipe.jsp">继续添加</a>
	<table align="center" border="1">
		<c:if test="${not empty recipeList}">
		<tr>
			<td>菜品ID</td>
			<td>菜品名</td>
			<td>菜图片</td>
			<td>菜详情</td>
			<td>菜价格</td>
			<td>修改</td>
			<td>删除</td>
		</tr>
			<c:forEach items="${recipeList}" var="recipe">
				<tr>
					<td>${recipe.re_id}</td>
					<td>${recipe.re_name}</td>
					<td><img alt="图片凉凉~" src="<%=picRoot%>${recipe.re_pic}"></td>
					<td>${recipe.detail}</td>
					<td>${recipe.price}</td>
					<td>
						<form action="modifyRecipe.do" method="post">
							<input type="hidden" name="re_id" value="${recipe.re_id}"/> 
							<input type="submit" value="修改" />
						</form>
					</td>					
					<td>
						<form action="deleteRecipe.do" method="post">
							<input type="hidden" name="shop_id" value="${recipe.shop_id}">
							<input type="hidden" name="re_id" value="${recipe.re_id}"/> 
							<input type="submit" value="删除" />
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