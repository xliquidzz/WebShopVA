package ch.webshop.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;

import ch.webshop.dao.FoodDAO;
import ch.webshop.representation.Food;

@Path("/food")
@Produces(MediaType.APPLICATION_JSON)
public class FoodResource {
    private final FoodDAO foodDAO;

    public FoodResource(@Nonnull final DBI dbi) {
        foodDAO = dbi.onDemand(FoodDAO.class);
    }

    @GET
    public List<Food> getFoodList() {
        return foodDAO.getAll();
    }

    @POST
    public @Nonnull Response createFood(@Valid @Nonnull final Food food) throws URISyntaxException {
        final long newFoodId = foodDAO.createFood(food.getId(), food.getDescription(), food.getPrice());
        return Response.created(new URI(String.valueOf(newFoodId))).build();
    }

    @GET
    @Path("/{id}")
    public @Nonnull Response readFood(@PathParam("id") @Nonnull final int id) {
        final Food food = foodDAO.readFoodById(id);
        if (food == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(food).build();
    }

    @DELETE
    @Path("/{id}")
    public @Nonnull Response deleteFood(@PathParam("id") @Nonnull final int id) {
    	if (foodDAO.readFoodById(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    	foodDAO.deleteFoodById(id);
    	return Response.noContent().build();
    }
}
