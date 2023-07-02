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
    <title>员工信息管理系统后台</title>
</head>
<body>
<h2>员工信息管理系统</h2>
<c:choose>
    <c:when test="${sessionScope.user==null}">
        <a href="${pageContext.request.contextPath}/index.jsp">用户登录</a>
    </c:when>
    <c:otherwise>
        <form method="get" action="<%=request.getContextPath()%>/InfoMatchServlet">
            <label for="name">姓名:</label>
            <input type="text" name="name" id="name"
                   placeholder="请输入要查询的姓名" required/>

            <label for="id">账号:</label>
            <input type="number" name="id" id="id"
                   placeholder="请输入要查询的账号" required/>
                <%--显示错误消息--%>
            <c:if test="${not empty requestScope.matchMsg}">
                <span style="color: red;align-content: center">${matchMsg}</span>
            </c:if>
            <input type="submit" name="搜索"><input type="reset" name="取消">
        </form>
        <hr/>

        <p>10号部门:${requestScope.d10_number}</p>
        <p>11号部门:${requestScope.d11_number}</p>
        <p>12号部门:${requestScope.d12_number}</p>
        <p>13号部门:${requestScope.d13_number}</p>
        <p>14号部门:${requestScope.d14_number}</p>
        <p>15号部门:${requestScope.d15_number}</p>

        <hr/>
        <a href="${pageContext.request.contextPath}/DepShowServlet">部门管理</a><br/>
        <a href="staffManage.jsp">人事管理</a><br/>
        <a href="depManage.jsp">岗位管理</a><br/>
        <a href="userManage.jsp">账号管理</a><br/>
        <a href="${pageContext.request.contextPath}/LogoutServlet">注销</a>
    </c:otherwise>
</c:choose>


</body>
</html>
