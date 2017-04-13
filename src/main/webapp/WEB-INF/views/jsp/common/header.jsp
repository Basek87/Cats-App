
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html lang="pl">

<head>
<meta name="description" content="Informacje o kotach" />
<meta name="keywords" content="kot, koty, zwierzęta" />
<title>Moja Strona</title>

<s:url value="/resources/themes/style.css" var="themeCSS" />
<link href="${themeCSS}" rel="stylesheet" />

<link
	href='http://fonts.googleapis.com/css?family=Lato:400,900&subset=latin,latin-ext'
	rel='stylesheet' type='text/css'>
</head>

<body>
	<div id="container">

		<div id="logo"></div>

		<div id="menu">
			
			<div class="option"><a class="linkTop" href="<c:url value="/index"/>">Home</a></div>
			<div class="option"><a class="linkTop" href="<c:url value="/top10"/>">Top 10</a></div>
			<div class="option"><a class="linkTop" href="<c:url value="/aboutCats"/>">O kotach</a></div>
			<div class="option"><a class="linkTop" href="<c:url value="/aboutProject"/>">O projekcie</a></div>
			<div class="option"><a class="linkTop" href="<c:url value="/admin"/>"><span
					title="Po dodaniu serwisu logowania opcja dostępna po zalogowaniu">Admin</span></a>
				
			</div>
			<div style="clear: both;"></div>
		</div>

		<div id="topbar">

			<div id="topbarL">
				<div>
					<img class="img" src="<s:url value="/resources" />/img/logo.png" />
				</div>
			</div>

			<div id="topbarR">
				<span class="bigtitle">O kotach słów kilka</span>
				<div style="height: 15px;"></div>
				Naprawdę intymnych i intensywnych przeżyć dostarczy dopiero żywy kot
				albo kufel piwa prosto z beczki; ponadto tak jeden, jak i drugi na
				żywo jest milszy i bardziej godzien ciepłych uczuć niż nawet
				najpiękniejsze ich obrazy. Eugen Skasa – Weiss
			</div>
			<div style="clear: both;"></div>
		</div>
		<div id="sidebar">
			<div class="optionL"><a class="linkLeft" href="<c:url value="/index"/>">Home</a></div>
			<div class="optionL"><a class="linkLeft" href="<c:url value="/top10"/>">Top 10</a> </div>
			<div class="optionL"><a class="linkLeft" href="<c:url value="/aboutCats"/>">O kotach</a></div>
			<div class="optionL"><a class="linkLeft" href="<c:url value="/aboutProject"/>">O projekcie</a></div>
		</div>