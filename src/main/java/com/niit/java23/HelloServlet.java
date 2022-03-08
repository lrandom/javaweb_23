package com.niit.java23;

import java.io.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hi World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hi</h1><p>My name is Luan</p>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}