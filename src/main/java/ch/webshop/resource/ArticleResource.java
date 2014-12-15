package ch.webshop.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;

import ch.webshop.dao.ArticleDAO;
import ch.webshop.representation.Article;

@Path("/article")
@Produces(MediaType.APPLICATION_JSON)
public class ArticleResource {
    private final ArticleDAO articleDAO;

    public ArticleResource(final DBI dbi) {
        articleDAO = dbi.onDemand(ArticleDAO.class);
    }

    @GET
    public List<Article> getArticleList() {
        return articleDAO.getAll();
    }

    @POST
    public Response createFood(final Article article) throws URISyntaxException {
        final long newFoodId = articleDAO.createArticle(article.getId(), article.getCategoryId(), article.getName(), article.getPrice());
        return Response.created(new URI(String.valueOf(newFoodId))).build();
    }

    @GET
    @Path("/{id}")
    public Response readFood(@PathParam("id") final int id) {
        final Article article = articleDAO.readArticleById(id);
        if (article == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(article).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteArticle(@PathParam("id") final int id) {
    	if (articleDAO.readArticleById(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    	articleDAO.deleteFoodById(id);
    	return Response.noContent().build();
    }

    @GET
    @Path("/category/{categoryName}")
    public Response readArticlesByCategoryName(@PathParam("categoryName") final String categoryName) {
        List<Article> articles = articleDAO.readArticlesByCategoryName(categoryName);
        if (articleDAO.readArticlesByCategoryName(categoryName) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(articles).build();
    }
}
