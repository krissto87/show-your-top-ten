<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>Twoje konto</title>

    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>
    <%-- Linki do szablonów css trafią tutaj --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">

    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body class="has-navbar-fixed-top">
<jsp:include page="/WEB-INF/views/header.jsp"/>
<section class="hero is-bold is-medium">
    <div class="container">
        <div class="hero-body">
            <h1 class="title">
                Spring Transitions
            </h1>
            <h2 class="subtitle">
                STRONA UŻYTKOWNIKA PO ZALOGOWANIU <strong>Spring Transitions</strong>.
                <br/>Znajdziesz tutaj mnóstwo przykładów w jaki sposób mogą być wdrażane kolejne
                rozwinięcia aplikacji opartej na
                frameworku Spring i Spring Boot
            </h2>

        </div>
    </div>
    <sec:csrfInput/>
</section>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>