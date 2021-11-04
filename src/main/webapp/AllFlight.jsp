<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.11.2021
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> all flights</title>
</head>
<body>

<table>
    <tr>
        <th>Root</th>
        <th>From</th>
        <th>To</th>
        <th>Time</th>
        <th></th>
    </tr>

    <c:forEach var="flights" items="${flight}">
        <tr>
            <td>
                    ${flights.name}
            </td>

            <td>
                    ${flights.from}
            </td>
            <td>
                    ${flights.to}
            </td>
            <td>
                <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value="${flights.time}" />
            </td>

            <td>
                <form action="AddSeat.jsp">
                    <button >
                        book
                    </button>
                </form>

            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
