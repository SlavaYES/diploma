<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav class="container-fluid navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Логотип</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Главая</a>
            </li>
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/messages/message">Мессенджер</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/themes/main_themes">Темы</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/tests/main_tests">Тесты</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/accounts/profile">Аккаунт</a>
                </li>
                <#if isAdmin>
                    <li class="nav-item">
                        <a class="nav-link" href="/accounts/users">Пользователи</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/themes/create_theme">Создать Тему</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/tests/create_test">Создать Тест</a>
                    </li>
                </#if>
            </#if>
        </ul>
        <#if user??>
            <div class="navbar-text mr-3">${name}</div>
        <@l.logout />
        <#else>
            <div>
                <a class="btn btn-outline-success" href="/login">Войти</a>
                <a class="btn btn-success" href="/registration">Зарегистрироваться</a>
            </div>
        </#if>
    </div>
</nav>