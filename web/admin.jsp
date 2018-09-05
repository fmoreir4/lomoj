<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOMOJ - Panel de Controle</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="index.jsp">Inicio</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <c:if test="${not empty funcionario}">
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Cadastro
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="admin.jsp?p=formFuncionario">Funcionario</a>
                                <a class="dropdown-item" href="admin.jsp?p=formProduto">Produto</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Relatórios
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="admin.jsp?p=reportFuncionario">Funcionario</a>
                                <a class="dropdown-item" href="admin.jsp?p=reportProduto">Produto</a>
                                <a class="dropdown-item" href="admin.jsp?p=reportCliente">Clientes</a>
                            </div>
                        </li>

                        <c:if test="${not empty funcionario.nome}">
                            <ul class="navbar-nav ml-auto">
                                <li class="nav-item">
                                    <a class="nav-link">${funcionario.nome}</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="sys?logica=FuncionarioLog&acao=off">Sair</a>
                                </li>
                            </ul>
                        </c:if> 
                    </ul>
                </div>
            </c:if>
        </nav>
        <%-- Mensagem --%>
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
            <c:if test="${not empty funcionario}">
                <c:if test="${not empty param.p}">
                    <c:import url="${param.p}.jsp"/>
                </c:if>
            </c:if>
            <c:if test="${empty funcionario}">
                <%-- Login Funcionario --%>
                <div class="row justify-content-center">
                    <form method="post" action="sys" class="col-md-6">
                        <input type="hidden" name="logica" value="FuncionarioLog">
                        <input type="hidden" name="acao" value="log">
                        <h2 class="p-3 text-center"> login do funcionario</h2>
                        <div class="form-group py-3">
                            <label for="e-mail">e-mail</label>
                            <input type="email" name="email" class="form-control p-2" value="${email}" placeholder="Ex. paulosilva@email.com">
                        </div>
                        <div class="form-group py-3">
                            <label for="senha" class="float-left">senha</label> 
                            <span class="float-right"><a href="#">esqueceu?</a></span>
                            <div class="input-group">
                                <input type="password" name="pws" class="form-control p-2">
                                <div class="input-group-append">
                                    <div class="input-group-text"><i class="fa fa-eye-slash"></i></div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group py-3">
                            <button class="btn btn-lg btn-block p-2">continuar</button>
                        </div>
                    </form>
                </div>

            </c:if>
        </section>

        <footer class="jumbotron bg-light">

        </footer>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <link rel="stylesheet"  href="js/jquery-ui.structure.min.css">
        <link rel="stylesheet"  href="js/jquery-ui.theme.min.css">

        <script src="js/datepicker.js"></script>
    </body>
</html>
