<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>Show Your Top10</title>

    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>

    <%-- Linki do szablonów css trafią tutaj --%>
    <link rel="stylesheet" href="/webjars/bulma/0.7.5/css/bulma.min.css">

    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="/webjars/font-awesome/5.10.1/js/all.min.js"></script>
</head>
<body class="has-navbar-fixed-top">
<jsp:include page="header.jsp"/>

<section class="hero is-bold is-medium">
    <div class="container">
        <div class="hero-body">
            <h1 class="title">
                INDEX BEZ ZALOGOWANIA
            </h1>
            <h2 class="subtitle">
                Witaj w projekcie <strong>Spring Transitions</strong>.
                <br/>Znajdziesz tutaj mnóstwo przykładów w jaki sposób mogą być wdrażane kolejne
                rozwinięcia aplikacji opartej na
                frameworku Spring i Spring Boot
            </h2>

        </div>
    </div>
</section>

<jsp:include page="footer.jsp"/>
</body>
</html>