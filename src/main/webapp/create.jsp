<%@ page import="com.example.demo.service.ProductService" %>
<%@ page import="com.example.demo.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: LONG
  Date: 4/7/2023
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Product product = (Product) request.getAttribute("product");
    if (product != null) {
%>
<h1>Update product</h1>

<form action="product?action=update-product" method="post">
    <label>ID</label>
    <input type="text" readonly name="productID" value="<%=product.getProductId()%>"/>
    <br/>
    <label>Name</label>
    <input type="text" name="productName" value="<%=product.getProductName()%>"/>
    <br/>
    <label>Description</label>
    <input type="text" name="description" value="<%=product.getDescription()%>"/>
    <br/>

    <br/>
    <input type="submit" value="submit"/>
</form>
<%} else {%>
<h1>Create product</h1>

<form action="product?action=create-product" method="post">
    <label>ID</label>
    <input type="text" name="productID"/>
    <br/>
    <label>Name</label>
    <input type="text" name="productName"/>
    <br/>
    <label>Description</label>
    <input type="text" name="description"/>
    <br/>
    <label>ManID</label>
    <input type="text" name="manID"/>
    <br/>
    <input type="submit" value="submit"/>
</form>
<%}%>
</body>
</html>
