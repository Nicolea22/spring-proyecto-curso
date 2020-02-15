<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Creacion de Peliculas</title>

    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/peliculas/save" var="urlForm"></spring:url>
    <link rel="stylesheet" href="${urlPublic}/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${urlPublic}/bootstrap/css/theme.css"/>

</head>
<body>

<!-- Fixed navbar -->
<jsp:include page="../includes/menu.jsp"></jsp:include>

<div class="container theme-showcase" role="main">

    <div class="page-header">
        <h3 class="blog-title"><span class="label label-success">Datos de la Pelicula</span></h3>
    </div>

    <spring:hasBindErrors name="pelicula">
        <div class="alert alert-danger" role="alert">
            Por favor corrija los siguientes errores
            <ul>
                <c:forEach var="error" items="${errors.allErrors}">
                    <li><spring:message message="${error}"/></li>
                </c:forEach>
            </ul>
        </div>
    </spring:hasBindErrors>

    <%--@elvariable id="pelicula" type=""--%>
    <form:form action="${urlForm}" method="post" enctype="multipart/form-data" modelAttribute="pelicula">
        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <img class="img-rounded" src="<c:url value="/resources/images/${pelicula.imagen}"/>" title="Imagen actual de la pelicula" width="155" height="220">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-3">
                <form:hidden path="id"/>
                <div class="form-group">
                    <label for="titulo">Título</label>
                    <form:input type="text" class="form-control" path="titulo" id="titulo" required="required"/>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="duracion">Duracion</label>
                    <form:input type="text" class="form-control" path="duracion" id="duracion" required="required"/>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="clasificacion" class="control-label">Clasificacion</label>
                    <form:select id="clasificacion" path="clasificacion" class="form-control">
                        <option value="A">Clasificacion A</option>
                        <option value="B">Clasificacion B</option>
                        <option value="C">Clasificacion C</option>
                    </form:select>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="genero" class="control-label">Genero</label>
                    <form:select id="generoId" path="genero" class="form-control" items="${generos}"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="estatus" class="control-label">Estatus</label>
                    <form:select id="genero" path="status" class="form-control">
                        <form:option value="Activa">Activa</form:option>
                        <form:option value="Inactiva">Inactiva</form:option>
                    </form:select>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="fechaEstreno">Fecha Estreno</label>
                    <form:input type="text" class="form-control" path="fechaEstreno" id="fechaEstreno" required="required"/>
                </div>
            </div>

            <div class="col-sm-3">
                <div class="form-group">
                    <label for="imagen">Imagen</label>
                    <input type="file" id="archivoImagen" name="archivoImagen"/>
                    <p class="help-block">Imagen de la pelicula</p>
                </div>
            </div>
        </div>

        <div class="page-header">
            <h3 class="blog-title"><span class="label label-success">Detalles</span></h3>
        </div>

        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="director">Director</label>
              <form:input type="text" class="form-control" path="detalle.director" id="director" required="required" />
            </div>
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="actores">Actores</label>
              <form:input type="text" class="form-control" path="detalle.actores" id="actores" required="required" />
            </div>
          </div>

          <div class="col-sm-6">
            <div class="form-group">
              <label for="trailer">URL del Trailer (Youtube)</label>
              <form:input type="text" class="form-control" path="detalle.trailer" id="trailer" placeholder="URL completa del video de YOUTUBE" required="required" />
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-sm-6">
            <div class="form-group">
              <label for="sinopsis">Sinopsis</label>
              <form:textarea class="form-control" rows="5" path="detalle.sinopsis" id="sinopsis"></form:textarea>
            </div>
          </div>
        </div>


        <button type="submit" class="btn btn-danger">Guardar</button>
    </form:form>

    <hr class="featurette-divider">

    <jsp:include page="../includes/footer.jsp"></jsp:include>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${urlPublic}/bootstrap/js/bootstrap.min.js" rel="stylesheet"></script>
<script src="${urlPublic}/tinymce/tinymce.min.js" rel="stylesheet"></script>

<script>
    $(function () {
            $("#fechaEstreno").datepicker({dateFormat: 'dd-mm-yy'});
        }
    );
</script>
</body>
</html>

