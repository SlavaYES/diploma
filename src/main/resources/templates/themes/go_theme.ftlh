<#import "../parts/common.ftlh" as c>

<@c.page>
    <#if theme??>
        <div>
            ${theme.title}
        </div>
        <div>
            ${theme.description}
        </div>
    </#if>
</@c.page>