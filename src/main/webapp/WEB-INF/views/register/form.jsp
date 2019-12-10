<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Rejestracja użytkownika</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%-- Linki do szablonów css trafią tutaj --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">

    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>
<h1 class="title">Zarejestruj się</h1>
<h2 class="subtitle">Podaj swoje dane:</h2>
<form:form modelAttribute="registrationData" method="post">
    <div class="field">
        <label class="label">Login</label>
        <div class="control has-icons-left has-icons-right">
            <form:input class="input is-success" placeholder="login (min 3, max 12 znaków)"
                        path="username" required="true" type="text"/>
            <form:errors path="username"/>
            <span class="icon is-small is-left">
      <i class="fas fa-user"></i>
    </span>
            <span class="icon is-small is-right">
      <i class="fas fa-check"></i>
    </span>
        </div>
        <p class="help is-success">This username is available</p>
    </div>

    <div class="field">
        <label class="label">Email</label>
        <div class="control has-icons-left has-icons-right">
            <form:input class="input is-danger" type="email" placeholder="example@example.com"
                        path="email" required="true"/>
            <form:errors path="email"/>
            <span class="icon is-small is-left">
      <i class="fas fa-envelope"></i>
    </span>
            <span class="icon is-small is-right">
      <i class="fas fa-exclamation-triangle"></i>
    </span>
        </div>
        <p class="help is-danger">This email is invalid</p>
    </div>

    <div class="field">
        <label class="label">Hasło</label>
        <p class="control has-icons-left">
            <form:input class="input" path="password" required="true" type="password"
                        placeholder="(min 4 a max 12 znaków)"/>
            <form:errors path="password"/>
            <span class="icon is-small is-left">
            <i class="fas fa-lock"></i>
            </span>
        </p>
    </div>

    <div class="field">
        <label class="label">Powtórz hasło</label>
        <p class="control has-icons-left">
            <form:input class="input" path="rePassword" required="true" type="password"
                        placeholder="(min 4 a max 12 znaków)"/>
            <form:errors path="rePassword"/>
            <span class="icon is-small is-left">
            <i class="fas fa-lock"></i>
            </span>
        </p>
    </div>

    <div class="field">
        <div class="control">
            <label class="checkbox">
                <form:checkbox path="termsAcceptance" required="true"
                               placeholder="Musisz zaakceptować aby zakończyć rejestracje"/>
                <form:errors path="termsAcceptance"/>
                Akceptuje <a href="#">warunki i zasady rejestracji</a>
            </label>
        </div>
    </div>

    <div class="field is-grouped">
        <div class="control">
            <button class="button is-link">Zarejestruj się</button>
        </div>
        <div class="control">
            <button class="button is-link is-light">Anuluj</button>
        </div>
    </div>
</form:form>
</body>
</html>