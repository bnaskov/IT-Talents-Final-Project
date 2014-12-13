<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(document).ready(function() {
		document.f.j_username.focus();
	});
</script>
<div class="container">
	<h3>Login with Username and Password</h3>

	<c:if test="${param.error != null}">

		<p class="error">Login failed. Check that your username and
			password are correct.</p>

	</c:if>


	<form name='f'
		action='${pageContext.request.contextPath}/j_spring_security_check'
		method='POST'>
		<table class="formtable">
			<tr>
				<td>User:</td>
				<td><input type='text' name='j_username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
			<tr>
				<td></td>
				<td><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
		</table>
	</form>

	<p>
		<a href="<c:url value="/newaccount"/>">Create new account</a>
	</p>
</div>


