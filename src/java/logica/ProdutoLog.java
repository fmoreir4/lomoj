package logica;

import controller.CtrlProduto;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

@MultipartConfig
//@WebServlet(name = "ProdutoServlet", urlPatterns = {"/Produto"})
public class ProdutoLog implements Logica {

    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String pagina = "index.jsp";
        String acao = request.getParameter("acao");

        //Cadastro
        if (acao.equals("cad")) {
            try {
                Produto produto = new Produto();
                CtrlProduto ctrlProduto = new CtrlProduto();
                produto.setNome(request.getParameter("nome"));
                produto.setDescricao(request.getParameter("descricao"));

                if (!request.getParameter("quant").equals("")) {
                    produto.setQuant(Integer.parseInt(request.getParameter("quant")));
                }

                if (!request.getParameter("valor").equals("")) {
                    produto.setValor(Float.parseFloat(request.getParameter("valor")));
                }

                produto.setFoto01(request.getPart("foto01").getSubmittedFileName());
                produto.setFoto02(request.getPart("foto02").getSubmittedFileName());
                produto.setFoto03(request.getPart("foto03").getSubmittedFileName());
                if (request.getParameter("ativo").equals("1")) {
                    produto.setAtivo(true);
                } else {
                    produto.setAtivo(false);
                }

                produto.validar();
                ctrlProduto.cadastrar(produto);
                request.setAttribute("avisos", "Cadastrado");
            } catch (Exception ex) {
                request.setAttribute("erros", ex.getMessage().replace("\n", "<br>"));
            }
            pagina = "admin.jsp?p=formProduto";
        }

        //Pesquisar
        if (acao.equals("pesq")) {
            CtrlProduto ctrlProduto = new CtrlProduto();
            String dados = request.getParameter("dados").trim();
            try {
                List<Produto> produtos = ctrlProduto.pesquisar(dados);
                request.setAttribute("produtos", produtos);
            } catch (Exception ex) {
                request.setAttribute("erros", "Dados não encontrados.");
            }
            pagina = "admin.jsp?p=reportProduto";
        }

        //Busca por ID
        if (acao.equals("desc")) {
            CtrlProduto ctrlProduto = new CtrlProduto();
            long id = Long.parseLong(request.getParameter("id"));
            try {
                Produto produto = ctrlProduto.buscaID(id);
                request.setAttribute("produto", produto);
                pagina = "index.jsp?p=descProduto";
            } catch (Exception ex) {
                request.setAttribute("erros", "Produto não encontrados.");
                pagina = "index.jsp";
            }
        }

        //Retorna para a página
        return pagina;
    }

}
