<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Login to Repibum</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">

<link href="<%=request.getContextPath()%>/css/login.css"
	rel="stylesheet" type="text/css">
</head>
<body>
<!-- navbar section-->
	<nav class="navbar navbar-expand-lg navbar-light bg-dark py-3">
		<div class="container">
			<a class="navbar-brand" href="<%=request.getContextPath()%>/home">
				<h2 class="text-white pt-1">Repibum</h2>
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
					<!--ms-autoで右側に寄せる-->
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/listRecipe">れしぴ</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/register">とうろく</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/logout">ろぐあうと</a></li>
					<!-- ↓ ボタン機能のコード-->
					<!--  <button class="btn btn-primary ms-2">追加</button> -->
				</ul>
			</div>
		</div>
	</nav>
	<!-- navbar section-->
	
	<!-- form section -->
	<div class="login-page">
		<div class="form">
			<!-- <form class="register-form">
				form
				<input type="text" placeholder="name" /> <input type="password"
					placeholder="password" /> <input type="text"
					placeholder="email address" />
				<button>create</button>
				<p class="message">
					Already registered? <a href="#">Sign In</a>
				</p>
			</form> -->
			<!-- register-form -->

			<form class="login-form" method="post">
				<!-- form -->
				<input type="text" name="loginId" placeholder="ユーザーID" /> <input
					type="password" name="loginPass" placeholder="パスワード" />
				<c:if test="${not empty error}">
					<p class="caution">ユーザーID or パスワードが違います</p>
				</c:if>
				<button type="submit" value="ログイン">ログイン</button>
				<p class="message">
					登録されていませんか？ <a href="#">ーーアカウントを作成するーー</a>
				</p>
			</form>
			<!-- login-form -->
		</div>
	</div>
	<!-- form section -->

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>