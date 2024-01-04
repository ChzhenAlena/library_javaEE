package com.example.books_logic;

import java.util.ArrayList;
import java.sql.*;

public class BookDB {
    private static String url = "jdbc:postgresql://localhost:5432/java_db";
    private static String username = "postgres";
    private static String password = "1234";

    public static ArrayList<Book> select() {

        ArrayList<Book> books = new ArrayList<Book>();
        try{
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM book");
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    String author = resultSet.getString(3);
                    String description = resultSet.getString(4);
                    int quantity = resultSet.getInt(5);
                    Book book = new Book(id, title, author, description, quantity);
                    books.add(book);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return books;
    }
    public static Book selectOne(int id) {

        Book book = null;
        try{
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM book WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){

                        int bookId = resultSet.getInt(1);
                        String title = resultSet.getString(2);
                        String author = resultSet.getString(3);
                        String description = resultSet.getString(4);
                        int quantity = resultSet.getInt(5);
                        book = new Book(bookId, title, author, description, quantity);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return book;
    }
    public static int insert(Book book) {

        try{
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "INSERT INTO book (title, author, description, quantity) Values (?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, book.getTitle());
                    preparedStatement.setString(2, book.getAuthor());
                    preparedStatement.setString(3, book.getDescription());
                    preparedStatement.setInt(4, book.getQuantity());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Book book) {

        try{
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE book SET title = ?, author = ?, description = ?, quantity = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, book.getTitle());
                    preparedStatement.setString(2, book.getAuthor());
                    preparedStatement.setString(3, book.getDescription());
                    preparedStatement.setInt(4, book.getQuantity());
                    preparedStatement.setInt(5, book.getId());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int id) {

        try{
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "DELETE FROM book WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
