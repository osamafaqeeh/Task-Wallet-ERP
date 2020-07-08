<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/6/2020
  Time: 1:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/dropDownList.js"></script>
    <title>Information form</title>


</head>
<body>
<div class="container-fluid">
    <c:set var="action" value="${param.action}" scope="request"/>

    <form class="md-form" action="${pageContext.request.contextPath}/controller" method="post" >

        <c:if test="${action eq 'edit'}">
            <c:set var="id" value="${param.customer_id}" scope="request"/>
            <c:set var="name" value="${param.name}" scope="request"/>
            <c:set var="address" value="${param.address}" scope="request"/>
            <c:set var="country" value="${param.country}" scope="request"/>
            <c:set var="city" value="${param.city}" scope="request"/>
            <c:set var="tax_number" value="${param.tax_number}" scope="request"/>
            <c:set var="active_customer" value="${param.active_customer}" scope="request"/>

            <input type="hidden"  name="command" value="update_customer"/>
            <input type="hidden"  name="customer_id" value="${id}" />
            <input type="hidden"  name="action" value="${action}" />
        </c:if>
        <c:if test="${action eq 'creat'}">
            <input type="hidden"  name="command" value="add_customer" />
            <input type="hidden"  name="action" value="${action}" />
        </c:if>

    <input type="hidden"  name="active_customer" value="INACTIVE" />
    <div class="form-row">
        <div class="form-group col-xs-6">
            <label >Name</label>
            <input type="text" class="form-control" name="name" value="${name}">
        </div>
        <div class="form-group col-xs-6">
            <label>Address</label>
            <input type="text" class="form-control" name="address" value="${address}">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-xs-12">
            <label>Tax Number</label>
            <input type="text" class="form-control" name="tax_number" value="${tax_number}">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group ">
            <label for="countySel">Select Country:</label><select  name="country"  id="countySel" size="1">
            <option value="${country}" selected="selected">Select Country</option>
            </select>
        </div>
    </div>
        <div class="form-group ">
            <label for="stateSel">Select State:</label><select name="city" id="stateSel" size="1">
            <option value="${city}"  selected="selected">Please select Country first</option>
            </select>
        </div>

    <div class=form-row">
        <div class="form-group">
            <div class="form-check">
                <label class="form-check-label" for="gridCheck">
                  Active
                </label>
                <input class="form-check-input" type="checkbox" id="gridCheck" name="active_customer" value="ACTIVE">
            </div>
        </div>
    </div>
    <div class=form-row">
    <button type="submit" class="btn btn-primary">Sign in</button>
        <div class="text-warning">${requestScope.message}</div>
    </div>

</form>
</div>
</body>
</html>
