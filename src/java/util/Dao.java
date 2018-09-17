package util;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Dao<Entitys extends EntitysBase> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("lomoj");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = null;

    //Busca pelo ID
    public Entitys findById(Class<Entitys> clazz, Long id) {
        return em.find(clazz, id);
    }

    //Salvar e Atualizar
    public void saveOrUpdate(Entitys obj) {
        try {
            et.begin();
            if (obj.getId() == null) {
                em.persist(obj);
            } else {
                em.merge(obj);
            }
            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
        }

    }

    //Remover
    public void remove(Class<Entitys> clazz, Long id) {
        Entitys t = findById(clazz, id);
        try {
            et.begin();
            em.remove(t);
            et.commit();
        } catch (Exception e) {
            et.rollback();
        }
    }

    //Buscar todos por nomes
    public List<Entitys> finds(String dado) {
        try {
            Query query = em.createQuery("select x from Entitys as x where x.nome like :dados and x.ativo = 1");
            query.setParameter("dados", dado + "%");
            List<Entitys> lista = query.getResultList();
            return lista;
        } finally {
            em.close();
        }
    }

    //Busca dados pela email e senha
    public Entitys findAccess(String email, String pws) {
        try {
            Query query = em.createQuery(""
                    + "select x from Entitys as x "
                    + "where x.email = :email and x.pws = :pws and x.ativo = 1");
            query.setParameter("email", email);
            query.setParameter("pws", pws);
            return (Entitys) query.getSingleResult();
        } finally {
            em.close();
        }
    }

}
