<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>-->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="../css/style.css">
        <title>Suivi stockage en cuve tampon</title>
    </head>
    <body>
    <section>
        <h1>Suivi stockage en cuve tampon</h1>
        <nav>
            <button id="tampon">Suivi stockage en cuve tampon</button>
            <button id="pasto">Suivi pasteurisation</button>
        </nav>
        <form>
            <div>
                 <h1 class="titre_data">Produit </h1><br>
                <div class="affec">
                    <input type="radio" id="E" name="affec">
                    <label for="E">E (oeuf entier)</label><br>
                    <input type="radio" id="B+J" name="affec">
                    <label for="B+J">B + J (Blanc et Jaune)</label>
                </div>
                <div class="categ">
                    <input type="radio" id="BIO" name="categ">
                    <label for="BIO">BIO</label>
                    <input type="radio" id="PAS" name="categ">
                    <label for="PAS">PAS</label><br>
                    <input type="radio" id="PA" name="categ">
                    <label for="PA">PA</label>
                    <input type="radio" id="CAGE" name="categ">
                    <label for="CAGE">CAGE</label><br>
                </div>
            </div>
            <div>
                 <h1 class="titre_data">Horaires </h1>
                <label for="debut">Début</label>
                <input type="time" id="debut"><br>
                <label for="fin">Fin</label>
                <input type="time" id="fin">
            </div>
            <div>
                 <h1 class="titre_data">Lieu de standardisation avant pasteurisation </h1>
                <div>
                    <h3>Blanc</h3>
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
                    <h3>Jaune</h3>
                    <input type="radio" name="cuve2" id="cuve2A">
                    <label for="cuve2A">Cuve A</label>
                    <input type="radio" name="cuve2" id="cuve2B">
                    <label for="cuve2B">Cuve B</label>
                    <input type="radio" name="cuve2" id="cuve2C">
                    <label for="cuve2C">Cuve C</label>
                    <input type="radio" name="cuve2" id="cuve2D">
                    <label for="cuve2D">Cuve D</label>
                    <input type="radio" name="cuve2" id="container2">
                    <label for="container2">Container</label>
                </div>
            </div>
            <button onclick="alert('Nouvelle Entrée')" id="newEntry">Ajouter une nouvelle entrée</button>
            <button onclick="alert('Entrées validées')" id="valider">Valider</button>
        </form>
    </section>
    <section>
        <table>
            <tr>
                <th>Code produit stocke</th>
                <th>Heure debut</th>
                <th>Heure fin</th>
                <th>Lieu de standardisation</th>
            </tr>
            <tr>
                <td>E PAS</td>
                <td>10h20</td>
                <td>11h10</td>
                <td>Container</td>
            </tr>
            <tr>
                <td>J BIO</td>
                <td>13h30</td>
                <td>14h20</td>
                <td>Cuve A</td>
            </tr>
            <tr>
                <td>B BIO</td>
                <td>13h30</td>
                <td>14h20</td>
                <td>Cuve A</td>
            </tr>
        </table>
    </section>
    </body>
</html>
