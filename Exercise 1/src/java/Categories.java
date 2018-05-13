import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


class Category{
    
    private String nameCategory; //onoma katigorias
    private String path; //path eikonas

    public String getNameCategory() {
        return nameCategory; //epistrefei to onoma tis katigorias
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory; //egkathista to onoma ths kathgorias sthn lista 
    }

    public String getPath() {
        return path; //epistrefei to path ths eikonas
    }

    public void setPath(String path) {
        this.path = path; //egkathista to path ths eikonas sthn lista
    }
    
}

public class Categories extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        Cookie fname = new Cookie("fname", request.getParameter("fname"));
        Cookie lname = new Cookie("lname", request.getParameter("lname"));
	Cookie sdate = new Cookie("sdate", request.getParameter("sdate"));
        Cookie fdate = new Cookie("fdate", request.getParameter("fdate"));
	Cookie cities = new Cookie("cities", request.getParameter("cities"));
        
        fname.setMaxAge(60 * 60 * 24);
        lname.setMaxAge(60 * 60 * 24);
        sdate.setMaxAge(60 * 60 * 24);
        fdate.setMaxAge(60 * 60 * 24);
        cities.setMaxAge(60 * 60 * 24);
        
        response.addCookie(fname);
        response.addCookie(lname);
        response.addCookie(sdate);
        response.addCookie(fdate);
        response.addCookie(cities);
        
        StringBuffer buf = new StringBuffer();
             buf.append("<!DOCTYPE html>");
             buf.append("<html>");
             buf.append("<head>");
             buf.append("<title> Categories </title>");
             buf.append("<meta charset=\"UTF-8\">");
             buf.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
             buf.append("</head>");
             buf.append("<body style = background:#ffffcc;>");
             buf.append("<h1 style=\"color:green;font-family:courier;text-align:center;\"> Categories</h1>");
             
             String firstName = request.getParameter("fname"); // ftiaxnei ena string to opoio legetai firstname kai apothikeyei to onoma apo thn prohgoymenh format
             
             buf.append("<strong><i>Hi, ").append(firstName).append("!<br>");
             buf.append("Please Choose A Category, </i></strong>");
             
             File file = new File("usr/share/tomcat8/webapps/RentingCar/WEB-INF/doc/Categories.txt"); //anoigo to arxeio me stoixeia
             Scanner in = new Scanner(file); //to diabazeis 
             
             ArrayList<Category> myCategories = new ArrayList<>(); //dhmioyrgo mia arraylist
             
             while(in.hasNext()){
                 Category tempCategory = new Category(); 
                 tempCategory.setNameCategory(in.nextLine());
                 tempCategory.setPath(in.nextLine());
                 myCategories.add(tempCategory);
             } //gemizo th lista me ta stoixeia toy file
            
            buf.append("<div align=\"center\">"); 
            for(Category c : myCategories){ //diatrexo thn lista 
                buf.append("<div style= \"overflow:auto;width:350px;height:220px;background:#ffffcc;float:left;left:0;top:0;padding:4px;margin-left:60px;;margin-top: 30px\">\n");
                buf.append("<strong>").append(c.getNameCategory()).append("<br></strong>");
                buf.append("<img src=\"img/categories/").append(c.getPath()).append("\" alt=\"").append(c.getNameCategory()).append("\" style=\"width:250px;height:160px;\"><br>");
                buf.append("<form action=\"Products\" method=\"get\">");
                buf.append("<input type=\"hidden\" name=\"category\" value=\"").append(c.getNameCategory()).append("\">");
                // to "hidden" einai mia kryfh forma h opoia epistrefei thn parametro gia na thn exoyme gia thn epomenh forma
                buf.append("<input action type=\"submit\" value=\"Continue!\">");
                buf.append("</form>");
                buf.append("</div>"); // bazo ta paths kai ta onomata apo thn lista oste na dimiourgiso ta div tis kathe eikonas
            }            
            buf.append("</div>");
            
            buf.append("</body>");
            buf.append("</html>");
            
            out.println(buf.toString());
            out.close();
    }

}