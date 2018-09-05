package logica;

import controller.CtrlProduto;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        if (acao.equals("add")){
            
        }
        
        //Retorna para a página
        return pagina;
    }

}
