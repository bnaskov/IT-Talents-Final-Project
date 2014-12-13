<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="container">
	<h3>Transaction history</h3>

	
		<form method="post"
			action="${pageContext.request.contextPath}/transactions">
			<table>
				<tr>
					<td><select name="initiatorIban">
							<c:forEach var="account" items="${accounts}">
								<option value="${account.iban}">${account.iban}</option>
							</c:forEach>
					</select></td>
					<td><input type="submit" value="Get History"></td>
				</tr>
			</table>
		</form>
	

	<table class="transactions-table">
		<thead>
			<tr>
				<th>Date</th>
				<th>Time</th>
				<th>Initiator IBAN</th>
				<th>Recipient IBAN</th>
				<th>Amount</th>
				<th>Reason for transfer</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="transaction" items="${transactions}">
				<tr>
					<td>${transaction.date}</td>
					<td>${transaction.time}</td>
					<td>${transaction.initiatorIban}</td>
					<td>${transaction.recipientIban}</td>
					<td>${transaction.amount}</td>
					<td>${transaction.reason}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>