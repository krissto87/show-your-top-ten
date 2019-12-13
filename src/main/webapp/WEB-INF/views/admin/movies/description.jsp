<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>Description movie ${movie.id}</title>

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
                <div class="columns is-mobile">
                    <div class="column is-half is-offset-one-quarter">
                        <table class="table">
                            <tr>
                                <th>Title:</th>
                                <th>Description:</th>
                            </tr>
                            <tr>
                                <td>${movie.title}</td>
                                <td>${movie.description}</td>
                            </tr>
                        </table>
                    </div>
                </div>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
    </section>

    <sec:csrfInput/>
</section>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>