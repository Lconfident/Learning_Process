<%--
  Created by IntelliJ IDEA.
  User: www
  Date: 2023/6/30
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>部门信息</title>
</head>
<body>
<h2>${requestScope.depName}</h2>
<table>
    <thead>
    <tr>
        <th>姓名</th>
        <th>账号</th>
        <th>邮箱</th>
        <th>管理</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="staff">
        <tr>
            <td>${staff.emp_name}</td>
            <td>${staff.emp_id}</td>
            <td>${staff.email}</td>
            <td>${staff.man_name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
