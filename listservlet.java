package com.sms.servlet;

import com.sms.dao.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Handles GET to /students - shows list or search results.
 */
@WebServlet("/students")
public class ListServlet extends HttpServlet {
    private StudentDAO dao = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q = req.getParameter("q");
        try {
            if (q != null && !q.trim().isEmpty()) {
                req.setAttribute("students", dao.searchByName(q.trim()));
            } else {
                req.setAttribute("students", dao.getAllStudents());
            }
            req.getRequestDispatcher("/list.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
package com.sms.servlet;

import com.sms.dao.StudentDAO;
import com.sms.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Loads a student and forwards to edit.jsp.
 * GET /edit?id=...
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private StudentDAO dao = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr == null) {
            resp.sendRedirect(req.getContextPath() + "/students");
            return;
        }
        try {
            int id = Integer.parseInt(idStr);
            Student s = dao.getStudentById(id);
            req.setAttribute("student", s);
            req.getRequestDispatcher("/edit.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/students");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
