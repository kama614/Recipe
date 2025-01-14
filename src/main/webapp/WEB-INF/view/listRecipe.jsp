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
	<div class="bg-dark text-white">
		<h1 class="ms-5">レシピリスト</h1>

	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-4 col-sm-6">
				<!-- card section No.01 -->
				<div class="recipe-list">
					<c:forEach items="${recipeList}" var="recipe">

						<img
							src="${pageContext.request.contextPath}/images/${recipe.images}"
							alt="Recipe Image">

						<c:out value="${recipe.name}" />

						<!-- 画像ファイル名を取得し、画像のURLを動的に生成 -->
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<!-- card section No.01 -->





	<dev> <c:forEach items="${recipeList}" var="recipe">

		<img src="${pageContext.request.contextPath}/images/${recipe.images}"
			alt="Recipe Image">

		<c:out value="${recipe.name}" />

		<!-- 画像ファイル名を取得し、画像のURLを動的に生成 -->

		<!-- <a
			href="${pageContext.request.contextPath}/recipe/details?image=${recipe.images}">
			<img src="${pageContext.request.contextPath}/images/${recipe.images}"
			alt="Recipe Image">
		</a> -->


	</c:forEach> </dev>



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
	<p>
		<a href="<%=request.getContextPath()%>/logout">Logout</a>
	</p>
</body>
</html>