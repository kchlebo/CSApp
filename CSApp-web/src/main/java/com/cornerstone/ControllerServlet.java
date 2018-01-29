/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone;

import com.cornerstone.session.IncidentFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import com.cornerstone.session;

/**
 *
 * @author Kornel
 */
public class ControllerServlet extends HttpServlet {
    
    @EJB
    private IncidentFacade incidentFacade;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        String path=request.getServletPath();
        boolean isInViewFolder=true;
        String url="";
        if(path.equals("/signOut"))
        {
            isInViewFolder=false;
            url="/index.jsp";
        }
        else if(path.equals("/incident"))
        {
            String param=request.getParameter("page");
            switch (param) {
                case "create":
                    path="createIncident";
                    break;
                case "search":
                    path="searchIncident";
                    break;
                case "view":
                    path="incident";
                    break;
                default:
                    break;
            }
        }
        else if(path.equals("/customerAdmin"))
        {
            path="customerAdmin";
        }
        else if(path.equals("/userAdmin"))
        {
            path="userAdmin";
        }
        
        else if(path.equals("/login"))
        {
            path="home";
        }
        
        if (isInViewFolder){url="/WEB-INF/view/"+path+".jsp";}
        try{
            request.getRequestDispatcher(url).forward(request, response);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
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
        String path=request.getServletPath();
        
        if(path.equals("/login"))
        {
            path="home";
        }
        
        String url="/WEB-INF/view/"+path+".jsp";
        try{
            request.getRequestDispatcher(url).forward(request, response);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
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
