<#import "../parts/common.ftlh" as c>

<@c.page>
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <input type="text" name="test" value="${test}" style="visibility: hidden"/>
            <div class="form-group">
                <input class="form-control ${(questionError??)?string('is-invalid', '')}"
                       type="text" value="<#if question??>${question.title}</#if>"
                       name="title" placeholder="Введите вопрос">
                <#if questionError??>
                    <div class="invalid-feedback">
                        ${questionError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input class="form-control ${(answerError??)?string('is-invalid', '')}"
                       type="text" value="<#if question??>${question.answer}</#if>"
                       name="answer" placeholder="Введите правильный ответ">
                <#if answerError??>
                    <div class="invalid-feedback">
                        ${answerError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input id="customFile" type="file" name="file">
                    <label class="custom-file-label" for="customFile">Выберите файл</label>
                </div>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="form-group">
                <button class="btn btn-primary" type="submit">Отправить</button>
            </div>
        </form>
    </div>

    <#list questions! as question>
        <div class="card my-3" style="width: 30rem;">
            <#if question.filename??>
                <img class="card-img-top" src="/img/${question.filename}"/>
            </#if>
            <div class="m-2">
                <span>${question.title}</span>
            </div>
            <div class="card-footer text-muted">
                ${question.answer}
            </div>
        </div>
    <#else>
        Нет вопросов
    </#list>
</@c.page>