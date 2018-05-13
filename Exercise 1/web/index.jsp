<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    
    <head>
        <title>Vaggos Car Renting</title> <!--titlos pano pano selidas-->
        <meta charset="UTF-8"> <!-- morfopoihsh blowser -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    </head>
    <body background="img/5057ca93ec8bdb3.jpg">
        <h1 style="color:green;font-family:courier;text-align:center;">Vaggos Car Renting</h1> <!--titlos-->
        <div style= "overflow:auto;width:350px;height:360px;background:#ffffcc; border: solid greenyellow 3px ;float:left;left:0;top:0;padding:3px;">
            <!-- plaisio keimenou diastaseis -->
            <strong> >Welcome to Vaggos Rent Car!< <br><br></strong> <!--titlos keimenou-->
            <form action="Categories" method="post">
                First name   : <input type="text" name="fname" required > <br>
                Last name   : <input type="text" name="lname" required > <br><br>
                <% //emfanizetai h simerinh hmerominia kai apo kato h shmerini syn 2
                    Date today = new Date();
                    Date dropOffDate = new Date(today.getTime() + 3*24*3600*1000 );
                    String day = String.format("%02d", today.getDate());
                    String dropDay = String.format("%02d", dropOffDate.getDate());
                    String month = String.format("%02d", today.getMonth() + 1);
                    String dropMonth = String.format("%02d", dropOffDate.getMonth() + 1);
                    String year = String.format("%02d", today.getYear() + 1900);
                    String dropYear = String.format("%02d", dropOffDate.getYear() + 1900);
                    %>
                Pick-Up Date : <input type="date" required name="sdate"  value="<% out.print( year + "-" + month + "-" + day);%>" min="<% out.print(year + "-" + month + "-" + day);%>"><br>
                Drop-off Date : <input type="date" required name="fdate" value="<% out.print(dropYear + "-" + dropMonth + "-" + dropDay); %>" min="<% out.print(dropYear + "-" + dropMonth + "-" + dropDay); %>"><br><br>
                <!--epilogi polis-->
                City: <select name="cities"  required>
                    <option disabled selected value> Choose City...</option>
                    <option value="Athens">Athens</option>
                    <option value="Thessaloniki">Thessaloniki</option>
                    <option value="Patras">Patras</option>
                    <option value="Volos">Volos</option>
                    <option value="Irakleio">Irakleio</option>
                    <option value="Rodos">Rodos</option>
                </select> <br><br>
                <input type="checkbox" name="age" required><br>
                <small>Age : 24-69</small><br><br>
                <input type="submit" value="Continue!">
            </form>     
        </div>
    </body>
</html>