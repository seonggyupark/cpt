<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./css/primary.css" />
<title>Cybion - modifica Fonte</title>
</head>
<body>

<div id="header"></div>

<div id="body">

<div class="form"><h3>Modifica fonte: <c:out value="${fonte.nome}" /> </h3>
<form id="editFonteForm" action="modifyFonte.do" method="post">
<div class="row">


<label for="nome">Nome:</label> <input name="nome"
	type="text" value="<c:out value="${fonte.nome}"/>"/>
	
	
	
</div>
<div class="row"><label for="link">Link:</label> <input
	name="link" type="text" value="<c:out value="${fonte.link}"/>"/>
	
	<input type="hidden" name="idFonte" value="<c:out value="${fonte.idFonte}"/>" />
	
	
	
	</div> <br/> <br/>
<span><label /><input class="button" type="submit" value="modifica"/>
<label /><input class="button" type="reset" value="reset" /></span>
</form>
</div>

<div class="form">
	<h3>Elimina fonte</h3>
	<form id="deleteFonteForm" action="deleteFonte.do?idFonte=<c:out value="${fonte.idFonte}"/>" method="post">
		<label /> <input class="button" type="submit" value="elimina" />
	</form>
</div>
<h6><a class="generic" href="indexAdmin.jsp">torna alla home</a></h6>
</div>
<div id="footer">
<h6>Cybion - monitoraggio dati</h6>
</div>

</body>
</html>