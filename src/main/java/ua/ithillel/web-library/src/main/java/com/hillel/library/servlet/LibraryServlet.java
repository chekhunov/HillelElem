package com.hillel.library.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.hillel.library.entity.Abonent;
import com.hillel.library.entity.Role;

@WebServlet("/library")
public class LibraryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/library.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String naming = request.getParameter("naming");
        
        List<Abonent> abonents;
        try {
            abonents = getAbonents(naming);
            request.setAttribute("abonents", abonents);
            
            request.getRequestDispatcher("/jsp/library.jsp").forward(request, response);
        } catch (NamingException e) {
        }

    }

    private List<Abonent> getAbonents(String naming) throws NamingException {
        Context ctx = (Context) new InitialContext().lookup("java:comp/env");
        DataSource ds = (DataSource) ctx.lookup("jdbc/testphones");

        Connection cn = null;
        try {
            cn = ds.getConnection();
            Statement st = null;
            try {
                st = cn.createStatement();
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("SELECT * FROM phonebook WHERE lastname='" + naming +"'");
                    ArrayList<Abonent> lst = new ArrayList<>();
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String name = rs.getString(2);
                        int phone = rs.getInt(3);
                        Role role = Role.valueOf(rs.getString(4));
                        lst.add(new Abonent(id, phone, name, role, null));
                    }
                    return lst;
                } finally {
                    if (rs != null) {
                        rs.close();
                    } else {
                        System.err.println("error while reading DB");
                    }
                }
            } finally {
                if (st != null) {
                    st.close();
                } else {
                    System.err.println("Statement was not created");
                }
            }
        } catch (SQLException e) {
            System.err.println("DB connection error: " + e);
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Ñonnection close error: " + e);
                }
            }
        }

        return Collections.emptyList();
    }

}
