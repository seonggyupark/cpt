<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./css/default.css" />
<title>Cybion - visualizza fonti</title>
</head>
<body>
<div id="wrapper">
<div id="header">
<div id="logo"><jsp:include page="header.jsp"></jsp:include></div>
<br />
<hr />
<em>Fonti attualmente memorizzate.</em>
<hr />
</div>
<div id="menu">
<table id="menutab">
	<tr>
		<td><a href="indexAdmin.jsp">Home</a></td>
		<td>|</td>
		<td><a href="viewClienti.do" class="generic">Clienti</a></td>
		<td>|</td>
		<td><a href="viewFonti.do" class="generic">Fonti</a></td>
		<td>|</td>
		<td><a href="viewNavXML.do" class="generic">Monitor</a></td>
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

<h3><a href="loadInteressiPerFonte.do" class="title">Inserisci
una fonte</a></h3>
<div class="entry">
<table border="1" id="fontiTable">
	<tr>
		<th scope="col">Nome</th>
		<th scope="col">Link</th>
		<th scope="col">Media pagine scaricate</th>
		<th scope="col">Pagine scaricate</th>
		<th scope="col">Scheduling(d,l,m,m,g,v,s)</th>
		<th scope="col">Util</th>
	</tr>
	<c:forEach var="fonte" items="${listaFonti}">
		<tr>
			<th scope="row"><c:out value="${fonte.nome}" /></th>
			<td><a class="generic" href=" <c:out value="${fonte.link}"/>">link</a></td>
			<td><c:forEach var="stat" items="${listaStatistiche}">
				<c:if test="${stat.idFonte == fonte.xmlDescriber.idNavXML}">
					<c:out value="${stat.media }" />
				</c:if>
			</c:forEach></td>
			<td><a class="generic"
				href="viewPages.do?idFonte=<c:out value="${fonte.xmlDescriber.idNavXML}"/>">Vai
			alle pagine scaricate</a></td>
			<td><c:out value="${fonte.scheduling}" /></td>
			<td><a class="generic"
				href="editFonte.do?idFonte=<c:out value="${fonte.idFonte}"/>">edit</a>
			</td>
		</tr>
	</c:forEach>
</table>
</div>
<h6><a class="generic" href="indexAdmin.jsp"> Torna alla home </a></h6>
</div>
</div>
</div>
</div>
<div id="footer">
<p>Cybion - monitoraggio dati</p>
</div>
</body>
</html>