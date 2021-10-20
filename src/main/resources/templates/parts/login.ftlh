<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Имя : </label>
            <div class="col-sm-4">
                <input class="form-control ${(usernameError??)?string('is-invalid', '')}"
                       type="text" name="username"
                       value = "<#if user??>${user.username}</#if>" placeholder="Введите Имя"/>
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Пароль: </label>
            <div class="col-sm-4">
                <input class="form-control ${(passwordError??)?string('is-invalid', '')}"
                       type="password" name="password" placeholder="Введите пароль"/>
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>
        <#if isRegisterForm>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label"> Пароль: </label>
                <div class="col-sm-4">
                    <input class="form-control ${(password2Error??)?string('is-invalid', '')}"
                           type="password" name="password2" placeholder="Повторите пароль"/>
                    <#if password2Error??>
                        <div class="invalid-feedback">
                            ${password2Error}
                        </div>
                    </#if>
                </div>
            </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Почта: </label>
            <div class="col-sm-4">
                <input class="form-control ${(emailError??)?string('is-invalid', '')}"
                       type="email" name="email"
                       value = "<#if user??>${user.email}</#if>" placeholder="name@mail.com"/>
                <#if emailError??>
                    <div class="invalid-feedback">
                        ${emailError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="g-recaptcha" data-sitekey="6LcRiaYaAAAAAPcXYPPrMNMYQoyJ9kUAthigpZrV"></div>
            <#if captchaError??>
                <div class="alert alert-danger" role="alert">
                    ${captchaError}
                </div>
            </#if>
        </div>
        </#if>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-success" type="submit"><#if isRegisterForm>Зарегистрироваться<#else>Войти</#if></button>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <button class="btn btn-success" type="submit" >Выйти</button>
    </form>
</#macro>
