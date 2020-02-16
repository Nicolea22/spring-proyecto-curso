<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="">
    <title>Creacion de Horarios</title>

    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/horarios/save" var="urlForm"></spring:url>
    <link rel="stylesheet" href="${urlPublic}/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${urlPublic}/bootstrap/css/theme.css"/>
</head>

<body>

<!-- Fixed navbar -->
<jsp:include page="../includes/menu.jsp" />

<div class="container theme-showcase" role="main">

    <h3 class="blog-title"><span class="label label-success">Datos del Horario</span></h3>

    <%--@elvariable id="horario" type="com.nicolea.app.model.Horario"--%>
    <form:form action="${urlForm}" method="POST" modelAttribute="horario">
        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="idPelicula" class="control-label">Pelicula</label>
                    <form:select id="idPelicula" path="pelicula.id"	class="form-control"
                                 items="${peliculas}" itemLabel="titulo" itemValue="id" />
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="fecha">Fecha</label>
                    <form:input type="text" class="form-control" name="fecha" id="fecha" required="required" path="fecha"/>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="hora">Hora</label>
                    <form:input type="text" class="form-control" name="hora" id="hora" placeholder="Formato: HH:mm Ejemplo 21:30" required="required" path="hora"/>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="sala" class="control-label">Sala</label>
                    <form:select id="sala" name="sala" class="form-control" path="sala">
                        <form:option value="Premium">Sala Premium</form:option>
                        <form:option value="Sala 1">Sala 1</form:option>
                        <form:option value="Sala 2">Sala 2</form:option>
                        <form:option value="Sala 3">Sala 3</form:option>
                    </form:select>
                </div>
            </div>

            <div class="col-sm-3">
                <div class="form-group">
                    <label for="precio">Precio</label>
                    <form:input type="text" class="form-control" name="precio" id="precio" required="required" path="precio"/>
                </div>
            </div>

        </div>

        <button type="submit" class="btn btn-danger" >Guardar</button>
    </form:form>

    <hr class="featurette-divider">

    <!-- FOOTER -->
    <jsp:include page="../includes/footer.jsp" />

</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${urlPublic}/bootstrap/js/bootstrap.min.js" rel="stylesheet"></script>

<script>
    $(function () {
            $("#fecha").datepicker({dateFormat: 'dd-mm-yy'});
        }
    );
</script>
</body>
</html>
