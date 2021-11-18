<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.11.2021
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comments</title>
</head>
<body>

<h1><%=session.getAttribute("fl")%>
</h1>

<form method="post">

    <c:forEach var="comments" items="${com}">
    <pre>
            ${comments.text}
    </pre>

    </c:forEach>

    <div>
        New Comment
    </div>

    <input type="text" width="1000" height="320" name="comment-text">
    <input type="submit" value="comment">

</form>
</body>
</html>
