<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>FreeMarker</title>
    <style type="text/css">
        table.gridtable {
            font-family: verdana,arial,sans-serif;
            font-size:11px;
            color:#333333;
            border-width: 1px;
            border-color: #666666;
            border-collapse: collapse;
        }
        table.gridtable th {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #666666;
            background-color: #dedede;
        }
        table.gridtable td {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #666666;
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<table class="gridtable">
    <tr>
        <th>Info Header 1</th><th>Info Header 2</th><th>Info Header 3</th>
    </tr>
    <tr>
        <td>Text 1A</td><td>Text 1B</td><td>Text 1C</td>
    </tr>
    <tr>
        <td>Text 2A</td><td>Text 2B</td><td>Text 2C</td>
    </tr>
</table>
<h1>hello world</h1>
<h1 style="color: red">${msg!""}</h1>
</body>
</html>