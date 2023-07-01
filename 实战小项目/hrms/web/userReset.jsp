<%--
  Created by IntelliJ IDEA.
  User: www
  Date: 2023/6/24
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>密码修改</title>
</head>

<body style="text-align: center;">

<h2>用户密码重置</h2>
<br/>
<br/>
<form method="post" action="/hrms/ResetServlet">

    <%--  原始密码  --%>
    <label for="oldPassword">原始密码：</label>
    <input type="password" name="oldPassword" id="oldPassword"
           placeholder="请输入您的原始密码" required/>

    <c:if test="${not empty requestScope.oldError}">
        <span style="color: red;align-content: center">
                ${requestScope.oldError}
        </span>
    </c:if>
    <br/>

    <%--  新密码  --%>
    <label for="newPassword">新密码：</label>
    <input type="password" name="newPassword" id="newPassword"
           placeholder="请输入您的新密码" required/>
    <br/>

    <%--  确认新密码  --%>
    <label for="confirmPassword">确认密码：</label>
    <input type="password" name="confirmPassword" id="confirmPassword" placeholder="请再次输入确认新密码" required/>

    <c:if test="${not empty requestScope.twoError}">
        <span style="color: red;align-content: center">
                ${requestScope.twoError}
        </span>
    </c:if>
    <br/>

    <input type="submit" value="提交">&nbsp;&nbsp;
    <input type="reset" value="重置">

    <br/>
    <c:if test="${not empty requestScope.reset}">
        <span style="color: red;align-content: center">
                ${requestScope.reset}
        </span>
    </c:if>
    <br/>
    <a href="${pageContext.request.contextPath}/UserShowServlet">返回主页</a>
</form>
</body>
</html>
