<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<script src="https://libs.cdnjs.net/jquery/3.4.1/jquery.min.js"></script>
<script src="https://libs.cdnjs.net/json2/20160511/json2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#json").click(function() {
			$.ajax({
				url : "${pageContext.request.contextPath}/test",
				type : "post",
				contentType : "application/json;charset=UTF-8",
				dataType : "json",
				data : JSON.stringify({
					id : 34,
					name : 'hack'
				}),
				success : function(data) {
					console.log(data);
				},
				error : function(data) {
					console.log(data);
				}
			});
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<a id="json">test</a>
</body>
</html>