<!DOCTYPE html>
	<html>
<body>
    <div style="width: 75%; margin:auto; text-align:center">
				<!-- here we type the query in order to show the result in a table -->

                <?php
                    include("test_connect_db.php");
                    session_start();
                    $user=$_SESSION['Erabiltzailea_aldagai_globala'];
					$link=connectDataBase();               
                    $emaitza=mysqli_query($link,"select id_booking, book_date, extracted_quantity, state from room_booking INNER JOIN partner
                     ON room_booking.partner_DNI = partner.DNI where email='$user'") or die(mysqli_error($link));
                ?>


                <h3 class="display-3">Those are your bookings</h3>
                <table class="table table-striped mt-4" style="width: 65%; margin:auto">
                <!-- These are the titles of the table -->    
				<Tr><Td>YOUR BOOKS</Td><Td>BOOKING ID</Td><Td>BOOKING DATE</Td><Td>EXTRACTED QUANTITY</Td><Td>PRE-POST BOOKING</Td></Tr>	
				
                <?php
                        //Here we create a variable called 'aux' and we type a while, which will not finish until all the rows are shown.
                        $aux=1;
                        while($erregistroa = mysqli_fetch_array($emaitza))
                        {
							//We insert the results per each result into differet variables.
							$id = $erregistroa['id_booking'];
							$date = $erregistroa['book_date'];
							$extract = $erregistroa['extracted_quantity'];
							$state = $erregistroa['state'];
							
				?>

					<form  method='get'>
					
					<tr>
					<td><?php echo $aux; ?></td>
					<td><?php echo $id; ?><input type='hidden' name='id' id="idreserva" value='<?php echo $id; ?>' /></td>
					<td><?php echo $date; ?></td>
					<td><?php echo $extract; ?> KG</td>
					<!--Here we are comparing the dates, if is smaller than today, a button named 'delete' will apeared, however, if the day 
						equals or is bigger than today, a button named 'Form' will apeared. -->
					<?php if ($date < date("Y-m-d") && $state == 1) { ?>
					<td><input class='btn btn-danger' id="finalizar" type='submit' data-idreserva='<?= $id; ?>' value='Form'/></td>
					<?php } else if ($date > date("Y-m-d") && $state == 1){ ?>
					<!-- this is the button, which will call the function inside the tag <script> -->
					<td><span class='delete  btn btn-danger' type='submit' data-id='<?= $id; ?>'>Delete</span></td>
					<?php } else {?>
						<td><b>Completed</b></td>
					<?php
					}
					?>
					</tr>
                            
					
					</form>
					<?php
					$aux+=1;
                        }

                        mysqli_free_result($emaitza);
                        mysqli_close($link);
					?>
                </table>
                <br/>
                <a href="index.php">Back to menu</a>
    </div>
    </body>
    </html>