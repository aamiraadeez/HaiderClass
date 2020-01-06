<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	function myFunction() {
		debugger;

		var emailID = document.getElementById("email").value;
		var pass = document.getElementById("password").value;

		var url = "/agents/UserValidation";
		var user = {
			"email" : emailID,
			"password" : pass
		}
		$.ajax({
			type : 'POST',
			url : url,
			contentType : 'application/json',
			data : JSON.stringify(user),
			async : true,
			success : function(result, textStatus, xhr) {
				debugger;
				console.log("text: " + textStatus);
				console.log("response: " + xhr);
				window.location.replace("/agents/dashboard");
			},
			error : function(message, textStatus, errorThrown) {
				console.log(message.responseText);
				console.log(textStatus);
				console.log(errorThrown);
				$("#actionResponse").text(
						JSON.stringify(message.responseJSON, undefined, 2));
			}
		});
	}
</script>
</head>
<body>
	Email:
	<input type="text" id="email" name="email">
	<br> Password:
	<input type="text" id="password" name="password">
	<br>
	<button type="submit" onclick="myFunction()">Login</button>
<!-- 	<a href="signup.jsp">register</a> -->
	<a href="signup">Forget Password</a>
</body>
</html>