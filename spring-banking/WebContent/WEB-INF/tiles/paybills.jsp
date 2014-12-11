<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<h1>Pay bills</h1>
<!-- 
<select>
	<c:forEach var="account" items="${accounts}">
		<option value="${account.iban}">${account.iban}</option>
	</c:forEach>
	</select>
 -->


<form method="post" action="${pageContext.request.contextPath}/paybills">
	<table>
		<tr>
			<td>Yout IBAN</td>
			<td><select name="initiatorIban">
					<c:forEach var="account" items="${accounts}">
						<option value="${account.iban}">${account.iban}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>Other's IBAN</td>
			<td><input type="text" name="recipientIban" /></td>
		</tr>
		<tr>
			<td>Amount</td>
			<td><input type="text" name="amount" /></td>
		</tr>
		<tr>
			<td>Reason for transfer</td>
			<td><textarea name="reason"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Transfer"></td>
		</tr>
	</table>
	


	<!--  <select name="initiatorIban">
		<c:forEach var="account" items="${accounts}">
			<option value="${account.iban}">${account.iban}</option>
		</c:forEach>
	</select> <input type="text" name="recipientIban" /> <input type="text"
		name="amount" /> <input type="text" name="reason" /> <input
		type="submit" value="Transfer">
		-->
</form>

<!--
<sf:form method="post"
	action="${pageContext.request.contextPath}/paybills"
	commandName="transaction">

	<table class="formtable">
		<tr>
			<td>Your accounts</td>
			<td>Recipient account</td>
			<td>Amount</td>
			<td>Reason</td>
		</tr>
		<tr>
			<td><sf:select path="initiatorIban">
					<c:forEach var="account" items="${accounts}">
						<option value="${account.iban}">${account.iban}</option>
					</c:forEach>
			</sf:select></td>
			<td><sf:text class="control" path="recipientIban" name="recipientIban"></sf:text></td>
			<td><sf:text class="control" path="amount" name="amount"></sf:text></td>
			<td><sf:text class="control" path="reason" name="reason"></sf:text></td>
			<td><input class="control" value="Send money" type="submit" /></td>
		</tr>
	</table>

</sf:form>
-->