package ee.lark.resources;

import ee.lark.entities.PostDAO;
import ee.lark.services.UserService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

@Ignore
public class PostResourceTest extends JerseyTest {

    public static PostDAO postDAOMock = Mockito.mock(PostDAO.class);
    public static UserService userServiceMock = Mockito.mock(UserService.class);

    @Override
    protected Application configure() {
        return new ResourceConfig(
                PostResource.class,
                PostDAO.class,
                UserService.class
        );
    }

    @Test
    public void testCreatePost() {
        throw new NotImplementedException();
    }
}
