package com.example.users_logic;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static java.util.Objects.nonNull;

@WebFilter(filterName = "authFilter", value = "/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final HttpSession session = request.getSession();
        if (nonNull(session) && nonNull(session.getAttribute("role"))) {
            final String role = (String) session.getAttribute("role");
            moveToMenu(request, response, role);
        } else {
            moveToMenu(request, response, "unknown");
        }
    }
    private void moveToMenu(final HttpServletRequest request, final HttpServletResponse response, final String role)
            throws ServletException, IOException {
        if (role.equals("admin")) {
            if(request.getRequestURI().equals("/logout"))
                request.getRequestDispatcher("/logout").forward(request, response);
            else if(request.getRequestURI().contains("library"))
                request.getRequestDispatcher(request.getRequestURI()).forward(request, response);
            else
                request.getRequestDispatcher("/library").forward(request, response);
        }
        if (role.equals("user")) {
            if(request.getRequestURI().equals("/logout"))
                request.getRequestDispatcher("/logout").forward(request, response);
            else
                request.getRequestDispatcher("/library").forward(request, response);
        }
        if(role.equals("unknown")){
            if(!request.getRequestURI().contains("library"))
                request.getRequestDispatcher(request.getRequestURI()).forward(request, response);
            else
                request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
