
        <?php
        include("test_connect_db.php");
        $ida = $_POST["dni"]; 
        $izena = $_POST["name"];
        $abizena = $_POST["surname"];
        $emaila = $_POST["mail"];       
        $txekbox=(isset($_POST["beer_trashed"]))? 1 :0;        
        $pasahitza= $_POST["password"];        
        $bankua= $_POST["iban"];
        $telefonoa= $_POST["phone"];
        $helbidea= $_POST["address"];
        
        $link = connectDataBase();
        $result = mysqli_query($link, "insert into partner values('$ida', '$izena', '$abizena', '$emaila', '$pasahitza', '$bankua', '$telefonoa', '$helbidea')");
		header("Location:index.php");
        ?>
   
