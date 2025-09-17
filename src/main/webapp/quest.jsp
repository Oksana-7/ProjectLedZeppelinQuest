<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UFO</title>
</head>
<body>
<h2>${question}</h2>
<form method="post" action="step">
    <button type="submit" name="answer" value="1">${answer1}</button>
    <button type="submit" name="answer" value="0">${answer2}</button>
</form>
<hr>
Статистика:<br>
Шаг квеста: ${stepIndex + 1}<br>
Имя пользователя: ${username}<br>
IP address: ${ip}<br>
</body>
</html>
