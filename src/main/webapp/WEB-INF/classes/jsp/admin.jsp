<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>-->

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Administration</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css">
  </head>
  <body>
    <nav class="topbar">
      <ul>
        <li><a>Home</a></li>
        <li><a>Administration</a></li>
      </ul>
    </nav>
    <nav class="sidebar">
      <ul>
        <li><a>Livraisons</a></li>
        <li><a>Palettes</a></li>
      </ul>
    </nav>
    <table>
      <tr>
        <th>Date</th>
        <th>Fournisseur</th>
        <th>Catégorie</th>
        <th>nb Palettes</th>
        <th>Référence</th>
        <th>Poids/p</th>
      </tr>
      <c:forEach items="${livraisons}" var="l">
        <tr>
          <td>${l.date}</td>
          <td>${l.fournisseur}</td>
          <td>${l.categorie}</td>
          <td>${l.nbPalette}</td>
          <td>${l.prefix}</td>
          <td>${l.netTotal}</td>
        </tr>
        <c:forEach items="${palettes}" var="p">
          <c:if test="${p.livraisonId=l.id}">
            <tr>
              <td> - </td>
              <td> - </td>
              <td> - </td>
              <td> - </td>
              <td>${p.reference}</td>
              <td>${p.net}</td>
            </tr>
          </c:if>
        </c:forEach>
      </c:forEach>
      <tr>
        <td>2020-08-20</td>
        <td>Blanchard</td>
        <td>BIO</td>
        <td>1</td>
        <td>RBLABIO0</td>
        <td>689</td>
      </tr>
      <tr>
        <td> - </td>
        <td> - </td>
        <td> - </td>
        <td> - </td>
        <td>RBLABIO00</td>
        <td>689</td>
      </tr>
    </table>
  </body>
</html>