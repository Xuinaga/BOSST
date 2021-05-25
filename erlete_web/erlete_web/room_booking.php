<!DOCTYPE html>
	<html>
		<head>
			<title>ERLETE EZTIOLA</title>
			<!--We import the extensions that we are going o use for programming the web-->
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></link>

			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
			<link rel="stylesheet" href="CSS_SD.css"></link>
			<link rel="stylesheet" href="new.css"></link>
			<link rel="icon"  type="image/jpg" href="images/erleaLogo.jfif"></link>
		</head>
		<body> 
			<!--We create the cantainer that is going to have insade all the content-->
			<div class="container-fluid-lg" style="padding:1vw;margin:5vw 5vw 2vw 5vw">
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
						    <a class="nav-link dropdown-toggle active bg-warning text-body text-center" data-toggle="dropdown">BEEKEPERS AREA</a>
							<!--If an user is logged he wiil be allowed to see the different options in the beekepers area -->
							<?php
								include("test_connect_db.php");
								session_start();
								$link=connectDataBase();
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
				
            </div>	
			<div style="width:100%; margin:auto">
				<div style="margin-left:10%" class="pb-4 float_l">
				<!--Function to show the calendar-->
						<?php
							include 'Calendar.php';
							include 'Booking.php';
							include 'BookableCell.php';
							
							
							$booking = new Booking(
								'erlete_db',
								'localhost',
								'root',
								''
							);
							
							$bookableCell = new BookableCell($booking);
							
							$calendar = new Calendar();
							
							$calendar->attachObserver('showCell', $bookableCell);
							
							$bookableCell->routeActions();
							
							echo $calendar->show();
						?>
				</div>
				<div class="float_l" style="width: 20%; font-size:2vw; margin:auto; text-align:center; margin-left:2vw">
						<?php
							$book_day=mysqli_query($link,"select book_date from room_booking");
							
							$sql2 = "UPDATE can SET availability = '1', new_use = NULL WHERE new_use <= CURDATE() AND availability = '0'";
							if ($conn->query($sql2) === TRUE) {
								$emaitza1=mysqli_query($link,"select id_can, capacity from can where availability=1");
							}
							$emaitza1=mysqli_query($link,"select id_can, capacity from can where availability=1");
						?>
						<!--Table to see in every moment which cans are available-->
						<p><strong>Available Cans</strong></p>
						<table  style="font-size:2vw" class="table table-striped Zentratu">
							
							<Tr><Td>CAN_ID</Td><Td>VOLUME</Td></Tr>
							<?php
									while($erregistroa1 = mysqli_fetch_array($emaitza1)){
										printf("<tr><td>%d</td><td>%dL</td></tr>",$erregistroa1[0],$erregistroa1[1]);
									}
									mysqli_free_result($emaitza1);
									mysqli_close($link);
							?>
						</table>							
				</div>
			</div>
        </body>
    </html>