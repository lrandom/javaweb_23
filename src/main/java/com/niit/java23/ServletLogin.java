package com.niit.java23;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "ServletLogin", value = "/do-login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password"); //plain text


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javaweb_23?autoReconnect=true&useSSL=false", "root", "koodinh@");
            PreparedStatement prp = connection.prepareStatement("SELECT * FROM users WHERE email=? AND pwd=?");
            prp.setString(1, email);
            prp.setString(2, Helper.generateMD5(password));
            ResultSet rs = prp.executeQuery();
            if (rs.next()) {
                //đăng nhập thành công
                response.setContentType("text/html");
                response.getWriter().write("Login success");
            } else {
                //đăng nhập thất bại
                response.setContentType("text/html");
                response.getWriter().write("Login failed");
            }
        } catch (Exception e) {

        }

    }
}
