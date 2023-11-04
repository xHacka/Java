package com.exam.assignment.database;

import com.exam.assignment.model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    public static Connection getDatabase() throws SQLException, ClassNotFoundException {
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql:// localhost:3306/";
        String dbName = "quiz3";
        String dbUsername = "root";
        String dbPassword = "";

        Class.forName(dbDriver);
        Connection conn = DriverManager.getConnection(
                dbURL + dbName,
                dbUsername,
                dbPassword
        );
        return conn;
    }

    public static void addPost(Connection conn, String author, String title, String content, Integer views) throws SQLException {
        PreparedStatement query = conn.prepareStatement("INSERT INTO posts (author, title, content, views) VALUES (?, ?, ?, ?)");
        query.setString(1, author);
        query.setString(2, title);
        query.setString(3, content);
        query.setInt(4, views);
        query.executeUpdate();
        query.close();
    }

    public static List getPosts(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM posts");
        // Create an array of Strings, with the same number of elements as the ResultSet.
        List posts = new ArrayList<Post>();
        while (rs.next()) {
            Post post = new Post(
                    rs.getInt("id"),
                    rs.getInt("views"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("content")
            );
            posts.add(post);
        }
        rs.close();
        return posts;
    }
}

