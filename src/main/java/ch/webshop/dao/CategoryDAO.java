package ch.webshop.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import ch.webshop.dao.mapper.CategoryMapper;
import ch.webshop.representation.Category;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(CategoryMapper.class)
public interface CategoryDAO {

	@GetGeneratedKeys
	@SqlUpdate("INSERT INTO category(id, name) VALUES (:id, :name)")
	int createCategory(@Bind("id") final int id, @Bind("name") final String name);

	@SqlQuery("SELECT * FROM category WHERE id = :id")
	Category readCategoryById(@Bind("id") final int id);



	@SqlUpdate("DELETE FROM category WHERE id = :id")
	void deleteCategoryById(@Bind("id") final int id);

	@SqlQuery("SELECT * FROM category")
	 List<Category> getAll();
}
