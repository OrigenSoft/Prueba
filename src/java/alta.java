/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alumno
 */
public class alta extends HttpServlet {

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
   
      
            
        String compania = request.getParameter("Compania");
         String nom = request.getParameter("NombreEmpleado");
          String edad = request.getParameter("edad");
           String sexo = request.getParameter("sexo");
            String correo = request.getParameter("correo");
             String telefono = request.getParameter("telefono");
              String codsec = request.getParameter("codsec");
               String contrasenia = request.getParameter("contrasenia");
               int edad2=Integer.parseInt(edad);
               int telefono2=Integer.parseInt(telefono);
               
             String contr2 = ""; 

 @SuppressWarnings("UnusedAssignment")

 MessageDigest md = null; 

 try { 

 md = MessageDigest.getInstance("MD5"); 

 BigInteger hash = new BigInteger(1, md.digest(contrasenia.getBytes())); 

 contr2 = hash.toString(16); 

 } catch (NoSuchAlgorithmException e) { 

 e.printStackTrace(); 

 }   
 
   
  
          
    
        Connection connectionBD = null;
        Statement sql ;
   
        
     try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.jdbc.Driver");
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","n0m3l0");
            sql = connectionBD.createStatement();
            ResultSet resulte = sql.executeQuery("select * from Codigo where Codigo ='"+codsec+"' and Compania='"+compania+"'");
          if(resulte.next()){
            Class.forName("com.mysql.jdbc.Driver");
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","n0m3l0");
            sql = connectionBD.createStatement();
            
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
"    text: \"Correo ya registrado!\",\n" +
"    type: \"error\"\n" +
"},\n" +
"\n" +
"function () {\n" +
"    window.location.href = 'registro.html';\n" +
"});"); 
out.println("</script>"); 
            
      
            int resu=  sql.executeUpdate("insert into Usuario values('"+compania+"','"+nom+"','"+edad2+"','"+sexo+"','"+correo+"','"+telefono2+"','"+codsec+"','"+contr2+"')");
          if(resu==1){
               response.sendRedirect("http://localhost:8080/SYC/faces/index.html");
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
"    text: \"Codigo o Usuario invalido!\",\n" +
"    type: \"error\"\n" +
"},\n" +
"\n" +
"function () {\n" +
"    window.location.href = 'registro.html';\n" +
"});"); 
out.println("</script>"); 
             
          }
           
        }else{
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
"    text: \"Codigo o Usuario invalido!\",\n" +
"    type: \"error\"\n" +
"},\n" +
"\n" +
"function () {\n" +
"    window.location.href = 'registro.html';\n" +
"});"); 
                out.println("</script>"); 
          }
     }
    }
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
            Logger.getLogger(alta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(alta.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(alta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(alta.class.getName()).log(Level.SEVERE, null, ex);
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
    }// </editor-fold>

}
        
