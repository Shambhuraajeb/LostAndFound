<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%!Connection con;%>
<%
Class.forName("com.mysql.cj.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/landf", "root", "");
%>
<!DOCTYPE html>
<html>
<head>



<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Recent Posts</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">

<script src="https://cdn.emailjs.com/dist/email.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">

<style type="text/css">
.user {
	color: white;
	font-family: 'Roboto', sans-serif;
	font-size: 13px;
	position: absolute;
	text-decoration: none;
	right: 9%;
	top: 30%;
}

.user:hover {
	border-bottom: 2px solid #fc0;
}
</style>
</head>


<body>
	<nav class="navbar" style="background-color: green; height: 50px">
		<a href="#" class="user">| USER LOGIN</a>
	</nav>
	<%
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery("select * from lost");
	%>
	<div>
		<div class="album">
			<div class="container">
				<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
					<%
					while (rs.next()) {
					%>

					<div class="row py-5">
						<div class="col-sm-6 mb-3 mb-sm-0">
							<div class="card">
								<div class="card-body">
									<h5 class="card-title"><%=rs.getString(2)%></h5>
									<p class="card-text"><%=rs.getString(9)%></p>
									<form action="http://localhost:8082/LostFound/Cont.jsp" method="post">
										<input type="hidden" id="email" name="email"
											value="<%=rs.getString(14)%>"> 
										<input type="hidden"
											id="id" name="id"
											value="<%=rs.getString(1)%>">
											<input type="hidden"
											id="id" name="item"
											value="<%=rs.getString(2)%>">
										<button type="submit" class="btn btn-primary">Contact</button>
									</form>
								</div>
							</div>
						</div>
					</div>


					<%
					}
					%>
				</div>
			</div>
		</div>
	</div>
	<script>
		emailjs.init("user_your_emailjs_user_id");

		function sendEmail() {
			var templateId = "template_your_email_template_id";

			// Get the email address from the input field
			var email = document.getElementById("email").value;

			// Check if the email address is provided
			if (!email) {
				alert("Please enter an email address.");
				return;
			}

			var params = {
				to_email : email,
				from_name : "Your Name",
				message : "Hello, this is the email message."
			};

			emailjs.send("your_emailjs_service_id", templateId, params).then(
					function(response) {
						console.log("Email sent successfully:", response);
					}, function(error) {
						console.log("Email failed to send:", error);
					});
		}
	</script>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>
