<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="dao" class="controller.CtrlProduto"/>
<h2> Bem vindo! </h2> 

<div class="row">
    <c:forEach items="${dao.pesquisar('')}" var="produto">
        <div class="col-md-3 produto"> 
            <a href="sys?logica=ProdutoLog&acao=desc&id=${produto.id}">
                <div class="well">
                    <img src="img/produtos/${produto.foto01}" title="${produto.foto01}" alt="${produto.descricao}" class="img-responsive">
                    <p class="nome">${produto.nome}</p>
                    <p class="descricao">${produto.descricao}</p>
                    <p class="valor">
                        R$
                        <f:formatNumber minFractionDigits="2" currencySymbol="R$">
                            ${produto.valor}
                        </f:formatNumber>
                </div>
            </a>    
        </div>
    </c:forEach>
</div>
