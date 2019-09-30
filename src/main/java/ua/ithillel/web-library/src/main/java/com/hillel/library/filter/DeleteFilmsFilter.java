package com.hillel.library.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hillel.library.entity.Abonent;
import com.hillel.library.entity.Role;

@WebFilter("/deleteFilms")
public class DeleteFilmsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        if (httpRequest.getMethod().equals("POST")) {

            HttpSession session = httpRequest.getSession();

            Abonent abonent = (Abonent) session.getAttribute("abonent");

            if (abonent != null && abonent.getRole() == Role.ADMIN) {
                chain.doFilter(httpRequest, httpResponse);
            } else {
                httpResponse.sendRedirect("/login");
            }
        } else {
            chain.doFilter(httpRequest, httpResponse);
        }

    }

}
