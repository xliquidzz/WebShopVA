package ch.webshop.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import ch.webshop.representation.Article;

public class ArticleMapper implements ResultSetMapper<Article>{

	public Article map(int index, ResultSet r, StatementContext ctx)
			throws SQLException {
		return new Article(r.getInt("id"),r.getInt("category_id"), r.getString("name"), r.getDouble("price"));
	}
}
