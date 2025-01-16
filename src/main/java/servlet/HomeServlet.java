// ホーム画面を表示。ログイン画面に飛べる。
package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/home.jsp")
				.forward(request, response);

		// サーバー上の指定ディレクトリ内に保存されているファイル一覧を取得する処理
		File filePath = getUploadedDirectory(request);
		// サーバー内の「アップロードされたファイルが保存されているディレクトリ」を取得する
		File[] fileList = filePath.listFiles();
		request.setAttribute("fileList", fileList);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//TODO
		/*
		 * 		ServletContext context = request.getServletContext();
				String imagePath = context.getRealPath("/images/background.jpg"); // 画像の実パス取得
		
				File imageFile = new File(imagePath);
				if (imageFile.exists()) {
				    System.out.println("画像ファイルは存在します: " + imagePath);
				} else {
				    System.out.println("画像ファイルが見つかりません: " + imagePath);
				}
		*/
	}

	private File getUploadedDirectory(HttpServletRequest request) {
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/uploads");
		return new File(path);
	}
}
