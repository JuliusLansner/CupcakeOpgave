<%@ page import="dat.backend.model.persistence.TopCakeFacade" %>
<%@ page import="dat.backend.model.entities.TopCake" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="dat.backend.model.persistence.BottomCakeFacade" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>
'


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


        <form name="topping" id="topping">
            <select name="top">
                <c:forEach var="item" items="${sessionScope.bottomliste}">
                    <option value="${item.navn}">${item.navn}</option>
                </c:forEach>
            </select>
            <br><br>
        </form>


        <form name="bottom" id="bottom">
            <select name="bund">
                <c:forEach var="item" items="${sessionScope.topliste}">
                    <option value="${item}">${item}</option>
                </c:forEach>
            </select>
            <br><br>
        </form>


        <form name="antal" id="antal">
            <select name="antal">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>
            <br><br>
        </form>


        <img src="image.png" id="dropdown-trigger">
        <div id="dropdown-list">
            <select>
                <option value="option1">Option 1</option>
                <option value="option2">Option 2</option>
                <option value="option3">Option 3</option>
            </select>
        </div>


        <form action="/ServletTilføjTilKurv" method="post">
            <input type="submit" id="tilføj" name="tilføj" placeholder="Tilføj"><br>
        </form>

        <c:if test="${sessionScope.user != null}">
            <button type="button" class="btn btn-primary">Læg i kurv</button>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>Login for at tilføje til kurv!</p>
        </c:if>


    </jsp:body>

</t:pagetemplate>