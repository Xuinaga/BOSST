<html>
<head>
        <title>ERLETE EZTIOLA</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></link>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <Link rel="stylesheet" href="CSS_SD.css"></Link>
		<!--<link rel="stylesheet" href="style.css">-->

        <link rel="icon"  type="image/jpg" href="images/erleaLogo.jfif"></link>
    </head>
	

    <body>
	<div class="container-fluid-lg" style="padding:1vw;margin:5vw">
            <div>
                <img src="images/goiburua1.jpg" style="width: 100%;height: 15vw; border-radius: 3vw;">
            </div>
            <nav class="navbar mt-4 navbar-expand-sm bg-white sticky-top" style="border: 0.3vw solid yellow; border-radius: 2vw;">
                <ul class="navbar-nav nav-pills flex-fill">
                    <li class="nav-item  flex-fill">
                        <a class="nav-link text-body text-center" href="index.php">HOME</a>						    
                    </li>
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
                           <a class="nav-link text-body Zentratu " href="contact.php">CONTACT</a>
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
							<a class="nav-link active bg-warning text-body Zentratu" href="login.php">LOGIN</a>
						<?php
							}
						?>	
						</li>
                </ul>
            </nav>
			<div class="pt-4 Zentratu" style="width: 30%; margin: auto">
				<h3 class="Zentratu">Your ERLETE account</h3>
				<form class="Zentratu" action="kontsultatu_erabiltzaileak.php" method="post" class="login-container">
					Email:<br>
					<input type="text" name="usuario" placeholder="Email" />
					<br>
					Password:<br>
					<input type="password" name="password" placeholder="Password" />
                    

                        <?php
                    
                            if(isset($_GET["incorrecto"]))
                            {
                                if($_GET["incorrecto"]=="Si")
                                {                         
                                                       
                        ?>
                        <div>
                        <p style="color:red"><strong>You have entered something wrong.</strong></p>
                        </div>
                        <?php                                    
                                }                                
                            }                            
                        ?>		
                
                         
					<input class="mt-4" type="submit" value="Sartu"/>
				</form>			
                <a style="text-align:center" href="register.php"><u>Become a member <strong>HERE</strong></u></a>
			</div>
		</div> 
    </body>
</html>
	
	