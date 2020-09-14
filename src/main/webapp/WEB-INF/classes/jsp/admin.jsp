<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>-->

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Administration</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sidebar.css">
  </head>
  <body>
    <nav class="topbar">
      <ul>
        <li><a href="<c:url value='/'/>">Home</a></li>
        <li><a href="#" class="active">Administration</a></li>
      </ul>
    </nav>
    <%--<nav class="sidebar">
      <ul>
        <li><a>Livraisons</a></li>
        <li><a>Palettes</a></li>
      </ul>
    </nav>--%>
    <table class="padding">
      <tr>
        <th>Date</th>
        <th>Fournisseur</th>
        <th>Catégorie</th>
        <th>nb Palettes</th>
        <th>Bon de Livraison/<br>Référence</th>
        <th>Poids/p</th>
        <th>Conforme</th>
        <th>Commentaires</th>
      </tr>
      <c:forEach items="${livraisons}" var="l">
        <tr class="liv">
          <td>${empty l.date? " - ":l.date}</td>
          <td>${empty l.fournisseur?" - ":l.fournisseur}</td>
          <td>${empty l.categorie?" - ":l.categorie}</td>
          <td>${empty l.nbPalette?" - ":l.nbPalette}</td>
          <td>${empty l.bonLivraison?" - ":l.bonLivraison}</td>
          <td>${empty l.netTotal?" - ":l.netTotal}</td>
          <td></td>
          <td></td>
        </tr>
        <c:forEach items="${palettes}" var="p">
          <c:if test="${p.livraisonId==l.id}">
            <tr class="palette ${p.conforme?"OK":"KO"}">
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td>${empty p.reference?" - ":p.reference}</td>
              <td>${empty p.net?" - ":p.net}</td>
              <td>${p.conforme?"OK":"KO"}</td>
              <td>${empty p.commentaires?"N/A":p.commentaires}</td>
            </tr>
          </c:if>
        </c:forEach>
      </c:forEach>
    </table>
  </body>
</html>