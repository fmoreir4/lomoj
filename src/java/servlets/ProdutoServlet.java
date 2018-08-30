package servlets;

import controller.CtrlProduto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

@MultipartConfig
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/Produto"})
public class ProdutoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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


        //Retorna para a página
        request.getRequestDispatcher(pagina).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
