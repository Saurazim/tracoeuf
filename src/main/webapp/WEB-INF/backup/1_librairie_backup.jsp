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
    <script src="<c:url value='js/fields.js'/>"></script>
    <script src="<c:url value='js/script.js'/>"></script>

    <title>Réception de livraison</title>
</head>

<body onload="init(0)">
    <section>
        <form method="post" action="<c:url value='livraison'/>" modelAttribute="livraisonForm">
            <table >
                <thead>
                    <tr>
                        <th>Numéro</th>
                        <th>Date</th>
                        <th>Fournisseur</th>
                        <th>Catégorie</th>
                        <th>Poids (kg)</th>
                        <th>Tare (kg)</th>
                        <th></th>
                    </tr>
                    <tr id="tr_errors">
                      <td></td>
                      <td><span class="erreur">${form.erreurs['date']}</span></td>
                      <td><span class="erreur">${form.erreurs['fournisseur']}</span></td>
                      <td><span class="erreur">${form.erreurs['categorie']}</span></td>
                      <td><span class="erreur">${form.erreurs['poids']}</span></td>
                      <td><span class="erreur">${form.erreurs["nb_tare"]}</span></td>
                      <td><p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p></td>
                    </tr>
                </thead>
                <!--le code suivant la balise tbody est copié lors de la duplication des champs.-->
                <!--ne pas supprimer le premier champ, sous peine de ne plus pouvoir dupliquer les champs-->
                <tbody id="formulaire">
                    <tr class="tr grid sevenColumn" id="0">
                        <td>0<input name="list[0].idColumn" type="hidden" value="0"></td>
                        <td>
                            <input type="date" class="list[0] date" name="list[0].date" value="${livraisonForm.list[0].date}" />
                        </td>
                        <td>
                            <select class="list[0] id_fournisseur" name="list[0].idFournisseur" onchange="toggleSelect(0)">
                              <c:forEach items="${fournisseurs}" var="fournisseur">
                                <option value="${fournisseur.id}">${fournisseur.nom}</option>
                              </c:forEach>
                              <option value="0">Autre Fournisseur</option>
                            </select>
                            <input class="list[0] autre_fournisseur hidden" name="list[0].autreFournisseur" type="text"
                                placeholder="Autre Fournisseur" />
                        </td>
                        <td>
                        <select class="list[0] categories" name="list[0].idCategorie">
                          <c:forEach items="${categories}" var="categ">
                            <option value="${categ.id}">${categ.type}</option>
                          </c:forEach>
                          </select>
                        </td>
                        <td class="grid twoRow">
                            <input class="list[0]" type="number" name="list[0].poidsPalette" />
                            <span class="erreur"></span>
                            <label>
                            <input class="list[0] typePoids hidden" type="hidden" name="list[0].typePoids" value="false">
                            <input class="list[0] typePoids checkbox 0" type="checkbox" name="list[0].typePoids" value="true"/>
                            net</label>

                        </td>
                        <td name="tare" class="tare 0">
                            <select name="list[0].nbAlveole" class="list[0] tare_nb_alveole">
                                <option>5</option>
                                <option>4</option>
                                <option>3</option>
                                <option>2</option>
                                <option>1</option>
                            </select>
                             <select name="list[0].typePalette" class="list[0] tare_type_palette">
                                <option>plastique</option>
                                <option>carton</option>
                            </select>
                            <input name="list[0].nbTare" class="list[0] nb_tare displayNone" type="number">
                            <label>
                            <input class="list[0] check_tare hidden" type="hidden" name="list[0].checkTare" value="false">
                            <input class="list[0] check_tare checkbox 0" name="list[0].checkTare" type="checkbox" checked value="true">
                            Autre</label>
                        </td>
                        <td>
                            <input class="addFields" onclick="addFields()" type="button" value=" + ">
                            <input class="delIt 0" type="button" value=" - ">
                            <button>Valider</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </section>
    <!--tableau affichant les livraisons déjà enregistrées en bdd-->
  <section class="col-12">
    <table class="padding">
      <tr>
        <th>Date</th>
        <th>Fournisseur</th>
        <th>Catégorie</th>
        <th>Poids Net total (kg)</th>
        <th>Nombre de palette</th>
        <th>Préfixe Code</th>
      </tr>
      <%--duplication des lignes--%>
      <c:forEach items="${livraisons}" var="item">
        <tr>
          <td>
            <fmt:parseDate value="${item.date}" pattern="yyyy-MM-dd" var="itemDate" type="date" />
            <fmt:formatDate value="${itemDate}" pattern="dd/MM/yy" />
          </td>
          <td>
            <c:out value="${item.fournisseur.nom}" default=" - " />
          </td>
          <td>
            <c:out value="${item.categorie.type}" default=" - " />
          </td>
          <td>${item.netTotal!=0 ? item.netTotal : " - "}</td>
          <td>${item.palettes.size()!=0 ? item.palettes.size() : " - "}</td>
          <td><c:out value="${item.prefixCode}" default=" - "/></td>
        </tr>
      </c:forEach>
    </table>
  </section>
  <script src="<c:url value='${pageContext.request.contextPath}/js/script.js'/>"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</body>

</html>