<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
	<h1>List of Bank accounts</h1>
	
	<table class="accounts">
	<tr>
		<td>IBAN</td>
		<td>Amount</td>
		<td>Currency</td>
	</tr>

	<c:forEach var="account" items="${accounts}">
		<tr>

			<td><c:out value="${account.iban}"></c:out></td>

			<td><c:out value="${account.amount}"></c:out></td>

			<td><c:out value="BGN"></c:out></td>

		</tr>
	</c:forEach>
</table>