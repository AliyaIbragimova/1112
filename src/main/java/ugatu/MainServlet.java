package ugatu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    /**
     * Основной метод класса HttpServlet, вызывается сервером для обработки GET запросов.
     *
     * @param req q{@link HttpServletRequest} объект, хранящий запрос,
     *                  сделанный клиентом к сервлету
     *
     * @param resp {@link HttpServletResponse} объект, хранящий ответ,
     *                  который сервлет отправляет на клиент
     *
     * @exception IOException вызывается, если обнаружена ошибка
     *                              ввода-вывода при обработке GET запроса
     *
     * @exception ServletException вызывается, если GET запрос
     *                                  не может быть обработан
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req,resp); //Для пустого метода, передаем запрос дальше к классу родителю
    }

    /**
     * Основной метод класса HttpServlet, вызывается сервером для обработки POST запросов.
     *
     * @param req q{@link HttpServletRequest} объект, хранящий запрос,
     *                  сделанный клиентом к сервлету
     *
     * @param resp {@link HttpServletResponse} объект, хранящий ответ,
     *                  который сервлет отправляет на клиент
     *
     * @exception IOException вызывается, если обнаружена ошибка
     *                              ввода-вывода при обработке POST запроса
     *
     * @exception ServletException вызывается, если POST запрос
     *                                  не может быть обработан
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Получение значения, переданного с клиента, в виде строки
        String select = req.getParameter("select");
        String star = req.getParameter("star");
        String pit = req.getParameter("pit");
        String vzrosl= req.getParameter("vzrosl");
        String det= req.getParameter("det");
        String day = req.getParameter("day");
        try {
            /*
            Переводим строки со значением в числа с плавающей точкой
            Если операция прошла успешно, то выполняем программу далее до окончания блока try{}
            Если в строке не было числел (например были буквы или было пусто), то произойдет ошибка
            и сразу же начнет выполняться блок catch{}
             */
            float vzrl = Float.parseFloat(vzrosl);
            float deti = Float.parseFloat(det);
            float strana = Float.parseFloat(select);
            float stars = Float.parseFloat(star);
            float pitanie = Float.parseFloat(pit);
            float otdih = Float.parseFloat(day);
            float answer;

            //расчет стоимости тура
            answer = ((strana + pitanie) * stars * (vzrl + (deti / 2))) * otdih;

            /*
            Записываем в виде атрибута полученный результат
            атрибут имеет вид <ключ> <значение>
             */
            req.setAttribute("answer", "Стоимость - " + String.format("%.2f", answer) + " Руб.");

        } catch (NumberFormatException exception) {
            /*
            Если произошла ошибка при переводе в численный тип,
            то в атрибут пишем сообщение с ошибкой
             */
            req.setAttribute("answer", "- Нужно указывать только цифры. Попробуйте снова.");
        }

        /*
        Перенаправляем наш запрос на вторую страницу,
        где и будем выводить наш ответ
         */
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }
}
