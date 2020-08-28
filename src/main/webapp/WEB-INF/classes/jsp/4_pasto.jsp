<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>-->
<!DOCTYPE html> 
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="../css/style.css">
        <title>Suivi Pasteurisation</title>
    </head>
    <body>
    <section>
        <h1>Suivi Pasteurisation</h1>
        <nav>
            <button id="tampon">Suivi stockage ne cuve tampon</button>
            <button id="pasto">Suivi pasteurisation</button>
        </nav>
        <form>
            <div>
                 <h1 class="titre_data">Date </h1><br>
                <input type="date" id="date" name="date"/><br>
            </div>
            <div>
                 <h1 class="titre_data">Numéro de lot </h1>
                <input type="text" id="lot">
            </div>
            <div>
                 <h1 class="titre_data">Heure de début </h1>
                <label for="heure">Début</label>
                <input type="time" id="heure"><br>
            </div>
            <div>
                 <h1 class="titre_data">Produit </h1><br>
                <input type="radio" id="E" name="affec">
                <label for="E">E (oeuf entier)</label><br>
                <input type="radio" id="B" name="affec">
                <label for="B">B (blanc d'oeuf)</label><br>
                <input type="radio" id="J" name="affec">
                <label for="J">J (jaune d'oeuf)</label>
            </div>
            <div>
                <input type="button" value="+" id="add_recycl" name="add_recycl">
                <label for="add_recycl">Recyclage</label>
                <div>
                    <input type="text" name="recycl" id="lot_recyl">
                    <input type="number" name="recycl" id="qte_recycl">
                     <h1 class="titre_data">Origine </h1>
                    <input type="radio" name="orig_recycl" id="intern">
                    <label for="intern">Interne</label>
                    <input type="radio" name="orig_recycl" id="extern">
                    <label for="extern">Externe</label>
                </div>
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
                 <h1 class="titre_data">Conditionnement </h1>
                <input type="checkbox" name="conditionnement" id="container">
                <label for="container">Container</label>
                <h3>Bag</h3>
                <input type="checkbox" name="conditionnement" id="bag2">
                <label for="bag2">2 kg</label>
                <input type="checkbox" name="conditionnement" id="bag5">
                <label for="bag5">5 kg</label>
                <input type="checkbox" name="conditionnement" id="bag10">
                <label for="bag10">10 kg</label>
                <h3>BIC</h3>
                <input type="checkbox" name="conditionnement" id="bic500">
                <label for="bic500">500 kg</label>
                <input type="checkbox" name="conditionnement" id="bic1k">
                <label for="bic1k">1000 kg</label>
            </div>
            <div>
                 <h1 class="titre_data">Quantité produite </h1>
                <input type="number" name="qte_produite" id="qte_container"><br>
                <input type="number" name="qte_produite" id="qte_bag2">
                <input type="number" name="qte_produite" id="qte_bag5">
                <input type="number" name="qte_produite" id="qte_bag10"><br>
                <input type="number" name="qte_produite" id="qte_bic5000">
                <input type="number" name="qte_produite" id="qte_bic1k">
            </div>
            <div>
                 <h1 class="titre_data">Client </h1>
                <input type="text" name="client" id="client_container"><br>
                <input type="text" name="client" id="client_bic500">
                <input type="text" name="client" id="client_bic1k">
            </div>
            <div>
                 <h1 class="titre_data">Lots d'additif </h1>
                <input type="radio" name="additif" id="sucre">
                <label for="sucre">Sucre</label>
                <input type="radio" name="additif" id="s_bio">
                <label for="s_bio">Sucre BIO</label>
                <input type="radio" name="additif" id="sel">
                <label for="sel">Sel</label>
                <input type="radio" name="additif" id="ib">
                <label for="ib">Idealblend</label>
                <input type="text" name="lot_additif" id="lot_additif">
            </div>
            <div>
                 <h1 class="titre_data">Température témoin </h1>
                <input type="text" name="temp" id="temp" placeholder="T (°C)">
                <input type="time" name="temp" id="temp_time">
            </div>
            <button onclick="alert('Produit Blancovo')" id="blancovo">Blancovo</button>
            <button onclick="alert('Produit Jaunovo')" id="jaunovo">Jaunovo</button>
            <button onclick="alert('Lavage')" id="lavage">Lavage</button>
            <button onclick="alert('Entrees validees')" id="valider">Valider</button>
        </form>
    </section>
    <section>
        <table>
            <tr>
                <th>Code produit stocke</th>
                <th>Heure début</th>
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
