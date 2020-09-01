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
</head>
<body onload="listenersAdding(0)">
    <form method="POST" action="${pageContext.request.contextPath}/save_palettes" modelAttribute="livraisonForm">
        <section>
            <p>${bo.prefix}</p>
            <input type="hidden" name="prefix" value="${bo.prefix}">
            <input type="hidden" name="id" value="${bo.id}">
        </section>
        <table>
            <tr>
                <th>Numéro</th>
                <th>Poids(kg)</th>
                <th>Tare(kg)</th>
                <th>Poids Net(kg)</th>
                <th>Conformité<br/>des critères<br/>de réception</th>
                <th>Commentaires</th>
                <th>Actions</th>
            </tr>
            <tbody id="formulaire">
                <tr class="${resultat!="Echec" ? 'displayNone' : 'reussit'}">
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
    <script src="<c:url value='js/palettes.js'/>"></script>
</body>
</html>