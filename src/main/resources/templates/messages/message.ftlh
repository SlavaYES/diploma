<#import "../parts/common.ftlh" as c>

<@c.page>
    <div class="container mr-5">
        <div class="form-row ">
            <form class="form-inline" action="messages/message" method="get">
                <input  class="form-control" type="text" name="filter" value="${filter!}" placeholder="Поиск по Тегу">
                <button class="btn btn-primary ml-2" type="submit">Поиск</button>
            </form>
        </div>

        <a class="btn btn-primary" data-bs-toggle="collapse"
           href="#collapseExample" role="button"
           aria-expanded="false" aria-controls="collapseExample">
            Написать
        </a>

        <div class="collapse <#if message??>show</#if>" id="collapseExample">
            <div class="form-group mt-3">
                <form method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <input class="form-control ${(textError??)?string('is-invalid', '')}"
                               type="text" value="<#if message??>${message.text}</#if>"
                               name="text" placeholder="Введите сообщение">
                        <#if textError??>
                        <div class="invalid-feedback">
                            ${textError}
                        </div>
                        </#if>
                    </div>
                    <div class="form-group">
                        <input class="form-control ${(tagError??)?string('is-invalid', '')}"
                               type="text" value="<#if message??>${message.tag}</#if>"
                               name="tag" placeholder="Tag">
                        <#if tagError??>
                            <div class="invalid-feedback">
                                ${tagError}
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
        </div>

        <h1>Hello, Messages</h1>
        <div class="">
            <#list messages! as message>
                <div class="card my-3" style="width: 30rem;">
                    <#if message.filename??>
                        <img class="card-img-top" src="/img/${message.filename}">
                    </#if>
                    <div class="m-2">
                        <span>${message.text}</span>
                        <i>${message.tag}</i>
                    </div>
                    <div class="card-footer text-muted">
                        ${message.authorName}
                    </div>
                </div>
            <#else>
                Нет сообщений
            </#list>
        </div>
    </div>
</@c.page>