package dao;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import model.Endereco;

public class EnderecoDAO extends ConectaJPA {

    //Salvar dados
    public void create(Endereco dados) throws Exception {
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

    //Alterar Endereco
    public void edit(Endereco dados) throws Exception {
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
                String cep = dados.getCep();
                if (findEndereco(cep) == null) {

                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Apagar dados
    public void destroy(String cep) throws Exception {
        et = em.getTransaction();
        try {
            et.begin();
            Endereco dados = null;
            try {
                dados = em.getReference(Endereco.class, cep);
                dados.getCep();
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

    //Busca cliete pelo cep
    public Endereco findEndereco(String cep) {
        try {
            return em.find(Endereco.class, cep);
        } finally {
            em.close();
        }
    }

    //Buscar todos por nomes
    public List<Endereco> findEnderecos(String dado) {
        try {
            Query query = em.createQuery("select e from Endereco as e where e.cep like :dados");
            query.setParameter("dados", dado + "%");
            List<Endereco> dadoss = query.getResultList();
            return dadoss;
        } finally {
            em.close();
        }
    }

}
