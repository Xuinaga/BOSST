<?php
	include 'test_connect_db.php';
	$id=$_POST['id'];
	
	$servername = "10.2.1.111:3306";
	$username = "bosst";
	$password = "bosst";
	$dbname = "erlete_db";


	$conn = new mysqli($servername, $username, $password, $dbname);
	
	
	$sql = "DELETE FROM room_booking WHERE id_booking=$id";
if ($conn->query($sql) === TRUE) {
  echo "Record deleted successfully";
} else {
  echo "Error deleting record: " . $conn->error;
}

$conn->close();
	
	mysqli_close($conn);
?>
