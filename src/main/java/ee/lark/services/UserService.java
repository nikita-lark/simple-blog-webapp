package ee.lark.services;

import java.util.UUID;
import ee.lark.entities.User;
import ee.lark.entities.UserDAO;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * A service which has the business logic for managing users.
 */
@Stateless
public class UserService {

    // mock the user
    public static final String TEST_USER_FIRST_NAME = "Nikita";
    public static final String TEST_USER_LAST_NAME = "Lark";
    public static final String TEST_USER_ID = "f55f0fba-5c88-421c-808f-76d0e8162ea8";

    @Inject
    private UserDAO userDao;

    /**
     * Tries to find the User by id. Otherwise, creates a new one.
     *
     * @param userId
     * @return User a User entity
     */
    public User selectOrCreate(UUID userId) {
        // check if the user exists in the storage
        User user = userDao.find(userId);
        if (!(user instanceof User)) {
            // create a new user
            user = new User(userId, TEST_USER_FIRST_NAME, TEST_USER_LAST_NAME);
            user = userDao.create(user);
        }
        return user;
    }
}
