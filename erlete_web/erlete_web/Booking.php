<?php
 
class Booking
{
 
    private $dbh;
 
    private $bookingsTableName = 'room_booking';
 
    
	/*Constructor for doing a booking*/
    public function __construct($database, $host, $databaseUsername, $databaseUserPassword)
    {
        try {
 
            $this->dbh =
                new PDO(sprintf('mysql:host=%s;dbname=%s', $host, $database),
                    $databaseUsername,
                    $databaseUserPassword
                );
 
        } catch (PDOException $e) {
            die($e->getMessage());
        }
    }
 /*Compiles the information from database about bookings that are already done*/
	public function index()
	{
		$statement = $this->dbh->query('SELECT * FROM ' . $this->bookingsTableName);
		return $statement->fetchAll(PDO::FETCH_ASSOC);
	}
	/*Function to add a booking */
	public function add(DateTimeImmutable $bookingDate)
	{
		$nan=$_SESSION['nan'];

		$statement = $this->dbh->prepare(
			"INSERT INTO  room_booking  VALUES ('','$nan',:bookingDate,'',1)"
		);
		
	
		if (false === $statement) {
			throw new Exception('Invalid prepare statement');
		}
	
		if (false === $statement->execute([
				':bookingDate' => $bookingDate->format('Y-m-d'),
			])) {
			throw new Exception(implode(' ', $statement->errorInfo()));
		}
	}
	/*Function to delete a booking */
	public function delete($id)
	{
		$statement = $this->dbh->prepare(
			'DELETE from ' . $this->bookingsTableName . ' WHERE id = :id'
		);
		if (false === $statement) {
			throw new Exception('Invalid prepare statement');
		}
		if (false === $statement->execute([':id' => $id])) {
			throw new Exception(implode(' ', $statement->errorInfo()));
		}
	}
}