<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>-->

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Réception de Palettes</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/palettes.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sidebar.css">
</head>

<body onload="listenersAdding(0)">
    <nav class="topbar">
        <ul>
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/livraison">Livraison</a></li>
            <li><a href="${pageContext.request.contextPath}/palettes" class="active">Palettes</a></li>
        </ul>
    </nav>
    <form method="POST" action="${pageContext.request.contextPath}/save_palettes" modelAttribute="livraisonForm">
        <section class="sidebar">
            <select class="date" id="date" onclick="addOptionsSelect()">
                <c:forEach items="${dates}" var="date" >
                    <option value="<c:out value = '${date}'/>"><c:out value = "${date}"/></option>
                </c:forEach>
            </select>
            <select class="livraisonId" id="livraisonId" onclick="putValues()">
            </select>
            <p id="prefixVu"><p>
            <input type="hidden" id="prefix" name="prefix" value="${bo.prefix}">
            <input type="hidden" id="id" name="id" value="${bo.id}">
            <input type="text" id="bon" name="bon" placeholder="Bon de livraison">
        </section>
        <table>
            <tr>
                <th>Numéro</th>
                <th>Poids(kg)</th>
                <th>Tare(kg)</th>
                <th>Poids Net(kg)</th>
                <th>Conformité<br />des critères<br />de réception</th>
                <th>Commentaires</th>
                <th>Actions</th>
            </tr>
            <tbody id="formulaire">
                <tr class="${resultat!=" Echec" ? 'displayNone' : 'reussit' }">
                    <td></td>
                    <td><span class="erreur">${erreurs["brut"]}</span></td>
                    <td><span class="erreur">${erreurs["tare"]}</span></td>
                    <td><span class="erreur">${erreurs["net"]}</span></td>
                    <td><span class="erreur">${erreurs["check"]}</span></td>
                    <td><span class="erreur">${erreurs["comment"]}</span></td>
                    <td><span class="erreur">${resultat}</span></td>
                </tr>
                <tr class="tr" id="0">
                    <td>0<input name="list[0].idColumn" type="hidden" value="0"></td>
                    <td><input type="number" class="list[0] poids" name="list[0].poids"></td>
                    <td><input type="number" class="list[0] tare" name="list[0].tare"></td>
                    <td><input type="number" class="list[0] net disabled" name="list[0].net"></td>
                    <td><input type="checkbox" class="list[0]" name="list[0].conforme"></td>
                    <td><textarea class="list[0]" name="list[0].commentaires"></textarea></td>
                    <td>
                        <input type="button" value="+" class="list[0] addFields">
                        <input type="button" value="-" class="list[0] delFields">
                        <button>Valider</button>
                    </td>
                </tr>

            </tbody>
        </table>
    </form>
    <script>
        var livraisons = ${livraisons}
        var dates = ${dates}
    </script>
    <script src="<c:url value='js/palettes.js'/>"></script>
</body>

</html>