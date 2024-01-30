package com.example.users_logic.DAO;

import com.example.users_logic.models.User;

import java.sql.*;

public class UserDB {
    private static String url = "jdbc:postgresql://localhost:5432/java_db";
    private static String username = "postgres";
    private static String password = "1234";
    public static User selectOne(String login, String userPassword){
        User user = null;
        try {
            Class.forName("org.postgresql.Driver");
            try(Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM users WHERE login=? AND password=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, login);
                    preparedStatement.setString(2, userPassword);
                    ResultSet rs = preparedStatement.executeQuery();
                    if(rs.next()){
                        user = new User();
                        user.setLogin(rs.getString(1));
                        user.setPassword(rs.getString(2));
                        user.setRole(rs.getString(3));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return user;
    }
    public static int insert(User user) {
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "INSERT INTO users (login, password, role) VALUES (?, ?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, user.getLogin());
                    preparedStatement.setString(2, user.getPassword());
                    preparedStatement.setString(3, user.getRole());
                    return preparedStatement.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }
}
