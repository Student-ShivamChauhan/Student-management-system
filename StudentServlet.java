package controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import dao.StudentDAO;
import model.Student;

public class StudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        if (name.isEmpty() || email.isEmpty()) {
            response.sendRedirect("addStudent.jsp?error=true");
            return;
        }

        Student s = new Student(name, email);
        StudentDAO.saveStudent(s);

        response.sendRedirect("viewStudent.jsp");
    }
}
