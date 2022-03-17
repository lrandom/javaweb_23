package com.niit.java23.controllers.admin;

import com.niit.java23.dals.DalCategory;
import com.niit.java23.models.Categories;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletList", value = "/admin-category-list")
public class ServletList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DalCategory dalCategory = new DalCategory();
        ArrayList<Categories> list = dalCategory.getRows();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/category/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
