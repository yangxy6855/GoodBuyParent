<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <#assign basePath="http://localhost:8081/abc" name="王二麻子" age="12"/>
</head>
<body>
    <h1>主标题：${title?default("主标题加载中...")}</h1>
    <h1>副标题：${subTitle?default("副标题加载中...")}</h1>
    <h1>价格：${price?string("0.00")}￥</h1>

    <hr>
    <#list  imgUrlList as temp>
        <h3><img src="${temp}"></h3>
    </#list>

    <hr>
    <#if flag>
        flag值为true
    </#if>

    <hr>
    <a href="${basePath}">xxx快来点我吧</a>
    <h3>${name}-${age}</h3>
</body>
</html>