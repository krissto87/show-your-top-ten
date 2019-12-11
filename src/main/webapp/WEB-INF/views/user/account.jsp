<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>Twoje konto</title>

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
                <div class="column is-one-quarter">
                    <aside class="menu">
                        <p class="menu-label">
                           <code> General:</code>
                        </p>
                        <ul class="menu-list">
                            <li><a href="#">Edit account</a></li>
                            <li><a href="#">Change password</a></li>
                        </ul>
                        <p class="menu-label">
                            <code>Your top10 movies:</code>
                        </p>
                        <ul class="menu-list">
                            <li><a href="#">Add</a></li>
                            <li><a href="#">Details</a></li>
                            <li><a href="#">Edit list</a></li>
                            <li><a href="#">Delete list</a></li>
                        </ul>
                        <p class="menu-label">
                            <code>Your top10 serials:</code>
                        </p>
                        <ul class="menu-list">
                            <li><a href="#">Add</a></li>
                            <li><a href="#">Details</a></li>
                            <li><a href="#" >Edit list</a></li>
                            <li><a href="#" >Delete list</a></li>
                        </ul>
                    </aside>
                </div>

                <div class="column is-narrow">
                    <p class="bd-notification is-primary">
                        <code class="html">Best movies list:</code><br>
                    <table class="table">
                        <tr>
                            <th>Rank:</th>
                            <th>Rating:</th>
                            <th>User:</th>
                            <th>Details:</th>
                        </tr>
                        <tr>
                            <td></td>
                        </tr>
                    </table>
                    </p>
                </div>
                <div class="column is-narrow">
                    <p class="bd-notification is-primary">
                        <code class="html">Best serial list:</code><br>
                    <table class="table">
                        <tr>
                            <th>Rank:</th>
                            <th>Rating:</th>
                            <th>User:</th>
                            <th>Details:</th>
                        </tr>
                        <tr>
                            <td></td>
                        </tr>
                    </table>
                    </p>
                </div>
            </div>
        </div>
    </section>

    <sec:csrfInput/>
</section>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>