package controller;

import dao.ProdutoDAO;
import model.Produto;

public class CtrlProduto {

    ProdutoDAO dao = null;

    public void cadastrar(Produto produto) throws Exception {
        dao = new ProdutoDAO();
        dao.create(produto);
    }


}
