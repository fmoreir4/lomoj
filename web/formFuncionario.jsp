
<form action="sys" method="post" enctype="multipart/form-data">
        <input type="hidden" name="logica" value="FuncionarioLog">
    <input type="hidden" name="acao" value="cad">

    <div class="form-group">
        <label for=""></label>
        <input type="file" class="form-control" name="fotoperfil" placeholder="Foto perfil">
    </div>

    <div class="form-group">
        <label for=""></label>
        <input type="text" class="form-control" name="nome" placeholder="Nome">
    </div>

    <div class="form-group">
        <label for=""></label>
        <input type="email" class="form-control" name="email" placeholder="E-mail">
    </div>


    <div class="form-check">
        <input type="radio" class="form-check-input" name="ativo" value="1"checked><label class="form-check-label">Ativo</label>
    </div>
    <div class="form-check">
        <input type="radio" class="form-check-input" name="ativo" value="0"><label class="form-check-label">Bloqueado</label>
    </div>
    
    <div class="form-group">
        <label for="exampleFormControlSelect1">Cargo</label>
        <select class="form-control" id="exampleFormControlSelect1">
            <option>Administrador</option>
            <option>Gerente</option>
            <option>Vendedor</option>
            <option>Atendente</option>
        </select>
    </div>

    <div class="form-group">
        <label for=""></label>
        <input type="password" class="form-control" name="pws" placeholder="Senha">
    </div>
    <div class="form-group">
        <label for=""></label>
        <input type="password" class="form-control" name="pwsc" placeholder="Confirmação de senha">
    </div>

    <div class="form-group text-right">
        <button type="submit" class="btn btn-primary">Salvar</button>
        <button type="reset" class="btn btn-primary">Cancelar</button>
    </div>
</form>
