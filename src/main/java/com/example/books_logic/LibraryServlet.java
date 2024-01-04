package com.example.books_logic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "libraryServlet", value = "/library")
public class LibraryServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Book> books = BookDB.select();
        request.setAttribute("books", books);
        if(request.getSession().getAttribute("role").equals("admin"))
            getServletContext().getRequestDispatcher("/library.jsp").forward(request, response);
        else
            getServletContext().getRequestDispatcher("/userLibrary.jsp").forward(request, response);
    }
}