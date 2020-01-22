<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<script src="https://libs.cdnjs.net/jquery/3.4.1/jquery.min.js"></script>
<script src="https://libs.cdnjs.net/json2/20160511/json2.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form:form commandName="user" action="register" method="post">
		id:<form:input path="id" />
		<form:errors path="id"></form:errors>
		<br>
		name:<form:input path="name" />
		<form:errors path="name"></form:errors>
		<br>
		<form:button>submit</form:button>
	</form:form>
</body>
</html>