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
public class alta2 extends HttpServlet {

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
   
      String nomVehi = request.getParameter("nombreVehiculo");
               String mar = request.getParameter("marca");
                String mod= ((String)request.getParameter("modelo"));
                    String plac = request.getParameter("placas");
                    String nose = request.getParameter("numeroSerie");
                    String nomo = request.getParameter("numeroMotor");
                    String cos = request.getParameter("costo");
               
               int cos2=Integer.parseInt(cos);
            
        String idSin = request.getParameter("idSiniestro");
         String compania = request.getParameter("compania");
         String correo = request.getParameter("correoU");
          String asegurado = request.getParameter("asegurado");
           String poliza = request.getParameter("poliza");
           String vipoliza1 = request.getParameter("vipoliza1");
           String vipoliza2 = request.getParameter("vipoliza2");
           String vipoliza3 = request.getParameter("vipoliza3");
           
           String fesi1 = request.getParameter("fesi1");
           String fesi2 = request.getParameter("fesi2");
           String fesi3 = request.getParameter("fesi3");
           
           String feap1 = request.getParameter("feap1");
           String feap2 = request.getParameter("feap2");
           String feap3 = request.getParameter("feap3");
           
           String feclau1 = request.getParameter("feclau1");
           String feclau2 = request.getParameter("feclau2");
           String feclau3 = request.getParameter("feclau3");
           
           String info = request.getParameter("info");
            
             String idVehi = request.getParameter("idVehiculo");
            
               int idVehi2=Integer.parseInt(idVehi);
              
               int idsin2=Integer.parseInt(idSin);
               
               

    
        Connection connectionBD = null;
        Statement sql ;
   
        
   try (PrintWriter out = response.getWriter()) {
//           out.println(idsin2);
//             out.println(compania);
//             out.println(correo);
//             out.println(idVehi2);
//             out.println(asegurado);
//             out.println(poliza);
//             out.println(vipoliza1);
//             out.println(vipoliza2);
//             out.println(vipoliza3);
//             out.println(fesi1);
//             out.println(fesi2);
//             out.println(fesi3);
//             out.println(feap1);
//             out.println(feap2);
//             out.println(feap3);
//             out.println(feclau1);
//             out.println(feclau2);
//             out.println(feclau3);
//             out.println(info);
            Class.forName("com.mysql.jdbc.Driver");
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","n0m3l0");
            sql = connectionBD.createStatement();
            int resu=  sql.executeUpdate("insert into Vehiculo values('"+idVehi2+"','"+nomVehi+"','"+mar+"','"+mod+"','"+plac+"','"+nose+"','"+nomo+"','"+cos2+"')");
           out.println("hola");
          if(resu==1){
              Class.forName("com.mysql.jdbc.Driver");
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","n0m3l0");
            sql = connectionBD.createStatement();
           int resu2=sql.executeUpdate("insert into siniestro values('"+idsin2+"','"+compania+"','"+correo+"','"+idVehi2+"','"+asegurado+"','"+poliza+"','"+vipoliza1+":"+vipoliza2+":"+vipoliza3+"','"+fesi1+":"+fesi2+":"+fesi3+"','"+feap1+":"+feap2+":"+feap3+"','"+feclau1+":"+feclau2+":"+feclau3+"','"+info+"')");
           if (resu2==1)
                response.sendRedirect("http://localhost:8080/SYC/faces/principal.jsp");
            }
          else
          {
              
            
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
        
