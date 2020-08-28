<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>-->

<!DOCTYPE html> 
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="../css/style.css">
        <title>Vente</title>
    </head>
    <body>
    <section>
        <h1>Sortie Bag in Box produits finis</h1>
        <form>
            <div>
                 <h1 class="titre_data">Date de vente </h1><br>
                <input type="date" id="date" name="date"/><br>
            </div>
            <div>
                 <h1 class="titre_data">Destinataire </h1>
                <input type="text" id="client">
            </div>
            <div>
                 <h1 class="titre_data">Numéro de lot </h1>
                <input type="text" id="lot">
            </div>
            <div>
                 <h1 class="titre_data">Produit </h1><br>
                <div>
                    <input type="radio" id="bio" name="produit">
                    <label for="bio">BIO</label><br>
                    <input type="radio" id="pa" name="produit">
                    <label for="pa">PA</label><br>
                    <input type="radio" id="pas" name="produit">
                    <label for="pas">PAS</label>
                    <input type="radio" id="cage" name="produit">
                    <label for="cage">CAGE</label>
                    <input type="radio" id="blancovo" name="produit">
                    <label for="blancovo">Blancovo</label>
                    <input type="radio" id="j11" name="produit">
                    <label for="j11">Jaunovo 11</label>
                    <input type="radio" id="j50" name="produit">
                    <label for="j50">Jaunovo 50</label>
                    <input type="radio" id="p_sucre" name="produit">
                    <label for="p_sucre">Sucre</label>
                    <input type="radio" id="surgele" name="produit">
                    <label for="surgele">Surgelé</label>
                </div>
                <div>
                    <input type="checkbox" id="declasse">
                    <label for="declasse">Decléssement</label>
                    <br>
                    <input type="radio" id="d_bio" name="produit">
                    <label for="d_bio">BIO</label><br>
                    <input type="radio" id="d_pa" name="produit">
                    <label for="d_pa">PA</label><br>
                    <input type="radio" id="d_pas" name="produit">
                    <label for="d_pas">PAS</label>
                    <input type="radio" id="d_cage" name="produit">
                    <label for="d_cage">CAGE</label>
                    <input type="radio" id="d_blancovo" name="produit">
                    <label for="d_blancovo">Blancovo</label>
                    <input type="radio" id="d_j11" name="produit">
                    <label for="d_j11">Jaunovo 11</label>
                    <input type="radio" id="d_j50" name="produit">
                    <label for="d_j50">Jaunovo 50</label>
                    <input type="radio" id="d_sucre" name="produit">
                    <label for="d_sucre">Sucre</label>
                    <input type="radio" id="d_surgele" name="produit">
                    <label for="d_surgele">Surgelé</label>
                </div>
            </div>
            <div>
                 <h1 class="titre_data">Quantité </h1>
                <h3>Entier</h3>
                <label for="e2">Outre 2kg</label>
                <input type="number" name="qte_vendu" id="e2">
                <label for="e5">Outre 5kg</label>
                <input type="number" name="qte_vendu" id="e5">
                <label for="e10">Outre 10kg</label>
                <input type="number" name="qte_vendu" id="e10">
                <h3>Jaune</h3>
                <label for="j2">Outre 2kg</label>
                <input type="number" name="qte_vendu" id="j2">
                <label for="j5">Outre 5kg</label>
                <input type="number" name="qte_vendu" id="j5">
                <label for="j10">Outre 10kg</label>
                <input type="number" name="qte_vendu" id="j10">
                <h3>Blanc</h3>
                <label for="b2">Outre 2kg</label>
                <input type="number" name="qte_vendu" id="b2">
                <label for="b5">Outre 5kg</label>
                <input type="number" name="qte_vendu" id="b5">
                <label for="b10">Outre 10kg</label>
                <input type="number" name="qte_vendu" id="b10">
            </div>
            <div>
                <label for="visa">Visa</label>
                <input type="password" name="visa" id="visa">
                <button onclick="alert('Entrées validées')" id="valider">Valider</button>
            </div>
        </form>
    </section>
    <section>
        <table>
            <tr>
                <th>Date de vente</th>
                <th>Destinataire</th>
                <th>N° lot</th>
                <th>Produit</th>
                <th>Entier 2</th>
                <th>Entier 5</th>
                <th>Entier 10</th>
                <th>Jaune 2</th>
                <th>Jaune 5</th>
                <th>Jaune 10</th>
                <th>Blanc 2</th>
                <th>Blanc 5</th>
                <th>Blanc 10</th>
            </tr>
            <tr>
                <td>31/12/19</td>
                <td>Heinaff</td>
                <td>19360</td>
                <td>CAGE</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>70</td>
            </tr>
        </table>
    </section>
    </body>
</html>
