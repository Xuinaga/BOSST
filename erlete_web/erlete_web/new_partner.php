
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
        $year=date("Y");
        $link = connectDataBase();
        /*Adding a new member to partner table in database*/
        $result = mysqli_query($link, "insert into partner values('$ida', '$izena', '$abizena', '$emaila', '$pasahitza', '$bankua', '$telefonoa', '$helbidea',1)");
       /*Adding first year charge to partnerhip_fee table in database*/
        $result2 = mysqli_query($link, "insert into partnership_fee values('$ida', '$year',1)");
        header("Location:register.php");
        ?>
   
