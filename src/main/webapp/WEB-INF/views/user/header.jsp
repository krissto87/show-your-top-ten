<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nagłówek</title>
</head>
<body>
<header>
    <nav class="navbar is-fixed-top" role="navigation" aria-label="main navigation">
        <div class="container">
            <div class="navbar-menu">
                <div class="navbar-start">
                    <a class="navbar-item" href="/">
                        <strong>Home</strong>
                    </a>
                    <a class="navbar-item" href="/user">
                        <strong>Main menu</strong>
                    </a>
                    <%-- Tutaj pozostałe linki, które chcemy mieć widoczne --%>
                </div>

                <div class="navbar=end">
                    <div class="navbar-item">
                        <div class="buttons">
                            <sec:authorize access="isAuthenticated()">
                                <a class="button is-primary" href="/user">
                                    <strong>${pageContext.request.userPrincipal.name} account</strong>
                                </a>
                                <form method="post" action="/logout">
                                    <button class="button is-link" type="submit"><strong>Logout</strong></button>
                                    <sec:csrfInput/>
                                </form>
                            </sec:authorize>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>
</body>
</html>