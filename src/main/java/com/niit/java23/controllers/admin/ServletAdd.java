package com.niit.java23.controllers.admin;

import com.niit.java23.dals.DalCategory;
import com.niit.java23.models.Categories;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletAdd", value = "/admin-category-add")
public class ServletAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/admin/category/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println(name);
        DalCategory dalCategory = new DalCategory();
        Categories categories = new Categories();
        categories.setName(name);
        dalCategory.addRow(categories);
        response.sendRedirect(request.getContextPath() + "/admin-category-list");
    }
}
