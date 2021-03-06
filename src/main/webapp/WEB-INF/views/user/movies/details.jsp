<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Movie list</title>
    <%-- Elementy dotyczące treści strony --%>
    <%-- Elementy dotyczące wyświetlania --%>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>
    <%-- Linki do szablonów css trafią tutaj --%>
    <link rel="stylesheet" href="/webjars/bulma/0.7.5/css/bulma.min.css">
    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="/webjars/font-awesome/5.10.1/js/all.min.js"></script>
</head>

<body class="has-navbar-fixed-top">
<jsp:include page="/WEB-INF/views/user/header.jsp"/>

<section class="hero is-bold is-medium">
    <section class="section">
        <div class="container">
            <div class="columns is-mobile is-multiline is-centered">
                <div class="column is-narrow">
                    <table class="table">
                        <tr>
                            <th>List place:</th>
                            <th>Title</th>
                            <th>Type:</th>
                            <th>Director:</th>
                            <th>Description:</th>
                        </tr>
                        <c:forEach items="${userMovies}" var="userMovie" varStatus="stat">
                            <tr>
                                <td>${stat.count}</td>
                                <td>${userMovie.title}</td>
                                <td>${userMovie.type}</td>
                                <td>${userMovie.director}</td>
                                <td>${userMovie.description}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </section>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>