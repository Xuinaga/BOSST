<?php

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "erlete_db";


$conn = new mysqli($servername, $username, $password, $dbname);

function ConnectDataBase()
		{
		$servername = "localhost";
		$username = "root";
		$password = "";
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