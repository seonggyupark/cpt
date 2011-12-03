<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./css/default.css" />
<title>Cybion - dettagli bandi per Fonte</title>
</head>
<body>
<div id="wrapper">
<div id="header">
<div id="logo"><jsp:include page="header.jsp"></jsp:include></div>
<br />
<hr />
<em>Descrittori XML attualmente memorizzati</em>
<hr />
</div>
<div id="menu">
<table id="menutab">
	<tr>
		<td><a href="indexAdmin.jsp">Home</a></td>
		<td>|</td>
		<td><a href="viewClienti.do">Clienti</a></td>
		<td>|</td>
		<td><a href="viewFonti.do">Fonti</a></td>
		<td>|</td>
		<td><a href="viewNavXML.do">Monitor</a></td>
		<td>|</td>
		<td><a href="#">Newsletter</a></td>
		<td>|</td>
		<td><a href="#">About</a></td>
	</tr>
</table>
</div>
<div id="page">
<div id="page-bgbtm">
<div class="post">
<h2 class="title"><a href="#">Bandi trovati : </a></h2>

<div class="entry">
<ol>
	<c:forEach items="${results}" var="result">
		<li>
		<h4><a href="showBando.do"><c:out
			value="${result.bando.titolo}"></c:out> - <c:out
			value="${result.bando.lingua}"></c:out></a> - abstract: <c:out
			value="${result.bando.sunto}"></c:out><br />
		<c:out value="${result.bando.categoria}"></c:out></h4>
		oggetto: <c:out value="${result.bando.oggetto}"></c:out><br />
		budget: <c:out value="${result.bando.budget}"></c:out><br />
		ente: <c:out value="${result.bando.ente}"></c:out><br />
		beneficiario: <c:out value="${result.bando.beneficiario}"></c:out><br />
		data di scadenza: <c:out value="${result.bando.dataScadenza}"></c:out><br />
		link: <c:out value="${result.bando.linkAllaFonte}"></c:out><br />
		attivita: <c:out value="${result.bando.attivita}"></c:out><br />
		regione geografica: <c:out value="${result.bando.regGeografica}"></c:out><br />
		tags: <c:out value="${result.bando.tagList}"></c:out><br />
		</li>
	</c:forEach>
</ol>
</div>
</div>
</div>
</div>

<div id="footer">
<p>Cybion - monitoraggio dati</p>
</div>

</div>

</body>
</html>