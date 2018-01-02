<%-- 
    Document   : admin
    Created on : 2017.07.20., 6:09:17
    Author     : Kornel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/cornerstone.css">
        <title>CornerStone</title>
    </head>
    <body>
        <div id="main">


            <div id="indexLeftColumn">
                <ul class="verticalMenu">
                    <li><a href="home.jsp">Home</a></li>
                    <li><a  href="createIncident.jsp">Create Incident</a></li>
                    <li><a  href="searchIncident.jsp">Search Incident</a></li>
                    <li id="admin"><a href="#">Admin</a>
                    
                        <ul class="hoverdown-content expanded">
                            <li><a href="userAdmin.jsp">User management</a></li>
                            <li><a class="active" href="groupAdmin.jsp">Group management</a></li>
                            <li><a   href="customerAdmin.jsp">Customer management</a></li>
                        </ul>
                    
                        </li>
                </ul>
                <%--
                <div class="verticalMenu">
                    <a href="home.jsp">Home</a>
                    <a  href="createIncident.jsp">Create Incident</a>
                    <a  href="searchIncident.jsp">Search Incident</a>
                    <div class="dropdown">
                        <button class="dropbtn">Dropdown</button>    
                        <div class="dropdown-content">
                            <a class="active" href="admin.jsp">User management</a>
                            <a class="active" href="admin.jsp">Group management</a>
                            <a class="active" href="admin.jsp">Customer management</a>
                        </div>
                    </div>
                </div>
                                    --%>

            </div>

            <div id="indexRightColumn">
                right column


            </div>


        </div>

    </body>
</html>
