<%-- 
    Document   : respuesta
    Created on : 2/12/2015, 07:24:09 AM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
		<div >
                    <center>
                    <h2>El resultado de tu busqueda es </h2>
                    
                    
                    <%
String Idsiniestro = (String)session.getAttribute("IdSiniestro");
String compania = (String)session.getAttribute("Compania");
String correoU = (String)session.getAttribute("correoU");
String idvehiculo = (String)session.getAttribute("IdVehiculo");
String asegurado = (String)session.getAttribute("asegurado");
String poliza = (String)session.getAttribute("poliza");
String vigenciapol = (String)session.getAttribute("VigenciaPoliza");
String fechaSiniestro = (String)session.getAttribute("fechaSiniestro");
String fechaapertura = (String)session.getAttribute("fechaAperturaCaso");
String fechaclausura = (String)session.getAttribute("fechaClausuraCaso");
String informe = (String)session.getAttribute("Informe");





String idV = (String)session.getAttribute("idV");
String NombreV = (String)session.getAttribute("NombreV");
String marca = (String)session.getAttribute("marca");
String modelo = (String)session.getAttribute("modelo");
String placas= (String)session.getAttribute("placas");
String numS= (String)session.getAttribute("numS");
String numM= (String)session.getAttribute("numM");
String costo = (String)session.getAttribute("costo");

%>


<h1>Datos del vehiculo</h1>
<table>
    <tr>
        <td><font size="4"><b>ID vehículo</b></td>
        <td><%=idV%> </td></tr>
    <tr>
        <td><font size="4"><b>Vehículo</b></td>
        <td><%=NombreV%> </td></tr>
    <tr>
        <td><font size="4"><b>Marca</b></td>
        <td><%=marca%></td></tr>
    <tr>
        <td><font size="4"><b>Modelo</b></td>
        <td><%=modelo%></td></tr>
    <tr>
        <td><font size="4"><b>Placas</b></td>
        <td><%=placas%></td></tr>
    <tr>
        <td><font size="4"><b>Número de serie</b></td>
        <td><%=numS%></td></tr>
    <tr>
        <td><font size="4"><b>Número de motor</b></td>
        <td><%=numM%></td></tr>
    <tr>
        <td><font size="4"><b>Costo</b></td>
        <td><%=costo%></td></tr>

</table>
                    </center>

<br>
<br>
<center>
<h1>Datos del usuario</h1>
<table>
    <tr>
        <td><font size="4"><b>Compañía</b></td>
        <td><%=compania%> </td></tr>
    <tr>
        <td><font size="4"><b>ID siniestro</b></td>
        <td><%=Idsiniestro%></td></tr>
    <tr>
        <td><font size="4"><b>Correo</b></td>
        <td><%=correoU%></td></tr>
    <tr>
        <td><font size="4"><b>ID vehículo</b></td>
        <td><%=idvehiculo%></td></tr>
    <tr>
        <td><font size="4"><b>Asegurado</b></td>
        <td><%=asegurado%></td></tr>
    <tr>
        <td><font size="4"><b>Poliza de garantía</b></td>
        <td><%=poliza%></td></tr>
    <tr>
        <td><font size="4"><b>Vigencia de la poliza</b></td>
        <td><%=vigenciapol%></td></tr>
    <tr>
        <td><font size="4"><b>Fecha del siniestro</b></td>
        <td><%=fechaSiniestro%></td></tr>
    <tr>
        <td><font size="4"><b>Apertura del caso</b></td>
        <td><%=fechaapertura%></td></tr>
    <tr>
        <td><font size="4"><b>Cierre del caso</b></td>
        <td><%=fechaclausura%></td></tr>

</table>
<br>
<br>
</center>
<center>
    <h1>Informe<h1>
    <table> <tr> <td> <%=informe%> </tr>  </td> </table>  
         <center></div>
        </div>
    </body>
</html>

