<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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