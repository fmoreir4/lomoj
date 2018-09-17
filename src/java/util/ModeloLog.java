package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Arquivo;
import util.Crypt;

@MultipartConfig
//@WebServlet(name = "ModeloServlet", urlPatterns = {"/Modelo"})
public class ModeloLog implements Logica {

    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String pagina = "index.jsp";
        String acao = request.getParameter("acao").trim(); 
        
        Arquivo arq = new Arquivo();
        String caminhoFoto = System.getProperty("user.home") + ""
                //+ "/Documents/NetBeansProjects/lomoj/web/img/clientes/";//windows
                + "/NetBeansProjects/lomoj/web/img/clientes/";//linux

        //Cadastro e Alteração
        if (acao.equals("cad") || acao.equals("alt")) {

            try {
               
                /*
                //Data de Nascimento
                if (!request.getParameter("dataNasc").equals("")) {
                    //String para Data(Calendar)
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(sdf.parse(request.getParameter("dataNasc").trim()));
                    cliente.setDataNasc(cal);
                }

                //Upload da Foto
                cliente.setFoto(arq.upload(caminhoFoto,
                        request.getPart("fotoperfil").getSubmittedFileName(),
                        request.getPart("fotoperfil").getInputStream()));
                 */
                
            } catch (Exception ex) {
                System.err.println("Erro: " + ex.toString());
                request.setAttribute("erros", ex.getMessage().replace("\n", "<br>"));
            }

            pagina = "index.jsp?p=formModelo";
        }

        //Login
        if (acao.equals("log")) {
            try {
                // CtrlModelo ctrlModelo = new CtrlModelo();
                String email = request.getParameter("email").trim();
                String pws = Crypt.md5(request.getParameter("pws").trim());
                // Modelo cliente = ctrlModelo.login(email, pws);
                HttpSession user = request.getSession();
                // cliente.setPws("");
                // user.setAttribute("cliente", cliente);
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

        //Retorna para a página
        return pagina;
    }

}
