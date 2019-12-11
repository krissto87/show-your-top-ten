<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit serial</title>
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

<section class="section">
    <div class="container">
        <div class="columns">
            <div class="column"></div>
            <div class="column">
                <form:form modelAttribute="serial" method="post">
                    <form:hidden path="id"/>
                    <div class="field">
                        <label class="label">Title</label>
                        <div class="control">
                            <form:input path="title" required="true"/><form:errors path="title"/>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Type</label>
                        <div class="control">
                            <div class="select">
                                <form:select path="type" items="${types}"/>
                            </div>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Description</label>
                        <div class="control">
                            <form:textarea path="description" rows="6" cols="80"/><form:errors path="description"/>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Creator</label>
                        <div class="control">
                            <form:input path="creator" required="true"/><form:errors path="creator"/>
                        </div>
                    </div>
                    <div class="field">
                        <div class="control">
                            <form:button class="button is-success is-link" type="submit">Edit confirm</form:button>
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