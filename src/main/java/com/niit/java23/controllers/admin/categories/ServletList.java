package com.niit.java23.controllers.admin.categories;

import com.niit.java23.dals.DB;
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
        if (request.getParameter("action") != null && request.getParameter("action").equals("DELETE")) {
            long id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
            if (id != 0) {
                Categories category = new Categories();
                category.setId(id);
                dalCategory.deleteRow(category);
            }
        }

        int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
        int totalRows = dalCategory.getTotalRows();
        double totalPages = Math.ceil(totalRows / dalCategory.getPageSize());

        ArrayList<Categories> list = dalCategory.getRows(page);
        request.setAttribute("list", list);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/category/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
