package com.niit.java23.controllers.admin.product;

import com.niit.java23.dals.DalCategory;
import com.niit.java23.models.Categories;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletProductAdd", value = "/admin-product-add")
public class ServletProductAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DalCategory dalCategory = new DalCategory();
        dalCategory.setSize(100);
        ArrayList<Categories> categories = dalCategory.getRows(1);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/product/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
