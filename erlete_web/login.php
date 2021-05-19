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
                        <div class="dropdown-menu dropdown-menu-right">
                            <a class="dropdown-item" href="#">Room booking</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Your bookings</a>
                        </div>
                    </li>
                    <li class="nav-item flex-fill">
                           <a class="nav-link text-body Zentratu " href="contact.php">CONTACT</a>
                    </li>
                    <li class="nav-item flex-fill">
                        <a class="nav-link text-body Zentratu active bg-warning" href="login.php">LOGIN</a>
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
	
	