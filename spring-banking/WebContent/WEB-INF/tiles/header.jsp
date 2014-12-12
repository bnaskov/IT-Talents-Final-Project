<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="image">
	<img
		src="${pageContext.request.contextPath}/static/images/banking-header.jpg"
		alt="Online Banking">
</div>

<a class="title" href="<c:url value='/'/>">Offerzz</a>

<sec:authorize access="!isAuthenticated()">
	<a class="login" href="<c:url value='/login'/>">Log in</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<a class="login" href="<c:url value='/j_spring_security_logout'/>">Log
		out</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<nav>
		<ul>
			<li><a class="accounts" href="<c:url value='/bankaccounts'/>">Bank
					accounts</a></li>
			<li><a class="openaccount"
				href="<c:url value='/openbankaccount'/>">Open account</a></li>
			<li><a class="pay_bills" href="<c:url value='/paybills'/>">Pay
					bills</a></li>
			<li><a class="transfer_money_to_user"
				href="<c:url value='/transfermoneytouser'/>">Transfer money</a></li>
			<li><a class="transactions"
				href="<c:url value='/transactions'/>">Transactions</a></li>
		</ul>
	</nav>
</sec:authorize>