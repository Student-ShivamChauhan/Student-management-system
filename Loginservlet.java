package com.sms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Demo login servlet. Replace with a real user store for production.
 * Accepts POST to /login with parameters 'username' and 'password'.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        if (USERNAME.equals(user) && PASSWORD.equals(pass)) {
            HttpSession session = req.getSession(true);
            session.setAttribute("user", user); // mark authenticated
            // Optionally set session timeout in seconds (e.g., 30 minutes)
            session.setMaxInactiveInterval(30 * 60);
            resp.sendRedirect(req.getContextPath() + "/students");
        } else {
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
