<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./css/default.css" />
<title>Cybion - inserisci interesse</title>
</head>
<body>
<div id="wrapper">
<div id="header">
<div id="logo"><jsp:include page="header.jsp"></jsp:include></div>
<br />
<hr />
<em>Inserisci un interesse.</em>
<hr />
</div>
<div id="menu">
<table id="menutab">
	<tr>
		<td><a href="#">Home</a></td>
		<td>|</td>
		<td><a href="viewClienti.do" class="generic">Clienti</a></td>
		<td>|</td>
		<td><a href="viewFonti.do" class="generic">Fonti</a></td>
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
<div class="page-bgbtm">
<div class="post">
<form method="post" action="insertInteresse.do">
<div class="entry"><label for="name">Nome Interesse:</label><input
	type="text" name="interesse" value="Nome interesse"
	onfocus="this.value='';" /></div>
<span><label /><input class="button" type="submit"
	value="inserisci" /> <label /><input class="button" type="reset"
	value="reset" /></span></form>
</div>
<h6><a class="generic" href="indexAdmin.jsp">torna alla home</a></h6>
</div>
</div>
</div>
<div id="footer">
<p>Cybion - monitoraggio dati</p>
</div>
</body>
</html>