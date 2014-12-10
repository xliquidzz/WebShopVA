package ch.webshop.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import ch.webshop.representation.Food;

public class FoodMapper implements ResultSetMapper<Food>{

	public Food map(int index, ResultSet r, StatementContext ctx)
			throws SQLException {
		return new Food(r.getInt("id"), r.getString("description"), r.getDouble("price"));
	}

}
