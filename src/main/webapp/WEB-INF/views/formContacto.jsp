<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="">
    <title>Formulario de Contacto</title>

    <spring:url value="/" var="urlRoot" />
    <spring:url value="/resources" var="urlPublic"/>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/theme.css"/>"/>

</head>

<body>

<jsp:include page="includes/menu.jsp" />

<div class="container theme-showcase" role="main">

    <h3 class="blog-title text-center">
        <span class="label label-success">Contacto</span>
    </h3>
    <br>

    <c:if test="${mensaje != null }">
        <div class='alert alert-success' role="alert">${mensaje}</div>
    </c:if>

    <%--@elvariable id="contacto" type="com.nicolea.app.model.Contacto"--%>
    <form:form class="form-horizontal" method="post" action="${urlRoot}contacto" modelAttribute="contacto">
        <div class="form-group">
            <label for="nombre" class="col-sm-2 control-label">Nombre</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" id="nombre" path="nombre" placeholder="Nombre" required="required" />
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <form:input type="email" class="form-control" path="email" id="email" placeholder="Email" required="required" />
            </div>
        </div>

        <div class="form-group">
            <label for="genero" class="col-sm-2 control-label">Generos Favoritos</label>
            <div class="col-sm-10">
                <form:select id="genero" path="generos" multiple="multiple" class="form-control"  items="${generos}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">Tu experiencia en el sitio</label>
            <div class="col-sm-10">
                <label><form:radiobutton path="rating" value="1" />Muy Mala</label>
                <label><form:radiobutton path="rating" value="2" />Mala</label>
                <label><form:radiobutton path="rating" value="3" />Regular</label>
                <label><form:radiobutton path="rating" value="4" />Buena</label>
                <label><form:radiobutton path="rating" value="5" />Muy Buena</label>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">Te gustaría recibir notificaciones de:</label>
            <div class="col-sm-10">
                <form:checkboxes items="${tipos}" path="notificaciones"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">Comentarios:</label>
            <div class="col-sm-10">
                <form:textarea class="form-control" rows="5" path="comentarios" id="comentarios"></form:textarea>
            </div>
        </div>

    <hr class="featurette-divider">

    </form:form>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-success">Enviar</button>
        </div>
    </div>

    <jsp:include page="includes/footer.jsp" />

</div>
<!-- /container -->

<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
