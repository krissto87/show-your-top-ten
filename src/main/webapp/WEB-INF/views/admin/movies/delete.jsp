<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete movie ${id}</title>
</head>
<body>
<form method="get" action="/admin/movies/all">
    <input type="submit" value="cancel"/>
</form>

<form method="post">
    <input type="hidden" name="id" value="${id}"/>
    <input type="submit" value="delete"/>
    <sec:csrfInput/>
</form>
</body>
</html>