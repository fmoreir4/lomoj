<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<form action="Cliente" method="get" class="form">
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
        <th>ID</th> <th>Nome</th> <th>E-mail</th> <th>Data Nasc.</th> <th> / </th> <th> X </th>
    </tr>
    <c:forEach items="${clientes}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.nome}</td>
            <td>${c.email}</td>
            <td><fmt:formatDate value="${c.dataNasc.time}" type="date"/></td>
            <td>/</td>
            <td>X</td>
        </tr> 
    </c:forEach>
    
</table>