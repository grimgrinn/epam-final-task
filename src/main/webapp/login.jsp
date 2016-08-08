<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07.08.2016
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>

    <form action="login" method="post">
        <input type="text" name="username">
        <input type="password" name="password">
        <input type="submit"> ${error}
    </form>

</body>
</html>
