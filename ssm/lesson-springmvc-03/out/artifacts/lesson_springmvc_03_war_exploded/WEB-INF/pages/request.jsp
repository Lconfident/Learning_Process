<%--
  Created by IntelliJ IDEA.
  User: www
  Date: 2023/12/12
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>成功运行</h2>
<form action="${pageContext.request.contextPath }/register">
    用户名：${username}<br>
    密码：${password}
</form>
</body>
</html>
