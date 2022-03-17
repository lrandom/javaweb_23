package com.niit.java23;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletChangeLanguage", value = "/ServletChangeLanguage")
public class ServletChangeLanguage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/change_language.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String localName = request.getParameter("locale-name");
        HttpSession session = request.getSession();
        session.setAttribute("locale", localName);
        response.sendRedirect("/java23-1.0-SNAPSHOT/ServletChangeLanguage");
    }
}
