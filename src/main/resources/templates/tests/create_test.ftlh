<#import "../parts/common.ftlh" as c>

<@c.page>
    <form method="post">
        <div class="form-group">
            <input class="form-control ${(titleError??)?string('is-invalid', '')}"
                   type="text" value="<#if test??>${test.title}</#if>"
                   name="title" placeholder="Введите Название">
            <#if titleError??>
                <div class="invalid-feedback">
                    ${titleError}
                </div>
            </#if>
        </div>
        <div class="form-group">
            <input class="form-control ${(descriptionError??)?string('is-invalid', '')}"
                   type="text" value="<#if test??>${test.description}</#if>"
                   name="description" placeholder="Введите описание">
            <#if descriptionError??>
                <div class="invalid-feedback">
                    ${descriptionError}
                </div>
            </#if>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit"> Создать </button>
    </form>
</@c.page>