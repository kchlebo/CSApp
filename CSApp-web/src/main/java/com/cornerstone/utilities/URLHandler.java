/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.utilities;


import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 604772006
 */
public class URLHandler {
    public enum PageType {HOME, INCIDENT, INDEX, CUSTOMERADMIN, USERADMIN, SEARCHINCIDENT, CREATEINCIDENT}
    static Map<PageType,String> urlHolder=new HashMap<>();
    static{
        
        urlHolder.put(PageType.HOME,"/WEB-INF/view/home.jsp");
        urlHolder.put(PageType.INCIDENT,"/WEB-INF/view/incident.jsp");
        urlHolder.put(PageType.INDEX,"/index.jsp");
        urlHolder.put(PageType.CUSTOMERADMIN,"/WEB-INF/view/customerAdmin.jsp");
        urlHolder.put(PageType.USERADMIN,"/WEB-INF/view/userAdmin.jsp");
        urlHolder.put(PageType.SEARCHINCIDENT,"/WEB-INF/view/searchIncident.jsp");
        urlHolder.put(PageType.CREATEINCIDENT,"/WEB-INF/view/createIncident.jsp");
        
    }
    
    static String getUrlForType(PageType type)
    {
        return urlHolder.get(type);
    }
    
    public static void openURL(HttpServletRequest request, HttpServletResponse response, PageType type)
    {
        //public static final String HOMEURL="/WEB-INF/view/home.jsp";
        
        
        try{
            request.getRequestDispatcher(getUrlForType(type)).forward(request, response);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
