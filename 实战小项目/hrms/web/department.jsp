<%--
  Created by IntelliJ IDEA.
  User: www
  Date: 2023/6/28
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门管理</title>
</head>
<body>
<h2>部门信息统计</h2>
<hr/>
<table>
    <thead>
    <tr>
        <th>部门ID</th>
        <th>部门名称</th>
        <th>部门人数</th>
        <th>总负责人</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${requestScope.dep10.dep_id}</td>
        <td><a href="DepInfoServlet?id=10">${requestScope.dep10.dep_name}</a></td>
        <td>${requestScope.dep10.headcount}</td>
        <td>${requestScope.dep10.man_name}</td>
    </tr>
    <tr>
        <td>${requestScope.dep11.dep_id}</td>
        <td><a href="DepInfoServlet?id=11">${requestScope.dep11.dep_name}</a></td>
        <td>${requestScope.dep11.headcount}</td>
        <td>${requestScope.dep11.man_name}</td>
    </tr>
    <tr>
        <td>${requestScope.dep12.dep_id}</td>
        <td><a href="DepInfoServlet?id=12">${requestScope.dep12.dep_name}</a></td>
        <td>${requestScope.dep12.headcount}</td>
        <td>${requestScope.dep12.man_name}</td>
    </tr>
    <tr>
        <td>${requestScope.dep13.dep_id}</td>
        <td><a href="DepInfoServlet?id=13">${requestScope.dep13.dep_name}</a></td>
        <td>${requestScope.dep13.headcount}</td>
        <td>${requestScope.dep13.man_name}</td>
    </tr>
    <tr>
        <td>${requestScope.dep14.dep_id}</td>
        <td><a href="DepInfoServlet?id=14">${requestScope.dep14.dep_name}</a></td>
        <td>${requestScope.dep14.headcount}</td>
        <td>${requestScope.dep14.man_name}</td>
    </tr>
    <tr>
        <td>${requestScope.dep15.dep_id}</td>
        <td><a href="DepInfoServlet?id=15">${requestScope.dep15.dep_name}</a></td>
        <td>${requestScope.dep15.headcount}</td>
        <td>${requestScope.dep15.man_name}</td>
    </tr>
    </tbody>
</table>

<a href="rootHome.jsp">管理后台</a>
</body>

</html>
