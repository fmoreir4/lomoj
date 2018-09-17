package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ConectaJPA {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("lomojPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = null;
}
