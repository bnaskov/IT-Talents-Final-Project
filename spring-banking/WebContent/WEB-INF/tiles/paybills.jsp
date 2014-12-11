<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<h1>Pay bills</h1>

<select>
	<c:forEach var="account" items="${accounts}">
		<option value="${account.iban}">${account.iban}</option>
	</c:forEach>
</select>

<!---->
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
			<td><select>
					<c:forEach var="account" items="${accounts}">
						<option value="${account.iban}">${account.iban}</option>
					</c:forEach>
			</select></td>
			<td><sf:textarea class="control" path="recAcc" name="text"></sf:textarea></td>
			<td><sf:textarea class="control" path="amount" name="text"></sf:textarea></td>
			<td><sf:textarea class="control" path="reason" name="text"></sf:textarea></td>
			<td><input class="control" value="Send money" type="submit" /></td>
		</tr>
	</table>

</sf:form>