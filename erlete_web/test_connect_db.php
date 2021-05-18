<?php

$servername = "10.2.1.111:3306";
$username = "bosst";
$password = "bosst";
$dbname = "erlete_db";


$conn = new mysqli($servername, $username, $password, $dbname);

function ConnectDataBase()
		{
			$servername = "10.2.1.111:3306";
			$username = "bosst";
			$password = "bosst";
			$dbname = "erlete_db";


		$conn = new mysqli($servername, $username, $password, $dbname);

		if ($conn->connect_error) {
			die("Connection failed: " . $conn->connect_error);
		}
			
			if (!($lotura=$conn))
			{
			echo "There is an error connecting the server.";
			exit();
			}
			if (!mysqli_select_db($lotura,$dbname))
			{
			echo "There is an error selecting the DB.";
			exit();
            }
            
	return $lotura;
}
?>