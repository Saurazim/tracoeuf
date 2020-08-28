/** @author Benjamin LE GALL*/

var ct = 0;

function getEnfant(id){
    return document.getElementById(id);
}

/**
 * modifie l'index de la liste dans les éléments s'y référant
 * @param {Number} id 
 * @param {Element} item 
 */
function incIdNum(previousId, nextId, item){
    item.name = item.name.replace(previousId,nextId);
    item.classList.remove("list["+previousId+"]");
    item.classList.add("List["+nextId+"]");

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
 * ajoute des events listener aux boutons concernés
 * l'id détermine la ligne concernée
 * @param {Number} id
 */
function listenersAdding(id){
    var enfant = getEnfant(id)
    enfant.querySelector(".poids").addEventListener("input", function(){mathsTare(id)});
    enfant.querySelector(".tare").addEventListener("input", function(){mathsTare(id)});
    enfant.querySelector(".addFields").addEventListener("click",function(){addFields(id);});
    if(id!=0){
        enfant.querySelector(".delFields").addEventListener("click",function(){delIt(id);});
    }
}

/**
 * duplique une ligne du tableau formulaire
 * @param {Number} id numéro de la ligne dupliquée
 */
function addFields(id){
    ct++;

    var tr1 = document.createElement("tr");
    tr1.id=ct;

    tr1.innerHTML = document.getElementById(id).innerHTML;
    document.getElementById("formulaire").appendChild(tr1);
    var enfant = getEnfant(ct);
    enfant.querySelector("td").innerHTML = ct + "<input type=\"hidden\" name=\"list["+ct+"].idColumn\" value=\"" + ct + "\">";
    var listInput = enfant.querySelectorAll("[class~='list\["+id+"\]']");
    var listPrevious = document.getElementById(id).querySelectorAll("[class~='list\["+id+"\]']");
    for(i=0;i<listInput.length;i++){
        listInput[i].value = listPrevious[i].value;
        incIdNum(id, ct, listInput[i]);
    }
    listenersAdding(ct);
}

function mathsTare(id){
    var enfant = getEnfant(id);
    var poids = enfant.querySelector("input.poids").value;
    var tare = enfant.querySelector("input.tare").value;
    var net = enfant.querySelector("input.net");
    net.value = poids-tare>0 ? poids-tare : "#ERROR";
}