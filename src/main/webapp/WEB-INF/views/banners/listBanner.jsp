<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de imagenes del banner</title>

    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/banners/save" var="urlForm"></spring:url>
    <spring:url value="/" var="urlRoot"/>
    <link rel="stylesheet" href="${urlPublic}/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${urlPublic}/bootstrap/css/theme.css"/>

</head>

<body>

<!-- Fixed navbar -->
<jsp:include page="../includes/menu.jsp"></jsp:include>

<div class="container theme-showcase" role="main">

    <h3>Listado de imagenes del Banner</h3>

    <a href="${urlRoot}banners/create" class="btn btn-success" role="button" title="Nuevo Banner" >Nuevo</a><br><br>

    <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Fecha Publicacion</th>
                <th>Nombre Archivo</th>
                <th>Estatus</th>
                <th>Opciones</th>
            </tr>
            <c:forEach items="${banners}" var="banner">
                <tr>
                        <td>${banner.id}</td>
                        <td>${banner.titulo}</td>
                        <td><fmt:formatDate pattern="dd-MM-yyyy" value="${banner.fecha}"/></td>
                        <td>${banner.archivo}</td>
                        <td><span class="label label-success">${banner.status}</span></td>
                        <td>
                            <a href="#" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
                            <a href="#" class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
                        </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <hr class="featurette-divider">

    <!-- FOOTER -->
    <jsp:include page="../includes/footer.jsp"></jsp:include>

</div> <!-- /container -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${urlPublic}/bootstrap/js/bootstrap.min.js" rel="stylesheet"></script>
</body>
</html>

