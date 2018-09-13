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
import model.Pedido;
import model.Produto;

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

        Pedido pedido = null;

        if (acao.equals("add")) {
            long id = Long.parseLong(request.getParameter("id"));
            Produto produto = ctrlProduto.buscaID(id);
            Item item = new Item();
            item.setProduto(produto);
            List<Item> itens = (List<Item>) carrinho.getAttribute("itens");
            if (itens == null) {
                itens = new ArrayList<>();
            }
            int cont = 0;
            for (Item i : itens) {
                if (i.getProduto().equals(item.getProduto())) {
                    cont++;
                }
            }
            if (cont == 0) {
                item.setValorItens();
                itens.add(item);
            }

            carrinho.setAttribute("itens", itens);

            pagina = "index.jsp?p=carrinho";
        }

        if (acao.equals("remove")) {
            int index = Integer.parseInt(request.getParameter("index"));
            List<Item> itens = (List<Item>) carrinho.getAttribute("itens");
            //remove o item se o carrinho não estiver vazio
            if (!itens.isEmpty()) {
                itens.remove(index);
                carrinho.setAttribute("itens", itens);
            }
            pagina = "index.jsp?p=carrinho";
        }

        if (acao.equals("calcular")) {
            calcular(request, carrinho);
            pagina = "index.jsp?p=carrinho";
        }

        //Retorna para a página
        return pagina;
    }

    private void calcular(HttpServletRequest request, HttpSession carrinho) {
        String quant[] = request.getParameterValues("quant");
        List<Item> itens = (List<Item>) carrinho.getAttribute("itens");
        double total = 0;
        int index = 0;
        for (Item i : itens) {
            i.setQuant(Integer.parseInt(quant[index]));
            i.setValorItens();
            total += i.getValorItens();
            index++;
        }
        carrinho.setAttribute("itens", itens);
        carrinho.setAttribute("total", total);
    }

}
