<html>
<head>
    <link href="static/main.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <title>UFO</title>
</head>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<h1>Квест НЛО</h1>
<h2>Пролог</h2>
<p>
    Ты стоишь в космическом порту и готов подняться на борт<br>
    своего корабля. Разве ты не об этом мечтал? Стать капитаном<br>
    галактического судна с экипажем, который будет совершать<br>
    подвиги под твоим командованием.<br>
    Так что вперед!
</p>
<h2>Знакомство с экипажем</h2>
<p>
    Когда ты поднялся на борт корабля, тебя поприветствовала девушка с черной папкой в руках:<br>
    - Здравствуйте, командир! Я Зинаида - ваша помощница. Видите? Там в углу пьет кофе<br>
    наш штурман - сержант Перегарный Шлейф, под штурвалом спит наш бортмеханик - Черный Богдан,<br>
    а фотографирует его Сергей Стальная Пятка - наш навигатор.
    А как обращаться к вам?
</p>
<form action="introduce" method="post">
    <label><input type="text" name="username"/></label>
    <input type="submit" value="Представиться"/>
</form>
</body>
</html>

