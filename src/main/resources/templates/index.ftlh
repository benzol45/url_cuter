<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>UrlCuter</title>
</head>
<body>
    <h1>Сервис генерации коротких ссылок</h1>

    <h2>Переход по полученной ссылке: /cut/{имя ссылки}</h2>
    <h4>Для примера добавлены: "g" = goole.com, "y" = yandex.ru, "gm" = gmail.com, "j" = поиск в goole слова "java"</h4>

    <h2>Управление ссылками</h2>
    <a href="/add">Интерфейс управления</a>
    <h4>Так же возможно управление через Rest /api/url, примеры JSON есть в документации</h4>

    <h2>Наиболее популярные переходы за месяц</h2>
    <table border="1">
        <tr>
            <th>cut url</th>
            <th>full url</th>
            <th>Переходов всего</th>
            <th>Переходов уникальных</th>
        </tr>
        <#list statistic as statisticRow>
            <tr>
                <td>${statisticRow.cut_url}</td>
                <td>${statisticRow.full_url}</td>
                <td>${statisticRow.vizitsAll}</td>
                <td>${statisticRow.vizitsUniq}</td>
            </tr>
        </#list>
    </table>
    <h4>Более подбробная статистика с фильтрацией доступна через Rest /api/requestStatistic, примеры JSON есть в документации</h4>
</body>
</html>