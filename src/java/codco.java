/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Miguel
 */
/*@WebServlet(urlPatterns = {"/ConsultaServlet"})*/
public class codco extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
  
        Connection connectionBD = null;
        Statement sql = null;
   
        String ide=request.getParameter("Compania");
        try (PrintWriter out = response.getWriter()) {
          
            Class.forName("com.mysql.jdbc.Driver");
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","n0m3l0");
            sql = connectionBD.createStatement();
            ResultSet result = sql.executeQuery("select * from Codigo where Compania ='"+ide+"'") ;
            
           
            if(result.next()){
          String compa =  result.getString("Compania");
            String cod =  result.getString("Codigo");
                request.getSession().setAttribute("Co", compa+ "");
                    request.getSession().setAttribute("Cod", cod+""); 
            
            
            
        
        
        response.sendRedirect("http://localhost:8080/SYC/faces/respuestacod.jsp");
        }
            else{
                        response.setContentType("text/html");  
               out.println("<head>");
                out.println("<link rel=\"stylesheet\" href=\"assets/css/main.css\" />");
                out.println("<script src=\"dist/sweetalert.min.js\"></script> <link rel=\"stylesheet\" type=\"text/css\" href=\"dist/sweetalert.css\">");
                out.println("</head>");
                out.println("<body>");
                out.println("<br>");
                out.println("<script type=\"text/javascript\">");  
                out.println("sweetAlert({\n" +
"    title: \"Error!\",\n" +
"    text: \"Codigo no encontrado!\",\n" +
"    type: \"error\"\n" +
"},\n" +
"\n" +
"function () {\n" +
"    window.location.href = 'codigocon.jsp';\n" +
"});"); 
out.println("</script>"); 
            }
                }}
    
        
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(codco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(codco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(codco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(codco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}



