<%--
  Created by IntelliJ IDEA.
  User: lixianfeng
  Date: 2018/6/11
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/taglib.jsp" %>
<html>
<head>
    <title></title>
</head>
<body>
    hello,欢迎[${name}]进入spring boot jsp
    <c:if test="${redis.key != null}">
        hello,欢迎进入redis学习 , 当前缓存值:${redis.key}
    </c:if>
    <c:if test="${redis}">
        欢迎引入redis学习
    </c:if>
    <br/><a href="/sys/user/list">用户信息</a>
    <br/><a href="/exception/index">异常练习</a>
    <br/><a href="/ftl/index">Freemarker知识练习</a>
    <br/><a href="/html/index">Thymeleaf知识练习</a>
    <br/><a href="/resource/get">配置资源文件</a>
</body>
</html>
