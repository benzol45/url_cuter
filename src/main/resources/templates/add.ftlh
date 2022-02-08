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
    <h1><a href="/"><--</a></h1>
    <h2>Add new url:</h2>
    <h3>
    <form method="post" action="/url">
        <label>Target URL
            <input type="text" name="full_url">
        </label>
        <br>
        <br>
        <label>Live time
            <input type="datetime-local" name="datetime">
        </label>
        <br>
        <br>
        <input type="submit" value="Create">
    </form>
    </h3>
    <br>

    <#if addedUrlMapper??>
        <h2>Add url:</h2>
        <h3>
        cut url: ${addedUrlMapper.cutUrl}<br>
        go: <a href="/cut/${addedUrlMapper.cutUrl}">/cut/${addedUrlMapper.cutUrl}</a><br>
        full url: ${addedUrlMapper.fullUrl}<br>
        live time: ${addedUrlMapper.liveTimePresentation}<br>
        </h3>
        <br>
    </#if>

    <h2>Active url:</h2>
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
            <td><a href="/cut/${urlMapper.cutUrl}">/cut/${urlMapper.cutUrl}</a></td>
            <td>${urlMapper.cutUrl}</td>
            <td>${urlMapper.fullUrl}</td>
            <td>${urlMapper.liveTimePresentation}</td>
            <td><a href="/url/delete/${urlMapper.cutUrl}">X</a></td>
        </tr>
    </#list>
    </table>
</body>
</html>