<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>レシピ詳細</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link href="<%=request.getContextPath()%>/css/showRecipe.css"
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
				<h1 class="me-5">レシピ詳細</h1>

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

	<!-- recipe show section -->
	<div class="show-details container">
		<div class="image">
			<c:if test="${not empty recipe.images}">
				<img
					src="${pageContext.request.contextPath}/images/${recipe.images}"
					alt="Recipe Image">
			</c:if>
			<c:if test="${empty recipe.images}">
				<p>No image available</p>
			</c:if>
		</div>
		<div class="sentence">
			<h3 class="pt-4 pb-2">
				<c:out value="${recipe.name}" />
			</h3>
			<div class="sentence-in">
				<h6 >材料・調味料・作り方</h6>
				<p>
					<c:out value="${recipe.detail}" />
				</p>
			</div>
			<h6 class="showurl">URL：</h6>
			<c:if test="${not empty recipe.url}">
				<a href="${recipe.url}"><c:out value="${recipe.url}" /></a>
			</c:if>

			<c:if test="${empty recipe.url}">
				<p></p>
			</c:if>
		</div>
	</div>
	<!-- recipe show section -->

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>