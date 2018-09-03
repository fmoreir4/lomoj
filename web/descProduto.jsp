<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
    <div class="col-md-6">
	<div class="col-md-12">
	    <c:if test="${not empty produto.foto01}">
		<img src="img/produtos/${produto.foto01}" class="img-fluid">
	    </c:if>
	</div>
	<div class="col-md-12">
	    <div class="row">
		<div class="col-md-6">
		    <c:if test="${not empty produto.foto02}">
			<img src="img/produtos/${produto.foto02}" class="img-thumbnail">
		    </c:if>
		</div>
		<div class="col-md-6">
		    <c:if test="${not empty produto.foto03}">
			<img src="img/produtos/${produto.foto03}" class="img-thumbnail">
		    </c:if>
		</div>
	    </div>
	</div>
    </div>
    <div class="col-md-6">
	<h4>Produto</h4>
	<p>${produto.nome}</p>
	<h4>Descrição do Produto</h4>
	<p>${produto.descricao}</p>
	<h4>Valor</h4>
	<p class="redValor">
	    <strong>
		R$
		<f:formatNumber minFractionDigits="2" currencySymbol="R$">
		    ${produto.valor}
		</f:formatNumber>
	    </strong>
	</p>
	<a href="sys?logica=Carrinho&acao=add&id=${produto.id}">
	    <button class="btn btn-danger btn-lg btn-block p-2"> Comprar </button>
	</a>
    </div>
</div>



