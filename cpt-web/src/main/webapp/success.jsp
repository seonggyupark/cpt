<?xml version="1.0" encoding="UTF-8" ?>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./css/default.css" />
<meta http-equiv="Refresh" content="10;url=indexAdmin.jsp" />  
<title>Cybion - Operazione confermata</title>
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
<a href="#">Operazione confermata</a>
<h6> Redirect automatico in 10 secondi oppure <a class="generic" href="indexAdmin.jsp"> Torna alla home </a></h6></div>  
<h4><c:out value="${message}" escapeXml="false"/></h4>
</div>
</div>
</div>
<div id="footer"><p>Cybion - monitoraggio dati</p></div>
</body>
</html>