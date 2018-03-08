package ee.lark.entities;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class PostDAO {

    public enum OrderBy {
        CREATED_AT_ASC,
        CREATED_AT_DESC
    }

    @PersistenceContext(unitName = "h2")
    private EntityManager entityManager;

    /**
     * Returns the list of Posts.
     *
     * @param orderBy the parameter which specifies the order of the list
     * @param limit the parameter which specifies the limit of the returned list (default 100)
     * @return List<Post> the list of Posts
     */
    public List<Post> list(OrderBy orderBy, int limit) {
        String query = "select p from Post p";
        switch (orderBy) {
            case CREATED_AT_ASC:
                query += " order by p.createdAt asc";
            case CREATED_AT_DESC:
                query += " order by p.createdAt desc";
        }
        return entityManager
                .createQuery(query, Post.class)
                .setMaxResults(limit)
                .getResultList();
    }

    /**
     * Finds Posts by the search term.
     *
     * @param searchTerm the search term
     * @param limit the parameter which specifies the limit of the returned list (default 100)
     * @return List<Post> the list of found Posts
     */
    public List<Post> search(String searchTerm, int limit) {
        FullTextEntityManager fullTextEM = Search.getFullTextEntityManager(entityManager);
        // create native Lucene query using the query DSL
        QueryBuilder qb = fullTextEM
                .getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Post.class)
                .get();
        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .wildcard()
                .onFields("title", "text", "user.firstName", "user.lastName")
                .matching(searchTerm.toLowerCase())
                .createQuery();
        // wrap Lucene query in a javax.persistence.Query
        javax.persistence.Query jpaQuery = fullTextEM.createFullTextQuery(luceneQuery, Post.class);
        // execute the search
        List result = jpaQuery
                .setMaxResults(limit)
                .getResultList();

        return result;
    }

    /**
     * Finds a Post by id.
     *
     * @param id the id of the Post
     * @return Post
     */
    public Post find(UUID id) {
        return entityManager.find(Post.class, id);
    }

    /**
     * Saves the Post.
     *
     * @param post
     * @return Post the persisted Post entity
     */
    public Post create(Post post) {
        entityManager.persist(post);
        return post;
    }

    /**
     * Updates the Post.
     *
     * @param post
     * @return Post the merged Post entity
     */

    public Post update(Post post) {
        entityManager.merge(post);
        return post;
    }

    /**
     * Deletes the Post.
     *
     * @param Post
     */
    public void delete(Post Post) {
        entityManager.remove(Post);
    }
}
