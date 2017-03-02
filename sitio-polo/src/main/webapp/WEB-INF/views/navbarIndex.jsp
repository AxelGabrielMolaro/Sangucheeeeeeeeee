<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="<c:url value="css/estilosGenerales.css"/>">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
      <div class="navbar-header logo">
        <a class="navbar-brand" href="#">
          <img alt="Logo" src="http://img.recetas-de-cocina.net.s3.amazonaws.com/wp-content/uploads/2013/05/recetas-sanguche-3.jpg" height="100%">

        </a>
        <a class="navbar-brand" href="#">
          <span class="Titulo ">Sangucheishon</span>
        </a>
      </div>
      <div class="col-md-offset-4 formularioLogin">
          <form:form action="/sitio-polo/login" modelAttribute="usuario" class="form-horizontal" method="POST">
              <div class="form-group col-md-5">
                  <label for="" class="control-label col-md-4">Mail</label>
                  <div class="col-md-8">
                    <form:input path="mail" class="form-control"/>
                  </div>
              </div>
              <div class="form-group col-md-5">
                  <label for="" class="control-label  col-md-4">Contraseña</label>
                  <div class="col-md-8">
                    <form:input path="contraseña" type="password" class="form-control"/>
                  </div>
              </div>
              <div class="form-group col-md-2 ">
                <div class="col-md-12  col-xs-offset-2 ">
                  <input type="submit" class="btn btn-success col-xs-10 " value="Ingresar"/>
                  ${exepcionLogin}
                </div>

              </div>
          </form:form>
      </div>

    </div>

</body>
</html>