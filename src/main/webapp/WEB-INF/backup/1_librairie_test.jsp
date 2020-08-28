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
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/test.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/switchSlider.css">

    <title>Réception de livraison</title>
</head>

<body>
    <section>
        <table>
            <tr>
                <th>Date</th>
                <th>Fournisseur</th>
                <th>Catégorie</th>
                <th>Poids</th>
                <th>Tare</th>
                <th></th>
            </tr>
            <tr>
                <td>
                    <form:input type="date" id="date" path="date" value="${livraison.date}" />
                </td>
                <td>
                    <form:select id="id_fournisseur" path="idFournisseur" onchange="toggleSelect()">
                        <form:options items="${fournisseurs}" itemValue="id" itemLabel="nom" />
                    </form:select>
                    <form:input id="autre_fournisseur" path="autreFournisseur" type="text"
                        placeholder="Autre Fournisseur" cssClass="hidden" />
                    <span class="erreur">${form.erreurs['fournisseur']}</span>
                </td>
                <td>
                    <form:radiobutton label="BIO" value="1" path="idCategorie" />
                    <form:radiobutton label="PAS" value="3" path="idCategorie" />
                    <form:radiobutton label="PA" value="2" path="idCategorie" />
                    <form:radiobutton label="CAGE" value="4" path="idCategorie" />
                    <span class="erreur">${form.erreurs['categorie']}</span></td>
                <td><input type="number" id="poidsPalette" name="poidsPalette"
                        value="<c:out value='${livraison.brutTotal}' />" />
                    <span class="erreur">${form.erreurs['poids']}</span>
                    <input id="brut" name="type_poids" onclick="ableTare()" checked="checked" type="radio" value="brut">
                    <label for="brut">brut</label>
                    <input id="net" name="type_poids" onclick="disableTare()" type="radio" value="net">
                    <label for="net">net</label></td>
                <td>
                    <fieldset id="div_nb_alveole" class="tare_nb_alveole grid twocolumn">
                        <input id="tareNbAlveole5" name="tareNbAlveole" class="tare_nb_alveole" type="radio" value="5"
                            checked="checked">
                        <label for="tareNbAlveole5">5</label>
                        <input id="tareNbAlveole4" name="tareNbAlveole" class="tare_nb_alveole" type="radio" value="4"
                            checked="checked">
                        <label for="tareNbAlveole4">4</label>
                        <input id="tareNbAlveole3" name="tareNbAlveole" class="tare_nb_alveole" type="radio" value="3"
                            checked="checked">
                        <label for="tareNbAlveole3">3</label>
                        <input id="tareNbAlveole2" name="tareNbAlveole" class="tare_nb_alveole" type="radio" value="2"
                            checked="checked">
                        <label for="tareNbAlveole2">2</label>
                        <input id="tareNbAlveole1" name="tareNbAlveole" class="tare_nb_alveole" type="radio" value="1"
                            checked="checked">
                        <label for="tareNbAlveole1">1</label>
                    </fieldset>
                    <fieldset id="div_type_palette" class="tare_type_palette grid twocolumn">
                        <input id="tareTypePalette1" name="tareTypePalette" class="tare_type_palette" type="radio"
                            value="plastique" checked="checked">
                        <label for="tareTypePalette1">plastique</label>
                        <input id="tareTypePalette2" name="tareTypePalette" class="tare_type_palette" type="radio"
                            value="carton">
                        <label for="tareTypePalette2">carton</label>
                    </fieldset>
                    <input id="check_tare" name="checkTare" onclick="toggleCheck()" type="checkbox">
                    <label for="check_tare">Autre</label>
                    <input id="nb_tare" name="nb_tare" class="displayNone" type="number">
                    <span class="erreur">${form.erreurs["nb_tare"]}</span>
                </td>
                <td>
                    <input type="button"/>
                    <input type="button"/>
                    <input type="button"/>
                </td>
            </tr>
        </table>
    </section>
    <section class="col-12">
        <table class="padding">
            <tr>
                <th>Date</th>
                <th>Fournisseur</th>
                <th>Catégorie</th>
                <th>Poids Brut (kg)</th>
                <th>Tare (kg)</th>
                <th>Poids Net (kg)</th>
            </tr>
            <c:forEach items="${livraisons}" var="item">
                <tr>
                    <td>
                        <fmt:parseDate value="${item.date}" pattern="yyyy-MM-dd" var="itemDate" type="date" />
                        <fmt:formatDate value="${itemDate}" pattern="dd/MM/yy" />
                    </td><%--${sdf}"/></td>--%>
                    <td>
                        <c:out value="${item.fournisseur}" default=" - " />
                    </td>
                    <td>
                        <c:out value="${item.categorie}" default=" - " />
                    </td>
                    <td>${!empty item.brutTotal ? item.brutTotal : " - "}</td>
                    <td>${!empty item.tare ? item.tare : " - "}</td>
                    <td>${item.netTotal!=0 ? item.netTotal : " - "}</td>
                </tr>
            </c:forEach>
            <tr>
                <td><%="19/06/20"%></td>
                <td>Blanchard</td>
                <td>Bio</td>
                <td> - </td>
                <td> - </td>
                <td>860</td>
            </tr>
            <tr>
                <td>19/06/20</td>
                <td>Blanchard</td>
                <td>Bio</td>
                <td> - </td>
                <td> - </td>
                <td>860</td>
            </tr>
            <tr>
                <td>19/06/20</td>
                <td>Blanchard</td>
                <td>Bio</td>
                <td> - </td>
                <td> - </td>
                <td>860</td>
            </tr>

        </table>
    </section>
</body>

</html>