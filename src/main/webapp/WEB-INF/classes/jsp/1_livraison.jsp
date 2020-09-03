<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>-->

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/livraisons.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>    
    <script src="<c:url value='/js/livraisons.js'/>"></script>
    <title>Réception de livraison</title>
</head>
<body onload="toggleSelect()">
    <form:form method="POST" modelAttribute="dto">
        <table>
            <tr>
                <th>Date</th>
                <th>Fournisseur</th>
                <th>Catégorie</th>
                <th>Nombre de palette<br/>(estimation)</th>
                <th></th>
            </tr>
            <tr>
                <td><form:input type="date" path="date" value="${dto.date}"/></td>
                <td>
                  <form:select path="fournisseurId" onclick="toggleSelect()" value="${dto.fournisseurId}">
                    <form:options items="${fournisseurs}" itemValue="id" itemLabel="nom"/>
                    <form:option value="0" label="Autre fournisseur"/>
                  </form:select>
                  <form:input path="fournisseurAutre" value="${dto.fournisseurAutre}"/>
                </td>
                <td>
                    <form:select path="categorieId" items="${categories}" itemValue="id" itemLabel="type" value="${dto.categorieId}" />
                </td>
                <td>
                    <form:input type="number" path="nombrePalette" value="${dto.nombrePalette}" />
                </td>
                <td><button id="submit">Réception</button></td>
            </tr>
            <tr class="${empty form.resultat ? "hidden" : ""}">
                <td><span class="erreur">${form.erreurs["date"]}</span></td>
                <td><span class="erreur">${form.erreurs["fournisseur"]}</span></td>
                <td><span class="erreur">${form.erreurs["categorie"]}</span></td>
                <td><span class="erreur">${form.erreurs["nbPalette"]}</span></td>
                <td><span class="${empty form.erreurs ? "succes" : "erreur"}">${form.resultat}</span></td>
            </tr>
        </table>
    </form:form>
    <input type="file" id="file">
    <button type="button" id="impression" name="impression" >Imprimer</button>
    <div id="feedback"></div>
</body>
</html> 