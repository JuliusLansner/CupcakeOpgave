<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>
<!-- Bootstrap tag - allows us to use bootstrop -->



<t:pagetemplate>

    <jsp:attribute name="header">
         Velkommen ${sessionScope.user.username}

    </jsp:attribute>

    <jsp:body>
        <div class="container">
            <!-- tværgående rækker hen over siden -->
            <div class="row">
                <!-- sidens kolonner. 6 angiver at kolonnen skal fylde 6 ud af 12 felter -->
                <div class="col-6">
                    <h2>Kunder</h2>
                    <div class="dropdown">
                        <form action="/action_page.php" name="topping" id="kunder">
                            <label for="kunder"></label>
                            <select name="Kunder">
                                <option value="volvo">Volvo</option>
                                <option value="saab">Saab</option>
                                <option value="opel">Opel</option>
                                <option value="audi">Audi</option>
                            </select>
                        </form>
                    </div>
                </div>
                <div class="col-6">
                    <h2>Ordrer</h2>
                    <div class="dropdown">
                        <form action="/action_page.php" name="topping" id="ordrer">
                            <label for="ordrer"></label>
                            <select name="Ordrer">
                                <option value="volvo">Volvo</option>
                                <option value="saab">Saab</option>
                                <option value="opel">Opel</option>
                                <option value="audi">Audi</option>
                            </select>
                        </form>
                    </div>
                </div>
            </div>

            <!-- bootstrap JS tags -->


        </div>

    </jsp:body>

</t:pagetemplate>