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

/**
 *
 * @author ioannis
 */

class Product{
    
    private String productName;
    private String ppd;
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPpd() {
        return ppd;
    }

    public void setPpd(String ppd) {
        this.ppd = ppd;
    }
    
}

public class Products extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        
        Cookie categoryCookie = new Cookie("categories", request.getParameter("category"));
        categoryCookie.setMaxAge(60 * 60 * 24);
        response.addCookie(categoryCookie);
        
        PrintWriter out = response.getWriter();
        StringBuffer buf = new StringBuffer();
        
        buf.append("<!DOCTYPE html>");
        buf.append("<html>");
        buf.append("<head>");
        buf.append("<title> Product </title>");
        buf.append("<meta charset=\"UTF-8\">");
        buf.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        buf.append("</head>");
        
        String category = request.getParameter("category");
        
        buf.append("<body background=\"img/29853010_10155329619740978_1454503159_n.jpg\">");
        buf.append("<h1 style=\"color:blueviolet ;font-family:courier;text-align:center;\">" + category + "<br></h1>");
        
        File inFile = new File("/usr/share/tomcat8/webapps/RentingCar/WEB-INF/doc/" + category + ".txt");
        Scanner in = new Scanner(inFile);
        
        ArrayList<Product> productList = new ArrayList<>();
        
        int cnt = 1;
        while(in.hasNext()){
            Product tempProduct = new Product();
            tempProduct.setProductName(in.nextLine());
            tempProduct.setPpd(in.nextLine());
            tempProduct.setImg(cnt + ".jpg");
            productList.add(tempProduct);
            cnt++;
            
        }
        
        buf.append("<div align=\"center\">");
        for(Product p : productList){
            buf.append("<div style= \"overflow:auto;width:450px;height:280px;background:#ffffb3;float:left;left:0;top:0;padding:4px;margin-left:400px;;margin-top: 30px\">");
            buf.append("<strong>").append( p.getProductName()).append("<br></strong>");
            buf.append("<img src=\"img/" + category + "/" + p.getImg() +"\" alt=\"" + p.getProductName() +"\" style=\"width:400px;height:200px;\"><br>");
	    buf.append("<strong><i> Price per Day: </i></strong>" + p.getPpd() + " euros <br>");
            buf.append("<form action=\"Confirmation\" method=\"post\">");
            buf.append("<input type=\"hidden\" name=\"product\" value=\"").append(p.getProductName()).append("\">");
            buf.append("<input type=\"hidden\" name=\"price\" value=\"").append(p.getPpd()).append("\">");
            buf.append("<input action type=\"submit\" value=\"Select!\">");
            buf.append("</form>");
            buf.append("</div>");
    }
        
        

        buf.append("</body>");
        buf.append("</html>");
            
        out.println(buf.toString());
        out.close();
    }
}

