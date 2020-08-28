<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>-->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/style.css">
    <title>Jaunovo</title>
</head>
<body>
<section>
    <h1>Suivi de pasteurisation discontinue : Jaunovo</h1>
    <form>
        <div>
             <h1 class="titre_data">Lot </h1>
            <input type="text" id="lot">
        </div>
        <div>
             <h1 class="titre_data">Dénomination du produit </h1>
            <input type="radio" name="nom_prod" id="j50">
            <label for="j50">Jaunovo 50</label>
            <input type="radio" name="nom_prod" id="j11">
            <label for="j11">Jaunovo 11</label>
            <input type="radio" name="nom_prod" id="j11o">
            <label for="j11o">Jaunovo 11 ovocolor</label><br>
            <input type="radio" name="nom_prod" id="j11bio">
            <label for="j11bio">Jaunovo 11 BIO</label>
            <input type="radio" name="nom_prod" id="j11pas">
            <label for="j11pas">Jaunovo 11 PAS</label>
            <input type="radio" name="nom_prod" id="j11pa">
            <label for="j11pa">Jaunovo 11 PA</label>
        </div>
        <h1>1. Cassage</h1>
        <div>
             <h1 class="titre_data">Date de cassage </h1><br>
            <input type="date" id="date_cass"/>
        </div>
        <div>
             <h1 class="titre_data">Heure de cassage </h1>
            <input type="time" id="heure_cass">
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
             <h1 class="titre_data">Produit </h1>
            <input type="radio" name="prod" id="prod_sucre">
            <label for="prod_sucre">Sucre 50%</label>
            <input type="radio" name="prod" id="prod_sel">
            <label for="prod_sel">Sale 11%</label>
        </div>
        <div>
             <h1 class="titre_data">Lots recyclés </h1>
            <input type="text" id="lot_recycl">
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
             <h1 class="titre_data">Quantité de JAUNE mise en oeuvre avant pasteurisation </h1>
            <input type="number" id="qte_jaune_avant">
        </div>
        <h1>2. Pasteurisation</h1>
        <div>
             <h1 class="titre_data">Date de pasteurisation </h1><br>
            <input type="date" id="date_pasto"/>
        </div>
        <div>
             <h1 class="titre_data">Heure de pasteurisation </h1>
            <input type="time" id="heure_pasto">
        </div>
        <div>
             <h1 class="titre_data">Température temoin </h1>
            <input type="text" name="temp" id="temp">
        </div>
        <div>
             <h1 class="titre_data">Cuve de pasteurisation </h1>
            <input type="radio" name="cuve" id="cp2">
            <label for="cp2">Cuve Process 2</label>
            <input type="radio" name="cuve" id="cp3">
            <label for="cp3">Cuve Process 3</label>
        </div>
        <div>
             <h1 class="titre_data">Quantité en pasteurisation </h1>
            <label for="qte_jaune_apres">Jaune</label>
            <input type="number" id="qte_jaune_apres"/><br>
            <input type="radio" name="additif" id="sel">
            <label for="sel">Sel</label>
            <input type="radio" name="additif" id="sucre">
            <label for="sucre">Sucre</label><br>
            <input type="number" name="pds_additif" id="pds_additif">
        </div>
        <h1>4. Conditionnement</h1>
        <div>
             <h1 class="titre_data">Date de conditionnement </h1><br>
            <input type="date" id="date_cond"/>
        </div>
        <div>
             <h1 class="titre_data">Heure de conditionnement </h1>
            <input type="time" id="heure_cond">
        </div>
        <div>
             <h1 class="titre_data">Horaires </h1>
            <label for="debut">Début</label>
            <input type="time" id="debut"><br>
            <label for="fin">Fin</label>
            <input type="time" id="fin">
        </div>

        <div>
             <h1 class="titre_data">Conditionnement </h1>
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
        <label for="control">Lot de températures enregistré ?</label>
        <input type="checkbox" name="control" id="control">
        <input type="button" value="Valider" id="valider">
    </form>
</section>
</body>
</html>