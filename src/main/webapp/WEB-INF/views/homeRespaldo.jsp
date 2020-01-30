<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina principal</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"></head>
<spring:url value="/resources" var="urlPublic" />

<body>
${urlPublic}/images/
<div class="panel panel-default">
	<div class="panel-heading">Lista de peliculas</div>
	<div class="panel-body">
		<table class="table table-hover table-bordered table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Título</th>
					<th>Duración</th>
					<th>Clasificación</th>
					<th>Género</th>
					<th>Status</th>
					<th>Imagen</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items= "${peliculas}" var="pelicula">
					<tr>
						<td>${pelicula.id}</td>
						<td>${pelicula.titulo}</td>
						<td>${pelicula.duracion}</td>
						<td>${pelicula.clasificacion}</td>
						<td>${pelicula.genero}</td>
						<td><img src="<c:url value="/resources/images/${pelicula.imagen}" />" width="80" height="100"></td>
						<td>
							<c:choose>
								<c:when test="${pelicula.status == 'Activa'}">
									<span class="label label-success">ACTIVA</span>
								</c:when>
								<c:otherwise>
									<span class="label label-danger">INACTIVA</span>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

</body>
</html>