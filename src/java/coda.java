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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
/**
 *
 * @author Alumno
 */
public class coda extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
   
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     
       
        java.util.Date date=new java.util.Date();
         
        Timestamp now = new Timestamp(date.getTime());
        String compa = request.getParameter("Compania");
     // String fecha = request.getParameter("fecha");
        
       String cod = request.getParameter("Codigo");
       String correo=request.getParameter("correo");
        String correo2=request.getParameter("correo2"); 
        String pass=request.getParameter("pass");
        
       
        try (PrintWriter out = response.getWriter()) {
           
        Connection connectionBD = null;
        Statement sql ;
            
        Class.forName("com.mysql.jdbc.Driver");
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","n0m3l0");
            sql = connectionBD.createStatement();
              out.println(cod);
                out.println(compa);
                  out.println(now);
            int resu=  sql.executeUpdate("insert into Codigo values('"+cod+"','"+compa+"','"+now+"')");
          if(resu==1){
              
              
      

   final String miCorreo = correo2; //correo del administrador desde que seran enviados los mensajes
    final String miContraseña = pass; //contraseña del correo
    final String servidorSMTP = "smtp.gmail.com";
    final String puertoEnvio = "465";
    String mailReceptor = correo;
    String asunto = "codigo"; 
    String cuerpo = "Hola empleado de la compañia " + compa +"\n"+
                     "Para que puedas registrarte necesitaras un codigo de verificación, el cual es: "+ cod + "\n"+
                      "espero puedas registarte, hasta luego"; //mensaje que sera enviado en el correro
  
               Properties props = new Properties();
        props.put("mail.smtp.user", miCorreo);
        props.put("mail.smtp.host", servidorSMTP);
        props.put("mail.smtp.port", puertoEnvio);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", puertoEnvio);
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        
        SecurityManager security = System.getSecurityManager();

        try {
            Authenticator auth = new autentificadorSMTP();
            
            
            
            Session session = Session.getInstance(props, 
       new javax.mail.Authenticator() {


 

       protected PasswordAuthentication getPasswordAuthentication()  {

 

       return new PasswordAuthentication(correo2,pass);

 

       }

       });

 

            // session.setDebug(true);

            MimeMessage msg = new MimeMessage(session);
            msg.setText(cuerpo);
            msg.setSubject(asunto);
            msg.setFrom(new InternetAddress(miCorreo));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    mailReceptor));
            Transport.send(msg);
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    
    
    
             
               response.sendRedirect("http://localhost:8080/SYC/faces/principal.jsp");
          }
        
          else{
              out.println("<script type=\"text/javascript\">");  
out.println("alert('el siniestro tecleado no existe');");
  out.println("document.location=('http://localhost:8080/SYC/faces/codigoalt.jsp')");
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
            Logger.getLogger(coda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(coda.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(coda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(coda.class.getName()).log(Level.SEVERE, null, ex);
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
