<%--
  Created by IntelliJ IDEA.
  User: malde
  Date: 3/26/2023
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/buypage.css">
</head>
<body>

<form action="${pageContext.request.contextPath}/ServletBuy" method="get">
<details class="kortinfo" style="cursor: pointer">
    <summary style="list-style-type: none; border: 1px solid black; padding: 10px;">Betal med kort</summary>
    <div style="border: 1px solid black; padding: 10px;">
        <input placeholder="Kortnummer" type="text"><br><br>
        <input placeholder="Sikkerhedskode" type="text"><br><br>
        <input type="date"> <br> <br>
        <button type="submit">Køb</button>
    </div>
</details>
</form>


<form action="ServletToBuypage" method="post">
    <details class="walletinfo" style="cursor: pointer">
        <summary style="list-style-type: none; border: 1px solid black; padding: 10px;">Betal med din wallet ${sessionScope.user.username}</summary>
        <div style="border: 1px solid black; padding: 10px;">
            <label class="saldolabel"> Din saldo: ${sessionScope.userSaldo} ${sessionScope.user.username}</label> <br> <br>
            <button type="submit">Køb</button>
        </div>
        <%= request.getAttribute("brugernavn") %>

    </details>
</form>

</body>
</html>
