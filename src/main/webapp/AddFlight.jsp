<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 30.10.2021
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Flight</title>
</head>
<body>
<form method="post">
    <div class="flight-add-block">
        <p>
            <input type="datetime-local" value="Enter date and time" placeholder="YYYY-MM-DD HH:MM:SS" name="time">
        </p>

        <p>
            <input type="text" placeholder="from" name="from">
        </p>

        <p>
            <input type="text" placeholder="to" name="to">
        </p>

        <p>
            <input type="text" placeholder="name" name="name">
        </p>

        <p>
            <input type="submit">
        </p>


    </div>
</form>
</body>
</html>
