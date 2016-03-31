<html>
    <head>
        <title>Saving Your Car</title>
        <meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="assets/css/main.css" />
    </head>
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
		
                    <div align="center"><h2>Información del usuario</h2></div>
                    
                    <%
String nom = (String)session.getAttribute("NombreEmpleado");
String compa= (String)session.getAttribute("compa");
String edad = (String)session.getAttribute("edad");
String sexo = (String)session.getAttribute("sexo");
String correo = (String)session.getAttribute("correo");
String telefono = (String)session.getAttribute("telefono");








%>

<br>
<br>
<center>
<table>
    <tr> 
        <td><font size="4"><b>Nombre</b></td>
        <td><%=nom%> </td></tr>
    <tr> 
        <td><font size="4"><b>Compañía</b></td>
        <td><%=compa%> </td></tr>
    <tr>
        <td><font size="4"><b>Edad</b></td>
        <td><%=edad%> </td></tr>
    <tr>
        <td><font size="4"><b>Sexo</b></td>
        <td><%=sexo%> </td></tr>
    <tr>
        <td><font size="4"><b>Correo</b></td>
        <td><%=correo%> </td></tr>

</table>
</center>





                
        </div>
    </body>
</html>

