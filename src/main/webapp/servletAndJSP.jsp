<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>"JSP"</title>
</head>
<body>

    <form action= "/ServletAndJSP" method="get">
        <input id= "richest" name= "richest" placeholder="richest user" readonly>
        <button type="button" onclick="document.getElementById('richest').value='${nameUser}'; return false;" >get</button><br>


        <p><input id= "sum" name= "sum" placeholder="accounts sum" readonly>
        <button type="button" onclick="document.getElementById('sum').value='${account}'; return false;" >get</button>

    </form>

    <p><a href= "/dataAllUsers" >Click here for a displaying data of all users</a>
</body>
</html>