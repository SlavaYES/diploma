<#import "../parts/common.ftlh" as c>
<#import "../parts/list_group.ftlh" as t>
<@c.page>
    <div class="container">
        <@t.bar "/tests/create_question" questions true/>
        <div class="col-3">
<#--            <#if test??>-->
                <a href="/tests/create_question/${test.id}">Нажмите, чтобы добвалять вопросы</a>
<#--            </#if>-->
        </div>
    </div>
</@c.page>