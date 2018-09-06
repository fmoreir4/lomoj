package logica;

import controller.CtrlItem;
import controller.CtrlPedido;
import controller.CtrlProduto;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Item;
import model.Produto;
import util.Arquivo;

@MultipartConfig
//@WebServlet(name = "ProdutoServlet", urlPatterns = {"/Produto"})
public class Carrinho implements Logica {

    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String pagina = "index.jsp";
        String acao = request.getParameter("acao");

        CtrlProduto ctrlProduto = new CtrlProduto();
        CtrlPedido ctrlPedido = new CtrlPedido();
        CtrlItem ctrlItem = new CtrlItem();

        HttpSession carrinho = request.getSession(false);

        if (acao.equals("add")) {
            long id = Long.parseLong(request.getParameter("id"));
            Produto produto = ctrlProduto.buscaID(id);
            Item item = new Item();
            item.setProduto(produto);
            List<Item> itens = (List<Item>) carrinho.getAttribute("itens");
            if (itens == null) {
                itens = new ArrayList<>();
            }
            itens.add(item);
            carrinho.setAttribute("itens", itens);
            pagina = "index.jsp?p=carrinho";
        }

        //Retorna para a página
        return pagina;
    }

}
