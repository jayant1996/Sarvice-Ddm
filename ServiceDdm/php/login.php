<?php

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "storage";

$db = mysqli_connect($servername, $username, $password, $dbname);

if ($db) {
	echo "";
	# code...
}else{
	die("Connection failed because".mysqli_connect_error());
}


$u_username = filter_input(INPUT_POST,"username");
$p_password = filter_input(INPUT_POST,"password");


$result = mysqli_query($db, "SELECT * FROM `users` WHERE email='".$u_username."' AND u_password ='".$p_password."'");

if($data = mysqli_fetch_array($result)){
    echo '1';
}





?>

