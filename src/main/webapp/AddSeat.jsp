<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31.10.2021
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddSeats</title>
</head>
<body>
    <form method="post">
        <p>
            <input type="number" placeholder="flight id" name="flight_id">
        </p>

        <p>
            <input type="number" step="0.01" placeholder="price per one" name="price">
        </p>

        <p>
            <select name="class">
                <option value="Economy class"> Economy class </option>
                <option value="Business Class"> Business Class </option>
            </select>
        </p>

        <p>
            <input type="number" placeholder="seat number(since)"  name="seat_number">
        </p>

        <p>
            <input type="number" placeholder="how much" name="n">
        </p>

        <p>
            <input type="number" value="-1" name="order_id">
        </p>

        <p>
            <input type="submit">
        </p>


    </form>
</body>
</html>
