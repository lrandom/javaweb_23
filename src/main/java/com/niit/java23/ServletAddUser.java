package com.niit.java23;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class ServletAddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String salary = request.getParameter("salary");


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager. getConnection("jdbc:mysql://127.0.0.1:3306/javaweb_23?autoReconnect=true&useSSL=false", "root", "koodinh@");
            PreparedStatement prp = connection.prepareStatement("insert into users(email,pwd,salary) values(?,?,?)");
            prp.setString(1, email);
            prp.setString(2, password);
            prp.setString(3, salary);
            prp.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
