<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Login to Repibum</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
	<div class="login-page">
		<div class="form">
			<form class="register-form">
				<!-- form -->
				<input type="text" placeholder="name" /> <input type="password"
					placeholder="password" /> <input type="text"
					placeholder="email address" />
				<button>create</button>
				<p class="message">
					Already registered? <a href="#">Sign In</a>
				</p>
			</form>
			<!-- register-form -->
			<form class="login-form" method="post">
				<!-- form -->
				<input type="text" name="loginId" placeholder="ユーザーID" /> <input
					type="password" name="loginPass" placeholder="パスワード" />
				<button type="submit" value="ログイン">ログイン</button>
				<p class="message">
					登録されていませんか？ <a href="#">ーーアカウントを作成するーー</a>
				</p>
			</form>
			<!-- login-form -->
		</div>
	</div>
</body>
</html>