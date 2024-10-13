<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<%@ include file="/common/admin/header.jsp"%>
	</div>
	<div>
		<sitemesh:write property="body" />
	</div>
	<div>
		<%@ include file="/common/admin/footer.jsp"%>
	</div>
</body>
</html>