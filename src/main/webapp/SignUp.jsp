<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.10.2021
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <meta name="viewport" content="device-width">
    <link rel="stylesheet" href="WEB-INF/styles/LogIn.css">
</head>
<body>

<h1>Registration</h1>

<form method="post">
    <div class="registration-block">

        <p>
        <input name="name" id="name-input" title="Full name">
        </p>
<p>

        <input name="mail" id="mail-input" title="mail">
</p>

        <p>

        <input type="date" name="birthday" placeholder="YYYY-MM-DD" required
               pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" title="Enter a date in this format YYYY-MM-DD" id="birthday-input"/>
        </p>

        <p>
        <input type="tel" name="phoneNumber" id="phonenumber-input" title="phone">
        </p>

        <p>
        <input type="password" name="password" id="password-input" title="password">
        </p>
        <p>
        <input type="submit" value="Save" />
        </p>

    </div>
</form>

</body>
</html>
