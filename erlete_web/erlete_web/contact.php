<!DOCTYPE html>
<html>
    <head>
        <title>ERLETE EZTIOLA</title>

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
						    <a class="nav-link text-body text-center" href="index.php">HOME</a>						    
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
						   	<a class="nav-link text-body  active bg-warning Zentratu" href="contact.php">CONTACT</a>
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
			<!--Contact form to ask quesions-->
            <div style="width: 35%;" class="float_l mt-4">
                <h2>CONTACT FORM</h2>
                <h4>Send an email:</h4>
                <p>For any question you could send us a message.</p>
                <p>We will answer you as soon as possible.</p>
                <div id="contact_form">
                    <form method="post" name="contact" action="mailto:suinaga.jon@uni.eus">
                            
                            <label for="author">Your Name: </label> <input type="text" id="yourname" name="yourname"/>
                            
                            <label for="email">Email: </label> <input type="email" id="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" />
                            <label for="subject">Subject: </label> <input type="text" name="subject" id="subject" />
                            <label for="text">Message:</label> <textarea id="text" name="text" rows="0" cols="20"></textarea>
                            <input type="submit" value="Send" id="submit" name="submit" class="submit_btn float_l" onClick="balidatu()" />
                            <input type="reset" value="Clear" id="reset" name="reset" class="submit_btn float_r" />
                            
                    </form>
                </div>
            </div>
			<!--Address and google maps link-->
            <div style="padding-left: 5vw; width: 60%;" class="float_l mt-4">
                <h4>Our address </h4>
                <h6>Extraction local</h6>
                San Juan Plaza, 3 <br>
                 48291 Axpe, Bizkaia <br>                    
                <strong>Phone number: </strong>+34 946987654 <br>
                <strong>Email:</strong> <a href="mailto:erleteeztiola@erlete.eus">erleteeztiola@erlete.eus</a>  <br>            
                <iframe class="mt-4" style="width: 100%; margin: auto;" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d538.5038815512886!2d-2.598953620808243!3d43.11561624869649!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd4fd2f2a585c9bd%3A0xa8f87e963dad1656!2sSan%20Juan%20Plaza%2C%2048291%20Axpe%2C%20Bizkaia!5e1!3m2!1ses!2ses!4v1620632124575!5m2!1ses!2ses" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
            </div>
            
    
</body>
</html>