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
 * @author Alumno
 */
public class sesion extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        
    
        /**
        wey esto esp para el hash
      */
    
        response.setContentType("text/html;charset=UTF-8");
                
                 HttpSession sesion = request.getSession();

           
                
                
   Connection connectionBD = null;
        Statement sql = null;
        String email = request.getParameter("email");
         String contr = request.getParameter("contr");
         
      

 String contr2 = ""; 

 @SuppressWarnings("UnusedAssignment")

 MessageDigest md = null; 

 try { 

 md = MessageDigest.getInstance("MD5"); 

 BigInteger hash = new BigInteger(1, md.digest(contr.getBytes())); 

 contr2 = hash.toString(16); 

 } catch (NoSuchAlgorithmException e) { 

 e.printStackTrace(); 

 } 
    if ("root@hotmail.com".equals(email)&&"pass".equals(contr))
    {
       
        String usu="root@hotmail.com";
        String nomb="bustos";
        String tel="54684864";
        String edad="50";
        sesion.setAttribute("usu", usu);
        sesion.setAttribute("nomb", nomb);
        sesion.setAttribute("tel", tel);
        sesion.setAttribute("edad", edad);
        
         response.sendRedirect("http://localhost:8080/SYC/faces/principal.jsp");
    }
        else
    
    {
    
        
        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.jdbc.Driver");
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","n0m3l0");
            sql = connectionBD.createStatement();
            ResultSet result = sql.executeQuery("select * from Usuario where correo ='"+email+"' and contraseña ='"+contr2+"'");
            
            if(result.next() && sesion.getAttribute("usuario") == null){
           
                 String compa = result.getString("Compania");
                  String nom = result.getString("NombreEmpleado");
                  String edad=result.getString("edad");
                  String sexo=result.getString("sexo");
                  String correo=result.getString("correo");
                  String telefono=result.getString("telefono");
                 
       
         sesion.setAttribute("NombreEmpleado", nom);
         sesion.setAttribute("compa", compa);
         sesion.setAttribute("edad", edad);
         sesion.setAttribute("sexo", sexo);
         sesion.setAttribute("correo", correo);
         sesion.setAttribute("telefono", telefono);
         
response.sendRedirect("http://localhost:8080/SYC/faces/Usuario.jsp");

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
"    text: \"Usuario o contraseña invalida!\",\n" +
"    type: \"error\"\n" +
"},\n" +
"\n" +
"function () {\n" +
"    window.location.href = 'index.html#two';\n" +
"});"); 
                //out.println(" window.location.replace(\"http://localhost:8080/SYC/faces/index.html#two\");");
                
                out.println("</script>"); 
//                response.sendRedirect("http://localhost:8080/SYC/faces/index.html#two");
//                out.println("<script type=\"text/javascript\">");  
//                out.println("swal(\"Here's a message!\")");  
//                out.println("</script>");
                 
            }
        }
    }
    }
     protected void processRequestGET(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        //me llega la url "proyecto/login/out"
        String action=(request.getPathInfo()!=null?request.getPathInfo():"");
        HttpSession sesion = request.getSession();
        if(action.equals("/out")){
            sesion.invalidate();
            response.sendRedirect("http://localhost:8080/SYC/faces/index.html");
        
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(sesion.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(sesion.class.getName()).log(Level.SEVERE, null, ex);
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

    
