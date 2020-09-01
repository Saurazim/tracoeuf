var xhr = new XMLHttpRequest;
var doc = encodeURIComponent(nomDoc);
xhr.open('GET','http://localhost:9091/tracoeuf/impression/'+doc);
// peut permettre de vérifier l'existence du fichier
//xhr.open('HEAD','http://localhost:9091/tracoeuf/impression/doc.docx');
xhr.send(null);

//cas méthode POST
xhr.open('POST', 'http://localhost:9091/tracoeuf/impression');
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.send('param1='+doc+'&param2='+"autre valeur");

xhr.addEventListener('readystatechange', function(){
    if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
        //....
    };
    //...
});

function impression(reference, date){
    var nom = reference+date;
    var xhr = new XMLHttpRequest();
    
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
}

(function(){
    var inputs = document.querySelector(".input"),
        inputsLen = inputs.length;
    

});