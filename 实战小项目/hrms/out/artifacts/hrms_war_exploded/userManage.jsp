<%--
  Created by IntelliJ IDEA.
  User: www
  Date: 2023/6/27
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>账号管理</title>
</head>

<body>
<h2>
    <center>账号管理</center>
</h2>
<%-- 实现账号的搜索--%>
<form method="get" action="<%=request.getContextPath() %>/UserSearchServlet">
    <lable for="idSearch">账号搜索：</lable>
    <input type="text" name="idSearch" id="idSearch" placeholder="请输入要搜索的账号"/>
    &nbsp;<input type="submit" value="搜索">
</form>
<c:if test="${not empty requestScope.searchMsg}">
        <span style="align-content: center">
                ${requestScope.searchMsg}
        </span>
</c:if>
<c:if test="${not empty requestScope.userSearch}">
        <span style="align-content: center">
                账号：${requestScope.userSearch.emp_id}
                密码：${requestScope.userSearch.password}
        </span>
</c:if>

<%--实现账号的申请--%>
<form method="get" action="<%=request.getContextPath() %>/UserInsertServlet">
    <lable for="idInsert">账号申请：</lable>
    <input type="text" name="idInsert" id="idInsert" placeholder="请输入要申请的账号"/>
    &nbsp;<input type="submit" value="申请">
</form>
<c:if test="${not empty requestScope.insertMsg}">
        <span style="align-content: center">
               ${requestScope.insertMsg}
        </span>
</c:if>

<%-- 实现账号的注销 --%>
<form method="get" action="<%=request.getContextPath() %>/UserDeleteServlet">
    <lable for="idDelete">账号注销：</lable>
    <input type="text" name="idDelete" id="idDelete" placeholder="请输入要删除的账号"/>
    &nbsp;<input type="submit" value="确认">
</form>
<c:if test="${not empty requestScope.deleteMsg}">
        <span style="align-content: center">
                ${requestScope.deleteMsg}
        </span>
</c:if>
<a href="rootHome.jsp">管理后台</a>
</body>
</html>
