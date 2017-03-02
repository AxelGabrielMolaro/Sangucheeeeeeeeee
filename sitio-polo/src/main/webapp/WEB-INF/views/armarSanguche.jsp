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
	
	<jsp:include page='navbarSinLogin.jsp'>
	  <jsp:param name='navbarSinLogin' value='navbarSinLogin.jsp'/>
	</jsp:include>
	
	
	<div class="container-fluid">
      <div class="col-md-6">
        <form:form action="/sitio-polo/agregarIngredienteSanguche" modelAttribute="ingrediente" class="form">
          <div class="form-group">
            <label for="" class="label-control col-md-12">Ingrediente</label>
            <div class="col-md-12">
              <form:select class="form-control" path="nombre" name="">
                 	<option value="ninguno000" >Ninguno</option>
                 	<c:forEach var="list" items="${listaDeIngredientesStock}">
                 		
                 		<option value="${list.getNombre()}">${list.getNombre()} c: ${list.getCantidad()}</option>
                 	</c:forEach>

              </form:select>
            </div>
          </div>
          <div class="form-group ">
            <label for="" class="label-control col-md-12">Cantidad</label>

            <div class="col-md-10 col-xs-12">
              <form:input  path="cantidad" type="text" class="form-control " name="" value="0"  readonly="true"/>
            </div>
            <div class="col-md-2 col-xs-12">
              <input type="button" name="btn  " value="+" class="btn btn-success col-xs-6 " onclick="aumentarValueEnUno('cantidad')">
              <input type="button" name="btn   " value="-" class="btn btn-danger col-xs-6" onclick="disminuirValueEnUno('cantidad')">
            </div>
          </div>
          <div class="form-group col-md-12">
              <input type="submit" class="btn btn-success form-control submitAgrgarIngredienteASanguche" value="Agregar ingrediente al sánguche">
              <div class="alert-warning">
                ${exepcion}
              </div>
          </div>

        </form:form>

      </div>
      <div class="col-md-6">
        <div class="col-md-12 tablaArmarSanguche">
          <table class="table ">

              <thead>
                <th>Ingrediente</th>
                <th>Cantidad</th>
                <th>Tipo</th>
                 <th>Precio</th>
                <th>Eliminar</th>
              </thead>
              <tbody>
                <c:forEach var="list" items="${listaDeIngredientesSanguche}">
                  <tr>
	                  <td>${list.getNombre()}</td>
	                  <td>${list.getCantidad()}</td>
	                  <td>${list.getTipo()}</td>
	                  <td>${list.getPrecio()}</td>
	                  <td><a href="/sitio-polo/eliminarSanguche/${list.getNombre()}">Eliminar</a> </td>
                </tr>
                </c:forEach>
                <tr>
                	Precio Total: $ ${precioTotal} 
                </tr>
               
              </tbody>
          </table>
        </div>
        <div class="col-md-12">
         <form:form action="/sitio-polo/comprarSanguche" modelAttribute="direccion" method="POST" class="form">
            <div class="form-group col-md-6">
              <label for="" class="control-label col-md-12">Calle</label>
              <div class="">
                 <form:input path="calle" class="form-control"/>
              </div>
            </div>
            <div class="form-group col-md-6">
              <label for="" class="control-label col-md-12">Numero</label>

              <div class="">
                <form:input path="numero" class="form-control"  onkeypress="return justNumbers(event)" />
              </div>
              
            </div>
            
            <a href="/sitio-polo/vaciarSanguche/${list.getNombre()}"><input type="button" name="" value="Vaciar sanguche" class="col-md-offset-6 col-xs-12 col-md-3 btn btn-warning"></a>
            <input type="submit" name="" value="Comprar sanguche" class="btn btn-success col-md-3 col-xs-12">
           
            
           
            <div class="alert-warning col-md-12">
              ${exepcion2}
            </div>
          </form:form>  
        </div>

      </div>

    </div>
	
	
	
	<!-- Scripts-->
    <script type="text/javascript" src="js/bootstrap.min.js"> </script>
    <script type="text/javascript" src="js/bootstrap.js"> </script>
    <script type="text/javascript" src="js/npm.js"> </script>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="<c:url value="/js/misFunciones.js"/>"></script>
    <script src="js/w3data.js"></script>
  	<script src="carrussel.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	<script src="http://code.jquery.com/jquery.js"></script>
	<script type="text/javascript" src="<c:url value="/js/funcionalidad.js"/>"></script>
</body>
</html>		
		
