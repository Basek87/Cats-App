<%@ include file="common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="content">
	<strong>Application has encountered an error. Please contact support on ...</strong>
	<br>
	<br>
	Error details: ${errorMsg.message}
</div>

<%@ include file="common/footer.jsp"%>
