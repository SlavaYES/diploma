<#import "../parts/common.ftlh" as c>

<@c.page>
    <h5>${username}</h5>
    ${message!}
    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Пароль: </label>
            <div class="col-sm-4">
                <input class="form-control" type="password" name="password" placeholder="Введите пароль"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Почта: </label>
            <div class="col-sm-4">
                <input class="form-control" type="email"
                       name="email" placeholder="name@mail.com" value="${email!''}"/>
            </div>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit">Изменить</button>
    </form>
</@c.page>