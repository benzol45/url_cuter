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
    <h3>New url:</h3>
    <form method="post" action="/url">
        <input type="datetime-local" name="datetime">
        <input type="text" name="full_url">
        <input type="submit" value="Отправить">
    </form>
    <br>

    <#if addedUrlMapper??>
        <h3>Add url:</h3>
        cut url: ${addedUrlMapper.cutUrl}
        full url: ${addedUrlMapper.fullUrl}
        live time: ${addedUrlMapper.liveTimePresentation}
        <br>
    </#if>

    <h3>Active url:</h3>
    <table border="1">
        <tr>
            <th>go to</th>
            <th>cut</th>
            <th>full</th>
            <th>live time</th>
            <th>remove</th>
        </tr>
    <#list urlMappers as urlMapper>
        <tr>
            <td></td>
            <td>${urlMapper.cutUrl}</td>
            <td>${urlMapper.fullUrl}</td>
            <td>${urlMapper.liveTimePresentation}</td>
            <td></td>
        </tr>
    </#list>
    </table>
</body>
</html>