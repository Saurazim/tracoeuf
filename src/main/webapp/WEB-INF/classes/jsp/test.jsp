<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>-->

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/switchSlider.css">
  
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="<c:url value='${pageContext.request.contextPath}/js/fields.js'/>"></script>
    <script src="<c:url value='${pageContext.request.contextPath}/js/script.js'/>"></script>

    <title>Réception de livraison</title>
</head>

<body onload="init()">
    <section>
        <form method="post" action="/testdto" modelAttribute="list">
            <table >
                <thead>
                    <tr>
                        <th>Numéro</th>
                        <th>Date</th>
                        <th>Fournisseur</th>
                        <th>Catégorie</th>
                        <th>Poids</th>
                        <th>Tare</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody id="formulaire">
                    <tr class="tr" id="0">
                        <td>
                            0
                            <input class="list[0]" name="list[0].idColumn" type="hidden" value="0">
                        </td>
                        <td>
                            <input type="date" class="list[0] date" name="list[0].date" value="" />
                        </td>
                        <td>
                            <select class="list[0] id_fournisseur" name="list[0].idFournisseur" onchange="toggleSelect(0)">
                                <option>option 1</option>
                                <option>option 2</option>
                                <option>option 3</option>
                                <option>option 4</option>
                                <option value="0">...</option>
                            </select>
                            <input class="list[0] autre_fournisseur hidden" name="list[0].autreFournisseur" type="text"
                                placeholder="Autre Fournisseur" />
                        </td>
                        <td>
                            <select class="list[0]" name="list[0].idCategorie">
                                <option value="1">BIO</option>
                                <option value="2">PA</option>
                                <option value="3">PAS</option>
                                <option value="4">CAGE</option>                            
                            </select>
                        </td>
                        <td>
                            <input class="list[0]" type="number" name="list[0].poidsPalette" />
                            <span class="erreur"></span>
                            <label>
                            <input class="list[0] typePoids hidden" type="hidden" name="list[0].typePoids" value="false">
                            <input class="list[0] typePoids checkbox 0" type="checkbox" name="list[0].typePoids" value="true"/>
                            net</label>

                        </td>
                        <td name="tare" class="tare 0">
                            <select name="list[0].nbAlveole" class="list[0] tare_nb_alveole grid twocolumn">
                                <option>5</option>
                                <option>4</option>
                                <option>3</option>
                                <option>2</option>
                                <option>1</option>
                            </select>
                             <select name="list[0].typePalette" class="list[0] tare_type_palette grid twocolumn">
                                <option>plastique</option>
                                <option>carton</option>
                            </select>
                            <label>
                            <input class="list[0] check_tare hidden" type="hidden" name="list[0].checkTare" value="false">
                            <input class="list[0] check_tare checkbox 0" name="list[0].checkTare" type="checkbox" value="true">
                            Autre</label>
                            <input name="list[0].nbTare" class="list[0] nb_tare displayNone" type="number">
                        </td>
                        <td>
                            <input class="addFields" onclick="addFields()" type="button" value="Ajouter">
                            <input class="delIt 0" type="button" value="Supprimer">
                            <button>Valider</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </section>
</body>

</html>