<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.entity.Product" %>
<%@ page import="com.example.demo.service.ProductService" %><%--
  Created by IntelliJ IDEA.
  User: LONG
  Date: 4/7/2023
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    List<Product> list = (List<Product>) session.getAttribute("products");
%>

<h1>Danh sach cac san pham</h1>
<a href="product?action=create-product">Them san pham</a>

<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Description</td>
        <td>Actions</td>
    </tr>
    <tbody>
    <%
        for (Product product : list) {

    %>
    <tr>
        <td><%=product.getProductId()%>
        </td>
        <td><%=product.getProductName()%>
        </td>
        <td><%=product.getDescription()%>
        </td>
        <td>
            <a href="product?action=update-product&id=<%=product.getProductId()%>">Edit</a>
            <a href="product?action=delete-product&id=<%=product.getProductId()%>">Delete</a>
        </td>
    </tr>
    <%}%>

    </tbody>
</table>

</body>
</html>
