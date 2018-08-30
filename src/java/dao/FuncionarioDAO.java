package dao;

import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Funcionario;

public class FuncionarioDAO extends ConectaJPA {

    //Salvar 
    public void create(Funcionario dados) throws Exception {
        et = em.getTransaction();
        try {
            et.begin();
            em.persist(dados);
            et.commit();
        } catch (Exception ex) {
            try {
                et.rollback();
            } catch (Exception re) {
                re.toString();
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Alterar 
    public void edit(Funcionario dados) throws Exception {
        et = em.getTransaction();
        try {
            et.begin();
            dados = em.merge(dados);
            et.commit();
        } catch (Exception ex) {
            try {
                et.rollback();
            } catch (Exception re) {

            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = dados.getId();
                if (findFuncionario(id) == null) {

                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Apagar
    public void destroy(Long id) throws Exception {
        et = em.getTransaction();
        try {
            et.begin();
            Funcionario dados = null;
            try {
                dados = em.getReference(Funcionario.class, id);
                dados.getId();
            } catch (EntityNotFoundException enfe) {

            }
            em.remove(dados);
            et.commit();
        } catch (Exception ex) {
            try {
                et.rollback();
            } catch (Exception re) {

            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Busca pelo ID
    public Funcionario findFuncionario(Long id) {
        try {
            return em.find(Funcionario.class, id);
        } finally {
            em.close();
        }
    }

    //Buscar todos por nomes
    public List<Funcionario> findFuncionarios(String dado) {
        try {
            Query query = em.createQuery("select x from Funcionario as x where x.nome like :dados and x.ativo = 1");
            query.setParameter("dados", dado + "%");
            List<Funcionario> lista = query.getResultList();
            return lista;
        } finally {
            em.close();
        }
    }

    //Busca dados pela email e senha
    public Funcionario findFuncionario(String email, String pws) {
        try {
            Query query = em.createQuery(""
                    + "select x from Funcionario as x "
                    + "where x.email = :email and x.pws = :pws");
            query.setParameter("email", email);
            query.setParameter("pws", pws);
            return (Funcionario) query.getSingleResult();
        } finally {
            em.close();
        }
    }

}
