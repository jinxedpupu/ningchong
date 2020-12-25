<%@ page import="com.cdvtc.ningchong.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 刘云龙
  Date: 2020/12/19
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <script>
    function logout() {
      var result = confirm("请先登录后再充值余额！");
      if (result) {
        //执行
        window.location.href = 'login_user.jsp';
      }
    }
  </script>
  <body>
 <a href="login_user.jsp">登录</a> --------------
  <%
    User user = (User) session.getAttribute("user");

    if (user != null) {
  %>
  <A href="recharge.jsp">充值</A>
  <%} else { %>
  <A href="#" onclick="logout()">登陆</A>
  <%}%>
  </body>
</html>
