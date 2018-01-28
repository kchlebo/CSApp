/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.utilities;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 604772006
 */
public class URLHandler {
    public enum PageType {HOME, INCIDENT, INDEX, CUSTOMERADMIN, USERADMIN, SEARCHINCIDENT, CREATEINCIDENT}
    static final Map<PageType,String> URLHOLDER=new HashMap<>();
    static{
        
        URLHOLDER.put(PageType.HOME,"/WEB-INF/view/home.jsp");
        URLHOLDER.put(PageType.INCIDENT,"/WEB-INF/view/incident.jsp");
        URLHOLDER.put(PageType.INDEX,"/index.jsp");
        URLHOLDER.put(PageType.CUSTOMERADMIN,"/WEB-INF/view/customerAdmin.jsp");
        URLHOLDER.put(PageType.USERADMIN,"/WEB-INF/view/userAdmin.jsp");
        URLHOLDER.put(PageType.SEARCHINCIDENT,"/WEB-INF/view/searchIncident.jsp");
        URLHOLDER.put(PageType.CREATEINCIDENT,"/WEB-INF/view/createIncident.jsp");
        
    }
    
    static String getUrlForType(PageType type)
    {
        return URLHOLDER.get(type);
    }
    
    public static void openURL(HttpServletRequest request, HttpServletResponse response, PageType type) 
    {
        //public static final String HOMEURL="/WEB-INF/view/home.jsp";
        
        
        try{
            request.getRequestDispatcher(getUrlForType(type)).forward(request, response);
        }
        catch(ServletException|IOException ex)
        {
            ex.getMessage();
            //TODO: add logger for exception
        }
    }
}
