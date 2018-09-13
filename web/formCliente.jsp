<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<form action="sys" method="post" enctype="multipart/form-data">
    <input type="hidden" name="logica" value="ClienteLog">
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
        <input type="text" class="form-control" name="dataNasc" placeholder="Data de Nascimento (dd/mm/aaaa)" id="datepicker" value="<fmt:formatDate value="${cliente.dataNasc.time}" type="date" pattern = "dd/MM/yyyy"/>">
    </div>
    <div class="form-group">
        <div class="form-check">
            <input type="radio" class="form-check-input" name="ativo" value="1" checked><label class="form-check-label">Ativo</label>
        </div>
        <div class="form-check">
            <input type="radio" class="form-check-input" name="ativo" value="0"><label class="form-check-label">Bloqueado</label>
        </div>
    </div>
    <!-- Endereco -->
    <div class="form-group">
        <label for="numero">Numero</label>
        <input type="text" name="numero" class="form-control" value="${cliente.numero}">
    </div>

    <div class="form-group">
        <label for="complemento">Complemento</label>
        <input type="text" name="complemento" class="form-control" value="${cliente.complemento}">
    </div>

    <div class="form-group">
        <label for="cep">CEP</label><span id="mensagem"></span>
        <input type="text" name="cep" class="form-control"  maxlength="9" value="${cliente.endereco.cep}" id="cep">
    </div>

    <div class="form-group">
        <label for="logradouro">Endereço</label>
        <input type="text" name="logradouro" maxlength="" class="form-control" value="${cliente.endereco.logradouro}" id="rua">
    </div>

    <div class="form-group">
        <label for="bairro">Bairro</label>
        <input type="text" name="bairro" maxlength="" class="form-control" value="${cliente.endereco.bairro}" id="bairro">
    </div>

    <div class="form-group">
        <label for="cidade">Cidade</label>
        <input type="text" name="cidade" maxlength="" class="form-control" value="${cliente.endereco.cidade}" id="cidade">
    </div>

    <div class="form-group">
        <label for="uf">Estado</label>
        <input type="text" name="uf" maxlength="2" class="form-control" value="${cliente.endereco.uf}" id="uf">
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

