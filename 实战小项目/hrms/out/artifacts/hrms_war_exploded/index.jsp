<%@ page import="entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: www
  Date: 2023/6/18
  Time: 11:19
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="./css/login.css">
    <title>员工管理系统</title>
</head>
<body>

<div class="login-container">
    <!-- 图片 -->
    <div class="img-container">
        <img src="./img/login.jpg" alt="login.jpg">
    </div>

    <!-- 登录表单 -->
    <form method="post"
          action="<%=request.getContextPath() %>/LoginServlet" class="form-container">
        <span class="active login-welcome">欢迎登录</span>
        <br/>

        <span class="login-text">账号</span><br/>
        <input type="text" name="id" class="text" placeholder="请输入您的账号" required/>
        <br/>

        <span class="login-text">密码</span><br/>
        <input type="password" name="password" class="text" placeholder="请输入您的密码" required/>

        <br/>

        <!-- ${error} -->
        <c:if test="${not empty requestScope.error}">
            <p class="error">${error}</p>
        </c:if>

        <br/>

        <div class="button">
            <input type="submit" value="登录" class="login"/>
            <input type="reset" value="重置" class="login"/>
        </div>
    </form>
</div>
</body>
</html>
