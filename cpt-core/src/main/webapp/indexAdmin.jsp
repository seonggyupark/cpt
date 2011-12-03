<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./css/primary.css" />
<title>Cybion - manage your info</title>
</head>
<body>
<div id="header"><jsp:include page="header.jsp"></jsp:include></div>
<div id="title">
	<h3>In questa pagina hai accesso a tutte le
	informazioni sui bandi, fonti, clienti e newsletter.</h3>
</div>

<div id="menudiv">
<table id="menu">
<tr>
	<td class="menuselected">Home</td><td> | </td>
	<td><a href="viewClienti.do">Clienti</a></td><td> | </td>
	<td><a href="viewFonti.do">Fonti</a></td><td> | </td>
	<td><a href="viewNavXML.do">Monitor</a></td><td> | </td>
	<td>Newsletter</td><td> | </td>
	<td>About</td>
</tr>
</table>
</div>

<!--<div id="body">-->
<!--	<div id="menu">-->
<!--	<ul>-->
<!--		<li><a href="viewFonti.do" class="generic">Visualizza le fonti</a></li>-->
<!--		<li><a href="viewClienti.do" class="generic">Visualizza i clienti </a></li>-->
<!--		<li><a href="loadInteressiPerFonte.do" class="generic">Inserisci una fonte</a></li>-->
<!--		<li><a href="loadInteressi.do" class="generic">Inserisci un cliente</a></li>-->
<!--		<li><a href="insertInteresse.jsp" class="generic">Inserisci un nuovo interesse</a></li>-->
<!--		<li><a href="viewNavXML.do" class="generic">Fai partire il crawling</a></li>-->
<!--		<li><a href="viewAnnotations.do" class="generic">Visualizza le Annotations</a></li>-->
<!--	</ul>-->
<!--</div>-->
<!--</div>-->


<div id="footer"><h6>Cybion - monitoraggio dati</h6></div>
</body>
</html>