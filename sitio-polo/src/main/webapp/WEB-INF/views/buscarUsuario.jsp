<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
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
	<jsp:include page='navbarAdminMaster.jsp'>
	  <jsp:param name='navbarAdminMaster' value='navbarAdminMaster.jsp'/>
	</jsp:include>

	<div class="contariner-fluid">
		<div class="col-md-4">
		<form:form modelAttribute="usuario" method="POST" action="/sitio-polo/buscarUsuario">
		 <div class="form-group">
            <label for="" class="label-control col-md-12">Buscar usuario por Mail</label>
         <div>
           	<form:input path="mail" class="form-control"/>
          </div>
          </div>
         
          <div class="form-group col-md-12">
              <input type="submit" class="btn btn-success form-control submitAgrgarIngredienteASanguche" value="Buscar usuario">
              <div class="alert-warning">
                Error
              </div>
          </div>
			
		
		</form:form>
         
        

      </div>
      <div class="col-md-8">
        <div class="col-md-12 tablaArmarSanguche">
          <table class="table ">

              <thead>
             	<th>Mail</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Tipo</th>
                <th>Contraseña</th>
                <th>Modificar</th>
                <th>Eliminar</th>
              </thead>
              <tbody>
                
                <c:forEach var="list" items="${listaDeUsuariosBuscados}">
                	<tr>
	                  <td>${list.getMail()}</td>
	                  <td>${list.getNombre()}</td>
	                  <td>${list.getApellido()}</td>
	                  <td>${list.getTipoUsuario()}</td>
	                  <td>${list.getContraseña()}</td>
	                  <td><a href="/sitio-polo/modificarUsuario/${list.getMail()}">Modificar</a> </td>
	                  <td><a href="/sitio-polo/eliminarUsuario/${list.getMail()}">Eliminar</a> </td>
               		</tr>
               		
                </c:forEach>
              	<tr>
              		<td>Error: exepcion</td>
              	</tr>
              </tbody>
          </table>
        </div>
        <div class="col-md-12">
          <input type="text" name="" value="Eliminar TODOS los usuarios" class="btn btn-danger col-md-3 col-xs-12">


        </div>

      </div>

		
	</div>

    <!-- Scripts-->
    <script type="text/javascript" src="js/bootstrap.min.js"> </script>
    <script type="text/javascript" src="js/bootstrap.js"> </script>
    <script type="text/javascript" src="js/npm.js"> </script>
    <script type="text/javascript" src="jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	<script src="http://code.jquery.com/jquery.js"></script>
</body>
</html>