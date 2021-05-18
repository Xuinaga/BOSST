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
		<body onload="ensenarDatos()"> 
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
						    <a class="nav-link dropdown-toggle active bg-warning text-body text-center" data-toggle="dropdown">BEEKEPERS AREA</a>
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
                <div id="datos" style="width: 95%; margin:auto; text-align:center">
				</div>
<script>


function ensenarDatos(){

	$.ajax({

		url: 'bookings_list.php',

		success:function(datos){

			$('#datos').fadeIn().html(datos);},

			error:function(){

				$('#datos').fadeIn().html('<p><strong>The server is not working</p>');

			}
	});
}


    // This functions starts when we press the button named 'delete'.
    $(document).on("click",".delete",function(){
        var el = this;

        // It takes the current id form the table and ask if we are sure of deleting the row.
        var id = $(this).data('id');
        var confirmalert = confirm("Are you sure that you want to cancel your booking?");
        if (confirmalert == true) {
            // AJAX Request to delete the row in the db.
            $.ajax({
                url: 'remove.php',
                type: 'post',
                data: { id:id },
                success: function(response){

                        // Remove row from HTML Table with an animation.
                        $(el).closest('tr').css('background','tomato');
                        $(el).closest('tr').fadeOut(800,function(){
                            $(this).remove();
                        });

                }
            });
        }
    });



//-------------FINALIZAR RESERVA---------

$(document).on("click","#finalizar",function(){

var id = $(this).data("idreserva");
var parametros = {"idreserva" : id,};

$.ajax({
		data:  parametros,
        url:   'extraction_form.php',
        type:  'post',


beforeSend:function(){

$('#datos').html('<div><img src="images/abeja.gif" width="400"/></div>')},


success:function(datos){


$('#datos').fadeIn().html(datos);},
error:function(){
$('#datos').fadeIn().html('<p><strong>The server is not working</p>');
}
});




});


//GENERAR DEUDA FORM

$(document).on("click","#terminar",function(){

	var kilos = $("#kilos").val();

	var reserva= $("#idreserva").data("id_book"); //obtener reserva

    	var parametros = {"kilos" : kilos,"idreserva" : reserva,};

$.ajax({
		data:  	parametros,
        url:   'extraction_form.php',
        type:  'post',

		beforeSend:function(){

		$('#datos').html('<div><img src="images/abeja.gif" width="400"/></div>')},

		success:function(datos){
			$('#datos').fadeIn().html(datos);
		},
		error:function(){
		$('#datos').fadeIn().html('<p><strong>The server is not working</p>');
		}
});

});

//SELECCIONAR CAN UTILIZADO
$(document).on("click","#cstate",function(){

var cid= $(this).data('can_id'); //obtener can

var reserva= $("#idreserva").data("id_book");

var parametros = {"cid" : cid, "idreserva" : reserva,};
var confirmalert = confirm("Are you sure that you have used this can?");
if (confirmalert == true) {
$.ajax({
		data:  	parametros,
		url:   'extraction_form.php',
		type:  'post',

		beforeSend:function(){

		$('#datos').html('<div><img src="images/abeja.gif" width="400"/></div>')},


	success:function(datos){
		$('#datos').fadeIn().html(datos);
	},
	error:function(){
	$('#datos').fadeIn().html('<p><strong>The server is not working</p>');
	}
});
}
});

//CANCELAR CAN SELECCIONADO
$(document).on("click","#cancel_can",function(){

var canid= $(this).data('cancel_id'); //obtener can

var reserva= $("#idreserva").data("id_book");

var parametros = {"#canid" : canid, "idreserva" : reserva,};
var confirmalert = confirm("Are you sure about you haven't used this can?");
if (confirmalert == true) {
$.ajax({
		data:  	parametros,
		url:   'extraction_form.php',
		type:  'post',

		beforeSend:function(){

		$('#datos').html('<div><img src="images/abeja.gif" width="400"/></div>')},

	success:function(datos){
		$('#datos').fadeIn().html(datos);
	},
	error:function(){
	$('#datos').fadeIn().html('<p><strong>The server is not working</p>');
	}
});
}
});
			
		</script>
        </body>
    </html>