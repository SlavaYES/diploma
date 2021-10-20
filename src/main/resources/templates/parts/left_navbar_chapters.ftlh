<#macro leftbar tests>
    <div class="list-group list-group-flush">
        <div class="container col-6">
            <a href="#item-1-1" class="list-group-item list-group-item-action">Введение</a>
            <a href="#item-1-2" class="list-group-item list-group-item-action">Машина Тьюринга</a>
            <a href="#item-1-3" class="list-group-item list-group-item-action">Математическая модель машины</a>
            <a href="#item-1-4" class="list-group-item list-group-item-action">Примеры задач</a>
            <a href="#item-1-5" class="list-group-item list-group-item-action">Проходы</a>
            <a href="#item-1-6" class="list-group-item list-group-item-action">Итоги</a>
            <#if tests??>
                <a href="#" class="list-group-item list-group-item-action disabled">Тесты</a>
            </#if>
            <#list tests! as test>
                <a href="../tests/${test.namepage}" class="list-group-item list-group-item-action">${test.title}</a>
            </#list>
        </div>
        <div class="" style="z-index: 1030"></div>
    </div>
</#macro>