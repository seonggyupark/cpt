<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./css/primary.css" />
<title>Cybion - inserisci interesse</title>
</head>
<body>
<div id="header"><jsp:include page="header.jsp"></jsp:include></div>
<div id="title">
<h3>Inserisci un nuovo interesse</h3>
</div>
<div class="form">
<form method="post" action="insertInteresse.do">
<div class="row"><label for="name">Nome Interesse:</label><input
	type="text" name="interesse" value="Nome interesse"
	onfocus="this.value='';" /></div>
<span><label /><input class="button" type="submit" value="inserisci"/>
<label /><input class="button" type="reset" value="reset" /></span></form></div>
<h6><a class="generic" href="indexAdmin.jsp">torna alla home</a></h6>
<div id="footer"><h6>Cybion - monitoraggio dati</h6></div>
</body>
</html>