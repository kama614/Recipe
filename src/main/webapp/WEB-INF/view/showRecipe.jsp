<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>レシピ詳細</title>
<link href="<%=request.getContextPath()%>/css/showRecipe.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<h1>レシピ詳細</h1>

	<div class="image">
		<c:if test="${not empty recipe.images}">
			<img src="${pageContext.request.contextPath}/images/${recipe.images}"
				alt="Recipe Image">
		</c:if>
		<c:if test="${empty recipe.images}">
			<p>No image available</p>
		</c:if>
	</div>

	<h3>
		<c:out value="${recipe.name}" />
	</h3>

	<p>材料・調味料・作り方</p>
	<c:out value="${recipe.detail}" />
	
	<c:if test="${not empty recipe.url}">
    <a href="${recipe.url}">URL</a>
</c:if>

<c:if test="${empty recipe.url}">
    <p>No URL provided</p>
</c:if>

</body>
</html>