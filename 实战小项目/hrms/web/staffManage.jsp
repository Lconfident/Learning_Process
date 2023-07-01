<%--
  Created by IntelliJ IDEA.
  User: www
  Date: 2023/6/28
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工管理</title>
</head>
<body>
<%--入职--%>
<h3>员工入职信息填写</h3>
<form method="post" action="<%=request.getContextPath()%>/JoinServlet">
    姓名:<input type="text" name="emp_name" placeholder="请输入姓名" required><br/>
    性别:
    <select name="sex">
        <option value="男" selected>男</option>
        <option value="女">女</option>
    </select><br/>
    <%--    <input input="text" name="sex" placeholder="请输入性别"/><br/>--%>
    出生日期:<input type="date" name="birth_date" value="1990-01-01"><br/>
    籍贯:<input type="text" name="native_place" placeholder="北京" required><br/>
    学历:
    <select name="education">
        <option value="本科" selected>请选择</option>
        <option value="专科">专科</option>
        <option value="本科">本科</option>
        <option value="研究生">研究生</option>
    </select><br/>
    毕业院校:<input type="text" name="graduate_school" placeholder="请输入毕业院校名称" required><br/>
    专业:<input type="text" name="major" placeholder="请输入所学专业" required><br/>
    邮箱:<input type="email" name="email" placeholder="xxxxx@company.com" required><br/>
    员工账号:<input type="number" name="emp_id" placeholder="请输入三位数字" required><br/>
    入职日期:<input type="date" name="hire_date" value="2018-01-01"><br/>

    <input type="submit" value="提交信息"><input type="reset" value="重置信息">
</form>

<c:if test="${not empty requestScope.staffInsertMsg}">
    <h4>${requestScope.staffInsertMsg}</h4>
</c:if>

<hr>

<%--信息修改--%>

<h3>员工入职信息修改</h3>
<form method="post" action="<%=request.getContextPath()%>/EditServlet">
    姓名:<input type="text" name="emp_name" placeholder="请输入姓名" required><br/>
    性别:
    <select name="sex">
        <option value="男" selected>男</option>
        <option value="女">女</option>
    </select><br/>
    <%--    <input input="text" name="sex" placeholder="请输入性别"/><br/>--%>
    出生日期:<input type="date" name="birth_date" value="1990-01-01"><br/>
    籍贯:<input type="text" name="native_place" placeholder="北京" required><br/>
    学历:
    <select name="education">
        <option value="本科" selected>请选择</option>
        <option value="专科">专科</option>
        <option value="本科">本科</option>
        <option value="研究生">研究生</option>
    </select><br/>
    毕业院校:<input type="text" name="graduate_school" placeholder="请输入毕业院校名称" required><br/>
    专业:<input type="text" name="major" placeholder="请输入所学专业" required><br/>
    邮箱:<input type="email" name="email" placeholder="xxxxx@company.com" required><br/>
    员工账号:<input type="number" name="emp_id" placeholder="请输入三位数字" required><br/>
    入职日期:<input type="date" name="hire_date" value="2018-01-01"><br/>

    <input type="submit" value="提交信息"><input type="reset" value="重置信息">
</form>
<c:if test="${not empty requestScope.staffEditMsg}">
    <h4>${requestScope.staffEditMsg}</h4>
</c:if>

<hr/>

<h3>员工离职信息填写</h3>
<form method="post" action="<%=request.getContextPath()%>/LeaveServlet">
    <input type="text" name="name" id="name" placeholder="姓名" required/><br/>
    <input type="number" name="id" placeholder="账号" required/><br/>

    <input type="submit" value="离职"/>&nbsp;
    <input type="reset" value="取消"/>
</form>
<c:if test="${not empty requestScope.staffDeleteMsg}">
        <span style="color: red;align-content: center">
                ${requestScope.staffDeleteMsg}
        </span>
</c:if>

<a href="rootHome.jsp">管理后台</a>
</body>
</html>
