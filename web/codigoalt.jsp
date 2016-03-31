<%-- 
    Document   : codigoalt
    Created on : 11/02/2016, 09:29:52 AM
    Author     : Alumno
--%>

<html>
    <head>
        <title>Saving Your Car</title>
  


        <meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="assets/css/main_1.css" />
        <script>
            
            function makeid()
{
    var texto = "";
    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    for( var i=0; i < 10; i++ )
        texto += possible.charAt(Math.floor(Math.random() * possible.length));
document.getElementById("Codigo").value = texto;


    return texto;
}
             function validacp(e)
            {
                var keycar;
                if(window.event)
                    keycar = e.keyCode;
                else
                    if(e.which)
                        keycar=e.which;
                if(keycar>=48 && keycar<=57)
                    return true;
                else
                    return false;
                
            }
            function valida(e)
            {
                var keylet;
                if(window.event)
                    keylet = e.keyCode; /*IE*/
                else
                    if(e.which)
                        keylet = e.which; //Netscape firefox opera
                
                if((keylet>=97&&keylet<=122)||keylet===8 ||keylet===32 || keylet===239 ||keylet>=65&&keylet<=90 ||keylet>=160&&keylet<=163)
                  return true;
                else
                  return false;
            }
                    
            
            
            </script>
    </head>
    
                      <%
String nom = (String)session.getAttribute("usu");
String compa = (String)session.getAttribute("nomb");

%>
   <body style="background-image:images/car.jpg" onload="makeid()" >
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
                                                        
                                                        <li>
                                                      
									<a>Codigo</a>
                                                                        <ul>
                                                                            <li> <a href="codigoalt.jsp">Alta</a> </li>
                                                                            <li> <a href="codigocon.jsp">Consulta</a>  </li>
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
		<form method="post" action="coda" class="container 50%">
					<div align="center"><h2><b>CODIGO</b></h2>
						
							
                                                      
                                                        <form method="post" action="coda">
                                                            <input type="text" id="Compania" name="Compania" placeholder="Compa&ntilde;&iacute;a" required/><br>
                                                    
                                                       <br>
<!--                                                       <div><h2>Fecha</h2></div><div disabled>
                                                            <input type="text" maxlength="2" size="2" name="vipoliza1" onKeyPress="return validacp(event)" id="vipoliza1" value="" placeholder="00" required/>:
                                                            <input type="text" maxlength="2" size="2" name="vipoliza2" onKeyPress="return validacp(event)" id="vipoliza2" value="" placeholder="00" required/>:
                                                            <input type="text" maxlength="2" size="2" name="vipoliza3" onKeyPress="return validacp(event)" id="vipoliza3" value="" placeholder="00" required/><br>
                             
                                                        </div>-->
                                                       <br><br>
                                                    
                                                       <input type="text" id="Codigo" name="Codigo" value=texto   readOnly required/> 
                                                      
                                                     <input type="email" id="correo" name="correo" value="" placeholder="Correo del cliente" required>  
                                                       <br><br>
                                             
                                                       <input type="email" id="correo2" name="correo2" value="" placeholder="Correo Admidnistrador" required>  
                                                       <br><br>
                                                       <input type="password" id="pass" name="pass" value="" placeholder="Contraseña Administrador" required>  
                                                       <br><br>
                                                       <input type="submit">
                                                       
                                                       
							<p><br />
							</p>
						
					</div>
                      </form>
				
        </div>
                        <script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
		
       
    </body>
</html>


