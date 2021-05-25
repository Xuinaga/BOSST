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
		<body onLoad="hasieratu()"> 
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
							<a class="nav-link text-body active bg-warning Zentratu" href="login.php">LOGIN</a>
						<?php
							}
						?>	
						</li>
					</ul>
				</nav>
                <div class="pt-4 Zentratu" style="width: 40%; margin: auto">
                <!--Form for people who wants to become partner -->
				<h3 class=" display-4 Zentratu">New member form</h3>
				<form name="formu" id="ok" class="Zentratu" action="new_partner.php" method="POST" class="login-container">
                    DNI:<br>
					<input type="text" id="dni" name="dni" placeholder="12345678A" pattern="[0-9]{8}[A-Z]{1}" required />
					<br>
                    Name:<br>
					<input type="text" id="name" name="name" placeholder="Your name" pattern="[A-Za-z]*" required/>
					<br>
                    Surname:<br>
					<input type="text" id="surname" name="surname" placeholder="Surname" pattern="[A-Za-z]*" required/>
					<br>
                    Email:<br>
					<input type="email" id="mail" name="mail" placeholder="smthng@smthng.dom" required/>
					<br>
					Password:<br>
					<input type="password" id="password" name="password" placeholder="Password" required/>
                    <br>
                    <input type="password" id="password2" name="password2" placeholder="Repeat password" required/>
                    <br>
                    IBAN:<br>
					<input type="text" size="30" id="iban" name="iban" placeholder="ESxx xxxx xxxx xxxx xxxx xxxx" pattern="[E]{1}[S]{1}[0-9]{2} [0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}">
					<br>
                    Phone:<br>
					<input type="text" name="phone" id="phone" placeholder="+XX xxx xxx xxx" pattern="[+]{1}[0-9]{2} [0-9]{3} [0-9]{3} [0-9]{3}"/>
					<br>
                    Address:<br>
					<textarea type="textarea" id="address" name="address" style="width:80%" placeholder="Street, Number, Floor Door, ZIP, City"required></textarea>
					<br>	
                    <label style="width: 80%"><input type="checkbox" name="kontatu[]" required/>I have read all the information before became a member</label>
					<br>     
                    <label style="width: 80%"><input type="checkbox" name="kontatu[]" required/>I agree to charge first year 30€ membership when submiting this form</label>
					<br>
                    <div style="">
                        <input type="submit" class="btn btn-success" name="bidali" value="Send">
                        <input  type="reset" class="btn btn-danger ml-2" name="ezabatu" value="Reset" onClick="ezabatu_formularioa()"><br>

                    </div>
                    
				</form>		
				<!--Link to login form-->	
                <a class="mt-4" style="text-align:center" href="login.php"><u>Login <strong>HERE</strong> if you are a partner.</u></a>
			</div>
            </div>
            <script>
              
                function hasieratu() {      
                    document.formu.dni.focus();           
                }
        		/*If a user wants to start the form from the beginning*/
                function ezabatu_formularioa(){
                    location.reload();
                }
				/*Checking if the password confirm is coorect in register form before submiting*/
				$("#ok").submit(function(){
					var password = $("#password").val();
					var password2 = $("#password2").val();
					if(password==password2){
						alert("Good register");
					}else{
						alert("Both `password are not the same")
						$("#password").focus();
						return false;
					}
					

				});
            </script>
        </body>
    </html>