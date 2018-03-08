package ee.lark.resources;

import ee.lark.entities.Post;
import ee.lark.entities.PostDAO;
import ee.lark.entities.User;
import ee.lark.services.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

/**
 * The root resource (exposed at "posts" path).
 */
@Path("posts")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
public class PostResource {

    @Inject
    private PostDAO postDAO;

    @Inject
    private UserService userService;

    /**
     * Returns the list of Posts.
     *
     * @param searchTerm the search term which is passed to the hibernate search engine
     * @param orderBy the parameter which specifies the order of the list
     * @return List<Post> the list of Posts
     */
    @GET
    public List<Post> list(
            @QueryParam("search") String searchTerm,
            @QueryParam("orderby") String orderBy
    ) {
        if (searchTerm != null &&! searchTerm.trim().isEmpty()) {
            return postDAO.search(searchTerm, 100);
        }
        //TODO! remove the mock
        PostDAO.OrderBy orderByMock = PostDAO.OrderBy.CREATED_AT_DESC;
        return postDAO.list(orderByMock, 100);
    }

    /**
     * Returns the Post by ID.
     * @param id the id of the Post
     * @return Post
     */
    @GET
    @Path("/{id}")
    public Post get(@PathParam("id") UUID id) {
        return postDAO.find(id);
    }

    /**
     * Creates the Post. Returns the HTTP status code 201.
     *
     * @param post
     * @return Response the JSON representation of the Post entity
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Post post) {
        User user = userService.selectOrCreate(
                UUID.fromString(UserService.TEST_USER_ID)
        );
        post.setUser(user);
        post = postDAO.create(post);
        return Response.status(Response.Status.CREATED).entity(post).build();
    }

    /**
     * Updates the Post.
     *
     * @param post
     * @return Post the updated Post entity
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Post update(Post post) {
        //TODO! figure out why sub resources are not deserialized
        //TODO! figure out how to skip nulls from the merge
        // a quick fix for preventing the PUT operation from failing
        User user = userService.selectOrCreate(
                UUID.fromString(UserService.TEST_USER_ID)
        );
        post.setUser(user);
        return postDAO.update(post);
    }

    /**
     * Deletes the Post.
     *
     * @param id the id of the Post
     */
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") UUID id) {
        Post post = postDAO.find(id);
        postDAO.delete(post);
    }
}
