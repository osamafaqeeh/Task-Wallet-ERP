<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/6/2020
  Time: 1:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>customer_information</title>
</head>
<body>
<div class="container">
    <div class="row">
        <a href="${pageContext.request.contextPath}/jsp/information_form.jsp?action=creat" class="btn btn-primary" role="button">Add Customer</a>
        <div class="text-warning">${requestScope.message}</div>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">#NUM</th>
                    <th scope="col">Name</th>
                    <th scope="col">Address</th>
                    <th scope="col">Country</th>
                    <th scope="col">City</th>
                    <th scope="col">Tax Number</th>
                    <th scope="col">Status</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.list}" var="customer" varStatus="loopCounter">
                    <tr>
                        <th scope="row">${loopCounter.count}</th>
                        <td>${customer.name}</td>
                        <td>${customer.address}</td>
                        <td>${customer.country}</td>
                        <td>${customer.city}</td>
                        <td>${customer.taxNumber}</td>
                        <td>${customer.activeCustomer}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/jsp/information_form.jsp?action=edit&customer_id=${customer.id}&name=${customer.name}&address=${customer.address}&country=${customer.country}&city=${customer.city}&tax_number=${customer.taxNumber}&active_customer=${customer.activeCustomer}" class="btn btn-primary" role="button">Update</a>
                            <a href="${pageContext.request.contextPath}/controller?command=delete_customer&customer_id=${customer.id}" class="btn btn-primary" role="button">Delete</a>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
