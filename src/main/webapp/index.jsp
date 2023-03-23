<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

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
        <form action="/action_page.php" name="topping" id="topping">
            <label for="topping"></label>
            <select name="topping">
                <option value="volvo"></option>
                <option value="saab">Saab</option>
                <option value="opel">Opel</option>
                <option value="audi">Audi</option>
            </select>

            <label for="topping"></label>
            <select name="topping">
                <option value="volvo">Volvo</option>
                <option value="saab">Saab</option>
                <option value="opel">Opel</option>
                <option value="audi">Audi</option>
            </select>
             <label for="topping"></label>
            <select name="topping">
                <option value="volvo">Volvo</option>
                <option value="saab">Saab</option>
                <option value="opel">Opel</option>
                <option value="audi">Audi</option>
            </select>


        </form>
        </div>
        <c:if test="${sessionScope.user != null}">
            <button type="button" class="btn btn-primary">Læg i kurv</button>
        </c:if>
        <c:if test="${sessionScope.user == null}">
            <p>Login for at tilføje til kurv!</p>
        </c:if>




    </jsp:body>

</t:pagetemplate>