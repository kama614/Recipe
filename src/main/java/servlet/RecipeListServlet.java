package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.RecipeDao;
import dto.Recipe;

/**
 * Servlet implementation class RecipeListServlet
 */
@WebServlet("/resipeList")
public class RecipeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// レシピデータの取得をDAOに依頼
			RecipeDao recipeDao = DaoFactory.createRecipeDao(); // RecipeDaoオブジェクトの取得
			List<Recipe> recipeList = recipeDao.findAll(); // RecipeDaoオブジェクトの利用

			// レシピデータをリクエストスコープに保存
			request.setAttribute("resipeList", recipeList);

			request.getRequestDispatcher("/WEB-INF/view/recipeList.jsp")
					.forward(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
			// エラー発生した場合にメッセージを表示
		}
	}

}