<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<form action="/LTweb/register" method="post">
		<div class="container">

			<!-- Hiển thị thông báo lỗi nếu có -->
			<c:if test="${alert != null}">
				<div class="alert">${alert}</div>
			</c:if>

			<h1>Register</h1>
			<p>Please fill in this form to create an account.</p>
			<hr>

			<label for="email"><b>Email</b></label> <input type="text"
				placeholder="Enter Email" name="email" id="email" required>

			<label for="username"><b>Username</b></label> <input type="text"
				placeholder="Username" name="uname" id="uname" required> <label
				for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="psw" id="psw" required> <label
				for="psw-repeat"><b>Repeat Password</b></label> <input
				type="password" placeholder="Repeat Password" name="psw-repeat"
				id="psw-repeat" required>

			<hr>

			<p>
				By creating an account you agree to our <a href="#">Terms &
					Privacy</a>.
			</p>
			<button type="submit" class="registerbtn">Register</button>
		</div>

		<div class="signin">
			Already have an account? <a href="/LTweb/login">Sign in</a>.
		</div>
	</form>
</body>
</body>
</html>