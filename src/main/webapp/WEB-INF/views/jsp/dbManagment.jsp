<%@ include file="common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="content">

	Strona w trakcie budowy <br>

	<h3>Dodaj Kota</h3>
	<c:url var="addAction" value="/admin/dbManagment/addCat"></c:url>
	<form:form action="${addAction}" modelAttribute="cat" method="post">
		<table>
			<tr>
				<td><form:label path="id">
						<s:message text="ID" />
					</form:label></td>
				<td><form:input path="id" disabled="true" /> <form:hidden
						path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="name">
						<s:message text="Imię" />
					</form:label></td>
				<td><form:input path="name" type="text" maxlength="10" />
				<form:errors path="name" /></td>
			</tr>

			<tr>
				<td><form:label path="ownerName">
						<s:message text="Właściciel" />
					</form:label></td>
				<td><form:input path="ownerName" type="text" maxlength="10" />
				<form:errors path="ownerName" /> </td>
			</tr>

			<tr>
				<td><form:label path="age">
						<s:message text="Wiek" />
					</form:label></td>
				<td><form:input path="age" type="number" max="20"  /></td>
			</tr>


			<tr>
				<td colspan="2"><c:if test="${!empty cat.name}">
						<input type="submit" value="<s:message text="Edytuj"/>" />
					</c:if> <c:if test="${empty cat.name}">
						<input type="submit" value="<s:message text="Dodaj"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>

	<br>
	<h3>Baza Danych</h3>
	<br>

	<c:if test="${!empty listCats}">
		<table class="tableCats">

			<tr>
				<th class="tableCats">ID</th>
				<th class="tableCats">Imie</th>
				<th class="tableCats">Imie Właściciela</th>
				<th class="tableCats">Wiek</th>
				<th class="tableCats">Zdjęcia</th>
				<th class="tableCats">Edycja</th>
				<th class="tableCats">Usuwanie</th>

			</tr>
			<c:forEach items="${listCats}" var="cat">
				<tr>
					<td class="tableCats">${cat.id}</td>
					<td class="tableCats">${cat.name}</td>
					<td class="tableCats">${cat.ownerName}</td>
					<td class="tableCats">${cat.age}</td>
					<td class="tableCats"><a class="buttonEdit"
						href="<c:url value='/admin/dbManagment/addPhoto/${cat.id}' />">Lista</a></td>
					<td class="tableCats"><a class="buttonEdit"
						href="<c:url value='/admin/dbManagment/editCat/${cat.id}' />">Edytuj</a></td>
					<td class="tableCats"><a class="buttonDel"
						href="<c:url value='/admin/dbManagment/deleteCat/${cat.id}' />">Usuń</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</div>

<%@ include file="common/footer.jsp"%>
