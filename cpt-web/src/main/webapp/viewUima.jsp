<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./css/default.css" />
<title>Cybion - visualizza le Annotation individuate</title>
</head>
<body>
<div id="header"><jsp:include page="header.jsp"></jsp:include></div>
<div id="title">
<h3>Elenco Annotation</h3>
</div>

<div id="menudiv">
<table id="menu">
<tr>
	<td class="menuselected">Home</td><td> | </td>
	<td><a href="viewClienti.do" class="generic">Clienti</a></td><td> | </td>
	<td><a href="viewFonti.do" class="generic">Fonti</a></td><td> | </td>
	<td>Monitor</td><td> | </td>
	<td>Newsletter</td><td> | </td>
	<td>About</td>
</tr>
</table>
</div>

<div id="listaAnnotation">
<table id="annotationsTable" border="1">
	<tr>
		<th scope="col">Tipo</th>
		<th scope="col">Testo</th>
	</tr>
<c:forEach var="annotation" items="${listaAnnotation}">
	<tr>
		<td><c:out value="${annotation.type}"/></td>
		<td><c:out value="${annotation.text}"/></td>
	</tr>
</c:forEach>
</table>

</div>
<h6><a class="generic" href="indexAdmin.jsp"> Torna alla home </a></h6>
<div id="footer"><h6>Cybion - monitoraggio dati</h6></div>
</body>


</html>