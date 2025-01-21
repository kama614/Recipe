// レシピの詳細を見るためのページ。ListRecipeServletからくる。
package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.RecipeDao;

@WebServlet("/showRecipe")
public class ShowRecipeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッションの確認
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("loginId") == null) {
			response.sendRedirect("login");// ログイン画面にリダイレクト
			return;
		}
		
		try {
			// ?id=○○を取得
			int id = Integer.parseInt(request.getParameter("id"));
			
			// Daoを使い、IDに基づくレシピの詳細を取得
			RecipeDao dao = DaoFactory.createRecipeDao(); // RecipeDaoオブジェクトの取得
			// レシピデータをリクエストスコープに保存
			request.setAttribute("recipe", dao.findById(id));
			
			// レシピ一覧画面にフォワード
			request.getRequestDispatcher("/WEB-INF/view/showRecipe.jsp")
			.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();// デバッグ用。運用環境ではロガーを使用してください。
			throw new ServletException("レシピ詳細の取得中にエラーが発生しました。", e);
			// エラー発生した場合にメッセージを表示
		}

		/*// Get パラメータの取得
		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);
		
		try {
			// レシピデータの取得をDAOに依頼
			RecipeDao recipeDao = DaoFactory.createRecipeDao(); // RecipeDaoオブジェクトの取得
			Recipe recipe = recipeDao.findById(id);
		
			// レシピデータをリクエストスコープに保存
			request.setAttribute("recipe", recipe);
		
			// レシピ一覧画面にフォワード
			request.getRequestDispatcher("/WEB-INF/view/showRecipe.jsp")
					.forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();// デバッグ用。運用環境ではロガーを使用してください。
			throw new ServletException("レシピ詳細の取得中にエラーが発生しました。", e);
			// エラー発生した場合にメッセージを表示
		}
		*/
		
		/*
		try {
			// レシピデータの取得をDAOに依頼
			RecipeDao recipeDao = DaoFactory.createRecipeDao(); // RecipeDaoオブジェクトの取得
			List<Recipe> recipeList = recipeDao.findAll(); // RecipeDaoオブジェクトの利用
		
			// レシピデータをリクエストスコープに保存
			request.setAttribute("recipeList", recipeList);
		
			// レシピ一覧画面にフォワード
			request.getRequestDispatcher("/WEB-INF/view/showRecipe.jsp")
					.forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();// デバッグ用。運用環境ではロガーを使用してください。
			throw new ServletException("レシピ一覧の取得中にエラーが発生しました。", e);
			// エラー発生した場合にメッセージを表示
		}*/
	}

	/*@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);
		
		try {
			// レシピデータの取得をDAOに依頼
			RecipeDao recipeDao = DaoFactory.createRecipeDao(); // RecipeDaoオブジェクトの取得
			Recipe recipe = recipeDao.findById(id);
	
			// レシピデータをリクエストスコープに保存
			request.setAttribute("recipe", recipe);
	
			// レシピ一覧画面にフォワード
			request.getRequestDispatcher("/WEB-INF/view/showRecipe.jsp")
					.forward(request, response);
	
		} catch (Exception e) {
			e.printStackTrace();// デバッグ用。運用環境ではロガーを使用してください。
			throw new ServletException("レシピ詳細の取得中にエラーが発生しました。", e);
			// エラー発生した場合にメッセージを表示
		}
	}*/

}
