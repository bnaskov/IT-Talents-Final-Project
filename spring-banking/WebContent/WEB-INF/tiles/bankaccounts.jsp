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
	
	<h3>List of Deposits</h3>

	<table class="accounts">
		<thead>
			<tr>
				<th>Start Date</th>
				<th>End Date</th>
				<th>IBAN</th>
				<th>Interest</th>
				<th>Amount</th>
				<th>Currency</th>
			</tr>
		</thead>

		<c:forEach var="deposit" items="${deposits}">
			<tr>

				<td><c:out value="${deposit.startDate}"></c:out></td>

				<td><c:out value="${deposit.endDate}"></c:out></td>
				
				<td><c:out value="${deposit.iban}"></c:out></td>

				<td><c:out value="${deposit.interest}"></c:out></td>

				<td><c:out value="${deposit.amount}"></c:out></td>

				<td><c:out value="BGN"></c:out></td>

			</tr>
		</c:forEach>
	</table>
</div>