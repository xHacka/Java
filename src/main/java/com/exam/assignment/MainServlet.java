package com.exam.assignment;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import com.exam.assignment.database.DBUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;

@WebServlet(name = "addPost", value = "/addPost")
public class MainServlet extends HttpServlet {
    private String message;
    private Connection conn;
    Random rand;

    public void init() {
        try {
            conn = DBUtils.getDatabase();
            rand = new Random();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("posts", DBUtils.getPosts(conn));
        request.getRequestDispatcher("index.jsp").forward(request,  response);
    }

    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DBUtils.addPost(
                conn,
                request.getParameter("author"),
                request.getParameter("title"),
                request.getParameter("content"),
                rand.nextInt(100)
        );

        request.setAttribute("posts", DBUtils.getPosts(conn));
        request.getRequestDispatcher("index.jsp").forward(request,  response);
    }

    public void destroy() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}