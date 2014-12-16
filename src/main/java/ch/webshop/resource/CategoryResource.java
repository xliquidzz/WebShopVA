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

import ch.webshop.dao.CategoryDAO;
import ch.webshop.representation.Category;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {
    private final CategoryDAO categoryDAO;

    public CategoryResource(final DBI dbi) {
        categoryDAO = dbi.onDemand(CategoryDAO.class);
    }

    @POST
    public Response createDrink(final Category category) throws URISyntaxException {
        final long newDrinkId = categoryDAO.createCategory(category.getId(), category.getName());
        return Response.created(new URI(String.valueOf(newDrinkId))).build();
    }

    @GET
    public List<Category> getCategoryList() {
        return categoryDAO.getAll();
    }

    @GET
    @Path("/{id}")
    public Response readCategory(@PathParam("id") final int id) {
        final Category Category = categoryDAO.readCategoryById(id);
        if (Category == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(Category).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCategory(@PathParam("id") final int id) {
        if (categoryDAO.readCategoryById(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        categoryDAO.deleteCategoryById(id);
        return Response.noContent().build();
    }
}
