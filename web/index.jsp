<%-- 
    Document   : index
    Created on : 06/08/2018, 19:30:20
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOMOJ</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="index.jsp">Inicio</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Produtos </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Lojas</a>
                    </li>
                </ul>

                <ul class="navbar-nav ml-auto">
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Procurando algo?" aria-label="Buscar">
                        <button class="btn btn-outline-warning my-2 my-sm-0" type="submit">Buscar</button>
                    </form>
                <c:if test="${not empty cliente.nome}">
                    <li class="nav-item">
                        <a class="nav-link">${cliente.nome}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Cliente?acao=off">Sair</a>
                    </li>
                </c:if> 
                <c:if test="${empty cliente.nome}">
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp?p=formCliente">Cadastro</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp?p=login">Login</a>
                    </li>
                </c:if>
                </ul>
            </div>
        </nav>

        <header class="jumbotron">
            <h1> LOMOJ </h1>
            <h3> A loja que vende tudo </h3>
        </header>

        <c:if test="${not empty avisos}">
            <div class="alert alert-success">
                <p>${avisos}</p>
            </div>
        </c:if>
        <c:if test="${not empty erros}">
            <div class="alert alert-danger">
                <p>${erros}</p>
            </div>
        </c:if>
        <c:if test="${not empty alertas}">
            <div class="alert alert-warning">
                <p>${alertas}</p>
            </div>
        </c:if>

        <section class="container">
            <c:if test="${not empty param.p}">
                <c:import url="${param.p}.jsp"/>
            </c:if>
        </section>

        <footer>

        </footer>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
