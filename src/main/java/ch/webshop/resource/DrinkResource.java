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

import ch.webshop.dao.DrinkDAO;
import ch.webshop.representation.Drink;

@Path("/drink")
@Produces(MediaType.APPLICATION_JSON)
public class DrinkResource {
    private final DrinkDAO drinkDAO;

    public DrinkResource(@Nonnull final DBI dbi) {
        drinkDAO = dbi.onDemand(DrinkDAO.class);
    }

    @POST
    public Response createDrink(final Drink Drink) throws URISyntaxException {
        final long newDrinkId = drinkDAO.createDrink(Drink.getId(), Drink.getDescription(), Drink.getPrice());
        return Response.created(new URI(String.valueOf(newDrinkId))).build();
    }

    @GET
    public List<Drink> getFoodList() {
        return drinkDAO.getAll();
    }

    @GET
    @Path("/{id}")
    public Response readDrink(@PathParam("id") final int id) {
        final Drink Drink = drinkDAO.readDrinkById(id);
        if (Drink == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(Drink).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDrink(@PathParam("id") final int id) {
    	if (drinkDAO.readDrinkById(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    	drinkDAO.deleteDrinkById(id);
    	return Response.noContent().build();
    }
}
