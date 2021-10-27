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
</head>
<body>

<h1>Registration</h1>

<form method="post">
    <div class="registration-block">
        <label for="name-input">
            Enter your full name
        </label>

        <input name="name" id="name-input">

        <label for="mail-input">
            Enter your email
            <br>
        </label>

        <input name="mail" id="mail-input">

        <label for="birthday-input">
            Enter your Birthday date
            <br>
        </label>

        <input type="date" name="birthday" placeholder="YYYY-MM-DD" required
               pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" title="Enter a date in this format YYYY-MM-DD" id="birthday-input"/>

        <label for="phonenumber-input">
            Enter your phone number
            <br>
        </label>

        <input type="tel" name="phonenumber" id="phonenumber-input">

        <label for="password-input">
             Enter your password
            <br>
        </label>

        <input type="password" name="password" id="password-input" >
        <br>

        <input type="submit" value="Save" />

    </div>
</form>

</body>
</html>
