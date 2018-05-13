/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ioannis
 */
public class Confirmation extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        
        Cookie[] cookies;
        cookies = request.getCookies();
        
        PrintWriter out = response.getWriter();
        StringBuffer buf = new StringBuffer();
        
        buf.append("<html>");
        buf.append("<head>");
        buf.append("<title>Confirmation</title>");
        buf.append("<meta charset=\"UTF-8\">");
        buf.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        buf.append("</head>");
        buf.append("<body background=\"img/29425336_1491831617605893_3705436150760996864_n.jpg\">");
        
        
        if(request.getParameter("product") != null){
            buf.append("<div align=\"center\">");
            buf.append("<div style= \"overflow:auto;width:300px;height:800px;background:#ffffcc; border: solid greenyellow 3px ;float:left; margin-left:580px; left:0;top:0;padding:3px;\">");
            buf.append("<h3 style= \"color:blueviolet ;font-family:courier;text-align:center;\"> Payment <br><br> </h2>");
            
            if(cookies.length != 0){
                for(Cookie c : cookies) 
                    if(c.getName().equals("fname"))
                        buf.append("First Name: <i>" + c.getValue() + "</i> <br>");
                for(Cookie c : cookies) 
                    if(c.getName().equals("lname"))
                        buf.append("Last Name: <i>" + c.getValue() + "</i> <br><br>");
                for(Cookie c : cookies) 
                    if(c.getName().equals("sdate"))
                        buf.append("Pick-Up Date: <i>" + c.getValue() + "</i> <br>");
                for(Cookie c : cookies) 
                    if(c.getName().equals("fdate"))
                        buf.append("Drop-Off Date: <i>" + c.getValue() + "</i> <br><br>");
                for(Cookie c : cookies) 
                    if(c.getName().equals("categories"))
                        buf.append("Category: <i>" + c.getValue() + "</i> <br>");
                String car = request.getParameter("product");
                Cookie vehicle = new Cookie("vehicle", request.getParameter("product"));
                vehicle.setMaxAge(60 * 60 * 24);
                response.addCookie(vehicle);

                String price = request.getParameter("price");
                Cookie priceCookie = new Cookie("price", request.getParameter("price"));
                priceCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(priceCookie);
                
                buf.append("Chosen Vehicle: <i>" + car + "</i> <br>");
                buf.append("Price: <i>" + price + "</i> price/day <br><br>");
                
                buf.append("<form action=\"Confirmation\" method=\"post\">");
                buf.append("E-mail: <input type=\"text\" name=\"email\" required > <br>");
                buf.append("Choose a payment form: <select name=\"choice\"  required>\n" +
                            "<option disabled selected value> Choose a payment form...</option>\n" +
                            "<option value=\"payondelivery\"> Pay on delivery</option>\n" +
                            "<option value=\"Card\">Card</option>\n" +
                            "</select> <br> <br>");
                buf.append("<label for=\"fname\"> If you want to pay by card:   </label> <br>\n" +
                           "<label for=\"fname\"> Accepted Cards </label> <br> ");
                buf.append("<img src=\"img/29665735_1500923660030022_2630462_n.jpg\" alt=\"Cards\" style=\"width:200px;height:100px;\"><br> <br><br><br>");
                buf.append("Name on Card: <select name=\"cards\"  >\n" +
                            "<option disabled selected value> Choose Card...</option>\n" +
                            "<option value=\"Visa\">Visa</option>\n" +
                            "<option value=\"MasterCard\">Master Card</option>\n" +
                            "<option value=\"Unionpay\">Unionpay</option>\n" +
                            "<option value=\"Maestro\">Maestro</option>\n" +
                            "\n" +
                            "</select> <br><br>\n" +
                            "<label for=\"ccnum\">Credit card number</label>\n" +
                            "<input type=\"password\" id=\"ccnum\" name=\"cardnumber\" placeholder=\"1111-2222-3333-4444\"> <br><br>\n" +
                            "<input type=\"submit\" value=\"Confirm!\">    \n" +
                            "</div>");
            }
            else{
                buf.append("There is ERROR! </div>");
            }
            
        }
        else{
            buf.append("<div align=\"center\">");
            buf.append("<div style= \"overflow:auto;width:300px;height:600px;background:#ffffcc; border: solid greenyellow 3px ;float:left; margin-left:580px; left:0;top:0;padding:3px;\">");
            buf.append("<h3 style= \"color:blueviolet ;font-family:courier;text-align:center;\"> Payment <br><br> </h2>");
            
            if(cookies.length != 0){
                for(Cookie c : cookies) 
                    if(c.getName().equals("fname"))
                        buf.append("First Name: <i>" + c.getValue() + "</i> <br>");
                for(Cookie c : cookies) 
                    if(c.getName().equals("lname"))
                        buf.append("Last Name: <i>" + c.getValue() + "</i> <br><br>");
                for(Cookie c : cookies) 
                    if(c.getName().equals("sdate"))
                        buf.append("Pick-Up Date: <i>" + c.getValue() + "</i> <br>");
                for(Cookie c : cookies) 
                    if(c.getName().equals("fdate"))
                        buf.append("Drop-Off Date: <i>" + c.getValue() + "</i> <br><br>");
                for(Cookie c : cookies) 
                    if(c.getName().equals("categories"))
                        buf.append("Category: <i>" + c.getValue() + "</i> <br>");
                for(Cookie c : cookies) 
                    if(c.getName().equals("vehicle"))
                        buf.append("Chosen Vehicle: <i>" + c.getValue() + "</i> <br>");
                for(Cookie c : cookies) 
                    if(c.getName().equals("price"))
                        buf.append("Price: <i>" + c.getValue() + "</i> price/day <br><br>");
                
                buf.append("E-mail: " + request.getParameter("email") + "<br>");
                buf.append("<h4><strong>Thank You!<br></strong></h4>");
                buf.append("We will inform you with an E-Mail!</div>");
            }else{
                buf.append("There is ERROR! </div>");
            }
        }
        
        buf.append("</body>");
        buf.append("</html>");
            
        out.println(buf.toString());
        out.close();
    }

}
