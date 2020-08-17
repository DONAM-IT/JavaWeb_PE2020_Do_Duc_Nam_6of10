<%-- 
    Document   : search
    Created on : Jul 14, 2020, 16:39:25 PM
    Author     : namdo
--%>

<%@page import="namdd.dtos.ProductDTO"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping Cart!</h1>
        <form action="MainController">
            <input type="submit" name="btnAction" value="load">
        </form>
        <%
            Vector<ProductDTO> list = (Vector<ProductDTO>) session.getAttribute("LIST");
            if (list != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ProductID</th>
                    <th>ProductName</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Add</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (ProductDTO dto : list) {
                %>
                <tr>
                    <td><%=count++%></td>
                    <td><%=dto.getProductID()%></td>
                    <td><%=dto.getProductName()%></td>
                    <td><%=dto.getPrice()%></td>
                    <td><%=dto.getQuantity()%></td>
                    <td>
                        <form action="MainController" method="POST">
                            <input type="hidden" name="txtProductID" value="<%=dto.getProductID()%>">
                            <input type="hidden" name="txtProductName" value="<%=dto.getProductName()%>">
                            <input type="hidden" name="txtPrice" value="<%=dto.getPrice()%>">
                            <input type="hidden" name="txtQuantity" value="<%=dto.getQuantity()%>">
                            <input type="submit" name="btnAction" value="Add">
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>

            </tbody>
        </table>
        <%
            }
        %>
        <a href="MainController?btnAction=View">View Cart</a>

    </body>
</html>
