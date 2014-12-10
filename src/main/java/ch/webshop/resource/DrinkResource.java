package ch.webshop.resource;

import java.net.URI;
import java.net.URISyntaxException;

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
    private final DrinkDAO DrinkDAO;

    public DrinkResource(@Nonnull final DBI dbi) {
        DrinkDAO = dbi.onDemand(DrinkDAO.class);
    }

    @POST
    public @Nonnull Response createDrink(@Valid @Nonnull final Drink Drink) throws URISyntaxException {
        final long newDrinkId = DrinkDAO.createDrink(Drink.getId(), Drink.getDescription(), Drink.getPrice());
        return Response.created(new URI(String.valueOf(newDrinkId))).build();
    }

    @GET
    @Path("/{id}")
    public @Nonnull Response readDrink(@PathParam("id") @Nonnull final int id) {
        final Drink Drink = DrinkDAO.readDrinkById(id);
        if (Drink == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(Drink).build();
    }

    @DELETE
    @Path("/{id}")
    public @Nonnull Response deleteDrink(@PathParam("id") @Nonnull final int id) {
    	if (DrinkDAO.readDrinkById(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    	DrinkDAO.deleteDrinkById(id);
    	return Response.noContent().build();
    }
}
