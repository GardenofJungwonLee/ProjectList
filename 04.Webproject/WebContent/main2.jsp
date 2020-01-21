<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WHO ARE YOU &mdash; Colorlib Website Template</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,700,900|Oswald:400,700">
<link rel="stylesheet" href="main/fonts/icomoon/style.css">

<link rel="stylesheet" href="main/css/bootstrap.min.css">
<link rel="stylesheet" href="main/css/magnific-popup.css">
<link rel="stylesheet" href="main/css/jquery-ui.css">
<link rel="stylesheet" href="main/css/owl.carousel.min.css">
<link rel="stylesheet" href="main/css/owl.theme.default.min.css">
<link rel="stylesheet" href="main/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="main/css/mediaelementplayer.css">
<link rel="stylesheet" href="main/css/animate.css">
<link rel="stylesheet" href="main/fonts/flaticon/font/flaticon.css">
<link rel="stylesheet" href="main/css/fl-bigmug-line.css">


<link rel="stylesheet" href="main/css/aos.css">

<link rel="stylesheet" href="main/css/style.css">

<style>
.ico{
padding:20px 0px 2px 340px;
margin-right:100px;
}
</style>

</head>
<body>
	<div class="site-wrap">

		<div class="site-navbar mt-4">
			<div class="container py-1">
				<div class="row align-items-center">
					<div class="col-8 col-md-8 col-lg-4">
						<h1 class="mb-0">
							<a href="main2.jsp" class="text-white h2 mb-0"><strong>WHO ARE YOU<span class="text-primary">.</span>
							</strong></a>
						</h1>
					</div>
					<div class="col-4 col-md-4 col-lg-8">
						<nav class="site-navigation text-right text-md-right"
							role="navigation">

							<div class="d-inline-block d-lg-none ml-md-0 mr-auto py-3">
								<a href="#" class="site-menu-toggle js-menu-toggle text-white"><span
									class="icon-menu h3"></span></a>
							</div>

							<ul class="site-menu js-clone-nav d-none d-lg-block">
								<li class="active"><a href="main2.jsp">Home</a></li>

								<li><a href="attachment2.jsp">Lovetype</a></li>

								<li class="has-children"><a href="#">Shows</a>
									<ul class="dropdown arrow-top">
										<li><a href="attachintroduce.html">Lovetype</a></li>
										<li class="has-children"><a href="#">Member</a>
											<ul class="dropdown">
											
											
												<li><a href="control?command=member">회원정보확인</a></li>
												<li><a href="updatejoin.jsp">회원정보수정</a></li>
												<li><a href="farewell.jsp">회원탈퇴</a></li>

											</ul></li>
									</ul></li>


								<li><a href="logout">Logout</a></li>
							</ul>
						</nav>
					</div>


				</div>
			</div>
		</div>
	</div>

	<div class="site-mobile-menu">
		<div class="site-mobile-menu-header">
			<div class="site-mobile-menu-close mt-3">
				<span class="icon-close2 js-menu-toggle"></span>
			</div>
		</div>
		<div class="site-mobile-menu-body"></div>
	</div>
	<!-- .site-mobile-menu -->

	<div class="site-blocks-cover overlay"
		style="background-image: url('images/hero_bg_11.jpg');"
		data-aos="fade" data-stellar-background-ratio="0.5" data-aos="fade">
		<div class="container">
			<div class="row align-items-center justify-content-center">
				<div class="col-md-7 text-center" data-aos="fade-up"
					data-aos-delay="400">
					<h1 class="mb-4">
						Welcome! <br>${sessionScope.id}</h1>
					<p>
						<a href="#" class="btn btn-primary px-4 py-3">The way you are</a>
					</p>
				</div>
			</div>
		</div>
	</div>





	<div class="col-md-6 col-lg-3" data-aos="fade-up" data-aos-delay="400">

	</div>


	<div class="bg-primary" data-aos="fade">
		<div class="container">
			<div class="row">


			<!-- 	<a href="https://github.com/Leehyeonjun-HUB "class="icon-github-square text-white ico"><span></span></a>
				<a href="https://github.com/Leehyeonjun-HUB "class="col-2 text-center py-4 social-icon d-block ico"></a>
				<span class="icon-github-square text-white">  </span> 
				<a href="https://github.com/LEEJUNGWON1993" class="col-2 text-center py-4 social-icon d-block"></a>
				<span class="icon-git text-white"></span>
				 -->
				 <a href="https://github.com/Leehyeonjun-HUB "class="icon-github text-white col-2 text-center py-4   ico"></a>
				 
				<a href="https://github.com/LEEJUNGWON1993" class="icon-git text-white col-2 text-center py-4  ico"></a>
			
				
				

			</div>
		</div>
	</div>

	<footer class="site-footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<div class="mb-5">
						<h3 class="footer-heading mb-4">About LEE & LEE</h3>
						<p>We are not sure who we are. But the coarse for knowing me
							is necessary to live happy life.</p>
					</div>

				</div>

				<div class="row">
					<div class="col-md-12">
						<h3 class="footer-heading mb-4">Follow Us</h3>

						<div>
							<a href="https://github.com/Leehyeonjun-HUB " class="pl-0 pr-3"><span
								class="icon-github-square"></span></a> <a
								href="https://github.com/LEEJUNGWON1993" class="pl-3 pr-3"><span
								class="icon-git"></span></a>

						</div>
					</div>
				</div>

			</div>



		</div>
		<div class="row pt-5 mt-5 text-center">
			<div class="col-md-12">
				<p>
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					Copyright &copy;
					<script data-cfasync="false"
						src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
					<script>
						document.write(new Date().getFullYear());
					</script>
					All rights reserved | This template is made with <i
						  aria-hidden="true"></i> by <a
						href="https://colorlib.com" target="_blank">Colorlib</a>
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
				</p>
			</div>

		</div>
		</div>
	</footer>

	</div>

	<script src="main/js/jquery-3.3.1.min.js"></script>
	<script src="main/js/jquery-migrate-3.0.1.min.js"></script>
	<script src="main/js/jquery-ui.js"></script>
	<script src="main/js/popper.min.js"></script>
	<script src="main/js/bootstrap.min.js"></script>
	<script src="main/js/owl.carousel.min.js"></script>
	<script src="main/js/mediaelement-and-player.min.js"></script>
	<script src="main/js/jquery.stellar.min.js"></script>
	<script src="main/js/jquery.countdown.min.js"></script>
	<script src="main/js/jquery.magnific-popup.min.js"></script>
	<script src="main/js/bootstrap-datepicker.min.js"></script>
	<script src="main/js/aos.js"></script>
	<script src="main/js/circleaudioplayer.js"></script>

	<script src="main/js/main.js"></script>
</body>
</html>