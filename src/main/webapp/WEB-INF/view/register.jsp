<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>レシピの登録</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/register.css" type="text/css">

</head>
<body>
	<!-- navbar section-->
	<nav class="navbar navbar-expand-lg navbar-light bg-dark py-3">
		<div class="container">
			<a class="navbar-brand" href="<%=request.getContextPath()%>/home">
				<h2 class="text-white pt-1">Repibum</h2>
			</a>
			<div>
				<h1 class="me-5">レシピの登録</h1>
			</div>
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

	<!-- register section -->
	<div class="register-page">
		<form class="register-form" action="register" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<th>料理名</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>詳細</th>
					<td><textarea name="detail" id="" cols="50" rows="10"></textarea></td>
				</tr>
				<tr>
					<th>URL</th>
					<td><input type="text" name="url"></td>
				</tr>
				<tr>
					<th>写真</th>
					<td><input type="file" name="images"></td>
				</tr>
			</table>
			<button type="submit" value="登録する">登録する</button>
			<!-- <button type="reset" value="リセット">リセット</button> -->
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>