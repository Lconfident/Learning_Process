<%--
  Created by IntelliJ IDEA.
  User: www
  Date: 2023/6/28
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>岗位管理</title>
</head>
<body>
    <form action="/hrms/\" method="post">
        请输入账号：<input type="text" name="emp_id">
        <br/>
        <label for="dep">请选择部门：</label>
        <select name="dep_id" id="dep">
            <option value="10">董事会</option>
            <option value="11">行政部</option>
            <option value="12">财务部</option>
            <option value="13">运营部</option>
            <option value="14">研发部</option>
            <option value="15">人力资源部</option>
        </select>
        <br/>
        请选择管理者：<input type="number" name="man_id">
        <br/>
        <c:if test="${not empty requestScope.depMsg}">
        <span style="color: red;align-content: center">
                ${requestScope.depMsg}
        </span>
        </c:if>
        <br/>
        <input type="submit" value="确认">
    </form>
</body>
</html>
