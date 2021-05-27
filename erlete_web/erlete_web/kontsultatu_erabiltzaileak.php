<?php
include("test_connect_db.php");
$usuario=$_POST["usuario"];
$password=$_POST["password"];


$link=ConnectDataBase();

$sql="SELECT dni, email, password FROM partner WHERE email = ?";
$stmt = $link->prepare($sql);
$stmt->bind_param('s',$usuario);
$stmt->execute();

$result =  $stmt->get_result(); //$conn->query($sql);
$data = $result->fetch_assoc();
if($data==''){
header("Location:login.php?incorrecto=Si");

}
while ($data) {
    if (($usuario == $data["email"]) && ($password == $data["password"])) {
    session_start();
    $_SESSION['nan'] = $data["dni"];
    $_SESSION['Erabiltzailea_aldagai_globala'] = $usuario;
    header("Location:index.php");
    } 

 
}


?>