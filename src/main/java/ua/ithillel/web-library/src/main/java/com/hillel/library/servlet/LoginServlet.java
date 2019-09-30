package com.hillel.library.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hillel.library.entity.Abonent;
import com.hillel.library.user.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginService loginService;

    public LoginServlet() {
        loginService = new LoginService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String valid = request.getParameter("valid");
        Abonent abonent = getLoginService().login(username, password, Boolean.valueOf(valid));
        if (abonent != null) {
            HttpSession session = request.getSession();
            session.setAttribute("abonent", abonent);
            response.sendRedirect("/");
        } else {
            request.setAttribute("loginError", "Not existing user");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }

    }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

}
