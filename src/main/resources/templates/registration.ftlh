<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div class="container">
        <div class="mb-1">Регистрация</div>
        ${message!}
        <@l.login "/registration" true/>
    </div>
</@c.page>