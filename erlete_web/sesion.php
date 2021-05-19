<div class="sesion">
<div class="user">
<?php
				session_start();
				if(isset($_SESSION['Erabiltzailea_aldagai_globala']))
				{
					
					$erabiltzaile= $_SESSION['Erabiltzailea_aldagai_globala'];
					echo "Welcome: <b> $erabiltzaile </b>"
					
					
					
					
				?>
</div>
<div class="exit_user">
				<form action="irten.php">
					
					<input class="close_sesion" type="submit" value="Sesioa itxi"/>
				</form>
				
				<?php
					
				} else {
				?>
				<form action="irten.php">
					
					<input class="close_sesion" type="submit" value="Sesioa itxi"/>
				</form>
				<?php 
				}
				
?>
</div>
</div>