<!DOCTYPE html>
<html lang="en">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Creacion de Noticias</title>

    <spring:url value="/resources" var="urlPublic" />
    <link rel="stylesheet" href="${urlPublic}/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${urlPublic}/bootstrap/css/theme.css"/>

</head>

<body>

<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">My CineSite</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="#">Acerca</a></li>
                <li><a href="#">Login</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container theme-showcase" role="main">

    <h3 class="blog-title"><span class="label label-success">Datos de la Noticia</span></h3>

    <form>
        <div class="row">
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="titulo">Titulo</label>
                    <input type="text" class="form-control" name="titulo" id="titulo" required="required"/>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="estatus">Estatus</label>
                    <select id="estatus" name="estatus" class="form-control">
                        <option value="Activa">Activa</option>
                        <option value="Inactiva">Inactiva</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="form-group">
                    <label for="detalle">Detalles</label>
                    <textarea class="form-control" name="detalle" id="detalle" rows="10"></textarea>
                </div>
            </div>
        </div>

        <button type="submit" class="btn btn-danger" >Guardar</button>
    </form>

    <hr class="featurette-divider">

    <!-- FOOTER -->
    <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2017 My CineSite, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
    </footer>

</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${urlPublic}/bootstrap/js/bootstrap.min.js" rel="stylesheet"></script>
<script src="${urlPublic}/bootstrap/js/bootstrap.min.js" rel="stylesheet"></script>
<script src="${urlPublic}/tinymce/tinymce.min.js" rel="stylesheet"></script>

    <script>
    tinymce.init({
        selector: '#detalle',
        plugins: "textcolor, table lists code",
        toolbar: " undo redo | bold italic | alignleft aligncenter alignright alignjustify \n\
                    | bullist numlist outdent indent | forecolor backcolor table code"
    });
</script>
</body>
</html>
