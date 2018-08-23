
<form action="Produto" method="post" enctype="multipart/form-data">   
    <input type="hidden" name="acao" value="cad">

    <div class="form-group">
        <label for=""></label>
        <input type="text" class="form-control" name="nome" placeholder="Nome">
    </div>

    <div class="form-group">
        <label for=""></label>
        <input type="text" class="form-control" name="descricao" placeholder="Descrição">
    </div>

    <div class="form-group">
        <label for=""></label>
        <input type="number" class="form-control" name="quant" placeholder="Quantidade" min="0" step="1">
    </div>

    <div class="form-group">
        <label for=""></label>
        <input type="number" class="form-control" name="valor" placeholder="Valor" min="0" step="0.01">
    </div>

    <div class="form-check">
        <input type="radio" class="form-check-input" name="ativo" value="1" checked><label class="form-check-label">Ativo</label>
    </div>
    <div class="form-check">
        <input type="radio" class="form-check-input" name="ativo" value="0"><label class="form-check-label">Bloqueado</label>
    </div>

    <div class="form-group">
        <label for=""></label>
        <input type="file" class="form-control" name="foto01" placeholder="Foto 1">
    </div>

    <div class="form-group">
        <label for=""></label>
        <input type="file" class="form-control" name="foto02" placeholder="Foto 2">
    </div>

    <div class="form-group">
        <label for=""></label>
        <input type="file" class="form-control" name="foto03" placeholder="Foto 2">
    </div>

    <div class="form-group float-right">
        <button type="submit" class="btn btn-primary">Salvar</button>
        <button type="reset" class="btn btn-primary">Cancelar</button>
    </div>

</form>
