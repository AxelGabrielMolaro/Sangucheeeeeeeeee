<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
	
 	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<!--css y js boostrap-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
	

	

	<link rel="stylesheet" type="text/css" href="css/estilo.css">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/estilo.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="css/bootstrap-theme.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="css/estilosGenerales.css"/>">
	<title>Axel Molaro</title>



</head>
<body>
	
	
	 <jsp:include page='navbarAdminStock.jsp'>
	  <jsp:param name='navbarAdminStock' value='navbarAdminStock.jsp'/>
	</jsp:include>
    <div class="container-fluid">
    	<div class="col-md-offset-3 col-md-6">
			<table class="table">
				
				<thead>
					Lista de ventas
					<th>Numero</th>
					<th>Sanguche</th>
					<th>Precio</th>
					<th>Direccion</th>
				</thead>
				<tbody>
				<c:forEach var="list" items="${listaDeVentas}">
					<tr>
						<td>${list.getNumeroDePedido()}</td>
						<td>
						
							<c:forEach var="list2" items="${list.getSanguche().getListaSanguche()}">
								${list2.getNombre()} , 
							</c:forEach>
						
						 </td>
						 
						<td> $ ${list.getSanguche().getPrecioTotal()} </td>
						<td> ${list.getDireccion().getCalle()} ${list.getDireccion().getNumero()} </td>
					</tr>
				</c:forEach>
					
				</tbody>
				</table>
			</table>
		</div>		
      

    </div>
     <!-- Scripts-->
    <script type="text/javascript" src="js/bootstrap.min.js"> </script>
    <script type="text/javascript" src="js/bootstrap.js"> </script>
    <script type="text/javascript" src="js/npm.js"> </script>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="js/misFunciones.js"></script>
    <script src="js/w3data.js"></script>
  	<script src="carrussel.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	<script src="http://code.jquery.com/jquery.js"></script>
	<script type="text/javascript" src="js/funcionalidad.js"></script>
</body>
</html>