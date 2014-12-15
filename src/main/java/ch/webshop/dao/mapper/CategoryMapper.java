package ch.webshop.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import ch.webshop.representation.Category;

public class CategoryMapper implements ResultSetMapper<Category>{

	public Category map(int index, ResultSet r, StatementContext ctx)
			throws SQLException {
		return new Category(r.getInt("id"), r.getString("name"));
	}

}
