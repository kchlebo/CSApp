<%-- 
    Document   : index
    Created on : 2017.07.19., 21:28:30
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
                <img src class="logo" id="logoBig" alt="">
            </div>
           <div id="indexRightColumn">
               <h1>CornerStone</h1>
                <div id="loginBox">
                    <div id="form-header">Login</div>
                    <form action="Login" method="post">
                        <label for="username">Username
                            <input type="text" name="username">
                        </label>
                        <label for="password">Password
                            <input type="password" name="password">
                        </label>
                        <input type="submit" value="Login" name="login" class="button1"/><br>
                        <input type="submit" value="Login as Guest" name="login-guest" class="button1"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
