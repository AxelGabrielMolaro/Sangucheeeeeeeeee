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
      <div class="col-md-4">
        <form:form action="/sitio-polo/agregarIngrediente"  modelAttribute="ingrediente"  method="POST" name="form">
          <div class="form-group">
            <label for="" class="label-control col-md-12">Nombre</label>
            <div class="col-md-12">
              <form:input path="nombre" type="text" class="form-control col-md-12" name="" value="" />
            </div>
          </div>
          <div class="form-group">
            <label for="" class="label-control col-md-12">Tipo</label>
            <div class="col-md-12">
              <form:select path="tipo" class="form-control" name="">
                  <option value="INGREDIENTE">Ingrediente</option>
                  <option value="CONDIMENTO">Condimento</option>

              </form:select>
            </div>
          </div>
           <div class="form-group ">
            <label for="" class="label-control col-md-12">Precio unitario</label>

            <div class="col-md-12 col-xs-12">
              <form:input path="precio" type="text" class="form-control " name="" value="0" id="cantidad"  onkeypress="return justNumbers(event)"/>
            </div>

          </div>
          <div class="form-group ">
            <label for="" class="label-control col-md-12">Cantidad</label>

            <div class="col-md-12 col-xs-12">
              <form:input path="cantidad" type="text" class="form-control " name="" value="0" id="cantidad" onkeypress="return justNumbers(event)" />
            </div>

          </div>
         
          <div class="form-group col-md-12">
              <input type="submit" class="btn btn-success form-control submitAgrgarIngredienteASanguche" value="Agregar ingrediente">
              <div class="alert-warning">
                ${exepcion }
              </div>
          </div>

        </form:form>

      </div>
      <div class="col-md-8">
        <div class="col-md-12 tablaArmarSanguche">
          <table class="table ">

              <thead>
                <th>Ingrediente</th>
                <th>Precio U</th>
                <th>Cantidad</th>
                <th>Tipo</th>
                <th>Modificar</th>
                <th>Eliminar</th>
              </thead>
              <tbody>
               	<c:forEach var="list" items="${listaDeIngredientesStock}">
               		<tr>
               			<td>${list.getNombre()}</td>
               			<td>$ ${list.getPrecio()}</td>
               			<td>${list.getCantidad()}</td>
               			<td>${list.getTipo()}</td>
               			<td><a href="/sitio-polo/modificarStock/${list.getNombre()}"><input type="button" class="btn btn-warning"></a></td>
               			<td><a href="/sitio-polo/eliminarStock/${list.getNombre()}"><input type="button" class="btn btn-danger"></a></td>
               		</tr>
               	</c:forEach>
              </tbody>
          </table>
        </div>
        <div class="col-md-12">
          <a href="/sitio-polo/vaciarStock"><input type="text" name="" value="Vaciar Stock" class="btn btn-warning col-md-3 col-xs-12">
          <a href="/sitio-polo/eliminarTodoElStock">  <input type="text" name="" value="Eliminar Stock" class="btn btn-danger col-md-3 col-xs-12"></a>
        


        </div>

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
	 <script type="text/javascript" src="<c:url value="/js/funcionalidad.js"/>"></script>
</body>
</html>