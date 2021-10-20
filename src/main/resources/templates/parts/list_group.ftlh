<#macro bar path varibles isQuestions>
    <div class="list-group">
    <#list varibles! as varible>
        <a href="${varible.id}" class="list-group-item list-group-item-action">
            <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1">${varible.title}</h5>
                <small class="text-muted">3 days ago</small>
            </div>
            <p class="mb-1">
                <#if isQuestions>
                    ${varible.answer}
                <#else>
                    ${varible.description}
                </#if>
            </p>
        </a>
    <#else>
        <#if isQuestions>
        <#else>
            <div>
                <a href="${path}" class="list-group-item list-group-item-action">
                    <div class="d-flex w-100 justify-content-between">
                        <h5 class="mb-1">Пусто</h5>
                        <small class="text-muted">3 days ago</small>
                    </div>
                    <p class="mb-1">Нажмите чтобы создать</p>
                </a>
            </div>
        </#if>
    </#list>
</div>
</#macro>