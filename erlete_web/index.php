<!DOCTYPE html>
	<html>
		<head>
			<title>ERLETE EZTIOLA</title>
			<!--We import the extensions that we are going o use for programming the web-->
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></link>

			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

			<Link rel="stylesheet" href="CSS_SD.css"></Link>

			<link rel="icon"  type="image/jpg" href="images/erleaLogo.jfif"></link>
		</head>
		<body> 
			<!--We create the cantainer that is going to have insade all the content-->
			<div class="container-fluid-lg" style="padding:1vw;margin:5vw">
				<!--We set-up the image for the header-->
				<div>
					<img src="images/goiburua1.jpg" style="width: 100%;height: 15vw; border-radius: 3vw;">
				</div>
				<!--We create the nav-bar with its different options-->
				<nav class="navbar mt-4 navbar-expand-sm bg-white sticky-top" style="border: 0.3vw solid yellow; border-radius: 2vw;">
					<ul class="navbar-nav nav-pills flex-fill">
						<li class="nav-item  flex-fill">
						    <a class="nav-link  active bg-warning text-body text-center" href="index.php">HOME</a>						    
						</li>
						<!--We create a dropdown with the different menus inside the beekeper area-->
						<li class="nav-item dropdown flex-fill">
						    <a class="nav-link dropdown-toggle text-body text-center" data-toggle="dropdown">BEEKEPERS AREA</a>
							<!--If an user is logged he wiil be allowed to see the different options in the beekepers area -->
							<?php
								session_start();
								if(isset($_SESSION['Erabiltzailea_aldagai_globala']))
									{														
							?>	
							<div class="dropdown-menu dropdown-menu-right">
						    	<a class="dropdown-item" href="room_booking.php">Room booking</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="bookings.php">Your bookings</a>
						    </div>
							<?php
								}
							?>
						</li>
						<li class="nav-item flex-fill">
						   	<a class="nav-link text-body Zentratu" href="contact.php">CONTACT</a>
						</li>
						<li class="nav-item flex-fill">
							<!--If an user is logged he wiil be allowed to logout -->
						<?php
							
							if(isset($_SESSION['Erabiltzailea_aldagai_globala']))
								{														
						?>							
							<a class="nav-link text-body Zentratu" href="irten.php">LOGOUT
							<?php
							include("test_connect_db.php");
			                $link=connectDataBase();
							$user=$_SESSION['Erabiltzailea_aldagai_globala'];
			                $emaitza=mysqli_query($link,"select name from partner where email='$user'");
							while($erregistroa = mysqli_fetch_array($emaitza)){
								printf($erregistroa[0]);
							}
							
						?>
							</a>
							<!--If a beekeper have an account he could login -->
						<?php
							}else{
						?>
							<a class="nav-link text-body Zentratu" href="login.php">LOGIN</a>
						<?php
							}
						?>	
						</li>
					</ul>
				</nav>
				<!--Some  different paragraphs about Erlete information-->
				<div class="container-fluid pt-4" id="content">
					<h2 class="display-4 pt-4">WHAT IS ERLETE?</h2>
					<p class="pt-4">Erlete is an association created by several small beekeepers from near Durango. Our intention is to carry out a project for honey extraction site so that it can be used by its members.
						Beekeepers extract and package honey in a local in Axpe.</p>
					<h3 class="pt-4">HOW CAN YOU BECOME A MEMBER</h3>
					<p class="pt-4">If someone finds interesting the purpose of our association, they can become a member by filling out a form.
						The price of the annual fee is 30€, which will be charged at the time the person makes the subscription, in the case of the following years the fee will be charged on January 1st.</p>
					<p>In case that any member wants to unsubscribe, they will have to notify the accountant before December 15th.</p>
					<h3 class="pt-4">HOW CAN YOU EXTRACT YOUR HONEY</h3>
					<p class="pt-4">Our partners will have the option of booking the extraction room that we have in our Axpe center. For this purpose they will find three different options in our Beekeper area: </p>
						 <p>On the one hand, they will be able to see the availability of the extraction room and the metal containers where, in case they are available, beekepers will be able to extract their honey, and in case there is no container available on the day of their booking, each member must bring their own containers for the extraction.</p>
					<p>On the other hand, beekepers will have the option of reserving the room by choosing the day in a calendar.</p>
					<p>Finally, each beekeper will have the option to view and manage their reservations, being able to cancel them before the day arrives. 
						After each extraction, each beekeeper will have to fill out a form, saying how many kilos of honey he has extracted and if he has used any metal container, cause automatically those containers would not be available for a period of 14 days.</p>
						<p>In case that one beekeper did any extraction during the month, the accountant will charge in their account a fee of 0,25€/kilo extracted.</p>
					<!--We create a video and image carousel with local media-->
						<div class="row pt-4">
						<div id="gallery" class="carousel slide pb-4" data-ride="carousel" style="margin: auto;">
							<ul class="carousel-indicators">
								<li data-target="#gallery" data-slide-to="0" class="active"></li>
								<li data-target="#gallery" data-slide-to="1"></li>
								<li data-target="#gallery" data-slide-to="2"></li>
								<li data-target="#gallery" data-slide-to="3"></li>
								<li data-target="#gallery" data-slide-to="4"></li>
								<li data-target="#gallery" data-slide-to="5"></li>
							</ul>
							<div class="carousel-inner">
								<div class="carousel-item active">
									<iframe width="800" height="500" src="https://www.youtube.com/embed/9lqKwL2hKRM"></iframe>
								</div>
								
								<div class="carousel-item">
									 <img src="images/erlete1.jpg" alt="Solar Panels" width="800" height="500">
								</div>
								<div class="carousel-item">
									  <img src="images/erlea1.jpg" alt="Water Dam" width="800" height="500">
								</div>
								<div class="carousel-item">
									  <img src="images/eztia1.jpg" alt="Eolics" width="800" height="500">
								</div>						
							</div>
							<a class="carousel-control-prev" href="#gallery" data-slide="prev">
								<span class="carousel-control-prev-icon"></span>
							</a>
							<a class="carousel-control-next" href="#gallery" data-slide="next">
								<span class="carousel-control-next-icon"></span>
							</a>
						</div>
					</div>	
					<!--We create carousel with network media-->
					<div class="row pt-4">
						<iframe style="margin: auto;width:800px; height: 500px" src="https://cloud.tokimedia.eus/public/argazki-galeria/1275/embed"></iframe>
					</div>
				</div>	  	
			</div>
		</body>
	</html>