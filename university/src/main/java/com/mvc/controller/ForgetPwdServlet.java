/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.controller;

import com.mvc.util.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class ForgetPwdServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             String username = null,cntno,email = null;
         //   username=request.getParameter("username");
            cntno=request.getParameter("username");
           // email=request.getParameter("email");
            Connection con = DBConnection.createConnection(); 
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from users where  username='"+cntno+"'");// and email='"+email+"'");
            if(rs.next())
            {
               response.sendRedirect("useriddisp_1.jsp?id="+rs.getString("q1")+"-"+rs.getString("q2")+"-"+rs.getString("q3"));
            }
           /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ForgetPwdServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ForgetPwdServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
           // processRequest(request, response);
            String username = null,cntno,email = null;
         //   username=request.getParameter("username");
            cntno=request.getParameter("username");
            
           // email=request.getParameter("email");
            Connection con = DBConnection.createConnection(); 
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from users where  username='"+cntno+"'");// and email='"+email+"'");
            if(rs.next())
            {
               response.sendRedirect("useriddisp_1.jsp?id="+rs.getString("q1")+"-"+rs.getString("q2")+"-"+rs.getString("q3"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForgetPwdServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //processRequest(request, response);
            String username = null,cntno,email = null;
         //   username=request.getParameter("username");
            cntno=request.getParameter("username");
           // email=request.getParameter("email");
            Connection con = DBConnection.createConnection(); 
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from users where  username='"+cntno+"'");// and email='"+email+"'");
            if(rs.next())
            {
               response.sendRedirect("useriddisp_1.jsp?id="+rs.getString("q1")+"-"+rs.getString("q2")+"-"+rs.getString("q3"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForgetPwdServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
