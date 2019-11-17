package app.repository;

import app.domain.entities.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final EntityManager entityManager;
    private final TransactionUtil transactionUtil;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager, TransactionUtil transactionUtil) {
        this.entityManager = entityManager;
        this.transactionUtil = transactionUtil;
    }

    @Override
    public void save(User user) {
        this.transactionUtil.createTransaction(user);
    }

    @Override
    public User findByUsername(String username, String password) {
        List<User> user =
                this.entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class)
                        .setParameter("username", username)
                        .setParameter("password", DigestUtils.sha256Hex(password)).getResultList();
        if (user.isEmpty()) {
            return null;
        }
        return user.get(0);
    }
}
