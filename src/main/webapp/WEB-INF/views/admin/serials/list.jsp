<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Serial list</title>
    <%-- Elementy dotyczące treści strony --%>
    <%-- Elementy dotyczące wyświetlania --%>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>
    <%-- Linki do szablonów css trafią tutaj --%>
    <link rel="stylesheet" href="/webjars/bulma/0.7.5/css/bulma.min.css">
    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="/webjars/font-awesome/5.10.1/js/all.min.js"></script>
</head>

<body class="has-navbar-fixed-top">
<jsp:include page="/WEB-INF/views/admin/header.jsp"/>

<section class="hero is-bold is-medium">
    <section class="section">
        <div class="container">
            <div class="columns is-mobile is-multiline is-centered">
                <div class="column is-narrow">
                    <table class="table">
                        <tr>
                            <th>Lp:</th>
                            <th>Title</th>
                            <th>Type:</th>
                            <th>Creator:</th>
                            <th>Description:</th>
                        </tr>
                        <c:forEach items="${serials}" var="serial" varStatus="stat">
                            <tr>
                                <td>${stat.count}</td>
                                <td>${serial.title}</td>
                                <td>${serial.type}</td>
                                <td>${serial.creator}</td>
                                <td>
                                    <div class="buttons are-small">
                                        <a class="button is-rounded"
                                           href="<c:url value='/admin/serials/description/${serial.id}'/>">
                                            <strong>Details</strong>
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <div class="buttons are-small">
                                        <a class="button is-primary"
                                           href="<c:url value='/admin/serials/edit/${serial.id}'/>">
                                            <strong>Edit</strong>
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <div class="buttons are-small">
                                        <a class="button is-link"
                                           href="<c:url value='/admin/serials/delete/${serial.id}'/>">
                                            <strong>Delete</strong>
                                        </a>
                                    </div>
                                </td>
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