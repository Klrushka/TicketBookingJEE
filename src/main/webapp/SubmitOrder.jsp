<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.11.2021
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>Your Order</h1>
    <h2> ROOT: <%= session.getAttribute("fl")%>
    </h2>
    <form method="post">
        <table>
            <tr>
                <th>
                    Place number
                </th>
                <th>
                    Class
                </th>
                <th>
                    Price
                </th>
            </tr>
            <c:forEach var="seat" items="${seatOrder}">
                <tr>
                    <td>
                            ${seat.seat_number}
                    </td>
                    <td>
                            ${seat.sClass}
                    </td>
                    <td>
                            ${seat.price}
                    </td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" value="submit">
    </form>
</body>
</html>
