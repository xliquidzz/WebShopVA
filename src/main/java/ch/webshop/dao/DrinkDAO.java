package ch.webshop.dao;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import ch.webshop.dao.mapper.DrinkMapper;
import ch.webshop.representation.Drink;

public interface DrinkDAO {

	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO drink(id, description, price) VALUES (:id, :description, :price)")
	int createDrink(@Bind("id") final int id,
					@Bind("description") final String description,
					@Bind("price") final double price);

	@Mapper(DrinkMapper.class)
	@SqlQuery("SELECT * FROM drink WHERE id = :id")
	Drink readDrinkById(@Bind("id") final int id);

	@SqlUpdate("DELETE FROM drink WHERE id = :id")
	void deleteDrinkById(@Bind("id") final int id);
}
