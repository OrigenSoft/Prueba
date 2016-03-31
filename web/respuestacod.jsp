<%-- 
    Document   : respuestacod
    Created on : 15/02/2016, 09:34:00 AM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
              <meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="assets/css/main.css" />
    </head>
    
                      <%
String nom = (String)session.getAttribute("usu");
String compa = (String)session.getAttribute("nomb");
String comp = (String)session.getAttribute("Co");
String cod = (String)session.getAttribute("Cod");

%>
   <body style="background-image:images/car.jpg ">
        <div>
           <header id="header">
					<h1 id="logo">Saving Your Car</h1>
					<nav id="nav">
						<ul>
							<li><a href="principal.jsp">Inicio</a></li>
							<li>
                                                            <a>Siniestro</a>
								<ul>
									<li><a href="registro1.html">Registrar</a></li>
                                                                        <li><a href="Aconsulta.jsp">Buscar</a></li>
								</ul>
							</li>
                                                       
							<li><a href="Aperfil.jsp">Perfil</a></li>
							<li>
                                                              <form method="post" action="cerrar">
                                                                
                                                           <input type="submit" value= "logout" >     
                                                            </form> </span></li>
						</ul>
					</nav>
				</header>
            <br><br><br>
		<center>
                    <h2>El resultado de tu busqueda es </h2>
                    <br>
                    Compa&ntilde;&iacute;a: <%=comp%> 
                            <br>
                    Codigo: <%=cod%>
                </center>
        </div>
   </body>
</html>