function impressionEtiquette(){
    var date = document.querySelector("input#date").value,
    fou = document.querySelector("select#fournisseurId"),
    fouText = fou.querySelector("option[value='"+fou.value+"']").innerHTML,
    cat = document.querySelector("select#categorieId"),
    catText = cat.querySelector("option[value='"+cat.value+"']").innerHTML,
    code,
    xhr = new XMLHttpRequest();

    fouText = setInCode(fouText);
    code = 'R'+fouText+catText;        

    //prep de la requete
    xhr.open('POST',chemin);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send('nomDoc='+nom);

    xhr.addEventListener('readystatechange', function(){
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
            alert("C'est fait!");
        }else if (xhr.readyState === XMLHttpRequest.DONE && xhr.status != 200){
            alert('Une erreur est survenue !\n\nCode :' + xhr.status + '\nTexte : ' + xhr.statusText);
        }
    });
    alert(xhr);
}

function setInCode(str){
    return str.substring(0, 3).toUpperCase()
}

function toggleSelect(){
    var chpsText = document.querySelector("#fournisseurAutre");
    var option = document.querySelector("#fournisseurId");
    if(option.value == 0){
        chpsText.classList.remove("hidden");
    } else {
        chpsText.classList.add("hidden");
    }
}