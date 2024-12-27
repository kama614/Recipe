<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>レシピ詳細</title>
<link href="<%=request.getContextPath()%>/css/listRecipe.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<h1>レシピ詳細</h1>
	<table>
		<tr>
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
		</c:forEach>
	</table>
	<!-- レシピ登録画面の登録画面に移動するURLつける -->
	<p>
		<a href="<%=request.getContextPath()%>/logout">Logout</a>
	</p>
</body>
</html>