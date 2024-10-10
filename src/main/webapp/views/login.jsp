<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<div class="container">
		<form action="/LTweb/login" method="post">

			<!-- Hiển thị thông báo lỗi nếu có -->
			<c:if test="${alert != null}">
				<div class="alert">${alert}</div>
			</c:if>

			<label for="uname">Username</label> <input type="text" id="uname"
				name="uname" placeholder="Username" required> <label
				for="psw">Password</label> <input type="password" id="psw"
				name="psw" placeholder="Password" required> <label>
				<input type="checkbox" checked="checked" name="remember">
				Remember me
			</label>

			<button type="submit">Login</button>

			<span class="psw"> <a href="/LTweb/forgot"> Forgot password?</a></span>
			
			<div class="register">
                Don't have an account? <a href="/LTweb/register">Register here</a>
            </div>
		</form>
	</div>
</body>
</html>
