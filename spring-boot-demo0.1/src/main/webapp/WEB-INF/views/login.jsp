<%--
  Created by IntelliJ IDEA.
  User: lixianfeng
  Date: 2018/6/12
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../WEB-INF/views/taglib.jsp" %>

<html>
<head>
    <title>登录</title>
</head>
<body>
  <form action="/doLogin" method="post">
    <input type="text" name="userName" /> <br/>
    <input type="password" name="passWord" />
    <input type="submit" value="登录"><span style="color: red;">${msg}</span>
  </form>
</body>
</html>
