<%-- 
    Document   : ViewCart
    Created on : Jul 14, 2020, 16:10:25 PM
    Author     : namdo
--%>

<%@page import="namdd.dtos.ProductDTO"%>
<%@page import="namdd.dtos.ProductDTO"%>
<%@page import="namdd.dtos.ProductDTO"%>
<%@page import="namdd.dtos.ProductDTO"%>
<%@page import="namdd.dtos.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Cart!</h1>
        <%
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>productID</th>
                    <th>productName</th>
                    <th>Price</th>
                    <th>Amount</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (ProductDTO dto : cart.getCart().values()) {
                %>
                <tr>
                    <td><%=count++%></td>
                    <td><%=dto.getProductID()%></td>
                    <td><%=dto.getProductName()%></td>
                    <td><%=dto.getPrice()%></td>
                    <td><%=dto.getAmount()%></td>
                </tr>
                <%
                    }
                %>


            </tbody>
        </table>
        <%
            }
        %>

    </body>
</html>
