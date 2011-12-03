<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./css/default.css" />
<title>Cybion - modifica Fonte</title>
</head>
<body>
<div id="wrapper">
<div id="header">
<div id="logo"><jsp:include page="header.jsp"></jsp:include></div>
<br />
<em>Modifica fonte</em>
<hr />
</div>
<div id="menu">
<table id="menutable">
<tr>
  <td><a href="#">Home</a></td><td> | </td>
  <td><a href="viewClienti.do">Clienti</a></td><td> | </td>
  <td><a href="viewFonti.do">Fonti</a></td><td> | </td>
  <td><a href="viewNavXML.do">Monitor</a></td><td> | </td>
  <td><a href="#">Newsletter</a></td><td> | </td>
  <td><a href="#">About</a></td>
</tr>
</table>
</div>
<div id="page">
<div id="page-bgbtm">
<div class="title">Modifica fonte: <c:out value="${fonte.nome}" />
</div>
<form id="editFonteForm" action="modifyFonte.do" method="post">
<div class="entry"><label for="nome">Nome:</label> <input
	name="nome" type="text" value="<c:out value="${fonte.nome}"/>" /></div>
<div class="entry"><label for="link">Link:</label> <input
	name="link" type="text" value="<c:out value="${fonte.link}"/>" /> <input
	type="hidden" name="idFonte" value="<c:out value="${fonte.idFonte}"/>" />
</div>
<span><label /><input class="button" type="submit"
	value="modifica" /> <label /><input class="button" type="reset"
	value="reset" /></span></form>
</div>
<div class="entry">
<hr/>
<p>Elimina fonte</p>
<form id="deleteFonteForm"
	action="deleteFonte.do?idFonte=<c:out value="${fonte.idFonte}"/>"
	method="post"><label /> <input class="button" type="submit"
	value="elimina" /></form>
</div>
<h6><a class="generic" href="indexAdmin.jsp">torna alla home</a></h6>
</div>
</div>
<div id="footer">
<p>Cybion - monitoraggio dati</p>
</div>
</body>
</html>