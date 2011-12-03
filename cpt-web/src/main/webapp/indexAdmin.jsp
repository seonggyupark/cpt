<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./css/default.css" />
<title>Cybion - manage your info</title>
</head>
<body>
<div id="wrapper">
<div id="header">
    <div id="logo"> <jsp:include page="header.jsp"></jsp:include></div>
    <br/>
    <hr/>
        <em>In questa pagina hai accesso a tutte le
        informazioni sui bandi, fonti, clienti e newsletter.</em>
    <hr/>
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
        <div class="post">
            <h2 class="title"><a href="#">Welcome!</a></h2>
        </div>
    </div>
</div>
<div id="footer">
    <p>Cybion - monitoraggio dati</p>
</div>
</div>
</body>
</html>