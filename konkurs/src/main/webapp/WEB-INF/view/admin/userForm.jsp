<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.error {
	color: #ff0000;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="userform">
	<h2>${message}</h2>
		<f:form action="user" modelAttribute="user" method="post">
		
		<f:label path="enabled">Czy ma być włączony?</f:label>
		<f:checkbox path="enabled" />
			<br>
		<f:label path="email">Email:</f:label>
		<f:input path="email" />
			<c:if test="${pageContext.request.method=='POST'}">
				<f:errors path="email" cssClass="error"/>
			</c:if>
			<br>
		<f:label path="password">Hasło:</f:label>
		<f:password path="password" id="password" />
			<c:if test="${pageContext.request.method=='POST'}">
				<f:errors path="password" cssClass="error"/>
			</c:if>
			<br>
		<f:label path="matchingPassword">Powtórz hasło:</f:label>
		<f:password path="matchingPassword" id="matchingPassword" />
			<c:if test="${pageContext.request.method=='POST'}">
				<f:errors path="*" cssClass="error"/>
			</c:if>
			<br>
		<f:label path="admin">Administrator systemu:</f:label>
		<f:checkbox path="admin" />
			<br>
		<input type="submit" value="wyślij"/>


		</f:form>
	</div>
</body>
</html>