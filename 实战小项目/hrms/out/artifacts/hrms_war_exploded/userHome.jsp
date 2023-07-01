<%--
  Created by IntelliJ IDEA.
  User: www
  Date: 2023/6/23
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户界面</title>
</head>
<body>
<center><h2>这里是用户主界面</h2></center>
<c:choose>
    <c:when test="${sessionScope.user==null}">
        <a href="${pageContext.request.contextPath}/index.jsp">用户登录</a>
    </c:when>
    <c:otherwise>
        <center>${cookie.id.value}!</center>
        <c:if test="${not empty requestScope.show.emp_name}">
            姓名:${requestScope.show.emp_name}<br/>
            工号:${requestScope.show.emp_id}<br/>
            个人邮箱:${requestScope.show.emp_email}<br/>
            部门:${requestScope.show.dep_name}<br/>
            部门管理者:${requestScope.show.man_name}<br/>
            邮箱:${requestScope.show.man_email}<br/>
            工龄:${requestScope.show.work_years}<br/>
        </c:if>
        <br/>
        <center>
            <a href="${pageContext.request.contextPath}/userReset.jsp">重置密码</a>
        </center>
        <br/>
        <center>
            <a href="${pageContext.request.contextPath}/LogoutServlet">注销</a>
        </center>
    </c:otherwise>
</c:choose>
<hr/>
</body>
</html>
