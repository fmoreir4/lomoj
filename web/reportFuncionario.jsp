<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<form action="Func" method="get" class="form">
     <h2> Pesquisa de Funcionário </h2>
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
        <th>ID</th> <th>Foto</th> <th>Nome</th> <th>E-mail</th> <th>Cargo</th> <th> / </th> <th> X </th>
    </tr>
    <c:forEach items="${funcionarios}" var="funcionario">
        <tr>
            <td>${funcionario.id}</td>
            <td>${funcionario.foto}</td>
            <td>${funcionario.nome}</td>
            <td>${funcionario.email}</td>
            <td>${funcionario.cargo}</td>
            <td>/</td>
            <td>X</td>
        </tr> 
    </c:forEach>

</table>