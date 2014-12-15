package ch.webshop.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import ch.webshop.dao.mapper.ArticleMapper;
import ch.webshop.representation.Article;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import java.util.List;

@RegisterMapper(ArticleMapper.class)
public interface ArticleDAO {

	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO article(id, category_id, name, price) VALUES (null, :category_id :name, :price)")
	int createArticle(@Bind("id") final int id,
					  @Bind("category_id") final int category_id,
					  @Bind("name") final String name,
					  @Bind("price") final double price);

	@SqlQuery("SELECT * FROM article WHERE id = :id")
	Article readArticleById(@Bind("id") final int id);

	@SqlUpdate("DELETE FROM article WHERE id = :id")
	void deleteFoodById(@Bind("id") final int id);

	@SqlQuery("SELECT * FROM article")
	List<Article> getAll();

	@SqlQuery("SELECT * FROM article WHERE category_id = (SELECT id FROM category WHERE name=:categoryName)")
	List<Article> readArticlesByCategoryName(@Bind("categoryName")final String categoryName);
}
