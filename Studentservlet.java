package com.sms.servlet;

import com.sms.dao.StudentDAO;
import com.sms.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Handles POST requests for adding or updating a student.
 * Path: /student
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private StudentDAO dao = new StudentDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Ensure UTF-8 for form data
        req.setCharacterEncoding("UTF-8");

        String action = req.getParameter("action");
        try {
            if ("add".equals(action)) {
                String name = req.getParameter("name");
                int age = Integer.parseInt(req.getParameter("age"));
                String department = req.getParameter("department");
                Student s = new Student(name, age, department);
                dao.addStudent(s);
                resp.sendRedirect(req.getContextPath() + "/students?msg=Student+added");
            } else if ("update".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                int age = Integer.parseInt(req.getParameter("age"));
                String department = req.getParameter("department");
                Student s = new Student(id, name, age, department);
                dao.updateStudent(s);
                resp.sendRedirect(req.getContextPath() + "/students?msg=Student+updated");
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown action");
            }
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid number format");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
