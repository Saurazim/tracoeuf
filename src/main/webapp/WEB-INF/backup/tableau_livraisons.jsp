<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>-->

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
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
</body>
</html>