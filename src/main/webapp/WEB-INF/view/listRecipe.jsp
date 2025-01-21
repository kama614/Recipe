<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>レシピリスト</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link href="<%=request.getContextPath()%>/css/listRecipe.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<!-- navbar section-->
	<nav class="navbar navbar-expand-lg navbar-light bg-dark py-3">
		<div class="container">
			<a class="navbar-brand" href="<%=request.getContextPath()%>/home">
				<h2 class="text-white pt-1">Repibum</h2>
			</a>
			<div class="text-white">
				<h1 class="me-5">レシピリスト</h1>

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
					<li class="nav-item">
						<form action="<%=request.getContextPath()%>/logout" method="post"
							style="display: inline;">
							<button type="submit" class="btn btn-link nav-link">
								ろぐあうと</button>
						</form>
					</li>
					<!-- ↓ ボタン機能のコード-->
					<!--  <button class="btn btn-primary ms-2">追加</button> -->
				</ul>
			</div>
		</div>
	</nav>
	<!-- navbar section-->

	<!-- list section -->
	<div class="container-fluid">
		<div class="row">
			<!-- card section No.01 -->
			<div class="recipe-list col-12 d-flex flex-wrap">
				<!-- d-flex: 子要素をFlexboxでレイアウトします。
				 flex-wrap: 幅が狭くなった際に要素が折り返されます。 -->
				<c:forEach items="${recipeList}" var="recipe">
					<div class="card text-center me-3">
						<a href="<%=request.getContextPath()%>/showRecipe"> <!--  me-3: Bootstrapのマージンユーティリティを使って、各要素の間にスペースを追加。 -->
							<img
							src="${pageContext.request.contextPath}/images/${recipe.images}"
							alt="Recipe Image" class="img-fluid"> <!-- img-fluid: 画像サイズを自動調整してレスポンシブにします。 -->
							<p class="recipe-name">
								<c:out value="${recipe.name}" />
							</p>
						</a>
					</div>
					<!-- 画像ファイル名を取得し、画像のURLを動的に生成 -->
				</c:forEach>
			</div>
			<!-- card section No.01 -->
		</div>
	</div>



	<!-- list section -->







	<%-- <tr>
			<th>ID</th>
			<th>料理名</th>
			<th>材料・調味料・作り方</th>
			<th>URL</th>
			<th>画像</th>
		</tr>
		<c:forEach items="${recipeList}" var="recipe">
			<tr>
				<td><c:out value="${recipe.id}" /></td>
				<td><c:out value="${recipe.name}" /></td>
				<td><c:out value="${recipe.detail}" /></td>
				<td><c:out value="${recipe.url}" /></td>
				<td><img
					src="${pageContext.request.contextPath}/images/${recipe.images}"
					alt="Recipe Image"></td>
				<!-- 画像ファイル名を取得し、画像のURLを動的に生成 -->
			</tr>
		</c:forEach> --%>

	<!-- レシピ登録画面の登録画面に移動するURLつける -->
	<%-- <p>
		<a href="<%=request.getContextPath()%>/logout">Logout</a>
		<a href="<%=request.getContextPath()%>/logout" class="btn btn-light me-2">ログアウト</a>
	</p> --%>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>