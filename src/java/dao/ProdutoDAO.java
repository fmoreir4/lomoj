package dao;

import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Produto;

public class ProdutoDAO extends ConectaJPA {

    //Salvar 
    public void create(Produto dados) throws Exception {
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
    public void edit(Produto dados) throws Exception {
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
                if (findProduto(id) == null) {

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
            Produto dados = null;
            try {
                dados = em.getReference(Produto.class, id);
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
    public Produto findProduto(Long id) {
        try {
            return em.find(Produto.class, id);
        } finally {
            em.close();
        }
    }

    //Buscar todos por nomes
    public List<Produto> findProdutos(String dado) {
        try {
            Query query = em.createQuery("select x from Produto as x where x.nome like :dados and x.ativo = 1");
            query.setParameter("dados", dado + "%");
            List<Produto> lista = query.getResultList();
            return lista;
        } finally {
            em.close();
        }
    }


}
