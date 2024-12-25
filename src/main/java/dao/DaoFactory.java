package dao;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoFactory {
	public static AdminDao createAdminDao() {
		return new AdminDaoImpl(getDataSource());
	}
	
	public static RecipeDao createCoffeeDao() {
		return new RecipeDaoImpl(getDataSource());
	}

	private static DataSource getDataSource() {
		DataSource ds = null;
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/recipe_album_db");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}



