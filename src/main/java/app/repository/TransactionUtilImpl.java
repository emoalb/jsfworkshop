package app.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class TransactionUtilImpl implements TransactionUtil {
    private final EntityManager entityManager;

    @Inject
    public TransactionUtilImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public <T> void createTransaction(T obj) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
    }
}
