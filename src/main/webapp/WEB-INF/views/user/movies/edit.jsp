<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Your Movie List!</title>
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

<section class="section">
    <div class="container">
        <div class="columns">
            <div class="column"></div>
            <div class="column">
                <form:form modelAttribute="movieList" method="post">
                    <form:hidden path="id"/>
                    <div class="field">
                        <label class="label">First place</label>
                        <div class="control">
                            <form:select path="first" items="${movies}" itemLabel="title" itemValue="id"/>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Second place</label>
                        <div class="control">
                            <form:select path="second" items="${movies}" itemLabel="title" itemValue="id"/>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Third place</label>
                        <div class="control">
                            <form:select path="third" items="${movies}" itemLabel="title" itemValue="id"/>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Fourth place</label>
                        <div class="control">
                            <form:select path="fourth" items="${movies}" itemLabel="title" itemValue="id"/>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Fifth place</label>
                        <div class="control">
                            <form:select path="fifth" items="${movies}" itemLabel="title" itemValue="id"/>
                        </div>
                    </div>

                    <div class="field">
                        <label class="label">Sixth place</label>
                        <div class="control">
                            <form:select path="sixth" items="${movies}" itemLabel="title" itemValue="id"/>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Seventh place</label>
                        <div class="control">
                            <form:select path="seventh" items="${movies}" itemLabel="title" itemValue="id"/>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Eighth place</label>
                        <div class="control">
                            <form:select path="eight" items="${movies}" itemLabel="title" itemValue="id"/>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Ninth place</label>
                        <div class="control">
                            <form:select path="ninth" items="${movies}" itemLabel="title" itemValue="id"/>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Tenth place</label>
                        <div class="control">
                            <form:select path="tenth" items="${movies}" itemLabel="title" itemValue="id"/>
                        </div>
                    </div>
                    <div class="field">
                        <div class="control">
                            <form:button class="button is-success is-link" type="submit">Edit list</form:button>
                        </div>
                    </div>
                    <sec:csrfInput/>
                </form:form>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>