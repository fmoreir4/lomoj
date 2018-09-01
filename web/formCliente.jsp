<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<form action="Cliente" method="post" enctype="multipart/form-data">
    <c:if test="${empty cliente.id}">
        <input type="hidden" name="acao" value="cad">
    </c:if>
    <c:if test="${not empty cliente.id}">
        <input type="hidden" name="acao" value="alt">
        <input type="hidden" name="id" value="${cliente.id}">
    </c:if>

    <div class="form-group">
        <label for=""></label>
        <input type="file" class="form-control" name="fotoperfil" placeholder="Foto perfil" value="${cliente.foto}">
    </div>

    <div class="form-group">
        <label for=""></label>
        <input type="text" class="form-control" name="nome" placeholder="Nome" value="${cliente.nome}">
    </div>

    <div class="form-group">
        <label for=""></label>
        <input type="email" class="form-control" name="email" placeholder="E-mail" value="${cliente.email}">
    </div>

    <div class="form-group">
        <label for=""></label>
        <input type="text" class="form-control" name="dataNasc" placeholder="Data de Nascimento (dd/mm/aaaa)" id="datepicker" value="${cliente.dataNasc.time}">
    </div>

    <div class="form-check">
        <input type="radio" class="form-check-input" name="ativo" value="1" checked><label class="form-check-label">Ativo</label>
    </div>
    <div class="form-check">
        <input type="radio" class="form-check-input" name="ativo" value="0"><label class="form-check-label">Bloqueado</label>
    </div>
    <c:if test="${empty cliente.id}">
        <div class="form-group">
            <label for=""></label>
            <input type="password" class="form-control" name="pws" placeholder="Senha">
        </div>

        <div class="form-group">
            <label for=""></label>
            <input type="password" class="form-control" name="pwsc" placeholder="Confirmação de senha">
        </div>
    </c:if>
    <div class="form-group text-right">
        <button type="submit" class="btn btn-primary">Salvar</button>
        <button type="reset" class="btn btn-primary">Cancelar</button>
    </div>
</form>
