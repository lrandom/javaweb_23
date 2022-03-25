package com.niit.java23.controllers.admin.categories;

import com.niit.java23.dals.DalCategory;
import com.niit.java23.models.Categories;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletEdit", value = "/admin-category-edit")
public class ServletEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        DalCategory dalCategory = new DalCategory();
        Categories category = dalCategory.getRow(id);
        request.setAttribute("category", category);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/category/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        DalCategory dalCategory = new DalCategory();
        Categories category = new Categories();
        category.setId(id);
        category.setName(name);
        dalCategory.updateRow(category);
        response.sendRedirect(request.getContextPath() + "/admin-category-list");
    }
}
