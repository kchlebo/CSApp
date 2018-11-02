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
                            <input id="usernameTextbox" type="text" name="username">
                        </label>
                        <label for="password">Password
                            <input id="passwordTextbox" type="password" name="password">
                        </label>
                        <input type="submit" value="Login" name="login" id ="loginButton" class="button1"/><br>
                        <input type="submit" value="Login as Guest" name="login-guest" id="loginAsGuestButton" class="button1"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
