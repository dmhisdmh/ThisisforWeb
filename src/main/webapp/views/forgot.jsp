<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Forgot Password</h1>
		<p>Please enter your email to reset your password.</p>

		<!-- Display alert if there's any -->
		<c:if test="${not empty alert}">
			<div class="alert">${alert}</div>
		</c:if>

		<!-- Form for email submission -->
		<form action="/LTweb/forgot" method="post">
			<div class="input-group">
				<label for="email">Email:</label> <input type="email" id="email"
					name="email" placeholder="Enter your email" required>
			</div>
			<div class="input-group">
				<label for="password">New Password:</label> <input type="password"
					id="psw" name="psw" placeholder="Enter new password"
					required>
			</div>

			<div class="input-group">
				<label for="confirm-password">Confirm Password:</label> <input
					type="password" id="repsw" name="repsw"
					placeholder="Confirm new password" required>
			</div>
			<button type="submit" class="btn">Reset Password</button>
		</form>

		<p style="text-align: center; margin-top: 20px;">
			<a href="/LTweb/login">Back to Login</a>
		</p>
	</div>
</body>
</html>