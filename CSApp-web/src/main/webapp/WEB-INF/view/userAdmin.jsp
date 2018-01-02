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
                    <li><a  href="Login">Home</a></li>
                    <li><a  href="Incident?page=create">Create Incident</a></li>
                    <li><a  href="Incident?page=create">Search Incident</a></li>
                    <li id="admin"><a href="#">Admin</a>
                    
                        <ul class="hoverdown-content expanded">
                            <li><a class="active" href="UserAdmin">User management</a></li>
                            <li><a  href="CustomerAdmin">Customer management</a></li>
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
                <div class="table">
                    [Results]
                    <table>
                        <tr>
                            <td>data</td>
                        </tr>
                    </table>
                </div>
                <div class="modify-buttons">
                    <button value="">Add</button>
                    <button value="">Modify</button>
                    <button value="">Delete</button>
                </div>
                <div class="admin-fields">
                <form>
                    <div class="formitem">
                        <input type="submit" value="Save" class="button1">
                    </div>                            
                    <div class="formitem">
                        <label for="firstName">First name</label>
                        <input type="text" id="firstName" name="firstName" />
                    </div>
                    <div class="formitem">
                        <label for="lastName">Last name</label>
                        <input type="text" id="lastName" name="lastName" />
                    </div>
                    <div class="formitem">
                        <label for="phonenr">Phone nr</label>
                        <input type="text" id="phonenr" name="phonenr" />
                    </div>
                    <div class="formitem">
                        <label for="userMail">Email</label>
                        <input type="text" id="userMail" name="userMail" />
                    </div>
                    <div class="formitem">
                        <label for="role">Role</label>
                        <input type="text" id="role" name="role" />
                    </div>
                    <div class="formitem">
                        <label for="permission">Group permission</label>
                        <input type="text" id="permission" name="permission" />
                    </div>

                </form>
                    </div>
            </div>


        </div>

    </body>
</html>
