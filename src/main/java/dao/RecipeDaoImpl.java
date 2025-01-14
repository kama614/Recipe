package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dto.Recipe;

public class RecipeDaoImpl implements RecipeDao {

	private DataSource ds;

	public RecipeDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	//	レシピ一覧で全レシピの取得と表示(ListRecipeServlet)
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
		} catch (SQLException e) {
			System.err.println("Database error occurred:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}catch(Exception e) {
			System.err.println("Unexpected error occurred:" +e.getMessage());
			e.printStackTrace();
			throw e;
		}

		return recipeList;
	}

	public Recipe findById(Integer id) throws Exception {
		Recipe recipe = new Recipe();

		try (Connection con = ds.getConnection()) {
			String sql = " SELECT "
					+ " recipe.id, recipe.name, recipe.detail, "
					+ " recipe.url, recipe.images "
					+ " FROM recipe "
					+ " WHERE recipe.id = ?";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setObject(1, id, Types.INTEGER);

			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				recipe = mapToRecipe(rs);
			}

		} catch (SQLException e) {
			System.err.println("Database error occurred:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}catch(Exception e) {
			System.err.println("Unexpected error occurred:" +e.getMessage());
			e.printStackTrace();
			throw e;
		}

		return recipe;

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
		try (Connection con = ds.getConnection()) {
			String sql = "UPDATE recipe "
					+ " SET name = ?, detail = ?, url = ?, images = ? "
					+ " WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, recipe.getName());
			stmt.setString(2, recipe.getDetail());
			stmt.setString(3, recipe.getUrl());
			stmt.setString(4, recipe.getImages());
			stmt.setObject(5, recipe.getId(), Types.INTEGER);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(Recipe recipe) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "DELETE FROM recipe WHERE id = ? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, recipe.getId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	private Recipe mapToRecipe(ResultSet rs) throws Exception {
		Integer id = (Integer) rs.getObject("id");
		String name = rs.getString("name");
		String detail = rs.getString("detail");
		String url = rs.getString("url");
		String images = rs.getString("images");

		return new Recipe(id, name, detail, url, images);
	}

}
