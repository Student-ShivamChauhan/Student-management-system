package com.sms.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Simple authentication filter to protect JSP pages and servlets except login/index.
 * Map this filter to secure paths (configured via annotation or web.xml).
 *
 * The annotation below blocks access to /students, /student, /edit, /delete, /logout, etc.
 */
@WebFilter(urlPatterns = {"/students", "/student", "/edit", "/delete", "/logout", "/add.jsp", "/list.jsp", "/edit.jsp", "/add.jsp"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) { /* no-op */ }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
            chain.doFilter(request, response);
            return;
        }
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        boolean loggedIn = session != null && session.getAttribute("user") != null;

        if (loggedIn) {
            chain.doFilter(request, response);
        } else {
            // If AJAX request, you might want to send 401; otherwise redirect to login.
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
    }

    @Override
    public void destroy() { /* no-op */ }
}
