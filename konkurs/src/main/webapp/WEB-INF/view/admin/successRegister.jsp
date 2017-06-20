<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<title>Konto Dodane</title>
</head>
<body>

	<h2>Dodano konto</h2>

	<a href="../start">Strona główna</a>
	<br>
	<a href="user">dodaj konto</a>

	<div id="userform">
		<h2>${message}</h2>
		<f:form action="user" modelAttribute="user" method="post">
			<f:label path="enabled">Czy ma być włączony?</f:label>
			<f:checkbox path="enabled" />
			<br>
			<f:label path="email">Email:</f:label>
			<f:input path="email" />
			<c:if test="${pageContext.request.method=='POST'}">
				<f:errors path="email" cssClass="error" />
			</c:if>
			<br>
			<f:label path="password">Hasło:</f:label>
			<f:password path="password" id="password" />
			<c:if test="${pageContext.request.method=='POST'}">
				<f:errors path="password" cssClass="error" />
			</c:if>
			<br>
			<f:label path="matchingPassword">Powtórz hasło:</f:label>
			<f:password path="matchingPassword" id="matchingPassword" />
			<c:if test="${pageContext.request.method=='POST'}">
				<f:errors path="*" cssClass="error" />
			</c:if>
			<br>
			<f:label path="role">Administrator systemu:</f:label>
			<f:checkbox path="role" />
			<br>
			<input type="submit" value="wyślij" />


		</f:form>
	</div>
</body>
</html>
</body>
</html>
