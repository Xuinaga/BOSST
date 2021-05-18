
<!DOCTYPE html>
	<html>
		
<body>
<div style="width:60%; margin:auto">
				<?php        
					include("test_connect_db.php");
					$link=connectDataBase();
					session_start();
                    $user=$_SESSION['Erabiltzailea_aldagai_globala'];

					$extract_id=$_POST["idreserva"];

                    $emaitza=mysqli_query($link,"SELECT can.id_can, can.capacity, can.availability, booking_can.id_booking FROM can LEFT JOIN booking_can ON can.id_can = booking_can.id_can WHERE can.availability = 1 OR booking_can.id_booking = $extract_id")or die(mysqli_error($link));
					
					
					if(isset($_POST["cid"])) {
						$cid = $_POST["cid"];

						$sql2 = "UPDATE can SET availability = '0', last_use = CURDATE() WHERE id_can = $cid";
						$insert = mysqli_query($link,"INSERT INTO booking_can VALUES ($extract_id, $cid)");
						if ($conn->query($sql2) === TRUE) {
							$emaitza=mysqli_query($link,"SELECT can.id_can, can.capacity, can.availability, booking_can.id_booking FROM can LEFT JOIN booking_can ON can.id_can = booking_can.id_can WHERE can.availability = 1 OR booking_can.id_booking = $extract_id")or die(mysqli_error($link));
						}
						
						$conn->close();

					}
					if(isset($_POST['#canid'])) {
						$canid = $_POST['#canid'];
						
						$sql2 = "UPDATE can SET availability = '1', last_use = NULL WHERE id_can = $canid";
						$delete = mysqli_query($link,"DELETE FROM booking_can WHERE id_can = $canid");
						if ($conn->query($sql2) === TRUE) {
							$emaitza=mysqli_query($link,"SELECT can.id_can, can.capacity, can.availability, booking_can.id_booking FROM can LEFT JOIN booking_can ON can.id_can = booking_can.id_can WHERE can.availability = 1 OR booking_can.id_booking = $extract_id")or die(mysqli_error($link));
						}
						$conn->close();
					}

					if(isset($_POST["kilos"])) {

					 	$cant = $_POST["kilos"];
						$sql = "UPDATE room_booking SET extracted_quantity = $cant, state = 0 WHERE id_booking = $extract_id";
						$finalC= mysqli_query($link, "SELECT can.id_can, can.capacity FROM can LEFT JOIN booking_can ON can.id_can = booking_can.id_can WHERE can.availability = 0 AND booking_can.id_booking = $extract_id")or die(mysqli_error($link));
						//$result = mysql_query($link, $sql)or die(mysqli_error($link));
						if ($conn->query($sql) === TRUE) {}
						$conn->close();
					}


                ?>
                    <h6 style="text-align:center" class="display-4 mt-4">POST EXTRACTION FORM</h6>
					
                    <form method="post">
					
                    <h5 style="text-align:center; margin-top:4px; margin-bottom:4px">Booking ID: <?php echo ($extract_id); ?><input type="hidden" data-id_book='<?= $extract_id; ?>' id="idreserva" name="idreserva" value= "<?php echo ($extract_id); ?>"/></h5><br>

					<?php
						if(isset($_POST["kilos"])) {
					?>

					<p style="text-align:center">Extracted Honey quantity: <?php echo $cant; ?> KG</p><br>
					<p style="text-align:center">Can used: <br>
					<table class="table table-striped mt-4" style="width: 60%; margin:auto">
					<tr>
					<Td style='text-align:center'>CAN ID</Td><Td style='text-align:center'>CAPACITY</Td></tr>
					<?php
					
						while($final = mysqli_fetch_array($finalC))
						{
						?>
						<tr>
						<td><?php echo $final['id_can']; ?></td>
						<td><?php echo $final['capacity']; ?></td>
						</tr>
						
						<?php
						}
						?>
					</table>
					</p>
					<?php
						} else {
					?>

					<p style="text-align:center">Extracted Honey quantity: <input type="number" id="kilos" style="width:10vw" id="kilos" max="999" name="kilos"/> KG</p>

					

                    <p style="text-align:center"><strong>Have you used any metal can?</strong></p>
					<table class="table table-striped mt-4" style="width: 60%; margin:auto">
                    
						<Tr><Td style='text-align:center'>CAN ID</Td><Td style='text-align:center'>CAPACITY</Td><Td style='text-align:center'>HAVE YOU USE IT?</Td></Tr>
						<?php
							
							
							while($erregistroa = mysqli_fetch_array($emaitza))
							{
								$cid = $erregistroa['id_can'];
								$cap = $erregistroa['capacity'];
								$available = $erregistroa['availability'];
								$booking = $erregistroa['id_booking'];
							?>
								<tr>
								<td style='text-align:center'><?php echo $cid; ?><input type="hidden" id="canid" name="cid" value="<?php echo $cid; ?>" /></td>
								<td style='text-align:center'><?php echo $cap; ?></td>

								<?php
									if($available == 0 and $extract_id == $booking) {
								?>
								<td style='text-align:center'><span type='submit' data-cancel_id='<?= $cid; ?>' id="cancel_can" class="sub btn btn-danger">Cancel</span></td>
								<?php
									} else {
								?>
								<td style='text-align:center'><span type='submit' data-can_id='<?= $cid; ?>' id="cstate" class="cstate btn btn-success">Used</span></td>
								<?php
									}
								?>
								</tr>
							<?php
							}

							mysqli_free_result($emaitza);
							mysqli_close($link);
						?>
					</table>
					<?php
						}
					?>
					<div class="mt-4" style="text-align:center">
					<?php 
					if(isset($_POST["kilos"])) {
					?>

						<td style='text-align:center'><input type='hidden' name='cant' value='<?php echo $cant; ?>'/></td>
						<a href="bookings.php">Back to menu</a>

					<?php
					} else {	
					?>
						<span type='submit' id="terminar" class="sub btn btn-success">submit</span>
					<?php
					}	
					?>
					</div>
					
				</form>
                
            </div>
	
        </body>
    </html>