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
    <form method="POST" action="" modelAttribute="livraisonForm">
        <table>
            <tr>
                <th>Numéro</th>
                <th>Poids(kg)</th>
                <th>Tare(kg)</th>
                <th>Poids Net(kg)</th>
                <th>Conformité</th>
                <th>Commentaires</th>
                <th>${dto.date}</th>
            </tr>
            <tbody id="formulaire">
                <tr class="tr" id="0">
                    <td>0<input name="list[0].idColumn" type="hidden" value="0"></td>
                    <td><input type="number" class="poids" name="list[0].poids"></td>
                    <td><input type="number" class="tare" name="list[0].tare"></td>
                    <td><input type="number" class="net disabled" name="list[0].net"></td>
                    <td><input type="checkbox" name="list[0].conforme"></td>
                    <td><textarea name="list[0].commentaires"></textarea></td>
                    <td>
                        <input type="button" value="+" class="addFields">
                        <input type="button" value="-" class="delFields">
                        <button>Valider</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
    <script src="<c:url value='js/palettes.js'/>"></script>
</body>
</html>