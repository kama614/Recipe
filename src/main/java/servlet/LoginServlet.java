package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.DaoFactory;
import dto.Admin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String loginId = request.getParameter("loginId");
			String loginPass = request.getParameter("loginPass");
			
			if (loginId == null || loginPass == null || loginId.isEmpty() || loginPass.isEmpty()) {
                request.setAttribute("error", "ログインIDとパスワードを入力してください。");
                request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
                return;
            }
			
			AdminDao adminDao = DaoFactory.createAdminDao();
			Admin admin = adminDao.findByLoginIdAndLoginPass(loginId, loginPass);
			
			 if (admin != null) {
	                // セッションにログイン情報を保存
	                request.getSession().setAttribute("loggedInAdminId", admin.getLoginId());
	                response.sendRedirect("listRecipe");
	            } else {
	                // エラーメッセージ設定
	                request.setAttribute("error", "ログインIDまたはパスワードが正しくありません。");
	                request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	            }

		} catch (Exception e) {
			 e.printStackTrace(); // デバッグ用。運用環境ではロガーを使用してください。
			    throw new ServletException("ログイン処理中にエラーが発生しました。", e);
		}

	}

}
