<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<h2 align="center">Current Offers</h2>
	<table class="offerDisplayTable" align="center">
		<thead>
			<tr>
				<th class="offerDisplayTh">NAME</th>
				<th class="offerDisplayTh">EMAIL</th>
				<th class="offerDisplayTh">TEXT</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="offer" items="${ offers }">
				<tr>
					<td class="offerDisplayTd">${offer.name}</td>
					<td class="offerDisplayTd">${offer.email}</td>
					<td class="offerDisplayTd">${offer.text}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
