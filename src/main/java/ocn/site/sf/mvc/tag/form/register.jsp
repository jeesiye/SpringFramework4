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
<title>Insert title here</title>
</head>
<body>
	<!--
	注意，使用内置的form标签，首先要在模型中存储对应的key-value

	标签文件的本地位置？
	spring-webmvc-4.3.22.RELEASE.jar中的META-INF文件夹中

	出现Neither BindingResult nor plain target object for bean name 'command' available as request attribute异常时？
	表示指定的commandName属性或者是默认的属性值command，不存在模型数据中。注意，关联的是模型中的key。

	form标签中最重要的属性是commandName或者是modelAttribute，两个的效用一样，通常使用前者

	spring内置的form标签的优势，通常html中的表单只支持get和post请求，但是使用内置的form标签，可以支持其他请求方式，完美的实现RESTful设计
	其内有可提供修改的methodParam参数，一般不需要修改。若要修改，具体查看相关的doc文档。
	 -->
	<form:form commandName="user" action="register" method="post">
		id:<form:input path="id" />
		<br>
		name:<form:input path="name" />
		<br>
		<form:button>submit</form:button>
	</form:form>
</body>
</html>