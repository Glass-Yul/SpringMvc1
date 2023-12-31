package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletInputStream inputStream = req.getInputStream(); // 바이트 코드로 받음
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);// 바이트를 문자로 바꿀 때 인코딩을 정해줘야하 함

        System.out.println("messageBody = " + messageBody);

        resp.getWriter().write("ok");


    }
}
