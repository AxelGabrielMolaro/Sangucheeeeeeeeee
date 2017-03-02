<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
	
 
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

	<!--  date -->
	
<link rel="stylesheet" href="resources/css/jquery-ui.css" type="text/css">
<link rel="stylesheet" href="resources/css/custom.css" type="text/css">
<script type="text/javascript" src="resources/jquery/jquery-ui.min.js"></script>
	<title>Home</title>



</head>
<body>
	<jsp:include page='navbarIndex.jsp'>
	  <jsp:param name='navbarIndex' value='navbarIndex.jsp'/>
	</jsp:include>
	<hr>
    <div class="container-fluid">
      <div class="col-md-6 col-xs-12">
        <div class="col-md-12 ">
            <img src="https://static-latercera-qa.s3.amazonaws.com/wp-content/uploads/sites/7/20140205/1894153.jpg " class=" logotipo col-xs-12 col-md-11"  alt="">
        </div>


      </div>

      <div class="col-md-6 col-xs-12">
        <div class="panel panel-success ">
          <div class="panel panel-heading">
            <div class="panel-title">
              ¿Desea registrarse?
            </div>
          </div>
          <div class="panel-body">
            <form:form modelAttribute="usuario" id="formularioRegistro" action="/sitio-polo/crearUsuario" class="form-vertical" method="POST">
                
              <div class="form-group col-md-6">
                <label for="" class="label-control">Nombre</label>
                <div>
                  <form:input path="nombre" type="text" class="form-control "/>



                </div>
              </div>
              <div class="form-group col-md-6">
                <label for="" class="label-control">Apellido</label>
                <div>
                  <form:input path="apellido" type="text" class="form-control"/>
                </div>
              </div>
              <div class="form-group ocultar" >
                <label for="" class="label-control" >Fecha de nacimiento</label>

                <div>
                  <form:input path="fechaDeNacimiento" type="date"  name="fecha" value="2000-01-01" class="form-control date-picker" />
                  
                </div>
              </div>
              <div class="form-group">
                <label for="" class="label-control">Mail</label>
                <div>
                  <form:input type="text" path="mail" class="form-control"/>
                </div>
              </div>
			 <div class="form-group ocultar">
                <label for="" class="label-control ">tipo</label>
                <div>
                  <form:input type="text" path="tipoUsuario" class="form-control" value="CLIENTE"/>
                </div>
              </div>
              <div class="form-group">
                <label for="" class="label-control">Contraseña</label>
                <div>
                  <form:input path="contraseña" type="text" class="form-control"/>
                </div>
              </div>
              <div class="form-group">
                <label for=""  class="label-control">Repetir contraseña</label>
                <div>
                  <form:input path="contraseña2" type="text" class="form-control"/>
                </div>
              </div>
             
              <input type="submit" class="btn btn-success" value="Registrarse">
              
            </form:form>
          </div>
          <div class="panel-footer ">
            ${exepcion}
              ${RegistroSatisfactorio}
          </div>

        </div>
      </div>
    </div>


    <!-- Scripts-->
    <script type="text/javascript" src="<c:url value="js/bootstrap.min.js"/>"> </script>
    <script type="text/javascript" src="<c:url value="js/bootstrap.js"/>"> </script>
    <script type="text/javascript" src="<c:url value="js/npm.js"/>"> </script>
    <script type="text/javascript" src="<c:url value="js/jquery-3.1.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="js/bootstrap.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="js/jquery-1.11.3.min.js"/>"></script>
	 <script type="text/javascript" src="<c:url value="js/validarFormularios.js"/>"></script>
	  <script type="text/javascript" src="<c:url value="http://code.jquery.com/jquery.js"/>"></script>
	<script type="text/javascript" src="<c:url value="js/misFunciones"/>"></script>




    <script src="js/w3data.js"></script>
  <script src="carrussel.js" charset="utf-8"></script>

    <script>
    
        $( "#date" ).datepicker();
     
    </script>
	

		
</body>
</html>