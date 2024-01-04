package com.example.users_logic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            User user;
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            user = new User(login, password, "user");
            if(UserDB.insert(user) == 1) {
                HttpSession session = request.getSession();
                session.setAttribute("role", user.getRole());
                response.sendRedirect("/library");
            }
            else
                response.sendRedirect("/register.jsp");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}