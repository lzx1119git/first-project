<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
成功
    <#if username!="">
        你的名字是${username}<br/>
        你的密码是${password}<br/>
    </#if>
    <#if username=="">
        <#list list as ll>
        账号是${ll.username}
        </#list>
    </#if>


</body>
</html>