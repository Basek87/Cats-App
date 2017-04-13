<%@ include file="common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="content">

	Ranking najlepszych zdjęć sortowanie wedgług oceny <br> <br>
	<br>

	<div class="square">
		<c:url var="addAction" value="/top10/update"></c:url>
		<c:forEach items="${catPhotos}" var="catPhoto">
			
			<form:form action="${addAction}" modelAttribute="catPhoto"
				enctype="multipart/form-data" method="POST">
				
				<div class="photoBlock">
					<img class="photo" src="loadImage/<c:out value="${catPhoto.id}"/>">
				</div>

				<div class="dataBlock">
					<form:label path="id">
						<s:message text="Id" />
					</form:label>
					<form:input path="id" style="color: black;"
						value="${catPhoto.id}" readonly="true" />

					<form:label path="averageRate">
						<s:message text="Średnia ocena" />
					</form:label>
					<form:input path="averageRate" readonly="true"
						style="color: black;" value="${catPhoto.averageRate}" />

					<form:label path="rate">
						<s:message text="ocena" />
					</form:label>
					<div>
						<form:input path="rate" type="number" min="1" max="5" />
					</div>
					<input type="submit" value="<s:message text="Edytuj"/>" />

				</div>
				<div style="clear: both;"></div>

			</form:form>
		</c:forEach>
	</div>
</div>

<%@ include file="common/footer.jsp"%>

