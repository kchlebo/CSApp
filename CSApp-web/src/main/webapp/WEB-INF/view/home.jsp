<%-- 
    Document   : home
    Created on : 2017.07.19., 22:04:51
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
                    <li><a class="active" href="Login">Home</a></li>
                    <li><a  href="Incident?page=create">Create Incident</a></li>
                    <li><a  href="Incident?page=search">Search Incident</a></li>
                    <li id="admin"><a href="#">Admin</a>
                    
                        <ul class="hoverdown-content collapsed">
                            <li><a href="UserAdmin">User management</a></li>
                            <li><a  href="CustomerAdmin">Customer management</a></li>
                        </ul>
                    
                        </li>
                </ul>
           
        </div>

        <div id="indexRightColumn">
            <div class="pageTitle">Home</div>
            <div class="myIncidentsGrid">
                [My incidents]
                <table>
                    <tr>
                        <td>data</td>
                    </tr>
                </table>
            </div>
            <div class="groupIncidentsGrid">
                [Incidents in my group]
                <table>
                    <tr>
                        <td>data</td>
                    </tr>
                </table>
            </div>
        </div>

        
    </div>
        
    </body>
</html>
