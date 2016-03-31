/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
public class logout extends HttpServlet {  
        @Override
        protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {

	
                        response.setHeader("Cache-Control", "no-cache"); 
            response.setHeader("Pragma", "no-cache"); 
                response.setDateHeader("Expires", 0); 

	request.getSession().invalidate();
	response.sendRedirect(request.getContextPath() + "/index.html");
}
}  
