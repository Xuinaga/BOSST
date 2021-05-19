<?php
session_start();
unset($_SESSION['Erabiltzailea_aldagai_globala']);
session_write_close();
header("Location: index.php");
?>