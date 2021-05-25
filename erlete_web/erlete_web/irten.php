<?php
/*To close a session whe clicking in logout */
session_start();
unset($_SESSION['Erabiltzailea_aldagai_globala']);
session_write_close();
header("Location: index.php");
?>