package dao;

import java.util.List;

import dto.Recipe;

public interface RecipeDao {
	List<Recipe> findAll() throws Exception;

	List<Recipe> findRecommended() throws Exception;

	void add(Recipe recipe) throws Exception;

	void update(Recipe recipe) throws Exception;

	void delete(Recipe recipe) throws Exception;
}
