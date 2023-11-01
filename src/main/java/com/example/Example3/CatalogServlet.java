package com.example.Example3;

import com.example.Example2.Catalog;
import com.example.Example2.CatalogItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "catalogServlet3", value = "/catalogServlet3")
public class CatalogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append(req.getParameter("name"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Catalog.addItem(new CatalogItem(
                req.getParameter("name"),
                req.getParameter("manufacturer"),
                req.getParameter("sku")
        ));

        resp.setHeader("SomeHeader", "SomeHeaderValueExample");
        resp.addCookie(new Cookie("SomeCookie", "SomeCookieExampleValue"));

        req.setAttribute("items", Catalog.getItems());

        req.getRequestDispatcher("example3list.jsp").forward(req, resp);
    }
}
