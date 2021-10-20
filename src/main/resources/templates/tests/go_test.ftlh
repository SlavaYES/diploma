<#import "../parts/common.ftlh" as c>
<@c.page>
    <div>${test.title}</div>
    <#list questions! as question>
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
    </#list>
</@c.page>