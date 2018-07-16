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
    <form name="addRecipe" action="addRecipe.do" method="post" enctype="multipart/form-data">
    <table border="0.5" align="center">
      <input type="hidden" name="shop_id" value="${shop.shop_id}">
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
</body>
</html>