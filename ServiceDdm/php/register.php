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


$ui_username = filter_input(INPUT_POST,"u_username");
$pi_password = filter_input(INPUT_POST,"p_password");
$email = filter_input(INPUT_POST,"email");
$phone = filter_input(INPUT_POST,"phone");

$sqli = "INSERT INTO `users`(`u_username`, `u_password`,`email`, `phone`) VALUES ('".$ui_username."', '".$pi_password."', '".$email."', '".$phone."')";

$result1 = mysqli_query($db, $sqli);

if($data = mysqli_fetch_array($result1)){
    echo '1';
}else{
    echo '0';
}



?>
 