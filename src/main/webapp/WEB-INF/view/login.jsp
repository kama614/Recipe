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
	<div class="login-page">
        <div class="form">
          <form class="register-form">
            <input type="text" placeholder="name"/>
            <input type="password" placeholder="password"/>
            <input type="text" placeholder="email address"/>
            <button>create</button>
            <p class="message">Already registered? <a href="#">Sign In</a></p>
          </form>
          <form class="login-form">
            <input type="text" placeholder="ユーザーID"/>
            <input type="password" placeholder="パスワード"/>
            <button>ログイン</button>
            <p class="message">登録されていませんか？ <a href="#">ーーアカウントを作成するーー</a></p>
          </form>
        </div>
      </div>
</body>
</html>