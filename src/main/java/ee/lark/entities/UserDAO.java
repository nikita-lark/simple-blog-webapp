package ee.lark.entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Stateless
public class UserDAO {

    @PersistenceContext(unitName = "h2")
    private EntityManager entityManager;

    public User find(UUID id) {
        return entityManager.find(User.class, id);
    }

    /**
     * Saves the User.
     *
     * @param user
     * @return User the persisted User entity
     */
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }
}
