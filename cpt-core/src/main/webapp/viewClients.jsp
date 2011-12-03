<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./css/primary.css" />
<title>Cybion - visualizza clienti</title>
</head>
<body>
	<div id="header"><jsp:include page="header.jsp"></jsp:include></div>
<div id="title">
		<h3>Clienti attualmente serviti</h3>
	</div>
<div id="menudiv">
<table id="menu">
<tr >
	<td><a href="indexAdmin.jsp">Home</a></td><td> | </td>
	<td class="menuselected"><a href="viewClienti.do" class="generic">Clienti</a></td><td> | </td>
	<td><a href="viewFonti.do">Fonti</a></td><td> | </td>
	<td><a href="viewNavXML.do" >Monitor</a></td><td> | </td>
	<td>Newsletter</td><td> | </td>
	<td>About</td>
</tr>
</table>
</div>
<div id="body">
	<h4><a href="loadInteressi.do" class="generic">Inserisci un cliente</a></h4>

	<div id="listaClienti">
	<table border="1" id="fontiTable">
			<tr>
				<th scope="col">Nome</th>
				<th scope="col">Email</th>
				<th scope="col">Interessi</th>

			</tr>
		<c:forEach var="cliente" items="${listaClienti}">
			<tr>
			<th scope="row"><c:out value="${cliente.nome}"/></th>
			<td> <a class="extern" href="mailto:<c:out value="${cliente.email}"/>">invia una mail</a></td>
			<td>
				<c:forEach var="interesse" items="${cliente.setInteressi}">
					<c:out	value="${interesse.nome }"/>
				</c:forEach>
			</td>
			</tr>
		</c:forEach>
		</table>
	</div>
<h6><a class="generic" href="indexAdmin.jsp"> Torna alla home </a></h6>

</div>
<div id="footer"><h6>Cybion - monitoraggio dati</h6></div>
	

</body>
</html>