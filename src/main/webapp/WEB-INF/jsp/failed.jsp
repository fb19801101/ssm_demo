<%--
  Created by IntelliJ IDEA.
  User: zengsm
  Date: 2017/12/7
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>FAILED</title>
    </head>
    <body>
        <h1>用户失效！</h1><br>
        登录名称：<%=request.getParameter("username")%><br>
        登录密码：<%=request.getParameter("password")%><br>

        <hr>
        <div>
            <h1>查询结果:</h1><br>
            <%--需要建立对应的界面JavaBean，后台传入对象实例--%>
            消息：<input value=${message}><br>
            状态：<input value=${status}><br>
            名字：<input value=${user.username}><br>
            密码：<input value=${user.password}><br>
        </div>
    </body>
</html>