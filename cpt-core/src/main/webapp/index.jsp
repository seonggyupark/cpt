<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./css/primary.css" />
<title>Cybion perfect tool - homepage</title>
</head>
<body>

<div id="header"><jsp:include page="header.jsp"></jsp:include></div>

<div id="body">

<div class="form"><h3>Inserisci username e password</h3>
<form id="loginForm" action="loginController.do" method="post">
<div class="row"><label for="username">UserID:</label> <input name="username"
	type="text" /></div>
<div class="row"><label for="password">Password:</label> <input
	name="password" type="password" /></div> <br/> <br/>
<span><label /><input class="button" type="submit" value="login"/>
<label /><input class="button" type="reset" value="reset" /></span>
</form>
</div>
</div>
<h6><a class="generic" href="indexAdmin.jsp"></a></h6>

<div id="footer"><h6>Cybion - monitoraggio dati</h6></div>

</body>
</html>