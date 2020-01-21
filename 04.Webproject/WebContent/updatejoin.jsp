<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>WHO ARE YOU &mdash; Colorlib Website Template</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,700,900|Oswald:400,700">
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

</head>
<body>


<div class="site-wrap">

    <div class="site-navbar mt-4">
      <div class="container py-1">
        <div class="row align-items-center">
          <div class="col-8 col-md-8 col-lg-4">
            <h1 class="mb-0"><a href="main2.jsp" class="text-white h2 mb-0"><strong>WHO ARE YOU<span
                    class="text-primary">.</span></strong></a></h1>
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
          <div class="col-4 col-md-4 col-lg-8">
            <nav class="site-navigation text-right text-md-right" role="navigation">

              <div class="d-inline-block d-lg-none ml-md-0 mr-auto py-3"><a href="#"
                  class="site-menu-toggle js-menu-toggle text-white"><span class="icon-menu h3"></span></a></div>

              <ul class="site-menu js-clone-nav d-none d-lg-block">
               
                  
            
              </ul>
            </nav>
          </div>


        </div>
      </div>
    </div>
  </div>

 

  <div class="site-blocks-cover inner-page-cover overlay" style="background-image: url('images/hero_bg_11.jpg');"
    data-aos="fade" data-stellar-background-ratio="0.5" data-aos="fade">
    <div class="container">
      <div class="row align-items-center justify-content-center">
        <div class="col-md-7 text-center" data-aos="fade-up" data-aos-delay="400">
  
          <h1 class="text-white"> Modification</h1>
          
        </div>
      </div>
    </div>
  </div>

  <div class="site-section">
    <div class="container">
      <div class="row align-items-center">
      



        </div>

        <div class="col-lg-4 mb-5 mb-lg-0">
          <div class="mb-5">
            <h3 class="footer-heading mb-4">회원 정보 수정</h3> 
              
              
              
            
       
 <form action="control" class="contact-form" method="post">
  		<input type="hidden" name="command" value="memberUpdate"> 
  		<input type="hidden" name="id" value="${sessionScope.id}"> 
           
           <div class="row form-group">
							<div class="col-md-12">
								<label class="font-weight-bold">ID</label> ${sessionScope.id}
							</div>
						</div>
						
            <div class="row form-group">
              <div class="col-md-12">
                <label class="font-weight-bold" for="pw">PassWord</label>
                <input type="text" name="pw" class="form-control" value="${sessionScope.member.pw}" maxlength="50">
              </div>
            </div>
       
            
            <div class="row form-group">
              <div class="col-md-12">
                <label class="font-weight-bold" for="name">Name</label>
             <input type="text" name="name" class="form-control" value="${sessionScope.member.name}" maxlength="50">
              </div>
            </div>

   <div class="row form-group">
              <div class="col-md-12">
                <label class="font-weight-bold" for="age">Age</label>
                  <input type="text" name="age" class="form-control" value="${sessionScope.member.age}" maxlength="50">
               </div>
            </div>
             <div class="row form-group">
              <div class="col-md-12">
                <label class="font-weight-bold" for="sex">Gender</label>
                  <input type="text" name="sex" class="form-control" value="${sessionScope.member.sex}" maxlength="50">
               </div>
            </div>
            
              <div class="row form-group">
              <div class="col-md-12">
                <label class="font-weight-bold" for="birthday">Birthday</label>
                 <input type="text" name="birthday" class="form-control" value="${sessionScope.member.birthday}" maxlength="50">
                </div>
            </div>
  
  
            <div class="row form-group">
              <div class="col-md-12">
                <label class="font-weight-bold" for="address">Address</label>
                <textarea name="address" cols="20" rows="2" class="form-control"
                  placeholder="주소를 입력하세요"></textarea>
              </div>
            </div>
  
     <div class="row form-group">
              <div class="col-md-12">
                <label class="font-weight-bold" for="job">Job</label>
                <input type="text" name="job" class="form-control" value="${sessionScope.member.job}" maxlength="50">
              </div>
            </div>
            
               <div class="row form-group">
              <div class="col-md-12">
                <label class="font-weight-bold" for="height">Height</label>
                 <input type="text" name="height" class="form-control" value="${sessionScope.member.height}" maxlength="50">
                </div>
            </div>
            
  
            <div class="row form-group">
              <div class="col-md-12">
                <input type="submit" value="수정" class="btn btn-primary py-3 px-4">
            
             &nbsp;&nbsp;&nbsp;   <input type="button" value="HOME" onclick="location.href='main2.jsp'" class="btn btn-primary py-3 px-4">
              </div>
            </div>
  
          </form>

      </div>
   
          
          
          
          
           
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