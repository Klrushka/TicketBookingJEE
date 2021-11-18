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
<form method="post">
    <table title="Flights">
        <tr>
            <th>Root</th>
            <th>From</th>
            <th>To</th>
            <th>Time</th>
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
                    <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${flights.time}"/>
                </td>
            </tr>

        <tr>

        </tr>


        </c:forEach>
    </table>


    <h2> Choose your Root </h2>

    <select name="flyname">
        <c:forEach items="${flight}" var="flights">
            <option value="${flights.name}"> ${flights.name} </option>
        </c:forEach>


        <input type="submit" >

    </select>

</form>
</body>
</html>
