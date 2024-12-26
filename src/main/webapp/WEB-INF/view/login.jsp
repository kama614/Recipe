<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Login to Repibum</title>
<link rel="stylesheet" href="login.css">
</head>
<body>
	<form action="login" method="post" id="login-form">
		<div class="heading">Login to Repibum</div>
		<div class="left">
			<label for="email">Email or ID</label> <br /> <input type="email"
				name="email" id="email" /> <br /> <label for="password">Password</label>
			<br /> <input type="password" name="password" id="pass" /> <br />
			<input type="submit" value="Login" />
		</div>
		<c:if test="${not empty error}">
		<p style="color: red;">${error}</p>
		</c:if>
		<div class="right">
			<div class="connect">Connect with</div>
			<a href="" class="facebook"> <!--       <span class="fontawesome-facebook"></span> -->
				<i class="fa fa-facebook" aria-hidden="true"></i>
			</a> <br /> <a href="" class="twitter"> <!--       <span class="fontawesome-twitter"></span> -->
				<i class="fa fa-twitter" aria-hidden="true"></i>
			</a> <br /> <a href="" class="google-plus"> <!--       <span class="fontawesome-google-plus"></span> -->
				<i class="fa fa-google-plus" aria-hidden="true"></i>
			</a>
		</div>
	</form>
</body>
</html>