/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.controller;

import com.mvc.Model.Club;
import com.mvc.Model.Post;
import com.mvc.bean.EventBean;
import com.mvc.dao.EventDao;
import com.mvc.dao.Idea_dao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "post_control", urlPatterns = {"/post_control"})
public class post_control extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String username=request.getParameter("uname");
            String title=request.getParameter("title");
            String descr=request.getParameter("descr");
            Post bean=new Post();
            bean.setUsername(username);
            bean.setPost_title(title);
            bean.setPost_descr(descr);
            	 Idea_dao loginDao = new Idea_dao(); //creating object for LoginDao. This class contains main logic of the application.
		 
	        String userValidate = loginDao.RegisterEvent(bean); //Calling authenticateUser function
	 
	        if(userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
	         {
	        	// HttpSession session=
	           //  request.setAttribute("id", username); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
	         //    HttpSession session=request.getSession();  
	           //  session.setAttribute("uname",username);
	        	out.println("<script> alert(\"event Inserted succefully!\");</script>");
	        	out.println("<script> location.replace('Home.jsp', '_blank')</script>"); //            request.getRequestDispatcher("/AdminHome.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
	         }
	         else
	         {
	             request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
	             request.getRequestDispatcher("/Home.jsp").forward(request, response);//forwarding the request
	         }

            
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
        processRequest(request, response);
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
        processRequest(request, response);
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
