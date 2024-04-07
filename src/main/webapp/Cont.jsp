<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Contact Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<style>
.form1 {
	background-color: rgba(0, 0, 0, 0.4);
	position: absolute;
	width: 80%;
	height: 72%;
	left: 10%;
	top: 22%;
	border-radius: 20px;
}

.form1:hover {
	border: 1px solid rgb(255, 255, 255);
}

.contennt {
	padding-top: 5%;
	padding-left: 5%;
	padding-right: 5%;
	padding-bottom: 5%;
}

input[type="submit"] {
	position: absolute;
	left: 43%;
	top: 85%;
	height: 40px;
	width: 200px;
	border: 1px solid rgb(242, 241, 241);
	background-color: rgb(52, 35, 35);
	color: aliceblue;
	font-weight: bold;
	letter-spacing: 1px;
}

h3 {
	font-weight: bold;
	color: rgb(28, 46, 111);
	letter-spacing: 1px;
	text-shadow: 2px 2px 2px rgb(255, 255, 255);
}

body {
	background-color: rgb(132, 201, 201);
	background-image: url(img/feed_bg.jpg);
}

input[type="text"], input[type="password"] {
	border: 1px solid black;
}

img {
	width: 80px;
	position: absolute;
	left: 46%;
	bottom: 92%;
}

input[type="text"] {
	font-weight: 600;
}
</style>
</head>

<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>


	<br>
	<center>
		<h3>Contact</h3>
	</center>
	<form action="http://localhost:8082/LostFound/Claim" method="post">
		<%
		String email = request.getParameter("email");
		String item = request.getParameter("item");
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		%>
		<div class="form1">
			<div class="contennt">
				<img src="img/logo.png">
				<div class="input-group">
					<span class="input-group-text"><b>First and last name</b></span> <input
						type="text" aria-label="First name" class="form-control"
						placeholder="e.g-raj" name="fname"> <input type="text"
						aria-label="Last name" class="form-control"
						placeholder="e.g-sharma" name="lname">
				</div>
				<br>
				<div class="input-group flex-nowrap">
					<span class="input-group-text" id="addon-wrapping"><b>Email</b></span>
					<input type="text" name="email" value="<%=email%>" class="form-control"
						placeholder="e.g-abc@gmail.com" aria-label="Username"
						aria-describedby="addon-wrapping"> 
						
						<span class="input-group-text" id="addon-wrapping"><b>Item</b></span>
						<input type="text" name="item" value="<%=item%>" class="form-control"
						aria-describedby="addon-wrapping">
						
						<input type="hidden" name="id"
						value="<%=id%>" class="form-control"
						placeholder="e.g-abc@gmail.com" aria-label="Username"
						aria-describedby="addon-wrapping">
				</div>
				<br>
				<div class="mb-3">
					 <span
						class="input-group-text" id="addon-wrapping"><b>Tell
							unique thing about items</b></span> <br>
					<textarea name="dec" class="form-control" id="exampleFormControlTextarea1"
						rows="3"></textarea>
				</div>
				<br> <input type="submit" class="btn btn-outline-primary">

			</div>
		</div>
	</form>
</body>

</html>