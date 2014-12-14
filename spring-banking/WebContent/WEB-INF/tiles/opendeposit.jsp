<%@page import="com.banking.spring.web.utils.IbanGenerator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java"%>
<%@ page language="java"%>
<%
	String recipientIban = IbanGenerator.generateIban();
%>

<div class="container">
	<h3>Open new deposit</h3>

	<form method="post"
		action="${pageContext.request.contextPath}/opendeposit">
		<table>
			<tr>
				<td>Your IBAN</td>
				<td><select name="initiatorIban">
						<c:forEach var="account" items="${accounts}">
							<option value="${account.iban}">${account.iban}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Duration</td>
				<td><select name="duration">
							<option label="3 months, 4 % interest" value="3" selected></option>
							<option label="12 months, 6 % interest" value="12"></option>
				</select></td>
			</tr>
			<tr>
				<td>Amount</td>
				<td><input type="text" name="amount" /> <input type="hidden"
					name="recipientIban" value="<%=recipientIban%>" /> <input
					type="hidden" name="reason" value="Openning new deposit" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Open deposit"></td>
			</tr>
		</table>
	</form>
</div>