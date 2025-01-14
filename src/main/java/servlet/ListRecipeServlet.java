// レシピ一覧のページ
package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.RecipeDao;
import dto.Recipe;

@WebServlet("/listRecipe")
public class ListRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッションの確認
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("loginId") == null) {
			response.sendRedirect("login");// ログイン画面にリダイレクト
			return;
		}

		try {
			// レシピデータの取得をDAOに依頼
			RecipeDao recipeDao = DaoFactory.createRecipeDao(); // RecipeDaoオブジェクトの取得
			List<Recipe> recipeList = recipeDao.findAll(); // RecipeDaoオブジェクトの利用

			// レシピデータをリクエストスコープに保存
			request.setAttribute("recipeList", recipeList);

			// レシピ一覧画面にフォワード
			request.getRequestDispatcher("/WEB-INF/view/listRecipe.jsp")
					.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();// デバッグ用。運用環境ではロガーを使用してください。
			throw new ServletException("レシピ一覧の取得中にエラーが発生しました。", e);
			// エラー発生した場合にメッセージを表示
		}
	}

}