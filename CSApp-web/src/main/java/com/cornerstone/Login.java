/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone;


import com.cornerstone.session.EmployeeFacadeLocal;
import com.cornerstone.session.IncidentFacade;
import com.cornerstone.session.IncidentFacadeLocal;
import com.cornerstone.utilities.URLHandler;
import com.cornerstone.utilities.URLHandler.PageType;
import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author 604772006
 */
public class Login extends HttpServlet {
    
    @EJB
    private IncidentFacadeLocal incidentFacade;
    @EJB
    private EmployeeFacadeLocal employeeFacade;
    
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
                //RequestDispatcher rd = request.getRequestDispatcher("Home");
                //rd.forward(request,response);
                String HOMEURL="/WEB-INF/view/home.jsp";
                //URLHandler.openURL(request, response,URLHandler.PageType.HOME);
                //Test data
                //TODO change to user parameter
                Integer i=1;
                List<com.cornerstone.entity.Incident> groupIncidents = incidentFacade.findAllInEmployeesGroups(i);
                
                //com.cornerstone.entity.Employee emp = employeeFacade.find(i);
                List<com.cornerstone.entity.Incident> myIncidents = incidentFacade.findByOwnerID(i);
                //com.cornerstone.entity.Incident inc = incidentFacade.find(1);
//                
                request.setAttribute("groupIncidents", groupIncidents);
                request.setAttribute("myIncidents", myIncidents);
                
                try{
                    request.getRequestDispatcher(HOMEURL).forward(request,response);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
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
