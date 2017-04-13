<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Cats Page</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
</head>
<body>
	<h1>Dodaj Kota</h1>
	<c:url var="addAction" value="/addCat/"></c:url>
	<form:form action="${addAction}" commandName="cat">
		<table>
			<tr>
				<td><form:label path="id">
						<spring:message text="ID" />
					</form:label></td>
				<td><form:input path="id" readonly="true" size="8"
						disabled="true" /> <form:hidden path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>

			<tr>
				<td><form:label path="ownerName">
						<spring:message text="Owner Name" />
					</form:label></td>
				<td><form:input path="ownerName" /></td>
			</tr>

			<tr>
				<td><form:label path="age">
						<spring:message text="Age" />
					</form:label></td>
				<td><form:input path="age" /></td>
			</tr>

			<tr>
				<td colspan="2"><c:if test="${!empty cat.name}">
						<input type="submit" value="<spring:message text="Edit Cat"/>" />
					</c:if> <c:if test="${empty cat.name}">
						<input type="submit" value="<spring:message text="Add Cat"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>


	<h3>Cats List</h3>
	<c:if test="${!empty listCats}">
		<table class="tg">

			<tr>
				<th width="80">Cat ID</th>
				<th width="120">Cat Name</th>
				<th width="120">Cat Owner Name</th>
				<th width="120">Cat Age</th>
				<th width="60">Delete</th>
				<th width="60">Edit</th>
			</tr>
			<c:forEach items="${listCats}" var="cat">
				<tr>
					<td>${cat.id}</td>
					<td>${cat.name}</td>
					<td>${cat.ownerName}</td>
					<td>${cat.age}</td>
					<td><a href="<c:url value='/deleteCat/${cat.id}' />">Delete</a></td>
					<td><a href="<c:url value='/editCat/${cat.id}' />">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>