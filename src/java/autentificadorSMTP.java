
import javax.mail.PasswordAuthentication;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumno
 */

     class autentificadorSMTP extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("wedart148@gmail.com", "secretajuanito");
        }
    
}
