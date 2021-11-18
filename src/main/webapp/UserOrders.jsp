
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.11.2021
  Time: 22:34
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

<h1> <%=session.getAttribute("fl")%> </h1>
<form method="post">
    <table>
        <tr>
            <th>

            </th>
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


        <c:forEach var="seat" items="${seats1}">
            <tr>
                <td>
                    <input type="checkbox" name="seat-id" value="${seat.id}">
                </td>
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
</form>
</body>
</html>
