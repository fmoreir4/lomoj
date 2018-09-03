package logica;

import controller.CtrlFuncionario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Funcionario;

@MultipartConfig
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/Func"})
public class FuncionarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String pagina = "admin.jsp";
        String acao = request.getParameter("acao");

        //Cadastro
        if (acao.equals("cad")) {
            try {
                Funcionario funcionario = new Funcionario();
                CtrlFuncionario ctrlFuncionario = new CtrlFuncionario();
                funcionario.setNome(request.getParameter("nome"));
                funcionario.setEmail(request.getParameter("email"));
                funcionario.setPws(request.getParameter("pws"));
                funcionario.setFoto(request.getPart("fotoperfil").getSubmittedFileName());

                funcionario.validar(request.getParameter("pwsc"));
                ctrlFuncionario.cadastrar(funcionario);
                request.setAttribute("avisos", "Cadastrado");
            } catch (Exception ex) {
                request.setAttribute("erros", ex.getMessage().replace("\n", "<br>"));
            }
            pagina = "admin.jsp?p=formFuncionario";
        }

        //Login
        if (acao.equals("log")) {
            try {
                CtrlFuncionario ctrlFuncionario = new CtrlFuncionario();
                String email = request.getParameter("email");
                String pws = request.getParameter("pws");
                Funcionario funcionario = ctrlFuncionario.login(email, pws);
                HttpSession user = request.getSession();
                funcionario.setPws("");
                user.setAttribute("funcionario", funcionario);
            } catch (Exception ex) {
                request.setAttribute("erros", "Usuário ou senha invalido");
                pagina = "admin.jsp?p=login";
            }
        }

        //Logoff(sair)
        if (acao.equals("off")) {
            HttpSession user = request.getSession();
            //Remove um item da session
            //user.removeAttribute("funcionario");
            //Apaga a session user
            user.invalidate();
        }

        //Pesquisar
        if (acao.equals("pesq")) {
            CtrlFuncionario ctrlfuncionario = new CtrlFuncionario();
            String dados = request.getParameter("dados").trim();
            try {
                List<Funcionario> funcionarios = ctrlfuncionario.pesquisa(dados);
                request.setAttribute("funcionarios", funcionarios);
            } catch (Exception ex) {
                request.setAttribute("erros", "Dados não encontrados.");
            }
            pagina = "admin.jsp?p=reportFuncionario";
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
