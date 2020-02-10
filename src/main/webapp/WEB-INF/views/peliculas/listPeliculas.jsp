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
    <title>Listado de Peliculas</title>

    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/peliculas/index" var="urlForm"></spring:url>
    <link rel="stylesheet" href="${urlPublic}/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${urlPublic}/bootstrap/css/theme.css"/>

</head>

<body>

<!-- Fixed navbar -->
<jsp:include page="../includes/menu.jsp"></jsp:include>
<spring:url value="/" var="urlRoot"/>

<div class="container theme-showcase" role="main">

    <h3>Listado de Peliculas</h3>

    <c:if test="${mensaje != null}">
        <div class="alert alert-success" role="alert">${mensaje}</div>
    </c:if>
    <a href="${urlRoot}peliculas/create" class="btn btn-success" role="button" title="Nueva Pelicula">Nueva</a><br><br>

    <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Titulo</th>
                <th>Genero</th>
                <th>Clasificacion</th>
                <th>Duracion</th>
                <th>Fecha Estreno</th>
                <th>Estatus</th>
                <th>Opciones</th>
            </tr>
            <c:forEach var="pelicula" items="${peliculas}">
                <tr>
                    <td>${pelicula.titulo}</td>
                    <td>${pelicula.genero}</td>
                    <td>${pelicula.clasificacion}</td>
                    <td>${pelicula.duracion} min.</td>
                    <td><fmt:formatDate pattern="dd-MM-yyyy" value="${pelicula.fechaEstreno}"/></td>
                    <c:choose>
                        <c:when test="${pelicula.status eq 'Activa'}">
                            <td><span class="label label-success">${pelicula.status}</span></td>
                        </c:when>
                        <c:otherwise>
                            <td><span class="label label-danger">${pelicula.status}</span></td>
                        </c:otherwise>
                    </c:choose>
                    <td>
                        <a href="#" class="btn btn-success btn-sm" role="button" title="Edit"><span
                                class="glyphicon glyphicon-pencil"></span></a>
                        <a href="#" class="btn btn-danger btn-sm" role="button" title="Eliminar"><span
                                class="glyphicon glyphicon-trash"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <hr class="featurette-divider">

    <!-- FOOTER -->
    <jsp:include page="../includes/footer.jsp"></jsp:include>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${urlPublic}/bootstrap/js/bootstrap.min.js" rel="stylesheet"></script>
</body>
</html>
