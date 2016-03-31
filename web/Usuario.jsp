
<html>
    <head>
        <title>Saving Your Car</title>
  


        <meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="assets/css/main.css" />
    </head>
    
                      <%
String nom = (String)session.getAttribute("NombreEmpleado");
String compa = (String)session.getAttribute("compa");

%>
    <body style="background-image:images/car.jpg ">
        <div>
            <header id="header">
					<h1 id="logo">Saving Your Car</h1>
					<nav id="nav">
						<ul>
							<li><a href="Usuario.jsp">Inicio</a></li>
							<li>
								<a href="perfil.jsp">Perfil</a>
								
							</li>
							<li><a href="busqueda.html">Buscar</a></li>
							<li>
                                                          
                                                            <form method="post" action="cerrar">
                                                                
                                                           <input type="submit" value= "logout" >     
                                                            </form>    
                                                         
                                               
						</ul>
					</nav>
				</header>
            <br><br><br>
            <section id="banner">
					<div class="content">
						<header>
							<h2>Bienvenido <%=nom%> de la compañia <%=compa%></h2>
							<p><br />
							</p>
						</header>
					</div>
				</section>
		
        </div>
    </body>
</html>
