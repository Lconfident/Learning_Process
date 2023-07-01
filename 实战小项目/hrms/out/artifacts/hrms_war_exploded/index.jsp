<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: www
  Date: 2023/6/18
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body style="text-align: center;">

<h2>
    <center>Login</center>
</h2>

<form method="post" action="<%=request.getContextPath() %>/LoginServlet">
    <%-- “用户名”字段 --%>
    <%--  如果请求参数中包含名为 “emp_id” 的参数，则将其值填充到 “emp_id” 表单字段中
   否则，如果 cookie 中包含名为 “emp_id” 的 cookie
   则将该 cookie 的值填充到 “emp_id” 表单字段中
   否则，将空字符串填充到 “emp_id” 表单字段中--%>
    <label for="emp_id">账号:</label>
    <input type="text" name="id" id="id" placeholder="请输入账号" required="required"/>
    <br/>
    <%-- “密码”字段 --%>
    <label for="password">密码:</label>
    <input type="password" name="password" id="password" placeholder="请输入密码" required="required"/>
    <br/>
    <%-- 显示错误消息 --%>
    <c:if test="${not empty requestScope.error}">
        <p style="color: red;align-content: center">${error}</p>
    </c:if>
    <input type="submit" value="登录"/>&nbsp;&nbsp;&nbsp;
    <input type="reset" value="重置">
</form>
</body>
</html>
