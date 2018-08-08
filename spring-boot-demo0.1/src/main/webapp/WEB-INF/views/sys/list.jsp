<%--
  Created by IntelliJ IDEA.
  User: lixianfeng
  Date: 2018/6/12
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/taglib.jsp" %>
<html>
<head>
    <title></title>
</head>
<body>
  <table>
    <c:forEach items="${sysUsers}" var="user">
      <tr>
        <td>用户名</td>
        <td>${user.username}</td>
        <td>ID</td>
        <td>${user.id}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
