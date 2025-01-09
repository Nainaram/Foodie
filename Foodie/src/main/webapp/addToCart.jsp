<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
    // Retrieve form parameters
    String menuId = request.getParameter("menuId");
    String name = request.getParameter("name");
    String price = request.getParameter("price");
    String restId = request.getParameter("restId");
    String quantity = request.getParameter("quantity");

    // HashMap to store cart items (key: menuId, value: item details as a Map)
    HashMap<String, Map<String, String>> cart = (HashMap<String, Map<String, String>>) session.getAttribute("cart");
    if (cart == null) {
        cart = new HashMap<>();
    }

    // Create item details
    Map<String, String> itemDetails = new HashMap<>();
    itemDetails.put("name", name);
    itemDetails.put("quantity", quantity);
    itemDetails.put("price", price);
    itemDetails.put("restId", restId);

    // Add or update item in the cart
    cart.put(menuId, itemDetails);

    // Save cart to session
    session.setAttribute("cart", cart);

    // Redirect back to menu.jsp
    response.sendRedirect("menu.jsp");
%>

</body>
</html>