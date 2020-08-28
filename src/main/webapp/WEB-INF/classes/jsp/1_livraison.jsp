<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>-->

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/livraisons.css">
    <meta charset="UTF-8">
    <title>Réception de livraison</title>
</head>
<body>
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
                <td><form:input type="date" path="date"/></td>
                <td>
                  <form:select path="fournisseurId">
                    <form:options items="${fournisseurs}" itemValue="id" itemLabel="nom"/>
                    <form:option value="0" label="Autre fournisseur"/>
                  </form:select>
                </td>
                <td>
                    <form:select path="categorieId" items="${categories}"/>
                </td>
                <td>
                    <form:input type="number" path="nombrePalette"/>
                </td>
                <td><button>Réception</button></td>
            </tr>
        </table>
    </form:form>
      <script src="<c:url value='${pageContext.request.contextPath}/classes/js/livraisons.js'/>"></script>
</body>
</html>