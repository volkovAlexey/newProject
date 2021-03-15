package com.hillel.task26;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String param1 = req.getParameter("a");
        String param2 = req.getParameter("b");
        String param3 = req.getParameter("c");

        resp.getWriter().println("<body><ol>" +
                "<li> a : " + param1 + "</li>" +
                "<li> b : " + param2 + "</li>" +
                "<li> c : " + param3 + "</li>" +
                "</ol></body>");
    }
}
