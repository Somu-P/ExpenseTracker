import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import util.DbConfig;
public class RegisterServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        try{
            Connection con=DbConfig.getConnection(getServletContext().getRealPath("/WEB-INF/.env"));
            PreparedStatement ps=con.prepareStatement("insert into users values(?,?,?)");
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,password);
            ps.executeUpdate();
            response.sendRedirect("login.html");
        }catch(Exception e){
            response.getWriter().println(e);
        }
    }
}
