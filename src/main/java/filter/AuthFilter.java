package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthFilter extends HttpFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		String uri = req.getRequestURI();
		if (!uri.endsWith("/login") || !uri.contains("/css")) { // @WebFilter("/*")の時は記述必要
			// loginサーブレットとCSSのみフィルターがかからない設定
			if (session.getAttribute("loginId") == null) {
				res.sendRedirect(req.getContextPath() + "/login");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
/*
認証用フィルタを適用するURL パターンは「」とし、「loginId」という
セッション変数が存在する場合はログイン済みと判断し、セッション変数が
存在しない場合は未ログインとしてログインページへリダイレクトするという処理を実装

リクエストされたページが何であるかを知るために、
HttpServletRequestインターフェースのgetRequestURI()というメソッドを使用
*/