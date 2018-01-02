<%-- 
    Document   : createIncident
    Created on : 2017.07.20., 6:06:51
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
                    <li><a class="active" href="Incident?page=create">Create Incident</a></li>
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
                <div class="pageTitle">Create Incident</div>
                <div class="incident">
                    <form>
                        <div class="formitem">
                                <input type="submit" value="Save" class="button1">
                            </div>
                        <div class="incidentColumn">
                            
                            <div class="formitem colTitle">
                                <label>Customer details</label>
                            </div>
                            <div class="formitem">
                                <label for="custName">Customer name</label>
                                <input type="text" id="custName" name="custName" />
                            </div>
                            <div class="formitem">
                                <label for="custPhone">Customer phone nr</label>
                                <input type="text" id="custPhone" name="custPhone" />
                            </div>
                            <div class="formitem">
                                <label for="submitterMail">Submitter email</label>
                                <input type="text" id="submitterMail" name="submitterMail" />
                            </div>
                        </div>
                        <div class="incidentColumn">
                            
                            <div class="formitem colTitle">
                                <label>Customer location</label>
                            </div>
                            <div class="formitem">
                                <label for="country">Country</label>
                                <input type="text" id="country" size="24" name="country" />
                            </div>
                            <div class="formitem">
                                <label for="city">City</label>
                                <input type="text" id="city" size="24" name="city" />
                            </div>
                            <div class="formitem">
                                <label for="address">Address</label>
                                <input type="text" id="address" size="24" name="address" />
                            </div>
                        </div>
                        <div class="incidentColumn">
                            <div class="formitem colTitle">
                                <label>Incident details</label> 
                            </div>
                            <div class="formitem">
                                <label for="incidentID">Incident ID</label>
                                <input type="text" id="incidentID" size="24" name="incidentID" />
                            </div>
                            <div class="formitem">
                                <label for="status">Status</label>
                                <input type="text" id="status" size="24" name="status" />
                            </div>
                            <div class="formitem">
                                <label for="priority">Priority</label>
                                <input type="text" id="priority" size="24" name="priority" />
                            </div>
                            <div class="formitem">
                                <label for="createdAt">Created at</label>
                                <input type="text" id="createdAt" size="24" name="createdAt" />
                            </div>
                            <div class="formitem">
                                <label for="description">Description</label>
                                <input type="text" id="description" size="24" name="description" />
                            </div>
                            <div class="formitem">
                                <label for="group">Group</label>
                                <input type="text" id="group" size="24" name="group" />
                            </div>
                            <div class="formitem">
                                <label for="owner">Owner</label>
                                <input type="text" id="owner" size="24" name="owner" />
                            </div>
                        </div>
                    </form>
                </div>
                
            </div>


        </div>

    </body>
</html>
