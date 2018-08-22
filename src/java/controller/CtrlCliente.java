package controller;

import dao.ClienteDAO;
import model.Cliente;

public class CtrlCliente {

    ClienteDAO dao = null;

    public void cadastrar(Cliente cliente) throws Exception {
        dao = new ClienteDAO();
        dao.create(cliente);
    }

    public Cliente login(String email, String senha) throws Exception {
        dao = new ClienteDAO();
        return dao.findCliente(email, senha);
    }

}
