<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>-->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/style.css">
    <title>Blancovo</title>
</head>
<body>
<section>
    <h1>Suivi de pasteurisation discontinue : Blancovo</h1>
    <form>
        <div>
             <h1 class="titre_data">Température </h1>
            <input type="text" name="temp" id="temp">
        </div>
        <div>
             <h1 class="titre_data">Débit </h1>
            <input type="number" name="debit" id="debit">
        </div>
        <div>
             <h1 class="titre_data">Catégorie </h1>
            <input type="radio" id="BIO" name="categ">
            <label for="BIO">BIO</label>
            <input type="radio" id="PAS" name="categ">
            <label for="PAS">PAS</label><br>
            <input type="radio" id="PA" name="categ">
            <label for="PA">PA</label>
            <input type="radio" id="CAGE" name="categ">
            <label for="CAGE">CAGE</label><br>
        </div>
        <div>
             <h1 class="titre_data">Date des blancs </h1><br>
            <input type="date" id="date_blancs" name="date_blancs"/>
        </div>
        <div>
             <h1 class="titre_data">Horaires </h1>
            <label for="debut">Début</label>
            <input type="time" id="debut"><br>
            <label for="fin">Fin</label>
            <input type="time" id="fin">
        </div>
        <div>
             <h1 class="titre_data">Cuve </h1>
            <input type="radio" name="cuve1" id="cuve1A">
            <label for="cuve1A">Cuve A</label>
            <input type="radio" name="cuve1" id="cuve1B">
            <label for="cuve1B">Cuve B</label>
            <input type="radio" name="cuve1" id="cuve1C">
            <label for="cuve1C">Cuve C</label>
            <input type="radio" name="cuve1" id="cuve1D">
            <label for="cuve1D">Cuve D</label>
            <input type="radio" name="cuve1" id="container1">
            <label for="container1">Container</label>
        </div>
        <div>
             <h1 class="titre_data">Outres </h1>
            <input type="checkbox" name="conditionnement" id="cond5">
            <label for="cond5">5 kg</label>
            <input type="checkbox" name="conditionnement" id="cond10">
            <label for="cond10">10 kg</label>
        </div>
        <div>
             <h1 class="titre_data">Quantités produites </h1>
            <input type="number" name="qte" id="qte5">
            <input type="number" name="qte" id="qte10">
        </div>
        <label for="visa">Visa</label>
        <input type="password" name="visa" id="visa">
        <input type="button" value="Valider" id="valider">
    </form>
</section>
</body>
</html>