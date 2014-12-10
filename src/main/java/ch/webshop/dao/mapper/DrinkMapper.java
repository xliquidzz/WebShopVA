package ch.webshop.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import ch.webshop.representation.Drink;

public class DrinkMapper implements ResultSetMapper<Drink>{

	public Drink map(int index, ResultSet r, StatementContext ctx)
			throws SQLException {
		return new Drink(r.getInt("id"), r.getString("description"), r.getDouble("price"));
	}

}
