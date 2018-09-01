package servlets;

import controller.CtrlCliente;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cliente;
import util.Arquivo;
import util.Crypt;

@MultipartConfig
@WebServlet(name = "ClienteServlet", urlPatterns = {"/Cliente"})
public class ClienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String pagina = "index.jsp";
        String acao = request.getParameter("acao");
        String caminhoFoto = System.getProperty("user.home") + ""
                + "/Documents/NetBeansProjects/lomoj/web/img/clientes/";//windows
                //+ "/NetBeansProjects/lomoj/web/img/clientes/";//linux

        //Cadastro e Alteração
        if (acao.equals("cad") || acao.equals("alt")) {
             Cliente cliente = null;
            try {
                cliente = new Cliente();
                CtrlCliente ctrlCliente = new CtrlCliente();
                Arquivo arq = new Arquivo();

                cliente.setNome(request.getParameter("nome"));
                cliente.setEmail(request.getParameter("email"));
                //cliente.setPws(request.getParameter("pws"));
                cliente.setFoto(request.getPart("fotoperfil").getSubmittedFileName());

                if (!request.getParameter("dataNasc").equals("")) {
                    //String para Data(Calendar)
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(sdf.parse(request.getParameter("dataNasc")));
                    cliente.setDataNasc(cal);
                }
                if(acao.equals("cad")){
                    cliente.setPws(request.getParameter("pws"));
                    cliente.validar(request.getParameter("pwsc"));
                } else {
                    cliente.setId(Long.parseLong(request.getParameter("id")));
                    cliente.validar();
                }
                //Upload da Foto
                cliente.setFoto(arq.upload(caminhoFoto,
                        request.getPart("fotoperfil").getSubmittedFileName(),
                        request.getPart("fotoperfil").getInputStream()));
                
                if(acao.equals("cad")){
                    cliente.setPws(Crypt.md5(cliente.getPws()));
                    ctrlCliente.cadastrar(cliente);
                } else {
                    ctrlCliente.alterar(cliente);
                }
                
                request.setAttribute("avisos", "Cadastrado");
            } catch (Exception ex) {
                request.setAttribute("cliente", cliente);
                request.setAttribute("erros", ex.getMessage().replace("\n", "<br>"));
            }
            pagina = "index.jsp?p=formCliente";
        }

        //Login
        if (acao.equals("log")) {
            try {
                CtrlCliente ctrlCliente = new CtrlCliente();
                String email = request.getParameter("email").trim();
                String pws = Crypt.md5(request.getParameter("pws").trim());
                Cliente cliente = ctrlCliente.login(email, pws);
                HttpSession user = request.getSession();
                cliente.setPws("");
                user.setAttribute("cliente", cliente);
            } catch (Exception ex) {
                request.setAttribute("erros", "Usuário ou senha invalido");
                pagina = "index.jsp?p=login";
            }
        }

        //Logoff(sair)
        if (acao.equals("off")) {
            HttpSession user = request.getSession();
            //Remove um item da session
            //user.removeAttribute("cliente");
            //Apaga a session user
            user.invalidate();
        }

        //Pesquisar
        if (acao.equals("pesq")) {
            CtrlCliente ctrlcliente = new CtrlCliente();
            String dados = request.getParameter("dados").trim();
            try {
                List<Cliente> clientes = ctrlcliente.pesquisa(dados);
                request.setAttribute("clientes", clientes);
            } catch (Exception ex) {
                request.setAttribute("erros", "Dados não encontrados.");
            }
            pagina = "admin.jsp?p=reportCliente";
        }

        if(acao.equals("edit")){
            long id = Long.parseLong(request.getParameter("id"));
            CtrlCliente ctrlCliente = new CtrlCliente();
            Cliente cliente;
            try {
                cliente = ctrlCliente.buscaID(id);
                request.setAttribute("cliente", cliente);
            } catch (Exception ex) {
                request.setAttribute("erros", "Cliente não localizado.");
            }
            
            pagina = "index.jsp?p=formCliente";
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
