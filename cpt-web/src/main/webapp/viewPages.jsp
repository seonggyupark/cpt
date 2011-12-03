<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./css/default.css" />
<title>Cybion - visualizza le pagine scaricate</title>
</head>
<body>
<div id="header"><jsp:include page="header.jsp"></jsp:include></div>
<div id="title">
<h3>Lista pagine</h3>
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

<div id="listaPagine">
<div class="table">
<table id="pagesTable" border="1">
	<tr>
		<th scope="col">Preview</th>
		<th scope="col">Data Scaricamento</th>
		<th scope="col">URI</th>
	</tr>
<c:forEach var="page" items="${listaPagine }">
	<tr>
		<td><textarea rows="5" cols="50" readonly="readonly"><c:out value="${page.content }"/></textarea></td>
		<td><c:out value="${page.data}"/></td>
		<td><a target="_blank" class="extern" href="<c:out value="${page.uri}"/>"><c:out value="${page.uri}"/></a></td>
	</tr>
</c:forEach>
</table>
</div>
</div>
<h6><a class="generic" href="indexAdmin.jsp"> Torna alla home </a></h6>
<div id="footer"><h6>Cybion - monitoraggio dati</h6></div>
</body>
</html>