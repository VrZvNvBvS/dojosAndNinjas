<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <title>Dojo Locations</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-3">
        <div class="container">
            <a class="navbar-brand mb-0 h1" href="/dojos">Dojos</a>
            <a class="navbar-brand mb-0 h1 ms-auto" href="/ninjas">Ninjas</a>
        </div>
    </nav>
    <div class="container">
    	<div class="card">
            <h5 class="card-header">${dojo.firstName}, ${dojo.lastName}'s Ninjas</h5>
            <div class="card-body">
                <h3></h3>
                <ul class="list-group">
                    <c:forEach var="ninja" items="${dojo.ninjas}">
                    <li class="list-group-item">${ninja.ninjaName} - ${ninja.ninjaType}</li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>