<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<form action="Produto" method="get" class="form">
    <input type="hidden" name="acao" value="pesq">
    <div class="form-group">
        <label for=""> Pesquisar </label>
        <input type="text" name="dados" class="form-control">
    </div>
    <div class="form-group">
        <button class="btn btn-primary">OK</button>
    </div>
</form>

<table class="table">
    <tr>
        <th>ID</th><th>Nome</th> <th>Descrição</th><th>Foto 1</th> <th>Foto 2</th><th>Foto 3</th><th> / </th> <th> X </th>
    </tr>
    <c:forEach items="${produtos}" var="produto">
        <tr>
            <td>${produto.id}</td>
            <td>${produto.nome}</td>
            <td>${produto.descricao}</td>
            <td>${produto.foto01}</td>
            <td>${produto.foto02}</td>
            <td>${produto.foto03}</td>
            <td>/</td>
            <td>X</td>
        </tr> 
    </c:forEach>

</table>