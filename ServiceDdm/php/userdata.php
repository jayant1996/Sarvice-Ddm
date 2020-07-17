<?php
error_reporting(0);
$db=mysqli_connect("localhost", "id12324772_root", "Jayant206@std", "id12324772_tambola");
if(isset($_POST['insert'])){
$target="images/".basename($_FILES['image']['name']);
$name=$_POST['full_name'];
$photo="https://ebookconar.000webhostapp.com/form/images/".$_FILES["image"]["name"];
$mobile_no=$_POST['mobile_no'];
$address=$_POST['address'];
$category=$_POST['category'];
$des=$_POST['description'];

$sql="INSERT INTO `user_service`(`full_name`, `images`, `mobile_no`, `address`, `category`, `des`) VALUES ('$name', '$photo', '$mobile_no', '$address', '$category', '$des')";
 mysqli_query($db, $sql);
move_uploaded_file($_FILES["image"]["tmp_name"],"images/".$_FILES["image"]["name"]);
}

?>
<!DOCTYPE html>
<html lang="en">
<head>
	<!-- Meta tags -->
	<title>Study Application Form a Simple Appointment form Responsive Widget :: w3layouts</title>
	<meta name="keywords" content="Study Application Form Responsive widget, Flat Web Templates, Android Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- stylesheets -->
	<link rel="stylesheet" href="css/style.css">
	<!-- google fonts  -->
	<link href="//fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Josefin+Sans:300,400,400i,700" rel="stylesheet">
</head>
<body>
	<div class="w3ls-banner">
	<div class="heading">
				<h1>Register Form</h1>
	</div>
		<div class="container">
			<div class="heading">
				<h2>Registration</h2>
				<p>Please fill out the registration form carefully</p>
			</div>
			<div class="agile-form">
				<form action="index.php" method="POST" enctype="multipart/form-data">
					<ul class="field-list">
						<li>
							<label class="form-label"> 
								Full Name 
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="full_name" placeholder="" required >
							</div>
						</li>
						<li>
							<label class="form-label"> 
								Photo
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="file" name="image" placeholder="" required >
							</div>
						</li>
						
						<li> 
							<label class="form-label">
							   Mobile Number
							   <span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="mobile_no" placeholder="" required >
							</div>
						</li>
						
						<li> 
							<label class="form-label">
							  Address
							   <span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="address" placeholder="" required >
							</div>
						</li>
						<li> 
							<label class="form-label">
							  Category
							   <span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<select class="form-dropdown" name="category" required>
									<option value="">&nbsp;</option>
									<option value="Electricians"> Electricians </option>
									<option value="Plumbers">Plumbers</option>
										<option value="Carpenters"> Carpenters </option>
									<option value="Appliance Repair">Appliance Repair</option>
										<option value="Cooking Appliance"> Cooking Appliance</option>
									<option value="Cake Maker">Cake Maker </option>
										<option value="Tution"> Tution </option>
									<option value="Medical">Madical </option>
									
								</select>
							</div>
						</li>
						<li> 
							<label class="form-label1">
								Service description.
							</label>
							<div class="form-input2">
								<textarea rows="5" cols="20" name="description"></textarea>
							
							</div>
						</li>
					</ul>
					<input type="submit" name="insert" value="Apply Now">
				</form>	
			</div>
		</div>
		<div class="copyright">
		<p>© 2018 Study Application Form. All rights reserved | Design by <a href="www.w3layouts.com">W3layouts</a></p> 
	</div>
	</div>
</body>
</html>