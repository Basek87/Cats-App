<%@ include file="common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="content">

	<h3>Dodaj Zdjęcie</h3>

	<form:form modelAttribute="fileBucket" enctype="multipart/form-data"
		method="POST">
		<table>
			<tr>
				<td><form:label path="file">
						<s:message text="Zdjecie" />
					</form:label></td>
				<td><form:input type="file" id="file" path="file" /></td>
			</tr>

			<tr>
				<td><form:label path="description">
						<s:message text="Opis" />
					</form:label></td>
				<td><form:input type="text" id="description" path="description" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit"
					value="<s:message text="Dodaj Zdjęcie"/>" /></td>
			</tr>
		</table>
	</form:form>


	<br>
	<h3>Lista Zdjęć</h3>
	<br>

	<c:if test="${!empty catPhotos}">
		<table class="photo">

			<tr>
				<th class="tableCats">ID</th>
				<th class="tableCats">Nazwa Pliku</th>
				<th class="tableCats">Typ</th>
				<th class="tableCats">Opis</th>
				<th class="tableCats">Delete</th>
			</tr>
			<c:forEach items="${catPhotos}" var="catPhotos">
				<tr>
					<td class="tableCats">${catPhotos.id}</td>
					<td class="tableCats">${catPhotos.name}</td>
					<td class="tableCats">${catPhotos.type}</td>
					<td class="tableCats">${catPhotos.description}</td>
					<td class="tableCats"><a class="buttonDel"
						href="<c:url value='/admin/dbManagment/addPhoto/${cat.id}/delete/${catPhotos.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</div>
<%@ include file="common/footer.jsp"%>