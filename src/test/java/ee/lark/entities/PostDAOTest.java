package ee.lark.entities;

import junit.framework.TestCase;
import org.junit.*;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Ignore
public class PostDAOTest extends TestCase {

    PostDAO postDAO;

    @Before
    protected void setUp() throws NamingException, SQLException {
        Context context = EJBContainer.createEJBContainer().getContext();
        postDAO = (PostDAO) context.lookup("java:global/classes/PostDAO");
    }

    @Test
    public void testCreate() {

        UUID id = UUID.fromString("f55f0fba-5c88-421c-808f-76d0e8162ea8");
        User user = new User(id, "Nikita", "Lark");
        Post post = new Post("Title", "Text", user);

        postDAO.create(post);

        List<Post> list = postDAO.list(PostDAO.OrderBy.CREATED_AT_DESC, 100);
        assertEquals("The count of posts in the database", 1, list.size());
    }
}
