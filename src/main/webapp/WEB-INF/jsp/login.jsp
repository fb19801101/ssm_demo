<%--
  Created by IntelliJ IDEA.
  User: zengsm
  Date: 2017/12/6
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>SSM-LOGIN</title>
    </head>
    <body>
        <div>
            <form action="login/login" method="post">
                用户名称 : <input type="text" name="username"/><br/>
                用户密码 : <input type="password" name="password"/><br/>
                <input type="submit" value="Login"/>
                <input type="reset" value="Reset"/>
            </form>
        </div>

        <hr>
        <%
            String path = request.getContextPath();//获取application的名称
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        %>
        <%out.println("application name: " + path);%><br>
        <%out.println("application path: " + basePath);%>
    </body>
</html>
