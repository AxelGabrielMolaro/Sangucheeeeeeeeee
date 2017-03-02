
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	
 	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<!--css y js boostrap-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
	
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	<script src="http://code.jquery.com/jquery.js"></script>
	
	<script type="text/javascript" src="js/funcionalidad.js"></script>
	<link rel="stylesheet" type="text/css" href="css/estilo.css">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/estilo.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="css/bootstrap-theme.min.css"/>">
	<script type="text/javascript" src="<c:url value="/css/estilo.css"/>"></script>
	
	<title>Axel Molaro</title>



</head>
<body>
	<div class="container-fluid contenido">
		


		<div class="row fondo-modificar-cantidad-stock">
				

			<div class="row">
			
			<div class="col-md-offset-5 col-md-1 datos-stock"> 

			INGREDIENTE ${ingredienteAModificar.getNombre()} CANTIDAD  ${ingredienteAModificar.getCantidad()} TIPO  ${ingredienteAModificar.getTipo()}

			</div>


			</div>	
			
			<div class="row logo"> 
				<div class="col-md-offset-2 col-md-3  ">
					
					<div class="formulario-agregar-cantidad-stock">
						<h4 >Modificar ingrediente</h4>
						<form:form method="post" modelAttribute="ingredienteAModificar" action="/sitio-polo/modificarStock2/${ingredienteAModificar.getNombre()}">
							
							
							

							<label  for="">Cantidad</label>
							<form:input type="text"  class="inp form-control" path="cantidad" onkeypress="return justNumbers(event)" ></form:input>
							
							<label for="">Tipo</label>
							<form:select path="tipo" class="form-control">
								<option value="INGREDIENTE">INGREDIENTE</option>
								<option value="CONDIMENTO">CONDIMENTO</option>
							</form:select>
							precio
							<form:input path="precio" class="form-control"/>
							<input type="submit"  class="form-control btn btn-success botones-Stock col-md-10" value="Modificar"></input>
						</form:form>
					</div>

				</div>
				
				
				<div class="row">
					<div class="col-md-offset-2">
						
						<a href="/sitio-polo/listaDeIngredientes">
							
							<input type="button" class="btn btn-warning col-md-9" value="Ir al stock" ></input>


						</a>
					</div>

				</div>

			</div>	
			

		</div>

	</div>	
</body>
</html>