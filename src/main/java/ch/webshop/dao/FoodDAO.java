package ch.webshop.dao;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import ch.webshop.dao.mapper.FoodMapper;
import ch.webshop.representation.Food;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(FoodMapper.class)
public interface FoodDAO {

	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO food(id, description, price) VALUES (:id, :description, :price)")
	int createFood(@Bind("id") final int id, @Bind("description") final String description,
				   @Bind("price") final double price);

	@SqlQuery("SELECT * FROM food WHERE id = :id")
	@Nullable
	Food readFoodById(@Bind("id") @Nonnull final int id);

	@SqlUpdate("DELETE FROM food WHERE id = :id")
	void deleteFoodById(@Bind("id") @Nonnull final int id);


	@SqlQuery("SELECT * FROM food")
	List<Food> getAll();
}
