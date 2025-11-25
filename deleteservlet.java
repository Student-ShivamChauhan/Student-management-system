package com.sms.servlet;

import com.sms.dao.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * GET /delete?id=...  - deletes student and redirects to list.
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private StudentDAO dao = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                dao.deleteStudent(id);
            } catch (NumberFormatException e) {
                // ignore invalid id
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
        resp.sendRedirect(req.getContextPath() + "/students?msg=Student+deleted");
    }
}
