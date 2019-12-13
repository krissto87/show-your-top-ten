<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <%--    <style>--%>
    <%--        .hero {--%>
    <%--            background: url( /../webapp/media/images/film.jpg) center / cover;--%>
    <%--        }--%>
    <%--        @media (max-width: 1024px) {.hero {background: url(/../webapp/media/images/film.jpg) center / cover;}}--%>
    <%--    </style>--%>
</head>
<body class="has-navbar-fixed-top">
<jsp:include page="header.jsp"/>

<section class="hero is-bold is-medium">
    <div class="container">
        <div class="hero-body">
            <sec:authorize access="isAnonymous()">
                <h1 class="title">
                    Witaj na stronie <strong>Show your top 10!</strong><br>
                    Zarejestruj się już teraz!
                </h1>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <h1 class="title">
                    Witaj ${pageContext.request.userPrincipal.name} na stronie <strong>Show your top 10!</strong><br>
                    Korzystaj z portalu juz teraz!
                </h1>
            </sec:authorize>
            <h2 class="subtitle">
                <br/> Kochasz dobre kino? Lubisz rankingi i klasyfikacje? ta strona jest dla Ciebie! Marnujesz swój cenny czas w poszukiwaniu jak film czy serial właczyć w piątkowy wieczór?
                Z nami będziesz miał go wiecej podgladąj najlepsze listy innych użytkowników i wybieraj co chcesz
                oglądać!
            </h2>
        </div>
    </div>
</section>

<jsp:include page="footer.jsp"/>
</body>
</html>