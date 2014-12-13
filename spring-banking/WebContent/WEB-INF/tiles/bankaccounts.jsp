<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="container">
	<h3>List of Bank accounts</h3>

	<table class="accounts">
		<thead>
			<tr>
				<th>IBAN</th>
				<th>Amount</th>
				<th>Currency</th>
			</tr>
		</thead>

		<c:forEach var="account" items="${accounts}">
			<tr>

				<td><c:out value="${account.iban}"></c:out></td>

				<td><c:out value="${account.amount}"></c:out></td>

				<td><c:out value="BGN"></c:out></td>

			</tr>
		</c:forEach>
	</table>
</div>