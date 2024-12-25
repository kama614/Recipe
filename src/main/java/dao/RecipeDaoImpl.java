package dao;

import java.util.List;

import javax.sql.DataSource;

import dto.Recipe;

public class RecipeDaoImpl implements RecipeDao {
	
private DataSource ds;
	
	public RecipeDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Recipe> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<Recipe> findRecommended() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void add(Recipe recipe) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Recipe recipe) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void delete(Recipe recipe) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
