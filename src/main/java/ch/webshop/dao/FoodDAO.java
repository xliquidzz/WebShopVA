package ch.webshop.dao;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import ch.webshop.dao.mapper.FoodMapper;
import ch.webshop.representation.Food;

public interface FoodDAO {

	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO food(id, description, price) VALUES (:id, :description, :price)")
	int createFood(@Bind("id") final int id, @Bind("description") final String description,
				   @Bind("price") final double price);

	@Mapper(FoodMapper.class)
	@SqlQuery("SELECT * FROM food WHERE id = :id")
	@Nullable
	Food readFoodById(@Bind("id") @Nonnull final int id);

	@SqlUpdate("DELETE FROM food WHERE id = :id")
	void deleteFoodById(@Bind("id") @Nonnull final int id);
}
