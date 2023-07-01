<%--
  Created by IntelliJ IDEA.
  User: www
  Date: 2023/6/28
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>
<h2>${requestScope.matfhMsg}</h2>
姓名:${requestScope.info.emp_name}<br/>
性别:${requestScope.info.sex}<br/>
出生日期:${requestScope.info.birth_date}<br/>
籍贯:${requestScope.info.native_place}<br/>
学历:${requestScope.info.education}<br/>
毕业学校:${requestScope.info.graduate_school}<br/>
专业:${requestScope.info.major}<br/>
个人邮箱:${requestScope.info.email}<br/>
员工工号:${requestScope.info.emp_id}<br/>
入职日期:${requestScope.info.hire_date}<br/>
<a href="rootHome.jsp">管理后台主页</a>
</body>
</html>
