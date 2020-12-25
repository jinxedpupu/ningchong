<%@ page import="com.cdvtc.ningchong.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 刘云龙
  Date: 2020/12/25
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>宁宠狗狗-充值</title>
    <style type="text/css">
        .all {
            width: 250px;
            margin: 0 auto;
            border: 1px #000000 solid;
        }

        .yhxx {
            margin-top: 20px;
            width: 250px;
            margin-left: 20px;
        }
        .shuru{
            margin-left: 20px;
        }

        #useryue {
            margin-top: 20px;
        }

        #btn {
            width: 220px;
            margin-top: 20px;
            margin-bottom: 20px;
            background-color: #00BFFF;
            border: #00BFFF;
        }
    </style>
</head>
<body>
<div class="all">
    <div class="yhxx">
        <%
            User user = (User) session.getAttribute("user");

            if (user != null) {
        %>
        <DIV style="text-align: left"><SPAN>当前用户:<%=user.getUserzhanghao()%></SPAN></DIV>
        <%} else { %>
        <A href="login_user.jsp">登陆</A>
        <%}%>
    </div>
    <div class="shuru">
        <form class="input" action="UserRechargeServlet" method=post>
            充值：
            <input id="useryue" type="text" name="useryue" placeholder="请输入充值金额" pattern="^\+?[1-9][0-9]*$">
            <input id="btn" type=submit name="btn" value="确定充值" onclick="btn()" />
        </form>
    </div>
</div>
</body>
</html>
