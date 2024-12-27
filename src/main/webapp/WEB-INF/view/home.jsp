<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Repibum</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/home.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<style>
.hero {
    background-image: url(images/cook_photo01.jpg);
    background-position: center;
    background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
    position: relative;
    z-index: 2;
}
</style>
</head>
<body>
	<!-- navbar section-->
	<nav class="navbar navbar-expand-lg navbar-light bg-dark py-3">
		<div class="container">
			<a class="navbar-brand" href="#">
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
					<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Features</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Pricing</a>
					</li>
					<!-- ↓ ボタン機能のコード-->
					<!--  <button class="btn btn-primary ms-2">追加</button> -->
				</ul>
			</div>
		</div>
	</nav>
	<!-- navbar section-->

	<!-- hero section -->
	<div class="hero vh-100 d-flex align-items-center" id="home">
		<div class="container">
			<div class="row">
				<div class="col-lg-7 mx-auto text-center">
					<h1 class="display-4 text-white">Recipe page</h1>
					<p class="text-white my-3">Lorem ipsum dolor sit amet
						consectetur adipisicing elit. Soluta, esse illum earum magni ea
						molestias laudantium, quibusdam eum minima ullam vitae quam
						corrupti eos dolorum dolore quo sapiente iusto. Quae.</p>
					<!-- ↓ ボタン機能のコード二個 -->
					<a href="#" class="btn btn-primary me-2">レシピ一覧 / 追加登録</a>
					<!-- <a href="#" class="btn btn-outline-light">Go Page</a> -->
				</div>
			</div>
		</div>
	</div>
	<!-- hero section -->


	<!-- Projects section -->
	<section id="projects">
		<div class="container-fluid">
			<div class="row g-3">
				<div class="col-md-8 mx-auto text-center">
					<!-- <h6 class="text-primary">ーーーーー</h6> -->
					<h1>旬の食材</h1>
					<!-- <p>
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem, eum.
                    </p> -->
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-sm-6">
					<!-- card section No.01 -->
					<div class="project">
						<img src="./images/vegetables01.jpg" alt="">
						<div class="overlay">
							<div>
								<h4 class="text-white">白菜</h4>
								<h6 class="text-white"></h6>
							</div>
						</div>
					</div>
				</div>
				<!-- card section No.01 -->
				<div class="col-lg-4 col-sm-6">
					<!-- card section No.02 -->
					<div class="project">
						<img src="./images/vegetables02.jpg" alt="">
						<div class="overlay">
							<div>
								<h4 class="text-white">菜の花</h4>
								<h6 class="text-white"></h6>
							</div>
						</div>
					</div>
				</div>
				<!-- card section No.02 -->
				<div class="col-lg-4 col-sm-6">
					<!-- card section No.03 -->
					<div class="project">
						<img src="./images/vegetables03.jpg" alt="">
						<div class="overlay">
							<div>
								<h4 class="text-white">ながいも</h4>
								<h6 class="text-white"></h6>
							</div>
						</div>
					</div>
				</div>
				<!-- card section No.03 -->
				<div class="col-lg-4 col-sm-6">
					<!-- card section No.04 -->
					<div class="project">
						<img src="./images/vegetables04.jpg" alt="">
						<div class="overlay">
							<div>
								<h4 class="text-white">だいこん</h4>
								<h6 class="text-white"></h6>
							</div>
						</div>
					</div>
				</div>
				<!-- card section No.04 -->
				<div class="col-lg-4 col-sm-6">
					<!-- card section No.05 -->
					<div class="project">
						<img src="./images/vegetables05.jpg" alt="">
						<div class="overlay">
							<div>
								<h4 class="text-white">ごぼう</h4>
								<h6 class="text-white"></h6>
							</div>
						</div>
					</div>
				</div>
				<!-- card section No.05 -->
				<div class="col-lg-4 col-sm-6">
					<!-- card section No.06 -->
					<div class="project">
						<img src="./images/vegetables06.jpg" alt="">
						<div class="overlay">
							<div>
								<h4 class="text-white">キャベツ</h4>
								<h6 class="text-white"></h6>
							</div>
						</div>
					</div>
				</div>
				<!-- card section No.06 -->
			</div>
		</div>
	</section>
	<!-- Projects section -->

	<!-- Service section -->
	<section id="service">
		<div class="container">
			<div class="row">
				<div class="col-md-8 mx-auto text-center">
					<h6 class="text-primary">SERVICES</h6>
					<h1>Service</h1>
					<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
						Voluptatem, eum.</p>
				</div>
			</div>
			<div class="row g-4">
				<div class="col-lg-4 col-sm-6">
					<!-- card section No.01 -->
					<div class="service card-effect">
						<div class="iconbox">
							<i class='bx bxs-comment-detail'></i>
						</div>
						<h5 class="mt-4 mb-2">Service</h5>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Reiciendis ex illum fugiat sunt consequuntur atque?</p>
					</div>
				</div>
				<!-- No.01 -->
				<div class="col-lg-4 col-sm-6">
					<!-- card section No.02 -->
					<div class="service card-effect">
						<div class="iconbox">
							<i class='bx bxs-comment-detail'></i>
						</div>
						<h5 class="mt-4 mb-2">Service</h5>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Reiciendis ex illum fugiat sunt consequuntur atque?</p>
					</div>
				</div>
				<!-- No.02 -->
				<div class="col-lg-4 col-sm-6">
					<!-- card section No.03 -->
					<div class="service card-effect">
						<div class="iconbox">
							<i class='bx bxs-comment-detail'></i>
						</div>
						<h5 class="mt-4 mb-2">Service</h5>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Reiciendis ex illum fugiat sunt consequuntur atque?</p>
					</div>
				</div>
				<!-- No.03 -->

			</div>
		</div>
	</section>
	<!-- Service section -->

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>