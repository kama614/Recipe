// レシピを登録する画面。レシピ一覧からくる。
// 登録出来たら一覧に飛ぶ。ログアウト可能。

package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.DaoFactory;
import dao.RecipeDao;
import dto.Recipe;

@WebServlet("/register")
@MultipartConfig(location = "C:/Users/zd3N02/temp")
// @MultipartConfig(location = "c:/temp")
// 自身のPCならC:の直下に置く
public class RegisterServlet extends HttpServlet {
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
			request.getRequestDispatcher("/WEB-INF/view/register.jsp")
					.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();// デバッグ用。運用環境ではロガーを使用してください。
			throw new ServletException("レシピ一覧の取得中にエラーが発生しました。", e);
			// エラー発生した場合にメッセージを表示
		}

		// サーバー上の指定ディレクトリ内に保存されているファイル一覧を取得する処理
		File filePath = getUploadedDirectory(request);
		// サーバー内の「アップロードされたファイルが保存されているディレクトリ」を取得する
		File[] fileList = filePath.listFiles();
		request.setAttribute("fileList", fileList);

		// デバッグ用にファイルリストをコンソールに表示
		for (File file : fileList) {
			System.out.println(file.getPath());

			/*		
			 利用シナリオ:
				サーバー上のディレクトリに保存されているファイルを一覧表示したい場合。
				例えば、ユーザーがアップロードした画像やドキュメントを一覧として表示する際に利用。
				「サーバーサイドで既に保存されているファイル」を対象とし、
				ファイルの読み込みや削除、一覧表示などの操作が主な用途です。
			*/

			/*
			response.setContentType("text/plain");
			response.getWriter().write("これはサーバーからのデータです！");
			*/
		}

		request.getRequestDispatcher("/WEB-INF/view/register.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// パラメータの取得
		String name = request.getParameter("name");
		String detail = request.getParameter("detail");
		String url = request.getParameter("url");
		String images = request.getParameter("images");

		// データの追加
		Recipe recipe = new Recipe();
		recipe.setName(name);
		recipe.setDetail(detail);
		recipe.setUrl(url);
		recipe.setImages(images);

		try {
			RecipeDao recipeDao = DaoFactory.createRecipeDao();
			recipeDao.add(recipe); // insertメソッドにする？？
			request.getRequestDispatcher("/WEB-INF/view/register.jsp")
					.forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		// アップされたファイルの情報を取得
		Part part = request.getPart("images");
		// HTTPリクエスト（multipart/form-data）で送信されたファイルを受け取る。
		// フォーム内の<input type="file" name="upfile">のname属性が"upfile"の場合、そのアップロードされたファイルにアクセスします。
		// これにはjavax.servlet.http.Partオブジェクトを使用します。
		long fileSize = part.getSize();
		String fileType = part.getContentType();
		String fileName = part.getSubmittedFileName();
		/*	
		利用シナリオ:
			クライアントからアップロードされたファイルを処理したい場合。
			ファイルをサーバーに保存したり、ファイルサイズやタイプをチェックしたりする際に利用。
			「新規にアップロードされたファイル」の処理に特化しており、
			アップロード時の情報取得やサーバーへの保存を行う際に使用します。
		*/
		// アップされたファイルを保存
		if (fileSize > 0) {
			File filePath = getUploadedDirectory(request);
			part.write(filePath + "/" + fileName);
		}

		// 完了画面の表示
		request.setAttribute("fileSize", fileSize);
		request.setAttribute("fileType", fileType);
		request.setAttribute("fileName", fileName);
		request.getRequestDispatcher("/WEB-INF/view/listRecipe.jsp")
				.forward(request, response);

		/*
		// ユーザー入力を取得
		String userInput = request.getParameter("userInput");

				// 入力値を検証
				if (isMalicious(userInput)) {
					// 悪意のある入力を検知した場合、エラーメッセージを返す
					response.setContentType("text/plain");
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					response.getWriter().write("不正な入力が検出されました！");
					return;
		
				}
		
				// 正常な処理を続ける
				response.setContentType("text/plain");
				response.getWriter().write("入力値は正常です: " + escapeHtml(userInput));
		*/
	}

	private File getUploadedDirectory(HttpServletRequest request) {
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/images");
		return new File(path);
	}

	/*
	// 悪意のある入力を検知するメソッド
	private boolean isMalicious(String input) {
		if (input == null || input.isEmpty()) {
			return false;
		}

		//@formatter:off
		// 危険な文字列やパターンを検出
		String[] dangerousPatterns= {
				"<script>","</script>",		// XSSの可能性
				"'","\"","--",";",			// SQLインジェクションの可能性
				"DROP","SELECT","INSERT",	// SQL構文
				"\\$\\{","\\}\\"			// ELインジェクションの可能性
		};
		//@formatter:on

		for (String pattern : dangerousPatterns) {
			if (input.toUpperCase().contains(pattern.toUpperCase())) {
				return true;
			}
		}

		return false;
	}

	// 入力値をエスケープするメソッド(HTMLエスケープ)
	private String escapeHtml(String input) {
		if (input == null) {
			return "";
		}
		return input
				.replace("&", "&amp;")
				.replace("<", "&it;")
				.replace(">", "&gt;")
				.replace("\"", "&quot;")
				.replace("'", "&#39;");
	}
	*/
}
