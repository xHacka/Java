package com.example.Example2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "catalogServlet2", value = "/catalogServlet2")
public class CatalogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append(req.getParameter("name"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String manufacturer = req.getParameter("manufacturer");
        String sku = req.getParameter("sku");

        Catalog.addItem(new CatalogItem(name, manufacturer, sku));

        resp.setHeader("SomeHeader", "SomeHeaderValueExample");
        resp.addCookie(new Cookie("SomeCookie", "SomeCookieExampleValue"));

        req.setAttribute("message", name);
        req.getRequestDispatcher("example2list.jsp").forward(req, resp);
    }
}
