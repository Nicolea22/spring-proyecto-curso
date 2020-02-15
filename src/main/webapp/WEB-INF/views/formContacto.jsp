
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="">
    <title>Formulario de Contacto</title>

    <spring:url value="/resources" var="urlPublic"/>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/theme.css"/>"/>

</head>

<body>

<!-- Fixed navbar -->
<jsp:include page="includes/menu.jsp"></jsp:include>

<div class="container theme-showcase" role="main">

    <h3 class="blog-title text-center"><span class="label label-success">Contacto</span></h3><br>

    <form:form class="form-horizontal" method="post" modelAttribute="contacto">
        <div class="form-group">
            <label for="nombre" class="col-sm-2 control-label">Nombre</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" id="nombre" path="nombre" placeholder="Nombre" required="required"/>
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <form:input type="email" class="form-control" path="email" id="email" placeholder="Email" required="required"/>
            </div>
        </div>

        <div class="form-group">
            <label for="generos" class="col-sm-2 control-label">Géneros Favoritos</label>
            <div class="col-sm-10">
                <form:select id="generos" path="generos" multiple="multiple" class="form-control" items="${generos}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">Tu experiencia en el sitio</label>
            <div class="col-sm-10">
                <label><input type="radio" name="rating" value="1">Muy Mala</label>
                <label><input type="radio" name="rating" value="2">Mala</label>
                <label><input type="radio" name="rating" value="3">Regular</label>
                <label><input type="radio" name="rating" value="4">Buena</label>
                <label><input type="radio" name="rating" value="5">Muy Buena</label>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">Te gustaría recibir notificaciones de:</label>
            <div class="col-sm-10">
                <label><input type="checkbox" name="notificaciones" value="Estrenos">Estrenos</label>
                <label><input type="checkbox" name="notificaciones" value="Promociones">Promociones</label>
                <label><input type="checkbox" name="notificaciones" value="Noticias" >Noticias</label>
                <label><input type="checkbox" name="notificaciones" value="Preventas">Preventas</label>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">Comentarios:</label>
            <div class="col-sm-10">
                <textarea class="form-control" name="comentarios" id="comentarios" rows="5"></textarea>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">Enviar</button>
            </div>
        </div>

    </form:form>

    <hr class="featurette-divider">

    <!-- FOOTER -->
    <jsp:include page="includes/footer.jsp"></jsp:include>

</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
