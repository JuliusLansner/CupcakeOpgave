<%@ page import="dat.backend.model.persistence.TopCakeFacade" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>'


<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the frontpage
    </jsp:attribute>

    <jsp:body>

        <div>
            <h1 class="designtext">
                Design din egen Cupcake
            </h1>
        </div>

        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Vælg topping
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                <a class="dropdown-item" href="#">Chocolate</a>
                <a class="dropdown-item" href="#">Vanilla</a>
                <a class="dropdown-item" href="#">Pistacio</a>
            </div>
        </div>


        <c:set var="topCakeList" value="<%= Arrays.asList(TopCakeFacade.topCakeList()) %>" />


        <form  name="topping" id="topping">
            <select name="top">
                <c:forEach var="item" items="${topCakeList}">
                    <option value="${item}">${item}</option>
                </c:forEach>
            </select>
            <br><br>
        </form>


        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Vælg bottom
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton2">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <a class="dropdown-item" href="#">Something else here</a>
            </div>
        </div>

        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton3" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Antal
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton3">
                <a class="dropdown-item" href="#">1</a>
                <a class="dropdown-item" href="#">2</a>
                <a class="dropdown-item" href="#">3</a>
            </div>
        </div>
        <c:if test="${sessionScope.user != null}">
            <button type="button" class="btn btn-primary">Læg i kurv</button>
        </c:if>
        <c:if test="${sessionScope.user == null}">
            <p>Login for at tilføje til kurv!</p>
        </c:if>




    </jsp:body>

</t:pagetemplate>