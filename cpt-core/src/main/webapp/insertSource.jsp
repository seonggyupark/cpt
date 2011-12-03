<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./css/primary.css" />
<title>Cybion - Inserimento una nuova fonte</title>
</head>
<body>
	<div id="header"><jsp:include page="header.jsp"></jsp:include></div>
	<div id="title">
		<h3>Inserisci una fonte</h3>
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

<div id="body">
<div class="form">
	<form name="insertFonteForm" method="post" action="insertFonte.do" enctype="multipart/form-data">
	<div class="row"><label for="fonteDescription">Descrizione Fonte:</label><input type="text" name="fonteDescription" value="Descrizione (es:TED)" onfocus="this.value='';"/> </div>
	<div class="row"><label for="scheduling">Scheduling:</label><select MULTIPLE="multiple" name="scheduling" size="7">
		<option value="1">Domenica</option>
		<option value="2">Lunedì</option>
		<option value="3">Martedì</option>
		<option value="4">Mercoledì</option>
		<option value="5">Giovedì</option>
		<option value="6">Venerdì</option>
		<option value="7">Sabato</option>
</select></div>
<div class="row"><label for="interesse">Interessi:</label><select MULTIPLE="multiple" name="interessi" size="5">
<c:forEach var="interesse" items="${listaInteressi}">
	<option value="<c:out value="${interesse.idInteresse}"/>"><c:out value="${interesse.nome}"/></option>
</c:forEach>
</select></div>
	<div class="row"><label for="xmlFile">Seleziona il file di navigazione:</label><input type="file" name="xmlFile"/> </div>		
<span><label /><input class="button" type="submit" value="Inserisci"/>
<label /><input class="button" type="reset" value="reset" /></span>
	</form></div>
<h4><a href="insertInteresse.jsp" class="generic">Inserisci un nuovo interesse</a></h4>
<div><h6><a class="generic" href="indexAdmin.jsp">torna alla home</a></h6></div>
</div>
<div id="footer"><h6>Cybion - monitoraggio dati</h6></div>
	

</body>
</html>