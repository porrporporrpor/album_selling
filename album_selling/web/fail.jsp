<%-- 
    Document   : fail
    Created on : Apr 22, 2018, 3:19:59 PM
    Author     : porx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= request.getAttribute("message") %></h1>
    </body>
</html>
