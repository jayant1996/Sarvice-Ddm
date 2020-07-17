
<?php
define('HOST','localhost');
define('USER','id12324772_root');
define('PASS','Jayant206@std');
define('DB','id12324772_tambola');

 
$con = mysqli_connect(HOST,USER,PASS,DB);
$name = $_GET['name'];

$sql = "SELECT * FROM `users` WHERE u_username='$name'";

$res = mysqli_query($con,$sql);

while($raw=mysqli_fetch_array($res))
{
	 $data[]=$raw;
}
print(json_encode($data));

?>