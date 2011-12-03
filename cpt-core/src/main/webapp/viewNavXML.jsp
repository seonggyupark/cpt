<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./css/primary.css" />
<title>Cybion - visualizza fonti</title>
</head>
<body>
<div id="header"><jsp:include page="header.jsp"></jsp:include></div>
<div id="title">
<h3>Descrittori XML attualmente memorizzati</h3>
</div>
<div id="menudiv">
<table id="menu">
	<tr>
		<td><a href="indexAdmin.jsp">Home</a></td>
		<td>|</td>
		<td><a href="viewClienti.do">Clienti</a></td>
		<td>|</td>
		<td><a href="viewFonti.do">Fonti</a></td>
		<td>|</td>
		<td class="menuselected"><a href="viewNavXML.do">Monitor</a></td>
		<td>|</td>
		<td>Newsletter</td>
		<td>|</td>
		<td>About</td>
	</tr>
</table>
</div>

<div id="body">
<form method="post" action="checkFonte.do">
<div class="form">

<h3>Controlla la fonte:</h3>

<select name="idFonte">
	<c:forEach var="xml" items="${listaXML}">
		<option value="<c:out value="${xml.idNavXML}"/>"><c:out
			value="${xml.description}" /></option>
	</c:forEach>
</select></div>
<label /><input class="button" type="submit" value="ok" /></form>
</div>


<h6><a class="generic" href="indexAdmin.jsp"> Torna alla home </a></h6>

<div id="footer">
<h6>Cybion - monitoraggio dati</h6>
</div>
</body>
</html>