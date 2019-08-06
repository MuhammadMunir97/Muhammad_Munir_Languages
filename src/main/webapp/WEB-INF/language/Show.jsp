<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${languageById.name}"/></title>
</head>
<body>
<h1><c:out value="${languageById.name}"/></h1>
<p>Creator: <c:out value="${languageById.creator}"/></p>
<p>Current Version: <c:out value="${languageById.currentVersion}"/></p>
<a href="/language">Back to dashboard</a>
<a href="/language/${languageById.id}/edit">Edit Lagauge</a>
<form action="/language/${languageById.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
</body>
</html>