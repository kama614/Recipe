package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
		List<Recipe> recipeList = new ArrayList<>();

		try (Connection con = ds.getConnection()) {

			String sql = "SELECT "
					+ " recipe.id, recipe.name, recipe.detail, "
					+ " recipe.url, recipe.images "
					+ " FROM recipe ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				recipeList.add(mapToRecipe(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return recipeList;
	}

	private Recipe mapToRecipe(ResultSet rs) throws Exception {
		Integer id = (Integer) rs.getObject("id");
		String name = rs.getString("name");
		String detail = rs.getString("detail");
		String url = rs.getString("url");
		String images = rs.getString("images");

		return new Recipe(id, name, detail, url, images);
	}

	@Override
	public List<Recipe> findRecommended() throws Exception {
		// そのうち記述する。多分。
		return null;
	}

	@Override
	public void add(Recipe recipe) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "INSERT INTO recipe "
					+ " (name, detail ,url, images) "
					+ " VALUES(?, ?, ?, ?) ";
			var stmt = con.prepareStatement(sql);
			stmt.setString(1, recipe.getName());
			stmt.setString(2, recipe.getDetail());
			stmt.setString(3, recipe.getUrl());
			stmt.setString(4, recipe.getImages());

			stmt.executeUpdate();
		}
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
