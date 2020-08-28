<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>-->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="../css/style.css">
        <title>Suivi de cassage des oeufs</title>
    </head>
    <body>
    <section>
        <h1>Suivi de cassage des oeufs</h1>
        <form>
            <div>
                 <h1 class="titre_data">Heure </h1><br>
                <input type="time" id="heure" name="date"/><br>
            </div>
            <div>
                 <h1 class="titre_data">Quantité </h1>
                <input type="number" id="nbPalette"><br>
                <h3>Poids net par palette</h3>
                <input type="number" id="pdsPal0">
                <input type="button" value="+" id="addPal">
                <input type="button" value="-" id="delPal">
            </div>
            <div>
                 <h1 class="titre_data">Catégorie </h1><br>
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
                 <h1 class="titre_data">Fournisseur </h1><br>
                <select id="fournisseur" name="fournisseur">
                    <option value="option 1">Option 1</option>
                    <option value="option 2">Option 2</option>
                    <option value="option 3">Option 3</option>
                    <option value="autre">Autre fournisseur</option>
                </select><br>
                <input id="autreFournisseur" name="fournisseur" type="text" placeholder="Autre Fournisseur"><br>
            </div>
            <div>
                 <h1 class="titre_data">Date de ramassage </h1><br>
                <input type="date" id="date" name="date"/><br>
            </div>
            <div>
                 <h1 class="titre_data">Affectation </h1>
                <input type="radio" id="E" name="affectation">
                <label for="E">Entier</label><br>
                <input type="radio" id="B+J" name="affectation">
                <label for="B+J">Blanc et Jaune</label>
            </div>
            <div>
                 <h1 class="titre_data">Nettoyage </h1>
                <input type="checkbox" name="nettoyage" id="cleaning">
                <input id="visa" type="password">
            </div>
            <button onclick="alert('Nouvelle Entree')" id="newEntry">Ajouter</button>
            <button onclick="alert('Entrees validees')" id="valider">Valider</button>
        </form>
    </section>
    <section>
        <table>
            <tr>
                <th>Heure</th>
                <th>Quantité</th>
                <th>Catégorie</th>
                <th>Fournisseur</th>
                <th>Date de ramassage</th>
                <th>Affectation</th>
                <th>Poids moyen par palette</th>
                <th>Nettoyage</th>
            </tr>
            <tr>
                <td>9h00</td>
                <td>6</td>
                <td>PAS</td>
                <td>Blanchard</td>
                <td>03/06/2020</td>
                <td>Entier</td>
                <td>860</td>
                <td>-</td>
            </tr>
            <tr>
                <td>13h00</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>A.S.</td>
            </tr>
        </table>
    </section>
    </body>
</html>
