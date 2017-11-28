
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
    <body>
        <!-- Форма, содержащая в себе кнопку, 3 техтовых поля, список, 8 радиокнопок(radiobutton).
             По нажатию на кнопку отправит POST запрос на сервлет-->
        <form action="servlet" method="POST">
            <div>
                <h1> Калькулятор расчета стоимости тура</h1>
            </div>
            <h2> Выберите страну </h2>
            <p>
            <select type="text" name = "select" value="" placeholder="Введите страну">
                <option value = "2000" selected>Страна А</option>
                <option value = "3000">Страна В</option>
                <option value = "3500">Страна С</option>
            </select>
            </p>
            <h2> Выберите количество звезд отеля </h2>
            <p>
            <input type="radio" checked="checked" name="star" value="1" >3*
            <input type="radio" name="star" value="1.5">4*
            <input type="radio" name="star" value="2.5">5*
            </p>
            <h2> Введите количество выходных дней</h2>
            <p><input type="text" name="day" value="" placeholder="Введите количество"></p>
            <h2> Выберите количество пасажиров</h2>
            <h3> Введите количество взрослых</h3>
            <p><input type="text" name="vzrosl" value="" placeholder="Введите количество"></p>
            <h3> Введите количество детей</h3>
            <p><input type="text" name="det" value="" placeholder="Введите количество"></p>
            <h2> Выберите тип питания </h2>
            <p>
            <input type="radio" checked="checked" name="pit" value="0"> нет
            <input type="radio" name="pit" value="400">завтрак
            <input type="radio" name="pit" value="700">завтрак+ужин
            <input type="radio" name="pit" value="1200">завтрак+обед+ужин
            <input type="radio" name="pit" value="1700">все включено
            </p>
            <input type="submit" value="РЕШИТЬ" />
        </form>
    </body>
</html>


