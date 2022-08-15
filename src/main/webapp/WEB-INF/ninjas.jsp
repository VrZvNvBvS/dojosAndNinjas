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
    <title>Dojos and Ninjas</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-3">
        <div class="container">
            <a class="navbar-brand mb-0 h1" href="/dojos">Dojos</a>
            <a class="navbar-brand mb-0 h1 ms-auto" href="/ninjas">Ninjas</a>
        </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-12 col-sm-12">
                <div class="card">
                    <h5 class="card-header">All Ninjas</h5>
                    <div class="card-body">
                        <table class="table table-striped">
                            <thead>
                                <th>NINJA:</th>
                                <th>AGE:</th>
                            </thead>
                            <tbody>
                                <c:forEach var="ninja" items="${allNinjas}">
                                <tr>
                                    <td>${ninja.ninjaName}</td>
                                    <td>${ninja.ninjaType}</td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-12 col-sm-12">
                <div class="card">
                    <h5 class="card-header">Create Ninja Profile</h5>
                    <div class="card-body">
                        <form:form action="/ninjas/insert" method="POST" modelAttribute="ninja">
                            <div class="mb-3">
                                <form:label class="form-label" path="ninjaName">Full Name:</form:label>
                                <form:input class="form-control" path="ninjaName" />
                                <form:errors class="form-text text-danger" path="ninjaName" />
                            </div>
                            <div class="mb-3">
                                <form:label class="form-label" path="ninjaType">Age:</form:label>
                                <form:input class="form-control" path="ninjaType" />
                                <form:errors class="form-text text-danger" path="ninjaType" />
                            </div>
                            <div class="mb-3">
                                Choose Dojo Location:
                                <form:select class="form-select" path="dojo">
                                    <c:forEach var="dojo" items="${allDojos}">
                                        <form:option value="${dojo.id}">${dojo.firstName} ${dojo.lastName}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                            <div class="d-flex justify-content-end">
                                <input type="submit" value="ADD NINJA" class="btn btn-primary">
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>