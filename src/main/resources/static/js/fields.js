/**
 * @author Benjamin Le Gall
 * @deprecated
 */

 /**
  * variable d'incrémentation
  * sert à définir l'id
  */
var ct = 0;

/**
 * affiche ou cache le champs autre fournisseur sous le select fournisseur
 * l'id détermine la ligne concernée
 * @param {Number} id 
 */
function toggleSelect(id){
    var enfant = getEnfant(id);
    var chpsText = enfant.getElementsByClassName("autre_fournisseur")[0];
    var option = enfant.getElementsByClassName("id_fournisseur")[0];
    if(option.value == 0){
        chpsText.classList.remove("hidden");
    } else {
        chpsText.classList.add("hidden");
    }

}

/**
 * affiche deux select ou un input number selon que la checkbox soit cochée ou non
 * l'id détermine la ligne concernée
 * @param {Number} id 
 */
function toggleCheck(id){

    var enfant = getEnfant(id);

    var nbAlve = enfant.getElementsByClassName("tare_nb_alveole")[0];
    var typePal = enfant.getElementsByClassName("tare_type_palette")[0];
    var inputTare = enfant.getElementsByClassName("nb_tare")[0];
    var hiddenTare = enfant.getElementsByClassName("check_tare hidden")[0];
    var tdTare = enfant.querySelector("td.tare");
    var labelCheck = tdTare.querySelector("label");
    var checkBox = enfant.getElementsByClassName("check_tare checkbox")[0]
    if (checkBox.checked == true) {
        nbAlve.classList.add("displayNone");
        typePal.classList.add("displayNone");
        tdTare.classList.add("grid", "twoRow");
        labelCheck.classList.add("secondRow");
        inputTare.classList.remove("displayNone");
        hiddenTare.disabled = true;
    } else {
        inputTare.classList.add("displayNone");
        labelCheck.classList.remove("secondRow");
        tdTare.classList.remove("grid", "twoRow");
        nbAlve.classList.remove("displayNone");
        typePal.classList.remove("displayNone");
        hiddenTare.disabled = false;
    }
}

/**
 * active ou désactive la colonne tare selon le type de poids
 * l'id détermine la ligne concernée
 * @param {Number} id 
 */
function toggleTare(id) {
    var enfant = getEnfant(id);

    var check = enfant.getElementsByClassName("typePoids checkbox")[0];
    var tableTare = enfant.getElementsByClassName("tare")[0];
    var hiddenCheck = enfant.getElementsByClassName("typePoids hidden")[0];
    if(check.checked==true){
        tableTare.classList.add("disableDiv");
        hiddenCheck.disabled = true;
    } else {
        tableTare.classList.remove("disableDiv");
        hiddenCheck.disabled = false;
    }
}

/**
 * récupère la ligne
 * @param {Number} id 
 * @returns {Element}
 */
function getEnfant(id){
    return document.getElementById(id);
}

/**
 * ajoute des events listener aux boutons concernés
 * l'id détermine la ligne concernée
 * @param {Number} id 
 */
function listenersAdding(id){
    var enfant = getEnfant(id)
    enfant.getElementsByClassName("id_fournisseur")[0].addEventListener("click",function(){toggleSelect(id);});
    enfant.getElementsByClassName("typePoids")[1].addEventListener("change",function(){toggleTare(id);});
    enfant.getElementsByClassName("check_tare")[1].addEventListener("change",function(){toggleCheck(id);});
    if(id!=0){
        enfant.getElementsByClassName("delIt")[0].addEventListener("click",function(){delIt(id);});
    }
}

/**
 * duplique une ligne du tableau formulaire
 */
function addFields() {
    ct++;

    var tr1 = document.createElement("tr");
    tr1.id = ct;

    tr1.innerHTML = document.getElementById("0").innerHTML;
    document.getElementById("formulaire").appendChild(tr1);
    var enfant = document.getElementById(ct)
    enfant.getElementsByTagName("td")[0].innerHTML = ct + "<input type=\"hidden\" name=\"list["+ct+"].idColumn\" value=\"" + ct + "\">";
    var listInput = enfant.querySelectorAll("[class~='list\[0\]']");
    for(let item of listInput){
        incIdNumber(ct, item);
    }
    init(ct);
}

/**
 * supprime la ligne
 * @param {Number} id 
 */
function delIt(id) {
    var ele = document.getElementById(id);
    var table = document.getElementById("formulaire");
    table.removeChild(ele);
}

/**
 * initialise la ligne
 * @param {Number} id 
 */
function init(id){
    toggleCheck(id);
    toggleSelect(id);
    toggleTare(id);
    listenersAdding(id);
}

/**
 * modifie l'index de la liste dans les éléments s'y référant
 * @param {Number} id 
 * @param {Element} item 
 */
function incIdNumber(id, item){
    item.name = item.name.replace("0",id);
    item.classList.remove("list[0]");
    item.classList.add("List["+id+"]");

}