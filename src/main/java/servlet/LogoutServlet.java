// ログアウトの画面。ホーム画面に飛ぶ。
package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		performLogout(request, response);
		/*	
		  
		// セッションを無効化
		request.getSession().invalidate();
		
		// ホーム画面にリダイレクト
		response.sendRedirect(request.getContextPath() + "/home");
		  
		response.sendRedirect():
		ブラウザに「指定されたURLに移動する」よう指示します。
		クライアント側でURLが変更されるため、リロード時に誤動作が発生しません。
			
		request.getContextPath():
		アプリケーションのルートパスを取得するため、homeのパス指定が環境依存にならず安全です。
			
		URLの統一:
		/WEB-INF/view/home.jspに直接アクセスさせるのではなく、home用のコントローラやサーブレットを作成することを推奨します。
		*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		performLogout(request, response);

		/*		// セッションを無効化
				request.getSession().invalidate();
		
				// ホーム画面にリダイレクト
				response.sendRedirect(request.getContextPath() + "/home");
		*/ }

	// doGet,doPostに同じ記述でも問題ないが、メソッドで
	// まとめることで重複コードを排除してメンテナンス性向上
	private void performLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// セッションがあるかチェック（セッションを無効化する前にチェックする）
		boolean isLoggedIn = request.getSession(false) != null &&
				request.getSession().getAttribute("user") != null;

		// セッションを無効化
		if (request.getSession(false) != null) {
			request.getSession().invalidate();
		}

		if(isLoggedIn) {
			// ログイン状態だった場合はホーム画面にリダイレクト
			response.sendRedirect(request.getContextPath() + "/home");
			
		}else {
			// ログアウト状態の場合はそのままホーム画面に留まる
			response.sendRedirect(request.getContextPath() + "/home");
		}
		
	}

}
