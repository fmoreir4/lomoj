<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row justify-content-center">

    <form method="post" action="Cliente" class="col-md-6">

        <input type="hidden" name="acao" value="log">

        <h2 class="p-3 text-center"> login do cliente</h2>

        <div class="form-group py-3">
            <label for="e-mail">e-mail</label>
            <input type="email" name="email" class="form-control p-2" value="${email}" placeholder="Ex. paulosilva@email.com">
        </div>

        <div class="form-group py-3">
            <label for="senha" class="float-left">senha na lomoj.com</label> 
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
        <div class="text-center py-3">---------- ou ----------</div>
        <div class="text-center py-3">não tem cadastro?<a href="index.jsp?p=formCliente.jsp">cadastre-se</a></div>

    </form>
</div>